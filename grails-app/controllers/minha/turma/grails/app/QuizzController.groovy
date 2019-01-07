package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class QuizzController {

    QuizzService quizzService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        render quizzService.list() as JSON
    }

    def show(Long id) {
        render quizzService.get(id) as JSON
    }

    def save(Quizz quizz) {
        if (quizz == null) {
            render status: NOT_FOUND
            return
        }

        try {
            quizzService.save(quizz)
        } catch (ValidationException e) {
            respond quizz.errors, view:'create'
            return
        }

        render quizz as JSON
    }

    def update(Quizz quizz) {
        if (quizz == null) {
            render status: NOT_FOUND
            return
        }

        try {
            quizzService.save(quizz)
        } catch (ValidationException e) {
            respond quizz.errors, view:'edit'
            return
        }

        render quizz as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        quizzService.delete(id)

        render status: NO_CONTENT
    }
}
