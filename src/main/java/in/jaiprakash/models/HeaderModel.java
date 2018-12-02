package in.jaiprakash.models;

public class HeaderModel {

	private String appName;
	private String userId;
	private String responsedateTime;
	private String language;
	private String sessionToken;
	private String country;
	private String servicename;
	
	public HeaderModel() {
		// TODO Auto-generated constructor stub
	}

	public HeaderModel(String appName, String userId, String responsedateTime, String language, String sessionToken,
			String country, String servicename) {
		super();
		this.appName = appName;
		this.userId = userId;
		this.responsedateTime = responsedateTime;
		this.language = language;
		this.sessionToken = sessionToken;
		this.country = country;
		this.servicename = servicename;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResponsedateTime() {
		return responsedateTime;
	}

	public void setResponsedateTime(String responsedateTime) {
		this.responsedateTime = responsedateTime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	
	
}
