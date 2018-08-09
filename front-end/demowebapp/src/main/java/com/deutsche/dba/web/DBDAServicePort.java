/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deutsche.dba.web;



import com.db.demomidtier.SQLManager;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Mike
 */
@Path("/services")
public class DBDAServicePort implements IDBDAServicePort
{

    SQLManager sql = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp"); // Must be read from config
        
    String result = sql.testConnection();
        
    

    @Override
    @GET
    @Path("/sayhello")
    public Response sayHtmlHelloTest()
    {
        String result = "<html> " + "<title>" + "DBDA" + "</title>"
                + "<body><h1>" + "the dbda is running..." + "</h1></body>" + "</html> ";

        return Response.status(200).entity(result).build();
    }
    

}
