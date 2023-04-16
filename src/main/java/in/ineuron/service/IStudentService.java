package in.ineuron.service;

import in.ineuron.dto.StudentDto;

public interface IStudentService {
	public String addstudent(StudentDto student);
	public StudentDto searchstudent(Integer studentId);
	public String deletestudent(Integer studentId);
	public String updatestudent(StudentDto student);
}
