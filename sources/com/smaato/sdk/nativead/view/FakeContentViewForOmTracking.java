package com.smaato.sdk.nativead.view;

import android.view.MotionEvent;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.ui.AdContentView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class FakeContentViewForOmTracking extends AdContentView {
    String omTrackerUrl;
    View viewRegisteredForImpression;

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void destroy() {
    }

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

    public FakeContentViewForOmTracking(View view, String str) {
        super(view.getContext());
        this.viewRegisteredForImpression = view;
        this.omTrackerUrl = str;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForVisibilityTracking() {
        return this.viewRegisteredForImpression;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForOmTracking() {
        return this.viewRegisteredForImpression;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap() {
        ViewabilityVerificationResource viewabilityVerificationResource = new ViewabilityVerificationResource("iabtechlab.com-omid", this.omTrackerUrl, "", "iabtechlab-smaato", true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewabilityVerificationResource);
        HashMap map = new HashMap();
        map.put(CampaignEx.KEY_OMID, arrayList);
        return map;
    }
}
