package webec

import mvc.Module
import mvc.Professor

class BootStrap {

    def init = { servletContext ->

        // Guard clause: prevent bootstrap objects in production
        if(Environment.current == Environment.PRODUCTION) return;

        Professor p1 = new Professor("Tom").save(flush:true, failOnError:true)
        Professor p2 = new Professor("Tim").save(flush:true, failOnError:true)

        Module m1 = new Module(p1, "mod 1", null)
        Module m2 = new Module(p1, "mod 2", null)

    }
    def destroy = {
    }
}
