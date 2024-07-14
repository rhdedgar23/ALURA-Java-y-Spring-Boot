package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//Usamos @JsonIgnoreProperties para descartar cualquier propiedad de nuestro json
//que no querramos en nuestra clase DatosSerie mas alla de las que nosotros
//especificamos con anterioridad
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        //@JsonAlias mappea la variable que obtiene de la API
        //a una variable de nuestra aplicacion
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion)
        //tambien podemos usar la anotacion @JsonProperty,
        //que a diferencia de @JsonAlias, tambien puede escribir
        //y no solo leer
        {
}
