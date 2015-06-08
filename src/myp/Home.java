package myp;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import myp.Sublist;
public class Home extends Frame implements ActionListener
{
public String name;
public TextField t1;
public Home()
{
Label l1=new Label("ONLINE EXAMINATION");
l1.setFont(new Font("Lucida",Font.BOLD,48)); 
Label l2=new Label("Enter Your Roll No:");
l2.setFont(new Font("Times New Roman",Font.PLAIN,24));
t1=new TextField(60);
Button b1=new Button("Login");
b1.setFont(new Font("Times New Roman",Font.BOLD,21));
setLayout(null);
add(l1);
add(l2);
add(t1);
add(b1);
l1.setBounds(200,50,700,70);
l2.setBounds(300,250,400,50);
t1.setBounds(500,300,200,30);
b1.setBounds(400,350,100,40);
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","sindhusha28031995");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT id,name FROM students");
while(rs.next())
{
	if(rs.getInt("id")==Integer.parseInt(t1.getText()))
	{
	name=new String(rs.getString("name"));
	//System.out.println(name);
	Sublist sl=new Sublist(name);
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
}}
}catch(SQLException se){se.printStackTrace();}
catch(Exception e){e.printStackTrace();}
}
public static void main(String args[])
{
Home h=new Home();
h.setVisible(true);
h.setSize(1000,1000);
h.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}


