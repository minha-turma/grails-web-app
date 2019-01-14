package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class QuizController {

    QuizService quizService
    def springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        User owner = springSecurityService.currentUser
        render Quiz.findAllByOwner(owner) as JSON
    }

    def show(Long id) {
        render quizService.get(id) as JSON
    }

    def save(Quiz quiz) {
        if (quiz == null) {
            render status: NOT_FOUND
            return
        }

        User owner = springSecurityService.currentUser
        quiz.owner = owner;

        try {
            quizService.save(quiz)
        } catch (ValidationException e) {
            respond quiz.errors, view:'create'
            return
        }

        render quiz as JSON
    }

    def count() {
        User owner = springSecurityService.currentUser
        render quizService.countByOwner(owner)
    }

    def update(Quiz quiz) {
        if (quiz == null) {
            render status: NOT_FOUND
            return
        }

        try {
            quizService.save(quiz)
        } catch (ValidationException e) {
            respond quiz.errors, view:'edit'
            return
        }

        render quiz as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        quizService.delete(id)

        render status: NO_CONTENT
    }
}
