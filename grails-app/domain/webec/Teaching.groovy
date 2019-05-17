package webec

import grails.rest.Resource

@Resource(uri="/teaching")
class Teaching {

    Professor professor
    Module    module
    int voteValue;

    static constraints = {
    }
}
