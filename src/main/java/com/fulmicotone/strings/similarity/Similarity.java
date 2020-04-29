package com.fulmicotone.strings.similarity;

import com.fulmicotone.strings.similarity.business.CharacterSequenceComparator;
import com.fulmicotone.strings.similarity.business.ComparingResult;
import com.fulmicotone.strings.similarity.business.PhraseNormalizerFactory;
import com.fulmicotone.strings.similarity.functions.ComparationPassedStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Similarity {

   private final PhraseNormalizerFactory one;
   private final PhraseNormalizerFactory two;
   private final  List<ComparationPassedStrategy> and;
   private final List<ComparationPassedStrategy> or;

    public Similarity(PhraseNormalizerFactory one,
                      PhraseNormalizerFactory two,
                      List<ComparationPassedStrategy> and,
                      List<ComparationPassedStrategy> or) {
        this.one = one;
        this.two = two;
        this.and = and;
        this.or = or;
    }

    public boolean compare(String a,String b){
        ComparingResult cr = CharacterSequenceComparator.get(one.apply(a), two.apply(b));
        return Stream.of(and.stream().allMatch(cp-> cp.isPassed(cr)),
                or.stream().anyMatch(cp->cp.isPassed(cr)))
                .allMatch(x-> x);

    }


    public static final class Builder {

        public  enum LogicalOperator {AND,OR};

        private PhraseNormalizerFactory one;

        private PhraseNormalizerFactory two;

        private List<ComparationPassedStrategy> and=new ArrayList<>();

        private List<ComparationPassedStrategy> or=new ArrayList<>();

        private Builder() { }

        public static Builder newOne() {
            return new Builder();
        }

        public Builder withFirstFactorNormalizationRules(PhraseNormalizerFactory one) {
            this.one = one;
            return this;
        }

        public Builder withSecondFactorNormalizationRules(PhraseNormalizerFactory two) {
            this.two = two;
            return this;
        }






        public Builder addPassedStrategy(ComparationPassedStrategy strategy, LogicalOperator opt) {
            if(opt==LogicalOperator.AND){ and.add(strategy); }else{ or.add(strategy); }
            return this;
        }



        public Similarity build() {
           return  new Similarity(this.one,this.two,this.and,this.or);
        }
    }
}
