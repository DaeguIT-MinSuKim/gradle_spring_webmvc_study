package gradle_spring_webmvc_study.dto;

public class OsCode {
    private String code;
    private String label;

    public OsCode(String code, String label){
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
