package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class LectureController {

    LectureService lectureService
    UserService userService
    PresenceService presenceService

    def springSecurityService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        User user = springSecurityService.currentUser

        if (userService.isProfessor()) {
            render Lecture.findAllByOwner(user) as JSON
            return
        }

        render Lecture.findAllBySchoolClass(((Student)user).schoolClass) as JSON
    }

    def show(Long id) {
        render lectureService.get(id) as JSON
    }

    def save(Lecture lecture) {
        if (lecture == null) {
            render status: NOT_FOUND
            return
        }

        User owner = springSecurityService.currentUser
        lecture.owner = owner
        lecture.date = new Date()

        try {
            lectureService.save(lecture)
        } catch (ValidationException e) {
            render lecture.errors
            return
        }

        render lecture  as JSON
    }

    def update(Lecture lecture) {
        if (lecture == null) {
            render status: NOT_FOUND
            return
        }

        try {
            lectureService.save(lecture)
        } catch (ValidationException e) {
            render lecture.errors, view:'edit'
            return
        }

        render lecture as JSON
    }

    def presence(Long id) {
        Lecture lecture = Lecture.get(id)
        render Presence.findAllByLecture(lecture) as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        lectureService.delete(id)

        render status: NO_CONTENT
    }
}
