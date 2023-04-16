package in.ineuron.daofactory;

import in.ineuron.dao.*;

public class StudentDaoFactory {
	private StudentDaoFactory() {}
	private static IStudentDao studentdao = null;
	public static IStudentDao getstudentdao() {
		if(studentdao ==null) {
			studentdao = new StudentDaoImpl();
		}
		return studentdao;
	}
}
