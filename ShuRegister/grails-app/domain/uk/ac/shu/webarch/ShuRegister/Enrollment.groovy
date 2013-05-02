package uk.ac.shu.webarch.ShuRegister

class Enrollment {

Student student
RegClass regClass

static contraints = {
}

static mapping = {
table "course_student"
student column: "student_fk"
regClass column: "reg_class_fk"
}
}

