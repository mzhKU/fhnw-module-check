package webec

import webec.Module
import webec.Professor

class BootStrap {

    def init = { servletContext ->

        // Guard clause: prevent bootstrap objects in production
        // if(Environment.current == Environment.PRODUCTION) return;

        Professor p1 = new Professor(name: "Tom").save(flush: true, failOnError: true)
        Professor p2 = new Professor(name: "Tim").save(flush: true, failOnError: true)

        Module bsys = new Module(title: "BSYS").save(flush: true, failOnError: true);
        Module vana = new Module(title: "VANA").save(flush: true, failOnError: true);

        Student s1 = new Student().save(flush: true, failOnError: true)
        Student s2 = new Student().save(flush: true, failOnError: true)
        Student s3 = new Student().save(flush: true, failOnError: true)
        Student s4 = new Student().save(flush: true, failOnError: true)
        Student s5 = new Student().save(flush: true, failOnError: true)

        // BSYS.p1 has 1+1-1 = +1 Rating
        Rating r1 = new Rating(module: bsys, professor: p1, student: s1, upvoted: true).save(flush: true, failOnError: true)
        Rating r2 = new Rating(module: bsys, professor: p1, student: s2, upvoted: true).save(flush: true, failOnError: true)
        Rating r3 = new Rating(module: bsys, professor: p1, student: s3, upvoted: false).save(flush: true, failOnError: true)

        // BSYS.p2 has -1-1 = -2 Rating
        Rating r4 = new Rating(module: bsys, professor: p2, student: s1, upvoted: false).save(flush: true, failOnError: true)
        Rating r5 = new Rating(module: bsys, professor: p2, student: s2, upvoted: false).save(flush: true, failOnError: true)

        Rating r6 = new Rating(module: vana, professor: p1, student: s4, upvoted: true).save(flush: true, failOnError: true)
        Rating r7 = new Rating(module: vana, professor: p2, student: s5, upvoted: true).save(flush: true, failOnError: true)

    }

    def destroy = {
    }
}
