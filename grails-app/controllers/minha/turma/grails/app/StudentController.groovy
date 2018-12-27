package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StudentController {

    StudentService studentService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render studentService.list(params) as JSON
    }

    def show(Long id) {
        render studentService.get(id) as JSON
    }

    def save(Student student) {
        if (student == null) {
            render status: NOT_FOUND
            return
        }

        try {
            studentService.save(student)
        } catch (ValidationException e) {
            render student.errors, view:'create'
            return
        }

        render student as JSON
    }

    def update(Student student) {
        if (student == null) {
            render status: NOT_FOUND
            return
        }

        try {
            studentService.save(student)
        } catch (ValidationException e) {
            render student.errors, view:'edit'
            return
        }

        render student as JSON
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        studentService.delete(id)

        render status: NO_CONTENT
    }
}
