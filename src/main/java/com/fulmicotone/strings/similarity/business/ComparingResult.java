package com.fulmicotone.strings.similarity.business;

import com.fulmicotone.strings.similarity.models.CharacterSequenceComparison;
import com.fulmicotone.strings.similarity.models.Phrase;
import com.fulmicotone.strings.similarity.utils.CharacterSequenceUnit;
import sun.awt.util.IdentityLinkedList;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;



public class ComparingResult  extends ArrayList<CharacterSequenceComparison> {


    private Map<CharacterSequenceUnit, List<CharacterSequenceComparison>> map=new HashMap<>();

    @Override
    public boolean add(CharacterSequenceComparison characterSequenceComparison) {

        CharacterSequenceUnit inUnit = CharacterSequenceUnit
                .of(characterSequenceComparison
                        .getComparisonClazz());

        map.putIfAbsent(inUnit,new ArrayList<>());

        ArrayList<Object> x = new ArrayList<>();

       // x.remo

        map.keySet().stream().filter(k-> k.getDeepLevel()<inUnit.getDeepLevel());
           //     .

        return super.add(characterSequenceComparison);
    }
}