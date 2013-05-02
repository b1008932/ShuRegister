import uk.ac.shu.webarch.ShuRegister.*;

class BootStrap {

    def init = { servletContext ->

println("BootStrap::init");

def ash_instructor = Instructor.findByStaffId('4334a') ?: new Instructor(name:'Ashley Moran', staffId:'4334a').save();
def james_instructor = Instructor.findByStaffId('1222d') ?: new Instructor(name:'James Lorry', staffId:'1222d').save();


/*def web_arch_course = Course.findBycourseCode('1111') ?: new Course(courseCode:'1111', courseName:'Web Architectures',
                                                                     description: 'A Web Architectures course').save();


def new_class = RegClass.findByname('WebArch-Mondays') ?: new RegClass(name:'WebArch-Mondays',
                                                                       classInstructor:james_instructor , 
                                                                         course:web_arch_course).save(); */

    }
    def destroy = {
    }
}
