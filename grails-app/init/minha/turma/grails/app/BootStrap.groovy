package minha.turma.grails.app

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->

        JSON.registerObjectMarshaller(User) {
            def output = [:]
            output['id'] = it.id
            output['name'] = it.name
            output['username'] = it.username
            output['schoolClass'] = ["id": it?.schoolClass?.id, "name": it?.schoolClass?.name]

            return output
        }

        // Create application roles
        Role adminRole = new Role('ROLE_ADMIN').save()
        Role professorRole = new Role('ROLE_PROFESSOR').save()
        Role studentRole = new Role('ROLE_STUDENT').save()

        SchoolClass schoolClass = new SchoolClass(name: "My class").save()

        // Create test users
        User admin = new User(name: 'Admin', username: 'admin', password: 'admin', authorities: [adminRole]).save()
        User professor = new User(name: 'Professor', username: 'professor', password: 'professor', schoolClass: schoolClass, authorities: [professorRole]).save()
        User student = new User(name: 'Student', username: 'student', password: 'student', schoolClass: schoolClass, authorities: [studentRole]).save()

        // Associate users to roles
        new UserRole(user: admin, role: adminRole).save()
        new UserRole(user: professor, role: professorRole).save()
        new UserRole(user: student, role: studentRole).save()

        new Quiz(statement: "Quem descobriu o Brasil", alternatives: ["Pedro", "Aecia", "Lula", "Dilma"], correct: 0, owner: admin).save()
        new Quiz(statement: "Quem é o atual presidente do Brasil?", alternatives: ["Dilma", "Aecio", "Bolsonaro", "Lula"], correct: 0, owner: admin).save()
        new Quiz(statement: "1+1?", alternatives: ["1", "2", "3", "4"], correct: 0, owner: admin).save()
        new Quiz(statement: "Qual a cor do céu?", alternatives: ["Azul", "Amarelo", "Vermelho", "Laranja"], correct: 0, owner: admin).save()
        new Quiz(statement: "Coletivo de abelha", alternatives: ["Enxame", "Alcateia", "Gado", "Cardume"], correct: 0, owner: admin).save()

    }
    def destroy = {
    }
}
