package com.pubmatic.sdk.video.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.ui.POBHtmlRendererListener;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.video.vastmodels.POBIcon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class POBIconView extends POBVastHTMLView<POBIcon> implements POBHtmlRendererListener {
    private POBVastHTMLView.b c;
    private View d;

    public POBIconView(Context context) {
        super(context);
    }

    void a(POBIcon pOBIcon) {
        POBVastHTMLView.b bVar;
        if (pOBIcon != null) {
            if (!POBNetworkMonitor.isNetworkAvailable(getContext())) {
                POBLog.debug("POBIconView", POBVideoLogConstants.MSG_RENDERING_ICON_FAILURE_NO_NETWORK, new Object[0]);
            } else {
                if (renderVastHTMLView(pOBIcon) || (bVar = this.c) == null) {
                    return;
                }
                bVar.a(new POBVastError(900, POBVideoLogConstants.MSG_ICON_RENDERING_FAILURE));
            }
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVastHTMLView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.video.player.POBVastHTMLView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener, com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient.OnRenderProcessGoneListener
    public void onRenderProcessGone() {
        removeAllViews();
        this.d = null;
        POBVastHTMLView.b bVar = this.c;
        if (bVar != null) {
            bVar.a(new POBVastError(900, POBVideoLogConstants.MSG_RENDERING_ICON_FAILURE));
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewClicked(String str) {
        if (this.c == null || str == null) {
            return;
        }
        if (POBCommonConstants.PLACEHOLDER_CLICK_THROUGH.contentEquals(str)) {
            this.c.a((String) null);
        } else {
            this.c.a(str);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRendered(View view) {
        this.d = view;
        if (getChildCount() == 0) {
            POBVastHTMLView.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(view, layoutParams);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRenderingFailed(POBError pOBError) {
        POBVastHTMLView.b bVar = this.c;
        if (bVar != null) {
            bVar.a(new POBVastError(900, POBVideoLogConstants.MSG_RENDERING_ICON_FAILURE));
        }
    }

    void setListener(POBVastHTMLView.b bVar) {
        this.c = bVar;
    }
}
