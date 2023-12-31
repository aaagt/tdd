package aaagt.tdd.phone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    void findByNumber() {
        PhoneBook pb = new PhoneBook();
        pb.add("aaa", "1234567890");
        pb.add("bbb", "1212121212");
        pb.add("ccc", "1111111111");
        assertAll(
                () -> assertEquals(pb.findByNumber("1234567890").get(), "aaa"),
                () -> assertEquals(pb.findByNumber("1111111111").get(), "ccc"),
                () -> assertEquals(pb.findByNumber("1212121212").get(), "bbb")
        );
    }

    @Test
    void findByName() {
        PhoneBook pb = new PhoneBook();
        pb.add("aaa", "1234567890");
        pb.add("bbb", "1212121212");
        pb.add("ccc", "1111111111");
        assertAll(
                () -> assertEquals(pb.findByName("aaa").get(), "1234567890"),
                () -> assertEquals(pb.findByName("ccc").get(), "1111111111"),
                () -> assertEquals(pb.findByName("bbb").get(), "1212121212")
        );
    }

    @Test
    void printAllNames() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        PhoneBook pb = new PhoneBook();
        pb.add("aaa", "1234567890");
        pb.add("bbb", "1212121212");
        pb.add("ccc", "1111111111");

        pb.printAllNames();

        assertEquals("""
                        aaa: 1234567890
                        bbb: 1212121212
                        ccc: 1111111111
                        """,
                outputStreamCaptor.toString());
    }
}
