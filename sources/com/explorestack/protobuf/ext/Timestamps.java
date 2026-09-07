package com.explorestack.protobuf.ext;

import com.explorestack.protobuf.Duration;
import com.explorestack.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes10.dex */
public final class Timestamps {
    static final long MILLIS_PER_SECOND = 1000;
    static final long NANOS_PER_MICROSECOND = 1000;
    static final long NANOS_PER_MILLISECOND = 1000000;
    static final long NANOS_PER_SECOND = 1000000000;
    static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
    private static final ThreadLocal<SimpleDateFormat> timestampFormat = new ThreadLocal<SimpleDateFormat>() { // from class: com.explorestack.protobuf.ext.Timestamps.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return Timestamps.createTimestampFormat();
        }
    };

    public static boolean isValid(long j, int i) {
        return j >= TIMESTAMP_SECONDS_MIN && j <= TIMESTAMP_SECONDS_MAX && i >= 0 && ((long) i) < 1000000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SimpleDateFormat createTimestampFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }

    private Timestamps() {
    }

    public static Timestamp checkValid(Timestamp timestamp) {
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        if (isValid(seconds, nanos)) {
            return timestamp;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(seconds), Integer.valueOf(nanos)));
    }

    public static Timestamp checkValid(Timestamp.Builder builder) {
        return checkValid(builder.build());
    }

    public static String toString(Timestamp timestamp) {
        checkValid(timestamp);
        long seconds = timestamp.getSeconds();
        int nanos = timestamp.getNanos();
        StringBuilder sb = new StringBuilder();
        sb.append(timestampFormat.get().format(new Date(seconds * 1000)));
        if (nanos != 0) {
            sb.append(".");
            sb.append(formatNanos(nanos));
        }
        sb.append("Z");
        return sb.toString();
    }

    public static Timestamp fromMillis(long j) {
        return normalizedTimestamp(j / 1000, (int) ((j % 1000) * 1000000));
    }

    public static long toMillis(Timestamp timestamp) {
        checkValid(timestamp);
        return checkedAdd(checkedMultiply(timestamp.getSeconds(), 1000L), ((long) timestamp.getNanos()) / 1000000);
    }

    public static Timestamp add(Timestamp timestamp, Duration duration) {
        checkValid(timestamp);
        return normalizedTimestamp(checkedAdd(timestamp.getSeconds(), duration.getSeconds()), checkedAdd(timestamp.getNanos(), duration.getNanos()));
    }

    private static Timestamp normalizedTimestamp(long j, int i) {
        long j2 = i;
        if (j2 <= -1000000000 || j2 >= 1000000000) {
            j = checkedAdd(j, j2 / 1000000000);
            i = (int) (j2 % 1000000000);
        }
        if (i < 0) {
            i = (int) (((long) i) + 1000000000);
            j = checkedSubtract(j, 1L);
        }
        return checkValid(Timestamp.newBuilder().setSeconds(j).setNanos(i).build());
    }

    private static long parseTimezoneOffset(String str) throws ParseException {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid offset value: " + str, 0);
        }
        return ((Long.parseLong(str.substring(0, iIndexOf)) * 60) + Long.parseLong(str.substring(iIndexOf + 1))) * 60;
    }

    private static int parseNanos(String str) throws ParseException {
        int iCharAt = 0;
        for (int i = 0; i < 9; i++) {
            iCharAt *= 10;
            if (i < str.length()) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt += str.charAt(i) - '0';
            }
        }
        return iCharAt;
    }

    private static String formatNanos(int i) {
        long j = i;
        if (j % 1000000 == 0) {
            return String.format(Locale.ENGLISH, "%1$03d", Long.valueOf(j / 1000000));
        }
        if (j % 1000 == 0) {
            return String.format(Locale.ENGLISH, "%1$06d", Long.valueOf(j / 1000));
        }
        return String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(i));
    }

    private static int checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        int i = (int) j3;
        checkNoOverflow(j3 == ((long) i), "checkedSubtract", j, j2);
        return i;
    }

    private static int checkedAdd(long j, long j2) {
        long j3 = j + j2;
        int i = (int) j3;
        checkNoOverflow(j3 == ((long) i), "checkedAdd", j, j2);
        return i;
    }

    private static int checkedMultiply(long j, long j2) {
        long j3 = j * j2;
        int i = (int) j3;
        checkNoOverflow(j3 == ((long) i), "checkedMultiply", j, j2);
        return i;
    }

    private static void checkNoOverflow(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new ArithmeticException("overflow: " + str + "(" + j + ", " + j2 + ")");
        }
    }
}
