package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
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

import Management.Patient;

public class PatientListFrame extends JFrame {

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
	public PatientListFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Create list of patients
		patientList = new JList<String>(createPatientNames());
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
		JPanel patientPanel = new JPanel();
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

		btnAddNewPatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddNewPatient.setBounds(41, 11, 143, 23);

		contentPane.add(btnAddNewPatient);
		// Creating new patient...
		btnAddNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientAlert createNewPatient = new PatientAlert(getFrame());

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

	public void updatePatientPanel(Patient patient) {

		label.setText("Name:" + patient.getName());

		label_1.setText("Age: " + patient.getAge());

		label_2.setText("Address: " + patient.getAddress());

		label_3.setText("Phone Number: " + patient.getPhoneNumber());

		label_4.setText("Birthdate: " + patient.getBirthdate());

		label_5.setText("Employer: " + patient.getEmployer());

		label_6.setText("Insurance: " + patient.getInsurance());

	}

	public void updatePatientList() {

		patientList.setListData(createPatientNames());
	}

	// Getters and Setters
	public PatientListFrame getFrame() {
		return this;
	}

}
