package minha.turma.grails.app

class UrlMappings {

    static mappings = {
        delete  "/api/$controller/$id(.$format)?"(action:"delete")
        get     "/api/$controller    (.$format)?"(action:"index")
        get     "/api/$controller/$id(.$format)?"(action:"show")
        post    "/api/$controller    (.$format)?"(action:"save")
        put     "/api/$controller/$id(.$format)?"(action:"update")
        patch   "/api/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'root', action:'index')
        "500"(view: '/error')
        "404"(controller: 'root', action:'index')

        /* STUDENT API */
        group "/api/user", {
            "/student"(controller:"User", id:"student", action: "student")
        }
    }

    static excludes = [
        '/css/*',
        '/fonts/*',
        '/static/*',
        '/asset-manifest.json',
        '/favicon.ico'
    ]

}
