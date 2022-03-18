import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class survey {

    java.util.Date date;
    String filename;
    public survey(java.util.Date date1) {
    date=date1;
    asave();
    questionuser();

    }



    public survey(){
        date = new java.util.Date();
        asave();
        questionuser();
    }
//requires
    //modifies
    //effect
    private void questionuser() {
        Scanner sc = new Scanner (System.in);
        System.out.println("please answer the following questions by entering a score from 1-10");
        System.out.println("1-not at all. 10-totaly agree");
        System.out.println(Question1);
        writer(Question1+" :"+sc.next());
        System.out.println(Question2);
        writer(Question2+" :"+sc.next());
        System.out.println(Question3);
        writer(Question3+" :"+sc.next());
        System.out.println(Question4);
        writer(Question4+" :"+sc.next());
        System.out.println(Question5);
        writer(Question5+" :"+sc.next());
        System.out.println(Question6);
        writer(Question6+" :"+sc.next());
        System.out.println(Question7);
        writer(Question7+" :"+sc.next());
        System.out.println(Question8);
        writer(Question8+" :"+sc.next());
        System.out.println(Question9);
        writer(Question9+" :"+sc.next());
        System.out.println(Question10);
        writer(Question10+" :"+sc.next());



    }

    public void asave() {

        //System.out.println("SURV_"+date+".txt");
         filename =maketitle("SURV_"+date+".txt");

        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                writer(filename);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Requires a string
    //modifies filename
    //effects eddit filename to appropriate format
    public String maketitle(String title){
       String name=title;
       name=name.replace(" ","_");
       name=name.replace(":",".");

       return name;
    }

    //requires file to be created
    //modifies filename file
    //effect writes texts on file
    public void writer(String text){
        try {
            FileWriter myWriter = new FileWriter(filename,true);
            myWriter.write(text+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    String Question1="Q1";
    String Question2="Q2";
    String Question3="Q3";
    String Question4="Q4";
    String Question5="Q5";
    String Question6="Q6";
    String Question7="Q7";
    String Question8="Q8";
    String Question9="Q9";
    String Question10="Q10";
    String Question11="Q11";


    }
