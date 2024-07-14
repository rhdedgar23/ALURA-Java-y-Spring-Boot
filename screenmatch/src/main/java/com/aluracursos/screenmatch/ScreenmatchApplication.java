package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Hola mundo desde Spring!");
//		var consumoApi = new ConsumoAPI();
//		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=5f5d4d86");
//		//var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datosSerie = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datosSerie);
//
//		//para mappear a DatosEpisodio
//		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=5f5d4d86");
//		DatosEpisodio datosEpisodios = conversor.obtenerDatos(json, DatosEpisodio.class);
//		System.out.println(datosEpisodios);
//
//		//Para mappear las temporadas
//		List<DatosTemporadas> temporadas = new ArrayList<>();
//		for (int i = 1; i <=datosSerie.totalDeTemporadas(); i++) {
//			json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=" +
//					i +
//					"&apikey=5f5d4d86");
//			var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
//			temporadas.add(datosTemporadas);
//		}
//		temporadas.forEach(System.out::println);

		Principal principal = new Principal();
		principal.muestraMenu();
	}
}
