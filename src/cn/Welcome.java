package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by doctli on 2015/11/23.
 */
class WelcomeJPanel extends JFrame{
    public String username=null;
    private JButton stb,list;
    private JComboBox levelselect;
    String levelname=null;
    public WelcomeJPanel(){
        JPanel q=new JPanel();

        stb=new JButton("开始");
        list=new JButton("英雄榜");

        String level[]={"—建议初级—","——初级——","——中级——","——高级——"};
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
        q.add(list);

        setLayout(new BorderLayout());
        add(q,BorderLayout.SOUTH);
        JTextArea jta=new JTextArea("welcome\n"
                +"记忆测试系统\n"
                +"选择级别+开始\n");
        add(jta,BorderLayout.CENTER);

        stb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // username=JOptionPane.showInputDialog(null,"英雄尊姓大名");
                switch (levelname){
                    case "—建议初级—":
                    case "——初级——":
                        new GameStart();
                        break;
                    case "——中级——":
                        new GameStart();
                        break;
                    case "——高级——":
                        new GameStart();
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
    }
    public String getUsername(){
        return username;
    }
    public static void main(String[] args){
        WelcomeJPanel jf=new WelcomeJPanel();
        jf.setTitle("欢迎使用记忆测试系统");
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setLocation(0,0);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

