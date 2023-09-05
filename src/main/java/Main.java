import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = UserDAO.getInstance();

        User u1 = new User();
        UserInfo ui1 = new UserInfo();
        Contact c1 = new Contact();
        Hobby h1 = new Hobby();
        Address a1 = new Address();
        Zipcode z1 = new Zipcode();


        /* userDAO.createUser(u1);
            u1.addUserInfo(ui1);
                ui1.addContact(c1);
            u1.addHobbies(h1);
            u1.addAddress(a1);
                a1.addZipcode(z1);*/


    }

}

