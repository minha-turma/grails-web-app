package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Answer)
abstract class AnswerService {

    abstract Answer get(Serializable id)

    abstract List<Answer> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Answer save(Answer answer)

}