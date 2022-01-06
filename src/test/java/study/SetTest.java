package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> number;

    @BeforeEach
    void setUp() {
        number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);
    }

    @Test
    void setSize() throws Exception {

        int size = number.size();

        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkContainNumber(int input) {

        assertThat(this.number.contains(input)).isTrue();

    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void checkContainNumberWithCsvSource(int input, boolean result) {

        assertThat(number.contains(input)).isEqualTo(result);
    }
}
