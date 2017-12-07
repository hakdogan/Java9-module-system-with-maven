package com.kodcu.db.com.kodcu.db;
/*
 * Created by hakdogan on 07/12/2017
 */
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.kodcu.db.ConnDB;

import java.sql.SQLException;

public class ConnectionTest {

    @Test
    public void connection() throws SQLException {
        assertFalse(ConnDB.instance().getDBConnection().isClosed());
    }
}