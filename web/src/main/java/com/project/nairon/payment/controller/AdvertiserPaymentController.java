/**
 * 
 */
package com.project.nairon.payment.controller;

import
		org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flutterwave.rave.java.payload.transferPayload;
import com.project.nairon.flutter.payment.service.TransferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author gbemisola
 *
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Payment", description = "the PAYMENT API")
public class AdvertiserPaymentController {
	
	@Autowired
	TransferService transferService;
	
	@GetMapping("/")
	public String test() {
		return "Hello FlutterWave";
	}
	
	@PostMapping("/transfer")
	public void doTransfer(transferPayload transferPayload) {
		transferService.dotransfer(transferPayload);
	}

}
