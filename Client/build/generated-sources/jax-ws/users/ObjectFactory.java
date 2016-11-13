
package users;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the users package. 
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

    private final static QName _ClassNotFoundException_QNAME = new QName("http://users/", "ClassNotFoundException");
    private final static QName _ParseException_QNAME = new QName("http://users/", "ParseException");
    private final static QName _AddLike_QNAME = new QName("http://users/", "addLike");
    private final static QName _AddLikeResponse_QNAME = new QName("http://users/", "addLikeResponse");
    private final static QName _GetUserData_QNAME = new QName("http://users/", "getUserData");
    private final static QName _GetUserDataResponse_QNAME = new QName("http://users/", "getUserDataResponse");
    private final static QName _IsTokenValid_QNAME = new QName("http://users/", "isTokenValid");
    private final static QName _IsTokenValidResponse_QNAME = new QName("http://users/", "isTokenValidResponse");
    private final static QName _Users_QNAME = new QName("http://users/", "users");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: users
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
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
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
     * Create an instance of {@link GetUserData }
     * 
     */
    public GetUserData createGetUserData() {
        return new GetUserData();
    }

    /**
     * Create an instance of {@link GetUserDataResponse }
     * 
     */
    public GetUserDataResponse createGetUserDataResponse() {
        return new GetUserDataResponse();
    }

    /**
     * Create an instance of {@link IsTokenValid }
     * 
     */
    public IsTokenValid createIsTokenValid() {
        return new IsTokenValid();
    }

    /**
     * Create an instance of {@link IsTokenValidResponse }
     * 
     */
    public IsTokenValidResponse createIsTokenValidResponse() {
        return new IsTokenValidResponse();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
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
    @XmlElementDecl(namespace = "http://users/", name = "ClassNotFoundException")
    public JAXBElement<ClassNotFoundException> createClassNotFoundException(ClassNotFoundException value) {
        return new JAXBElement<ClassNotFoundException>(_ClassNotFoundException_QNAME, ClassNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLike }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "addLike")
    public JAXBElement<AddLike> createAddLike(AddLike value) {
        return new JAXBElement<AddLike>(_AddLike_QNAME, AddLike.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLikeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "addLikeResponse")
    public JAXBElement<AddLikeResponse> createAddLikeResponse(AddLikeResponse value) {
        return new JAXBElement<AddLikeResponse>(_AddLikeResponse_QNAME, AddLikeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "getUserData")
    public JAXBElement<GetUserData> createGetUserData(GetUserData value) {
        return new JAXBElement<GetUserData>(_GetUserData_QNAME, GetUserData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "getUserDataResponse")
    public JAXBElement<GetUserDataResponse> createGetUserDataResponse(GetUserDataResponse value) {
        return new JAXBElement<GetUserDataResponse>(_GetUserDataResponse_QNAME, GetUserDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTokenValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "isTokenValid")
    public JAXBElement<IsTokenValid> createIsTokenValid(IsTokenValid value) {
        return new JAXBElement<IsTokenValid>(_IsTokenValid_QNAME, IsTokenValid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTokenValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "isTokenValidResponse")
    public JAXBElement<IsTokenValidResponse> createIsTokenValidResponse(IsTokenValidResponse value) {
        return new JAXBElement<IsTokenValidResponse>(_IsTokenValidResponse_QNAME, IsTokenValidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Users }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://users/", name = "users")
    public JAXBElement<Users> createUsers(Users value) {
        return new JAXBElement<Users>(_Users_QNAME, Users.class, null, value);
    }

}
