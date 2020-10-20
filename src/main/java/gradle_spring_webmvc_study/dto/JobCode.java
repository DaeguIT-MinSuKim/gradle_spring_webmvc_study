package gradle_spring_webmvc_study.dto;

public class JobCode {
    private String code;
    private String label;

    public JobCode(String code, String label){
       this.code = code;
       this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

}
