package com.smaato.sdk.core.util;

import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.diinjection.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public final class DateEncoder {
    private static final DateEncoder instance = new DateEncoder();

    @Inject
    private static Logger logger;

    private DateEncoder() {
        AndroidsInjector.injectStatic(DateEncoder.class);
    }

    public static DateEncoder getInstance() {
        return instance;
    }

    public String decode(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss Z", Locale.getDefault());
        try {
            return simpleDateFormat.format(new Date(Long.parseLong(str, 2) * 100));
        } catch (Exception unused) {
            return simpleDateFormat.format(new Date(System.currentTimeMillis()));
        }
    }

    public Long decodeHeaderDate(String str) {
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", new Locale("en", "US", "POSIX"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MM yyyy HH:mm:ss zzz", new Locale("en", "US", "POSIX"));
        try {
            return Long.valueOf(simpleDateFormat.parse(str).getTime());
        } catch (ParseException e) {
            logError("Error in parsing alpha month", e);
            try {
                return Long.valueOf(simpleDateFormat2.parse(str).getTime());
            } catch (ParseException e2) {
                logError("Error in parsing numeric month", e2);
                return null;
            }
        }
    }

    private static void logError(String str, Throwable th) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.error(LogDomain.CORE, str, th);
        }
    }
}
