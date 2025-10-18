package com.example.imc;

public class CardModel {
    String titulo;
    float pesoKG;
    float altura;
    float resultadoIMC;

    public CardModel(String titulo, float pesoKG, float altura, float resultadoIMC) {
        this.titulo = titulo;
        this.pesoKG = pesoKG;
        this.altura = altura;
        this.resultadoIMC = resultadoIMC;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPesoKG() {
        return pesoKG;
    }

    public void setPesoKG(float pesoKG) {
        this.pesoKG = pesoKG;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getResultadoIMC() {
        return resultadoIMC;
    }

    public void setResultadoIMC(float resultadoIMC) {
        this.resultadoIMC = resultadoIMC;
    }
}
