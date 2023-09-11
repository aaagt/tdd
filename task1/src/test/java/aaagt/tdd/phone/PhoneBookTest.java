package aaagt.tdd.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookTest {
    @Test
    void addIncreasesCounter() {
        PhoneBook pb = new PhoneBook();

        int actual = pb.add("aaa", "1234567890");
        assertEquals(1, actual);

        actual = pb.add("bbb", "1134567890");
        assertEquals(2, actual);
    }

    @Test
    void addThrowsOnExistingName() {
        Executable run = () -> {
            PhoneBook pb = new PhoneBook();
            pb.add("aaa", "1234567890");
            pb.add("aaa", "1134567890");
        };
        assertThrows(IllegalArgumentException.class, run);
    }
}
