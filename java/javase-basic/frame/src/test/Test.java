package test;

import java.util.List;

import comman.spring.iocdi.ClassPathApplicationContext;
import dao.StuScoreDao;
import dao.StudentDao;
import dao.impl.StuScoreDaoImpl;
import dao.impl.StudentDaoImpl;
import model.StuScore;
import model.Student;
import service.StudentService;

public class Test {
	public static void main(String[] args) {
		// �������ӳ�
		/*StudentDao stuDao = new StudentDaoImpl();
		
		stuDao.updateStudent("davidJin", 3);
		
		List<Student> list = stuDao.getStudents();
		for (Student s : list) {
			System.out.println(s.toString());
		}
		
		System.out.println("==================");
		StuScoreDao ssDao = new StuScoreDaoImpl();
		List<StuScore> listScore = ssDao.getStuScores();
		for (StuScore ss : listScore) {
			System.out.println(ss.toString());
		}*/
		
		// ����IOCOne
		/*ClassPathApplicationContext cs = new ClassPathApplicationContext("ApplicationContext.xml");
		Student s = (Student) cs.getBean("student");
		System.out.println(s);*/
		
		// ����IOCTwo
		ClassPathApplicationContext cs = new ClassPathApplicationContext();
		StudentService s = (StudentService) cs.getBean("studentService");
		System.out.println(s.getStudentDao());
	}
}
