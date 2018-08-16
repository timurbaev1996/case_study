/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deutsche.dba.web;


import com.db.demomidtier.SQLManager;
import com.deutsche.dba.utils.SimpleJsonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   
    public SQLManager sqlManager = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp");

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
    @Path("/testConnection")
    //@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response testConnection()      
    {
        if (sqlManager == null) {
            try {
                //sqlManager = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp");
            } catch (Exception e) {
                System.err.println (e.getMessage());
                return Response.status(200).entity(e.getMessage()).build();
            }
        }

        String output = sqlManager.testConnection();
        boolean out;
        if (output == "Successful"){
            out = true;     
        }
        else{
            out = false;
        }
        return Response.status(200).entity(out).build();
        
    }
    
    @GET
    @Path("/validate/{name}/{pwd}")
    public Response validate(@PathParam("name")String name,
                                        @PathParam("pwd")String pwd)
    {
        try {
            //boolean output = true;
            //sqlManager = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp");
            boolean output = sqlManager.AuthorizeUser(name,pwd);
            
        return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(200).entity(false).build();
        }
        
    }
    
    @POST
    @Path("/validate1")
    public Response validateFromForm(@FormParam("lg_username")String name,
                                        @FormParam("lg_password")String pwd)
    {
        try {
            //boolean output = true;
            //sqlManager = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp");
            boolean output = sqlManager.AuthorizeUser(name,pwd);
            
        return Response.status(200).entity(output).build();
        } catch (Exception e) {
            return Response.status(200).entity(false).build();
        }
        
    }

    @GET
    @Path("/displayTable")
    public Response displayTable() throws JsonProcessingException{
        
        Map[] result;
        try {
            //sqlManager = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp");
            result = sqlManager.overview();
            
            ObjectMapper mapperObj = new ObjectMapper();
       
            String jsonResp = mapperObj.writeValueAsString(result);
            System.out.println(jsonResp);

            return Response.ok(jsonResp, MediaType.APPLICATION_JSON_TYPE).build(); 

            
        } catch (SQLException ex) {
            Logger.getLogger(DBDAServicePort.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(ex.getMessage(), MediaType.APPLICATION_JSON_TYPE).build(); 
        }
        
        
    }
    
    
}
