package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Player;
import model.Players;

public class JaxbUnMarshaller {
	
	public Players init () {
		Players players = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Players.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			players = (Players) unmarshaller.unmarshal(new File("files/entrada.xml"));
			return players;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
