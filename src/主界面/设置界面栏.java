package 主界面;

import com.sun.javaws.util.JfxHelper;
import 贪吃蛇.GamePane;
import 贪吃蛇.MyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class 设置界面栏 {

//创建一个list数组接收匿名内部类中的参数
    ArrayList<String> list = new ArrayList<>();

    //创建一个空的容器布局
    JPanel jp = new JPanel();

    //创建设置的组件（文字）
    JLabel packLabel = new JLabel("设置贪吃蛇头部样式");
    JLabel ballLabel = new JLabel("设置贪吃蛇食物的样式");
    JLabel nandu = new JLabel("设置游戏难度");
    JLabel body = new JLabel("设置身体的图片样式");

    //创建按钮
    JButton btn = new JButton("确定");

    //创建设置的组件（文本框/下拉选择框）
    JComboBox packxiala = new JComboBox();
    JComboBox ballxiala = new JComboBox();
    JComboBox nanduxiala = new JComboBox();
    JComboBox bodyxiala = new JComboBox();



    //创建一个包含球拍设置项的盒子
    Box packBox = Box.createHorizontalBox();

    //创建一个包含小球设置项的盒子
    Box ballBox = Box.createHorizontalBox();

    //创建一个包含贪吃蛇身体样式的盒子
    Box bodyBox = Box.createHorizontalBox();

    //创建一个包含游戏难度的盒子
    Box nanduBox = Box.createHorizontalBox();

    //创建一个包含确定按钮的盒子
    Box anniuBox = Box.createVerticalBox();

    //创建一个主盒子
    Box allBox = Box.createVerticalBox();

    //    创建一个菜单
    JMenuBar jmb = new JMenuBar();


    //1级
    JMenu jm1 = new JMenu("菜单");
    JMenu jm2 = new JMenu("信息");

    //2级
    JMenuItem jmi1 = new JMenuItem("返回上一级");
    JMenuItem jmi2 = new JMenuItem("游戏版本信息");
    JMenuItem jmi3 = new JMenuItem("关于游戏");


    //展示本页面的方法
    public void show(){
        //创建一个窗口对象
        JFrame jf = new JFrame("设置");
        //设置窗口的位置和大小
        jf.setBounds(200,200,300,300);

        //组装菜单栏
//
//        jm1.add(jmi1);
//        jm1.add(jmi2);
//
        jm2.add(jmi2);
        jm2.add(jmi3);

        jmb.add(jm1);
        jmb.add(jm2);

        jm1.add(jmi1);

        jf.setJMenuBar(jmb);//将菜单栏添加到窗口中


        //为设置蛇头样式图片设置下拉选择框添加内容
        packxiala.addItem("狗头");
        packxiala.addItem("虎头");
        packxiala.addItem("猪头");
        packxiala.addItem("蛇头");

        //为设置食物样式图片设置下拉选择框添加内容
        ballxiala.addItem("天使");
        ballxiala.addItem("苹果");
        ballxiala.addItem("樱桃");
        ballxiala.addItem("兔子");

        //为设置贪吃蛇身体下拉选择框添加内容
        bodyxiala.addItem("灰色方块");
        bodyxiala.addItem("飞机");
        bodyxiala.addItem("小狗狗");


        //为游戏难度下拉选择框添加内容
        nanduxiala.addItem("简单");
        nanduxiala.addItem("中等");
        nanduxiala.addItem("困难");
        nanduxiala.addItem("专家");



        //将球拍组件添加到对应的盒子中
        packBox.add(packLabel);
        packBox.add(packxiala);

        //将小球组件添加到对应的盒子中
        ballBox.add(ballLabel);
        ballBox.add(ballxiala);

        //将游戏难度的组件添加到对应的盒子中
        nanduBox.add(nandu);
        nanduBox.add(nanduxiala);

        //将身体难度的组件添加到对应的盒子中
        bodyBox.add(body);
        bodyBox.add(bodyxiala);

        //将确定的按钮添加到对应的盒子中
        anniuBox.add(btn);

        //将其他盒子添加到主盒子中
        allBox.add(Box.createVerticalStrut(20));
        allBox.add(packBox);
        allBox.add(Box.createVerticalStrut(20));
        allBox.add(ballBox);
        allBox.add(Box.createVerticalStrut(20));
        allBox.add(bodyBox);
        allBox.add(Box.createVerticalStrut(20));
        allBox.add(nanduBox);
        allBox.add(Box.createVerticalStrut(20));
        allBox.add(anniuBox);


        //将球拍,小球和难度下拉选择框的组件盒子添加到容器中
        jp.add(allBox);


        //将容器添加到窗口中
        jf.add(jp);

        //以下是设置背景图片的相关代码

        ImageIcon bg = new ImageIcon("设置.jpg");


        JLabel label = new JLabel(bg);

        JPanel pan = (JPanel) jf.getContentPane();

        //          优先解决和背景图片相关的代码
        label.setSize(bg.getIconWidth(),bg.getIconHeight());

        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        pan.setOpaque(false);//设置背景透明

        jp.setOpaque(false);//设置Jpanel容器透明

        pan.setLayout(new FlowLayout());//无了解

        jf.setLocationRelativeTo(null);//设置窗口在屏幕的中央,可无


        //        点击返回上一级界面
        jmi1.addActionListener(new ActionListener() {//点击了前台按钮则进入前台登录界面
            @Override
            public void actionPerformed(ActionEvent e) {

                new 主界面().xuanze();
                jf.dispose();//关闭上一个窗口
            }
        });

        //点击确定按钮
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取文本框中的值
                String tou = packxiala.getSelectedItem().toString();
                String food = ballxiala.getSelectedItem().toString();
                String nandu1 = nanduxiala.getSelectedItem().toString();
                String body = bodyxiala.getSelectedItem().toString();
                list.add(tou);
                list.add(food);
                list.add(nandu1);
                list.add(body);
                nandu();//此处调用设置游戏难度的方法
                tou();

                new 主界面().xuanze();
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

    //设置换蛇头的方法
    public void tou(){
        MyImage m = new MyImage();
        System.out.println("选择头是:"+list.get(0));
        if(list.get(0).equals("狗头")){
            m.setShangtou("snakePhoto\\狗上.png");
            m.setXiatou("snakePhoto\\狗下.png");
            m.setRighttou("snakePhoto\\狗右.png");
            m.setLefttou("snakePhoto\\狗下.png");
        }else if(list.get(0).equals("猪头")){
            m.setShangtou("snakePhoto\\猪头上.png");
            m.setXiatou("snakePhoto\\猪头下.png");
            m.setRighttou("snakePhoto\\猪头右.png");
            m.setLefttou("snakePhoto\\猪头左.png");
        }else if(list.get(0).equals("虎头")){
            m.setShangtou("snakePhoto\\虎头上.png");
            m.setXiatou("snakePhoto\\虎头下.png");
            m.setRighttou("snakePhoto\\虎头右.png");
            m.setLefttou("snakePhoto\\虎头上.png");
        }else if(list.get(0).equals("蛇头")){
            m.setShangtou("snakePhoto\\蛇头上.png");
            m.setXiatou("snakePhoto\\蛇头下.png");
            m.setRighttou("snakePhoto\\蛇头右.png");
            m.setLefttou("snakePhoto\\蛇头上.png");
        }

        if(list.get(1).equals("天使")){
            m.setFoodimg("snakePhoto\\天使.png");
        }else if(list.get(1).equals("樱桃")){
            m.setFoodimg("snakePhoto\\樱桃.png");
        }else if(list.get(1).equals("苹果")){
            m.setFoodimg("snakePhoto\\苹果.png");
        }else if(list.get(1).equals("兔子")){
            m.setFoodimg("snakePhoto\\兔子.png");
        }

        if(list.get(3).equals("灰色方块")){
            m.setBodyimg("snakePhoto\\body.png");
        }else if(list.get(3).equals("小狗狗")){
            m.setBodyimg("snakePhoto\\小狗.png");
        }else if(list.get(3).equals("飞机")){
            m.setBodyimg("snakePhoto\\飞机.png");
        }

    }

    //设置难度的调用方法
    public void nandu(){
        GamePane g  = new GamePane();
        if(list.get(2).equals("简单")){
            g.setNandu1(1000);
        }else if(list.get(2).equals("中等")){
            g.setNandu1(500);
        }else if(list.get(2).equals("困难")){
            g.setNandu1(100);
        }else if(list.get(2).equals("专家")){
            g.setNandu1(10);
        }
    }



//测试本页代码是否正常运行
    public static void main(String[] args) {
        设置界面栏 s= new 设置界面栏();
        s.show();

    }



}


