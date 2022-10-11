package 主界面;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class 记录排行榜 {
    //创建一个窗口对象
    JFrame jf = new JFrame("游戏记录");


    //    创建一个菜单
    JMenuBar jmb = new JMenuBar();


    //1级
    JMenu jm1 = new JMenu("菜单");
    JMenu jm2 = new JMenu("信息");

    //2级
    JMenuItem jmi1 = new JMenuItem("返回上一级");
    JMenuItem jmi2 = new JMenuItem("设置");


    //创建一个返回的按钮
    JButton btn = new JButton("返回");

    //创建一个表格
    String[] titles1 ={"姓名","游戏积分"};

    Vector titles=new Vector();

    Vector data = new 贪吃蛇.DataBase().wanjiaxinxi();

    //创建一个盒子包含表格内容
    Box box = Box.createHorizontalBox();

    //创建一个盒子包含返回按钮
    Box box1 = Box.createHorizontalBox();

    //创建一个总的盒子包含其他小盒子
    Box allbox = Box.createVerticalBox();



    //创建一个显示内容的方法
    public void show(){
        for(String k:titles1){/////
            titles.add(k);///////这里是将titles1中的数据转换成vector类型，jtable中传的两种参数要保持类型一致
        }///////////////////////

        JTable jtable = new JTable(data,titles);



        jmb.add(jm1);
        jmb.add(jm2);

        jm1.add(jmi1);

        jm2.add(jmi2);

        jf.setJMenuBar(jmb);//将菜单栏添加到窗口中


//        jf.add(new JScrollPane(jtable));
        box.add(new JScrollPane(jtable));
        box1.add(btn);

        allbox.add(box);
        allbox.add(Box.createVerticalStrut(5));
        allbox.add(box1);



        jf.add(allbox);

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jf.setBounds(450,200,400,200);
        jf.setVisible(true);

        //设置点击返回按钮的事件
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 主界面().xuanze();
                jf.dispose();
            }
        });

        //点击返回上一级的按钮
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 主界面().xuanze();
                jf.dispose();
            }
        });

        //点击设置的按钮
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 设置界面栏().show();
                jf.dispose();
            }
        });
    }

//测试本页代码是否正常运行
    public static void main(String[] args) {
        new 记录排行榜().show();
    }



}
