package com.dt.la.inquiryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost.laservice.VMInquiryResponse;
import localhost.laservice.VinInquiryRequest;



@Endpoint
public class VMInquiryEndpoint {
	private static final String NAMESPACE_URI = "http://localhost/laservice";

	private VMInquiryRepositry vmInquiryRepository;
	

	@Autowired
	public VMInquiryEndpoint(VMInquiryRepositry vmInquiryRepository) {
		this.vmInquiryRepository = vmInquiryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "vinInquiryRequest")
	@ResponsePayload
	public VMInquiryResponse getCountry(@RequestPayload VinInquiryRequest request) {
		VMInquiryResponse response = new VMInquiryResponse();
		response.setVinInquiry(vmInquiryRepository.findVin(request.getVin()));

		return response;
	}
}
