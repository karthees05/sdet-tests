package com.test.qa;

import org.junit.Assert;
import org.junit.Test;

public class MaxWordsInSentence {


    public int maxCount(String paragraphText) {
        int maxWordCount = 0;
        // Split the paragraph into sentences using regular expressions
        String[] sentences = paragraphText.split("[.!?]");


        for (String sentence : sentences) {
            // Split the sentence into words using space as a delimiter
            String[] words = sentence.trim().split("\\s+");

            if (words.length > maxWordCount) {
                maxWordCount = words.length;
            }
        }
        return maxWordCount;
    }

    @Test
    public void test1() {
        String paragraph = "a b c d e f g h. This is the first sentence. The second sentence has more words. The third sentence is the longest.";
        Assert.assertEquals(8,maxCount(paragraph));
    }
}
