package com.fulmicotone.strings.similarity.functions;

import com.fulmicotone.strings.similarity.business.ComparingResult;
import com.fulmicotone.strings.similarity.utils.CharacterSequenceUnit;

public class OneWordIsEnoughStrategy implements ComparationPassedStrategy {
    @Override
    public boolean isPassed(ComparingResult r) {
       return r.getByUnit(CharacterSequenceUnit.WORD)
                .stream()
                .flatMap(c->c.getScoreMap().values().stream())
                .anyMatch(score->score==0);

    }
}
