package myp;
//import java.util.*;
import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import myp.*;
public class Subexam extends Frame implements ActionListener,ItemListener
{
public int ans[]=new int[30];
public int score=0;
public String name1;
public String subname,msg;
public Button b1,b2,b3;
public Label l1,l2,l3;
public CheckboxGroup cg;
public Checkbox c[]=new Checkbox[4];
public ResultSet rs;
public int visit[]=new int[20];
public Subexam(String name,String topicn)throws NullPointerException
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","sindhusha28031995");
Statement stmt=con.createStatement();
rs=stmt.executeQuery("SELECT * FROM questions WHERE topic='"+topicn+"'");
name1=name;subname=topicn;
l1=new Label("Welcome "+name+" ....\n");
b1=new Button("prev");
b2=new Button("next");
cg=new CheckboxGroup();
rs.next();
l2=new Label(Integer.toString(rs.getInt("id"))+")  "+rs.getString("que"));
c[0]=new Checkbox(rs.getString("opt0"),cg,false);
c[1]=new Checkbox(rs.getString("opt1"),cg,false);
c[2]=new Checkbox(rs.getString("opt2"),cg,false);
c[3]=new Checkbox(rs.getString("opt3"),cg,false);
}catch(SQLException se){se.printStackTrace();}
catch(Exception e){e.printStackTrace();}
b3=new Button("Submit");
l3=new Label();
Panel p1=new Panel();
Panel p2=new Panel();
Panel p3=new Panel();
p1.setFont(new Font("Times New Roman",Font.BOLD,24));
p2.setFont(new Font("Times New Roman",Font.BOLD,24));
p3.setFont(new Font("Times New Roman",Font.BOLD,24));
p1.setLayout(null);
p1.add(l1);
p1.add(l2);
p2.setLayout(new GridLayout(4,1));
p2.add(c[0]);
p2.add(c[1]);
p2.add(c[2]);
p2.add(c[3]);
p3.setLayout(null);
p3.add(b1);
p3.add(b2);
p3.add(b3);
p3.add(l3);b3.setVisible(false);
setLayout(new GridLayout(3,1));
add(p1);
add(p2);
add(p3);
l1.setBounds(100,50,400,30);
l2.setBounds(100,200,700,60);
b1.setBounds(200,100,100,50);
b2.setBounds(600,100,100,50);
b3.setBounds(400,100,100,50);
l3.setBounds(100,200,400,50);
b2.addActionListener(this);
b1.addActionListener(this);
c[0].addItemListener(this);
c[1].addItemListener(this);
c[2].addItemListener(this);
c[3].addItemListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{b3.setVisible(false);
try{
if(rs.previous()==false)
{
msg="cant move to prevoius";
l3.setText(msg);
rs.next();
}
else
{
l2.setText(Integer.toString(rs.getInt("id"))+")  "+rs.getString("que"));
c[0].setLabel(rs.getString("opt0"));
c[1].setLabel(rs.getString("opt1"));
c[2].setLabel(rs.getString("opt2"));
c[3].setLabel(rs.getString("opt3"));
l3.setText("");
}
}catch(SQLException se){se.printStackTrace();}
catch(Exception e){e.printStackTrace();}
}
if(ae.getSource()==b2)
{
try{
if(rs.next()==false)
{msg="You reached end Question";
l3.setText(msg);
b3.setVisible(true);
b3.addActionListener(this);
rs.previous();}
else
{
l2.setText(Integer.toString(rs.getInt("id"))+")  "+rs.getString("que"));
c[0].setLabel(rs.getString("opt0"));
c[1].setLabel(rs.getString("opt1"));
c[2].setLabel(rs.getString("opt2"));
c[3].setLabel(rs.getString("opt3"));
msg="";
l3.setText(msg);
}
}catch(SQLException se){se.printStackTrace();}
catch(Exception e){e.printStackTrace();}
}
if(ae.getSource()==b3)
{
Finalres f=new Finalres(name1,subname,score);
f.setVisible(true);
f.setSize(1000,1000);
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
setVisible(false);
}
}
public void paint(Graphics g)
{
g.drawString(msg,400,700);
}
public void itemStateChanged(ItemEvent ie)
{
int opt=0;
if(ie.getSource()==c[0]){opt=1;}
if(ie.getSource()==c[1]){opt=2;}
if(ie.getSource()==c[2]){opt=3;}
if(ie.getSource()==c[3]){opt=4;}
try
{
if(rs.getInt("ans")==opt)
{
if(visit[rs.getInt("id")]==0){
score++;
visit[rs.getInt("id")]=1;}
}
if(rs.getInt("ans")!=opt)
{
if(visit[rs.getInt("id")]==1){
score--;
visit[rs.getInt("id")]=0;}
}
}catch(SQLException se){se.printStackTrace();}
catch(Exception e){e.printStackTrace();}
}
public static void main(String args[])
{
Subexam se=new Subexam("no user","Compiler Design");
se.setVisible(true);
se.setSize(1000,1000);
se.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});
}
}

