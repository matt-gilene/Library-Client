import java.awt.Dimension;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class LibraryClient extends JFrame {

	private static final long serialVersionUID = 5153752319840062711L;

	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenu edit;
	private JMenu view;
	
	private JMenuItem exit;
	private JMenuItem newClient;
	
	private JTable clientTable;
	private ClientTableModel clientModel;
	
	private JTable bookTable;
	private BookTableModel bookModel;
	
	
	public LibraryClient() {
		buildMenuBar();
		openClientTable();
		
		clientModel.addClient(new Client("Matt", 18));
		
		setPreferredSize(new Dimension(500,500));
		pack();
		setVisible(true);
	}
	
	private void buildMenuBar() {
		if(menuBar == null) {
			menuBar = new JMenuBar();
		}
		if(file == null) {
			file = new JMenu();
			file.setText("File");
		}
		if(edit == null) {
			edit = new JMenu();
			edit.setText("Edit");
		}
		if(view == null) {
			view = new JMenu();
			view.setText("View");
		}
		if(exit == null) {
			exit = new JMenuItem();
			exit.setText("Exit");
			exit.addActionListener((e) -> System.exit(0));
		}
		if(newClient == null) {
			newClient = new JMenuItem();
			newClient.setText("New Client");
			newClient.addActionListener((e) -> clientModel.addClient(new Client("Matt", 13)));
		}
		setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(view);
		file.add(newClient);
		file.add(new JSeparator());
		file.add(exit);
	}
	
	private void buildClientTable() {
		clientTable = new JTable();
		clientTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point p = e.getPoint();
				int row = ((JTable) e.getSource()).rowAtPoint(p);
				if(e.getClickCount() == 2) {
					openBookTable(clientModel.getClient(row));
				}
			}
		});
		clientModel = new ClientTableModel();
		clientTable.setModel(clientModel);
	}
	
	private void buildBookTable(Client c) {
		bookTable = new JTable();
		bookModel = new BookTableModel(c);
		bookTable.setModel(bookModel);
	}
	
	private void openClientTable() {
		buildClientTable();
		setTableView(clientTable);
	}
	
	private void openBookTable(Client c) {
		buildBookTable(c);
		setTableView(bookTable);
	}
	
	private void setTableView(JTable t) {
		this.getContentPane().removeAll();
		this.getContentPane().add(new JScrollPane(t));
		this.revalidate();
		this.repaint();
	}
}
