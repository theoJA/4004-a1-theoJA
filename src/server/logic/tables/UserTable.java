package server.logic.tables;

import java.util.ArrayList;
import java.util.List;
import server.logic.model.User;

public class UserTable {
	List<User> userList=new ArrayList<User>();
	
	private static class UserListCollection {
        private static final UserTable INSTANCE = new UserTable();
    }
	
	private UserTable(){
    	// Initializing the user table
    	String[] passwordList=new String[]{"zhibo","yu","michelle","kevin","sun"};
    	String[] usernameList=new String[]{"zhibo@carleton.ca","yu@carleton.ca","michelle@carleton.ca","kevin@carleton.ca","sun@carleton.ca"};
    	for(int i = 0; i < usernameList.length; i++){
			User deuser = new User(i, usernameList[i], passwordList[i]);
			userList.add(deuser);
		}
    };
    
    public static final UserTable getInstance() {
        return UserListCollection.INSTANCE;
    }
    
    public List<User> getUserList() {
		return userList;
	}
    
    public String checkUserExists(String username, String password) {
		String result="";
		int flag=0;
		int index=0;
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getUsername().equalsIgnoreCase(username)){
				flag=flag+1;
				index=i;
			}else{
				flag=flag+0;
			}
		}
		boolean userPassword=userList.get(index).getPassword().equalsIgnoreCase(password);
		if(flag!=0 && userPassword){
			result="User exists.";
		}else if(flag==0){
			result="User does not exist.";
		}else if(userPassword==false){
			result="Password does not match.";
		}
		return result;
	}
    
    public int lookup(String string) {
		int userid=-1;
		for(int i=0;i<userList.size();i++){
			if(userList.get(i).getUsername().equalsIgnoreCase(string)){
				userid=i;
			}
		}
		return userid;
	}
    
    public boolean lookup(int j) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<userList.size();i++){
			int userid=(userList.get(i)).getUserId();
			if(userid==j){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			result=false;
		}
		return result;
	}

}
