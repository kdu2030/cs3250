
public class Contact {
	private String name;
	private String phoneNum;
	private String mailAddr;
	private String email;
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNum() {
		return phoneNum;
	}



	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}



	public String getMailAddr() {
		return mailAddr;
	}



	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Contact(String name, String phoneNum, String mailAddr, String email) {
		if(name.length() <= 0) {
			throw new RuntimeException("Name cannot be empty");
		}
		this.name = name.trim();
		this.phoneNum = phoneNum.trim();
		this.mailAddr = mailAddr.trim();
		this.email = email.trim();
	}
	
	

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNum=" + phoneNum + ", mailAddr=" + mailAddr + ", email=" + email + "]";
	}
	
	

}
