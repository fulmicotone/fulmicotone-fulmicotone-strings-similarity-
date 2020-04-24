package com.fulmicotone.strings.similarity.business;

import com.fulmicotone.strings.similarity.models.Phrase;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;


/**
 * This Class get a text as input
 * and Normalizing it as indicated in the builder
 * return Phrase Object
 * @see Phrase
 * dividing the phrase in chunk
 * @see com.fulmicotone.strings.similarity.models.Chunk
 */
public class PhraseFactory implements Function<String, Phrase> {

    private final int minWordLength;
    private final boolean applyLowerCase;
    private final String delimiter;
    private final Map<String,String> replacements;

    private PhraseFactory(int minWordLength,
                          boolean applyLowerCase,
                          String delimiter,
                          Map<String,String> replacements){

        this.minWordLength =minWordLength;
        this.applyLowerCase=applyLowerCase;
        this.delimiter=delimiter;
        this.replacements =replacements;
    }
                            
    @Override
    public Phrase apply(String inputText) {

         inputText = applyLowerCase?inputText.toLowerCase():inputText;

         //all replacement
         for( Map.Entry<String,String>e : replacements.entrySet())
         { inputText=inputText.replace(e.getKey(),e.getValue());}

        if(minWordLength!=-1)
        for(String term: inputText.split(Pattern.quote(" "))){
            if(term.length()<=minWordLength){inputText=inputText.replace(term,"");}
        }
         inputText= inputText.replaceAll("\\s+", " ");

        return new Phrase(delimiter,null,-1,inputText);
    }


    public static Builder newOne(){ return new Builder(); }


    public static class Builder{

        private   int minWordLength =-1;
        private  boolean applyLowerCase=true;
        private  String delimiter=" ";
        private  Map<String,String> replacements=new HashMap<>();


        public Builder withMinWordLength(int length){
            this.minWordLength=length;
            return this;
        }

        public Builder withApplyLowerCase(boolean
                                                  apply){
            this.applyLowerCase=apply;
            return this;
        }

        public Builder withSplitterDelimiter(String delimiter){
            this.delimiter=delimiter;
            return this;
        }


        public Builder addReplacement(String word,String replace){
            replacements.putIfAbsent(word,replace);
            return this;
        }


        public Builder addWordToExclude(String word){
            replacements.putIfAbsent(word,"");
            return this;
        }

        public PhraseFactory standard(){ return build(); }

        public PhraseFactory build(){

            return new PhraseFactory(
                    minWordLength,
                    applyLowerCase,
                    delimiter,
                    replacements
                    );
        }


    }


}
