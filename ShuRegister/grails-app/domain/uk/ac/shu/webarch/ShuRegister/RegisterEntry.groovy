package uk.ac.shu.webarch.ShuRegister

class RegisterEntry  {

Student student

RegistrationSheet registrationSheet

Long timestamp


static constraints = {
timestamp(nullable:false, blank:false);
}

static mapping = {
table "student_register_entry"
student column: "student_fk"
registrationSheet column: "registration_sheet_fk"
}
}

