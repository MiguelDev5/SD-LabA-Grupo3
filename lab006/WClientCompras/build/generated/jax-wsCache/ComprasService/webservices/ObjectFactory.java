
package webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _APrueba_QNAME = new QName("http://webservices/", "a-prueba");
    private final static QName _APruebaResponse_QNAME = new QName("http://webservices/", "a-pruebaResponse");
    private final static QName _Comprar_QNAME = new QName("http://webservices/", "comprar");
    private final static QName _ComprarResponse_QNAME = new QName("http://webservices/", "comprarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link APrueba }
     * 
     */
    public APrueba createAPrueba() {
        return new APrueba();
    }

    /**
     * Create an instance of {@link APruebaResponse }
     * 
     */
    public APruebaResponse createAPruebaResponse() {
        return new APruebaResponse();
    }

    /**
     * Create an instance of {@link Comprar }
     * 
     */
    public Comprar createComprar() {
        return new Comprar();
    }

    /**
     * Create an instance of {@link ComprarResponse }
     * 
     */
    public ComprarResponse createComprarResponse() {
        return new ComprarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APrueba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "a-prueba")
    public JAXBElement<APrueba> createAPrueba(APrueba value) {
        return new JAXBElement<APrueba>(_APrueba_QNAME, APrueba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APruebaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "a-pruebaResponse")
    public JAXBElement<APruebaResponse> createAPruebaResponse(APruebaResponse value) {
        return new JAXBElement<APruebaResponse>(_APruebaResponse_QNAME, APruebaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comprar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "comprar")
    public JAXBElement<Comprar> createComprar(Comprar value) {
        return new JAXBElement<Comprar>(_Comprar_QNAME, Comprar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "comprarResponse")
    public JAXBElement<ComprarResponse> createComprarResponse(ComprarResponse value) {
        return new JAXBElement<ComprarResponse>(_ComprarResponse_QNAME, ComprarResponse.class, null, value);
    }

}
