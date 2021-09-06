public class Profile{
    String user;
    String pass;
    String place;
    public Profile(String user, String pass, String place) {
        this.user = user;
        this.pass = pass;
        this.place = place;
    }
    public String getPass() {
        return pass;
    }
    public boolean isPassEmpty() {
        if(this.pass == "") {
            return true;
        }else {
            return false;
        }
    }
}
