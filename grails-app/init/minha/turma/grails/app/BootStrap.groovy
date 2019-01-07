package minha.turma.grails.app

import grails.converters.JSON

class BootStrap {

    ProfessorService professorService

    def init = { servletContext ->

        JSON.registerObjectMarshaller(Professor.Role) { Professor.Role role ->
            role.toString()
        }

        Professor admin = new Professor(
                name: "Tulio de Souza", registration: "08143152405", password: "1234", role: Professor.Role.ADMIN)

        professorService.save(admin)

        def userRole = new Role('ROLE_USER').save()

        def me = new User(username: 'user1', password: '1234', authorities: [userRole]).save()

        UserRole.create me, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        Quizz quizz = new Quizz(statement: "Quem descobriu o Brasil", alternatives: ["Pedro", "Aecia", "Lula", "Dilma"], correct: 0)
        quizz.save()

    }
    def destroy = {
    }
}
