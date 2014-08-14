import javax.swing.table.AbstractTableModel;


public class BookTableModel extends AbstractTableModel {

	private Client client;
	
	public BookTableModel(Client c) {
		client = c;
	}
	
	@Override
	public int getRowCount() {
		return client.bookCount();
	}

	@Override
	public int getColumnCount() {
		return Book.DATA_NAMES.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return Book.DATA_NAMES[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return client.getBook(rowIndex).asArray()[columnIndex];
	}

}
