package manager;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import dao.Reader;
import gui.TemtemFrame;
import jaxb.JaxbMarshaller;
import jaxb.JaxbUnMarshaller;
import model.Player;
import model.Players;
import model.Temtem;

public class Manager {
	
	private Players players;
	
	public Manager(){
		
	}
	
	public void init(){
		players=(new JaxbUnMarshaller()).init();
		readFile();
	}

	private void readFile() {
		Reader reader=new Reader("files/acciones.txt");
		String line;
		String[] args;
		
		while((line = reader.getLine())!=null) {
			System.out.println(line);
			int temtemID, playerID;
			args=line.split(" ");
			
			switch(args[0]) {
				case "M":
					showTemtem(args[1]);
					break;
				case "P":
					System.out.println(players.getPlayerById(Integer.parseInt(args[1]))+"\n");
					break;
				case "B":
					players.getPlayerById(Integer.parseInt(args[1])).removeTemtem(args[2]);
					break;
				case "A":
					addTemtem(args);
					break;
				case "S":
					(new JaxbMarshaller()).init(players);
					break;
				default:
					System.out.println("Acción erronea");
					break;
			}
		}
		reader.close();
	}

	private void addTemtem(String[] temtemData) {
		if(temtemData.length==12) {
			Player player=players.getPlayerById(Integer.parseInt(temtemData[1]));
			player.addTemtem(Arrays.copyOfRange(temtemData,2,12));
			System.out.println("Temtem anadido\n");
		}else {
			System.out.println("Accion erronea\n");
		}
		
	}

	private void showTemtem(String id) {
		Temtem temtem=players.fecthTemtemById(id);
		if(temtem !=null) {
			TemtemFrame frame=new TemtemFrame();
			frame.showImage(temtem.getName());
			System.out.println(temtem.toString());
		}else
			System.out.println("Temtem no encontrado.\n");
	}
}
