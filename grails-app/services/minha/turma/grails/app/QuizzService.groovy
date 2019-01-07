package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Quizz)
interface QuizzService {

    Quizz get(Serializable id)

    List<Quizz> list(Map args)

    Long count()

    void delete(Serializable id)

    Quizz save(Quizz quizz)

}