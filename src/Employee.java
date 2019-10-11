
public class Employee {
	
	private String name;
	private int salary;
	private int year;
	private int month;
	private int day;
	
	public Employee(String name, int salary, int y, int m, int d) {
		this.name = name;
		this.salary = salary;
		this.year = y;
		this.month = m;
		this.day = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String getHireDate() {
		return this.year +"-"+this.month+"-"+this.day;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}

}
