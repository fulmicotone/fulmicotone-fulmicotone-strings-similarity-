package com.fulmicotone.strings.similarity.models;

import info.debatty.java.stringsimilarity.interfaces.StringDistance;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * This class represents the result of a comparison between char sequence pair
 * a,b the two factor
 * and score map name algorithm and its score.
 */
public class CharacterSequenceComparison  {

    public CharacterSequence getA() { return a; }

    public CharacterSequence getB() { return b; }

    public Map<Class<?>, Double> getScoreMap() { return scoreMap; }


    public <E extends  CharacterSequence> Class<E> getComparisonClazz(){

       return  ((Class) ((ParameterizedType)b.getClass()
               .getGenericSuperclass())
               .getActualTypeArguments()[0]);

    }

    private final CharacterSequence a;
    private final CharacterSequence b;
    private final Map<Class<?>, Double> scoreMap;

    public CharacterSequenceComparison(CharacterSequence a,
                                          CharacterSequence b,
                                          Map<Class<?>, Double> scoreMap) {
        this.a = a;
        this.b = b;
        this.scoreMap=scoreMap;
    }
}
