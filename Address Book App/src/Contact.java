
public class Contact {
	private String name;
	private String phoneNum;
	private String mailAddr;
	private String email;

	public Contact(String name, String phoneNum, String mailAddr, String email) {
		if (name.length() <= 0) {
			throw new RuntimeException("Name cannot be empty");
		}
		this.name = name.trim();
		this.phoneNum = phoneNum.trim();
		this.mailAddr = mailAddr.trim();
		this.email = email.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() <= 0) {
			throw new RuntimeException("Name cannot be empty");
		}
		this.name = name.trim();
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum.trim();
	}

	public String getMailAddr() {
		return mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNum=" + phoneNum + ", mailAddr=" + mailAddr + ", email=" + email + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != Contact.class) {
			return false;
		}
		Contact other = (Contact) obj;
		return name.equals(other.getName()) && phoneNum.equals(other.getPhoneNum()) && mailAddr.equals(other.getMailAddr()) && email.equals(other.getEmail());
	}

}
