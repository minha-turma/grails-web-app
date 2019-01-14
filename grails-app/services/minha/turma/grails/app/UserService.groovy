package minha.turma.grails.app

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(User)
abstract class UserService {

    def sessionFactory

    PresenceService presenceService

    abstract User get(Serializable id)

    abstract List<User> list(Map args)

    List<Student> listStudents() {

        List<Student> students = Student.list()

        students.each {
            List<Lecture> lectures = Lecture.findAllBySchoolClass(it.schoolClass)
            if (lectures.size() > 0) {
                List<Presence> presences = Presence.findAllByStudentAndLectureInList(it, lectures)
                it.presence = presences.isEmpty() ? 0 : (presences.size() / lectures.size()) * 100
            }

        }

        return students
    }

    abstract Long count()

    Long countStudents() {
        return Student.count()
    }

    @Transactional
    abstract void delete(Serializable id)

    @Transactional
    abstract User save(User student)

    @Transactional
    List<User> save(List<User> students) {

        Map schoolClassMap = [:]

        students.each {

            SchoolClass schoolClass = schoolClassMap[it.schoolClass.name]
            if (schoolClass == null) {
                schoolClass = SchoolClass.findByName(it.schoolClass.name)
                if (schoolClass == null) {
                    schoolClass = it.schoolClass.save()
                }
                schoolClassMap[it.schoolClass.name] = schoolClass
            }

            it.schoolClass = schoolClass
            it.save()

            it.roles.each { role ->
                UserRole.create(it, role).save()
            }
        }
    }

}