package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c5 implements q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t8 f8569a;
    private final WeakReference<l51> b;

    public /* synthetic */ c5(l51 l51Var) {
        this(l51Var, new t8(), new WeakReference(l51Var));
    }

    public c5(l51 nativeAdEventController, t8 adResultReceiver, WeakReference<l51> eventControllerReference) {
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(adResultReceiver, "adResultReceiver");
        Intrinsics.checkNotNullParameter(eventControllerReference, "eventControllerReference");
        this.f8569a = adResultReceiver;
        this.b = eventControllerReference;
        adResultReceiver.a(this);
    }

    public final t8 a() {
        return this.f8569a;
    }

    @Override // com.yandex.mobile.ads.impl.q3
    public final void a(int i, Bundle bundle) {
        l51 l51Var = this.b.get();
        if (l51Var != null) {
            if (i == 19) {
                l51Var.g();
                return;
            }
            if (i != 20) {
                switch (i) {
                    case 6:
                        l51Var.e();
                        break;
                    case 7:
                        l51Var.d();
                        break;
                    case 8:
                        l51Var.c();
                        break;
                    case 9:
                        l51Var.b();
                        break;
                }
                return;
            }
            l51Var.f();
        }
    }
}
