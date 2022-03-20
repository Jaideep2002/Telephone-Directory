import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event .*;
class Telephone extends Frame implements ActionListener
{
      JButton b1,b2,b3,b4;
      JTextField t1,t2,t3,t4;
     JTextArea ta1;
     JLabel l1,l2,l3,l4,bg,h;
   Telephone()
  {
       JFrame f=new JFrame("Jay's Telephone");
      Image icon=Toolkit.getDefaultToolkit().getImage("D:\\first year\\sem 2\\java\\gui application\\phone.jpg");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setPreferredSize(new Dimension(550,300));
      f.getContentPane().setBackground(Color.PINK);
      f.pack();
  f.setVisible(true);
    f.setIconImage(icon); 
 bg = new JLabel(new ImageIcon("D:\\hat\\oops project\\tele.jfif"));
        bg.setBounds(850,100,600,600);
       b1=new JButton("Add"); 
       b1.setBounds(50,50,100,30);
       b2=new JButton("Search");
        b2.setBounds(170,50,100,30);
         b3=new JButton("Print All");
        b3.setBounds(290,50,100,30); 
      h=new JLabel("Telephone Directory");
     h.setBounds(500,10,300,50);
     l1=new JLabel("Enter Name:");
    l1.setBounds(50,100,120,30);
     l2=new JLabel("Enter Phone Number:");
    l2.setBounds(50,150,140,30);
     l3=new JLabel("Enter Search Name:");
    l3.setBounds(50,200,140,30);
    t1=new JTextField();
    t1.setBounds(270,100,140,30);
    t2=new JTextField();
    t2.setBounds(270,150,140,30);
     t3=new JTextField();
    t3.setBounds(270,200,140,30);
    ta1=new JTextArea(null,300,300);
   ta1.setBounds(100,350,300,300);
   b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this);  
   t1.addActionListener(this); t2.addActionListener(this);  t3.addActionListener(this); 
   f.add(b1); f.add(b2); f.add(b3); 
  f.add(l1); f.add(l2); f.add(l3);
    f.add(t1); f.add(t2);  f.add(t3); f.add(h);
    f.add(ta1);   f.add(bg);
   f.setSize(1500,1500);  
  f.setLayout(null);
 ta1.setFont(new Font("Serif",Font.PLAIN,20));
h.setFont(new Font("Serif",Font.PLAIN,35));
  f.setVisible(true);
  }
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b1)
   {
        
        String s1=t1.getText();
         String s2=t2.getText();
   if(s2.length()==10)
  {
          t2.setText(s2);
   }
  else
  {
      JOptionPane.showMessageDialog(null,"Invalid Phone Number");
 }
           try {
      // Creates a FileWriter
      FileWriter output = new FileWriter("output.txt",true);
      // Writes the string to the file
             output.append(s1+" "+s2+"\n");
            
          t1.setText(" "); t2.setText(" ");

      // Closes the writer
      output.close();
    }

    catch (Exception e) {
      e.getStackTrace();
    }                                     
   }
if(ae.getSource()==b2)
{
  
   try{
      File f1=new File("output.txt"); 
      String[] words=null;
      FileReader fr = new FileReader(f1);  
      BufferedReader br = new BufferedReader(fr); 
      String s;     
      String s5=t3.getText();  
      int count=0;  
      while((s=br.readLine())!=null)   
      {
         words=s.split(" ");  
          for (String word : words) 
          {
                 if (word.equals(s5))  
                 {
                   count++;   
                 }
          }
      }
      if(count!=0)  
      {
               JOptionPane.showMessageDialog(null,"Name Found");
      }
      else
      {
               JOptionPane.showMessageDialog(null,"Name Not Found");
      }
      
         fr.close();
}
    catch (Exception e) {e.getStackTrace();}                                 
}
  if(ae.getSource()==b3)
 {
     ta1.setText(null);
     try{  
         File f1=new File("output.txt");
        Scanner sc=new Scanner(f1);                      
        while(sc.hasNextLine())
       {    
        String s=sc.nextLine();
         ta1.append(s+"\n");    
        }
         sc.close();
    }
       catch (Exception ex) {ex.printStackTrace();  }
    }
  }
}
public class TelephoneDirectory
{
 public static void main(String[] args)
{
      new Telephone();   
}
}




















