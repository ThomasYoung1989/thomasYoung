package com.test.invoke;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.test.invoke package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _UpdateAppAcctSoap_QNAME = new QName(
			"UpdateAppAcctSoap", "UpdateAppAcctSoap");
	private final static QName _UpdateAppAcctSoapResponse_QNAME = new QName(
			"UpdateAppAcctSoap", "UpdateAppAcctSoapResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.test.invoke
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link UpdateAppAcctSoapResponse }
	 * 
	 */
	public UpdateAppAcctSoapResponse createUpdateAppAcctSoapResponse() {
		return new UpdateAppAcctSoapResponse();
	}

	/**
	 * Create an instance of {@link UpdateAppAcctSoap }
	 * 
	 */
	public UpdateAppAcctSoap createUpdateAppAcctSoap() {
		return new UpdateAppAcctSoap();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateAppAcctSoap }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "UpdateAppAcctSoap", name = "UpdateAppAcctSoap")
	public JAXBElement<UpdateAppAcctSoap> createUpdateAppAcctSoap(
			UpdateAppAcctSoap value) {
		return new JAXBElement<UpdateAppAcctSoap>(_UpdateAppAcctSoap_QNAME,
				UpdateAppAcctSoap.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link UpdateAppAcctSoapResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "UpdateAppAcctSoap", name = "UpdateAppAcctSoapResponse")
	public JAXBElement<UpdateAppAcctSoapResponse> createUpdateAppAcctSoapResponse(
			UpdateAppAcctSoapResponse value) {
		return new JAXBElement<UpdateAppAcctSoapResponse>(
				_UpdateAppAcctSoapResponse_QNAME,
				UpdateAppAcctSoapResponse.class, null, value);
	}

}
