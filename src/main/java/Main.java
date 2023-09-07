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


        Users u4 = new Users();
        UserInfo ui4 = new UserInfo("Hans");
        Contact c4 = new Contact(21212121);
        Hobby h4 = new Hobby("Sove", Category.INDOOR);
        Address a4 = new Address("Polensgade", 30);
        Zipcode z4 = new Zipcode(2300, "København", "Hovedstaden", "Københavns kommune");

        userDAO.createUser(u4);
        u4.addUserInfo(ui4);
        ui4.addContact(c4);
        u4.addHobbies(h4);
        a4.addZipcode(z4);
        userDAO.updateUser(u4);
*/


    }
}

