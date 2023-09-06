package model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @Test
    void addUserInfo() {
        Users user = new Users();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("TestPerson");
        user.addUserInfo(userInfo);
        assertNotNull(user.getUserInfo());
        assertEquals(userInfo, user.getUserInfo());

    }

    @Test
    void addHobbies() {
        Users user = new Users();
        Hobby hobby1 = new Hobby("Hobby1", Category.INDOOR);
        Hobby hobby2 = new Hobby("Hobby2", Category.OUTDOOR);
        user.addHobbies(hobby1);
        user.addHobbies(hobby2);
        assertEquals(2, user.getHobbies().size());
    }

    @Test
    void addAddress() {
        Users user = new Users();
        Address address = new Address();
        address.setAddressName("TestGade");
        address.setAddressNumber(3);
        user.addAddress(address);
        assertNotNull(user.getAddress());
        assertEquals(address, user.getAddress());
    }
}