package com.netapp.supportsite.url.builder;

import com.netapp.framework.url.builder.UrlBuilder;

public class SolrURLBuilder  implements UrlBuilder{
	/*private static final String BREAD_CRUB_URL ="http://durahc110d1-stg.corp.netapp.com:8983/solr/R2B3_SYSTEM.SYSTEM/select/?q=asup_id:";*/
	/*private static final String BREAD_CRUB_URL ="http://reststg.corp.netapp.com/asup-rest-interface/ASUP_DATA/client_id/smartsolve/asup_id/";*/
	private static final String BREAD_CRUB_URL ="http://restprd.corp.netapp.com/asup-rest-interface/ASUP_DATA/client_id/myasup/asup_id/";
	private static final String BIZ_KEY_ARG = "&fl=biz_key";
	private String asupId;
	
	public SolrURLBuilder(String asupId){
		this.asupId = asupId;
	}
	
	public String getHostname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServiceName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String buildUrl() {
		StringBuilder strBuilder = new StringBuilder(BREAD_CRUB_URL);
		strBuilder.append(asupId);
		/*strBuilder.append(BIZ_KEY_ARG);*/
		
		return strBuilder.toString();
	}

}
