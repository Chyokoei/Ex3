package danyizhize;

public class Ex1 {
	public static void main(String[] args) 
	{
		Ex1 loginform = new Ex1();
        LoginForm t = loginform.new LoginForm();
        t.init();
        t.display();
        t.validate();
	}


 class LoginForm{
	private UserDAO user = new UserDAO();
	public void init()
	{
		System.out.println("init successfully");
	}
	public void display() 
	{
		System.out.println("display successfully");
	}
	public void validate()
	{String username ="admin";
	String userpassword = "123456";
	    user.findUser(username,userpassword);
		System.out.println("validate successfully");
	}
}
public class UserDAO{
	private DBUtil Con= new DBUtil(); 
	public boolean findUser(String userName,String userPassword) 
	{
	userName = "admin";
	userPassword = "123456";
	System.out.println("userName="+userName);
	return true;
	}
}
public class DBUtil{
	public void getConnection() 
	{
		System.out.println("getConnection successfully");
	}
}
}
