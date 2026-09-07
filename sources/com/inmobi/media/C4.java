package com.inmobi.media;

import android.view.ViewTreeObserver;
import com.inmobi.ads.InMobiAudio;

/* JADX INFO: loaded from: classes5.dex */
public final class C4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiAudio f3040a;

    public C4(InMobiAudio inMobiAudio) {
        this.f3040a = inMobiAudio;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        try {
            InMobiAudio inMobiAudio = this.f3040a;
            inMobiAudio.f = AbstractC3565t3.a(inMobiAudio.getMeasuredWidth());
            InMobiAudio inMobiAudio2 = this.f3040a;
            inMobiAudio2.g = AbstractC3565t3.a(inMobiAudio2.getMeasuredHeight());
            if (this.f3040a.b()) {
                this.f3040a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 1, "InMobiAudio", "InMobiAudio$1.onGlobalLayout() handler threw unexpected error");
        }
    }
}
