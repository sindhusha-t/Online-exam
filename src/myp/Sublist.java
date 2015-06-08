package myp;
//import java.util.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import myp.*;
public class Sublist extends Frame implements ItemListener,ActionListener
{
public String name1;
public String subname;
public List l1;
public Sublist(String name)
{name1=name;
Label p=new Label("Welcome "+name+" .....");
p.setFont(new Font("Times New Roman",Font.PLAIN,24)); 
Label p1=new Label("Select one Subject: \n");
p1.setFont(new Font("Times New Roman",Font.PLAIN,24)); 
l1=new List();
Button b=new Button("Back");
b.setFont(new Font("Times New Roman",Font.BOLD,18)); 
l1.addItem("Programming Languages");
l1.addItem("Operating System");
l1.addItem("Compiler Design");
l1.addItem("Database Management System");
 l1.addItem("Computer Networks");
l1.addItem("Data Structures");
l1.addItem("Software Engineering");
l1.addItem("Web Technologies");
l1.setFont(new Font("Times New Roman",Font.PLAIN,20)); 
setLayout(null);
add(p);
add(p1);
add(l1);
add(b);
p.setBounds(200,70,500,40);
p1.setBounds(450,140,500,40);
l1.setBounds(300,200,450,200);
b.setBounds(500,500,100,50);
l1.addItemListener(this);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
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
public void itemStateChanged(ItemEvent ie)
{
subname=l1.getSelectedItem();
Subrules sr=new Subrules(name1,subname);
sr.setVisible(true);
sr.setSize(1000,1000);
setVisible(false);
sr.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
public static void main(String args[])
{
Sublist sl=new Sublist("no user");
sl.setVisible(true);
sl.setSize(1000,1000);
sl.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}

