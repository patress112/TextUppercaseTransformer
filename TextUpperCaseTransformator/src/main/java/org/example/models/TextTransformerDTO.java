package org.example.models;


// Toto je DTO trieda, ktorá obsahuje dáta z formulára - v našom prípade obsah textarea elementu
public class TextTransformerDTO {
    // Atribúty
    private String text;

    // Konštruktor - trieda musí mať bezparametrický konštruktor
    public TextTransformerDTO() {};

    // Gettery a settery
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
