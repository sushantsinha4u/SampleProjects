package com.example.demo;

import org.hibernate.envers.Audited;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reports")
@Audited
public class Report {

  private String id;

  private String reportName;
  
  private String reportDesciption;


  public String getReportDesciption() {
	return reportDesciption;
}

public void setReportDesciption(String reportDesciption) {
	this.reportDesciption = reportDesciption;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getReportName() {
	return reportName;
}

public void setReportName(String reportName) {
	this.reportName = reportName;
}

public String getReportDomain() {
	return reportDomain;
}

public void setReportDomain(String reportDomain) {
	this.reportDomain = reportDomain;
}

public String getReportGenerationYear() {
	return reportGenerationYear;
}

public void setReportGenerationYear(String reportGenerationYear) {
	this.reportGenerationYear = reportGenerationYear;
}

private String reportDomain;
  
  private String reportGenerationYear;

}