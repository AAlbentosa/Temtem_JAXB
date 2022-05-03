package model;

import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="temtem")
@XmlType(propOrder= {"id", "name", "type", "attributes"})
public class Temtem {
	
	private String id;
	private String name;
	private String type;
	private ArrayList<Attribute> attributes;
	
	public Temtem() {
	}

	public Temtem(String id, String name, String type, Attribute[] attributes) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.attributes=new ArrayList<Attribute>(Arrays.asList(attributes));
	}

	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name="nombre")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="tipo")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	@XmlElement(name="atributo")
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		String str="";
		for(Attribute a: attributes)
			str+=a.toString()+"\n";
		return str;
	}
	
	
}
