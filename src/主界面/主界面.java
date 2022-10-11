package 主界面;

import com.sun.jmx.mbeanserver.JmxMBeanServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 主界面 {
    //创建主界面上方任务栏

    //创建主界面任务栏
    Box box  = Box.createVerticalBox();
    JButton btn1 = new JButton("开始游戏");
    JButton btn2 = new JButton("设置");
    JButton btn3 = new JButton("查看记录");

    //    创建一个菜单
    JMenuBar jmb = new JMenuBar();


    //1级
    JMenu jm1 = new JMenu("菜单");
    JMenu jm2 = new JMenu("信息");
//
//    //2级
    JMenuItem jmi1 = new JMenuItem("游戏信息");
    JMenuItem jmi2 = new JMenuItem("关于游戏");
//    JMenuItem jmi2 = new JMenuItem("关闭程序");
//    JMenuItem jmi3 = new JMenuItem("修改个人信息");
//
//


    public void xuanze(){
        //创建一个窗口界面
        JFrame jf = new JFrame("登录界面");
        //设置窗口位置
        jf.setBounds(200,200,400,200);

        //添加组件

        //组装菜单栏
//
//        jm1.add(jmi1);
//        jm1.add(jmi2);
//
//        jm2.add(jmi3);

        jmb.add(jm1);
        jmb.add(jm2);

        jm2.add(jmi1);
        jm2.add(jmi2);

        jf.setJMenuBar(jmb);//将菜单栏添加到窗口中



        box.add(Box.createHorizontalStrut(80));
        box.add(Box.createVerticalStrut(10));
        box.add(btn1);//添加开始游戏的按钮

        box.add(Box.createVerticalStrut(10));
        box.add(btn2);//添加设置的按钮

        box.add(Box.createVerticalStrut(10));
        box.add(btn3);//添加查看游戏记录的按钮

        jf.add(box);


        //以下是设置背景图片的相关代码

        ImageIcon bg = new ImageIcon("src\\主界面\\images\\主界面.jpeg");


        JLabel label = new JLabel(bg);

        JPanel pan = (JPanel) jf.getContentPane();

        //          优先解决和背景图片相关的代码
        label.setSize(bg.getIconWidth(),bg.getIconHeight());

        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        pan.setOpaque(false);//设置背景透明

        pan.setLayout(new FlowLayout());//无了解

        jf.setLocationRelativeTo(null);//设置窗口在屏幕的中央,可无


        //        点击开始游戏按钮进入到弹球小游戏界面
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 贪吃蛇.StartGame().tanchishe();
            }
        });

        //点击查看记录按钮进入到游戏记录界面
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new 记录排行榜().show();
                jf.dispose();
            }
        });

        //点击设置按钮进入设置界面
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new 设置界面栏().show();
                jf.dispose();//关闭上一个窗口
            }
        });

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new 关于游戏界面().show();
                jf.dispose();//关闭上一个窗口
            }
        });

        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                new 游戏信息界面().show();
                jf.dispose();//关闭上一个窗口
            }
        });







        //设置窗口无法被拉伸
        jf.setResizable(false);
        //设置窗口可见
        jf.setVisible(true);
        //设置窗口点击X关闭退出程序
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    public static void main(String[] args) {
        主界面 s = new 主界面();
        s.xuanze();
    }
}
