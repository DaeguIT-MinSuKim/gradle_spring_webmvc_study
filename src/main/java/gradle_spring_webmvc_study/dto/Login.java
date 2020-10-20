package gradle_spring_webmvc_study.dto;

import java.util.Arrays;

public class Login {
    private String loginType;
    private JobCode jobCode;
    private String[] favoriteOs;
    private OsCode[] osCode;
    private boolean allowNoti;
    private String tool;
    private String etc;

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public boolean isAllowNoti() {
        return allowNoti;
    }

    public void setAllowNoti(boolean allowNoti) {
        this.allowNoti = allowNoti;
    }

    public OsCode[] getOsCode() {
        return osCode;
    }

    public void setOsCode(OsCode[] osCode) {
        this.osCode = osCode;
    }

    public String[] getFavoriteOs() {
        return favoriteOs;
    }

    public void setFavoriteOs(String[] favoriteOs) {
        this.favoriteOs = favoriteOs;
    }

    public JobCode getJobCode() {
        return jobCode;
    }

    public void setJobCode(JobCode jobCode) {
        this.jobCode = jobCode;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return String.format(
                "Login [loginType=%s, jobCode=%s, favoriteOs=%s, osCode=%s, allowNoti=%s, tool=%s, etc=%s]", loginType,
                jobCode, Arrays.toString(favoriteOs), Arrays.toString(osCode), allowNoti, tool, etc);
    }

}
