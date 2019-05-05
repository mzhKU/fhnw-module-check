package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RatingSpec extends Specification implements DomainUnitTest<Rating> {

    Professor professor1
    Student   student1
    Module    module1
    Rating    rating1

    def setup() {
        mockDomain Module
        mockDomain Professor
        mockDomain Student
        mockDomain Rating

        professor1 = new Professor(name: "TestProfessor 01")
        student1   = new Student(name: "TestStudent 01")
        module1    = new Module(title: "TestModule 01")

        rating1    = new Rating(professor: professor1, student: student1, module: module1, upvote: true)
    }

    void "test double_vote_up"() {
        when:
            def init = { servletContext ->
                rating1.save(flush: true)
                // rating1.save(flush: true)
            }

        then:
            true == true

    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

    def cleanup() {
        professor1.delete()
        student1.delete()
        module1.delete()
    }

}
