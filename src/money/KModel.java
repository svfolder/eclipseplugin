/**
 * 
 */
package money;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

//www.sbp-program.ru

/**
 * @author Администратор
 * 
 */
public class KModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	// Имена колонок;
	protected Vector<String> columnNames;
	
	// Данные;
	private Vector<Vector<Object>> tableData;
	
	// Классы колонок;
	protected Vector<Object> vColClass;

	public KModel() {
		super();
		vColClass = new Vector<Object>();
		vColClass.add(0, Integer.class);
		vColClass.add(1, String.class);
		columnNames = new Vector<String>();
		columnNames.add("Номер");
		columnNames.add("Наименование");
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return getTableData().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return getTableData().get(row).get(column);
	}

	// Показывать заголовки колонок;
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	// Запрещаем редактировать первую колонку (счёт колонок идёт с нуля);
	public boolean isCellEditable(int row, int column) {
		if (column == 0) {
			return false;
		}
		return true;

	}

	public void setValueAt(Object obj, int row, int column) {
		if (column == 0) {
			(getTableData().get(row)).set(column, (Integer) obj);
		} else if (column == 1) {
			(getTableData().get(row)).set(column, (String) obj);
		}
		fireTableCellUpdated(row, column);
	}

	public Class<?> getColumnClass(int col) {
		Class<?> c = Object.class;
		try {
			c = (Class<?>) vColClass.get(col);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		return c;
	}

	public void setTableData(Vector<Vector<Object>> tableData) {
		this.tableData = tableData;
	}

	public Vector<Vector<Object>> getTableData() {
		return tableData;
	}

}
