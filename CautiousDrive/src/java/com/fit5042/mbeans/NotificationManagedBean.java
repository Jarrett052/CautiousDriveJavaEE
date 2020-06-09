/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fit5042.mbeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.hibernate.validator.internal.util.logging.Log;

/**
 *
 * @author csz
 */
@Named(value = "notificationManagedBean")
@ApplicationScoped
public class NotificationManagedBean implements Serializable{

    /**
     * Creates a new instance of NotificationManagedBean
     */

//        private static String reminders;
        private String reminders;
    
        public static String findNotification() {
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        //Making HTTP request
        try {
//            url = new URL("http://adcf7bea.ngrok.io");
              url = new URL("http://c8093bd2.ngrok.io/notification");  
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            // set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            // set the connection method to GET
            conn.setRequestMethod("POST");
            // add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());
            // read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
    
    
    public String notificationSend() throws ProtocolException, IOException{
    
        reminders = sendLocationGetNotification();
        return reminders;
    }
    
    
//    {"longitude":144.96203,"latitude":-37.81791}
    
//    public static void sendLocationGetNotification(){
//        //initialise
//        URL url = null;
//        HttpURLConnection conn = null;
////        final String methodPath1="calorietracker.food/";
//        try {
//            Gson gson =new GsonBuilder().create();
//            String stringFoodJson=gson.toJson(food);
//            //url = new URL(BASE_URL+ methodPath1);
//            url = new URL(BASE_URL+ methodPath1);
//            //open the connection
//            conn = (HttpURLConnection) url.openConnection();
//            //set the timeout
//            conn.setReadTimeout(10000);
//            conn.setConnectTimeout(15000);
//            //set the connection method to POST
//            conn.setRequestMethod("POST");
//            //set the output to true
//            conn.setDoOutput(true);
//            //set length of the data you want to send
//            conn.setFixedLengthStreamingMode(stringFoodJson.getBytes().length);
//            //add HTTP headers
//            conn.setRequestProperty("Content-Type", "application/json");
//            //Send the POST out
//            conn.getOutputStream();
//            PrintWriter out= new PrintWriter(conn.getOutputStream());
//            out.print(stringFoodJson);
//            System.out.print(stringFoodJson);
//            out.close();
//            Log.i("error",Integer.toString(conn.getResponseCode()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conn.disconnect();
//        }
//    }
//    
     public static String sendLocationGetNotification() throws MalformedURLException, ProtocolException, IOException{  
         
//       URL url = new URL("https://www.example.com/login");
//        URLConnection con = url.openConnection();
//        HttpURLConnection http = (HttpURLConnection)con;
//        http.setRequestMethod("POST"); // PUT is another valid option
//        http.setDoOutput(true);
//        
        
//        reminders = findNotification();

        URL url = new URL("http://c8093bd2.ngrok.io/notification/");
//        URLConnection con = url.openConnection();
//        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        
//        byte[] out = "{\"username\":\"root\",\"password\":\"password\"}" .getBytes(StandardCharsets.UTF_8);
        byte[] out = "{\"longitude\":144.946457,\"latitude\":-37.81791}" .getBytes(StandardCharsets.UTF_8);
                      
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
                
                int responseCode;
                responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);
                String sendBack = "";
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
//			System.out.println(response.toString());
                                
                        sendBack = response.toString();
                        
                        
		} else {
                    
//			System.out.println("POST request not worked");
                        sendBack = "POST request not worked" ;
		}
                
                return sendBack;
	}

        
        




}
    
    
    

