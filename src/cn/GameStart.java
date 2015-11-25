package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by doctli on 2015/11/23.
 */
public class GameStart  implements Runnable{

    private int level;
    private  String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private JLabel letter;
    private int rows;
    private int i;
    private String resu="";

    public GameStart(){

        JPanel p1=new JPanel();
        p1=new JPanel();
        p1.setLayout(new BorderLayout());
        //String chars = "abcdefghijklmnopqrstuvwxyz";


        // ImageIcon imageIcon=new ImageIcon(getClass().getResource("image/A.ico"));
        JLabel letter=new JLabel("aaaaaaa");
        p1.add(letter);
        new Thread(this).start();

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
                            break;
                        case 1:
                            System.out.println("你选择不继续");
                            break;
                        case 2:
                            System.out.println("呵呵");
                            break;
                    }

                }


            }
        });


        JFrame jf=new JFrame();
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
            while(true){
                if(letter.getText()!="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"){
                    letter.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");}
                else
                    letter.setText("大家好");

//                    for(i=1;i<=8;i++){
//                        char randomchar=chars.charAt((int)(Math.random() * 26));
//                        int randomint=(int)(Math.random() * 26);
//                         // p1.add(new JLabel(String.valueOf(randomchar)));
//                         // letter.setIcon(new ImageIcon(getClass().getResource("src/image/"+String.valueOf(randomchar)+".ico")));
//                         letter.setText(String.valueOf(randomchar));
//                         resu+=String.valueOf(randomchar);
//                     }

//                else{
//                    letter.setText("5");
//                }
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException ex){

        }
    }
}