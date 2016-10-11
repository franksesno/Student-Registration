import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.joda.time.LocalDate;

import Assignment1.Assign1.course;
import Assignment1.Assign1.module;
import Assignment1.Assign1.student;
public class studentReg {

	public static void main(String[] args) {
		String courseName = "Electronic and Computer Engineering ";
		
		//Creating an array of students
		
		student[] a ={ new student("Frank Jezz", "22/05/1994", 22, 3001),
					   new student("King Kunte", "15/06/1993", 23, 2111)};
		student[] b ={ new student("Michael Scofield", "20/01/1994", 22, 3125),
					   new student("Michael Jackson", "29/11/1993", 23, 2158)};
		student[] c ={ new student("Jeff Hardy", "14/10/1995", 21, 3257),
					   new student("Matt Hardy", "10/12/1992", 24, 3459)};
		
		//array of modules
		
		module[] modulesList ={ new module("Software Engineering III","CT417", a),
							    new module("Machine Learning & Data Mining", "CT4475", b),
							    new module("Telecommunication Software Applications", "EE453", c)};
		
		LocalDate startDate = new LocalDate(2016, 9, 1);
		LocalDate endDate = new LocalDate(2017, 4, 25);
		course Prog = new course( courseName, modulesList, startDate, endDate );
		
		module[] m = Prog.getModuleList();
		HashMap <student, ArrayList<module>> map_a = new HashMap<student, ArrayList<module>>();
		HashMap <module, course> map_b = new HashMap<module, course>();
		
		for (int i=0; i<m.length;i++){
			student[] enrolled_Students = m[i].getStudentList();
			map_b.put(m[i], Prog);
			
			for (int j=0; j<enrolled_Students.length; j++){
				if (!map_a.containsKey(enrolled_Students[j])){
					map_a.put(enrolled_Students[j], new ArrayList<module>());
				}
				
				map_a.get(enrolled_Students[j]).add(m[i]);
			
		}

	}
		
		Set<student> keys = map_a.keySet();
		Iterator<student> i = keys.iterator();
		
		while(i.hasNext()){
			student temp = i.next();
			System.out.println("Student:" +  student.getUsername() );
			ArrayList<module> list = map_a.get(temp);
			Iterator<module> itr = list.iterator();
			
			System.out.println("Modules:");
			
			while(itr.hasNext()){
				module t = itr.next();
				System.out.println(t.getModuleName() + " ");
			}
		
			System.out.println("Course:" + map_b.get(list.get(0)).getCourseName());
		}

}
}