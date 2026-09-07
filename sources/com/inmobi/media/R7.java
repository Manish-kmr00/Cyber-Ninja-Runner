package com.inmobi.media;

import android.content.Context;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class R7 extends C3540r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f3182a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R7(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.inmobi.media.C3540r7, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final C3313b7 getNativeStrandAd() {
        WeakReference weakReference = this.f3182a;
        if (weakReference != null) {
            return (C3313b7) weakReference.get();
        }
        return null;
    }

    public final void setNativeStrandAd(C3313b7 c3313b7) {
        this.f3182a = new WeakReference(c3313b7);
    }
}
