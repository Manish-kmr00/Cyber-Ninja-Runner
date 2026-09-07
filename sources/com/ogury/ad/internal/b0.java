package com.ogury.ad.internal;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.MissingResourceException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7264a;
    public final s7 b;

    public b0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (s7.c == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            s7.c = new s7(applicationContext);
        }
        s7 profigDao = s7.c;
        Intrinsics.checkNotNull(profigDao);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profigDao, "profigDao");
        this.f7264a = context;
        this.b = profigDao;
    }

    public final String a() {
        return this.b.b();
    }

    public final boolean c() {
        return this.f7264a.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }

    public final String e() {
        return "5.0.1/" + this.b.b() + RemoteSettings.FORWARD_SLASH_STRING + Build.VERSION.RELEASE;
    }

    public final String f() {
        String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f7264a);
        Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "getDefaultUserAgent(...)");
        return defaultUserAgent;
    }

    public final String b() {
        try {
            return this.f7264a.getResources().getConfiguration().getLocales().get(0).getCountry();
        } catch (MissingResourceException unused) {
            return "ZZ";
        }
    }

    public final String d() {
        String language = this.f7264a.getResources().getConfiguration().getLocales().get(0).getLanguage();
        Intrinsics.checkNotNull(language);
        return language;
    }
}
