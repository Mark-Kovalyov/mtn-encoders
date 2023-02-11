package mayton.libs.encoders.qrcode;;

public class VCardQrCode {

    private String n;
    private String fn;
    private String org;
    private String title;
    private String adr;
    private String tel;
    private String work;
    private String voice;
    private String cell;
    private String fax;
    private String email;
    private String url;

    // BEGIN:VCARD
    // VERSION:3.0
    // N:Sname;Name
    // FN:Name Sname
    // ORG:Organization
    // TITLE:JobTitle
    // ADR:;;Street;CIty;State;12345;Country
    // TEL;
    // WORK;
    // VOICE:MainPhone TEL;
    // CELL:Mobile TEL;
    // FAX:Fax EMAIL;WORK;
    // INTERNET:you@mail.com
    // URL:www.site.com
    // END:VCARD

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("BEGIN:VCARD\n");
        s.append("VERSION:3.0\n");
        if (n != null) s.append("N:").append(n).append(";\n");
        if (fn != null) s.append("FN:").append(fn).append(";\n");
        if (org != null) s.append("ORG:").append(org).append(";\n");
        if (title != null) s.append("TITLE:").append(title).append(";\n");
        if (adr != null) s.append("ADR:").append(adr).append(";\n");
        if (tel != null) s.append("TEL:").append(tel).append(";\n");
        if (work != null) s.append("WORK:").append(work).append(";\n");
        if (voice != null) s.append("VOICE:").append(work).append(" TEL;\n");
        if (cell != null) s.append("CELL:").append(cell).append(" TEL;\n");
        if (fax != null) s.append("FAX:").append(fax).append("EMAIL;WORK;\n");
        if (url != null) s.append("URL:").append(url).append(";\n");
        s.append("END:VCARD\n");
        return s.toString();
    }

    public static class Builder {

        private String n;
        private String fn;
        private String org;
        private String title;
        private String adr;
        private String tel;
        private String work;
        private String voice;
        private String cell;
        private String fax;
        private String email;
        private String url;

        public Builder() {
        }

        public Builder n(String n){
            this.n = n;
            return Builder.this;
        }

        public Builder fn(String fn){
            this.fn = fn;
            return Builder.this;
        }

        public Builder org(String org){
            this.org = org;
            return Builder.this;
        }

        public Builder title(String title){
            this.title = title;
            return Builder.this;
        }

        public Builder adr(String adr){
            this.adr = adr;
            return Builder.this;
        }

        public Builder tel(String tel){
            this.tel = tel;
            return Builder.this;
        }

        public Builder work(String work){
            this.work = work;
            return Builder.this;
        }

        public Builder voice(String voice){
            this.voice = voice;
            return Builder.this;
        }

        public Builder cell(String cell){
            this.cell = cell;
            return Builder.this;
        }

        public Builder fax(String fax){
            this.fax = fax;
            return Builder.this;
        }

        public Builder email(String email){
            this.email = email;
            return Builder.this;
        }

        public Builder url(String url){
            this.url = url;
            return Builder.this;
        }

        public VCardQrCode build() {
            return new VCardQrCode(this);
        }
    }

    private VCardQrCode(Builder builder) {
        this.n = builder.n;
        this.fn = builder.fn;
        this.org = builder.org;
        this.title = builder.title;
        this.adr = builder.adr;
        this.tel = builder.tel;
        this.work = builder.work;
        this.voice = builder.voice;
        this.cell = builder.cell;
        this.fax = builder.fax;
        this.email = builder.email;
        this.url = builder.url;
    }


}