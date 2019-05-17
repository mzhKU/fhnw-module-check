package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import grails.test.hibernate.HibernateSpec

@SuppressWarnings("MethodName")
class RatingSpec extends Specification implements DomainUnitTest<Rating> {

    Professor p1 = new Professor(name: "Test Professor 1").save(flush: true, failOnError: true)
    Professor p2 = new Professor(name: "Test Professor 2").save(flush: true, failOnError: true)
    Student   s1 = new Student(name: "s1").save(flush: true, failOnError: true)
    Module    m1 = new Module(title: "Test Module 01").save(flush: true, failOnError: true)

    def "Two same ratings are invalid"() {


        // ---------- Test 1 --------------------------------------------------------
        when: "A rating has a unique combination of prof student module vote"
        def  rating01 = new Rating(professor: p1, student: s1, module: m1, vote: 1)

        then: "it is a valid instances"
        rating01.validate(['vote'])

        and: "can be saved"
        rating01.save()

        and: "there is now one rating in the database"
        Rating.all.size() == 1
        // ----------------------------------------------------------------------------


        // ---------- Test 2 --------------------------------------------------------
        when: "A second rating has the same parameters"
        def rating02 = new Rating(professor: p1, student: s1, module: m1, vote: 1)

        and: "they it is saved"
        rating02.save()

        then: "the upvote value of the second rating is not valid"
        !rating02.validate(['vote'])
        // ----------------------------------------------------------------------------


        // ---------- Test 3 --------------------------------------------------------
        when: "A third rating has a different professor"
        def rating03 = new Rating(professor: p2, student: s1, module: 1, vote: 1)

        then: "it is valid"
        rating03.validate(['vote'])

        and: "it can be saved"
        rating03.save()

        and: "there are now two ratings in the database"
        Rating.all.size() == 2
        // ----------------------------------------------------------------------------
    }


    def cleanup() {}
}
