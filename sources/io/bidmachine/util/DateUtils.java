package io.bidmachine.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\u001a"}, d2 = {"Lio/bidmachine/util/DateUtils;", "", "()V", "createCalendar", "Ljava/util/Calendar;", "daysBetween", "", "startDate", "Ljava/util/Date;", "endDate", "getBeginOfDayMs", "", "date", "getDateDaysAgo", "days", "getUtcOffsetMinutes", "isOlderThanDate", "", "whenDate", "dateMs", "isYearValid", "year", "setupCalendarStartOfDay", "", "calendar", "toCalendar", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();

    private DateUtils() {
    }

    @JvmStatic
    public static final Calendar createCalendar() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        return calendar;
    }

    @JvmStatic
    public static final Date getDateDaysAgo(int days) {
        Calendar calendar = DateUtilsKt.toCalendar(new Date());
        calendar.add(6, -days);
        Date time = calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "Date().toCalendar().appl…AR, -days)\n        }.time");
        return time;
    }

    @JvmStatic
    public static final int getUtcOffsetMinutes() {
        return (int) TimeUnit.MILLISECONDS.toMinutes(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }

    @JvmStatic
    public static final boolean isOlderThanDate(long dateMs, Date whenDate) {
        Intrinsics.checkNotNullParameter(whenDate, "whenDate");
        return isOlderThanDate(new Date(dateMs), whenDate);
    }

    @JvmStatic
    public static final boolean isOlderThanDate(Date date, Date whenDate) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(whenDate, "whenDate");
        return DateUtilsKt.isOlderThanDate(date, whenDate);
    }

    @JvmStatic
    public static final boolean isYearValid(int year) {
        return 1900 <= year && year <= createCalendar().get(1);
    }

    @JvmStatic
    public static final int daysBetween(Date startDate, Date endDate) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        return DateUtilsKt.daysBetween(startDate, endDate);
    }

    @JvmStatic
    public static final long getBeginOfDayMs(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return DateUtilsKt.getBeginOfDayMs(date);
    }

    @JvmStatic
    public static final Calendar toCalendar(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return DateUtilsKt.toCalendar(date);
    }

    @JvmStatic
    public static final void setupCalendarStartOfDay(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        DateUtilsKt.setupCalendarStartOfDay(calendar);
    }
}
