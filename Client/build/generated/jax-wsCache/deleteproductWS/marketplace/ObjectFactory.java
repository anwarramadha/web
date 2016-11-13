
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
    private final static QName _Deleteproduct_QNAME = new QName("http://marketplace/", "deleteproduct");
    private final static QName _DeleteproductResponse_QNAME = new QName("http://marketplace/", "deleteproductResponse");

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
     * Create an instance of {@link Deleteproduct }
     * 
     */
    public Deleteproduct createDeleteproduct() {
        return new Deleteproduct();
    }

    /**
     * Create an instance of {@link DeleteproductResponse }
     * 
     */
    public DeleteproductResponse createDeleteproductResponse() {
        return new DeleteproductResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Deleteproduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "deleteproduct")
    public JAXBElement<Deleteproduct> createDeleteproduct(Deleteproduct value) {
        return new JAXBElement<Deleteproduct>(_Deleteproduct_QNAME, Deleteproduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteproductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "deleteproductResponse")
    public JAXBElement<DeleteproductResponse> createDeleteproductResponse(DeleteproductResponse value) {
        return new JAXBElement<DeleteproductResponse>(_DeleteproductResponse_QNAME, DeleteproductResponse.class, null, value);
    }

}
