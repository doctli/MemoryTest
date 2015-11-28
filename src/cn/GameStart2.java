package cn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by doctli on 2015/11/23.
 */
public class GameStart2 extends JFrame {

    private int level=10;
    private  String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private JLabel letter;
    private String resu="";
    public JPanel p1;
    private Thread thread;
    private Runnable runnable;
    private ImageIcon imageIcon=new ImageIcon("image/C.jpg");
    private ImageIcon imageIcon2=new ImageIcon("image/A.jpg");
    //private JFrame jf;
    public ImageIcon setimage(String path){
        ImageIcon icon=new ImageIcon("image/"+path+".jpg");
        return icon;
    }

    public void  GameStart2() {
        p1 = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        p1.setLayout(layout);
        letter = new JLabel();
        letter.setIcon(imageIcon);
        p1.add(letter);

        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.BOTH;
        g.gridwidth = 0;
        g.weightx = 0;
        g.weighty = 0;
        layout.setConstraints(letter, g);
        JPanel p2 = new JPanel();
        JLabel resultname = new JLabel("你的答案");
        JTextField resule = new JTextField(20);
        JButton submit = new JButton("提交");
        p2.add(resultname);
        p2.add(resule);
        p2.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resule.getText().equals(resu)) {
                    String username = JOptionPane.showInputDialog(null, "挑战成功\n英雄尊姓大名");

                } else {
                    int choose = JOptionPane.showConfirmDialog(null, "回答错误\n正确答案：" + resu + "\n是否重来");
                    switch (choose) {
                        case 0:
                            // jf.dispose();

                            new GameStart2();
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

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setTitle("游戏界面");
        setSize(500, 500);
        setVisible(true);
        setLocation(0, 0);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        runnable = new Runnable() {
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
        thread=new Thread(runnable);
        thread.start();
    }
}