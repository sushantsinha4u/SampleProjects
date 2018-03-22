package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {

    @Autowired
    ReportMongoRepository reportRepository;

    @Autowired
    ReportSearchRepository reportSearchRepository;
    
    @Value("${page.size}")
    private Integer pageSize;

    @RequestMapping("/")
    public String home(Model model,@RequestParam(defaultValue="0")int page,Pageable pageable) {
    	Page<Report> pages=reportRepository.findAll(pageable);
    	
    	Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
    		
    	model.addAttribute("username",auth.getName());
    	model.addAttribute("roles",auth.getAuthorities());
    	System.out.println(pages.getTotalElements());
    	System.out.println(pages.getTotalPages());
    	System.out.println(pages.getNumber());
    	System.out.println(pages.getNumberOfElements());
    	System.out.println(pages.getSize());
    	System.out.println("No of Links"+Math.round(pages.getTotalElements()+pages.getTotalPages())/pageSize);
    	model.addAttribute("noOfLinks", Math.round(pages.getTotalElements()+pages.getTotalPages())/pageSize);
        model.addAttribute("reportList", reportRepository.findAll(new PageRequest(page, pageSize)));
        return "home";
    }

    @RequestMapping(value = "/addReport", method = RequestMethod.POST )
    public String addReport(@ModelAttribute Report report,Model model,Pageable pageable,@RequestParam(defaultValue="0")int page) {
        reportRepository.save(report);
        Page<Report> pages=reportRepository.findAll(pageable);
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
    		
    	model.addAttribute("username",auth.getName());
    	model.addAttribute("roles",auth.getAuthorities());
        System.out.println("element"+pages.getTotalElements());
    	System.out.println("pages"+pages.getTotalPages());
    	System.out.println("number"+pages.getNumber());
    	System.out.println("noofeleemnts"+pages.getNumberOfElements());
    	System.out.println("size"+pages.getSize());
    	
    	model.addAttribute("noOfLinks", Math.round((pages.getTotalElements()+pages.getTotalPages())/pageSize));
        model.addAttribute("reportList", reportRepository.findAll(new PageRequest(page, pageSize)));
        return "home";
    }

    @RequestMapping(value = "/deleteReport", method = RequestMethod.POST)
        public String deleteReport(Model model, @RequestParam String id,Pageable pageable,@RequestParam(defaultValue="0")int page) {
    	Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
    		
    	model.addAttribute("username",auth.getName());
    	model.addAttribute("roles",auth.getAuthorities());
    	Optional<Report> report =reportRepository.findById(id);
        reportRepository.deleteById(report.get().getId());
        Page<Report> pages=reportRepository.findAll(pageable);
    	model.addAttribute("noOfLinks", Math.round((pages.getTotalElements()+pages.getTotalPages())/pageSize));
        model.addAttribute("reportList", reportRepository.findAll(new PageRequest(page, pageSize)));
       return "home";
    }
   
    
    @RequestMapping(value = "/editReport", method = RequestMethod.POST)
    public String editReport(@RequestParam String id, Model model) {
    Report report =reportSearchRepository.findOne(id);
    Authentication auth = SecurityContextHolder.getContext()
            .getAuthentication();
		
	model.addAttribute("username",auth.getName());
	model.addAttribute("roles",auth.getAuthorities());
    model.addAttribute("report" , report);
		return "edit";      	
    }
    
    
    @RequestMapping(value = "/updateReport", method = RequestMethod.POST)
    public String updateReport(@RequestParam String id, Report report,Model model,Pageable pageable,@RequestParam(defaultValue="0")int page) {
    	reportSearchRepository.findAndModify(id,report);
    	 Page<Report> pages=reportRepository.findAll(pageable);
     	model.addAttribute("noOfLinks", Math.round((pages.getTotalElements()+pages.getTotalPages())/pageSize));
         model.addAttribute("reportList", reportRepository.findAll(new PageRequest(page, pageSize)));
     	
         Authentication auth = SecurityContextHolder.getContext()
                 .getAuthentication();
     		
     	model.addAttribute("username",auth.getName());
     	model.addAttribute("roles",auth.getAuthorities());
         return "home";      	
    }
    
    
    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam String search,@RequestParam(defaultValue="0")int page,Pageable pageable) {
    	List<Report> rep=(List<Report>) reportSearchRepository.searchReports(search);
    	System.out.println("PAGE	 :: "+page);
    	System.out.println("rep size	 :: "+rep.size());
    	System.out.println(" no odf link	 :: "+Math.round(rep.size()/pageSize));
     	model.addAttribute("noOfLinks", Math.round(rep.size()/pageSize));
        model.addAttribute("reportList", rep);
    	List<Report> repltst=(List<Report>) reportSearchRepository.searchReports(search,page,pageSize);
    	System.out.println("final list size :: "+repltst.size());
      
    	Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
    		
    	model.addAttribute("username",auth.getName());
    	model.addAttribute("roles",auth.getAuthorities());
    	model.addAttribute("search", repltst);
        return "home";
    }

}