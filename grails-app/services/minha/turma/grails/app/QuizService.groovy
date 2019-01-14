package minha.turma.grails.app

import grails.gorm.services.Service

@Service(Quiz)
abstract class QuizService {

    abstract Quiz get(Serializable id)

    abstract List<Quiz> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Quiz save(Quiz quiz)

    int countByOwner(User owner) {
        Quiz.countByOwner(owner)
    }

}