package com.certification.springcoreformation;

public class SecondService {

	private static SecondService service = new SecondService();
	
	public static SecondService getInstance() {
		return service;
	}

}
