package User;

//import User.Survey;
import org.junit.Assert;
import org.junit.Test;

public class test {

    GUI1 gui = new GUI1();
    Apple device = new Apple();
    solution sol = new solution();
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
        String S2=sol.Findsol("hello");
        Assert.assertEquals("what movie do you like",S2);//no keywords in search
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
