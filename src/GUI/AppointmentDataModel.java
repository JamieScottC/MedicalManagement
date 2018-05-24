package GUI;

import javax.swing.table.DefaultTableModel;

import Management.Patient;

public class AppointmentDataModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9005049384635839070L;
	private String[] columnNames = {"Date", "Time", "Reason"};
	private String[][] data;
	private int rowCount = 3;
	public AppointmentDataModel(Patient patient){
			data = new String[patient.getAppointments().size()][3];
			for(int i = 0; i < patient.getAppointments().size(); i++){
				data[i][0] = patient.getAppointments().get(i).getDate(); 
			}
			for(int i = 0; i < patient.getAppointments().size(); i++){
				data[i][1] = patient.getAppointments().get(i).getTime(); 
			}
			for(int i = 0; i < patient.getAppointments().size(); i++){
				data[i][2] = patient.getAppointments().get(i).getReason(); 
			}
		}
	
	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		
		return rowCount;
	}
	public void setRowCount(int rowCount){
		this.rowCount = rowCount;
	}
	

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void setData(String[][] data){
		this.data = data;
	}
}


