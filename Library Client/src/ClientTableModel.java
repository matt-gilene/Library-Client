import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class ClientTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 2265935259131137069L;
	
	private ArrayList<Client> clients;
	
	public ClientTableModel() {
		clients = new ArrayList<Client>();
	}
	
	public void addClient(Client c) {
		clients.add(c);
		this.fireTableDataChanged();
	}
	
	public void removeClient(Client c) {
		if(clients.contains(c)) {
			clients.remove(c);
			this.fireTableDataChanged();
		}
	}
	
	public Client getClient(int r) {
		return clients.get(r);
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public int getColumnCount() {
		return Client.DATA_NAMES.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return Client.DATA_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return clients.get(rowIndex).asArray()[columnIndex];
	}
}
