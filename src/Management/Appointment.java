package Management;

import java.util.ArrayList;

public class Appointment {
	private String date, time;
	public static ArrayList<Appointment>  appointments = new ArrayList<Appointment>();
	public Appointment(String date, String time){
		this.date = date;
		this.time = time;
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


}
