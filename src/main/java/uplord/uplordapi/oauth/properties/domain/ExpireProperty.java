package uplord.uplordapi.oauth.properties.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Getter
public class ExpireProperty {
    private final Long DefaultValue = 0L;

    private final Long days;
    private final Long hours;
    private final Long minutes;
    private final Long seconds;

    public ExpireProperty(Long days, Long hours, Long minutes, Long seconds) {
        this.days = days == null ? DefaultValue : days;
        this.hours = hours == null ? DefaultValue : hours;
        this.minutes = minutes == null ? DefaultValue : minutes;
        this.seconds = seconds == null ? DefaultValue : seconds;
    }

    public Long getMaxAge() {
        long maxAge = 0L;
        if (isExistsValue(this.days)) {
            maxAge += this.days * 24L * 60L * 60L;
        }
        if (isExistsValue(this.hours)) {
            maxAge += this.hours * 60L * 60L;
        }
        if (isExistsValue(this.minutes)) {
            maxAge += this.minutes * 60L;
        }
        if (isExistsValue(this.seconds)) {
            maxAge += this.seconds;
        }
        return maxAge;
    }

    public final Date toDate() {
        return Date.from(
                LocalDateTime.now()
                        .plusDays(days)
                        .plusHours(hours)
                        .plusMinutes(minutes)
                        .plusSeconds(seconds)
                        .atZone(ZoneId.systemDefault()).toInstant()
        );
    }

    private boolean isExistsValue(Long value) {
        return !value.equals(DefaultValue);
    }
}