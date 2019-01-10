package minha.turma.grails.app

import grails.converters.JSON
import grails.validation.ValidationException
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*

class UserController {

    UserService userService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render userService.list(params) as JSON
    }

    def show(Long id) {
        render userService.get(id) as JSON
    }

    /*
    * This action is designed to handle single and bulk inserts.
    * If a single object is sent through the body, than a single insert is performed.
    * Otherwise, if an array of object is sent, than a bulk insert of the items is performed.
    * */
    def save() {
        if (request.JSON instanceof JSONObject) {
            User student = new User(request.JSON)

            if (!student.validate()) {
                render (status: BAD_REQUEST, text: student.errors)
            }

            userService.save(student)

            render(text: student, contentType: "application/json", status: CREATED)
        }
        else if (request.JSON instanceof JSONArray) {

            List<User> students = []

            request.JSON.each {
                User student = new User(it)

                if (!student.validate()) {
                    render (status: BAD_REQUEST, text: student.errors)
                }

                students.add(student)
            }

            userService.save(students)
            render(text: students as JSON, contentType: "application/json", status: CREATED)
        }
    }

    def update(User student) {
        if (student == null) {
            render status: NOT_FOUND
            return
        }

        try {
            userService.save(student)
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

        userService.delete(id)

        render status: NO_CONTENT
    }
}
