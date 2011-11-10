package money;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Toolkit;
import java.rmi.server.UID;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class Money {

	private JTable table;
	private KModel model;
	private KFDB baza;
	
	private JFrame frame;
	private JTable table_1;

	private int xcvb ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Money window = new Money();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Money() throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws InstantiationException, Exception, IllegalAccessException, UnsupportedLookAndFeelException {
		
		frame = new JFrame("Тест Моней");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Money.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		frame.setBounds(100, 100, 450, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName()  );
		} catch (Exception ex) {
			
		}
		
		
		JButton btnAddRecord = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0440\u0430\u0441\u0445\u0434");
		btnAddRecord.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "6666");
				
				
			}
			
		});
		
		
		btnAddRecord.setBounds(10, 11, 136, 23);
		frame.getContentPane().add(btnAddRecord);
		
		//JTable newTable = this.InitDbase();
		
		//JScrollPane scrollPane = new JScrollPane( newTable );
		
		JScrollPane scrollPane = new JScrollPane( );
		scrollPane.setBounds(10, 73, 422, 241);
		frame.getContentPane().add(scrollPane);
		
		
		//Не забудьте указать вашего пользователя и пароль (у меня "root" и "masterkey" соответственно);
		baza = new KFDB("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/money", "root", "");
		model = new KModel();
		
		model.setTableData(baza.getNomen("SELECT * FROM java_money"));
		
		
		table_1 = new JTable(model);
		table_1.setBackground(Color.ORANGE);
		table_1.getColumnModel().getColumn(0).setMaxWidth(50);
		
		table_1.setBorder(new LineBorder(Color.RED, 3));
		scrollPane.setViewportView(table_1);
		
	}
	
	
	public JTable InitDbase(){

		
		//Не забудьте указать вашего пользователя и пароль (у меня "root" и "masterkey" соответственно);
		baza = new KFDB("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/money", "root", "");
		model = new KModel();
		
		//System.err.println( baza );
		
		model.setTableData(baza.getNomen("SELECT * FROM java_money"));
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		
		//frame.setContentPane( new JScrollPane(table));
		
		return table;
		
	}
}
