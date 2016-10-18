package com.shireen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("person")
    @GET
    @Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Person getPersonDetails(){
    	Person p = new Person();
    	p.setAge(22);
    	p.setName("Shireen");
    	return p;
    }
}
