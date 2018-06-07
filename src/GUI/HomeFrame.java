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
		Patient test14 = new Patient("Barry Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test2 = new Patient("Richard Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test3 = new Patient("Joseph Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test4 = new Patient("John Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test5 = new Patient("Harold Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test6 = new Patient("Nick Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test7 = new Patient("Jack Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test8= new Patient("Stacy Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test9 = new Patient("Will Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test10 = new Patient("Kristen Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test11 = new Patient("Karen Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test12 = new Patient("Elise Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		Patient test13 = new Patient("Alice Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");

		Patient test = new Patient("Joey Block", "148 Oliver RD", "914-856-0972", "05/05/2000", "Google", "Blue Shield", "05160291999");
		test.getAppointments().add(new Appointment("05/05/05", "5:30", "Checkup"));
		test.getAppointments().add(new Appointment("05/08/05", "5:45", "Eye test"));
		test.getAppointments().add(new Appointment("07/09/05", "9:30", "X-rays"));
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
		JButton btnPatients = new JButton("Enter Patient Portal");
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
		btnPatients.setBounds(153, 141, 553, 188);
		btnPatients.setFont(new Font("Verdana", Font.PLAIN, 44));
		frame.getContentPane().add(btnPatients);
	}
	public JFrame getFrame(){
		return frame;
	}
}
