import dao.HobbyDAO;
import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = UserDAO.getInstance();
        HobbyDAO hobbyDAO = HobbyDAO.getInstance();

        /*

        Users u1 = new Users();
        UserInfo ui1 = new UserInfo("Signe");
        Contact c1 = new Contact(30294785);
        Hobby h1 = new Hobby("Svømning", Category.INDOOR);
        Address a1 = new Address("Mosevej", 3);
        Zipcode z1 = new Zipcode(3400, "Hillerød", "Region Nordsjælland", "Hillerød Kommune");

        userDAO.createUser(u1);
        u1.addUserInfo(ui1);
        ui1.addContact(c1);
        u1.addHobbies(h1);
        u1.addAddress(a1);
        a1.addZipcode(z1);
        userDAO.updateUser(u1);
        System.out.println(u1);



        Users u2 = new Users();
        UserInfo ui2 = new UserInfo("Natasja");
        Contact c2 = new Contact(20202020);
        Hobby h2 = new Hobby("Sove", Category.INDOOR);
        Address a2 = new Address("Polensgade", 30);
        Zipcode z2 = new Zipcode(2300, "København", "Hovedstaden", "Københavns kommune");

        userDAO.createUser(u2);
        u2.addUserInfo(ui2);
        ui2.addContact(c2);
        u2.addHobbies(h2);
        a2.addZipcode(z2);
        userDAO.updateUser(u2);

         */

        hobbyDAO.getNumberOfPeopleWithHobby("Sove");
    }
}

