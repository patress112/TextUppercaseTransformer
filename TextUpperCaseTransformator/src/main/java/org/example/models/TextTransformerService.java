package org.example.models;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class TextTransformerService {

    // Metódy
    public String transformText(TextTransformerDTO text) {
        String originalText = text.getText();
        String transformedText = originalText.toUpperCase();

        return transformedText;
    }

}
