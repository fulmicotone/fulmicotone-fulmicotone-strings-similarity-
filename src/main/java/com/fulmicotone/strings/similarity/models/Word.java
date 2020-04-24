package com.fulmicotone.strings.similarity.models;


import java.util.stream.Stream;

/**
 * Rapresent a single word
 */
public class Word  extends CharacterSequence<Word> {

    protected Word(CharacterSequence context, int sortIndex, String sequence) {
        super(context, sortIndex, sequence);
    }

    @Override
    public Stream<Word> asUnitStream() { return Stream.empty(); }

    @Override
    public String toString() {
        return sequence;
    }
}

