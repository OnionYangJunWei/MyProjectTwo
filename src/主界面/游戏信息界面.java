package 主界面;

import 贪吃蛇.StartGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 游戏信息界面 {
    //创建一个窗口界面
    JFrame jf = new JFrame("游戏信息界面");


    //创建一个文本域
    JTextArea jt = new JTextArea(20,30);

    //创建一个返回按钮
    JButton btn = new JButton("返回到主界面");

    //创建一个存放文本域的盒子
    Box box = Box.createHorizontalBox();
    //创建一个存放的盒子
    Box box1 = Box.createHorizontalBox();

    //创建一个主盒子
    Box allbox = Box.createVerticalBox();

    //创建一个显示的方法
    public void show(){
        //将文本域添加到对应的盒子中
        box.add(jt);

        //将按钮添加到对应的盒子中
        box1.add(btn);

        //将所有盒子添加到主盒子中
        allbox.add(box);
        allbox.add(Box.createVerticalStrut(10));
        allbox.add(box1);


        //创建一个Jpanel容器存放所有的盒子

        JPanel jp = new JPanel();

        jp.add(allbox);
        jt.setText("游戏版本号：2021.12.12");


        //将jp容器添加到窗口中
        jf.add(jp);

        jf.setBounds(400,200,400,400);

        jf.setVisible(true);

        //创建按钮的点击方法
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 主界面().xuanze();
                jf.dispose();
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //创建一个方法测试本页代码是否正常运行
    public static void main(String[] args) {
        new 游戏信息界面().show();
    }
}
