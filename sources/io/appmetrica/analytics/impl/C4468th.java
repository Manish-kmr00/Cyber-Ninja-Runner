package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ICrashTransformer;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.th, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4468th extends AbstractC4457t6 {
    public final AbstractC4474tn d;

    public C4468th(Context context, AbstractC4474tn abstractC4474tn, InterfaceC4432s6 interfaceC4432s6, ICrashTransformer iCrashTransformer) {
        this(abstractC4474tn, interfaceC4432s6, iCrashTransformer, new T9(context));
    }

    public final AbstractC4474tn c() {
        return this.d;
    }

    public C4468th(AbstractC4474tn abstractC4474tn, InterfaceC4432s6 interfaceC4432s6, ICrashTransformer iCrashTransformer, T9 t9) {
        super(interfaceC4432s6, iCrashTransformer, t9);
        this.d = abstractC4474tn;
    }
}
