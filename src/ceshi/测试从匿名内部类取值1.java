package ceshi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class 测试从匿名内部类取值1 {
    JFrame jf = new JFrame("ceshi");
    JButton btn = new JButton("点击");



     String  name;



    public void show(){
        jf.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name="吃啥";

            }
        });

        jf.setBounds(200,200,200,200);

        jf.setVisible(true);
        System.out.println(name);
    }

    public void cehi(String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        测试从匿名内部类取值1 s  = new 测试从匿名内部类取值1();
        s.show();
    }
}

