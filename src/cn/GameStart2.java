package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by doctli on 2015/11/23.
 */
public class GameStart2 extends JApplet implements Runnable{

    private int level=10;
    private  String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private JLabel letter;
    private String resu="";
    public JPanel p1;
    private JFrame jf=new JFrame();
    public GameStart2(){

    }
    public void GameStart2(int i){
        p1=new JPanel();
        GridBagLayout layout=new GridBagLayout();
        p1.setLayout(layout);
        ImageIcon imageIcon=new ImageIcon("image/C.jpg");
        letter=new JLabel("2222");
        p1.add(letter);
        new Thread(this).start();
        GridBagConstraints g=new GridBagConstraints();
        g.fill=GridBagConstraints.BOTH;
        g.gridwidth=0;
        g.weightx=0;
        g.weighty=0;
        layout.setConstraints(letter,g);
        JPanel p2=new JPanel();
        JLabel resultname=new JLabel("你的答案");
        JTextField resule=new JTextField(20);
        JButton submit=new JButton("提交");
        p2.add(resultname);
        p2.add(resule);
        p2.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(resule.getText().equals(resu)){
                    String  username=JOptionPane.showInputDialog(null,"t挑战成功\n英雄尊姓大名");

                }
                else{
                    int choose=JOptionPane.showConfirmDialog(null,"回答错误\n正确答案："+resu+"\n是否重来");
                    switch (choose){
                        case 0:
                            jf.dispose();
                            new GameStart2();
                            break;
                        case 1:
                            System.out.println("你选择不继续"+"");
                            break;
                        case 2:
                            System.out.println("呵呵");
                            break;
                    }
                }
            }
        });

        jf.add(p1,BorderLayout.CENTER);
        jf.add(p2,BorderLayout.SOUTH);
        jf.setTitle("游戏界面");
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setLocation(0,0);
        jf.add(p1,BorderLayout.CENTER);
        jf.add(p2,BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public void run(){
    try{
        while (level>0){
            if(letter.getText()==null) {
                char randomchar = chars.charAt((int) (Math.random() * 26));
                letter.setText(String.valueOf(randomchar));
                resu+=String.valueOf(randomchar);
                System.out.println(resu);
            }
            else{
                letter.setText(null);
            }
            level--;
            Thread.sleep(200);
        }
    }
    catch (InterruptedException e){
    }
    finally {
        letter.setText(null);
    }
}
}