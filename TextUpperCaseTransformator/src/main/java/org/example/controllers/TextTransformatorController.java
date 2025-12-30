package org.example.controllers;

import org.example.models.TextTransformerDTO;
import org.example.models.TextTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


// Toto je controller trieda, obsluhujúca URL endpointy. Jej úloha je vracať HTML šablóny, prípadne najprv pomocou service tried vykonať nejaké výpočty / úlohy, výsledoky dosadiť do HTML šablóny a napokon kompletnú šablónu vrátiť
@Controller
public class TextTransformatorController {

    // Pre používanie service metód si do atribútov pridáme service inštanciu a označíme ju anotáciou @Autowired
    @Autowired
    private TextTransformerService textService;

    /**
     * Toto je základná metóda renderujúca index.html šablónu na URL localhost:8080
     * Do jej argumentu vložíme model
     * @param model
     * @return
     */
    @GetMapping("/")
    public String renderTextTransformator(Model model) {
        // Vytvoríme premennú pageTitle, do ktorej vložíme text nadpisu
        model.addAttribute("pageTitle", "My Own Spring Boot TextUpperCase Transformator 😎😁");
        // Vytvoríme aj premennú, do ktorej vložíme prázdny DTO objhkt - keďže ho používame vo formulári v index.html ako th:object
        model.addAttribute("textTransformerDTO", new TextTransformerDTO());

        return "index";
    }

    /**
     * Táto metóda obsluhuje odoslanie formulára
     * Vložíme do jej argumentov Model a aj DTO
     * Keďže sme v controlleri, musíme pri DTO použiť anotáciu @ModelAttribute
     *
     * @param model
     * @param text
     * @return
     */
    @PostMapping("/")
    public String renderTransformedText(Model model,
                                        @ModelAttribute TextTransformerDTO text) {
        // Vytvoríme opäť premennú, v ktorej bude uložený nadpis
        model.addAttribute("pageTitle", "My Own Spring Boot TextUpperCase");
        // Vytvoríme premennú, v ktorej pomocou service triedy bude uložený text z DTO na upperCase
        String transformedText = textService.transformText(text);
        // Vytvoríme si nakoniec do šablóny aj premennú s finálnym textom
        model.addAttribute("transformedText", transformedText);

        // Napokon vrátime šablónu
        return "index";
    }


}
