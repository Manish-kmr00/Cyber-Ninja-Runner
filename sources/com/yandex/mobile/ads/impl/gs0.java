package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class gs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gi2 f9033a;
    private final cm0 b;

    private static final class a implements ft {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f9034a;
        private final WeakReference<ViewGroup> b;
        private final WeakReference<List<pb2>> c;

        public a(ViewGroup viewGroup, List<pb2> friendlyOverlays, b instreamAdLoadListener) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
            Intrinsics.checkNotNullParameter(instreamAdLoadListener, "instreamAdLoadListener");
            this.f9034a = instreamAdLoadListener;
            this.b = new WeakReference<>(viewGroup);
            this.c = new WeakReference<>(friendlyOverlays);
        }

        @Override // com.yandex.mobile.ads.impl.ft
        public final void a(bt instreamAd) {
            Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
            ViewGroup viewGroup = this.b.get();
            List<pb2> listEmptyList = this.c.get();
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (viewGroup != null) {
                this.f9034a.a(viewGroup, listEmptyList, instreamAd);
            } else {
                this.f9034a.a("Ad was received but there's no view group to display it");
            }
        }

        @Override // com.yandex.mobile.ads.impl.ft
        public final void onInstreamAdFailedToLoad(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f9034a.a(reason);
        }
    }

    public interface b {
        void a(ViewGroup viewGroup, List<pb2> list, bt btVar);

        void a(String str);
    }

    public gs0(Context context, uu1 sdkEnvironmentModule, gi2 vmapRequestConfig, cm0 instreamAdLoadingController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(vmapRequestConfig, "vmapRequestConfig");
        Intrinsics.checkNotNullParameter(instreamAdLoadingController, "instreamAdLoadingController");
        this.f9033a = vmapRequestConfig;
        this.b = instreamAdLoadingController;
    }

    public final void a() {
        this.b.a((ft) null);
    }

    public final void a(ViewGroup adViewGroup, List<pb2> friendlyOverlays, b loadListener) {
        Intrinsics.checkNotNullParameter(adViewGroup, "adViewGroup");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        a aVar = new a(adViewGroup, friendlyOverlays, loadListener);
        cm0 cm0Var = this.b;
        cm0Var.a(aVar);
        cm0Var.a(this.f9033a);
    }
}
