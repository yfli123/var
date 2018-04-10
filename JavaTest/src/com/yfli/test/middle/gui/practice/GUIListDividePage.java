package com.yfli.test.middle.gui.practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.yfli.test.middle.gui.GUIHeroTableModel;
import com.yfli.test.middle.jdbc.JDBCHeroDAO;
import com.yfli.test.middle.lambda.Hero;
  
  
public class GUIListDividePage {
  
    static GUIHeroTableModel htm = new GUIHeroTableModel();
    static JTable t = new JTable(htm);
  
    // �ѷ�ҳ��ť�����������������÷���
    static JButton bFirst = new JButton("��ҳ");
    static JButton bPre = new JButton("��һҳ");
    static JButton bNext = new JButton("��һҳ");
    static JButton bLast = new JButton("ĩҳ");
    static JComboBox<Integer> cb = new JComboBox<>();
  
    static int number = 10;// ÿҳ��ʾ10��
    static int start = 0;// ��ʼ��ҳ��
    private static boolean cbListenerEnabled = true;
  
    public static void main(String[] args) {
  
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 340);
        f.setLocation(200, 200);
  
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  
        t.getSelectionModel().setSelectionInterval(0, 0);
  
        JPanel pOperation = new JPanel();
  
        JButton bAdd = new JButton("����");
        JButton bDelete = new JButton("ɾ��");
        JButton bEdit = new JButton("�༭");
        pOperation.add(bAdd);
        pOperation.add(bDelete);
        pOperation.add(bEdit);
  
        JPanel pPage = new JPanel();
  
        pPage.add(bFirst);
        pPage.add(bPre);
        pPage.add(cb);
          
        pPage.add(bNext);
        pPage.add(bLast);
  
