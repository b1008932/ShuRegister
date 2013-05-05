import uk.ac.shu.webarch.ShuRegister.*;

class BootStrap {

    def init = { servletContext ->

println("BootStrap::init");

def ash_instructor = Instructor.findByStaffId('4334a') ?: new Instructor(name:'Ashley Moran', staffId:'4334a').save();
def james_instructor = Instructor.findByStaffId('1222d') ?: new Instructor(name:'James Lorry', staffId:'1222d').save();


def web_arch_course = Course.findByCourseCode('1111wa') ?: new Course(courseCode:'1111wa', courseName:'Web Architectures',
                                                                    description: 'A Web Architectures course').save();

def database_course = Course.findByCourseCode('2222db') ?: new Course(courseCode:'2222db', courseName:'Database_systems', description: 'Sql Based databases').save();


def webArch_monday = RegClass.findByCourseAndName(web_arch_course, 'WebArch-Mondays') ?: 
                                                                    new RegClass(name:'WebArch-Mondays',
                                                                       classInstructor:james_instructor , 
                                                                         course:web_arch_course).save(); 

def webArch_tuesday = RegClass.findByCourseAndName(web_arch_course, 'WebArch-Tuesday') ?: 
                                                                    new RegClass(name:'WebArch-Tuesday',
                                                                       classInstructor:james_instructor , 
                                                                         course:web_arch_course).save();

def database_thursday = RegClass.findByCourseAndName(database_course, 'Database-Thursday') ?: 
                                                                    new RegClass(name:'Database-Thursday',
                                                                       classInstructor:ash_instructor , 
                                                                         course:database_course).save();

def student_a = Student.findByStudentNumber('b1008') ?: new Student(studentNumber:'b1008', fullStudentName:'John Paul',
                                                                         notes:'John Paul Monday WebArch').save();

def student_b = Student.findByStudentNumber('b1233') ?: new Student(studentNumber:'b1233', fullStudentName:'Eric Davis',
                                                                         notes:'Eric Davis Tuesday WebArch').save();

def student_c = Student.findByStudentNumber('b1877') ?: new Student(studentNumber:'b1877', fullStudentName:'James Trin',
                                                                         notes:'James Trin Thursday Database').save();




def student_a_webArch = Enrollment.findOrCreateByStudentAndRegClass(student_a,webArch_monday)

def student_b_webArch = Enrollment.findOrCreateByStudentAndRegClass(student_b,webArch_tuesday)

def student_c_webArch = Enrollment.findOrCreateByStudentAndRegClass(student_c,database_thursday)




    }
    def destroy = {
    }
}
