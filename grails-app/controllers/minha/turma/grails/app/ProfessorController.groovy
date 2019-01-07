package minha.turma.grails.app

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.util.Holders
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
class ProfessorController {

    ProfessorService professorService
    SpringSecurityService springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", login: "POST"]

    def index(Integer max) {

        springSecurityService = Holders.applicationContext.getBean('springSecurityService')
        User user = springSecurityService.currentUser

        params.max = Math.min(max ?: 10, 100)
        render professorService.list(params) as JSON
    }

    def show(Long id) {
        render professorService.get(id) as JSON
    }

    def save(Professor professor) {
        if (professor == null) {
            render status: NOT_FOUND
            return
        }

        try {
            professorService.save(professor)
        } catch (ValidationException e) {
            render professor.errors, view:'create'
            return
        }

        render professor as JSON
    }

    def update(Professor professor) {
        if (professor == null) {
            render status: NOT_FOUND
            return
        }

        try {
            professorService.save(professor)
        } catch (ValidationException e) {
            render professor.errors, view:'edit'
            return
        }

        render professor as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        professorService.delete(id)

        render status: NO_CONTENT
    }

    def login() {
        String registration = request.JSON["registration"]
        String password = request.JSON["password"]

        Professor professor = Professor.findByRegistration(registration)

        if (professor && professor.password == password) {
            render professor as JSON
        } else {
            render status: FORBIDDEN
        }
    }
}
