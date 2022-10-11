package ceshi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class 测试如何从匿名内部类取值2 {

    JFrame jf =new JFrame("Cejsi");

    JButton btn = new JButton("ok");

    String name;

    ArrayList<String> list = new ArrayList<>();


    public void show(){
        jf.add(btn);

        jf.setBounds(200,200,200,200);
        jf.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =  "难度";
                list.add(name);
                ceshi();

            }
        });


    }

    public void ceshi(){
        String name = list.get(0);
        System.out.println(name);
    }

    public static void main(String[] args) {
        new 测试如何从匿名内部类取值2().show();
    }
}
