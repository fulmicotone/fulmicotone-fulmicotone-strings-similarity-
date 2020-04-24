package com.fulmicotone.strings.similarity.models;



import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Any words sequence
 * @see Word
 * Essentially a Character Sequence
 *divided by the empty spaces
 */
public class Chunk extends CharacterSequence<Word> {


    protected Chunk(CharacterSequence context, int sortIndex, String sequence) {
        super(context, sortIndex, sequence);
    }


    @Override
    public Stream<Word> asUnitStream(){

       AtomicInteger i=new AtomicInteger(0);
       return

            Stream.of(sequence.split(Pattern.quote(" ")))
            .map(str-> new Word(this, i.incrementAndGet(), str));
   }


}
