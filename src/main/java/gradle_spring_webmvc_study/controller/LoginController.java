package gradle_spring_webmvc_study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gradle_spring_webmvc_study.dto.Code;
import gradle_spring_webmvc_study.dto.Login;

@Controller
/*@RequestMapping("/login")*/
public class LoginController {
    
    @GetMapping("/login")
    public String form(Login login){
        return "login/form";
    }
    
    @PostMapping("/result")
    public String result(@ModelAttribute("login") Login login){
        return "login/result";
    }
    
    @ModelAttribute("jobCodes")
    public List<Code> getJobCodes(){
        List<Code> jobCodes = new ArrayList<>();
        jobCodes.add(new Code("A", "사용자"));
        jobCodes.add(new Code("B", "개발자"));
        jobCodes.add(new Code("C", "관리자"));
        return jobCodes;
    }
    
    @ModelAttribute("loginTypes")
    public List<String> getLoginTypes(){
        List<String> loginTypes = new ArrayList<>();
        loginTypes.add("일반회원");
        loginTypes.add("기업회원");
        loginTypes.add("헤드헌터회원");
        return loginTypes;
    }
}


/*
@GetMapping("/login2")
public String form2(Model model){
    List<String> loginTypes = new ArrayList<>();
    loginTypes.add("일반회원");
    loginTypes.add("기업회원");
    loginTypes.add("헤드헌터회원");
    model.addAttribute("loginTypes", loginTypes);
    return "login/form";
}

@GetMapping("/login3")
public ModelAndView form3(){
    List<String> loginTypes = new ArrayList<>();
    loginTypes.add("일반회원");
    loginTypes.add("기업회원");
    loginTypes.add("헤드헌터회원");
    
    List<JobCode> jobCodes = new ArrayList<>();
    jobCodes.add(new JobCode("사용자", "A"));
    jobCodes.add(new JobCode("개발자", "B"));
    jobCodes.add(new JobCode("관리자", "C"));
    
    ModelAndView mav =  new ModelAndView();
    mav.addObject("loginTypes", loginTypes);
    mav.addObject("jobCodes", jobCodes);
    mav.setViewName("login/form");
    return mav;
}

@GetMapping("/login4")
public ModelAndView form4(Login login){
    List<String> loginTypes = new ArrayList<>();
    loginTypes.add("일반회원");
    loginTypes.add("기업회원");
    loginTypes.add("헤드헌터회원");
    
    List<JobCode> jobCodes = new ArrayList<>();
    jobCodes.add(new JobCode("사용자", "A"));
    jobCodes.add(new JobCode("개발자", "B"));
    jobCodes.add(new JobCode("관리자", "C"));
    
    String[] favoriteOsNames = {"윈도우10", "리눅스", "유닉스"};
    
    List<OsCode> osCodes = Arrays.asList(
            new OsCode("w", "윈도우10"),
            new OsCode("l", "리눅스"),
            new OsCode("u", "유닉스"));
    
    List<String> tools = Arrays.asList("Eclipse", "IntelliJ", "VSCode");
    
    ModelAndView mav =  new ModelAndView();
    mav.addObject("loginTypes", loginTypes);
    mav.addObject("jobCodes", jobCodes);
    mav.addObject("favoriteOsNames", favoriteOsNames);
    mav.addObject("osCodes", osCodes);
    mav.addObject("tools", tools);
    
    mav.setViewName("login/form");
    return mav;
}

*/