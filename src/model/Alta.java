package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
@XmlRootElement(name="alta")
@XmlType(propOrder= {"city"})
public class Alta {
	
	private String city;
	private String date;
	public Alta() {
	}
	
	@XmlAttribute(name="ciudad")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@XmlValue
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date=date;
	}
	
	@Override
	public String toString() {
		return "Alta [city=" + city + " date= "+date+"]";
	}
	
}
