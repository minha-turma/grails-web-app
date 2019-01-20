package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class PresenceController {

    PresenceService presenceService
    UserService userService

    def springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {

        User user = springSecurityService.currentUser

        if (userService.isProfessor()) {
            render Presence.list() as JSON
            return
        }

        render Presence.findAllByStudent(((Student) user)) as JSON
    }

    def show(Long id) {
        render presenceService.get(id) as JSON
    }

    def save(Presence presence) {
        if (presence == null) {
            render status: NOT_FOUND
            return
        }

        try {
            presenceService.save(presence)
        } catch (ValidationException e) {
            render presence.errors
            return
        }

        render presence  as JSON
    }

    def update(Presence presence) {
        if (presence == null) {
            render status: NOT_FOUND
            return
        }

        try {
            presenceService.save(presence)
        } catch (ValidationException e) {
            render presence.errors, view:'edit'
            return
        }

        render presence as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        presenceService.delete(id)

        render status: NO_CONTENT
    }

    def average() {
        render presenceService.average()
    }
}
