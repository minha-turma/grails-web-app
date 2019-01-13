package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

class LectureController {

    LectureService lectureService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render lectureService.list(params) as JSON
    }

    def show(Long id) {
        render lectureService.get(id) as JSON
    }

    def save(Lecture lecture) {
        if (lecture == null) {
            render status: NOT_FOUND
            return
        }

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

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        lectureService.delete(id)

        render status: NO_CONTENT
    }
}
