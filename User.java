public class User {

    private String name;
    private String host;
    private String password;

    public User(String n, String p, String h){
        name=n;
        host=h;
        password=p;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
