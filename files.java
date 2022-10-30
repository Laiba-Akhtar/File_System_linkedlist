//In my project I have tried to explain the concept of linkling several files through linklist
//I have taken example of two files and linked them through linklist
//The insertion in these files is through linklist
//The accessing of data of files is through linklist Object
//The deletion is also through linklist


//LAIBA AKHTAR ALI
//20SW057
//DSA PROJECT
//TITLE : FILING THROUGH LINKLIST
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
class files 
{

    public static File myObj;
    public static File myObj1;
    public static FileWriter myWriter;
    public static FileWriter myWriter1;

    //I have used this in the file class as first files will be created then they can be paas into linklist 
    public Object makefile(String name)
     {
        try 
        {
            myObj = new File(name);
            if (myObj.createNewFile())
             {
                System.out.println("File created: " + myObj.getName());
             }
             else 
             {
                System.out.println("File already exists.");
             }
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myObj;
     }
      
      
    class Node 
     {
     Object object;
     Node next;

       Node(Object o) 
        {
            this.object = o;
        }

       Node(Object o, Node next) 
        {
            this.object = o;
            this.next = next;
        }
        //Here I have explained that we can insert in files through linklist object
        public void writefile(Node s, String data)
        {
        try 
        {
           
            myWriter = new FileWriter(s.object.toString());
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully completed.");
        
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        }


       //this method gives the object of the file 
        public Node givesObject(Node x,int num){
        int count=0;
        Node temp=x;
      
        for (Node p = temp; p != null; p = p.next) 
        {
            count++;
            if (p.object == null) 
            {
               break;
              
             
            }
            if(count==num){
                System.out.println(p.object);
               return p;
            }
          
        }
        return null;
    }
   
         //Here I have explained that we can insert in those files that already have data through linklist object
        public void writefileagain(Node f, String data) throws IOException
        {
        
            try
            {
                FileWriter fileWritter = new FileWriter(f.object.toString(),true);
                BufferedWriter bw = new BufferedWriter(fileWritter);
                bw.write(data);
                System.out.println("Successfully wrote to the file.");
                bw.close();  
            }
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
         //Here I have explained how to access selective files through linklist object
        public void selectivevalue(Node a) 
        {
            Node temp = a;
            System.out.println("The data stored is:");
            
            // Scanner sc=new Scanner(System.in);
            
          
                try {
                  
                    File myObj = new File(temp.object.toString());
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) 
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                
            
        }
        public void deleterecord(Node a) 
        {
            Node temp = a;
            for (Node p = temp; p != null; p = p.next) 
            {
                if (p.object == null) 
                {
                    break;
                }
                a.writefile( p, "");
               
            }
        }
 //Here I have explained that we can access the data of the complete files
        public void value(Node a) 
        {
            Node temp = a;
            for (Node p = temp; p != null; p = p.next) 
            {
                if (p.object == null) 
                {
                    break;
                }
                System.out.println(p.object.toString());
                try
                 {
                  
                    File myObj = new File(p.object.toString());
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) 
                    {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) 
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("STUDENT DATA MANAGEMENT");
        Scanner sc = new Scanner(System.in) ;
        files file = new files();
        //I will be giving example here related to two files by name and we can add as many as we want
       
        String s1="Student Educational details";
        File f=new File(file.makefile(s1).toString());


        String s2="Student Personal details";
        File f2=new File(file.makefile(s2).toString());

        String s3="File_1";
        File f3=new File(file.makefile(s3).toString());

        String s4="file_2";
        File f4=new File(file.makefile(s4).toString());
        files.Node head = file.new Node(f);
        head.next = file.new Node(f2);
        head.next.next = file.new Node(f3);
        head.next.next.next=file.new Node(f4);
      
        int choice=0;
        while(choice<5)
        {
            //these are the functionalities in the system
        System.out.println("What you want to do :");
        System.out.println("1.INSERT THE COMPLETE DATA");
        System.out.println("2.ACCESS DATA");
        System.out.println("3.ADD SOME DATA IN THE FILE");
        System.out.println("4.DELETE THE COMPLETE RECORD");
      
       
            System.out.println("Enter num");
             choice=sc.nextInt();
        
        if(choice==1)
     {
    
        //I have given two choices to insert in file 1 or file 2
    System.out.println("I.Insert data in file 1");
    System.out.println("II.Insert data into file 2");
    System.out.println("III.Insert in any  file");

    //System.out.println("III.Insert in any file by giving node");
    Scanner ss=new Scanner(System.in);
    System.out.println("CHOOSE NUMBER:");
    int num=ss.nextInt();
    
    if(num==1)
    {
        System.out.println("DATA YOU WANT TO ENTER");
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        // StringBuffer buff=new StringBuffer("");
         String data, name,Address,father_name;
         
         System.out.println("Data you want to insert");
       
         System.out.println("Enter name:");
         name=scanner.nextLine();
         System.out.println("Enter Father name:");
         father_name=scanner.nextLine();
        
         System.out.println("Address:");
        Address=scanner.nextLine();
       
               data="Name: "+name+"\nFather name :"+father_name+"\nAddress: "+Address;
               //The collected data is passes
       head.writefile(head, data);
    }

   else if(num==2)
   {
    System.out.println("DATA YOU WANT TO ENTER");
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        // StringBuffer buff=new StringBuffer("");
         String uni_name,Rollno,degree;
         String data;
         
         System.out.println("Data you want to insert");
       
         System.out.println("University Name:");
         uni_name=scanner.nextLine();
       
         System.out.println("Rollno:");
         Rollno=scanner.nextLine();
         System.out.println("Degree:");
        degree=scanner.nextLine();
               data="University Name: "+uni_name+"\nRollno: "+Rollno+"\nDegree: "+degree;
   head.writefile(head.next, data);  
       
    }
    else if(num==3){
        String data;
        System.out.println("Enter number which file ");
        Scanner sccc=new Scanner(System.in);
         int number;
        number=sccc.nextInt();
       System.out.println("Data you want to enter");
       Scanner ses=new Scanner(System.in);
  data=ses.nextLine();
        head.writefile(head.givesObject(head,number),data);  
        
      }

     }
//I have given two choices to access data in file 1 or file 2 or to access complete data
    else if (choice==2)
    {
        System.out.println("1.To Access selective record");
        System.out.println("2.To Access complete record");
      
        System.out.println("CHOOSE NUMBER:");
       Scanner ss=new Scanner(System.in);
        int num=ss.nextInt();

        if(num==1)
        {
       System.out.println("From which file you want to retrieve");
       System.out.println("1.file1");
       System.out.println("2.file2");
       System.out.println("3.Any file");
       Scanner scc=new Scanner(System.in);
      int n=scc.nextInt();
      if(n==1)
      { 
    head.selectivevalue(head);
      }
           else if(n==2)
      {
      
       head.selectivevalue(head.next);
          
      }
      else if(num==3){
        System.out.println("Enter number which file ");
        Scanner sccc=new Scanner(System.in);
         int number;
        number=sccc.nextInt();
        //System.out.println(head.writevalue(head,number));
        head.selectivevalue(head.givesObject(head, num));
      }

        }
        else if(num==2)
        {
            System.out.println("The data reterived is");
           
              
                head.value(head);

        }
    }

    else if(choice==3)
    {
       
    //To add data in file already containing data
        System.out.println("1.In file1");
        System.out.println("2.In file2");
        System.out.println("3.In Anyfile");
        System.out.println("enter num");
        int number;
        Scanner scanner=new Scanner(System.in);
        number=scanner.nextInt();
        Scanner scc1=new Scanner(System.in);
         String data;
         System.out.println("data you want to enter"); 
        data=scc1.nextLine();
        if(number==1)
        {
            
          head.writefileagain(head,data);  
        //   System.out.println("done");
        }
       else  if(number==2)
        {
         
          head.writefileagain(head.next,data);  
        }
        else  if(number==3)
        {
            //To add some more data in the file that are in the linklist
    System.out.println("Enter number which file ");
    Scanner sccc=new Scanner(System.in);
     int num;
    num=sccc.nextInt();
    
     head.writefileagain(head.givesObject(head,num),data); 
        
      
    
    }
}
    else if(choice==4)
    {
        //here the data is set to be null

        System.out.println("1.First file");
        System.out.println("2.Second file");
        System.out.println("3.Any file");
        System.out.println("4.Delete Complete Record");
        System.out.println("Enter number which file ");
        Scanner sccc=new Scanner(System.in);
         int num;
        num=sccc.nextInt();
        if(num==1){
    head.writefile(head, "");
        }
       else if(num==2){
    head.writefile(head.next, "");
        }
        else if(num==3)
        {
            Scanner Sc=new Scanner(System.in);
            int wf;
            System.out.println("Enter which file");
           wf=Sc.nextInt();
           head.writefile(  head.givesObject(head, wf), "");
          
        }
        else if(num==4){
           head. deleterecord(head) ;
        }
    }
}

    
   // OuterClass outerObject = new OuterClass();
// OuterClass.InnerClass innerObject = outerObject.new InnerClass();


    }

    }
