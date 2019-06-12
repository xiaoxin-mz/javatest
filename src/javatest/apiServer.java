package javatest;

public class apiServer {
	public native void Init(String strAddress, String strDeviceUID, String strSoftId, String strSoftVer);
	public native String Register(String strUid, String strPwd, String strConfirmPwd, String strQQ, String strMail);
	public native String[] Login(String strUid, String strPwd);
	public native String[] Usage();
	public native String Contact();
	public native String Charge(String strCardId, String strCardPwd);
	public native String Modify(String strOldPwd, String strNewPwd, String strConfirmPwd);
	public native String Logout();
}
