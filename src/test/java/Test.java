import com.fulmicotone.strings.similarity.Similarity;
import com.fulmicotone.strings.similarity.business.PhraseNormalizerFactory;
import com.fulmicotone.strings.similarity.functions.OneWordIsEnoughStrategy;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public   void test(){


        Similarity s = Similarity.Builder
                .newOne()
                .withFirstFactor(PhraseNormalizerFactory.newOne()
                        .withMinWordLength(3)
                        .withApplyLowerCase(true)
                        .withSplitterDelimiter("/")
                        .build())
                .withSecondFactor(PhraseNormalizerFactory.newOne()
                        .withMinWordLength(3)
                        .withApplyLowerCase(true)
                        .withSplitterDelimiter("-")
                        .build())
                .addPassedStrategy(new OneWordIsEnoughStrategy(), Similarity.Builder.LogicalOperator.OR)
                .build();


              boolean r= s.compare("soccer/player/ball", "soccer and play-shoes-bombastic");

                boolean r1= s.compare("tennis/player/field", "rock and base-shoes-bombastic");


        Assert.assertTrue(r);

        Assert.assertTrue(r1==false);

    }
}
