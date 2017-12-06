/*
 * Created by JFormDesigner on Wed Dec 06 00:08:05 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookBorrowDao;
import com.shigure.model.Book;
import com.shigure.model.BookBorrow;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class ReaderBorrowManage extends JFrame {
    static int borrowId = 0;
    BookBorrowDao bookBorrowDao = new BookBorrowDao();
    public ReaderBorrowManage() {
        initComponents();
        this.fillTable(new BookBorrow());
    }

    private void fillTable(BookBorrow bookBorrow){
        int userId = ReaderDashBoard.uid;
        DefaultTableModel dtm = (DefaultTableModel) borrowTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookBorrowDao.borrowList(con,bookBorrow);
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getInt("borrowId"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getFloat("price"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("borrowTime"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_deleteActionPerformed(ActionEvent e) {
        int borrowId = ReaderBorrowManage.borrowId;
        if(borrowId == 0){
            JOptionPane.showMessageDialog(null,"请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
        if(n==0){
            Connection con = null;
            try {
                con= getConnection();
                int deleteNum = bookBorrowDao.borrowDelete(con,borrowId);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.fillTable(new BookBorrow());
                }else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"删除失败");
            }finally {
                free(con);
            }
        }
    }


    private void borrowTableMousePressed(MouseEvent e) {
        int row = this.borrowTable.getSelectedRow();
        ReaderBorrowManage.borrowId = Integer.parseInt(String.valueOf(borrowTable.getValueAt(row,0)));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        scrollPane1 = new JScrollPane();
        borrowTable = new JTable();
        jb_delete = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- borrowTable ----
            borrowTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "\u501f\u9605\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u7c7b\u522b", "\u501f\u9605\u65e5\u671f"
                }
            ));
            {
                TableColumnModel cm = borrowTable.getColumnModel();
                cm.getColumn(5).setPreferredWidth(160);
            }
            borrowTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    borrowTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(borrowTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 55, 520, 230);

        //---- jb_delete ----
        jb_delete.setText("text");
        jb_delete.addActionListener(e -> jb_deleteActionPerformed(e));
        contentPane.add(jb_delete);
        jb_delete.setBounds(new Rectangle(new Point(320, 340), jb_delete.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - siyuan zheng
    private JScrollPane scrollPane1;
    private JTable borrowTable;
    private JButton jb_delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}