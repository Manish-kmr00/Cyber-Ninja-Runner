package com.pubmatic.sdk.video.player;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.ui.POBHtmlRendererListener;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.webrendering.ui.POBHTMLRenderer;
import com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import com.safedk.android.utils.h;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public abstract class POBVastHTMLView<T extends POBAdDescriptor> extends FrameLayout implements POBHtmlRendererListener, POBHTMLViewClient.OnRenderProcessGoneListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBHTMLRenderer f7824a;
    private POBWebView b;

    class a extends POBHTMLRenderer {
        a(POBWebView pOBWebView, POBHTMLViewClient pOBHTMLViewClient) {
            super(pOBWebView, pOBHTMLViewClient);
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLRenderer
        public void loadHTML(String str, String str2, boolean z) {
            if (str == null) {
                PubMaticNetworkBridge.webviewLoadUrl(POBVastHTMLView.this.b, str2);
                return;
            }
            try {
                Formatter formatter = new Formatter(Locale.getDefault());
                formatter.format("<html><head><meta name=\"viewport\" content=\"user-scalable=0, width=device-width, initial-scale=1\"/><style>body{margin:0;padding:0;}div{display:block;width:100%%;height:100%%;}</style></head><body><div align=\"center\">%s</div></body></html>", str);
                String strValueOf = String.valueOf(formatter);
                formatter.close();
                PubMaticNetworkBridge.webviewLoadDataWithBaseURL(POBVastHTMLView.this.b, null, strValueOf, POBCommonConstants.CONTENT_TYPE_HTML, StandardCharsets.UTF_8.name(), null);
            } catch (IllegalFormatException e) {
                notifyError(new POBError(1009, "Unable to render creative, due to " + e.getMessage()));
            }
        }
    }

    interface b {
        void a();

        void a(POBVastError pOBVastError);

        void a(String str);
    }

    public POBVastHTMLView(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    protected POBWebView createWebView(Context context) {
        POBWebView pOBWebViewCreateInstance = POBWebView.createInstance(context);
        if (pOBWebViewCreateInstance != null) {
            pOBWebViewCreateInstance.getSettings().setJavaScriptEnabled(true);
            pOBWebViewCreateInstance.getSettings().setCacheMode(2);
            pOBWebViewCreateInstance.setScrollBarStyle(0);
        }
        return pOBWebViewCreateInstance;
    }

    public void destroy() {
        invalidateRenderer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public void invalidateRenderer() {
        POBHTMLRenderer pOBHTMLRenderer = this.f7824a;
        if (pOBHTMLRenderer != null) {
            pOBHTMLRenderer.destroy();
            this.f7824a = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    protected boolean renderVastHTMLView(POBAdDescriptor pOBAdDescriptor) {
        POBWebView pOBWebViewCreateWebView = createWebView(getContext());
        this.b = pOBWebViewCreateWebView;
        if (pOBWebViewCreateWebView == null) {
            return false;
        }
        POBHTMLViewClient pOBHTMLViewClient = new POBHTMLViewClient(this);
        pOBHTMLViewClient.disableMultipleOnPageFinished(true);
        a aVar = new a(this.b, pOBHTMLViewClient);
        this.f7824a = aVar;
        aVar.setRendererViewListener(this);
        String renderableContent = pOBAdDescriptor.getRenderableContent();
        if (POBUtils.isNullOrEmpty(renderableContent)) {
            return false;
        }
        if (renderableContent.toLowerCase().startsWith("http")) {
            this.f7824a.loadHTML(null, renderableContent, pOBAdDescriptor.isCompanion());
        } else {
            this.f7824a.loadHTML(renderableContent, "", pOBAdDescriptor.isCompanion());
        }
        return true;
    }
}
