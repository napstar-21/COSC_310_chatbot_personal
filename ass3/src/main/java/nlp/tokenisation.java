package nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class tokenisation {

    public static void main(String[] args) {
    StanfordCoreNLP stanfordCoreNLP= pipeline.getPipeline();

    String text = "Hi, this is Logan Gilroy";

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();
        String word;
        for(CoreLabel coreLabel:coreLabelList){

            System.out.println(coreLabel.originalText());

        }

    }
}
