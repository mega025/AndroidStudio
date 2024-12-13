package com.mega025.recycleview;

public class VideojuegosModel {
    public String preguntas;
    public String colors;

    public VideojuegosModel(String preguntas) {
        this.preguntas = preguntas;

    }

    public String getPreguntas() {
        return preguntas;
    }

    public String getColors() {
        return colors;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}
