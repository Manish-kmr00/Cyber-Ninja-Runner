package com.yandex.div.core.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivViewDelegate.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/widget/DivViewDelegate;", "", "buildDrawingCache", "", "autoScale", "", "invalidateDrawable", "Landroid/graphics/drawable/Drawable;", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE, "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "unscheduleDrawable", "who", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivViewDelegate {
    void buildDrawingCache(boolean autoScale);

    Drawable invalidateDrawable(Drawable dr);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onVisibilityChanged(View changedView, int visibility);

    void unscheduleDrawable(Drawable who);
}
