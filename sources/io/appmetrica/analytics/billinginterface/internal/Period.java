package io.appmetrica.analytics.billinginterface.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class Period {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f10937a = Pattern.compile("P(\\d+)(\\S+)");
    public final int number;
    public final TimeUnit timeUnit;

    public enum TimeUnit {
        TIME_UNIT_UNKNOWN,
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    public Period(int i, TimeUnit timeUnit) {
        this.number = i;
        this.timeUnit = timeUnit;
    }

    public static Period parse(String str) {
        TimeUnit timeUnit;
        Matcher matcher = f10937a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        if (strGroup == null || strGroup2 == null) {
            return null;
        }
        try {
            int i = Integer.parseInt(strGroup);
            char cCharAt = strGroup2.charAt(0);
            if (cCharAt == 'D') {
                timeUnit = TimeUnit.DAY;
            } else if (cCharAt == 'M') {
                timeUnit = TimeUnit.MONTH;
            } else if (cCharAt != 'W') {
                timeUnit = cCharAt != 'Y' ? TimeUnit.TIME_UNIT_UNKNOWN : TimeUnit.YEAR;
            } else {
                timeUnit = TimeUnit.WEEK;
            }
            return new Period(i, timeUnit);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Period period = (Period) obj;
        return this.number == period.number && this.timeUnit == period.timeUnit;
    }

    public int hashCode() {
        return this.timeUnit.hashCode() + (this.number * 31);
    }

    public String toString() {
        return "Period{number=" + this.number + "timeUnit=" + this.timeUnit + "}";
    }
}
