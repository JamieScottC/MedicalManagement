package management;

public class Assistant extends Employee{

	public Assistant(String name, String address, String phoneNumber, String birthdate, int age, int id) {
		super(name, address, phoneNumber, birthdate, age, id);
		salary = 150000;
	}

}
