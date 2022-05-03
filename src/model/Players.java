package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jugadores")
public class Players {
	
	@XmlElement(name="jugador")
	private ArrayList<Player> players;
	
	public Players() {}
	
	public Players(ArrayList<Player> players) {
		this.players=players;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Temtem fecthTemtemById(String args){
		for(Player p:players) 
			for(Temtem t:p.getTemtems())
				if(t.getId().equals(args)) 
					return t;

		return null;
	}

	public Player getPlayerById(int id) {
		for(Player p:players) 
			if(p.getId()==id) 
				return p;
		
		return null;
	}

}
