package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 */
class WelcomeJPanel {
    public String username=null;
    private JButton stb,list;
    private JComboBox levelselect;
    String levelname=null;
    public WelcomeJPanel(){
        JFrame jf=new JFrame();
        JPanel q=new JPanel();

        stb=new JButton("开始");
        list=new JButton("英雄榜");

        String level[]={"——初级——","——中级——","——高级——"};
        levelselect=new JComboBox(level);
        levelselect.setBorder(BorderFactory.createTitledBorder("选择难度"));
        levelname=levelselect.getSelectedItem().toString();
        levelselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelname=levelselect.getSelectedItem().toString();
                System.out.println("难度已经改变      "+levelname);
            }
        });

        q.add(stb);
        q.add(levelselect);
        q.add(list);

        jf.setLayout(new BorderLayout());
        jf.add(q,BorderLayout.SOUTH);
        JTextArea jta=new JTextArea("welcome\n"
                +"记忆测试系统\n"
                +"选择级别+开始\n");
        jf.add(jta,BorderLayout.CENTER);

        stb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // username=JOptionPane.showInputDialog(null,"英雄尊姓大名");
                //GameStart2 g=new GameStart2();
                switch (levelname){
                    case "——初级——":
                        jf.dispose();
                        new GameStart2();
                        System.out.println("游戏开始");
                        break;
                    case "——中级——":

                        break;
                    case "——高级——":

                        break;
                    default:
                        break;
                }
            }
        });
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("list button");
            }
        });

        jf.setTitle("欢迎使用记忆测试系统");
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setLocation(0,0);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new WelcomeJPanel();


    }
}

