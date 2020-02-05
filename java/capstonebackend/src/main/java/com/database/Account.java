package com.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * stores info about the user
 * @author jravi
 *
 */
@Entity
public class Account {
	@Id
    @Column(name="loginid")
	protected int LoginID;
    @Column(name="screenname")
	protected String ScreenName;
    @Column(name="password")
	protected String password;
    @Column(name="accountactive")
	protected String AccountActive;
	
	public int getLoginID() {
		return LoginID;
	}
	public void setLoginID(int loginID) {
		LoginID = loginID;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String isAccountActive() {
		return AccountActive;
	}
	public void setAccountActive(String accountActive) {
		AccountActive = accountActive;
	}
	
}
