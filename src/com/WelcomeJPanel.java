package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
class WelcomeJPanel{
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    private CardLayout cardLayout=new CardLayout();
    private JPanel cardPanel=new JPanel(cardLayout);
    private JPanel q=new JPanel();
    private String username=null;
    private JButton stb,list;
    private JButton clear,back;
    private JComboBox levelselect;
    private String levelname=null;
    private   String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Thread thread,thread2,thread3;
    private Runnable runnable,runnable2,runnable3;

    private JLabel letter;
    private String resu="";
    private JPanel panel1,panel2,panel3;

    private static JTextArea paiming=new JTextArea(30,30);
    private JTextField resule;
    private JFrame jf;


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
                resu="";
                resule.setText(null);
                System.out.println("难度已经改变      " + levelname);
            }
        });

        q.add(stb);
        q.add(levelselect);
        q.add(list);

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(q, BorderLayout.SOUTH);
        JTextArea jta = new JTextArea("welcome\n" + "记忆测试系统\n" + "选择级别+开始\n");
        panel1.add(jta, BorderLayout.CENTER);

        stb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "2");
                switch (levelname) {
                    case "——初级——":
                        thread.start();
                        System.out.println("游戏开始");
                        break;
                    case "——中级——":
                        thread2.start();
                        System.out.println("游戏开始");
                        break;
                    case "——高级——":
                        thread3.start();
                        System.out.println("游戏开始");
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

//        GridBagConstraints g=new GridBagConstraints();
//        g.fill=GridBagConstraints.BOTH;
//        g.gridwidth=0;
//        g.weightx=0;
//        g.weighty=0;
//        layout.setConstraints(letter,g);
        JPanel p2 = new JPanel();
        JLabel resultname = new JLabel("你的答案");
        resule = new JTextField(20);
        JButton submit = new JButton("提交");
        p2.add(resultname);
        p2.add(resule);
        p2.add(submit);
        panel2 = new JPanel();
        panel2.add(letter, BorderLayout.CENTER);
        panel2.add(p2, BorderLayout.SOUTH);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resule.getText().equalsIgnoreCase(resu)) {
                    username = JOptionPane.showInputDialog(null, "挑战成功\n英雄尊姓大名");
                    if(username!=null) {
                        filedeal.appendFile(username + " " + levelname+"挑战成功  "+df.format(new Date())+"\n");
                        paiming.setText(filedeal.showFile());
                        cardLayout.last(cardPanel);
                    }
                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "回答错误\n正确答案：" + resu + "\n是否重来");
                    switch (choose) {
                        case 0:
                            jf.dispose();
                            new WelcomeJPanel();
                            break;
                        case 1:
                            jf.dispose();
                            System.out.println("你选择不继续" + "");
                            break;
                        case 2:
                            System.out.println("呵呵");
                            break;
                    }
                }
            }
        });
        back=new JButton("返回");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new WelcomeJPanel();
                cardLayout.first(cardPanel);
            }
        });
        clear=new JButton("清空");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filedeal.clearFile();
                cardLayout.last(cardPanel);
            }
        });
        JPanel panel31=new JPanel();
        panel31.add(clear);
        panel31.add(back);
        panel3=new JPanel();
        panel3.add(panel31,BorderLayout.NORTH);
        panel3.add(paiming,BorderLayout.CENTER);

        cardPanel.add(panel1, String.valueOf(1));
        cardPanel.add(panel2, String.valueOf(2));
        cardPanel.add(panel3, String.valueOf(3));

        jf=new JFrame();
        jf.setTitle("欢迎使用记忆测试系统");
        jf.setSize(500,400);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        //jf.setLocation(0,0);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(cardPanel, BorderLayout.CENTER);

        runnable=new Runnable() {//-------------------------------------------------------------------初级难度
            @Override
            public void run() {
                int a=10;
                try{
                    while (a>0){
                        if(letter.getText().equals("                    ")) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            letter.setText(String.valueOf(randomchar)+"                  ");
                            resu+=String.valueOf(randomchar);
                            System.out.println(resu);
                        }
                        else{
                            letter.setText("                    ");
                        }
                        a--;
                        Thread.sleep(200);
                    }
                }
                catch (InterruptedException e){

                }
                finally {
                    letter.setText("^-^");
                }
            }
        };
        runnable2=new Runnable() {//-------------------------------------------------------------------中级级难度
            @Override
            public void run() {
                int a = 10;
                try {
                    while (a > 0) {
                        if (letter.getText() == null) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            ImageIcon imageIcon1 = setimage(String.valueOf(randomchar));
                            letter.setIcon(imageIcon1);
                            letter.setText(String.valueOf(randomchar));
                            resu += String.valueOf(randomchar);
                            System.out.println(resu);
                        } else {
                            //letter.setIcon(null);
                            letter.setText(null);
                        }
                        a--;
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {

                } finally {
                    letter.setIcon(null);
                    letter.setText("没有了");
                }

            }
        };
        runnable3=new Runnable() {//-------------------------------------------------------------------高级级难度
            @Override
            public void run() {

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
