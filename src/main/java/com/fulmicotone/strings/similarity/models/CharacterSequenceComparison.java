package com.fulmicotone.strings.similarity.models;

import java.util.Map;
import java.util.Objects;

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

       return (Class<E>) b.getClass();

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


    @Override
    public int hashCode() {
        return Objects.hash(a.sequence, b.sequence);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj == null || obj.getClass()!= this.getClass()) return false;

        CharacterSequenceComparison o = (CharacterSequenceComparison) obj;

        return (o.a.sequence
                .equals(this.a.sequence) &&
                o.b.sequence
                        .equals(this.b.sequence));
    }
}
