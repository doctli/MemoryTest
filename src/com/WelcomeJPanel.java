package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
/**
 */
class WelcomeJPanel{
    private CardLayout cardLayout=new CardLayout();
    private JPanel cardPanel=new JPanel(cardLayout);
    private JScrollPane scrollPane=new JScrollPane();
    private JPanel q=new JPanel();
    private String username="";
    private JButton stb,list;
    private JButton clear,back,tryagain;
    private JComboBox levelselect,levelnumselect;
    private String levelname=null;
    private String levelnum=null;
    private   String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Thread thread,thread2,thread3;
    private Runnable runnable,runnable2,runnable3;
    private JLabel letter;
    private String resuu="";
    private JPanel panel1,panel2,panel21,panel3,panel31;
    private static JTextArea paiming=new JTextArea(30,30);
    private JTextField result;
    private JFrame jf;
    private int type;
    private Icon img1=new ImageIcon("image/zb.jpg");
    private Icon success=new ImageIcon("image/success.jpg");
    private Icon waitimage=new ImageIcon("image/hg.jpg");
    private Icon errorimage=new ImageIcon("image/error.jpg");
    private Icon success2=new ImageIcon("image/success2.jpg");
    private static int gamerun=0;
    private int a;
    private StopTime stopTime=new StopTime();
    private int gamenum=0;
    public ImageIcon setimage(String path){
        ImageIcon icon=new ImageIcon("image/"+path+".jpg");
        return icon;
    }

