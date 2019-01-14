package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SchoolClassController {

    SchoolClassService schoolClassService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        render schoolClassService.list() as JSON
    }

    def show(Long id) {
        render schoolClassService.get(id) as JSON
    }

    def save(SchoolClass schoolClass) {
        if (schoolClass == null) {
            render status: NOT_FOUND
            return
        }

        try {
            schoolClassService.save(schoolClass)
        } catch (ValidationException e) {
            render schoolClass.errors, view:'create'
            return
        }

        render schoolClass  as JSON
    }

    def count() {
        render schoolClassService.count()
    }

    def update(SchoolClass schoolClass) {
        if (schoolClass == null) {
            render status: NOT_FOUND
            return
        }

        try {
            schoolClassService.save(schoolClass)
        } catch (ValidationException e) {
            render schoolClass.errors, view:'edit'
            return
        }

        render schoolClass as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        schoolClassService.delete(id)

        render status: NO_CONTENT
    }
}
