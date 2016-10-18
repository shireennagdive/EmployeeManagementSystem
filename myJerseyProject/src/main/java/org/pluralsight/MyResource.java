package org.pluralsight;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

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
/*    @GET
    @PathParam("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
*/    
    
    @GET
    @Path("test/{id}")
    @Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getSpecificPerson(@PathParam("id") String id){
    	System.out.println(id + " from REST API");
    	
    	return Response.status(200).build();
    	
    }
    
    
    
    
    @Path("person")
    @GET
    
    @Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Person getPersonDetails(){
    	
    	Person p = new Person();
    	
    	p.setAge(23);
    	p.setName("Ajay");
    	
    	return p;
    }
    
    
    
    
    
    
    @Path("person2")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response setPersonDetails(Person p){
    	System.out.println(p.getAge());
    	System.out.println(p.getName());
    	return Response.status(200).build();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}





