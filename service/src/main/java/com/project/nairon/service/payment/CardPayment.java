/**
 * 
 */
package com.project.nairon.service.payment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.flutterwave.rave.java.payload.FLWmetaModel;
import com.flutterwave.rave.java.payload.cardLoad;
import com.flutterwave.rave.java.payload.cardPayload;
import com.flutterwave.rave.java.payload.splitaddPayload;
import com.flutterwave.rave.java.payload.suggestedload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import org.springframework.stereotype.Component;

/**
 * @author gbemisola
 *
 */

@Component
public class CardPayment {
	
	public String doflwcardpayment(cardLoad cardload) throws UnknownHostException {
		PaymentServices paymentServices = new PaymentServices();
		InetAddress localhost = InetAddress.getLocalHost();
		cardload.setIP((localhost).toString());
		
		
		if(cardload.getTxRef()== null) {
			Date date = new Date();
			cardload.setTxRef("MC" + date);
			
		}
		
		FLWmetaModel flwmetamodel = new FLWmetaModel();
		
		flwmetamodel.setMetaname(cardload.getMetaname());;
		flwmetamodel.setMetavalue(cardload.getMetavalue());
		
		cardPayload cardpayload = new cardPayload();
		cardpayload.setAmount(cardload.getAmount());
        cardpayload.setCardno(cardload.getCardno());
        cardpayload.setCountry(cardload.getCountry());
        cardpayload.setCurrency(cardload.getCurrency());
        cardpayload.setCvv(cardload.getCvv());
        cardpayload.setDevice_fingerprint(cardload.getDevice_fingerprint());
        cardpayload.setEmail(cardload.getEmail());
        cardpayload.setExpirymonth(cardload.getExpirymonth());
        cardpayload.setExpiryyear(cardload.getExpiryyear());
        cardpayload.setFirstname(cardload.getFirstname());
        cardpayload.setIP(cardload.getIP());
        cardpayload.setLastname(cardload.getLastname());
        cardpayload.setPBFPubKey(cardload.getPublic_key());
        cardpayload.setPhonenumber(cardload.getPhonenumber());
        cardpayload.setRedirect_url(cardload.getRedirect_url());
        cardpayload.setTxRef(cardload.getTxRef());
        cardpayload.setMeta(flwmetamodel);
        cardpayload.setPin(cardload.getPin());
        cardpayload.setSuggested_auth(cardload.getSuggested_auth());
        cardpayload.setBillingaddress(cardload.getBillingaddress());
        cardpayload.setBillingcity(cardload.getBillingcity());
        cardpayload.setBillingcountry(cardload.getBillingcountry());
        cardpayload.setBillingstate(cardload.getBillingstate());
        cardpayload.setBillingzip(cardload.getBillingzip());
        cardpayload.setEncryption_key(cardload.getEncryption_key());
        cardpayload.setTest(cardload.getTest());
        
        if (cardload.getSubaccounts() != null) {
        	
        	JSONArray array = new JSONArray(cardload.getSubaccounts());
        	
        	List<splitaddPayload> list = new ArrayList<>();
        	
        	if (array != null) {
        		
        		for (int i = 0; i < array.length(); i++) {
        			
                    JSONObject recordJSON = array.getJSONObject(i);
                    
                   splitaddPayload splitaddPayload = new splitaddPayload();
                   splitaddPayload.setId(recordJSON.optString("id"));
                   splitaddPayload.setTransaction_split_ratio(recordJSON.optString("transaction_split_ratio"));
                   
                   list.add(splitaddPayload);
               }
        		
        	}
        	cardpayload.setSubaccounts(list);
        }
        
        if ("preauth" .contentEquals(cardload.getCharge_type())) {
        	
        	cardpayload.setCharge_type("preauth");
        }
        
        TripleDES tripledes = new TripleDES();

        String payload = new JSONObject(cardpayload).toString();

        String Encryteddata = tripledes.encryptData(payload, cardpayload.getEncryption_key());

        String response = paymentServices.doflwcardpayment(Encryteddata, cardpayload);

        JSONObject myObject = new JSONObject(response);
        JSONObject Object = myObject.optJSONObject("data");
        
        if (!"V-COMP".equals(myObject.optString("message")) ) {
        	
        	
            if (myObject.optString("status").equals("success") && Object.optString("suggested_auth").equals("PIN")) {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth("PIN");
                suggestedload.setRequest("please enter pin");
                response = new JSONObject(suggestedload).toString();
                
            } else if (myObject.optString("status").equals("success") && Object.optString("suggested_auth").equals("NOAUTH_INTERNATIONAL")) {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth("NOAUTH_INTERNATIONAL");
                suggestedload.setRequest("please enter billingzip, billingcity, billingaddress ,billingstate ,billingcountry");
                response = new JSONObject(suggestedload).toString();
                
            } else if (myObject.optString("status").equals("success") && Object.optString("authurl") != "N/A") {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth(Object.optString("authurl"));
                response = new JSONObject(suggestedload).toString();
            }
        }
        
        return response;
		
	}

}
