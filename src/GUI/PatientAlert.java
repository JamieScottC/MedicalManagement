package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Management.Patient;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class PatientAlert extends JDialog {

	private static final long serialVersionUID = -5655586865922896598L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtBirthdate;
	private JTextField txtEmployer;
	private JTextField txtInsurance;
	private JTextField txtSsn;
	private JLabel lblPleaseEnterA;

	/**
	 * Create the dialog.
	 */
	public PatientAlert(final PatientListFrame pLFrame) {
		setModal(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 500, 538);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		try {
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}
		{
			// Ok button to add new patient, checks if birthdate is valid and
			// updates PatientListFrame
			JButton okBtn = new JButton("Ok");
			okBtn.setBounds(165, 483, 80, 23);
			okBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isValidDate(txtBirthdate.getText())) {
						lblPleaseEnterA.setVisible(false);
						new Patient(txtName.getText(), txtAddress.getText(), txtPhoneNumber.getText(),
								txtBirthdate.getText(), txtEmployer.getText(), txtInsurance.getText(),
								txtSsn.getText());
						pLFrame.updatePatientList();
						pLFrame.revalidate();
						pLFrame.repaint();
						setVisible(false);
						dispose();

					} else {
						lblPleaseEnterA.setVisible(true);
					}
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(okBtn);
			okBtn.setActionCommand("OK");
			getRootPane().setDefaultButton(okBtn);
		}
		{
			// Cancels adding new patient
			JButton cancelBtn = new JButton("Cancel");
			cancelBtn.setBounds(247, 483, 80, 23);
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					setVisible(false);
					dispose();
				}
			});
			contentPanel.add(cancelBtn);
			cancelBtn.setActionCommand("Cancel");
		}

		JLabel lblAreYourSure = new JLabel("Please enter in all fields below");
		lblAreYourSure.setBounds(15, 19, 424, 34);
		lblAreYourSure.setVerticalAlignment(SwingConstants.TOP);
		lblAreYourSure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreYourSure.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblAreYourSure);
		{
			txtName = new JTextField();
			txtName.setText("Name");
			txtName.setBounds(15, 60, 86, 20);
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			txtAddress = new JTextField();
			txtAddress.setText("Address");
			txtAddress.setBounds(15, 100, 86, 20);
			contentPanel.add(txtAddress);
			txtAddress.setColumns(10);
		}
		{
			txtPhoneNumber = new JTextField();
			txtPhoneNumber.setText("Phone Number");
			txtPhoneNumber.setBounds(15, 140, 86, 20);
			contentPanel.add(txtPhoneNumber);
			txtPhoneNumber.setColumns(10);
		}
		{
			txtBirthdate = new JTextField();
			txtBirthdate.setText("Birthdate");
			txtBirthdate.setBounds(15, 180, 86, 20);
			contentPanel.add(txtBirthdate);
			txtBirthdate.setColumns(10);
		}
		{
			txtEmployer = new JTextField();
			txtEmployer.setText("Employer");
			txtEmployer.setBounds(15, 220, 86, 20);
			contentPanel.add(txtEmployer);
			txtEmployer.setColumns(10);
		}
		{
			txtInsurance = new JTextField();
			txtInsurance.setText("Insurance");
			txtInsurance.setBounds(15, 260, 86, 20);
			contentPanel.add(txtInsurance);
			txtInsurance.setColumns(10);
		}
		{
			txtSsn = new JTextField();
			txtSsn.setText("SSN");
			txtSsn.setBounds(15, 300, 86, 20);
			contentPanel.add(txtSsn);
			txtSsn.setColumns(10);

		}
		{
			lblPleaseEnterA = new JLabel("Please Enter a Valid Birthdate");
			lblPleaseEnterA.setForeground(new Color(255, 0, 0));
			lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPleaseEnterA.setBounds(158, 441, 215, 14);
			lblPleaseEnterA.setVisible(false);
			contentPanel.add(lblPleaseEnterA);

			setVisible(true);
		}
	}

	//Static because they are re-useable in other classes
	// Check if <code>date</code> is valid
	public static boolean isValidDate(String date) {
		if (date.charAt(2) != '/' || date.charAt(5) != '/' || !isNumber(date.substring(6))) {
			return false;
		}

		return true;
	}

	// Check if <code>str</code> is a number
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}