    public WelcomeJPanel() {

        //------------------------------------------------------JPanel1-------------------------------------------------------------------------------------------------
        stb = new JButton("开始");
        list = new JButton("英雄榜");

        String level[] = {"——初级——", "——中级——", "——高级——"};
        levelselect = new JComboBox(level);
        levelselect.setBorder(BorderFactory.createTitledBorder("选择难度"));
        levelname = levelselect.getSelectedItem().toString();
        levelselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelname = levelselect.getSelectedItem().toString();

            }
        });
        String num[]={"第 1 关","第 2 关","第 3 关","第 4 关","第 5 关"};
        levelnumselect=new JComboBox(num);
        levelnumselect.setBorder(BorderFactory.createTitledBorder("选择难度"));
        levelnum=levelnumselect.getSelectedItem().toString();

        levelnumselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelnum=levelnumselect.getSelectedItem().toString();
                switch (levelnum){
                    case "第 1 关":
                        a=2;
                        break;
                    case "第 2 关":
                        a=4;
                        break;
                    case "第 3 关":
                        a=6;
                        break;
                    case "第 4 关":
                        a=8;
                        break;
                    case "第 5 关":
                        a=10;
                        break;
                    default:
                        System.err.println("关卡选择错误");
                        break;
                }
                resuu="";
                result.setText(null);
                System.out.println("难度已经改变      " + levelname+levelnum);
            }
        });
        q.add(list);
        q.add(levelselect);
        q.add(levelnumselect);
        q.add(stb);
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(q, BorderLayout.SOUTH);
        JTextArea jta = new JTextArea(
                "欢迎来到记忆测试系统\n" +
                        "记忆测试系统\n" +
                        "使用方法：选择难度等级——选择关卡——>开始\n" +
                        "答案不区分大小写\n"+
                        "\n\n\n" +
                        "已有："+gamerun+"次挑战,其中挑战成功的请看英雄榜");
        panel1.add(jta, BorderLayout.CENTER);
        jta.setEditable(false);
        paiming.setEditable(false);

        stb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamerun++;
                jta.setText(
                        "欢迎来到记忆测试系统\n" +
                                "记忆测试系统\n" +"使用方法：选择难度等级——选择关卡——>开始\n" +
                                "答案不区分大小写\n"+
                                "\n\n\n"
                                +"已有："+gamerun+"  次挑战,其中挑战成功的请看英雄榜");
                    cardLayout.show(cardPanel, "2");
                while (username.equals("")) {
                    username = JOptionPane.showInputDialog(null, "请输入玩家名以开始");
                }
                jf.setTitle("欢迎使用记忆测试系统"+"____玩家："+username);
                switch (levelname) {
                    case "——初级——":
                        type = 1;
                        result.setText("");
                        new Thread(runnable).start();
                        break;
                    case "——中级——":
                        type = 2;
                        result.setText("");
                        new Thread(runnable2).start();
                        break;
                    case "——高级——":
                        Object[] options1={"就是要装逼","吓死宝宝了","不好意思点错"};
                        int choose = JOptionPane.showOptionDialog(null, "装逼模式即将开启\n" + "是否继续", "最高难度", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,img1,options1,options1[0]);
                        switch (choose) {
                            case 0:
                                type = 3;
                                result.setText("");
                                new Thread(runnable3).start();
                                break;
                            case 1:
                                break;
                            case 2:
                                cardLayout.first(cardPanel);
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paiming.setText(filedeal.showFile());
                if(paiming.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"历史等你创造");
                else{
                    cardLayout.last(cardPanel);
                }

            }
        });

        //------------------------------------------------------JPanel2-------------------------------------------------------------------------------------------------
        letter = new JLabel("                    ");
        letter.setFont(new Font("宋体",Font.BOLD, 35));
        back=new JButton("返回");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.first(cardPanel);
            }
        });

        tryagain=new JButton("重来");
        panel21 = new JPanel();
        JLabel resultname = new JLabel("你的答案");
        result = new JTextField(20);
        JButton submit = new JButton("提交");
        panel21.add(resultname);
        panel21.add(result);
        panel21.add(submit);
        panel21.add(tryagain);
        panel21.add(back);
        panel2 = new JPanel();
        panel2.add(letter, BorderLayout.CENTER);

        tryagain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(null);
                switch (type){
                    case 1:
                        new Thread(runnable).start();
                        break;
                    case 2:
                        new Thread(runnable2).start();
                        break;
                    case 3:
                        new Thread(runnable3).start();
                        break;
                    default:
                        new Thread(runnable).start();
                        break;
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTime.counttime(new Date());
                if (result.getText().equalsIgnoreCase(resuu)) {
                    gamenum++;
                    Object[] options2={"下一关","统计关数","去看英雄榜"};
                    int choose= JOptionPane.showOptionDialog(null,"记忆正确\n","挑战成功",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,success,options2,options2[0]);
                    switch (choose){
                        case 0:
                            filedeal.appendFile(username + " " + levelname+levelnum+"挑战成功  "+stopTime.getTimes()+"\n");
                            paiming.setText(filedeal.showFile());
                            cardLayout.show(cardPanel, "2");
                            switch (levelnum){
                                case "第 1 关":
                                    levelnumselect.setSelectedItem("第 2 关");break;
                                case "第 2 关":
                                    levelnumselect.setSelectedItem("第 3 关");break;
                                case "第 3 关":
                                    levelnumselect.setSelectedItem("第 4 关");break;
                                case "第 4 关":
                                    levelnumselect.setSelectedItem("第 5 关");break;
                                case "第 5 关":
                                    switch (levelname){
                                        case "——初级——":
                                            levelselect.setSelectedItem("——初级——");break;
                                        case "——中级——":
                                            levelselect.setSelectedItem("——高级——");break;
                                        case "——高级——":
                                            JOptionPane.showMessageDialog(null,"更难等级正在开发中……");
                                            break;
                                        default:
                                            break;
                                    }
                                default:
                                    System.err.println("关卡选择错误");
                                        break;
                                }
                            JOptionPane.showMessageDialog(null,"即将开始"+levelname+":"+levelnum);
                            result.setText(null);
                            switch (type){
                                case 1:
                                    new Thread(runnable).start();
                                    break;
                                case 2:
                                    new Thread(runnable2).start();
                                    break;
                                case 3:
                                    new Thread(runnable3).start();
                                    break;
                                default:
                                    new Thread(runnable).start();
                                    break;
                            }
                            break;
                        case 1:
                            filedeal.appendFile(username + " " + levelname+levelnum+"挑战成功  "+stopTime.getTimes()+"\n");
                            JOptionPane.showMessageDialog(null,username+"\n您本次挑战了"+gamenum+"关");
                            paiming.setText(filedeal.showFile());
                            cardLayout.last(cardPanel);
                            break;
                        case 2:
                            cardLayout.last(cardPanel);
                            break;
                    }
                } else {
                    Object[] options3={"重来","主界面","去看英雄榜"};
                    int choose = JOptionPane.showOptionDialog(null, "回答错误\n正确答案：" + resuu + "\n是否重来","",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,errorimage,options3,options3[0]);
                    switch (choose) {
                        case 0:
                            JOptionPane.showMessageDialog(null,"重来会比较快，请注意左上角");
                            switch (type){
                                case 1:
                                    new Thread(runnable).start();
                                    break;
                                case 2:
                                    new Thread(runnable2).start();
                                    break;
                                case 3:
                                    new Thread(runnable3).start();
                                    break;
                                default:
                                    new Thread(runnable).start();
                                    break;
                            }
                            break;
                        case 1:
                            cardLayout.first(cardPanel);
                            break;
                        case 2:
                            cardLayout.last(cardPanel);
                            break;
                    }
                }
            }
        });
        clear=new JButton("清空");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamerun=0;
                filedeal.clearFile();
                paiming.setText(filedeal.showFile());
            }
        });
        panel31=new JPanel();
        panel31.add(clear);
        panel31.add(back);
        panel3=new JPanel();
        scrollPane=new JScrollPane(paiming);
        panel3.add(panel31,BorderLayout.NORTH);
        panel3.add(scrollPane,BorderLayout.CENTER);

        cardPanel.add(panel1, String.valueOf(1));
        cardPanel.add(panel2, String.valueOf(2));
        cardPanel.add(panel3, String.valueOf(3));

        jf=new JFrame();
        jf.setTitle("欢迎使用记忆测试系统");
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jf.add(cardPanel, BorderLayout.CENTER);

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int option =JOptionPane.showConfirmDialog(null,"是否完全退出该系统？","系统提示",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(option==JOptionPane.YES_OPTION) {
                    System.exit(0);
                    username=null;
                }
            }
        });
        runnable=new Runnable() {//-------------------------------------------------------------------初级难度
            @Override
            public void run() {
                String resu="";
                stopTime.setStart(new Date());
                int b=a+10;
                letter.setIcon(null);
                try{
                    while (b>0){
                        if(letter.getText().equals("                    ")) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            letter.setText(String.valueOf(randomchar)+"                  ");
                            resu+=String.valueOf(randomchar);
                        }
                        else{
                            letter.setText("                    ");
                        }
                        b--;
                        Thread.sleep(200);
                    }
                }
                catch (InterruptedException e){
                }
                finally {
                    panel2.add(panel21, BorderLayout.SOUTH);
                    letter.setText("不急，慢慢想你就忘记了");
                    letter.setIcon(waitimage);
                    resuu=resu;
                    System.out.println(resuu);
                    result.requestFocus();
                }
            }
        };
        runnable2=new Runnable() {//-------------------------------------------------------------------中级级难度
            @Override
            public void run() {
                letter.setIcon(null);
                String resu="";
                stopTime.setStart(new Date());
                int b = a+10;
                try {
                    while (b > 0) {
                        if (letter.getText() == null) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            ImageIcon imageIcon1 = setimage(String.valueOf(randomchar));
                            letter.setIcon(imageIcon1);
                           // letter.setText(String.valueOf(randomchar));
                            resu += String.valueOf(randomchar);
                        } else {
                            //letter.setIcon(null);
                            letter.setText(null);
                        }
                        b--;
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {

                } finally {
                    panel2.add(panel21, BorderLayout.SOUTH);
                    letter.setText("咱不急，慢慢想");
                    letter.setIcon(waitimage);
                    resuu=resu;
                    System.out.println(resuu);
                    result.requestFocus();
                }

            }
        };
        runnable3=new Runnable() {//-------------------------------------------------------------------高级级难度
            @Override
            public void run() {
                letter.setIcon(null);
                String resu="";
                stopTime.setStart(new Date());
                int b= a+20;
                try {
                    while (b > 0) {
                        if(letter.getText().equals("                    ")) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            letter.setText(String.valueOf(randomchar)+"                  ");
                            resu+=String.valueOf(randomchar);
                        }
                        else{
                            letter.setText("                    ");
                        }
                        b--;
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {

                } finally {
                    panel2.add(panel21, BorderLayout.SOUTH);
                    letter.setText("不急，慢慢想你就忘记了");
                    letter.setIcon(waitimage);
                    resuu=resu;
                    System.out.println(resuu);
                    result.requestFocus();
                }

            }
        };
        thread=new Thread(runnable);
        thread2=new Thread(runnable2);
        thread3=new Thread(runnable3);
    }


    public static void main(String[] args){
        new WelcomeJPanel();
    }
}
