package user;
//Java Beams
public class User {

	private String userID;
	private String userPassword;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userAddr;
    private String ccName;
    private int	ccNum;
    private int ccExp;
    private int ccCvv;
	private int role;
	//2 = admin, 1= active user, 0= inactive user
    
    public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userName) {
		this.userFirstName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userName) {
		this.userLastName = userName;
	}
	
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public int getCcNum() {
		return ccNum;
	}
	public void setCcNum(int ccNum) {
		this.ccNum = ccNum;
	}
	public int getCcExp() {
		return ccExp;
	}
	public void setCcExp(int ccExp) {
		this.ccExp = ccExp;
	}
	public int getCcCvv() {
		return ccCvv;
	}
	public void setCcCvv(int ccCvv) {
		this.ccCvv = ccCvv;
	}
	public int getRole() {
		return role;
	}
    public void setRole(int role) {
		this.role = role;
	}
    
}
