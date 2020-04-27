package com.fulmicotone.strings.similarity.business;

import com.fulmicotone.strings.similarity.models.CharacterSequence;
import com.fulmicotone.strings.similarity.models.CharacterSequenceComparison;
import com.fulmicotone.strings.similarity.utils.CharacterSequenceUnit;

import java.util.*;


public class ComparingResult  {


    private Map<CharacterSequenceUnit, List<CharacterSequenceComparison>> mapBySeqUnit =new HashMap<>();

    protected ComparingResult(List<CharacterSequenceComparison> list){ list.forEach(this::add); }

    public boolean add(CharacterSequenceComparison characterSequenceComparison) {

        CharacterSequenceUnit inUnit = CharacterSequenceUnit
                .of(characterSequenceComparison
                        .getComparisonClazz());
       return  Optional.ofNullable(mapBySeqUnit.putIfAbsent(inUnit, new LinkedList<>()))
                .orElse(mapBySeqUnit.get(inUnit))
                .add(characterSequenceComparison);
    }



    public <E extends CharacterSequenceComparison> List<E> getByUnit(CharacterSequenceUnit unit){

        return (List<E>) mapBySeqUnit.get(unit);

    }
}