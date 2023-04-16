package in.ineuron.dao;

import in.ineuron.dto.StudentDto;

public interface IStudentDao {
	public String addstudent(StudentDto student);
	public StudentDto searchstudent(Integer studentId);
	public String deletestudent(Integer studentId);
	public String updatestudent(StudentDto student);
}
