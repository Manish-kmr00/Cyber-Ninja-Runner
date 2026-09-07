package com.inmobi.media;

import android.view.ViewTreeObserver;
import com.inmobi.ads.InMobiBanner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class G4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiBanner f3078a;

    public G4(InMobiBanner inMobiBanner) {
        this.f3078a = inMobiBanner;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        L4 l4P;
        try {
            InMobiBanner inMobiBanner = this.f3078a;
            inMobiBanner.i = AbstractC3565t3.a(inMobiBanner.getMeasuredWidth());
            InMobiBanner inMobiBanner2 = this.f3078a;
            inMobiBanner2.j = AbstractC3565t3.a(inMobiBanner2.getMeasuredHeight());
            if (this.f3078a.b()) {
                this.f3078a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        } catch (Exception e) {
            B1 mAdManager = this.f3078a.getMAdManager();
            if (mAdManager == null || (l4P = mAdManager.p()) == null) {
                return;
            }
            String strAccess$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(strAccess$getTAG$cp, "access$getTAG$cp(...)");
            ((M4) l4P).a(strAccess$getTAG$cp, "InMobiBanner$1.onGlobalLayout() handler threw unexpected error: ", e);
        }
    }
}
