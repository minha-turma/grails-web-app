package minha.turma.grails.app

class Subject {

    String name
    
    static hasMany = [topics:String]

    static constraints = {
        name unique: true
    }
}
