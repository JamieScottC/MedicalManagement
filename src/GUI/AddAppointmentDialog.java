package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Management.Appointment;
import Management.Patient;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class AddAppointmentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtReason;
	private JLabel lblValidDate;

	/**
	 * Create the dialog.
	 */
	public AddAppointmentDialog(final Patient patient,
			final PatientListFrame pLFrame) {
		setModal(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 400, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Content Panel
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtDate = new JTextField();
			txtDate.setText("Date");
			contentPanel.add(txtDate);
			txtDate.setColumns(10);
		}
		{
			txtTime = new JTextField();
			txtTime.setText("Time");
			contentPanel.add(txtTime);
			txtTime.setColumns(10);
		}
		{
			txtReason = new JTextField();
			txtReason.setText("Reason");
			contentPanel.add(txtReason);
			txtReason.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (PatientAlert.isValidDate(txtDate.getText())) {
							lblValidDate.setVisible(false);
							patient.getAppointments().add(
									new Appointment(txtDate.getText(), txtTime
											.getText(), txtReason.getText()));

							pLFrame.updatePatientList();
							pLFrame.revalidate();
							pLFrame.repaint();
							setVisible(false);
							dispose();

						} else {
							lblValidDate.setVisible(true);
						}
					}
				});
				{
					lblValidDate = new JLabel("Please Enter a Valid Date");
					lblValidDate.setForeground(new Color(255, 0, 0));
					lblValidDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblValidDate.setHorizontalAlignment(SwingConstants.LEFT);
					lblValidDate.setVisible(false);
					buttonPane.add(lblValidDate);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
