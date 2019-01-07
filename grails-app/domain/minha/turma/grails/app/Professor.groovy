package minha.turma.grails.app

class Professor {

    String name
    String registration
    String password

    static constraints = {
        name (blank: false, minSize: 2, maxSize: 255)
        registration (blank: false, unique: true)
        password (blank: false)
    }
}
