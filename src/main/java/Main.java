import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {


        User u1 = new User();
        UserInfo ui1 = new UserInfo("diller");
        Contact c1 = new Contact();
        Hobby h1 = new Hobby();
        Address a1 = new Address("dillervej", 69);
        Zipcode z1 = new Zipcode();

        u1.addUserInfo(ui1);
        u1.setAddress(a1);

        UserDAO userDAO = new UserDAO();
        userDAO.createUser(u1);


        System.out.println(userDAO.readUser(u1.getUserId()));


    }

}

