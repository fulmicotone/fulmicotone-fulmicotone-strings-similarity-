package com.fulmicotone.strings.similarity.models;


import java.util.stream.Stream;

/**
 * Any CharSequence
 * also  divisible into smaller parts
 * through asUnitStream method
 * @param <Unit>
 */
public abstract class CharacterSequence<Unit extends CharacterSequence> {

    protected   final CharacterSequence parent;

    protected final int sortIndex;

    public CharacterSequence getParent() {
        return parent;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public String getSequence() {
        return sequence;
    }

    protected final String sequence;


    public CharacterSequence(CharacterSequence context, int sortIndex, String sequence){

        this.parent=context;
        this.sequence =sequence;
        this.sortIndex=sortIndex;
    }

    public abstract Stream<Unit> asUnitStream();

    @Override
    public String toString() {return sequence; }
}

