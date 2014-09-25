package com.test;

@javax.jws.WebService(targetNamespace = "http://test.com/", serviceName = "ThomasWebTestService", portName = "ThomasWebTestPort")
public class ThomasWebTestDelegate {

	com.test.ThomasWebTest thomasWebTest = new com.test.ThomasWebTest();

	public int returnInt() {
		return thomasWebTest.returnInt();
	}

}