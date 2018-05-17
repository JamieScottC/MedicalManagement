package Management;
import java.awt.List;
import java.util.ArrayList;

public class Patient {
	private String name, address, phoneNumber, birthdate, employer, insurance;
	private int age, ssn, id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static ArrayList<Patient> patients = new ArrayList();
	public Patient(String name, String address, String phoneNumber, String birthdate, String employer, String insurance,
			int age, int ssn) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthdate;
		this.employer = employer;
		this.insurance = insurance;
		this.age = age;
		this.ssn = ssn;
		//Add this patient to our list of patients and assign id
		patients.add(this);
		id = patients.size();
	}
	//Testing constructor
	
	public String getName() {
		return name;
	}

	public Patient() {
		this.name = "J";
		this.address = "J";
		this.phoneNumber ="J";
		this.birthdate = "J";
		this.employer = "J";
		this.insurance ="J";
		this.age = 5;
		this.ssn = 10;
		id = patients.size();
	}
	public void setName(String name) {
		this.name = name;
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

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
}
