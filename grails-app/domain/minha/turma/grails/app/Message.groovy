package minha.turma.grails.app

class Message {

    String subject
    String content
    User owner
    SchoolClass schoolClass

    static constraints = {
        subject blank: false
        content blank: false
        owner nullable: false
        schoolClass nullable: false
    }
}
