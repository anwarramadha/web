
package marketplace;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the marketplace package. 
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

    private final static QName _ClassNotFoundException_QNAME = new QName("http://marketplace/", "ClassNotFoundException");
    private final static QName _Marketplace_QNAME = new QName("http://marketplace/", "marketplace");
    private final static QName _Myproduct_QNAME = new QName("http://marketplace/", "myproduct");
    private final static QName _MyproductResponse_QNAME = new QName("http://marketplace/", "myproductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: marketplace
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClassNotFoundException }
     * 
     */
    public ClassNotFoundException createClassNotFoundException() {
        return new ClassNotFoundException();
    }

    /**
     * Create an instance of {@link Marketplace }
     * 
     */
    public Marketplace createMarketplace() {
        return new Marketplace();
    }

    /**
     * Create an instance of {@link Myproduct }
     * 
     */
    public Myproduct createMyproduct() {
        return new Myproduct();
    }

    /**
     * Create an instance of {@link MyproductResponse }
     * 
     */
    public MyproductResponse createMyproductResponse() {
        return new MyproductResponse();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "ClassNotFoundException")
    public JAXBElement<ClassNotFoundException> createClassNotFoundException(ClassNotFoundException value) {
        return new JAXBElement<ClassNotFoundException>(_ClassNotFoundException_QNAME, ClassNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Marketplace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "marketplace")
    public JAXBElement<Marketplace> createMarketplace(Marketplace value) {
        return new JAXBElement<Marketplace>(_Marketplace_QNAME, Marketplace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Myproduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "myproduct")
    public JAXBElement<Myproduct> createMyproduct(Myproduct value) {
        return new JAXBElement<Myproduct>(_Myproduct_QNAME, Myproduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MyproductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "myproductResponse")
    public JAXBElement<MyproductResponse> createMyproductResponse(MyproductResponse value) {
        return new JAXBElement<MyproductResponse>(_MyproductResponse_QNAME, MyproductResponse.class, null, value);
    }

}
