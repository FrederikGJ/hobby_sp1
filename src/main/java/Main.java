import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO;
        User u1 = new User();
        UserInfo ui1 = new UserInfo("Signe");
        Contact c1 = new Contact(30294785);
        Hobby h1 = new Hobby("svømning", Category.INDOOR);
        Address a1 = new Address("mosevej", 5);
        Zipcode z1 = new Zipcode();

        userDAO.createUser(u1);
        u1.addUserInfo(ui1);


    }

}

