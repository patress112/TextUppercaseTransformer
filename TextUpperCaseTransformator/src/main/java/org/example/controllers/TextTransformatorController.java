package org.example.controllers;

import org.example.models.TextTransformerDTO;
import org.example.models.TextTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TextTransformatorController {

    @Autowired
    private TextTransformerService textService;

    @GetMapping("/")
    public String renderTextTransformator(Model model) {
        model.addAttribute("pageTitle", "My Own Spring Boot TextUpperCase Transformator 😎😁");
        model.addAttribute("textTransformerDTO", new TextTransformerDTO());

        return "index";
    }

    @PostMapping("/")
    public String renderTransformedText(Model model,
                                        @ModelAttribute TextTransformerDTO text) {
        model.addAttribute("pageTitle", "My Own Spring Boot TextUpperCase");
        String transformedText = textService.transformText(text);
        model.addAttribute("transformedText", transformedText);

        return "index";
    }


}
