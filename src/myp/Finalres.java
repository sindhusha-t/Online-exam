package myp;
//import java.util.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import myp.*;
public class Finalres extends Frame implements ActionListener
{
public String name1,subname;
public int score1;
public Button b1,b2;
public Label l1,l2;
public Finalres(String name,String topic,int score)
{
l1=new Label("Congratulations "+name+" .....\n");
l2=new Label("you scored "+Integer.toString(score)+" in the topic "+topic);
name1=name;subname=topic;score1=score;
b1=new Button("Return to subjectslist");
b2=new Button("Return to home");
l1.setFont(new Font("Times New Roman",Font.BOLD,24));
l2.setFont(new Font("Times New Roman",Font.BOLD,21));
b1.setFont(new Font("Times New Roman",Font.BOLD,18));
b2.setFont(new Font("Times New Roman",Font.BOLD,18));
setLayout(null);
add(l1);
add(l2);
add(b1);
add(b2);
l1.setBounds(50,50,600,30);
l2.setBounds(100,100,600,30);
b1.setBounds(100,300,200,40);
b2.setBounds(400,300,200,40);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
Sublist sl=new Sublist(name1);
sl.setVisible(true);
sl.setSize(1000,1000);
setVisible(false);
sl.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
else
{
Home h=new Home();
h.setVisible(true);
h.setSize(1000,1000);
setVisible(false);
h.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}
public static void main(String args[])
{
Finalres f=new Finalres("no user","no topic",0);
f.setVisible(true);
f.setSize(1000,1000);
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}
