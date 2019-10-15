package ua.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.training.persistence.dao.IUserDao;
import ua.training.persistence.dao.factory.DaoFactory;
import ua.training.persistence.entities.User;
import ua.training.persistence.entities.UserType;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SignInServiceTest {
    private final String validEmail = "genadii_o@gmail.com";
    private final String validPassword = "pass_1";

    @Mock
    IUserDao userDao;

    @Mock
    DaoFactory daoFactory;

    @InjectMocks
    private SignInService service;

    @Test
    public void getUserWhenValidCredentialsTest() {
        final User user = getUser();
        Optional<User> expected = Optional.of(user);
        when(daoFactory.getUserDao()).thenReturn(userDao);
        when(userDao.getUserByEmailAndPassword(validEmail, validPassword)).thenReturn(expected);
        assertEquals(expected, service.getAuthorizedUser(validEmail, validPassword));
    }

    @Test
    public void getUserWhenInvalidCredentialsTest() {
        final String invalidEmail = "genadii_o@gmail.coms";
        final String invalidPassword = "pass_1d";

        final User user = getUser();
        Optional<User> expected = Optional.of(user);
        when(daoFactory.getUserDao()).thenReturn(userDao);
        when(userDao.getUserByEmailAndPassword(validEmail, validPassword)).thenReturn(expected);
        assertFalse(service.getAuthorizedUser(invalidEmail, invalidPassword).isPresent());
    }

    private User getUser() {
        final User user = new User();
        user.setId(1L);
        user.setFirstName("Генадій");
        user.setLastName("Омелянко");
        user.setOrganization(null);
        user.setEmail("genadii_o@gmail.com");
        user.setPassword("pass_1");
        user.setAddress(null);
        user.setUserType(new UserType(3L, "inspector"));
        return user;
    }
}
