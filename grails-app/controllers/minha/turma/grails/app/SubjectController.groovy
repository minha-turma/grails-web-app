package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class SubjectController {

    SubjectService subjectService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render subjectService.list(params) as JSON
    }

    def show(Long id) {
        render subjectService.get(id) as JSON
    }

    def save(Subject subject) {
        if (subject == null) {
            render status: NOT_FOUND
            return
        }

        try {
            subjectService.save(subject)
        } catch (ValidationException e) {
            render subject.errors
            return
        }

        render subject  as JSON
    }

    def update(Subject subject) {
        if (subject == null) {
            render status: NOT_FOUND
            return
        }

        try {
            subjectService.save(subject)
        } catch (ValidationException e) {
            render subject.errors, view:'edit'
            return
        }

        render subject as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        subjectService.delete(id)

        render status: NO_CONTENT
    }
}
