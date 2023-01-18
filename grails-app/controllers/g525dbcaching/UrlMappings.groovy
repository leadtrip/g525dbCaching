package g525dbcaching

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "car")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}