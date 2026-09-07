package com.pubmatic.sdk.webrendering.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.pubmatic.sdk.webrendering.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/pubmatic/sdk/webrendering/ui/POBAdViewContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Lcom/pubmatic/sdk/common/view/POBWebView;", "adView", "<init>", "(Landroid/content/Context;Lcom/pubmatic/sdk/common/view/POBWebView;)V", "", "isExpanded", "", "resizeDsaIcon", "(Z)V", "isFullScreen", "isVideo", "Landroid/view/View$OnClickListener;", "clickListener", "addDsaIcon", "(ZZLandroid/view/View$OnClickListener;)V", "a", "Landroid/content/Context;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/pubmatic/sdk/common/view/POBWebView;", "getAdView", "()Lcom/pubmatic/sdk/common/view/POBWebView;", "Landroid/widget/ImageButton;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/widget/ImageButton;", "getDsaIcon", "()Landroid/widget/ImageButton;", "setDsaIcon", "(Landroid/widget/ImageButton;)V", "dsaIcon", "webrendering_release"}, k = 1, mv = {1, 7, 1})
public final class POBAdViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final POBWebView adView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private ImageButton dsaIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public POBAdViewContainer(Context context, POBWebView adView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.context = context;
        this.adView = adView;
        addView(adView);
    }

    public final void addDsaIcon(boolean isFullScreen, boolean isVideo, View.OnClickListener clickListener) {
        ImageButton imageButtonCreateDsaInfoIconButton = POBUIUtil.createDsaInfoIconButton(this.context, R.id.pob_dsa_info_btn, com.pubmatic.sdk.common.R.drawable.pob_dsa_info_icon, isFullScreen, isFullScreen && !isVideo);
        this.dsaIcon = imageButtonCreateDsaInfoIconButton;
        if (imageButtonCreateDsaInfoIconButton != null) {
            imageButtonCreateDsaInfoIconButton.setOnClickListener(clickListener);
        }
        addView(this.dsaIcon);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final POBWebView getAdView() {
        return this.adView;
    }

    public final ImageButton getDsaIcon() {
        return this.dsaIcon;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void resizeDsaIcon(boolean isExpanded) {
        ImageButton imageButton = this.dsaIcon;
        if (imageButton != null) {
            POBUIUtil.resizeDsaInfoBtn(this.context, imageButton, isExpanded);
        }
    }

    public final void setDsaIcon(ImageButton imageButton) {
        this.dsaIcon = imageButton;
    }
}
