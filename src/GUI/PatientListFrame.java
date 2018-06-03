package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import management.Patient;

import javax.swing.JTable;

public class PatientListFrame extends JFrame {

	private static final long serialVersionUID = 8356686953031687928L;
	private JPanel contentPane;
	private JList<String> patientList;
	JLabel label = new JLabel("");

	JLabel label_1 = new JLabel("");

	JLabel label_2 = new JLabel("");

	JLabel label_3 = new JLabel("");

	JLabel label_4 = new JLabel("");

	JLabel label_5 = new JLabel("");

	JLabel label_6 = new JLabel("");
	private final JButton btnAddNewPatient = new JButton("Add new Patient");
	private JTable appointmentTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientListFrame frame = new PatientListFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// Need to suppress these warnings or designer will freak out?
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PatientListFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Create list of patients
		patientList = new JList(createPatientNames());
		patientList.setValueIsAdjusting(true);
		patientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		patientList.setBackground(Color.LIGHT_GRAY);
		patientList.setForeground(Color.BLACK);
		patientList.setBounds(10, 11, 145, 239);
		patientList.setLayoutOrientation(JList.VERTICAL);
		// Make scrollbar for patients
		JScrollPane scrollBar = new JScrollPane(patientList);
		scrollBar.setForeground(Color.BLACK);
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(10, 45, 209, 423);
		scrollBar.setViewportView(patientList);
		contentPane.add(scrollBar);
		// Patient panel to view patient info
		final JPanel patientPanel = new JPanel();
		patientPanel.setVisible(false);
		patientPanel.setLayout(null);
		patientPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		patientPanel.setBounds(245, 0, 409, 521);
		contentPane.add(patientPanel);
		patientPanel.setVisible(false);
		// Labels for patient panel

		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(10, 50, 267, 17);
		patientPanel.add(label);

		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(10, 90, 267, 21);
		patientPanel.add(label_1);

		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(10, 130, 267, 17);
		patientPanel.add(label_2);

		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(10, 170, 267, 17);
		patientPanel.add(label_3);

		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(10, 210, 235, 17);
		patientPanel.add(label_4);

		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(10, 250, 235, 17);
		patientPanel.add(label_5);

		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(10, 290, 267, 17);
		patientPanel.add(label_6);

		// appointment table
		appointmentTable = new JTable();
		appointmentTable.setFillsViewportHeight(true);
		appointmentTable.setToolTipText("");
		appointmentTable.setBounds(88, 392, 300, 118);
		patientPanel.add(appointmentTable);
		JScrollPane scrollPane = new JScrollPane(appointmentTable);
		scrollPane.setBounds(71, 431, 300, 80);
		patientPanel.add(scrollPane);

		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAppointments.setBounds(182, 406, 102, 14);
		patientPanel.add(lblAppointments);

		// Add appointment button
		JButton btnAddAppointment = new JButton("Add Appointment");
		btnAddAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!patientList.isSelectionEmpty()){
					System.out.println("New Appointment dialog");
					new AddAppointmentDialog(Patient.patients.get(patientList.getSelectedIndex()), getFrame());
				}
			}
		});
		btnAddAppointment.setBounds(162, 381, 115, 23);
		patientPanel.add(btnAddAppointment);
		// add patient button
		btnAddNewPatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddNewPatient.setBounds(41, 11, 143, 23);

		contentPane.add(btnAddNewPatient);

		JButton btnDeletePatient = new JButton("Delete this Patient");
		btnDeletePatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDeletePatient.setBounds(41, 479, 143, 23);
		contentPane.add(btnDeletePatient);
		// Creating new patient...
		btnAddNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientAlert(getFrame());

			}
		});
		// Deleting currently selected patient
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient.patients.remove(patientList.getSelectedIndex());
				updatePatientList();
			}
		});
		// When we select a patient
		patientList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				// Ignore firing off another event when you release the mouse
				if (le.getValueIsAdjusting()) {
					return;
				}
				int i = patientList.getSelectedIndex();
				if (i != -1) {
					// Selected a patient so display the panel
					Patient patient = Patient.patients.get(i);
					patientPanel.setVisible(true);

					updatePatientPanel(patient);

					// Also update appointment table
					updateAppointmentTable(patient);
				}
			}
		});
	}

	// Helper Methods

	// Create array of Patient names and organize
	public String[] createPatientNames() {
		String[] patientNames = new String[Patient.patients.size()];
		for (int i = 0; i < Patient.patients.size(); i++) {
			patientNames[i] = Patient.patients.get(i).getName();
		}
		return patientNames;
	}

	// Update the patient panel to currently selected patient
	public void updatePatientPanel(Patient patient) {

		label.setText("Name:" + patient.getName());

		label_1.setText("Age: " + patient.getAge());

		label_2.setText("Address: " + patient.getAddress());

		label_3.setText("Phone Number: " + patient.getPhoneNumber());

		label_4.setText("Birthdate: " + patient.getBirthdate());

		label_5.setText("Employer: " + patient.getEmployer());

		label_6.setText("Insurance: " + patient.getInsurance());

	}

	public void updateAppointmentTable(Patient patient) {
		AppointmentDataModel appointmentDataModel = new AppointmentDataModel(
				patient);

		if (patient.getAppointments().size() != 0) {

			appointmentDataModel.setRowCount(patient.getAppointments().size());
			appointmentTable.setModel(appointmentDataModel);

			// If we dont have any appointments lets clear the
			// appointment table
		} else {
			appointmentDataModel.setRowCount(0);
			appointmentTable.setModel(appointmentDataModel);

		}
	}

	public void updatePatientList() {

		patientList.setListData(createPatientNames());
	}

	// Getters and Setters
	public PatientListFrame getFrame() {
		return this;
	}
}


