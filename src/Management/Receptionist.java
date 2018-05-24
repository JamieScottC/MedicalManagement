package Management;

public class Receptionist extends Employee{

	public Receptionist(String name, String address, String phoneNumber, String birthdate, int age, int id) {
		super(name, address, phoneNumber, birthdate, age, id);
		salary = 50000;
	}

}
