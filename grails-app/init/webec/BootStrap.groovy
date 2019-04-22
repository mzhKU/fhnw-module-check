package webec

import webec.Module
import webec.Professor

class BootStrap {

    def init = { servletContext ->

        // Guard clause: prevent bootstrap objects in production
        // if(Environment.current == Environment.PRODUCTION) return;

        Professor p1 = new Professor(name: "Tom").save(flush:true, failOnError:true)
        Professor p2 = new Professor(name: "Tim").save(flush:true, failOnError:true)

        Module m1 = new Module(title: p1, professor: "mod 1", votes: null)
        Module m2 = new Module(title: p1, professor: "mod 2", votes: null)

    }
    def destroy = {
    }
}
