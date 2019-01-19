package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Message)
abstract class MessageService {

    abstract Message get(Serializable id)

    abstract List<Message> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Message save(Message message)

}