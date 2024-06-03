
package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para comprar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="comprar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidadPan" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantidadQueso" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantidadPlatanos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cantidadNaranjas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comprar", propOrder = {
    "cantidadPan",
    "cantidadQueso",
    "cantidadPlatanos",
    "cantidadNaranjas"
})
public class Comprar {

    protected int cantidadPan;
    protected int cantidadQueso;
    protected int cantidadPlatanos;
    protected int cantidadNaranjas;

    /**
     * Obtiene el valor de la propiedad cantidadPan.
     * 
     */
    public int getCantidadPan() {
        return cantidadPan;
    }

    /**
     * Define el valor de la propiedad cantidadPan.
     * 
     */
    public void setCantidadPan(int value) {
        this.cantidadPan = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadQueso.
     * 
     */
    public int getCantidadQueso() {
        return cantidadQueso;
    }

    /**
     * Define el valor de la propiedad cantidadQueso.
     * 
     */
    public void setCantidadQueso(int value) {
        this.cantidadQueso = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadPlatanos.
     * 
     */
    public int getCantidadPlatanos() {
        return cantidadPlatanos;
    }

    /**
     * Define el valor de la propiedad cantidadPlatanos.
     * 
     */
    public void setCantidadPlatanos(int value) {
        this.cantidadPlatanos = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadNaranjas.
     * 
     */
    public int getCantidadNaranjas() {
        return cantidadNaranjas;
    }

    /**
     * Define el valor de la propiedad cantidadNaranjas.
     * 
     */
    public void setCantidadNaranjas(int value) {
        this.cantidadNaranjas = value;
    }

}
