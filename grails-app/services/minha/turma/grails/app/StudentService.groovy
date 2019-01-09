package minha.turma.grails.app

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Student)
abstract class StudentService {

    abstract Student get(Serializable id)

    abstract List<Student> list(Map args)

    abstract Long count()

    @Transactional
    abstract void delete(Serializable id)

    @Transactional
    abstract Student save(Student student)

    @Transactional
    List<Student> save(List<Student> students) {
        students.each {
            it.save()
        }
    }

}