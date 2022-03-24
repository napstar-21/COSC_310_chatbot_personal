package User;

import User.Device1;
//import User.Survey;
import User.solution;
import org.junit.Assert;
import org.junit.Test;

public class test {

    GUI1 gui = new GUI1();
    Device1 device = new Device1();
    solution sol = new solution(device);
    IO io = new IO(gui);
    @Test
    public void searchsomething(){
        Assert.assertEquals("plug it into power",sol.Findsol("my phone wont turn on"));
    }
    @Test
    public void searchnothing(){
        Assert.assertEquals(" rephrase your problem I couldn't understand that ",sol.Findsol(""));
    }
    @Test
    public void searchnotther(){
        Assert.assertEquals(" rephrase your problem I couldn't understand that ",sol.Findsol("I need a new phone"));//no keywords in search
    }
    @Test
    public void testsurvey() {
        Survey survey = new Survey();
        String title = survey.filename;
        survey.writer("User.test");
       String S1=survey.read(title);

       Assert.assertTrue(S1.equals(survey.filename+"\nUser.test"+"\n"));



    }
}
