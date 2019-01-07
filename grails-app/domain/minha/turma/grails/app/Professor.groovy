package minha.turma.grails.app

class Professor {

    enum Role {
        ADMIN,
        PROFESSOR
    }

    String name
    String registration
    String password
    Role role

    static constraints = {
        name (blank: false, minSize: 2, maxSize: 255)
        registration (blank: false, unique: true)
        password (blank: false)
        role (blank: false)
    }
}
