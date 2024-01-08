package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Student;

public interface IStudentService {
	public String saveStudent(Student student);
	public List<Student> displayAllStudent();
	public Student findStudent(Integer id);
	public String updateStudent(Student student);
	public String deleteStudent(Integer id);

}
