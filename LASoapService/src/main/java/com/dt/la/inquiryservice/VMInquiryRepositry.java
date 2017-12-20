package com.dt.la.inquiryservice;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import localhost.laservice.VinInquiryInfo;


@Component
public class VMInquiryRepositry {
	private static final Map<String, VinInquiryInfo> vinInquiry = new HashMap<>();

	@PostConstruct
	public void initData() {
		VinInquiryInfo vin1 = new VinInquiryInfo();
		vin1.setInquiryType("VM");
		vin1.setVin("1C4SDJET2CC152905");
		vin1.setFlag1("CL");
		vin1.setFlag2("AL");
		vin1.setFlag3("BL");
		
		
		vinInquiry.put(vin1.getVin(), vin1);
		
		VinInquiryInfo vin2 = new VinInquiryInfo();
		vin2.setInquiryType("VM");
		vin2.setVin("1A323JET2CC152905");
		vin2.setFlag1("AL");
		vin2.setFlag2("AL");
		
		
		vinInquiry.put(vin2.getVin(), vin2);


		
	}

	public VinInquiryInfo findVin(String vin) {
		Assert.notNull(vin, "VIN is not null");
		System.out.println("Testing the VIN "+ vin);
		return vinInquiry.get(vin);
	}
}
