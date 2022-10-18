package com.esercizio.publisherData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
	
	private static final String playstationFileName = "File/playstation.txt";
	
    public static void main( String[] args ) {

    	Map<Integer, SoftwareHouse> playstation = new HashMap<>();
    	
    	List<Game> santaMonicaGames = new LinkedList<>();

		/*santaMonicaGames.add(new Game(0L));
		santaMonicaGames.get(0).setName("God Of War");
		santaMonicaGames.get(0).addPlatform("Playstation 2");
		santaMonicaGames.get(0).setPublicationYear("2005");

		santaMonicaGames.add(new Game(1L));
		santaMonicaGames.get(1).setName("God Of War II");
		santaMonicaGames.get(1).addPlatform("Playstation 2");
		santaMonicaGames.get(1).setPublicationYear("2007");

		santaMonicaGames.add(new Game(2L));
		santaMonicaGames.get(2).setName("God Of War III");
		santaMonicaGames.get(2).addPlatform("Playstation 3");
		santaMonicaGames.get(2).setPublicationYear("2010");

		santaMonicaGames.add(new Game(3L));
		santaMonicaGames.get(3).setName("God Of War");
		santaMonicaGames.get(3).addPlatform("Playstation 4");
		santaMonicaGames.get(3).setPublicationYear("2018");*/

		SoftwareHouse santaMonica = SoftwareHouse.getInstance(0L);

		santaMonica.addGame(0L, "God Of War", "Playstation 2", "2005"  );
		santaMonica.addGame(1L, "God Of War II", "Playstation 2", "2007"  );
		santaMonica.addGame(2L, "God Of War III", "Playstation 3", "2010"  );

        santaMonica.setName("Santa Monica Studio");
        santaMonica.setNumberOfEmployees(300);
        santaMonica.setFoundationYear("1999");
        santaMonica.setGames(santaMonicaGames);
        
        playstation.put(santaMonica.hashCode(), santaMonica);

        System.out.println("Stampa Studi Playstation: ");
		System.out.println(" ");

        playstation.forEach((key, value) -> System.out.println(value.toString()));

        
        try {

			WriterService writerService = new WriterService();
			writerService.log(writerService.write(playstationFileName, playstation));

			/*File playstationFile = new File(playstationFileName);
        	if (playstationFile.createNewFile())
        		System.out.println("File Playstation creato.");
        	else
        		System.out.println("File Playstation già esistente.");
        		
        	
        	FileWriter playstationWriter = new FileWriter(playstationFileName);
        	String playstationJson = gson.toJson(playstation);
        	playstationWriter.write(playstationJson);
        	System.out.println("Scrittura completata su " + playstationFileName);
        	
        	
        	playstationWriter.close();*/

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
