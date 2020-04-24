package com.fulmicotone.strings.similarity.utils;

import com.fulmicotone.strings.similarity.models.CharacterSequence;
import info.debatty.java.stringsimilarity.JaroWinkler;
import info.debatty.java.stringsimilarity.experimental.Sift4;
import info.debatty.java.stringsimilarity.interfaces.StringDistance;



public enum StringDistanceAlgorithms {


    JAROWINKLER(JaroWinkler.class,new JaroWinkler()),
    Sift4(Sift4.class,new Sift4());

    private Class clazz;
    private StringDistance instance;

    StringDistanceAlgorithms(Class clazz,StringDistance instance){
        this.clazz=clazz;
    this.instance =instance;
    }

    public <E extends  StringDistance > Class<E> getAlgorithmClass(){ return this.clazz; }

    public StringDistance getInstance()
    {return instance;}
}
