/*Raj has a phone directory in which he will store his friends and family’s phone numbers. 
He wants to transfer all the information into a file and retrieve the details in an easy 
manner. The directory contains the phone numbers and name of the person. He wants
to add a new person's details with phone number. So, help him by writing a Java 
program which retrieves the details by searching/adding the person's name and vice 
versa. Use GUI.*/
import java.util.*;
class Telephone
{
    String name;
   String ph;
Telephone(String s,String t)
{
     ph=t;
     name=s;
}
String getName()
{  
   return name;
}
String getPhone()
{
   return ph;   
}
public String toString()
{ 
       return ("Name: "+name+"\n"+"Phone Number: "+ph);
}
}
public class TelephoneDemo
{
 static int c=0;
public static void main(String[] args)throws IOException
{
    File f=new File("D:\\first year\\sem 2\\java\\PhoneDir.txt");
     Scanner sc=new Scanner(f); 
 while(sc.hasNextLine()){
   String s=sc.nextLine();  
String[] s2=s.split(" ");
    (c+1)++;
for(int i=0;i<c;i++)
   System.out.println((i+1)+"."+s2[i+1]);
}
 sc.close();
Telephone ob[]=new Telephone[10];
 Scanner sc=new Scanner(System.in);
  Scanner sc1=new Scanner(System.in);
    while(true)
{
     System.out.println("1: Add New Phone Number 2: Update Phone Number 3: Print All Phone Number 4: Print Specific Phone Number");
       System.out.print("Enter Choice:");
  int x=sc.nextInt();
      switch(x)
{
       case 1:
                      System.out.print("Enter Name:");
                    String b=sc1.nextLine();
                    System.out.print("Enter Phone Number:");
                    String e=sc1.nextLine();
            ob[c]=new Telephone(b,e);
                 c++;
                break;
          case 2: 
                         int h=0;
                       System.out.print("Enter Name:");
                          String str=sc1.nextLine();                         
                          for(int i=0;i<c;i++)
                       {
                                 if((ob[i].name).equals(str))
                                  {
                                      System.out.print("Enter Phone Number to be updated:");
                                       String m=sc1.nextLine();  
                                       ob[i].ph=m;
                                       System.out.println("Phone Number Updated");
                                       break;
                                   }
                                   else
                                   {
                                       h++;
                                    }
                        } 
                           if(h==c)
                            System.out.println("Name Not Found");
                         break;
         case 3:
            System.out.println("----------------------------------------------------------------------");
                    for(int i=0;i<c;i++)
{
                       System.out.println(ob[i]);
                          System.out.println("______________________________");
                             }
             System.out.println("----------------------------------------------------------------------"); 
  
   Scanner ds=new Scanner(ob);
  while(ds.hasNext())
{
     String s=ds.nextLine();
  f.write(s+"\n");
}
                            break;
           case 4:
                  h=0;
            System.out.print("Enter Name:");
                          String n1=sc1.nextLine();
                          System.out.println("Phone Number of Specific Person:");     
                           System.out.println("----------------------------------------------------------------------");                 
                          for(int i=0;i<c;i++)
                       {
                                 if((ob[i].name).equals(n1))
                                  {
                                        System.out.println(ob[i].toString());
                                        System.out.println("______________________________");                                                                                                            
                                   }
                                     else
                                   {
                                       h++; 
                                   }
                        }
                        if(h==c)
                     System.out.println("Name not found");
                       System.out.println("----------------------------------------------------------------------"); 
                         break;
                   case 5: System.exit(0);
}
}
}
}
    