package com.yfli.test.middle.gui;

import javax.swing.table.AbstractTableModel;

public class GUITableModel extends AbstractTableModel {
 
    String[] columnNames = new String[] { "id", "name", "hp", "damage" };
    String[][] heros = new String[][] { { "1", "����", "616", "100" },
            { "2", "��Ī", "512", "102" }, { "3", "����", "832", "200" } };
 
    // ����һ���ж�����
    public int getRowCount() {
        // TODO Auto-generated method stub
        return heros.length;
    }
 
    // ����һ���ж�����
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    // ��ȡÿһ�е�����
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    // ��Ԫ���Ƿ�����޸�
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // ÿһ����Ԫ�����ֵ
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return heros[rowIndex][columnIndex];
    }
 
}
