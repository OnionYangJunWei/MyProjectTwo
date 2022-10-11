package 贪吃蛇;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class 死亡后输入信息界面 {
    //创建一个窗口对象
    JFrame jf  = new JFrame("游戏结束");
    //创建组件
    JLabel shuru = new JLabel("请输入你的姓名");

    JButton btn = new JButton("确定");
    JButton btn1 = new JButton("取消");

    //创建一个收纳积分的盒子
    Box box = Box.createHorizontalBox();
    //创建一个收纳输入姓名的盒子
    Box box1 = Box.createHorizontalBox();

    //创建一个收纳按钮的盒子
    Box box2 = Box.createHorizontalBox();
    //创建一个显示组装的方法
    public void show( int score){

        //创建一个组件
        JLabel jifen = new JLabel("你的积分是:"+score);
        JTextField jt = new JTextField(10);


        System.out.println("测试");
        System.out.println(jt.getText().trim());
        System.out.println("ceshi");
        //组装积分盒子
        box.add(jifen);
        //组装收纳姓名的盒子
        box1.add(shuru);
        box1.add(Box.createVerticalStrut(10));
        box1.add(jt);
        box1.add(Box.createVerticalStrut(10));

        box2.add(btn);
        box2.add(Box.createHorizontalStrut(20));
        box2.add(btn1);


        //创建一个Jpanel容器
        JPanel jp = new JPanel();

        //将组件添加到jpanel容器中去
        jp.add(box);
        jp.add(box1);
        jp.add(box2);
        //将jpanel容器添加到窗口中
        jf.add(jp);

        //设置基础的窗口设置
        jf.setBounds(400,300,300,150);
        jf.setVisible(true);
        //设置窗口点击X关闭退出程序
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        //实现点击弹出框的确认按钮
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //创建一个变量接收文本框中输入的值
                    String name = jt.getText();
                    System.out.println(name);
                    new DataBase().add(name,score);//将值传入到数据库
                    jf.dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        //实现点击弹出框取消的按钮
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
    }

    //测试本页面
    public static void main(String[] args) {
        死亡后输入信息界面 s = new 死亡后输入信息界面();
        s.show(20);
        DataBase d = new DataBase();

    }

}
