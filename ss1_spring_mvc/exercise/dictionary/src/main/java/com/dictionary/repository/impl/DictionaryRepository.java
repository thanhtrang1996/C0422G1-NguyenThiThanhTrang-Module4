package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("hi", "Xin Chào");
        dictionaryMap.put("no", "không");
        dictionaryMap.put("cute", "dễ thương");
        dictionaryMap.put("dog", "con chó");
        dictionaryMap.put("cat", "con mèo");
        dictionaryMap.put("hot", "nóng");
        dictionaryMap.put("love", "yêu");
    }
    @Override
    public String listDictionary(String name) {
        String dictionary = dictionaryMap.get(name);
        if (dictionary == null) {
            dictionary = "not found";
        }
        return dictionary;
    }
}
