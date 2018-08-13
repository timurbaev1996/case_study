/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deutsche.dba.web;


import com.db.demomidtier.SQLManager;
import com.deutsche.dba.utils.SimpleJsonMessage;
import java.util.Map;
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
 * @author Selvyn
 */
@Path("/services")
public class DBDAServicePort implements IDBDAServicePort {
   
    public SQLManager sqlManager = null;//new SQLManager("jdbc:mysql://localhost:3307/db_grad","root","ppp");

    @Override
    @GET
    @Path("/sayhello")
    public Response sayHtmlHelloTest()
    {  
        String result = "<html> " + "<title>" + "DBDA" + "</title>"
                + "<body><h1>" + "the dbda is running..." + "</h1></body>" + "</html> ";

        return Response.status(200).entity(result).build();
    }
    
    @Override
    @GET
    @Path("/getAllTags")
    //@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response testConnection()      
    {
        String result = "";
        if (sqlManager == null) {
            try {
                sqlManager = new SQLManager("jdbc:mysql://ocalhost:3307/db_grad","root","ppp");
            } catch (Exception e) {
                System.err.println (e.getMessage());
                return Response.status(200).entity(e.getMessage()).build();
            }
        }

        String output = sqlManager.testConnection();
        result = "<html> " + "<title>" + "DBDA" + "</title>" 
        + "<body><h1>" + output + "</h1></body>" + "</html> ";
        return Response.status(200).entity(result).build();

               
    }
    
    @Override
    @GET
    @Path("/getAllURL")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getAllURL()
    {
        String result = "getAllURL() need to be built";
    	return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @Override
    @GET
    @Path("/get/{tags}")
    public Response getSavedURLWithInfo(@PathParam("tags")String tags)
    {
        String result = "getSavedURLWithInfo() need to be built";
    	return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @Override
    @GET
    @Path("/login/{usr}/{pwd}")
    public Response loginWithInfo( @PathParam("url")String usr,
                                        @PathParam("description")String description,
                                        @PathParam("tags")String tags )
    {
        String result = "loginWithInfo() need to be built";
    	return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    
    }
}
