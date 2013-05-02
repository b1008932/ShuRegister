package uk.ac.shu.webarch.ShuRegister


class Course {

String courseName
String courseCode
String description

Set classes

static constraints = {

courseCode maxSize: 20
}

static hasMany = [classes: RegClass]
static mappedBy = [classes: "course"]

static mapping = {
table "course"
courseName column: "course_name"
courseCode column: "mapped_course_code"
description column: "course_desc" , type: "text"
}
}

