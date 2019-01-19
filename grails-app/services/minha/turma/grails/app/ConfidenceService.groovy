package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Confidence)
abstract class ConfidenceService {

    abstract Confidence get(Serializable id)

    abstract List<Confidence> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Confidence save(Confidence confidence)

}