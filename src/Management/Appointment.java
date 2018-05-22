package Management;

import java.util.ArrayList;

public class Appointment {
	private String date, time;
	private Patient patient;
	public static ArrayList<Appointment>  appointments = new ArrayList<Appointment>();
	public Appointment(String date, String time, Patient patient){
		this.date = date;
		this.time = time;
		this.patient = patient;
	}

	
	
	//Getters and Setters
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
