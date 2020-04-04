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

import com.flutterwave.rave.java.payload.bankPayload;
import com.flutterwave.rave.java.payload.splitaddPayload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import org.springframework.stereotype.Component;

/**
 * @author gbemisola
 *
 */

@Component
public class BankPayment {
	
	public String doflwbankpayment(bankPayload bankpayload) throws UnknownHostException {
		
        PaymentServices paymentservices = new PaymentServices();
        InetAddress localhost = InetAddress.getLocalHost();
        bankpayload.setIP((localhost).toString());

        Date date = new Date();

        if (bankpayload.getTxRef() == null) {
            bankpayload.setTxRef("MC" + date);
        }
        
        if (bankpayload.getSubaccounts() != null) {

            JSONArray array = new JSONArray(bankpayload.getSubaccounts());

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
            bankpayload.setSubaccounts(list);
            }

        TripleDES tripledes = new TripleDES();
        String encrytedsecretkey = tripledes.getKey(bankpayload.getSECKEY());

        String payload = new JSONObject(bankpayload).toString();
        String Encryteddata = tripledes.encryptData(payload, encrytedsecretkey);

        String response = paymentservices.doflwbankpayment(Encryteddata, bankpayload);
        return response;

    }

}
