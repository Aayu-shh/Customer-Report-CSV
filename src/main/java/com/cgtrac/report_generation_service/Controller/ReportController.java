package com.cgtrac.report_generation_service.Controller;

import com.cgtrac.report_generation_service.Service.PlatformReportService;
import com.cgtrac.report_generation_service.Service.ReportService;
import com.cgtrac.report_generation_service.Service.VirtualReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    PlatformReportService platformReportService;

    @Autowired
    VirtualReportService virtualReportService;

    @PostMapping("{region}")
    public ResponseEntity<String> generateReport(@PathVariable String region){
        return reportService.generateReport(region);
    }

    @PostMapping("thread/{region}")
    public ResponseEntity<String> generateReportUsingPlatformThread(@PathVariable String region){
         platformReportService.generateReportPlatform(region);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("virtual/{region}")
    public ResponseEntity<String> generateReportVirtual(@PathVariable String region){
        virtualReportService.generateReportVirtual(region);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