        bEdit.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                // �ж��Ƿ�ѡ��
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "�༭ǰ��Ҫ��ѡ��һ��");
                    return;
                }
  
                // ��ȡѡ�еĶ���
                Hero hero = htm.heros.get(index);
  
                // ��ʾ�༭Dialog
  
                EditDialog ed = new EditDialog(f);
                ed.tfName.setText(hero.name);
                ed.tfHp.setText(String.valueOf((int) hero.hp));
  
                ed.setVisible(true);
  
            }
        });
  
        bAdd.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
                 
                updateButtonStatus();
            }
        });
        bDelete.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
  
                // �ж��Ƿ�ѡ��
                int index = t.getSelectedRow();
                if (-1 == index) {
                    JOptionPane.showMessageDialog(f, "ɾ��ǰ��Ҫ��ѡ��һ��");
                    return;
                }
  
                // ����ȷ���Ƿ�Ҫɾ��
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "ȷ��Ҫɾ����"))
                    return;
  
                // ��ȡid
                Hero hero = htm.heros.get(index);
                int id = hero.id;
  
                // ɾ��
                new JDBCHeroDAO().delete(id);
  
                // ����table
                start = 0;
                updateTable();
                updateButtonStatus();
  
            }
        });
  
        addPageListener();
          
        cb.addActionListener(new ActionListener() {
              
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cbListenerEnabled)
                    return;
                  
                int currentPage = (int) cb.getSelectedItem();
                start = (currentPage-1)*number;
                updateTable();
                updateButtonStatus();
                  
            }
        });
  
        JScrollPane sp = new JScrollPane(t);
  
        f.setLayout(null);
        sp.setBounds(0, 0, 394, 200);
        pOperation.setBounds(0, 200, 394, 50);
        pPage.setBounds(0, 250, 394, 200);
        f.add(sp);
        f.add(pOperation);
        f.add(pPage);
        updateButtonStatus();
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
  
    private static void addPageListener() {
  
        bFirst.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                start = 0;
                updateTable();
                updateButtonStatus();
            }
        });
        bPre.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                start -= number;
                updateTable();
                updateButtonStatus();
            }
        });
        bNext.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                start += number;
                updateTable();
                updateButtonStatus();
            }
        });
        bLast.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                  
                start = last();
  
                updateTable();
                  
                updateButtonStatus();
                  
            }
  
        });
  
    }
  
    private static void updateButtonStatus() {
        int last = last();
  
        // �Ƿ�����һҳ
        if (0 != start) {
            bFirst.setEnabled(true);
            bPre.setEnabled(true);
        }
  
        // �Ƿ��ǵ�һҳ
        if (0 == start) {
            bFirst.setEnabled(false);
            bPre.setEnabled(false);
        }
  
        // �Ƿ������һҳ
        if (start == last) {
            bLast.setEnabled(false);
            bNext.setEnabled(false);
        }
        // �Ƿ�����һҳ
        if (start < last) {
            bLast.setEnabled(true);
            bNext.setEnabled(true);
        }
          
        //�ܹ���ҳ��
        int pageNumber =last/number+1;
        cbListenerEnabled = false;
        cb.removeAllItems();
  
        for (int i = 0; i < pageNumber; i++) {
  
            cb.addItem(i+1);
        }
        cbListenerEnabled = true;
          
        int currentPage = start/number +1;
        cb.setSelectedItem(currentPage);
  
    }
  
    static class AddDialog extends JDialog {
        JLabel lName = new JLabel("����");
        JLabel lHp = new JLabel("Ѫ��");
  
        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
  
        JButton bSubmit = new JButton("�ύ");
  
        AddDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
  
            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();
  
            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
  
            pSubmit.add(bSubmit);
  
            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);
  
            this.add(pInput);
            this.add(pSubmit);
  
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            bSubmit.addActionListener(new ActionListener() {
  
                @Override
                public void actionPerformed(ActionEvent e) {
  
                    if (checkEmpty(tfName, "����")) {
                        if (checkNumber(tfHp, "hp")) {
  
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
  
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
  
                            new JDBCHeroDAO().add(h);
  
                            JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
  
                            AddDialog.this.setVisible(false);
                            start = 0;
                            updateTable();
                        }
                    }
  
                }
            });
  
        }
    }
  
    public static void updateTable() {
        htm.heros = new JDBCHeroDAO().list(start, number);
        t.updateUI();
        if (!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }
  
    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }
  
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if (0 == value.length()) {
            JOptionPane.showMessageDialog(null, msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, msg + " ֻ��������");
            tf.grabFocus();
            return false;
        }
  
        return true;
    }
  
    static class EditDialog extends JDialog {
        JLabel lName = new JLabel("����");
        JLabel lHp = new JLabel("Ѫ��");
  
        JTextField tfName = new JTextField();
        JTextField tfHp = new JTextField();
  
        JButton bSubmit = new JButton("�ύ");
  
        EditDialog(JFrame f) {
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
  
            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();
  
            pInput.setLayout(new GridLayout(2, 2, gap, gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
  
            pSubmit.add(bSubmit);
  
            pInput.setBounds(50, 20, 200, 100);
            pSubmit.setBounds(0, 130, 300, 150);
  
            this.add(pInput);
            this.add(pSubmit);
  
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
  
            bSubmit.addActionListener(new ActionListener() {
  
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkEmpty(tfName, "����")) {
                        if (checkNumber(tfHp, "hp")) {
  
                            // ��ȡid
                            int index = t.getSelectedRow();
                            int id = htm.heros.get(index).id;
  
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
  
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                            h.id = id;
  
                            new JDBCHeroDAO().update(h);
  
                            JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
  
                            EditDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
  
                }
            });
        }
    }
  
    private static int last() {
        // ���һҳ��ʼ��λ��
        int last;
  
        int total = new JDBCHeroDAO().getTotal();
  
        // ���һҳҪ�������Ƿ��ܹ�����ÿҳ��ʾ������number
  
        if (0 == total % number) {
            // ����������20����ô���һҳ��ʼ��λ�þ���10
            last = total - number;
        } else {
            // ����������21����ô���һҳ��ʼ��λ�þ���20
            last = total - total % number;
        }
        return last;
  
    }
}
