
package it.vige.nam.stub;

import jakarta.activation.DataHandler;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlMimeType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java per signCAdESByAttachment complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="signCAdESByAttachment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credentials" type="{http://service.ws.nam/}credentials" minOccurs="0"/&gt;
 *         &lt;element name="inputDataHandler" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="CAdESPreferences" type="{http://service.ws.nam/}cAdESPreferences" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signCAdESByAttachment", propOrder = { "credentials", "inputDataHandler", "cAdESPreferences" })
public class SignCAdESByAttachment {

	protected Credentials credentials;
	@XmlMimeType("application/octet-stream")
	protected DataHandler inputDataHandler;
	@XmlElement(name = "CAdESPreferences")
	protected CAdESPreferences cAdESPreferences;

	/**
	 * Recupera il valore della proprietà credentials.
	 * 
	 * @return possible object is {@link Credentials }
	 * 
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * Imposta il valore della proprietà credentials.
	 * 
	 * @param value allowed object is {@link Credentials }
	 * 
	 */
	public void setCredentials(Credentials value) {
		this.credentials = value;
	}

	/**
	 * Recupera il valore della proprietà inputDataHandler.
	 * 
	 * @return possible object is {@link DataHandler }
	 * 
	 */
	public DataHandler getInputDataHandler() {
		return inputDataHandler;
	}

	/**
	 * Imposta il valore della proprietà inputDataHandler.
	 * 
	 * @param value allowed object is {@link DataHandler }
	 * 
	 */
	public void setInputDataHandler(DataHandler value) {
		this.inputDataHandler = value;
	}

	/**
	 * Recupera il valore della proprietà cAdESPreferences.
	 * 
	 * @return possible object is {@link CAdESPreferences }
	 * 
	 */
	public CAdESPreferences getCAdESPreferences() {
		return cAdESPreferences;
	}

	/**
	 * Imposta il valore della proprietà cAdESPreferences.
	 * 
	 * @param value allowed object is {@link CAdESPreferences }
	 * 
	 */
	public void setCAdESPreferences(CAdESPreferences value) {
		this.cAdESPreferences = value;
	}

}
