package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.ad, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC3304ad implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3270a;
    public final ArrayList b;
    public final ArrayList c;
    public final WeakReference d;

    public RunnableC3304ad(fd visibilityTracker, AtomicBoolean isPaused) {
        Intrinsics.checkNotNullParameter(visibilityTracker, "visibilityTracker");
        Intrinsics.checkNotNullParameter(isPaused, "isPaused");
        this.f3270a = isPaused;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new WeakReference(visibilityTracker);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x018d  */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3270a.get()) {
            return;
        }
        fd fdVar = (fd) this.d.get();
        if (fdVar != null) {
            fdVar.m = false;
            for (Map.Entry entry : fdVar.f3319a.entrySet()) {
                View view = (View) entry.getKey();
                cd cdVar = (cd) entry.getValue();
                int i = cdVar.f3287a;
                View view2 = cdVar.c;
                Object obj = cdVar.d;
                byte b = fdVar.d;
                boolean z = true;
                if (b == 1) {
                    Zc zc = fdVar.b;
                    if (zc.a(view2, view, i, obj) && zc.a(view, view, i)) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                } else if (b == 2) {
                    Zc zc2 = fdVar.b;
                    Intrinsics.checkNotNull(zc2, "null cannot be cast to non-null type com.inmobi.ads.viewability.inmobi.HtmlPollingVisibilityTracker.HtmlVisibilityChecker");
                    C3338d4 c3338d4 = (C3338d4) ((InterfaceC3408i4) zc2);
                    boolean zA = c3338d4.a(view2, view, i, obj);
                    boolean zA2 = c3338d4.a(view, view, i);
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (!(view instanceof Ba)) {
                        z = false;
                        break;
                    }
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        z = false;
                        break;
                    }
                    Ba ba = (Ba) view;
                    int[] iArr = new int[2];
                    ba.getLocationInWindow(iArr);
                    int[] viewableFrameArray = ba.getViewableFrameArray();
                    int i2 = iArr[0] + (viewableFrameArray != null ? viewableFrameArray[0] : 0);
                    int i3 = iArr[1] + (viewableFrameArray != null ? viewableFrameArray[1] : 0);
                    if (!rect.intersect(new Rect(i2, i3, i2 + (viewableFrameArray != null ? viewableFrameArray[2] : 0), (viewableFrameArray != null ? viewableFrameArray[3] : 0) + i3))) {
                        z = false;
                        break;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ba.getWidth(), ba.getHeight(), Bitmap.Config.ARGB_8888);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, new Paint());
                    ba.draw(canvas);
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, AbstractC3565t3.a(ba.getWidth()), AbstractC3565t3.a(ba.getHeight()), true);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
                    int[] viewableFrameArray2 = ba.getViewableFrameArray();
                    int iMin = Math.min(bitmapCreateScaledBitmap.getWidth(), viewableFrameArray2 != null ? viewableFrameArray2[0] : 0);
                    int iMin2 = Math.min(bitmapCreateScaledBitmap.getHeight(), viewableFrameArray2 != null ? viewableFrameArray2[1] : 0);
                    int iMin3 = Math.min(viewableFrameArray2 != null ? viewableFrameArray2[2] : 0, bitmapCreateScaledBitmap.getWidth() - iMin);
                    int iMin4 = Math.min(viewableFrameArray2 != null ? viewableFrameArray2[3] : 0, bitmapCreateScaledBitmap.getHeight() - iMin2);
                    Bitmap bitmapCreateBitmap2 = (iMin3 <= 0 || iMin4 <= 0) ? null : Bitmap.createBitmap(bitmapCreateScaledBitmap, iMin, iMin2, iMin3, iMin4);
                    if (bitmapCreateBitmap2 == null) {
                        z = false;
                        break;
                    }
                    int height = bitmapCreateBitmap2.getHeight() * bitmapCreateBitmap2.getWidth();
                    int[] iArr2 = new int[height];
                    bitmapCreateBitmap2.getPixels(iArr2, 0, bitmapCreateBitmap2.getWidth(), 0, 0, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight());
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i4 >= height) {
                            z = false;
                            break;
                        }
                        int i6 = iArr2[i4];
                        if (i6 > -16777216 && i6 < 0 && (i5 = i5 + 1) >= ba.getMinimumPixelsPainted()) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (zA && zA2 && z) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                } else {
                    Zc zc3 = fdVar.b;
                    if (zc3.a(view2, view, i, obj) && zc3.a(view, view, i)) {
                        this.b.add(view);
                    } else {
                        this.c.add(view);
                    }
                }
            }
        }
        bd bdVar = fdVar != null ? fdVar.j : null;
        this.b.size();
        this.c.size();
        if (bdVar != null) {
            bdVar.a(this.b, this.c);
        }
        this.b.clear();
        this.c.clear();
        if (fdVar != null) {
            fdVar.d();
        }
    }
}
