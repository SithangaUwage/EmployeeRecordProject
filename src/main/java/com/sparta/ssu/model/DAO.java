package com.sparta.ssu.model;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import  java.time.format.DateTimeFormatter;
import java.util.Date;

public class DAO {

    private final String QUERY = "SELECT first_name FROM emplyeestable where id=?";
    private final String INSERT_QUERY = "INSERT INTO emplyeestable (id, first_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) " + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String URL = "jdbc:postgresql://localhost/postgres?user=postgres&password=Acad3my1";

    private final int batchSize = 1000;
    private int count = 0;
    public void runSQLQUERY(Employee employee) {

            try (Connection connection = DriverManager.getConnection(URL)) {
                PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
                statement.setString(1, employee.getId());
                statement.setString(2, employee.getNamePrefix());
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getMiddleInitial());
                statement.setString(5, employee.getLastName());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, employee.getDateofBirth());
                statement.setDate(9, employee.getDateofJoining());
                statement.setInt(10, employee.getSalary());
                statement.addBatch();
//                if (++count % batchSize == 0 || ++count % employee.size() == 0) {
                    runQuery(statement);
//                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    private void runQuery(PreparedStatement statement) throws SQLException {
        int result = statement.executeUpdate();
    }

//    private void  displayTimeTaken(Employee employee, long timeTaken) {
//
//    }

}
