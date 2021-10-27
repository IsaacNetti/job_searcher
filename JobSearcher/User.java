package JobSearcher;

public abstract class User {
    protected String username;
    protected String password;
    protected String typeOfUser;

    public User(){
    }
    public abstract void setUsername(String username);
    public abstract void setPassword(String password);
    public void setType(String type){
        this.typeOfUser = type;
    }
    public abstract String getUsername();
    public String getType(){
        return typeOfUser;
    }
}
