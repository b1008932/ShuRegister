package uk.ac.shu.webarch.ShuRegister

/* This is the Register Entry class */
class RegisterEntry  {

/* This is the attributes for the Register Entry class */
Student student

RegistrationSheet regSheet

Long timestamp


static constraints = {
timestamp(nullable:false, blank:false);
}

static mapping = {
table "student_register_entry"
student column: "student_fk"
regSheet column: "registration_sheet_fk"
}
}

