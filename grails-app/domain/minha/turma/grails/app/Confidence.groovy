package minha.turma.grails.app

class Confidence {

    enum Status {
        Confident('Confident'), Confused('Confused'), Unsecure('Unsecure')

        String name
        Status (String name) {
            this.name = name
        }
    }

    Status status
    Student student
    Subject subject
    String topic

    static constraints = {
        status (nullable: false)
        student (nullable: false)
        subject (nullable: false, unique: ['student'])
        topic(nullable: false)
    }
}
