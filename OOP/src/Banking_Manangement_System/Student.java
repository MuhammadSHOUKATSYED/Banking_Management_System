package assignment_1;
import java.util.*;
public class Student {
	private String name;
	private String UniversityId; // 3 accounts per university id
	private String program;
	private String course; //Student's course must be SDA
	private String address;
	private String phoneNumber;
	private List<Account> acc;
	
	public Student(String name, String universityId, String program, String course, String address, String phoneNumber,
			List<Account> acc) {
		super();
		this.name = name;
		UniversityId = universityId;
		this.program = program;
		this.course = course;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.acc = acc;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversityId() {
		return UniversityId;
	}
	public void setUniversityId(String universityId) {
		UniversityId = universityId;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Account> getAcc() {
		return acc;
	}
	public void setAcc(List<Account> acc) {
		this.acc = acc;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", UniversityId=" + UniversityId + ", program=" + program + ", course="
				+ course + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
}