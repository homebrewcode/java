package com.netapp.supportsite.url.builder;

import java.util.ArrayList;
import java.util.List;

import com.netapp.framework.url.builder.PathConstants;
import com.netapp.framework.url.builder.UrlBuilder;



public class NGSSupportCase implements UrlBuilder{

	private static final String LOGIN_USR_ID="LoginUserID";
	private static final String LOGIN_USR_NAME="LoginUserName";
	private static final String CUST_ID_LIST="CustomerIDList";
	private static final String STATUS="Status";
	private static final String PRODUCT_ID="ProductID";

	private String serviceName;
	private String hostName;
	private String queryServiceName;
	private String loginUserId;
	private String loginUserName;
	private List<String> customerIdList;
	private String status;
	private String productId;


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getQueryServiceName() {
		return queryServiceName;
	}

	public void setQueryServiceName(String queryServiceName) {
		this.queryServiceName = queryServiceName;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public List<String> getCustomerIdList() {
		return customerIdList;
	}

	public void setCustomerIdList(List<String> customerIdList) {
		this.customerIdList = customerIdList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getHostname() {
		return hostName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String buildUrl() {

		//Sample URL
		/*http://vmwsoaapp13-dev.corp.netapp.com:9102/NGS_SupportCase/GetSerailizedProduct?
		 LoginUserID=1220783;LoginUserName=00BEA9EB4B1;CustomerIDList=1003013,1008857,1029200,1340278,1464067,2058636;
		 Status=E0001;ProductID=14228894
		 */
		//TODO: Alter this method based on mandatory and non-mandatory parameters
		try {
			validateMandatoryParameters();
		} catch (InsufficiantParametersException e) {
			e.printStackTrace();
			return null;
		}

		StringBuilder url = new StringBuilder();
		url.append(PathConstants.HTTP_PROTOCOL).append(hostName).append(PathConstants.URL_DELIM);
		url.append(serviceName).append(PathConstants.URL_DELIM).append(queryServiceName).append(PathConstants.QUESTION_MARK);

		//Logged In User ID
		url.append(LOGIN_USR_ID).append(PathConstants.EQUALS).append(loginUserId).append(PathConstants.SEMI_COLON);
		
		//Logged In User Name
		url.append(LOGIN_USR_NAME).append(PathConstants.EQUALS).append(loginUserName).append(PathConstants.SEMI_COLON);

		//Customer ID list
		url.append(CUST_ID_LIST).append(PathConstants.EQUALS).append(customerIdList.toString().replaceAll("[\\[\\]\\s]", "")).append(PathConstants.SEMI_COLON);

		//Status 
		url.append(STATUS).append(PathConstants.EQUALS).append(status).append(PathConstants.SEMI_COLON);
		
		//ProductId
		url.append(PRODUCT_ID).append(PathConstants.EQUALS).append(productId);


		return url.toString();

	}

	private void validateMandatoryParameters() throws InsufficiantParametersException {
		if(hostName==null || loginUserId==null || customerIdList==null || customerIdList.isEmpty() || status==null || productId==null || queryServiceName==null){
			throw new InsufficiantParametersException(this);
		}
	}	
	
	@Override
	public String toString() {
		return "NGSSupportCaseUrlBuilder [serviceName=" + serviceName
				+ ", hostName=" + hostName + ", queryServiceName="
				+ queryServiceName + ", loginUserId=" + loginUserId
				+ ", loginUserName=" + loginUserName + ", customerIdList="
				+ customerIdList + ", status=" + status + ", productId="
				+ productId + "]";
	}

	public static void main(String args[]){
		/*http://vmwsoaapp13-dev.corp.netapp.com:9102/NGS_SupportCase/GetSerailizedProduct?
		 LoginUserID=1220783;LoginUserName=00BEA9EB4B1;CustomerIDList=1003013,1008857,1029200,1340278,1464067,2058636;
		 Status=E0001;ProductID=14228894
		 */		
		NGSSupportCase nsgSupportCase = new NGSSupportCase();
		nsgSupportCase.setHostName("vmwsoaapp13-dev.corp.netapp.com:9102");
		nsgSupportCase.setServiceName("NGS_SupportCase");
		nsgSupportCase.setQueryServiceName("GetSerailizedProduct");
		nsgSupportCase.setLoginUserId("1220783");
		nsgSupportCase.setLoginUserName("00BEA9EB4B1");
		nsgSupportCase.setStatus("E0001");
		nsgSupportCase.setProductId("14228894");
		
		
		List<String> customerIdList = new ArrayList<String>();
		customerIdList.add("1003013");
		customerIdList.add("1008857");
		customerIdList.add("1029200");
		customerIdList.add("1340278");
		customerIdList.add("1464067");
		customerIdList.add("2058636");
		
		nsgSupportCase.setCustomerIdList(customerIdList);
		
		System.out.println(nsgSupportCase.buildUrl());
	}
	
}
