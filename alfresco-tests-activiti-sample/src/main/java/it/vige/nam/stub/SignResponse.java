
package it.vige.nam.stub;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java per signResponse complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="signResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signResponse", propOrder = { "_return" })
public class SignResponse {

	@XmlElement(name = "return")
	protected byte[] _return;

	/**
	 * Recupera il valore della proprietà return.
	 * 
	 * @return possible object is byte[]
	 */
	public byte[] getReturn() {
		return _return;
	}

	/**
	 * Imposta il valore della proprietà return.
	 * 
	 * @param value allowed object is byte[]
	 */
	public void setReturn(byte[] value) {
		this._return = value;
	}

}
