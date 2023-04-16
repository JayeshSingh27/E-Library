package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory {
	private StudentServiceFactory () {}
	private static IStudentService studentservice=null;
	public static IStudentService getstudentservice() {
		if(studentservice == null) {
			studentservice = new StudentServiceImpl();
		}
		return studentservice;
	}
}
