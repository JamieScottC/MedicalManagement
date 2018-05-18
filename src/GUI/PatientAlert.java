package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Management.Patient;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientAlert extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public PatientAlert(Patient patient, final JFrame patientListFrame) {
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.POPUP);
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
			JButton yesBtn = new JButton("Yes");
			yesBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					//Get rid of patient List Frame as well
					patientListFrame.setVisible(false);
					patientListFrame.dispose();
					PatientFrame pFrame = new PatientFrame(patient);
					pFrame.setVisible(true);
				}
			});
			yesBtn.setBounds(171, 61, 65, 23);
			contentPanel.add(yesBtn);
			yesBtn.setActionCommand("OK");
			getRootPane().setDefaultButton(yesBtn);
		}
		{
			JButton noBtn = new JButton("No");
			noBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			noBtn.setBounds(242, 61, 65, 23);
			contentPanel.add(noBtn);
			noBtn.setActionCommand("Cancel");
		}

		JLabel lblAreYourSure = new JLabel("Are your sure you would like to view Patient " + patient.getName());
		lblAreYourSure.setVerticalAlignment(SwingConstants.TOP);
		lblAreYourSure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAreYourSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYourSure.setBounds(47, 11, 387, 34);
		contentPanel.add(lblAreYourSure);

	}
}
