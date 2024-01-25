
package it.vige.nam.stub;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java per noteReportBean complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="noteReportBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="about" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="synopsis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noteReportBean", propOrder = { "about", "description", "policy", "synopsis", "type" })
public class NoteReportBean {

	protected int about;
	protected String description;
	protected int policy;
	protected String synopsis;
	protected int type;

	/**
	 * Recupera il valore della proprietà about.
	 * 
	 */
	public int getAbout() {
		return about;
	}

	/**
	 * Imposta il valore della proprietà about.
	 * 
	 */
	public void setAbout(int value) {
		this.about = value;
	}

	/**
	 * Recupera il valore della proprietà description.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Imposta il valore della proprietà description.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Recupera il valore della proprietà policy.
	 * 
	 */
	public int getPolicy() {
		return policy;
	}

	/**
	 * Imposta il valore della proprietà policy.
	 * 
	 */
	public void setPolicy(int value) {
		this.policy = value;
	}

	/**
	 * Recupera il valore della proprietà synopsis.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Imposta il valore della proprietà synopsis.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSynopsis(String value) {
		this.synopsis = value;
	}

	/**
	 * Recupera il valore della proprietà type.
	 * 
	 */
	public int getType() {
		return type;
	}

	/**
	 * Imposta il valore della proprietà type.
	 * 
	 */
	public void setType(int value) {
		this.type = value;
	}

}
