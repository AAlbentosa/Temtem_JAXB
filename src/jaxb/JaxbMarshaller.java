package jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Player;
import model.Players;

public class JaxbMarshaller {
	
	public void init (Players players) {
		try {
			JAXBContext context = JAXBContext.newInstance(Players.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(players, new File("files/salida.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}


}
