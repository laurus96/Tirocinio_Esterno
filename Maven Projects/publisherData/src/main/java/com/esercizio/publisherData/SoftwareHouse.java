package com.esercizio.publisherData;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class SoftwareHouse {
	
	private static SoftwareHouse instance = null; 
	
	private Long id;
	private String name;
	private Integer numberOfEmployees;
	private String foundationYear;
	private List<Game> games;

	public static SoftwareHouse getInstance() {
		if(instance == null) {
			instance = new SoftwareHouse();
		}
		return instance;
	}

	public static SoftwareHouse getInstance(Long id) {
		if(instance == null) {
			instance = new SoftwareHouse(id);
		}
		return instance;
	}
	
	private SoftwareHouse() {

	}
	
	private SoftwareHouse(Long id) {
		this(id, null, null, null, null);
	}
	
	private SoftwareHouse(String name) {
		this(null, name, null, null, null);
	}
	
	private SoftwareHouse(Long id, String name, Integer numberOfEmployees, String year, Game game) {
		this.id = id;
		this.name = name;
		this.numberOfEmployees = numberOfEmployees;
		this.foundationYear = year;

		this.addGame(game);
		
	}

	public Game getGame(String name){
		for(Game game : this.games) {
			if(game.getName().compareTo(name) == 0) {
				return game;
			}
		}
		
		return new Game();
	}
	
	public Game getGame(Long id){
		for(Game game : this.games) {
			if(game.getId() == id) {
				return game;
			}
		}
		
		return null;
	}

	public void setGames(List<Game> games) {
		if(!this.games.isEmpty() ) {
			for(Game g : this.games) {
				if(!this.games.contains(g))
					this.games.add(g);
			}
		} else
			this.games = games;
		
	}

	public List<Game> getGames(){
		return this.games;
	}
	
	public void addGame(Game game) {
		if (this.games == null || this.games.contains(game)) {
			this.games = new LinkedList<>();
		}
		if (game != null)
			this.games.add(game);

	}


	public void addGame(Long id, String name, String platform, String publicationYear){
		if(this.getGames() == null || this.getGames().isEmpty())
				this.setGames(new LinkedList<>());
		this.games.add(new Game(id));

		int lastIndexFull = this.games.size() - 1;
		this.games.get(lastIndexFull).setName(name);
		this.games.get(lastIndexFull).addPlatform(platform);
		this.games.get(lastIndexFull).setPublicationYear(publicationYear);

	}
	
	@Override
	public String toString() {
		
		String allGames = "";
		
		if(this.getGames() != null) {
			
			for (Game game : this.games) {
				allGames = allGames + game.toString() + ",\n\n";
			}
		}
		else if (this.games.isEmpty())
			allGames = allGames + " Nessun gioco pubblicato";

		
		return String.format("%s: \nIdentificativo: %d \nNumero di impiegati: %d \nAnno di fondazione: %s \nGiochi Publicati:\n\n %s",
				this.name,
				this.id,
				this.numberOfEmployees,
				this.foundationYear,
				allGames);
				
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = hash * 67 + (this.id != null ? this.id.hashCode() : 0);
		hash = hash * 67 + (this.name != null ? this.name.hashCode() : 0);
		hash = hash * 67 + (this.numberOfEmployees != 0 ? this.numberOfEmployees : 0);
		hash = hash * 67 + (this.foundationYear != null ? this.foundationYear.hashCode() : 0);
		hash = hash * 67 + (this.games != null ? this.games.hashCode() : 0);
		
		return hash;
	}
	
	@Override 
	public SoftwareHouse clone() {
		SoftwareHouse ob =  new SoftwareHouse();
		ob.setId(this.id);
		ob.setName(this.name);
		ob.setNumberOfEmployees(this.numberOfEmployees);
		ob.setFoundationYear(this.foundationYear);
		
		if(this.games.size() == 1)
			ob.addGame(((LinkedList<Game>) this.games).getFirst());
		else
			ob.setGames(this.games);
		
		return ob;
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		
		SoftwareHouse ob = (SoftwareHouse) o;
		
		if(this.id == ob.getId() &&
				this.name.toLowerCase().compareTo(ob.getName().toLowerCase()) == 0 &&
				this.numberOfEmployees == ob.getNumberOfEmployees() &&
				this.foundationYear.compareTo(ob.getFoundationYear()) == 0 &&
				this.games.equals(ob.getGames())
				)
			return true;
		
		return false;

	}
	
}
