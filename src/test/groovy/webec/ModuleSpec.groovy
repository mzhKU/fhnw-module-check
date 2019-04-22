package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ModuleSpec extends Specification implements DomainUnitTest<Module> {

    Module mgli
    Module bsys

    Professor hauser;
    Professor leiser;

    def setup() {

        mockDomain Module
        mockDomain Professor

        hauser = new Professor(name: "Hauser").save()
        leiser = new Professor(name: "Leiser").save()

        mgli = new Module(title: "mgli", professor: leiser, votes: 10).save()
        bsys = new Module(title: "bsys", professor: hauser, votes: 3).save()

    }

    def cleanup() {
        mgli.delete()
        bsys.delete()
        hauser.delete()
        leiser.delete()
    }


    void "upvote increase votes"() {
        when:
        mgli.upvote()

        then:
        mgli.getVotes() == 11
    }

    // The test is 'called' by the same user, how to do that?
    /*
    void "upvote cancels upvote"() {
        when:
        mgli.upvote()
        mgli.upvote()

        then:
        mgli.getVotes() == 10
    }
    */
}
