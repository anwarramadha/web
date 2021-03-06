
package marketplace;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "deleteproductWS", targetNamespace = "http://marketplace/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DeleteproductWS {


    /**
     * 
     * @param catalogid
     * @return
     *     returns java.lang.String
     * @throws ClassNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteproduct", targetNamespace = "http://marketplace/", className = "marketplace.Deleteproduct")
    @ResponseWrapper(localName = "deleteproductResponse", targetNamespace = "http://marketplace/", className = "marketplace.DeleteproductResponse")
    @Action(input = "http://marketplace/deleteproductWS/deleteproductRequest", output = "http://marketplace/deleteproductWS/deleteproductResponse", fault = {
        @FaultAction(className = ClassNotFoundException_Exception.class, value = "http://marketplace/deleteproductWS/deleteproduct/Fault/ClassNotFoundException")
    })
    public String deleteproduct(
        @WebParam(name = "catalogid", targetNamespace = "")
        int catalogid)
        throws ClassNotFoundException_Exception
    ;

}
