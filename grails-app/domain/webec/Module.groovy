package webec

import grails.rest.Resource

class Module {
    String title

    /*
    @Override
    String toString() { return title }
    */

    String toString() { "$title" }

    static constraints  = {
        // title unique:true
        title blank: false
        title nullable: true
    }
}
