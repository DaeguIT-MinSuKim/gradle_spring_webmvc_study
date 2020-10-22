package gradle_spring_webmvc_study.dto;

public class AuthInfo {
    private Long id;
    private String email;
    private String name;

    public AuthInfo() {
        // TODO Auto-generated constructor stub
    }

    public AuthInfo(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
