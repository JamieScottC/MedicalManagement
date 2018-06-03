package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import management.Appointment;
import management.Patient;

public class HomeFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame window = new HomeFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Add test patients
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient.patients.add(new Patient());
		Patient test = new Patient("Joey Block", "test", "test", "05/05/2000", "test", "test", "test");
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		//Done testing
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 860, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Button to enter patient portal
		JButton btnPatients = new JButton("Patients");
		btnPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When button clicked open new frame
				frame.setVisible(false);
				frame.dispose();
				// Make new patient frame object and set visable
				PatientListFrame plistframe = new PatientListFrame();
				plistframe.setVisible(true);
			}
		});
		btnPatients.setBounds(30, 60, 150, 31);
		btnPatients.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(btnPatients);

		JButton btnEmployees = new JButton("Employees");
		btnEmployees.setBounds(254, 60, 150, 31);
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmployees.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(btnEmployees);

		JButton button = new JButton("Patients");
		button.setBounds(30, 186, 150, 31);
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(button);

		JButton btnEmployees_1 = new JButton("Employees");
		btnEmployees_1.setBounds(254, 186, 150, 31);
		btnEmployees_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(btnEmployees_1);
	}

}
