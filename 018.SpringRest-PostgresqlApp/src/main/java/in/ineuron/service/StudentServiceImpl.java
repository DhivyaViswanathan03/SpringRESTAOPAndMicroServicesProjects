package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.exception.StudentNotFoundException;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public String saveStudent(Student student) {
		Student stu=dao.save(student);
		return "student saved with id"+stu.getSid();
	}

	@Override
	public List<Student> displayAllStudent() {
		return dao.findAll();
	}

	@Override
	public Student findStudent(Integer id) {
		Student stu=dao.findById(id).orElseThrow(()->new StudentNotFoundException("Record not found"));
		return stu;
	}

	@Override
	public String updateStudent(Student student) {
		Student stu=dao.save(student);
		return "student update successfully for id:"+stu.getSid();
	}

	@Override
	public String deleteStudent(Integer id) {
		dao.findById(id).orElseThrow(()->new StudentNotFoundException("Record not found"));
		dao.deleteById(id);
		return "deleted successfully for id:"+id;
	}

}
