package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.StudentDto;

public class StudentServiceImpl implements IStudentService{

	private IStudentDao studentdao;
	@Override
	public String addstudent(StudentDto student) {
		// TODO Auto-generated method stub
		studentdao = StudentDaoFactory.getstudentdao();
		return studentdao.addstudent(student);
	}

	@Override
	public StudentDto searchstudent(Integer studentId) {
		// TODO Auto-generated method stub
		studentdao = StudentDaoFactory.getstudentdao();
		return studentdao.searchstudent(studentId);
	}

	@Override
	public String deletestudent(Integer studentId) {
		// TODO Auto-generated method stub
		studentdao = StudentDaoFactory.getstudentdao();
		return studentdao.deletestudent(studentId);
	}

	@Override
	public String updatestudent(StudentDto student) {
		// TODO Auto-generated method stub
		studentdao = StudentDaoFactory.getstudentdao();
		return studentdao.updatestudent(student);
	}

}
