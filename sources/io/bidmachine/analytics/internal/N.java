package io.bidmachine.analytics.internal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f12053a = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.SSS", Locale.getDefault());

    public final Long a(String str) throws ParseException {
        Date date = this.f12053a.parse(Calendar.getInstance().get(1) + '-' + str);
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }
}
