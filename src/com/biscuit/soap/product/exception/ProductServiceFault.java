package com.biscuit.soap.product.exception;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebFault;

/**
 * @author mlahariya
 * @version 1.0, Feb 2017
 */

@WebFault(name = "serviceFault", targetNamespace = "http://service.product.soap.biscuit.com/")
public class ProductServiceFault extends Exception {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private ServiceFault faultInfo;

	public ServiceFault getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(ServiceFault faultInfo) {
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public ProductServiceFault(String message, ServiceFault faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public ProductServiceFault(String message, ServiceFault faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * @param message
	 */
	public ProductServiceFault(String code, String message) {

		super(message);
		this.faultInfo = new ServiceFault();
		MessagesType messagesType = new MessagesType();

		List<MessageType> messageTypeList = new ArrayList<>();
		MessageType messageObj = new MessageType();
		messageObj.setCode(code);
		messageObj.setText(message);
		messageTypeList.add(messageObj);
		messagesType.setMessage(messageTypeList);

		this.faultInfo.setMessages(messagesType);
	}

}
