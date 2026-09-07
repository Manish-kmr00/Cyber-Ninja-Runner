package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C4007b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4367pf f11474a;
    public final CounterConfiguration b;

    public C4007b4(C4367pf c4367pf, CounterConfiguration counterConfiguration) {
        this.f11474a = c4367pf;
        this.b = counterConfiguration;
    }

    public static C4007b4 a(Context context, Bundle bundle) {
        C4367pf c4367pf;
        String str = C4367pf.c;
        if (bundle != null) {
            try {
                c4367pf = (C4367pf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
                c4367pf = null;
            }
        } else {
            c4367pf = null;
        }
        CounterConfiguration counterConfigurationFromBundle = CounterConfiguration.fromBundle(bundle);
        if (counterConfigurationFromBundle == null || c4367pf == null || !context.getPackageName().equals(c4367pf.f11723a.getAsString("PROCESS_CFG_PACKAGE_NAME")) || c4367pf.f11723a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() != AppMetrica.getLibraryApiLevel()) {
            return null;
        }
        return new C4007b4(c4367pf, counterConfigurationFromBundle);
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f11474a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final C4367pf a() {
        return this.f11474a;
    }
}
