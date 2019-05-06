package webec

import grails.rest.Resource

@Resource(uri="app")
class Module {
    String title

    static constraints  = {
        title unique:true
        title blank: false
        title nullable: true
    }
}
