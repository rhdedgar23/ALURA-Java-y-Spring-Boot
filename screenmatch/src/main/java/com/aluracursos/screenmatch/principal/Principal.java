package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=5f5d4d86";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){
        System.out.println("Escribe el nombre de la serie que deseas buscar: ");
        var nombreSerie = teclado.nextLine();

        //Obtener datos de series
        var json = consumoApi.obtenerDatos( URL_BASE +
                nombreSerie.replace(" ", "+") +
                API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Obtener datos de temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE +
                    nombreSerie.replace(" ", "+") +
                    "&Season=" +
                    i +
                    API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);
        
        //Mostrar solo el titulo de los episodios para las temporadas
        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }

        //Mostrar titulos de episodios usando funciones Lambda
        //Para cada t en temporadas, obten la lista de episodios
        //y a su vez, para cada lista de episodios, obten para cada episodio su titulo
        temporadas.forEach(t -> t.episodios()
                .forEach(e -> System.out.println(e.titulo())));
    }
}
