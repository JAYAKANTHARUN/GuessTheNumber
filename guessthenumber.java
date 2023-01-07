import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class guessthenumber{
    Random random=new Random();
    int number=random.nextInt(100);

    int score=100;
    int highscore=0;

    public guessthenumber(){
        JFrame f=new JFrame("Higher-Lower Guess Number");

        Label l0=new Label("Random Number Between 1-100 is Generated");
        l0.setBounds(100,40,800,20);
        l0.setBackground(Color.LIGHT_GRAY);
        l0.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(l0);

        Label l1=new Label("Enter Your Guess : ");
        l1.setBounds(170,100,230,30);
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(l1);

        TextField t1=new TextField();
        t1.setBounds(400,100,80,30);
        t1.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(t1);

        JButton b1=new JButton("CHECK");
        b1.setBounds(290,140,100,50);
        b1.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        b1.setBackground(new Color(138, 147, 170));
        b1.setBorder(new LineBorder(Color.BLACK,2));
        f.add(b1);

        Label l2=new Label("Status : ");
        l2.setBounds(210,220,100,30);
        l2.setBackground(Color.LIGHT_GRAY);
        l2.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(l2);

        TextField t2=new TextField();
        t2.setBounds(320,220,150,30);
        t2.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(t2);
        t2.setText("-");

        Label l3=new Label("Score : ");
        l3.setBounds(220,260,100,30);
        l3.setBackground(Color.LIGHT_GRAY);
        l3.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(l3);

        TextField t3=new TextField();
        t3.setBounds(320,260,150,30);
        t3.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(t3);
        t3.setText("-");

        Label l4=new Label("HighScore : ");
        l4.setBounds(170,300,130,30);
        l4.setBackground(Color.LIGHT_GRAY);
        l4.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(l4);

        TextField t4=new TextField();
        t4.setBounds(320,300,150,30);
        t4.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        f.add(t4);
        t4.setText("0");

        JButton b2=new JButton("RESET");
        b2.setBounds(290,370,100,50);
        b2.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        b2.setBackground(new Color(138, 147, 170));
        b2.setBorder(new LineBorder(Color.BLACK,2));
        f.add(b2);

        JButton b3=new JButton("EXIT");
        b3.setBounds(290,460,100,50);
        b3.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 20));
        b3.setBackground(new Color(138, 147, 170));
        b3.setBorder(new LineBorder(Color.BLACK,2));
        f.add(b3);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (Integer.parseInt(t1.getText())>number){
                    t2.setText("higher");
                    score=score-5;
                }
                if (Integer.parseInt(t1.getText())<number){
                    t2.setText("lower");
                    score=score-5;
                }
                if (Integer.parseInt(t1.getText())==number){
                    t2.setText("correct");
                    t3.setText(String.valueOf(score)+"/100");
                    if (score>highscore){
                        highscore=score;
                        t4.setText(String.valueOf(score)+"/100");
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t3.setText("-");
                number=random.nextInt(100);
                score=100;
                t2.setText("-");
                t1.setText("");
            }
        });

        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int result=JOptionPane.showConfirmDialog(null,"Are you sure that you want to Quit ?","CONFIRMATION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (result==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        ImageIcon img=new ImageIcon("iconphoto.png");
        f.setIconImage(img.getImage());
        f.setSize(700,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    public static void main(String args[]){
        
        guessthenumber obj=new guessthenumber();
    }
}
