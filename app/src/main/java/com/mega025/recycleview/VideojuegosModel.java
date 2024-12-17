package com.mega025.recycleview;

public class VideojuegosModel {
    public String preguntas;
    public String colors;
    public String imagen;

    public VideojuegosModel(String preguntas, String colors) {
        this.preguntas = preguntas;

    }
    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getColors() {
        return colors;
    }
}
