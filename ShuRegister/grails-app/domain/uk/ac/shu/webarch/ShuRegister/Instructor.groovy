package uk.ac.shu.webarch.ShuRegister

/* The teachers of the class*/

class Instructor {

/* Attributes for the instructor class */

String name
String staffId

Set classes

static hasMany = [classes: RegClass]

static mappedBy = [classes: "classInstructor"]


    static constraints = {
name(nullable:false, blank:false,maxSize:256);
staffId(nullable:false, blank:false,maxSize:20);
    }
}

