package com.kodcu.info.com.kodcu.info;
/*
 * Created by hakdogan on 07/12/2017
 */

import com.kodcu.db.ConnDB;
import com.kodcu.user.User;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import java.util.List;

public class InsertTest {

    @Test
    public void insert(){
        ConnDB.instance().insertWithStatement(new User("Huseyin", "Akdogan", "Expert Software Consultant", 41));
        List<String> result = ConnDB.instance().getUsers();
        assertFalse(result.isEmpty());
    }
}
