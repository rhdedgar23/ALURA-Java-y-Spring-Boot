package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        //la instancia objectMapper transforma nuestro json a la clase que le proporcionamos
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //Si en el futuro escalamos nuestra aplicacion y tenemos otros tipos de datos
    //diferentes a Serie, nos conviene crear una clase generica
//    public DatosSerie obtenerDatos(String json){
//
//    }
}
