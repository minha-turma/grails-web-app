package minha.turma.grails.app

class Lecture {

    Date date
    Subject subject
    SchoolClass schoolClass

    static constraints = {
        schoolClass (unique: ['date', 'subject'])
    }

    static hasMany = [presences: Presence]
}
