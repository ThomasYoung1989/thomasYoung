package com.test.pay;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class InvokeTest {

	public static void main(String[] args) {
		  //webService访问地址
        Service service = new Service();
        Call call=null;
        //创建调用句柄
        try {
        	call = (Call) service.createCall();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
        
        String _ServicesURL = "http://localhost:8080/TestWebservice/services/accountService";
        try {
			call.setTargetEndpointAddress(new URL(_ServicesURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        call.setOperationName(new QName("UpdateAppAcctSoap", "UpdateAppAcctSoap"));
        try {
			String result = (String) call.invoke(new Object[] { "ajlsdkfjasjdlf"});
			System.out.print(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
