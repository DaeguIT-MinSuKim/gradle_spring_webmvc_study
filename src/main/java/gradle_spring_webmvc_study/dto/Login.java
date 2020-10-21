package gradle_spring_webmvc_study.dto;

import java.util.List;

public class Login {
    private String loginType;
    private String jobCode;
    private Code job;
    private String tool;
    private List<String> favoriteOs;
    private List<String> likeOs;
    private List<Code> subjects;
    private List<String> strSubjects;

    
    public Code getJob() {
        return job;
    }

    public void setJob(Code job) {
        this.job = job;
    }

    public List<String> getStrSubjects() {
        return strSubjects;
    }

    public void setStrSubjects(List<String> strSubjects) {
        this.strSubjects = strSubjects;
    }

    public List<Code> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Code> subjects) {
        this.subjects = subjects;
    }

    public List<String> getLikeOs() {
        return likeOs;
    }

    public void setLikeOs(List<String> likeOs) {
        this.likeOs = likeOs;
    }

    public List<String> getFavoriteOs() {
        return favoriteOs;
    }

    public void setFavoriteOs(List<String> favoriteOs) {
        this.favoriteOs = favoriteOs;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
