package Sacco.view.financeManip;

public class SaccoAccountManip {
    private String code;
    private String header;
    private String footer;
    private String type;
    private String name;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter() {
        return footer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SaccoAccountManip() {
        super();
    }
}
