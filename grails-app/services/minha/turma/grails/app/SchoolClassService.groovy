package minha.turma.grails.app

import grails.gorm.services.Service

@Service(SchoolClass)
abstract class SchoolClassService {

    abstract SchoolClass get(Serializable id)

    abstract List<SchoolClass> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract SchoolClass save(SchoolClass schoolClass)

}