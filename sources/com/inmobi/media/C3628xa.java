package com.inmobi.media;

import androidx.webkit.Profile;
import com.json.nu;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3628xa implements InterfaceC3519q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3478a;

    public C3628xa(Ba ba) {
        this.f3478a = ba;
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a() {
        L4 l4 = this.f3478a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "onAdScreenDisplayFailed");
        }
        this.f3478a.getListener().c();
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void b(Object obj) {
        L4 l4 = this.f3478a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, nu.m);
        }
        Ba ba = this.f3478a;
        if (ba.b == 0) {
            ba.setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
            Ba originalRenderView = this.f3478a.getOriginalRenderView();
            if (originalRenderView != null) {
                originalRenderView.setAndUpdateViewState(Profile.DEFAULT_PROFILE_NAME);
            }
        } else if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, ba.getViewState())) {
            this.f3478a.setAndUpdateViewState("Hidden");
        }
        this.f3478a.v();
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a(Object obj) {
        L4 l4 = this.f3478a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "onAdScreenDisplayed");
        }
        Ba ba = this.f3478a;
        if (ba.b == 0) {
            if (ba.getOriginalRenderView() != null) {
                Ba originalRenderView = this.f3478a.getOriginalRenderView();
                if (originalRenderView != null) {
                    originalRenderView.setAndUpdateViewState("Expanded");
                }
            } else {
                this.f3478a.setAndUpdateViewState("Expanded");
            }
            this.f3478a.L = false;
        }
        this.f3478a.getListener().e(this.f3478a);
    }
}
