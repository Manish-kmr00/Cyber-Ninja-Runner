package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public interface bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8528a = a.f8529a;

    View.OnClickListener a(ig<?> igVar, rr0 rr0Var, j3 j3Var, c71 c71Var, po1 po1Var, ec0 ec0Var);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f8529a = new a();
        private static final bp b = new bp() { // from class: com.yandex.mobile.ads.impl.bp$a$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.bp
            public final View.OnClickListener a(ig igVar, rr0 rr0Var, j3 j3Var, c71 c71Var, po1 po1Var, ec0 ec0Var) {
                return bp.a.a(igVar, rr0Var, j3Var, c71Var, po1Var, ec0Var);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final View.OnClickListener a(ig asset, rr0 rr0Var, j3 adClickable, c71 viewAdapter, po1 renderedTimer, ec0 forceImpressionTrackingListener) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            Intrinsics.checkNotNullParameter(adClickable, "adClickable");
            Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
            Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
            Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
            return new k51(asset, rr0Var, adClickable, viewAdapter, renderedTimer, forceImpressionTrackingListener);
        }

        private a() {
        }

        public static bp a() {
            return b;
        }
    }
}
