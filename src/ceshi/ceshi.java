package ceshi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ceshi {
    public static void main(String[] args) {
        JFrame jf = new JFrame("测试");
        JTextField jt = new JTextField(10);
        JButton btn = new JButton("确定");
        Box box = Box.createHorizontalBox();
        box.add(jt);
        box.add(btn);
        jf.add(box);

        jf.pack();
        jf.setVisible(true);
        String name = jt.getText();



        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(name);
            }
        });


    }
}
