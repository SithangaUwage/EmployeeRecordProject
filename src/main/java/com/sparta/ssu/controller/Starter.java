package com.sparta.ssu.controller;

import com.sparta.ssu.model.DAO;
import com.sparta.ssu.model.EmployeeManager;

import java.text.DecimalFormat;

public class Starter {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.readEmployeeRecordsFromCSV();
//        long endTime = System.nanoTime();
//        long timeTaken = endTime - startTime;
//        DecimalFormat format = new DecimalFormat("###, ###.####");
//        System.out.println("Total time taken" + timeTaken);
//        DAO Query = new DAO();
//        Query.runSQLQuery();
    }


}


