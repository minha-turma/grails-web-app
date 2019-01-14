package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Presence)
abstract class PresenceService {

    abstract Presence get(Serializable id)

    abstract List<Presence> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Presence save(Presence presence)

}