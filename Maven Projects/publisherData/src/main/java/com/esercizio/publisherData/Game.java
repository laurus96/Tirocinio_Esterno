package com.esercizio.publisherData;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Game {
	
	private Long id;
	private String name;
	private List<String> platform;
	private String publicationYear;
	
	public Game() {
	
	}
	
	public Game(Long id) {
		this(id, null, null, null);
	}
	
	public Game(String name) {
		this(null, name, null, null);
	}
	

	private Game(Long id, String name, String platform, String year) {
		this.id = id;
		this.name = name;
		this.addPlatform(platform);
		this.publicationYear = year;
				
	}
	
	
	public void addPlatform(String platform) {
		if (this.platform == null || this.platform.contains(platform)) {
			this.platform = new LinkedList<>();
		}
		if (platform != null)
			this.platform.add(platform);

	}
	
	@Override
	public String toString() {
		return String.format("%s: \nIdentificativo: %d \nPiattaforma/e: %s \nAnno di Pubblicazione: %s",
				this.name,
				this.id,
				this.platform,
				this.publicationYear);
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = hash * 56 + (this.id != null ? this.id.hashCode() : 0);
		hash = hash * 56 + (this.name != null ? this.name.hashCode() : 0);
		hash = hash * 56 + (this.platform != null ? this.platform.hashCode() : 0);
		hash = hash * 56 + (this.publicationYear != null ? this.publicationYear.hashCode() : 0);
		
		return hash;
		
	}
	
	@Override
	public Game clone() {
		Game g = new Game();
		
		g.id = this.id;
		g.name = this.name;
		g.publicationYear = this.publicationYear;
		
		if(this.platform.size() == 1)
			g.addPlatform(((LinkedList<String>) this.platform).getFirst());
		else
			g.platform = this.platform;
		
		return g;
		
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		
		Game ob = (Game) o;
		
		if(this.id == ob.id &&
				this.name.toLowerCase().compareTo(ob.name.toLowerCase()) == 0 &&
				this.platform.equals(ob.platform) &&
				this.publicationYear.compareTo(ob.publicationYear) == 0)
			return true;
		
		return false;
		
	}
	

}
