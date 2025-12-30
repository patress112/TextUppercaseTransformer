package org.example.models;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

// Táto trieda obsahuje biznis logiku aplikácie
// Označíme ju anotáciou @Service
@Service
public class TextTransformerService {

    // Metódy

    /**
     * Vytvoríme metódu na transformáciu textu
     * Metóda prjme ako argument obsah DTO prepravky
     * V modeli nepotrebujeme používať @ModelAttribute pri DTO, to len v controlleri
     * @param text
     * @return
     */
    public String transformText(TextTransformerDTO text) {
        // Originálny text od užívateľa získame z DTO cez getter a uložíme ho do premennej
        String originalText = text.getText();
        // Do novej premennej uložíme transformovaný text
        String transformedText = originalText.toUpperCase();

        // Nakoniec túto premennú vrátime, aby sme s ňou mohli neskôr pracovať
        return transformedText;
    }

}
