package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProfessorController {

    ProfessorService professorService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
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
}
