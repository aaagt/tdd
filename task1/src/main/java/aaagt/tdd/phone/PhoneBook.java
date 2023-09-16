package aaagt.tdd.phone;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String, String> book = new HashMap<>();

    public int add(String name, String phoneNumber) {
        if (book.containsKey(name)) {
            throw new IllegalArgumentException("Такое имя уже есть");
        }
        book.put(name, phoneNumber);
        return book.size();
    }

    public String findByNumber(String phoneNumber) {
        return null;
    }
}
