import java.io.*;
import java.util.*;

public class TextFile {

	public static void main(String[] args) throws IOException {
		Employee[] emps = new Employee[3];
		emps[0] = new Employee("Carl", 7500, 1999,3,1);
		emps[1] = new Employee("Harry", 9500, 1995,7,12);
		emps[2] = new Employee("Tony", 8000, 1999,9,3);
		
		File f = new File("Employees.txt");
		if(!f.exists()) {
			f.createNewFile();
		}
		
		// save all employee records to a file
		try(PrintWriter out = new PrintWriter(f.getName(),"UTF-8")){
			writeEmployees(out, emps);
		}
		
		try(Scanner in = new Scanner(new FileInputStream(f.getName()))){
			Employee[] stfs = readEmps(in);
			for(Employee emp: stfs) {
				System.out.println(emp.toString());
			}
		}

	}

	public static void writeEmployees(PrintWriter out, Employee[] emps) {
		out.println(emps.length);
		for(Employee emp: emps) {
			writeOneEmployee(out,emp);
		}
		
	}
	
	// write every single employee data into file
	public static void writeOneEmployee(PrintWriter out, Employee e) {
		out.println(e.getName()+"|"+e.getSalary()+"|"+e.getHireDate());
	}
	
	private static Employee[] readEmps(Scanner in) {
		// consume a new line
		int len = in.nextInt();
		in.nextLine();
		Employee[] emps = new Employee[len];
		for(int i=0; i<len;i++) {
			emps[i] = readOneEmployee(in);
		}
		return emps;
	}
	
	
	public static Employee readOneEmployee(Scanner in) {
		String line = in.nextLine();
		String[] attrs = line.split("\\|");
		String name = attrs[0];
		int salary = Integer.parseInt(attrs[1]);
		String hiredDate = attrs[2];
		
		String[] date = hiredDate.split("\\-");
		String y = date[0];
		String m = date[1];
		String d = date[2];
		
		return new Employee(name, salary, Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
		
	}
}
