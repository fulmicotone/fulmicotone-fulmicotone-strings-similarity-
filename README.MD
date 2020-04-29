
## **strings-similarity**

Simple library to compare two phra
se through different algorithms, already well implemented in debatty / java-string-similarity. The library allows to comparing two text, first as entirety, then as a piece by piece and finally as single words in any combinations. Then each one can implements its own strategy to consider valid  a comparison or not.




###### **Example** 

                //PhraseNormalizerFactory
                //is an object used to define 
                //the input normalization rules
                 
                
                   Similarity s = Similarity.Builder
                .newOne()
                .withFirstFactor(PhraseNormalizerFactory.newOne()
                        .withMinWordLength(3)
                        .withApplyLowerCase(true)
                        .withSplitterDelimiter("/")
                        .build())
                .withSecondFactor(PhraseNormalizerFactory.newOne()
                        .withMinWordLength(3)
                        .withApplyLowerCase(true)
                        .withSplitterDelimiter("-")
                        .build())
                .addPassedStrategy(new OneWordIsEnoughStrategy(), Similarity.Builder.LogicalOperator.OR)
              .build();
              
              boolean willbetrue= s.compare("soccer/player/ball", "soccer and play-shoes-bombastic");

              boolean willbefalse= s.compare("tennis/player/field", "rock and base-shoes-bombastic");




TODO

PhraseNormalizerFactory adding apply trim 
consider when a replacement completely replaces the entire input and therefore only space remains 


[![](https://jitpack.io/v/fulmicotone/fulmicotone-strings-similarity.svg)](https://jitpack.io/#fulmicotone/fulmicotone-strings-similarity)
