package webec

import java.util.stream.Stream

/*
 --------------------
 Module  |   Teaching
 --------------------
 BSYS    | prof01
 BSYS    | prof02
       [...]
 --------------------

 --------------------------------------
 Module | Professor | Student | Upvote
 --------------------------------------
 BSYS   | prof01    | stud01  | true
 BSYS   | prof01    | stud02  | false
       [...]
 --------------------------------------
*/



import grails.plugin.springsecurity.annotation.Secured
import webec.SecRole

@Secured(SecRole.ADMIN)
class AppController {

    def index() {

        Professor p
        Student   s = new Student(name: "s0").save(flush: true, failOnError: true)
        Module    m
        int       vote

        // Prevent saving of a new rating on initial load when no values are submitted
        if(null != params.get("professor")) {
            p = Professor.findByName(params.get("professor"))
            m = Module.findByTitle(params.get("module"))
            vote = Integer.valueOf(params.get("vote"))

            // Default student before implementing authentication and authorization
            s = new Student(name: "s0").save(flush: true, failOnError: true)

            Rating r = new Rating(module: m, professor: p, student: s, vote: vote )
            r.save(flush: true, failOnError: true)
            System.out.println("Rating added: " + r.module.title + " " + r.professor.name + " " + r.vote)
        }

        for(Teaching t : Teaching.all) {
            t.voteValue = Rating.findAllByModuleAndProfessor(t.module, t.professor).vote.sum()
        }

        render(view:'index', model:[student: s.name, teachings: Teaching.all, ratings: Rating.all.size()])
    }
}
