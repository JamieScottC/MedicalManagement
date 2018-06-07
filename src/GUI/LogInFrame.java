package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import face.FaceCompare;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdPassword;
	private JButton btnEnter;
	private final char[] correctPassword = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private JLabel lblPleaseEnterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame frame = new LogInFrame();
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
	public LogInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setBounds(208, 150, 108, 20);
		contentPane.add(pwdPassword);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(133, 150, 77, 17);
		contentPane.add(lblPassword);

		JButton btnUseFacialRecognition = new JButton("Use Facial Recognition");
		btnUseFacialRecognition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double correlationNumber = new FaceCompare().getCorrelationOfFeatures();
				if (correlationNumber > 0.6) {
					// When button clicked open new frame
					setVisible(false);
					dispose();
					HomeFrame hf = new HomeFrame();
					hf.getFrame().setVisible(true);
				}
			}
		});
		btnUseFacialRecognition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUseFacialRecognition.setBounds(478, 147, 183, 23);
		contentPane.add(btnUseFacialRecognition);

		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(pwdPassword.getPassword());
				if (Arrays.equals(pwdPassword.getPassword(), correctPassword)) {
					setVisible(false);
					dispose();
					HomeFrame hf = new HomeFrame();
					hf.getFrame().setVisible(true);

				} else {

				}
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnter.setBounds(161, 181, 89, 23);
		contentPane.add(btnEnter);
		
		lblPleaseEnterPassword = new JLabel("Please Enter Password or Use Facial Recognition to Enter");
		lblPleaseEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPleaseEnterPassword.setBounds(114, 11, 621, 95);
		contentPane.add(lblPleaseEnterPassword);
	}
}
