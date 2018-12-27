package minha.turma.grails.app

import grails.gorm.services.Service

@Service(SchoolClass)
interface SchoolClassService {

    SchoolClass get(Serializable id)

    List<SchoolClass> list(Map args)

    Long count()

    void delete(Serializable id)

    SchoolClass save(SchoolClass schoolClass)

}