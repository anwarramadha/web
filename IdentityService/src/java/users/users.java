/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mujahid Suriah
 */
@XmlRootElement(name = "users")
public class users {
    @XmlElement(name="userid", required=true)
    private final String userid;
    @XmlElement(name="username", required=true)
    private final String username;
    @XmlElement(name="fullname", required=true)
    private final String fullname;
    @XmlElement(name="email", required=true)
    private final String email;
    @XmlElement(name="address", required=true)
    private final String address;
    @XmlElement(name="postal", required=true)
    private final String postal;
    @XmlElement(name="phone", required=true)
    private final String phone;
    @XmlElement(name="likes", required=true)
    private final String like;
    
    public users() {
        userid="";
        username="";
        fullname="";
        email="";
        address="";
        postal="";
        phone="";
        like="";
    }
    public users(String uid, String uname,String name, String mail, 
        String addr, String post, String phne, String suka) {
        userid = uid;
        username = uname;
        fullname = name;
        email = mail;
        address = addr;
        postal = post;
        phone = phne;
        like = suka;
    }
    
    /**
     * This is a sample web service operation
     * @param txt
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
