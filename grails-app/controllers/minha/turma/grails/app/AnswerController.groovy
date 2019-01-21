package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class AnswerController {

    AnswerService answerService
    UserService userService

    def springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        User user = springSecurityService.currentUser

        if (userService.isProfessor()) {
            render Answer.list() as JSON
            return
        }

        render Answer.findAllByStudent(((Student)user)) as JSON
    }

    def show(Long id) {
        render answerService.get(id) as JSON
    }

    def save(Answer answer) {
        if (answer == null) {
            render status: NOT_FOUND
            return
        }

        try {
            answerService.save(answer)
        } catch (ValidationException e) {
            render answer.errors
            return
        }

        render answer  as JSON
    }

    def update(Answer answer) {
        if (answer == null) {
            render status: NOT_FOUND
            return
        }

        try {
            answerService.save(answer)
        } catch (ValidationException e) {
            render answer.errors, view:'edit'
            return
        }

        render answer as JSON
    }

    def presence(Long id) {
        Answer answer = Answer.get(id)
        render Presence.findAllByLecture(answer) as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        answerService.delete(id)

        render status: NO_CONTENT
    }
}
