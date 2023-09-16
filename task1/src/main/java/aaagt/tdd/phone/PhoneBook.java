package aaagt.tdd.phone;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PhoneBook {

    private final Map<String, String> book = new TreeMap<>();

    public int add(String name, String phoneNumber) {
        if (book.containsKey(name)) {
            throw new IllegalArgumentException("Такое имя уже есть");
        }
        book.put(name, phoneNumber);
        return book.size();
    }

    public Optional<String> findByNumber(String phoneNumber) {
        return book.entrySet().stream()
                .filter(contact -> contact.getValue().equals(phoneNumber))
                .map(contact -> contact.getKey())
                .findFirst();
    }
}
