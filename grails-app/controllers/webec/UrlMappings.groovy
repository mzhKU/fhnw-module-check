package webec

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // "/"(view:"/index")
        "/"(controller: "app")
        "/about"(view: "/description")
        "/module"(controller: "module")
        "/professor"(controller: "professor")
        "/rating"(controller: "rating")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
