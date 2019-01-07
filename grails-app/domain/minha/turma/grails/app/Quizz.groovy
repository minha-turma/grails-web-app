package minha.turma.grails.app

class Quizz {

    String statement
    List alternatives
    int correct

    static constraints = {
        statement (blank: false)
        alternatives (blank: false)
        correct (blank: false)
    }

    static hasMany = [alternatives: String]
}
