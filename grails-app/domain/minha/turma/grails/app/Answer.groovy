package minha.turma.grails.app

class Answer {

    Quiz quiz
    Student student
    String choice

    static constraints = {
        quiz unique: ['student'], nullable: false
        student nullable: false
    }
}
