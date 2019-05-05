package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ModuleSpec extends Specification implements DomainUnitTest<Module> {

    def setup() {

    }

    void "test Module Title cannot be blank"() {
        when:
        domain.title = ''

        then:
        !domain.validate(['title'])
    }

    def cleanup() {

    }

}
