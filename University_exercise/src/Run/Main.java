package Run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Test.Course;
import Test.FullTeacher;
import Test.PartTeacher;
import Test.Student;
import Test.Teacher;
import Test.University;
import Util.Util;

public class Main {

	public static void main(String[] args) {
		
		int menu = 0;
		
		University university = new University();
		
		university.addTeacher(new FullTeacher ("John", 4));
		university.addTeacher(new PartTeacher ("Oscar", 8));
		university.addTeacher(new FullTeacher ("Marian", 5));
		university.addTeacher(new PartTeacher ("Caroline", 10));
		
		university.addStudent(new Student ("Catalina", 20912, 28));
		university.addStudent(new Student ("Julian", 20951, 30));
		university.addStudent(new Student ("Sandra", 20929, 29));
		university.addStudent(new Student ("Carlos", 20853, 37));
				
		university.addCourse(new Course("Biology", 203, university.getTeachersList().get(0)));
		university.addCourse(new Course("Maths", 207, university.getTeachersList().get(1)));
		university.addCourse(new Course("History", 105, university.getTeachersList().get(2)));
		university.addCourse(new Course("Physics", 502, university.getTeachersList().get(3)));
		
		university.getCoursesList().get(0).addStudentsList(university.getStudentsList().get(0));
		university.getCoursesList().get(0).addStudentsList(university.getStudentsList().get(1));
		
		university.getCoursesList().get(1).addStudentsList(university.getStudentsList().get(1));
		university.getCoursesList().get(1).addStudentsList(university.getStudentsList().get(2));
		
		university.getCoursesList().get(2).addStudentsList(university.getStudentsList().get(2));
		university.getCoursesList().get(2).addStudentsList(university.getStudentsList().get(3));
		
		university.getCoursesList().get(3).addStudentsList(university.getStudentsList().get(3));
		university.getCoursesList().get(3).addStudentsList(university.getStudentsList().get(0));
		
		while (menu != 6) {
			System.out.println("\nMenu\n1. Teachers List\n2. Courses List\n3. Add a new student\n4. Add a new course\n5. List the classes for a given student\n6. Salir");
			
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
		
			switch (menu) {
				
			case 1:	
				university.printTeachersList();
				break;
			case 2:
				university.printCourses();
				System.out.println("\nWrite the name of the course that you want to see");
				String selectedCourse = Util.scanString();
				university.printCourseInformation(selectedCourse);
				break;		
			case 3: 
				university.addNewStudent();
				System.out.println("¿Which course will take the student?");
				String courseName = Util.scanString();
				university.findCourseByName(courseName).addStudentsList(university.getLastStudentAdded());
				break;				
			case 4:
				university.addNewCourse();
				university.addStudentToCourse();
				break;
			case 5: 
				university.listCoursesForStudent();
				break;
			}
		}
	}	
}
