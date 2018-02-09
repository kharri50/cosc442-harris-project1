package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameBoardProduct.
 */
public class GameBoardProduct {
	
	/** The cells. */
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	
	/** The color groups. */
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();

	/**
	 * Gets the cells.
	 *
	 * @return the cells
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * Gets the cell.
	 *
	 * @param newIndex the new index
	 * @return the cell
	 */
	public Cell getCell(int newIndex) {
		return (Cell) cells.get(newIndex);
	}

	/**
	 * Gets the cell number.
	 *
	 * @return the cell number
	 */
	public int getCellNumber() {
		return cells.size();
	}

	/**
	 * Query cell.
	 *
	 * @param string the string
	 * @return the cell
	 */
	public Cell queryCell(String string) {
		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * Query cell index.
	 *
	 * @param string the string
	 * @return the int
	 */
	public int queryCellIndex(String string) {
		for (int i = 0; i < cells.size(); i++) {
			IOwnable temp = (IOwnable) cells.get(i);
			if (temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the property number for color.
	 *
	 * @param name the name
	 * @return the property number for color
	 */
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer) colorGroups.get(name);
		if (number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Adds the cell.
	 *
	 * @param cell the cell
	 */
	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
		cells.add(cell);
	}

	/**
	 * Gets the properties in monopoly.
	 *
	 * @param color the color
	 * @return the properties in monopoly
	 */
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < getCellNumber(); i++) {
			IOwnable c = getCell(i);
			if (c instanceof PropertyCell) {
				PropertyCell pc = (PropertyCell) c;
				if (pc.getColorGroup().equals(color)) {
					monopolyCells[counter] = pc;
					counter++;
				}
			}
		}
		return monopolyCells;
	}
}