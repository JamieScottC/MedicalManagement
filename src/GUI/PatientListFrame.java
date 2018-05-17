package GUI;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
		
		
		String[] patientNames = createPatientNames(new String[Patient.patients.size()]);
		
		JList list = new JList(patientNames);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.LIGHT_GRAY);
		list.setForeground(Color.BLACK);
		list.setBounds(10, 11, 145, 239);
		list.setLayoutOrientation(JList.VERTICAL);
	
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setForeground(Color.BLACK);
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(10, 64, 209, 375);
		scrollBar.setViewportView(list);
		contentPane.add(scrollBar);
		
		
		  list.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent le) {
		        int i = list.getSelectedIndex();
		        if (i != -1){
		          
		        }
		      }
		    });
	}
	//Create array of Patient names and organize
	private String[] createPatientNames(String[] patientNames) {
		for(int i = 0; i < Patient.patients.size(); i++){
			patientNames[i] = Patient.patients.get(i).getName();
		}
		return patientNames;
	}
}
