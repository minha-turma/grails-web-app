package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Subject)
abstract class SubjectService {

    abstract Subject get(Serializable id)

    abstract List<Subject> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Subject save(Subject schoolClass)

}