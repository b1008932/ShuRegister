package uk.ac.shu.webarch.ShuRegister


class RegClass {

String name

Instructor classInstructor

Course course

Set enrolledStudents

String code

Set registrationSheets

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

