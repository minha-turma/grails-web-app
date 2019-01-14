package minha.turma.grails.app

class Presence {

    Student student
    Lecture lecture

    static constraints = {
        student (unique: ['lecture'])
        student (nullable: false)
        lecture (nullable: false)
    }
}
