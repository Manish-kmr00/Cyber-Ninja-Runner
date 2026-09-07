package io.bidmachine.rendering;

import android.content.Context;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.utils.Logger;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.utils.UserAgentProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Rendering {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f12323a = new AtomicBoolean(false);
    private static UserAgentProvider b;

    public static String getUserAgent() {
        UserAgentProvider userAgentProvider = b;
        if (userAgentProvider != null) {
            return userAgentProvider.getUserAgent();
        }
        return null;
    }

    public static void initialize(Context context) {
        f12323a.compareAndSet(false, true);
    }

    public static void setLoggingEnabled(boolean isLoggingEnabled) {
        m.a(isLoggingEnabled);
        MraidLog.setLoggingLevel(isLoggingEnabled ? Logger.LogLevel.debug : Logger.LogLevel.none);
    }

    public static void setUserAgentProvider(UserAgentProvider userAgentProvider) {
        b = userAgentProvider;
    }
}
