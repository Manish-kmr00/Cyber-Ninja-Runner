package com.inmobi.media;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import com.playon.bridge.AdUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class V2 extends CustomTabsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W2 f3215a;

    public V2(W2 w2) {
        this.f3215a = w2;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        O1 o1;
        super.onNavigationEvent(i, bundle);
        Intrinsics.checkNotNullExpressionValue("W2", "access$getLOG_TAG$cp(...)");
        S1 s1 = this.f3215a.c;
        if (s1 != null) {
            X2 x2 = s1.h;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6 && x2.d == null) {
                            if (x2.e == 4) {
                                x2.d = Boolean.TRUE;
                            } else {
                                x2.d = Boolean.FALSE;
                            }
                            if (Intrinsics.areEqual(x2.d, Boolean.TRUE)) {
                                O1 o2 = x2.f3233a;
                                if (o2 != null) {
                                    o2.a(N5.LPCompleteSuccess, x2.b, (Integer) 8003);
                                }
                                O1 o3 = x2.f3233a;
                                if (o3 != null) {
                                    o3.c();
                                }
                            } else {
                                O1 o4 = x2.f3233a;
                                if (o4 != null) {
                                    o4.a(N5.LPCompleteFailed, x2.b, Integer.valueOf(AdUnit.ERROR_INVALID_MEDIA_URL));
                                }
                            }
                        }
                    } else if (x2.d == null) {
                        x2.d = Boolean.FALSE;
                        O1 o5 = x2.f3233a;
                        if (o5 != null) {
                            o5.a(N5.LPCompleteFailed, x2.b, (Integer) 8004);
                        }
                    }
                } else if (x2.d == null) {
                    x2.d = Boolean.TRUE;
                    O1 o6 = x2.f3233a;
                    if (o6 != null) {
                        o6.a(N5.LPCompleteSuccess, x2.b, (Integer) null);
                    }
                    O1 o7 = x2.f3233a;
                    if (o7 != null) {
                        o7.c();
                    }
                }
            } else if (!x2.c) {
                x2.c = true;
                O1 o8 = x2.f3233a;
                if (o8 != null) {
                    o8.a(N5.LPPageStart, x2.b, (Integer) null);
                }
            }
            x2.e = i;
            if (i != 5) {
                if (i == 6 && (o1 = s1.b) != null) {
                    o1.a();
                    return;
                }
                return;
            }
            O1 o9 = s1.b;
            if (o9 != null) {
                o9.b();
            }
        }
    }
}
