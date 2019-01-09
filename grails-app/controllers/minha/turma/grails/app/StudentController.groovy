package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

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

    /*
    * This action is designed to handle single and bulk inserts.
    * If a single object is sent through the body, than a single insert is performed.
    * Otherwise, if an array of object is sent, than a bulk insert of the items is performed.
    * */
    def save() {
        if (request.JSON instanceof JSONObject) {
            Student student = new Student(request.JSON)

            if (!student.validate()) {
                render (status: BAD_REQUEST, text: student.errors)
            }

            studentService.save(student)

            render(text: student, contentType: "application/json", status: CREATED)
        }
        else if (request.JSON instanceof JSONArray) {

            List<Student> students = []

            request.JSON.each {
                Student student = new Student(it)

                if (!student.validate()) {
                    render (status: BAD_REQUEST, text: student.errors)
                }

                students.add(student)
            }

            studentService.save(students)
            render(text: students as JSON, contentType: "application/json", status: CREATED)
        }
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
