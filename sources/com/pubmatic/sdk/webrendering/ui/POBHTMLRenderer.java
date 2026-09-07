package com.pubmatic.sdk.webrendering.ui;

import android.os.Trace;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.ui.POBHtmlRendererListener;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.view.POBWebView;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class POBHTMLRenderer implements POBHTMLViewClient.HTMLViewClientListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBHtmlRendererListener f7932a;
    private POBWebView b;
    private boolean c;
    private final Formatter d;
    private long e = 15;
    private POBTimeoutHandler f;

    class a implements POBTimeoutHandler.POBTimeoutHandlerListener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            POBHTMLRenderer.this.notifyError(new POBError(1009, String.format("Unable to render creative within %s seconds.", Long.valueOf(POBHTMLRenderer.this.e))));
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            POBHTMLRenderer.this.invalidateWebView();
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0 && action != 1) {
                return false;
            }
            POBHTMLRenderer.this.c = true;
            return false;
        }
    }

    public POBHTMLRenderer(POBWebView pOBWebView, POBHTMLViewClient pOBHTMLViewClient) {
        this.b = pOBWebView;
        pOBWebView.setWebViewClient(pOBHTMLViewClient);
        this.b.setOnTouchListener(new c());
        pOBHTMLViewClient.setHTMLClientListener(this);
        this.d = new Formatter(Locale.getDefault());
    }

    private void b() {
        if (this.f == null) {
            POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new a());
            this.f = pOBTimeoutHandler;
            pOBTimeoutHandler.start(this.e * 1000);
        }
    }

    public void destroy() {
        a();
        POBWebView pOBWebView = this.b;
        if (pOBWebView != null) {
            pOBWebView.postDelayed(new b(), 1000L);
        }
    }

    public void invalidateWebView() {
        POBWebView pOBWebView = this.b;
        if (pOBWebView != null) {
            pOBWebView.setWebViewClient(null);
            this.b.stopLoading();
            PubMaticNetworkBridge.webviewLoadUrl(this.b, AndroidWebViewClient.BLANK_PAGE);
            this.b.clearHistory();
            this.b.destroy();
            this.b = null;
        }
    }

    public boolean isUserInteracted() {
        return this.c;
    }

    public void loadHTML(String str, String str2, boolean z) {
        if (this.b != null) {
            if (str == null) {
                if (str2 != null) {
                    Trace.endSection();
                    Trace.beginSection("POB Rendering");
                    PubMaticNetworkBridge.webviewLoadUrl(this.b, str2);
                    return;
                }
                return;
            }
            try {
                if (z) {
                    this.d.format("<html><head><meta name=\"viewport\" content=\"user-scalable=0, width=device-width, initial-scale=1\"/><style>body{margin:0;padding:0;}div{display:block;width:100%%;height:100%%;}</style></head><body><div align=\"center\">%s</div></body></html>", str);
                } else {
                    this.d.format(POBCommonConstants.RICHMEDIA_FORMAT, str);
                }
                String strValueOf = String.valueOf(this.d);
                this.d.close();
                Trace.endSection();
                Trace.beginSection("POB Rendering");
                PubMaticNetworkBridge.webviewLoadDataWithBaseURL(this.b, str2, strValueOf, POBCommonConstants.CONTENT_TYPE_HTML, StandardCharsets.UTF_8.name(), null);
                if (z) {
                    return;
                }
                b();
            } catch (OutOfMemoryError | IllegalFormatException e) {
                notifyError(new POBError(1009, "Unable to render creative, due to " + e.getMessage()));
            }
        }
    }

    protected void notifyError(POBError pOBError) {
        a();
        POBHtmlRendererListener pOBHtmlRendererListener = this.f7932a;
        if (pOBHtmlRendererListener != null) {
            pOBHtmlRendererListener.onViewRenderingFailed(pOBError);
        }
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient.HTMLViewClientListener
    public void onPageFinished(WebView webView) {
        a();
        POBHtmlRendererListener pOBHtmlRendererListener = this.f7932a;
        if (pOBHtmlRendererListener != null) {
            pOBHtmlRendererListener.onViewRendered(webView);
        }
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient.HTMLViewClientListener
    public void onReceivedError(POBError pOBError) {
        notifyError(pOBError);
    }

    public void setRendererViewListener(POBHtmlRendererListener pOBHtmlRendererListener) {
        this.f7932a = pOBHtmlRendererListener;
    }

    public void setRenderingTimeout(int i) {
        this.e = i;
    }

    public void setUserInteracted(boolean z) {
        this.c = z;
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient.HTMLViewClientListener
    public boolean shouldOverrideUrlLoading(String str) {
        POBHtmlRendererListener pOBHtmlRendererListener = this.f7932a;
        if (pOBHtmlRendererListener == null || !this.c) {
            return false;
        }
        this.c = false;
        pOBHtmlRendererListener.onViewClicked(str);
        return true;
    }

    private void a() {
        POBTimeoutHandler pOBTimeoutHandler = this.f;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
            this.f = null;
        }
    }
}
