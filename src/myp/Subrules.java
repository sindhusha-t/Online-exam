package myp;
//import java.util.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import myp.*;
public class Subrules extends Frame implements ActionListener
{
public String name1;
public String subname;
public Button b1,b2,b3;
public Subrules(String name,String topic)
{
name1=name;
subname=topic;
Label l1=new Label("Welcome "+name+" .....");
Label l2=new Label("You Selected topic "+topic+" :");
Label l3=new Label("The RULES to be followed are:");
l1.setFont(new Font("Times New Roman",Font.BOLD,24)); 
l2.setFont(new Font("Times New Roman",Font.BOLD,22)); 
l3.setFont(new Font("Times New Roman",Font.BOLD,20)); 
TextArea ta=new TextArea();
ta.setFont(new Font("Times New Roman",Font.PLAIN,18)); 
ta.setText("1)Examination time limit is 30 minutes \n 2)There are no negative marks \n 3)Each Question carries 1 mark \n4)There are 10 questions \n\n\n                                    ALL THE BEST");
ta.setEditable(false);
b1=new Button("START");
b2=new Button("BACK");
b3=new Button("Return To Home");
b1.setFont(new Font("Times New Roman",Font.BOLD,20)); 
b2.setFont(new Font("Times New Roman",Font.BOLD,20)); 
b3.setFont(new Font("Times New Roman",Font.BOLD,20)); 
setLayout(null);
add(l1);
add(l2);
add(l3);
add(ta);
add(b1);
add(b2);
add(b3);
l1.setBounds(200,50,600,30);
l2.setBounds(200,100,600,30);
l3.setBounds(350,140,600,30);
ta.setBounds(250,180,600,200);
b1.setBounds(400,500,100,50);
b2.setBounds(200,500,100,50);
b3.setBounds(600,500,200,50);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
Subexam se=new Subexam(name1,subname);
se.setVisible(true);
se.setSize(1000,1000);
setVisible(false);
se.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
if(ae.getSource()==b3)
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
if(ae.getSource()==b2)
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
}
public static void main(String args[])
{
Subrules sr=new Subrules("no user","no topic");
sr.setVisible(true);
sr.setSize(1000,1000);
sr.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}