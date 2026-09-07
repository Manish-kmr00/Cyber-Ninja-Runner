package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class F7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3070a;
    public final C3313b7 b;
    public final L4 c;
    public final String d;
    public final L7 e;

    public F7(Context context, AdConfig adConfig, C3313b7 mNativeAdContainer, C3625x7 dataModel, L4 l4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(mNativeAdContainer, "mNativeAdContainer");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        this.b = mNativeAdContainer;
        this.c = l4;
        this.d = "F7";
        L7 l7 = new L7(context, adConfig, mNativeAdContainer, dataModel, new E7(this), new D7(this), this, l4);
        this.e = l7;
        K8 k8 = l7.m;
        int i = mNativeAdContainer.B;
        k8.getClass();
        K8.f = i;
    }

    public final R7 a(View view, ViewGroup parent, boolean z, Ba ba) {
        R7 r7A;
        L4 l4;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewWithTag = view != null ? view.findViewWithTag("InMobiAdView") : null;
        R7 r7 = viewFindViewWithTag instanceof R7 ? (R7) viewFindViewWithTag : null;
        if (z) {
            r7A = this.e.a(r7, parent, ba);
        } else {
            L7 l7 = this.e;
            l7.getClass();
            Intrinsics.checkNotNullParameter(parent, "parent");
            l7.o = ba;
            R7 container = l7.a(r7, parent);
            if (!l7.n) {
                C3513p7 root = l7.c.e;
                if (container != null && root != null) {
                    Intrinsics.checkNotNullParameter(container, "container");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(root, "root");
                    l7.b((ViewGroup) container, root);
                }
            }
            r7A = container;
        }
        if (r7 == null && (l4 = this.c) != null) {
            String TAG = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).b(TAG, "InMobiNative.getPrimaryView called with Non Native View.");
        }
        if (r7A != null) {
            r7A.setNativeStrandAd(this.b);
        }
        if (r7A != null) {
            r7A.setTag("InMobiAdView");
        }
        return r7A;
    }
}
