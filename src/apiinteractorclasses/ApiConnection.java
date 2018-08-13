/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apiinteractorclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GeorgeK
 */
public class ApiConnection {
    private String domain ;
    private String request;
    private List<String> response;
    public static final String AUTHORAIZATION_KEY="";
    public ApiConnection(String apiDomain,String requestToApi){
        domain=apiDomain;
        request=requestToApi;
        response=new ArrayList<String>();
    }
    public ApiConnection(){
       domain="";
       request="";
       response=new ArrayList<String>();
    }
    public void setDomain(String apiDomain){domain=apiDomain;return;}
    public void setRequest(String apiRequest){request=apiRequest;return;}
    public String getDomain(){return domain;}
    public String getRequest(){return request;}
    public boolean getApi() throws MalformedURLException, IOException{
        URL url=new URL(domain);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setDoInput(true);
       // connection.set
        //connection.setRequestProperty("User-Agent", "Mozilla/5.0");
       connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
       connection.setRequestProperty("Accept", "application/json");
       BufferedReader in = new BufferedReader(new InputStreamReader(
                           connection.getInputStream()));
       String inputLine;
       String items="";
       while ((inputLine = in.readLine()) != null){
           String trimmed=inputLine.trim();
           if(trimmed.equals("[")||trimmed.equals("]")){
               //System.out.print(1);
           }
           else if(trimmed.equals("{")){
             //  System.out.println(2);
               items="";
           }
           else if(trimmed.equals("}")||trimmed.equals("},")){
              // System.out.println(3);
               response.add(items);
              // System.out.println();
           }
           else{
             //  System.out.println(4);
               items=items.concat(inputLine);
           }
       }
                  //System.out.println(inputLine);
       in.close();
        return false;
    }
    public boolean postApi(){
        return false;
    }
    
    
}
