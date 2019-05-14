package webec

import webec.Module
import webec.Professor
import webec.SecRole
import webec.SecUser
import webec.SecUserSecRole

class BootStrap {

    def init = { servletContext ->

        // Guard clause: prevent bootstrap objects in production
        // if(Environment.current == Environment.PRODUCTION) return;


        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))

        SecUser guest = save(new SecUser(username: 'guest', password: 'guest'))
        SecUserSecRole.create(guest, guestRole, true)


        SecUser testUser = save(new SecUser(username: 'me', password: '1234'))
        SecUserSecRole.create(testUser, adminRole, true)


        assert SecRole.count() == 2
        assert SecUser.count() == 2
        assert SecUserSecRole.count() == 2

        Professor p1 = new Professor(name: "Tom").save(flush: true, failOnError: true)
        Professor p2 = new Professor(name: "Tim").save(flush: true, failOnError: true)

        // List<Professor> bsysProfessors = new ArrayList<>()
        // bsysProfessors.add(p1)
        // bsysProfessors.add(p2)

        // List<Professor> vanaProfessors = new ArrayList<>()
        // vanaProfessors.add(p2)

        Module bsys = new Module(title: "BSYS").save(flush: true, failOnError: true);
        Module vana = new Module(title: "VANA").save(flush: true, failOnError: true);
        Module mgli = new Module(title: "MGLI").save(flush: true, failOnError: true);

        Student s1 = new Student(name: "s1").save(flush: true, failOnError: true)
        Student s2 = new Student(name: "s2").save(flush: true, failOnError: true)
        Student s3 = new Student(name: "s3").save(flush: true, failOnError: true)
        Student s4 = new Student(name: "s4").save(flush: true, failOnError: true)
        Student s5 = new Student(name: "s5").save(flush: true, failOnError: true)

        // BSYS.p1 has 1+1-1 = +1 Rating
        Rating r1 = new Rating(module: bsys, professor: p1, student: s1, vote: 1).save(flush: true, failOnError: true)
        // Rating r8 = new Rating(module: bsys, professor: p1, student: s1, upvote: true).save(flush: true, failOnError: true)
        Rating r2 = new Rating(module: bsys, professor: p1, student: s2, vote: 1).save(flush: true, failOnError: true)
        Rating r3 = new Rating(module: bsys, professor: p1, student: s3, vote: -1).save(flush: true, failOnError: true)

        // BSYS.p2 has -1-1 = -2 Rating
        Rating r4 = new Rating(module: bsys, professor: p2, student: s1, vote: -1).save(flush: true, failOnError: true)
        Rating r5 = new Rating(module: bsys, professor: p2, student: s2, vote: -1).save(flush: true, failOnError: true)

        Rating r6 = new Rating(module: vana, professor: p1, student: s4, vote: 1).save(flush: true, failOnError: true)
        Rating r7 = new Rating(module: vana, professor: p2, student: s5, vote: 1).save(flush: true, failOnError: true)
        Rating r8 = new Rating(module: mgli, professor: p2, student: s1, vote: 1).save(flush: true, failOnError: true)

        save(new Teaching(professor: p1, module: bsys))
        save(new Teaching(professor: p2, module: bsys))
        save(new Teaching(professor: p1, module: vana))
        save(new Teaching(professor: p2, module: mgli))

    }

    static <Domain> Domain save(Domain domainObject) {
        domainObject.save(failOnError: true, flush:true)
    }

    def destroy = {
    }
}
