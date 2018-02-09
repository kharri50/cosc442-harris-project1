package edu.towson.cis.cosc442.project1.monopoly;


import java.util.ArrayList;
import java.util.Hashtable;

public class GameBoardProduct {
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public Cell getCell(int newIndex) {
		return (Cell) cells.get(newIndex);
	}

	public int getCellNumber() {
		return cells.size();
	}

	public Cell queryCell(String string) {
		for (int i = 0; i < cells.size(); i++) {
			Cell temp = (Cell) cells.get(i);
			if (temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}

	public int queryCellIndex(String string) {
		for (int i = 0; i < cells.size(); i++) {
			IOwnable temp = (IOwnable) cells.get(i);
			if (temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer) colorGroups.get(name);
		if (number != null) {
			return number.intValue();
		}
		return 0;
	}

	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
		cells.add(cell);
	}

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