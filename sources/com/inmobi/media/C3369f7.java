package com.inmobi.media;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3369f7 implements Zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f3313a = new Rect();

    @Override // com.inmobi.media.Zc
    public final boolean a(View rootView, View adView, int i) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(adView, "adView");
        return true;
    }

    @Override // com.inmobi.media.Zc
    public final boolean a(View view, View view2, int i, Object obj) {
        O7 mediaPlayer;
        if (!(obj instanceof C3313b7) || ((C3313b7) obj).t) {
            return false;
        }
        if (((view2 instanceof C3556s8) && (mediaPlayer = ((C3556s8) view2).getMediaPlayer()) != null && 3 != mediaPlayer.f3156a) || view2 == null || !view2.isShown()) {
            return false;
        }
        if ((view != null ? view.getParent() : null) == null || !view2.getGlobalVisibleRect(this.f3313a)) {
            return false;
        }
        long jHeight = ((long) this.f3313a.height()) * ((long) this.f3313a.width());
        long width = ((long) view.getWidth()) * ((long) view.getHeight());
        return width > 0 && ((long) 100) * jHeight >= ((long) i) * width;
    }
}
