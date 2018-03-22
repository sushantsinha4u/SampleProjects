package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ReportSearchRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection<Report> searchReports(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                        .orOperator(Criteria.where("reportDesciption").regex(text, "i"),
                                    Criteria.where("reportName").regex(text, "i"),
                                    Criteria.where("reportDomain").regex(text, "i"),
                        Criteria.where("reportGenerationYear").regex(text, "i"))
                        ), Report.class);
    }

    
    public Collection<Report> searchReports(String text,int page,int pageSize) {
    	Query query = new Query();
    	query.query(new Criteria()
                .orOperator(Criteria.where("reportDesciption").regex(text, "i"),
                        Criteria.where("reportName").regex(text, "i"),
                        Criteria.where("reportDomain").regex(text, "i"),
            Criteria.where("reportGenerationYear").regex(text, "i")));
    	query.skip(page);
    	query.limit(pageSize);    	
        return mongoTemplate.find(query, Report.class);
    }
    
    public Report findOne(String id) {
    	System.out.println("id----"+id);
		return  mongoTemplate.findOne
				(Query.query(
						new Criteria().orOperator
						(Criteria.where("id").is(id))),Report.class);
         }
    
    
    public  void findAndModify(String id, Report report) {
    	mongoTemplate.findOne
		(Query.query(
				new Criteria().orOperator
				(Criteria.where("id").is(id))),Report.class);
    	mongoTemplate.save(report);
    }
    
}