package webec

import grails.rest.Resource

@Resource(uri="app")
class Module {
    String title
    List<Professor> professors

    static constraints  = {
        title unique:true
        title blank: false
    }
}
