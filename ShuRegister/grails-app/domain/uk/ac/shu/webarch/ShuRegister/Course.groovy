package uk.ac.shu.webarch.ShuRegister

/* This is the course class */
class Course {

/* This is the attributes of the course class*/
String courseName
String courseCode
String description

Set classes

static constraints = {

courseCode maxSize: 20
}

/* Links the course to the classes (RegClass)*/
static hasMany = [classes: RegClass]
static mappedBy = [classes: "course"]

/* Naming the columns in the SQL database*/
static mapping = {
table "course"
courseName column: "course_name"
courseCode column: "mapped_course_code"
description column: "course_desc" , type: "text"
}
}

