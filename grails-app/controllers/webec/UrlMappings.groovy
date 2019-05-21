package webec

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        // "/"(view:"/index")
        "/"(         controller: "app")
        "/module"(   controller: "module")
        "/professor"(controller: "professor")
        "/rating"(   controller: "rating")
        "/teaching"( controller: "teaching")
        "/teaching/edit"(view: "teaching/edit")
        "/about"(    view:       "/description")
        "500"(       view:       '/error')
        "404"(       view:       '/notFound')
    }
}
