package mayton.libs.encoders.qrcode;

public class WifiQrCode {

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("WIFI:");
        if (networkName != null) s.append("S:").append(networkName).append(";");
        if (pwd != null) s.append("P:").append(pwd).append(";");
        s.append("T:").append(encryption.desc).append(";");
        s.append("H:").append(hidden ? "Y" : "N").append(";");
        return s.toString();
    }

    public static enum Encryption {
        WPA_WPA2("WPA/WPA2"),
        NONE("None"),
        WEB("WEB");
        public final String desc;
        Encryption(String desc) {
            this.desc = desc;
        }
    }

    private String networkName;
    private String pwd;
    private boolean hidden;
    private Encryption encryption;

    public static class Builder {

        private String networkName;
        private String pwd;
        private boolean hidden;
        private Encryption encryption;

        public Builder() {
        }

        Builder(String networkName, String pwd, boolean hidden, Encryption encryption) {
            this.networkName = networkName;
            this.pwd = pwd;
            this.hidden = hidden;
            this.encryption = encryption;
        }

        public Builder networkName(String networkName){
            this.networkName = networkName;
            return Builder.this;
        }

        public Builder pwd(String pwd){
            this.pwd = pwd;
            return Builder.this;
        }

        public Builder hidden(boolean hidden){
            this.hidden = hidden;
            return Builder.this;
        }

        public Builder encryption(Encryption encryption){
            this.encryption = encryption;
            return Builder.this;
        }

        public WifiQrCode build() {

            return new WifiQrCode(this);
        }
    }

    private WifiQrCode(Builder builder) {
        this.networkName = builder.networkName;
        this.pwd = builder.pwd;
        this.hidden = builder.hidden;
        this.encryption = builder.encryption;
    }

}
