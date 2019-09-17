package ua.training.service;

import ua.training.persistance.beans.User;
import ua.training.persistance.dao.IUserDao;
import ua.training.persistance.dao.factory.MySQLDaoFactory;
import ua.training.util.exceptions.DaoException;

import java.util.Optional;

public class AuthorizationService {
    // userDao;
    private MySQLDaoFactory daoFactory;

    public AuthorizationService() {
        this.daoFactory = MySQLDaoFactory.getInstance();
    }


    // return authorized user if one exist in DB
    public Optional<User> authorizeUser(String login, String password) {
        final IUserDao userDao = daoFactory.getUserDao();
        return userDao.getUserByLoginAndPassword(login, password);
    }

//    // return authorized user if one exist in DB
////    public boolean isUserAuthorized(RequestContent requestContent) {
////        boolean isAuthorized = false;
////
////        final IUserDao userDao = daoFactory.getUserDao();
////        final Optional<User> optionalUser = userDao.getUserByLoginAndPassword(requestContent);
//////        HashMap<String, Object> requestAttributes = requestContent.getRequestAttributes();
////
////        if (optionalUser.isPresent()) {
////            isAuthorized = true;
////            final User user = optionalUser.get();
////            requestContent.setAttribute("id", user.getId());
////            requestContent.setAttribute("firstName", user.getFirstName());
////            requestContent.setAttribute("lastName", user.getLastName());
////        }
////
////        return isAuthorized;
////    }


//    // return authorized user if one exist in DB
//    public Optional<User> authorizeUser(RequestContent requestContent) {
//
//        final IUserDao userDao = daoFactory.getUserDao();
//        final Optional<User> optionalUser = userDao.getUserByLoginAndPassword(requestContent);
//
//        // TODO: return RequestContent with fetched user from DB
//
//
//        return optionalUser;
//    }
}
