package study;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

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


}
