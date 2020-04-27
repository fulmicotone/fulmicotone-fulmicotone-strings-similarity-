package com.fulmicotone.strings.similarity.utils;

import com.fulmicotone.strings.similarity.models.CharacterSequence;
import com.fulmicotone.strings.similarity.models.Chunk;
import com.fulmicotone.strings.similarity.models.Phrase;
import com.fulmicotone.strings.similarity.models.Word;

public enum CharacterSequenceUnit {
    PHRASE(Phrase.class,1),
    CHUNK(Chunk.class,2),
    WORD(Word.class,3);

    private Class clazz;
    private int deepLevel;

    CharacterSequenceUnit(Class clazz,int deepLevel){ this.clazz=clazz; this.deepLevel=deepLevel; }

    public <E extends  CharacterSequence > Class<E> getUnitClass(){ return this.clazz; }

    public Class getClazz() { return clazz; }

    public int getDeepLevel() { return deepLevel; }

   public static  CharacterSequenceUnit of(Class clazz){
        for(CharacterSequenceUnit unit :values()){
            if(unit.clazz==clazz){ return unit; }
        }
        return null;
    }

}
