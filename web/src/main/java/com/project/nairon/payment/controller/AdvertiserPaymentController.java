/**
 * 
 */
package com.project.nairon.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flutterwave.rave.java.payload.transferPayload;
import com.project.nairon.flutter.payment.service.TransferService;

/**
 * @author gbemisola
 *
 */
//@RestController
//public class AdvertiserPaymentController {
//
//	private TransferService transferService;
//
//	@Autowired
//	public AdvertiserPaymentController(TransferService transferService){
//		this.transferService = transferService;
//	}
//
//
//	@GetMapping("/")
//	public String test() {
//		return "Hello FlutterWave";
//	}
//
//	@PostMapping("/transfer")
//	public void doTransfer(transferPayload transferPayload) {
//		transferService.dotransfer(transferPayload);
//	}
//
//}
