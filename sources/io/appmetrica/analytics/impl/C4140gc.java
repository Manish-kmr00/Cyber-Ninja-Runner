package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4140gc extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4165hc f11567a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4140gc(C4165hc c4165hc) {
        super(0);
        this.f11567a = c4165hc;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0039  */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Ac c4615ze;
        C4165hc c4165hc = this.f11567a;
        Bc bc = c4165hc.f;
        InterfaceC4560x9 interfaceC4560x9 = c4165hc.b;
        Fg fg = c4165hc.f11584a;
        F4 f4 = c4165hc.c;
        Le le = c4165hc.d;
        bc.getClass();
        if (FrameworkDetector.isNative()) {
            T9 t9H = C4486ua.E.h();
            Bundle applicationMetaData = t9H.d.getApplicationMetaData(t9H.f11362a);
            if (TextUtils.isEmpty(applicationMetaData != null ? applicationMetaData.getString("io.appmetrica.analytics.plugin_id") : null)) {
                c4615ze = new Jd();
            } else {
                c4615ze = new C4615ze(interfaceC4560x9, fg, f4, le);
            }
        } else {
            c4615ze = new C4615ze(interfaceC4560x9, fg, f4, le);
        }
        return c4615ze.a();
    }
}
