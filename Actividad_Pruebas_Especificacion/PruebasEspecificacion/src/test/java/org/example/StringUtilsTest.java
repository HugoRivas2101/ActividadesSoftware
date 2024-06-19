package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.StringsUtils.substringsBetween;
import static org.junit.jupiter.api.Assertions.*;



public class StringUtilsTest {


    @Test
    void simpleTest(){
        StringsUtils stringUtils=new StringsUtils();
        assertThat(substringsBetween("axcaycazc","a","c")).isEqualTo(new String[]{"x","y","z"});
    }

    @Test
    void manyStrings(){
        StringsUtils stringUtils=new StringsUtils();
        assertThat(substringsBetween("abcdabcdabcd","a","d")).isEqualTo(new String[]{"bc","bc","bc"});
    }

    @Test
    void openAndCloseTagsThatAreLongerThan1Char(){
        StringsUtils stringsUtils=new StringsUtils();
        assertThat(substringsBetween("aabcddaabfddaab","aa","dd")).isEqualTo(new String[]{"bc","bf"});
    }
    @Test
    void strOfLength1() {
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "a", "a")).isEqualTo(null);
    }
    @Test
    void openAndCloseOfLength1() {
        assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "c")).isEqualTo(new String[]{"b"});
    }
    @Test
    void openAndCloseTagsOfDifferentSizes() {
        assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
        assertThat(substringsBetween("aabbcc", "aa", "cc")).isEqualTo(new String[]{"bb"});
        assertThat(substringsBetween("aabbccaaeecc", "aa", "cc")).isEqualTo(new String[]{"bb", "ee"});
    }
    @Test
    void notSubstringBetweenOpenAndCloseTags() {
        assertThat(substringsBetween("aabb", "aa", "bb")).isEqualTo(new String[]{""});
    }
}
