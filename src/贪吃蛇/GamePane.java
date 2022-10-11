package 贪吃蛇;
import 主界面.设置界面栏;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;



public class GamePane extends JPanel {

    //设置游戏的难度速度
    int speed;



    //设置游戏的难度
    static int nandu1=500;//设置默认的难度为“中等”

    public void setNandu1(int nandu1) {
        this.nandu1 = nandu1;
        System.out.println("难度为:"+nandu1);

    }


    int length;//定义蛇的长度变量
    //分别存储蛇的X轴和Y轴
    int[]snakeX=new int[200];
    int[]snakeY=new int[200];
    //定义蛇头方向
    String direction;
    //创建一个定时器
    Timer timer;
    boolean isStart=false;//默认游戏是暂停效果
    //定义食物的坐标
    int foodX;
    int foodY;
    //定义成绩
    int score;
    //死亡状态
    boolean isDie=false;//
    //设置最初的游戏界面(蛇的位置以及随机生成的食物位置)
    public void init(){
        length=3;//初始化蛇的长度默认为3
        snakeX[0]=175;
        snakeY[0]=275;

        snakeX[1]=150;
        snakeY[1]=275;

        snakeX[2]=125;
        snakeY[2]=275;
        direction="R";
        foodX=(int)((Math.random()*30)+1)*25;//[25,750]，，，随机生成食物的x坐标
        foodY=((new Random().nextInt(26))+4)*25;//[100,，，，随机生成食物的y坐标



    }

    public GamePane() {
        init();
        //将焦点定位到 当前操作面板
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    if(isDie){
                        //恢复初始化
                        init();
                        isDie=false;
                        score=0;
                    }else{//没死
                        isStart= !isStart;
                        repaint();//重新绘制
                    }

                }
                //监听箭头事件
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    direction="U";
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    direction="D";
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    direction="L";
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    direction="R";
                }
            }
        });
//        //设置游戏难度
//        if(chuanzhi.get(1).equals("简单")){
//            speed=100;
//        }else if (chuanzhi.get(1).equals("中等")){
//            speed=150;
//        }else if(chuanzhi.get(1).equals("困难")){
//            speed=500;
//        }else if(chuanzhi.get(1).equals("专家")){
//            speed=1000;
//        }
        timer =new Timer(nandu1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStart&&!isDie){
                    //如果游戏开始才动起来后一节身子
                    for(int i=length-1;i>0;i--){
                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
                    //动头
                    if("R".equals(direction)){
                        snakeX[0]+=25;
                    }
                    if("L".equals(direction)){
                        snakeX[0]-=25;
                    }
                    if("U".equals(direction)){
                        snakeY[0]-=25;
                    }
                    if("D".equals(direction)){
                        snakeY[0]+=25;
                    }
                    //防止超出边界
                    if(snakeX[0]>800){
                        snakeX[0]=0;
                    }
                    if(snakeX[0]<0){
                        snakeX[0]=800;
                    }

                    if(snakeY[0]>800){
                        snakeY[0]=50;
                    }
                    if(snakeY[0]<50){
                        snakeY[0]=800;
                    }
                    //检测碰撞,坐标重合
                    if(snakeX[0]==foodX&&snakeY[0]==foodY){
                        length++;
                        //食物坐标改变
                        foodX=(int)((Math.random()*30)+1)*25;//[25,750]
                        foodY=((new Random().nextInt(26))+4)*25;//[100,750]
                        score+=10;
                    }
                    //死亡判定
                    for(int i=1;i<length;i++){
                        if(snakeX[i]==snakeX[0]&&snakeY[i]==snakeY[0]){
                            isDie=true;

                        }
                    }
                    repaint();

                }
            }
        });
        //启动定时
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        setBackground(new Color(209, 255, 225, 255));


        MyImage.header.paintIcon(this,g,0,0);
        g.setColor(Color.white);
        g.fillRect(0,53,800,700);
        //绘制蛇头
        MyImage.setImageIcon();
        if("R".equals(direction)){
            MyImage.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("L".equals(direction)){
            MyImage.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("U".equals(direction)){
            MyImage.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("D".equals(direction)){
            MyImage.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i=1;i<length;i++){
            MyImage.body.paintIcon(this,g,snakeX[i],snakeY[i] );
        }

        //游戏暂停中间显示提示语
        if(!isStart){
            g.setColor(Color.CYAN);
            g.setFont(new Font("幼圆",Font.BOLD,40));
            g.drawString("点击空格开始游戏",250,330);
        }
        //绘制食物
        MyImage.food.paintIcon(this,g,foodX,foodY);
        //积分
        g.setColor(Color.ORANGE);
        g.setFont(new Font("幼圆",Font.BOLD,20));
        g.drawString("积分:"+score,620,35);


        //死亡
        if(isDie){
            g.setColor(Color.RED);
            g.setFont(new Font("幼圆",Font.BOLD,20));
            g.drawString("GAME OVER 按下空格重新开始游戏",200,330);
            //此处弹出窗口使玩家输入姓名
            //调用方法
            死亡后输入信息界面 s = new 死亡后输入信息界面();
            s.show(score);



        }

    }

}
