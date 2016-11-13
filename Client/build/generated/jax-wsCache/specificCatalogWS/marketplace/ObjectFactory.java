
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
    private final static QName _AddLike_QNAME = new QName("http://marketplace/", "addLike");
    private final static QName _AddLikeResponse_QNAME = new QName("http://marketplace/", "addLikeResponse");
    private final static QName _GetSpecificCatalog_QNAME = new QName("http://marketplace/", "getSpecificCatalog");
    private final static QName _GetSpecificCatalogResponse_QNAME = new QName("http://marketplace/", "getSpecificCatalogResponse");
    private final static QName _Marketplace_QNAME = new QName("http://marketplace/", "marketplace");

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
     * Create an instance of {@link AddLike }
     * 
     */
    public AddLike createAddLike() {
        return new AddLike();
    }

    /**
     * Create an instance of {@link AddLikeResponse }
     * 
     */
    public AddLikeResponse createAddLikeResponse() {
        return new AddLikeResponse();
    }

    /**
     * Create an instance of {@link GetSpecificCatalog }
     * 
     */
    public GetSpecificCatalog createGetSpecificCatalog() {
        return new GetSpecificCatalog();
    }

    /**
     * Create an instance of {@link GetSpecificCatalogResponse }
     * 
     */
    public GetSpecificCatalogResponse createGetSpecificCatalogResponse() {
        return new GetSpecificCatalogResponse();
    }

    /**
     * Create an instance of {@link Marketplace }
     * 
     */
    public Marketplace createMarketplace() {
        return new Marketplace();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "addLike")
    public JAXBElement<AddLike> createAddLike(AddLike value) {
        return new JAXBElement<AddLike>(_AddLike_QNAME, AddLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "addLikeResponse")
    public JAXBElement<AddLikeResponse> createAddLikeResponse(AddLikeResponse value) {
        return new JAXBElement<AddLikeResponse>(_AddLikeResponse_QNAME, AddLikeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpecificCatalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getSpecificCatalog")
    public JAXBElement<GetSpecificCatalog> createGetSpecificCatalog(GetSpecificCatalog value) {
        return new JAXBElement<GetSpecificCatalog>(_GetSpecificCatalog_QNAME, GetSpecificCatalog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSpecificCatalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getSpecificCatalogResponse")
    public JAXBElement<GetSpecificCatalogResponse> createGetSpecificCatalogResponse(GetSpecificCatalogResponse value) {
        return new JAXBElement<GetSpecificCatalogResponse>(_GetSpecificCatalogResponse_QNAME, GetSpecificCatalogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Marketplace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "marketplace")
    public JAXBElement<Marketplace> createMarketplace(Marketplace value) {
        return new JAXBElement<Marketplace>(_Marketplace_QNAME, Marketplace.class, null, value);
    }

}
