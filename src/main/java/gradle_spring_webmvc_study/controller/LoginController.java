package gradle_spring_webmvc_study.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring_webmvc_study.dto.AuthInfo;
import gradle_spring_webmvc_study.dto.LoginCommand;
import gradle_spring_webmvc_study.exception.WrongIdPasswordException;
import gradle_spring_webmvc_study.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthService authService;

    @GetMapping
    public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required = false) Cookie rCookie) {
        if (rCookie != null) {
            loginCommand.setEmail(rCookie.getValue());
            loginCommand.setRememberEmail(true);
        }
        return "/login/loginForm";
    }

    @PostMapping
    public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
//        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors())
            return "/login/loginForm";
        try {
            AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
            //TODO 세션에 authInfo 저장해야함
            session.setAttribute("authInfo", authInfo);
            
            //쿠키를 이용한 이메일기억하기 적용
            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
            rememberCookie.setPath("/");
            if (loginCommand.isRememberEmail()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 30);
            }else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);

            
            return "/login/loginSuccess";
        }catch (WrongIdPasswordException ex) {
            errors.reject("idPasswordNotMatching");
            return "/login/loginForm";
        }
    }


}


/*
    @GetMapping("/login1")
    public String form1(Login login){
        return "login/form";
    }
    
    @GetMapping("/login2")
    public String form2(Login login){
        login.setLoginType("기업회원");
        login.setJobCode("B");
        login.setTool("VSCode");
        List<String> favoriteOs = Arrays.asList("리눅스", "칼리리눅스");
        login.setFavoriteOs(favoriteOs);
        List<String> likeOs = Arrays.asList("O1", "O5");
        login.setLikeOs(likeOs);
        return "login/form";
    }
    
    @GetMapping("/login3")
    public String form3(){
        return "login/form2";
    }
    @PostMapping("/result2")
    public String result2(Model model, 
            @RequestParam("loginType") String loginType,
            @RequestParam("jobCode") String jobCode,
            @RequestParam("likeOs") List<String> likeOs){
        
        model.addAttribute("loginType", loginType);
        model.addAttribute("jobCode", jobCode);
        
        Map<String, Code> osMap = getLikeOsMap();
        List<Code> likeOsCode = new ArrayList<Code>();
        for(String os : likeOs) {
            likeOsCode.add(osMap.get(os));
        }
        model.addAttribute("likeOs", likeOsCode);
        return "login/result2";
    }
    
    public Map<String, Code> getLikeOsMap(){
        Map<String, Code> likeOs = new HashMap<String, Code>();
        likeOs.put("O1", new Code("O1", "윈도우10"));
        likeOs.put("O2",new Code("O2", "리눅스"));
        likeOs.put("O3", new Code("O3", "유닉스"));
        likeOs.put("O4",new Code("O4", "칼리리눅스"));
        likeOs.put("O5",new Code("O5", "우분투"));
        return likeOs;
    }
    
    @PostMapping("/result")
    public String result(@ModelAttribute("login") Login login){
        login.setSubjects(getSelectedSubjects(login.getStrSubjects()));
        return "login/result";
    }

    private List<Code> getSelectedSubjects(List<String> strSubjects) {
        List<Code> subjects = getSubjects();
        List<Code> selected = new ArrayList<>();
        for(String c : strSubjects) {
            Code code = new Code(c, null);
            if (subjects.contains(code)) {
                selected.add(subjects.get(subjects.indexOf(code)));
            }
        }
        return selected;
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
    
    @ModelAttribute("tools")
    public List<String> getTools(){
        List<String> tools = new ArrayList<>();
        tools.add("Eclipse");
        tools.add("IntelliJ");
        tools.add("VSCode");
        return tools;
    }
    
    @ModelAttribute("favoriteOsNames")
    public List<String> getFavoriteOsNames(){
        List<String> favoriteOs = new ArrayList<>();
        favoriteOs.add("윈도우10");
        favoriteOs.add("리눅스");
        favoriteOs.add("유닉스");
        favoriteOs.add("칼리리눅스");
        favoriteOs.add("우분투");
        return favoriteOs;
    }
    
    @ModelAttribute("likeOs")
    public List<Code> getLikeOs(){
        List<Code> likeOs = new ArrayList<>();
        likeOs.add(new Code("O1", "윈도우10"));
        likeOs.add(new Code("O2", "리눅스"));
        likeOs.add(new Code("O3", "유닉스"));
        likeOs.add(new Code("O4", "칼리리눅스"));
        likeOs.add(new Code("O5", "우분투"));
        return likeOs;
    }
    
    @ModelAttribute("subjects")
    public List<Code> getSubjects(){
        List<Code> subjects = new ArrayList<>();
        subjects.add(new Code("S1", "윈도우10"));
        subjects.add(new Code("S2", "리눅스"));
        subjects.add(new Code("S3", "유닉스"));
        subjects.add(new Code("S4", "칼리리눅스"));
        subjects.add(new Code("S5", "우분투"));
        return subjects;
    } 
*/