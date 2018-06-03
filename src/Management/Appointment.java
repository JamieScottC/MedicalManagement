package management;

import java.util.ArrayList;

public class Appointment {
	private String date, time, reason;
	public static ArrayList<Appointment> appointments = new ArrayList<Appointment>();

	public Appointment(String date, String time, String reason) {
		this.date = date;
		this.time = time;
		this.reason = reason;
	}

	// Getters and Setters
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
