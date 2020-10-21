package gradle_spring_webmvc_study.dto;

public class Code {
    private String code;
    private String label;

    public Code() {
        // TODO Auto-generated constructor stub
    }

    public Code(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("Code [code=%s, label=%s]", code, label);
    }

    
}
