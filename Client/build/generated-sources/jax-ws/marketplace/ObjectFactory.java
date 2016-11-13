
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
    private final static QName _Purchases_QNAME = new QName("http://marketplace/", "Purchases");
    private final static QName _GetPurchases_QNAME = new QName("http://marketplace/", "getPurchases");
    private final static QName _GetPurchasesResponse_QNAME = new QName("http://marketplace/", "getPurchasesResponse");
    private final static QName _GetSales_QNAME = new QName("http://marketplace/", "getSales");
    private final static QName _GetSalesResponse_QNAME = new QName("http://marketplace/", "getSalesResponse");

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
     * Create an instance of {@link Purchases }
     * 
     */
    public Purchases createPurchases() {
        return new Purchases();
    }

    /**
     * Create an instance of {@link GetPurchases }
     * 
     */
    public GetPurchases createGetPurchases() {
        return new GetPurchases();
    }

    /**
     * Create an instance of {@link GetPurchasesResponse }
     * 
     */
    public GetPurchasesResponse createGetPurchasesResponse() {
        return new GetPurchasesResponse();
    }

    /**
     * Create an instance of {@link GetSales }
     * 
     */
    public GetSales createGetSales() {
        return new GetSales();
    }

    /**
     * Create an instance of {@link GetSalesResponse }
     * 
     */
    public GetSalesResponse createGetSalesResponse() {
        return new GetSalesResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Purchases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "Purchases")
    public JAXBElement<Purchases> createPurchases(Purchases value) {
        return new JAXBElement<Purchases>(_Purchases_QNAME, Purchases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchases }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getPurchases")
    public JAXBElement<GetPurchases> createGetPurchases(GetPurchases value) {
        return new JAXBElement<GetPurchases>(_GetPurchases_QNAME, GetPurchases.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPurchasesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getPurchasesResponse")
    public JAXBElement<GetPurchasesResponse> createGetPurchasesResponse(GetPurchasesResponse value) {
        return new JAXBElement<GetPurchasesResponse>(_GetPurchasesResponse_QNAME, GetPurchasesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getSales")
    public JAXBElement<GetSales> createGetSales(GetSales value) {
        return new JAXBElement<GetSales>(_GetSales_QNAME, GetSales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://marketplace/", name = "getSalesResponse")
    public JAXBElement<GetSalesResponse> createGetSalesResponse(GetSalesResponse value) {
        return new JAXBElement<GetSalesResponse>(_GetSalesResponse_QNAME, GetSalesResponse.class, null, value);
    }

}
