package 贪吃蛇;

import 主界面.主界面;
import 主界面.设置界面栏;
import 主界面.记录排行榜;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame {
    JFrame jf=new JFrame("贪吃蛇");

    //    创建一个菜单
    JMenuBar jmb = new JMenuBar();


    //1级
    JMenu jm1 = new JMenu("菜单");
    JMenu jm2 = new JMenu("信息");

    //2级
    JMenuItem jmi1 = new JMenuItem("返回上一级");
    JMenuItem jmi2 = new JMenuItem("查看排行榜");
    JMenuItem jmi3 = new JMenuItem("设置");


    public void tanchishe(){


        //组装菜单栏
        jmb.add(jm1);
        jmb.add(jm2);

        jm1.add(jmi1);
        jm2.add(jmi2);
        jm2.add(jmi3);

        jf.setJMenuBar(jmb);//将菜单栏添加到窗口中

        //        点击返回上一级界面
        jmi1.addActionListener(new ActionListener() {//点击了前台按钮则进入前台登录界面
            @Override
            public void actionPerformed(ActionEvent e) {
                new 主界面().xuanze();
                jf.dispose();//关闭上一个窗口
            }
        });

//        //        点击查看排行榜
//        jmi2.addActionListener(new ActionListener() {//点击了前台按钮则进入前台登录界面
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                new 主界面()
//                jf.dispose();//关闭上一个窗口
//            }
//        });



        //点击查看游戏记录按钮
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new 记录排行榜().show();
                jf.dispose();//关闭上一个窗口
            }
        });


        //        点击设置按钮
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new 设置界面栏().show();
                jf.dispose();//关闭上一个窗口
            }
        });



        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取当前屏幕的高度像素
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取当前屏幕的宽度像素
//        jf.setSize(800,800);
//        jf.setLocationRelativeTo(null);//无依赖居中
        jf.setBounds((width-800)/2,(height-800)/2,800,750);//使窗口的x和y坐标显示在屏幕的中间位置，并设置窗口的大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//sz设置此窗口点击右上角的x关闭窗口
        GamePane gamePane = new GamePane();//创建一个游戏界面的对象
        jf.add(gamePane);//将游戏的界面添加到窗口中
        jf.setVisible(true);//设置此窗口为显示可见
    }
//测试本页代码是否正常运行
    public static void main(String[] args) {
        StartGame s = new StartGame();
        s.tanchishe();
    }
}
