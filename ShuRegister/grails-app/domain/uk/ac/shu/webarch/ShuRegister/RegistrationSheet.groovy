package uk.ac.shu.webarch.ShuRegister

/* This is the Registration sheet class */
class RegistrationSheet {

/* This is the attributes for the regsheet class */
RegClass regClass

String shortcode

Course course

Date sheetDate

String note

Set signatories

static hasMany = [signatories: RegisterEntry ]

static mappedBy = [signatories: "regSheet"]


static contraints = {
course(nullable:false, blank:false);
sheetDate(nullable:false, blank:false);
notes(nullable:true, blank:true);
shortcode(nullable:false, blank:false);
}


static mapping = {

}
}

