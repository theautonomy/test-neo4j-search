package org.wei.spring.rest.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class PaymentInformation {
	
	private long id;
	private String paymentType;
	private BigDecimal paymentAmmount;
	
	@JsonSerialize(using=org.wei.spring.rest.utils.JsonStdDateSerializer.class)
	private Date transactionDate;

	private Date createDate; 
	private Date updateDate; 
	private String createUser;
	private String updateUser;
	private String stateCode;

	//@JsonIgnore
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public BigDecimal getPaymentAmmount() {
		return paymentAmmount;
	}
	
	public void setPaymentAmmount(BigDecimal paymentAmmount) {
		this.paymentAmmount = paymentAmmount;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	public String getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
}
