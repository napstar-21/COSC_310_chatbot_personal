package User;


import javax.swing.*;
import java.awt.image.BufferedImage;

public class IO {


    String usertext;
    String Lusertext;
    String ans;
    GUI1 gui;
    Boolean exit = false;
    int excount=0;
    Survey survey;


    Apple apple;


    public IO(GUI1 gui){

        this.gui=gui;
        apple = new Apple();
        solution sol = new solution();
    gui.reply("Hello! I am Team 30's Virtual Product Assistant"+"\n" +"at anytime enter apple or android to switch to advice for the specified device\n"+
            "I am set to default to apple products\n"+"in order to exit the program enter exit or done\n"+
            "Chatbot: How can I help you today?\n");
    }

    void button(String txt){
        gui.screenout("Client: " + txt + "\n");//user input is added to text area
        gui.field.setText("");//reset input box
   usertext=txt;
   // receive rahman's text here.
    }

    void solfind(String txt){
        //txt = SpellCheck.correct(txt);
        //txt = pos.lstring(txt);

            String ans = solution.Findsol(txt);

            String formerkeyword = solution.keyword;
            System.out.println(formerkeyword);
            if (exit) {
                exit();
            } else if (txt.equals("exit")) {
                gui.screenout("Chatbot: please complete our survey\nplease answer the following questions by entering a score from 1-10\n" +
                        "1-not at all. 10-totaly agree\npress RETURN to contiue\n");
                survey = new Survey();
                exit();

            } else {

                //pos.lstring(txt);
                gui.screenout(ans + ".\n Chatbot:Here is some more information on"+solution.keyword+"from Wikipedia" + "\n");
                gui.screenout(wikiapi.returninfo(solution.keyword));
                gui.screenout("");
                gui.screenout(".\n Chatbot: Here is an image depicting \""+solution.keyword+"\" from Flickr" + "\n");
                gui.screenout(Flickr.FetchDesiredPhoto(solution.keyword));
                gui.screenout( ".\n Chatbot:What else can I help you with" + "\n");

            }
        }


    private void exit() {
        exit = true;

            gui.screenout("ChatBot: "+survey.SurveyQuestions.get(excount)+"\n");
            Lusertext=usertext;
            if(excount>=1)
            survey.writer(survey.SurveyQuestions.get(excount-1)+": "+Lusertext);
        excount+=1;
        if(excount>=survey.SurveyQuestions.size())
        gui.close();
    }

}


