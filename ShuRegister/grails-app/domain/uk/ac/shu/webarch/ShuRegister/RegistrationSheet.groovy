package uk.ac.shu.webarch.ShuRegister

class RegistrationSheet {

Course course

Date sheetDate

String note

Set signatories

static hasMany = [signatories: RegisterEntry ]

static mappedBy = [signatories: "registrationSheet"]


static contraints = {
course(nullable:false, blank:false);
sheetDate(nullable:false, blank:false);
notes(nullable:true, blank:true);
}


static mapping = {
table "Course_Register_sheet" 
course column: "course_fk"
notes column: "course_desc" , type:"text"
}
}

