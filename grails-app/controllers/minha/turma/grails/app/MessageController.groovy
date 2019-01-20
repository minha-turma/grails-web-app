package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class MessageController {

    MessageService messageService
    def springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        User owner = springSecurityService.currentUser
        render Message.findAllByOwner(owner) as JSON
    }

    def show(Long id) {
        render messageService.get(id) as JSON
    }

    def save(Message message) {
        if (message == null) {
            render status: NOT_FOUND
            return
        }

        User owner = springSecurityService.currentUser
        message.owner = owner
        message.date = new Date()

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            render message.errors
            return
        }

        render message  as JSON
    }

    def update(Message message) {
        if (message == null) {
            render status: NOT_FOUND
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            render message.errors, view:'edit'
            return
        }

        render message as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        messageService.delete(id)

        render status: NO_CONTENT
    }
}
