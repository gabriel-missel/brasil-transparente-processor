package com.brasil.transparente.processor.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class ProperCaseFormatter {
    private static final Set<String> LOWERCASE_WORDS = new HashSet<>(Arrays.asList(
            "da", "de", "do", "das", "dos", "e", "em", "para", "com", "sem", "sob", "sobre", "pelo", "pela", "pelos", "pelas"
    ));

    public static String convertToProperCase(String text) {
        text = text.toLowerCase();
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i > 0 && LOWERCASE_WORDS.contains(word)) {
                result.append(word);
            } else {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1));
            }

            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
