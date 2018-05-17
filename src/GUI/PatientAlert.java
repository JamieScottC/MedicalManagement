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

public class PatientAlert extends JDialog {

	private final JPanel contentPanel = new JPanel();

	

	/**
	 * Create the dialog.
	 */
	public PatientAlert(Patient patient) {
		setType(Type.UTILITY);
		setBounds(100, 100, 500, 145);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		try {
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Yes");
			okButton.setBounds(171, 61, 65, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("No");
			cancelButton.setBounds(242, 61, 65, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblAreYourSure = new JLabel("Are your sure you would like to view Patient " + patient.getName());
		lblAreYourSure.setVerticalAlignment(SwingConstants.TOP);
		lblAreYourSure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAreYourSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYourSure.setBounds(47, 11, 387, 34);
		contentPanel.add(lblAreYourSure);
		
	}
}
