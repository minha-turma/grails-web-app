package minha.turma.grails.app

class Answer {

    Quiz quiz
    Student student
    int choice

    static constraints = {
        quiz unique: ['student'], nullable: false
        student nullable: false
    }
}
