/*
 * Created by JFormDesigner on Thu Dec 07 00:53:52 CST 2017
 */

package com.shigure.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author siyuan zheng
 */
public class About extends JFrame {
    public About() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        //======== this ========
        setTitle("\u5173\u4e8e");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f5c\u8005\uff1a\u90d1\u601d\u8fdc");
        label1.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
        contentPane.add(label1);
        label1.setBounds(80, 60, label1.getPreferredSize().width, 25);

        //---- label2 ----
        label2.setText("\u8054\u7cfb\u65b9\u5f0f\uff1asiyuan@shigure.me");
        label2.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(80, 125), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7f51\u7ad9\uff1awww.shigure.me");
        label3.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
        contentPane.add(label3);
        label3.setBounds(80, 190, label3.getPreferredSize().width, 25);
        contentPane.add(label4);
        label4.setBounds(0, 0, 450, 280);

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
