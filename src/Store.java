public class Store {
    String user;
    String password;
    String place;
    public Store(String user, String password, String place) {
        this.user = user;
        this.password = password;
        this.place = place;
    }
    public String retrieval() {
        return password;
    }
    public boolean hollow() {
        if(this.password == "") {
            return true;
        }else {
            return false;
        }
    }
}
