package ua.training.persistance.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {


    public static PreparedStatement setValuesToPs(Object[] values, PreparedStatement ps) throws IllegalArgumentException {
        try {
            for (int i = 1; i < values.length+1; i++) {
                final Object value = values[i];

                if (value instanceof Long) {
                    ps.setLong(i, (long) value);
                } else if(value instanceof Double) {
                    ps.setDouble(i, (double) value);
                } else if(value instanceof String) {
                    ps.setString(i, (String) value);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }


}
