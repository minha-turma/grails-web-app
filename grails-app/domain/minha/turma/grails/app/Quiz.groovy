package minha.turma.grails.app

class Quiz {

    String statement
    List alternatives
    String correct
    User owner

    static constraints = {
        statement (blank: false)
        alternatives (blank: false)
        correct (blank: false)
        owner (blank: false)
    }

    static hasMany = [alternatives: String]
}
