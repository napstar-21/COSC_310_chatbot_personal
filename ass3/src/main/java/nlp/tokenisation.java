package nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class tokenisation {

    public static void main(String[] args) {
    StanfordCoreNLP stanfordCoreNLP= pipeline.getPipeline();

    String text = "blu yelow reed read giont";

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();
        String word;

        Stemmer spellCheck = new Stemmer();
        for(CoreLabel coreLabel:coreLabelList){
            word = coreLabel.originalText();
            spellCheck.add(word.toCharArray(), word.toCharArray().length);
            spellCheck.stem();
            String u = spellCheck.toString();
            System.out.println(u);

        }

    }
}
