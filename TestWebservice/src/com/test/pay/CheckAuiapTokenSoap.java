package com.test.pay;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;

/**
 * 4A验证接口
 * @author Administrator
 *
 */
public class CheckAuiapTokenSoap {
	
	 private static final Logger LOG=Logger.getLogger(CheckAuiapTokenSoap.class);
	
	 private  Call call; 
	 
	 private static CheckAuiapTokenSoap checkAuiapTokenSoap;
	 
	 
	 public static CheckAuiapTokenSoap getInstance(){
		 if(checkAuiapTokenSoap==null){
			 checkAuiapTokenSoap=new CheckAuiapTokenSoap();
		 }
		 return checkAuiapTokenSoap;
	 }
	 
	 
	 private CheckAuiapTokenSoap(){
		    //webService访问地址
	        Service service = new Service();
	        //创建调用句柄
	        try {
				call = (Call) service.createCall();
			} catch (ServiceException e) {
				e.printStackTrace();
				LOG.error(e);
			}
	        
	        String _ServicesURL = "http://172.31.184.75:8080/all/services/UpdateAppAcctSoap";
	        try {
				call.setTargetEndpointAddress(new URL(_ServicesURL));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        call.setOperationName(new QName("UpdateAppAcctSoap", "UpdateAppAcctSoap"));
	        /*call.addParameter("RequestInfo", Constants.XSD_STRING, ParameterMode.IN);
	        call.setReturnType(Constants.XSD_STRING);
	        call.setEncodingStyle("UTF-8");*/
	 }
	 
	 /**
	  * 调用webservice获取接口数据
	  * @param requestInfo
	  * @return
	  */
	 public String getResultFromAuiap(String requestInfo){
		 String result="";
		 try {
			result = (String) call.invoke(new Object[] { "ajlsdkfjasjdlf"});
		} catch (RemoteException e) {
			e.printStackTrace();
			LOG.error("4A webservice调用失败",e);
		}
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 CheckAuiapTokenSoap checkAuiapTokenSoap=CheckAuiapTokenSoap.getInstance();
		 System.out.println(checkAuiapTokenSoap.getResultFromAuiap("alskjdfl"));
	}

}
