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
	public PatientAlert() {
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
		contentPanel.setLayout(null);
		{
			JButton okBtn = new JButton("Ok");
			okBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			okBtn.setBounds(154, 475, 65, 23);
			contentPanel.add(okBtn);
			okBtn.setActionCommand("OK");
			getRootPane().setDefaultButton(okBtn);
		}
		{
			JButton cancelBtn = new JButton("Cancel");
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			cancelBtn.setBounds(242, 475, 65, 23);
			contentPanel.add(cancelBtn);
			cancelBtn.setActionCommand("Cancel");
		}

		JLabel lblAreYourSure = new JLabel("Please enter in all fields below");
		lblAreYourSure.setVerticalAlignment(SwingConstants.TOP);
		lblAreYourSure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreYourSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYourSure.setBounds(47, 11, 387, 34);
		contentPanel.add(lblAreYourSure);
		setVisible(true);
	}
}
