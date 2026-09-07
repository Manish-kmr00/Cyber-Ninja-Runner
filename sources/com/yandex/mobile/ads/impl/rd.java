package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f10095a = new CopyOnWriteArraySet<>();
    private static final Map<String, String> b;
    public static final /* synthetic */ int c = 0;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = be1.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = be1.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = dh0.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = e42.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttplib.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        b = MapsKt.toMap(linkedHashMap);
    }

    public static void a(String loggerName, int i, String message, Throwable th) {
        int iMin;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String strTake = b.get(loggerName);
        if (strTake == null) {
            strTake = StringsKt.take(loggerName, 23);
        }
        if (Log.isLoggable(strTake, i)) {
            if (th != null) {
                message = message + "\n" + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i2 = 0;
            while (i2 < length) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) message, '\n', i2, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i2 + 4000);
                    String strSubstring = message.substring(i2, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    Log.println(i, strTake, strSubstring);
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public static void a() {
        Level level;
        for (Map.Entry<String, String> entry : b.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Logger logger = Logger.getLogger(key);
            if (f10095a.add(logger)) {
                logger.setUseParentHandlers(false);
                if (Log.isLoggable(value, 3)) {
                    level = Level.FINE;
                } else {
                    level = Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING;
                }
                logger.setLevel(level);
                logger.addHandler(sd.f10196a);
            }
        }
    }
}
