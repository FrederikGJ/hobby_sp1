import dao.HobbyDAO;
import dao.UserDAO;
import model.*;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = UserDAO.getInstance();
        HobbyDAO hobbyDAO = HobbyDAO.getInstance();

        Users u1 = new Users();
        UserInfo ui1 = new UserInfo("Signe");
        Contact c1 = new Contact(30294785);
        Hobby h1 = new Hobby("Svømning", Category.INDOOR);
        Address a1 = new Address("Mosevej", 3);
        Zipcode z1 = new Zipcode(3400, "Hillerød", "Region Nordsjælland", "Hillerød Kommune");

        userDAO.createUser(u1); // User is created and persisted
        u1.addUserInfo(ui1); // add UserInfo to User
        ui1.addContact(c1); // add Contact to UserInfo
        u1.addHobbies(h1); // add Hobby to User
        u1.addAddress(a1); // add Address to User
        a1.addZipcode(z1); // add Zipcode to Address
        userDAO.updateUser(u1); // update the User so the changes are merges to the DB
        System.out.println(u1);
        userDAO.deleteUser(10); // User is deleted


        Hobby newHobby = new Hobby("Paintball", Category.OUTDOOR );
        hobbyDAO.createHobby(newHobby);





    }

}

