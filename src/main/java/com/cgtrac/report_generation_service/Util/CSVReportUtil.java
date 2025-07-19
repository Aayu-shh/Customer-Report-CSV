package com.cgtrac.report_generation_service.Util;

import com.cgtrac.report_generation_service.Model.Customer;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class CSVReportUtil {

    public static void writeCustomersToCsv(String region, List<Customer> customers) throws IOException {
        Path path = Paths.get("reports", region + "_report.csv");
        Files.createDirectories(path.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(path);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "Name", "Email","Gender", "Region"))) {

            for (Customer customer : customers) {
                csvPrinter.printRecord(customer.getId(), customer.getName(), customer.getEmail(),customer.getGender(), customer.getRegion());
            }
        }
    }
}