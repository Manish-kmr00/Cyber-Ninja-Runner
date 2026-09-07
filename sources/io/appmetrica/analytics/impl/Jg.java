package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class Jg implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4576y0 f11209a;

    public Jg(C4576y0 c4576y0) {
        this.f11209a = c4576y0;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    public final Object apply(Object obj) {
        String str = (String) obj;
        C4576y0 c4576y0 = this.f11209a;
        String str2 = c4576y0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c4576y0.f.f11867a);
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str2);
        C4082e4 c4082e4 = new C4082e4("", "", 5898, 0, orCreatePublicLogger);
        if (str != null) {
            c4082e4.f(str);
        }
        c4082e4.m = bundle;
        c4082e4.c = this.f11209a.f.f;
        return c4082e4;
    }
}
