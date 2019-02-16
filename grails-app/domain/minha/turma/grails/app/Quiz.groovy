package minha.turma.grails.app

class Quiz {

    String statement
    Subject subject
    String topic
    List alternatives
    String correct
    User owner
    Boolean isOpen = false

    static constraints = {
        statement (blank: false)
        alternatives (blank: false)
        correct (blank: false)
        owner (blank: false)
    }

    static hasMany = [alternatives: String]
}
