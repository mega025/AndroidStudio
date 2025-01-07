package com.mega025.recycleview;

import java.util.ArrayList;

public class VideojuegosModel {
    private String pregunta;
    private String respuestaCorrecta;
    private ArrayList<String> opciones;

    public VideojuegosModel(String pregunta, String respuestaCorrecta, ArrayList<String> opciones) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.opciones = opciones;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String[] getOpciones() {
        return opciones.toArray(new String[0]);
    }
}


