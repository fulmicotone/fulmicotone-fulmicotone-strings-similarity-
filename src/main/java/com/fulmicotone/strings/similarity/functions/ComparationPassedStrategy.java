package com.fulmicotone.strings.similarity.functions;

import com.fulmicotone.strings.similarity.business.ComparingResult;

public interface ComparationPassedStrategy {

    boolean isPassed(ComparingResult r);
}
