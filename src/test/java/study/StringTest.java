package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() throws Exception {
        //    "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.

        String oneAndTwo = "1,2";

        String[] split = oneAndTwo.split(",");

        assertThat(split).contains("1", "2");
    }


    @Test
    void split2() throws Exception{
        //    "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String oneAndTwo = "1";

        String[] split = oneAndTwo.split(",");

        assertThat(split).contains("1");
    }

    @Test
    void subString() throws Exception{
        String oneAndTwo = "(1,2)";

        String substring = oneAndTwo.substring(1, oneAndTwo.length()-1);

        assertThat(substring).isEqualTo("1,2");
    }
}
