package io.appmetrica.analytics.coreutils.internal.logger;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LoggerStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap f10997a = new HashMap();
    private static final Object b = new Object();
    private static volatile PublicLogger c = PublicLogger.getAnonymousInstance();

    public static PublicLogger getMainPublicOrAnonymousLogger() {
        return c;
    }

    public static PublicLogger getOrCreateMainPublicLogger(String str) {
        c = getOrCreatePublicLogger(str);
        return c;
    }

    public static PublicLogger getOrCreatePublicLogger(String str) {
        if (TextUtils.isEmpty(str)) {
            return PublicLogger.getAnonymousInstance();
        }
        PublicLogger publicLogger = (PublicLogger) f10997a.get(str);
        if (publicLogger == null) {
            synchronized (b) {
                publicLogger = (PublicLogger) f10997a.get(str);
                if (publicLogger == null) {
                    publicLogger = new PublicLogger(ApiKeyUtils.createPartialApiKey(str));
                    f10997a.put(str, publicLogger);
                }
            }
        }
        return publicLogger;
    }

    public static void unsetPublicLoggers() {
        f10997a = new HashMap();
        c = PublicLogger.getAnonymousInstance();
    }
}
