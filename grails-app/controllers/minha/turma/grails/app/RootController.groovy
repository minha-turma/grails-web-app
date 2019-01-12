package minha.turma.grails.app

class RootController {
    def index() {
        redirect(uri: "/index.html")
    }
}