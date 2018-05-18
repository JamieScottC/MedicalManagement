package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Management.Patient;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class PatientFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientFrame frame = new PatientFrame(new Patient());
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
	public PatientFrame(Patient patient) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameLabel.setBounds(10, 50, 267, 17);
		contentPane.add(nameLabel);
		
		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ageLabel.setBounds(10, 90, 267, 21);
		contentPane.add(ageLabel);
		
		JLabel addressLabel = new JLabel("Address: ");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addressLabel.setBounds(10, 130, 267, 17);
		contentPane.add(addressLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number: ");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phoneNumberLabel.setBounds(10, 170, 267, 17);
		contentPane.add(phoneNumberLabel);
		
		JLabel birthdateLabel = new JLabel("Birthdate: ");
		birthdateLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		birthdateLabel.setBounds(10, 210, 235, 17);
		contentPane.add(birthdateLabel);
		
		JLabel employerLabel = new JLabel("Employer: ");
		employerLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		employerLabel.setBounds(10, 250, 235, 17);
		contentPane.add(employerLabel);
		
		JLabel insuranceLabel = new JLabel("Insurance: ");
		insuranceLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		insuranceLabel.setBounds(10, 290, 267, 17);
		contentPane.add(insuranceLabel);
	}

}
