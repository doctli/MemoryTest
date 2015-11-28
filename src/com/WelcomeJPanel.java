package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 */
class WelcomeJPanel extends JFrame {
    private CardLayout cardLayout=new CardLayout();
    private JPanel cardPanel=new JPanel(cardLayout);
    private JPanel q=new JPanel();
    private String username=null;
    private JButton stb,list;
    private JComboBox levelselect;
    private String levelname=null;
    private   String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int level=10;

    private Thread thread,thread2,thread3;
    private Runnable runnable,runnable2,runnable3;

    private JLabel letter;
    private String resu="";
    private JPanel p1,p3,firstjpanel;

    private JTextArea paiming=new JTextArea();

    private int start;

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
                System.out.println("难度已经改变      " + levelname);
            }
        });

        q.add(stb);
        q.add(levelselect);
        q.add(list);

        firstjpanel = new JPanel();
        firstjpanel.setLayout(new BorderLayout());
        firstjpanel.add(q, BorderLayout.SOUTH);
        JTextArea jta = new JTextArea("welcome\n" + "记忆测试系统\n" + "选择级别+开始\n");
        firstjpanel.add(jta, BorderLayout.CENTER);

        stb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // username=JOptionPane.showInputDialog(null,"英雄尊姓大名");
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
                cardLayout.last(cardPanel);
                System.out.println("list button");
            }
        });

        //------------------------------------------------------JPanel2-------------------------------------------------------------------------------------------------
//        p1=new JPanel();
//        //GridBagLayout layout=new GridBagLayout();
//        p1.setLayout(new BorderLayout());
//        ImageIcon imageIcon=new ImageIcon("image/C.jpg");
        letter = new JLabel("aaaaaaaaa");
//        p1.add(letter);
        //new Thread(this).start();

//        GridBagConstraints g=new GridBagConstraints();
//        g.fill=GridBagConstraints.BOTH;
//        g.gridwidth=0;
//        g.weightx=0;
//        g.weighty=0;
//        layout.setConstraints(letter,g);
        JPanel p2 = new JPanel();
        JLabel resultname = new JLabel("你的答案");
        JTextField resule = new JTextField(20);
        JButton submit = new JButton("提交");
        p2.add(resultname);
        p2.add(resule);
        p2.add(submit);
        p3 = new JPanel();
        p3.add(new JLabel("hehehehheeh"), BorderLayout.NORTH);
        p3.add(letter, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.SOUTH);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resule.getText().equals(resu)) {
                    String username = JOptionPane.showInputDialog(null, "挑战成功\n英雄尊姓大名");

                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "回答错误\n正确答案：" + resu + "\n是否重来");
                    switch (choose) {
                        case 0:
                            //jf.dispose();
                            //new GameStart2();
                            break;
                        case 1:
                            System.out.println("你选择不继续" + "");
                            break;
                        case 2:
                            System.out.println("呵呵");
                            break;
                    }
                }
            }
        });

        cardPanel.add(firstjpanel, String.valueOf(1));
        cardPanel.add(p3, String.valueOf(2));
        cardPanel.add(paiming, String.valueOf(3));

        add(cardPanel, BorderLayout.CENTER);
        runnable=new Runnable() {//-------------------------------------------------------------------初级难度
            @Override
            public void run() {
                int a=10;
                try{
                    while (a>0){
                        if(letter.getText()==null) {
                            char randomchar = chars.charAt((int) (Math.random() * 26));
                            letter.setText(String.valueOf(randomchar));
                            resu+=String.valueOf(randomchar);
                            System.out.println(resu);
                        }
                        else{
                            letter.setText(null);
                        }
                        a--;
                        Thread.sleep(200);
                    }
                }
                catch (InterruptedException e){

                }
                finally {
                    letter.setText("没有了");
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
                            letter.setIcon(null);
                            letter.setText(null);
                        }
                        a--;
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {

                } finally {
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
        WelcomeJPanel jf=new WelcomeJPanel();
        jf.setTitle("欢迎使用记忆测试系统");
        jf.setSize(500,600);
        jf.setVisible(true);
        jf.setLocation(0,0);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
