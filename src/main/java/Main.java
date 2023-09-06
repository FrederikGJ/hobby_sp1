import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = UserDAO.getInstance();

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
        userDAO.deleteUser(10);


    }

}

