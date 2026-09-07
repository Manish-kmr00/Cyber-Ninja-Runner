package com.smaato.sdk.core.csm;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.ui.AdContentView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class CsmImageAdContentView extends AdContentView {
    private View csmView;

    @Override // com.smaato.sdk.core.ui.AdContentView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void showProgressIndicator(boolean z) {
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void startShowingView() {
    }

    public CsmImageAdContentView(Context context, View view) {
        super(context);
        this.csmView = view;
        addView(view);
    }

    public CsmImageAdContentView(Context context) {
        super(context);
        this.csmView = null;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForVisibilityTracking() {
        return this.csmView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForOmTracking() {
        return this.csmView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap() {
        return new HashMap();
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void destroy() {
        this.csmView = null;
    }
}
