package mayton.libs.encoders.qrcode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *     String event =
 *             "BEGIN:VEVENT " +
 *                     "SUMMARY:BoozeParty " +
 *                     "DESCRIPTION: " +
 *                     "LOCATION: Kiev" +
 *                     "DTSTART:20210704 " +
 *                     "DTEND:20210714 " +
 *                     "END:VEVENT";
 */

public class VEventQrCode {

    private String summary;
    private String desc;
    private String location;
    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("BEGIN:VEVENT\n");
        if (summary != null) s.append("SUMMARY:").append(summary).append("\n");
        if (desc != null) s.append("DESCRIPTION:").append(desc).append("\n");
        if (location != null) s.append("LOCATION:").append(location).append("\n");
        if (dtStart != null) s.append("DTSTART:").append(DateTimeFormatter.ISO_DATE_TIME.format(dtStart)).append("\n");
        if (dtEnd != null) s.append("DTEND:").append(DateTimeFormatter.ISO_DATE_TIME.format(dtEnd)).append("\n");
        s.append("END:VEVENT");
        return s.toString();
    }

    public static class Builder {

        private String summary;
        private String desc;
        private String location;
        private LocalDateTime dtStart;
        private LocalDateTime dtEnd;

        public Builder() {
        }

        public Builder summary(String summary){
            this.summary = summary;
            return Builder.this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return Builder.this;
        }

        public Builder location(String location){
            this.location = location;
            return Builder.this;
        }

        public Builder dtStart(LocalDateTime dtStart){
            this.dtStart = dtStart;
            return Builder.this;
        }

        public Builder dtStart(LocalDate dtStart){
            // TODO
            this.dtStart = null;
            return Builder.this;
        }

        public Builder dtEnd(LocalDateTime dtEnd){
            this.dtEnd = dtEnd;
            return Builder.this;
        }

        public Builder dtEnd(LocalDate dtEnd){
            // TODO
            this.dtStart = null;
            return Builder.this;
        }

        public VEventQrCode build() {

            return new VEventQrCode(this);
        }
    }

    private VEventQrCode(Builder builder) {
        this.summary = builder.summary;
        this.desc = builder.desc;
        this.location = builder.location;
        this.dtStart = builder.dtStart;
        this.dtEnd = builder.dtEnd;
    }


}

