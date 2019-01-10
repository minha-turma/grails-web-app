package minha.turma.grails.app

class SchoolClass {

    String name

    static constraints = {
        name (blank: false, unique: true)
    }

    static hasMany = [users: User]
}
