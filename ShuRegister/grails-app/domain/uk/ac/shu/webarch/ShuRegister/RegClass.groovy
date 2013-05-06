package uk.ac.shu.webarch.ShuRegister

/* The word Class is a used word so i have called it RegClass  */
class RegClass {

/* This is the Attributes for Class */
String name

Instructor classInstructor

Course course

Set enrolledStudents

String code

Set registrationSheets

/*This links the Class to Enrollment and Registration sheet */
static hasMany = [enrolledStudents: Enrollment, registrationSheets:RegistrationSheet
]

static mappedBy =[enrolledStudents: "regClass", registrationSheets:'regClass'
]

    static constraints = {
    }

static mapping = {
  classInstructor column: "instructor_fk"
    course column: "course_fk"
}
}

