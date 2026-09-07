package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR*\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048\u0000@AX\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/w9;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "event", "", "a", "(Landroid/view/MotionEvent;)Z", "e", "onSingleTapUp", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()V", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "<set-?>", "Z", "()Z", "setHasClick$ChartboostMonetization_9_8_3_productionRelease", "(Z)V", "hasClick", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class w9 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final GestureDetector gestureDetector;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean hasClick;

    public w9(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.gestureDetector = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.hasClick = true;
        return super.onSingleTapUp(e);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getHasClick() {
        return this.hasClick;
    }

    public final boolean a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.gestureDetector.onTouchEvent(event);
    }

    public final void b() {
        this.hasClick = false;
    }
}
