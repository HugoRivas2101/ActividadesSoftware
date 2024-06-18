import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.example.CountWords;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assert.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CountWordsTest {
    @Test
    void twoWordsEndingWithS() { // 1
        int words = new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void noWordsAtAll(){
        int words=new CountWords().count("hola mundo");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void wordsThatEndInR() { // 1
        int words = new CountWords().count("car bar");
        assertThat(words).isEqualTo(2);
    }
    @Test
    void testCountWordsEndingWithS(){
        int words=new CountWords().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }
    @Test
    void testEmptyString(){
        int word=new CountWords().count("");
        assertThat(word).isEqualTo(0);
    }
}
