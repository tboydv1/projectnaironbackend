/**
 * 
 */
package com.project.nairon.flutter.payment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bulkPayload;
import com.flutterwave.rave.java.payload.transferPayload;
import com.flutterwave.rave.java.service.transferServices;

/**
 * @author gbemisola
 *
 */
public class TransferService {
	
	private static final Logger LOG = Logger.getLogger(TransferService.class);
	
	
	 public String dotransfer(transferPayload transferPayload) {
	        transferServices transferServices = new transferServices();

	        if (transferPayload.getReference() == null) {
	            Date date = new Date();
	            transferPayload.setReference("MC" + date);
	        }

	        String payload = new JSONObject(transferPayload).toString();
	        String response = transferServices.dotransfer(payload);
	        return response;
	    }

	    public String dobulktransfer(bulkPayload bulkPayload) {
	        transferServices transferServices = new transferServices();

	        bulkPayload.setSeckey(raveConfig.SECRET_KEY);

	        String payload = new JSONObject(bulkPayload).toString();
	        String response = transferServices.dobulktransfer(payload);
	        return response;
	    }

	
}
