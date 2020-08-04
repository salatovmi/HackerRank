import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class SortStudents implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        if (student.getCgpa() - t1.getCgpa() > 0.0001) {
            return -1;
        }
        else if (Math.abs(student.getCgpa() - t1.getCgpa()) < 0.0001) {
            if (student.getFname().equals(t1.getFname())) {
                return student.getId() - t1.getId();
            }
            else {
                return student.getFname().compareTo(t1.getFname());
            }
        }
        return 1;
    }
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}

        SortStudents ss = new SortStudents();
        Collections.sort(studentList, ss);

      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
