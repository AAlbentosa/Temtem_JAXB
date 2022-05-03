package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="jugador")
@XmlType(propOrder= {"id", "nombre", "alta", "objects", "temtems"})
public class Player {
	
	private int id;
	private String nombre;
	private Alta alta;
	private ArrayList<Object> objects;
	private ArrayList<Temtem> temtems;
	
	
	public Player() {
	}
	
	@XmlAttribute(name="id")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="alta")
	public Alta getAlta() {
		return alta;
	}


	public void setAlta(Alta alta) {
		this.alta = alta;
	}
	
	@XmlElementWrapper(name="objetos")
	@XmlElement(name="objeto")
	public ArrayList<Object> getObjects() {
		return objects;
	}


	public void setObjects(ArrayList<Object> objects) {
		this.objects = objects;
	}
	
	@XmlElementWrapper(name="temtems")
	@XmlElement(name="temtem")
	public ArrayList<Temtem> getTemtems() {
		return temtems;
	}


	public void setTemtems(ArrayList<Temtem> temtems) {
		this.temtems = temtems;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", nombre=" + nombre + ", alta=" + alta + ", objects=" + getObjectsQty() + ", temtems="
				+ temtems.size() + "]";
	}

	private int getObjectsQty() {
		int qty=0;
		for(Object o: objects)
			qty+=o.getQuantity();
		
		return qty;
	}
	
	public void removeTemtem(String id) {
		boolean temtemRemoved=false;
		
		for(Temtem t: new ArrayList<Temtem>(temtems))
			if(t.getId().equals(id)) {
				temtems.remove(t);
				temtemRemoved=true;
				break;
			}
		
		if(temtemRemoved)
			System.out.println("Temtem borrado\n");
		else
			System.out.println("Temtem no encontrado\n");
	}

	public void addTemtem(String[] temtemData) {
		String id=temtemData[0];
		String name=temtemData[1];
		String type=temtemData[2];
		Attribute[] attributes= { 
			new Attribute("PS", Integer.parseInt(temtemData[3])),
			new Attribute("ATQ", Integer.parseInt(temtemData[4])),
			new Attribute("SATQ", Integer.parseInt(temtemData[5])),
			new Attribute("STA", Integer.parseInt(temtemData[6])),
			new Attribute("VEL", Integer.parseInt(temtemData[7])),
			new Attribute("DEF", Integer.parseInt(temtemData[8])),
			new Attribute("SDEF", Integer.parseInt(temtemData[9]))
		};
		
		temtems.add(new Temtem(id, name, type, attributes));
	}
}
