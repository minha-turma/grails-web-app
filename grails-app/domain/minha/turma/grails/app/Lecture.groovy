package minha.turma.grails.app

class Lecture {

    Date date
    Subject subject
    String topic
    SchoolClass schoolClass
    User owner
    boolean isOpen = false

    static constraints = {
        schoolClass (unique: ['date', 'subject', 'owner'])
    }

    static hasMany = [presences: Presence]
}
