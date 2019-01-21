package minha.turma.grails.app

class Subject {

    String name

    static constraints = {
        name unique: true
    }
}
