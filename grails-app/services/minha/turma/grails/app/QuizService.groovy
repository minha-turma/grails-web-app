package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Quiz)
interface QuizService {

    Quiz get(Serializable id)

    List<Quiz> list(Map args)

    Long count()

    void delete(Serializable id)

    Quiz save(Quiz quiz)

}