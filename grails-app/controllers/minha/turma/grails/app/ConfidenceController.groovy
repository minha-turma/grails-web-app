package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class ConfidenceController {

    ConfidenceService confidenceService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        render confidenceService.list() as JSON
    }

    def show(Long id) {
        render confidenceService.get(id) as JSON
    }

    def save(Confidence confidence) {
        if (confidence == null) {
            render status: NOT_FOUND
            return
        }

        try {
            confidenceService.save(confidence)
        } catch (ValidationException e) {
            render confidence.errors
            return
        }

        render confidence  as JSON
    }

    def update(Confidence confidence) {
        if (confidence == null) {
            render status: NOT_FOUND
            return
        }

        try {
            confidenceService.save(confidence)
        } catch (ValidationException e) {
            render confidence.errors, view:'edit'
            return
        }

        render confidence as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        confidenceService.delete(id)

        render status: NO_CONTENT
    }
}
