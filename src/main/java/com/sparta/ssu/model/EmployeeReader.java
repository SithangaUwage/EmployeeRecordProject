package com.sparta.ssu.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;

public class EmployeeReader {

//    private List<Employee> employeeList = new ArrayList<>();

    public void filePath() {
        String csvFile = "C:\\Users\\TECH-W70\\Documents\\EmployeeRecordProject\\resources\\EmployeeRecords.csv";
        String line = "";
        String cvsSplitBy = ",";
        Map<String, Employee> employeeMap = new HashMap<String, Employee>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String[] header = br.readLine().split(cvsSplitBy);
            while ((line = br.readLine()) != null) {
                String[] employeeReaderArray = line.split(cvsSplitBy);
                Employee employeeArray = new Employee(employeeReaderArray);
                employeeMap.put(employeeArray.getId(), employeeArray);
            }
//            br.lines()
//                       .parallel
////                    .filter(line -> line.startsWith("id"))
//                    .map(lines -> lines.split(","))
//                    .forEach(lines -> (lines));
        } catch (IOException e) {
            e.printStackTrace();
        }


//    public Map<String,Employee> getEmployees(){
//        filePath();
//        return employeeMap;}

        DAO dateAO = new DAO();
        Set<Map.Entry<String, Employee>> records = employeeMap.entrySet();
        for (Map.Entry<String, Employee> record : records) {
            Employee value = record.getValue();
            dateAO.runSQLQUERY(value);
        }

    }




}


//private void createRecords(String[] fields) {
//    Employee employee = createEmployeeRecord(fields);
//    String key = employee.getId();
//    if (!employeeMap.containsKey(key)) {
//        employeeMap.put(employee.getId(), employee);
//    } else {
//        duplicates.put(employee.getId(), employee);
//        duplicates.put(employeeMap.get(key).getId() + "tmp", employeeMap.get(key));
//        employeeMap.remove(key);
//    }
//}
//
//private Employee createEmployeeRecord(String[] fields) {
//    return new Employee( fields[0], fields[1], fields[2], fields[3], fields[4],fields[5], fields[6], formatDate(fields[7]), formatDate(fields[8]), fields[9]);
//}
//}



