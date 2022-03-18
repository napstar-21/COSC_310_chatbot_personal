package User;
import nlp.POS;


public class IO {


    String usertext;
    String Lusertext;

    GUI1 gui;
    Boolean exit = false;
    int excount=0;
    Survey survey;
    POS pos = new POS();

    public IO(GUI1 gui){

        this.gui=gui;
        Device device1 = new Device();
        solution sol = new solution(device1);
    gui.reply("Hello! I am Team 30's Virtual Product Assistant"+"\n" +
            "in order to exit the program enter exit or done\n"+
            "Chatbot: How can I help you today?\n");
    }

    void button(String txt){
        gui.screenout("You: " + txt + "\n");//user input is added to text area
        gui.field.setText("");//reset input box
   usertext=txt;
    }

    void solfind(String txt){
       String ans= solution.Findsol(txt);
       if(exit){
           exit();
       }
       else if (ans.equals("exit")){
            gui.screenout("Chatbot: please complete our survey\nplease answer the following questions by entering a score from 1-10\n" +
                    "1-not at all. 10-totaly agree\npress RETURN to contiue\n");
           survey = new Survey();
            exit();
        }
        else {

            pos.lstring(txt);
            gui.screenout("Chatbot: you should try to " + ans + ".\n Chatbot:What else can I help you with" + "\n");
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
