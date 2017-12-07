package com.kodcu.info;

import com.kodcu.db.ConnDB;
import com.kodcu.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Created by hakdogan on 24/08/2017
 */
public class InfoUser {

    private static Logger logger = LogManager.getLogger(InfoUser.class);
    public static void main(String[] args){

        User user = new User("Huseyin", "Akdogan", "Expert Software Consultant", 41);
        logger.info(user.toString());
        try {
            ConnDB.instance().insertWithStatement(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}