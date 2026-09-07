package com.five_corp.ad.internal.view;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.LINENetworkBridge;

/* JADX INFO: renamed from: com.five_corp.ad.internal.view.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3047e extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1569a = 0;

    public C3047e(Context context, String str) {
        super(context);
        if (Build.VERSION.SDK_INT >= 26) {
            setWebViewClient(new C3046d());
        }
        LINENetworkBridge.webviewLoadData(this, Base64.encodeToString(str.getBytes(), 0), POBCommonConstants.CONTENT_TYPE_HTML, "base64");
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
