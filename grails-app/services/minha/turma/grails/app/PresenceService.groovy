package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Presence)
abstract class PresenceService {

    LectureService lectureService
    UserService userService

    abstract Presence get(Serializable id)

    abstract List<Presence> list(Map args)

    abstract Long count()

    double average() {
        List<Student> students = userService.listStudents()
        return students.size()
    }

    abstract void delete(Serializable id)

    abstract Presence save(Presence presence)

}