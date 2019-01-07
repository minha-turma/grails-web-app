package minha.turma.grails.app

import grails.converters.JSON

class BootStrap {

    ProfessorService professorService

    def init = { servletContext ->

        def userRole = new Role('ROLE_USER').save()
        def adminRole = new Role('ROLE_ADMIN').save()

        def me = new User(username: 'user1', password: '1234', authorities: [userRole]).save()
        def admin = new User(username: 'admin', password: 'admin', authorities: [adminRole]).save()

        UserRole.create me, userRole
        UserRole.create admin, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        Quiz quiz = new Quiz(statement: "Quem descobriu o Brasil", alternatives: ["Pedro", "Aecia", "Lula", "Dilma"], correct: 0, owner: me)
        quiz.save()

    }
    def destroy = {
    }
}
