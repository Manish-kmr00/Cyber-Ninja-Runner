package com.pubmatic.sdk.video.player;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.ui.POBHtmlRendererListener;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class POBEndCardView extends POBVastHTMLView<POBAdDescriptor> implements POBEndCardRendering, POBHtmlRendererListener, View.OnClickListener {
    private com.pubmatic.sdk.video.player.a c;
    private String d;
    private POBAdDescriptor e;
    private View f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBEndCardView.this.c != null) {
                POBEndCardView.this.c.b();
            }
        }
    }

    public POBEndCardView(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(R.color.black));
    }

    @Override // com.pubmatic.sdk.video.player.POBVastHTMLView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public FrameLayout getView() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.pubmatic.sdk.video.player.a aVar;
        if (this.e != null || (aVar = this.c) == null) {
            return;
        }
        aVar.b();
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
        View view = this.f;
        if (view != null) {
            removeView(view);
            this.f = null;
        }
        a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_RENDERING_ERROR));
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewClicked(String str) {
        if (this.c != null) {
            if (str == null || !POBCommonConstants.PLACEHOLDER_CLICK_THROUGH.contentEquals(str)) {
                this.c.a(str, false);
            } else {
                this.c.a(null, false);
            }
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRendered(View view) {
        this.f = view;
        if (getChildCount() != 0 || this.e == null) {
            return;
        }
        com.pubmatic.sdk.video.player.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
        POBEndCardUtil.updateEndCardView(view, this, this.e);
        addView(view);
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRenderingFailed(POBError pOBError) {
        a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_RENDERING_ERROR));
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void render(POBAdDescriptor pOBAdDescriptor) {
        this.e = pOBAdDescriptor;
        if (pOBAdDescriptor == null) {
            a();
            return;
        }
        POBLog.debug("POBEndCardView", POBVideoLogConstants.MSG_END_CARD_FOUND, new Object[0]);
        if (!POBNetworkMonitor.isNetworkAvailable(getContext())) {
            a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_NETWORK_ERROR));
        } else {
            if (renderVastHTMLView(pOBAdDescriptor)) {
                return;
            }
            a(new POBVastError(604, POBVideoLogConstants.MSG_END_CARD_NO_SUPPORTED_RESOURCE));
        }
    }

    void setFSCEnabled(boolean z) {
        setOnClickListener(z ? this : null);
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setLearnMoreTitle(String str) {
        this.d = str;
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setListener(com.pubmatic.sdk.video.player.a aVar) {
        this.c = aVar;
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setOnSkipOptionUpdateListener(POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener) {
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setSkipAfter(int i) {
    }

    private void a() {
        POBLog.debug("POBEndCardView", POBVideoLogConstants.MSG_RENDERING_LEARN_MORE, new Object[0]);
        Resources resources = getResources();
        setBackgroundColor(resources.getColor(R.color.transparent));
        View viewA = b.a(getContext(), com.pubmatic.sdk.video.R.id.pob_learn_more_btn, this.d, resources.getColor(com.pubmatic.sdk.webrendering.R.color.pob_controls_background_color));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, resources.getDimensionPixelOffset(com.pubmatic.sdk.webrendering.R.dimen.pob_control_height));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = resources.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_end_card_learn_more__bottom_margin);
        addView(viewA, layoutParams);
        viewA.setOnClickListener(new a());
    }

    private void a(POBVastError pOBVastError) {
        com.pubmatic.sdk.video.player.a aVar = this.c;
        if (aVar != null) {
            aVar.a(pOBVastError);
        }
        a();
    }
}
