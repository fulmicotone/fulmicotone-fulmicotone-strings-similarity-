package com.fulmicotone.strings.similarity.models;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * A Chunk Sequence
 * @see Chunk
 */
public class Phrase extends CharacterSequence<Chunk> {

    private final String delimiter;

    public Phrase(String delimiter,CharacterSequence context,
                  int sortIndex,
                  String sequence) {

        super(context, sortIndex, sequence);
        this.delimiter=delimiter;
    }



    @Override
    public Stream<Chunk> asUnitStream() {
        AtomicInteger i=new AtomicInteger(0);
        return

                Stream.of(sequence.split(Pattern.quote(delimiter)))
                        .map(str-> new Chunk(this, i.incrementAndGet(), str));
    }
}
