package io.bidmachine.iab.mraid;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.json.b9;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.w;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.iab.utils.VisibilityTracker;

/* JADX INFO: loaded from: classes9.dex */
public class MraidWebView extends WebView {
    private static final b g = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebViewGestureDetector f12216a;
    private final VisibilityTracker b;
    private MraidWebViewListener c;
    private boolean d;
    private boolean e;
    private boolean f;

    public interface MraidWebViewListener {
        void onViewableChanged(boolean viewable);
    }

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            MraidWebView.this.f12216a.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if ((action != 0 && action != 1) || view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    private static final class b extends WebChromeClient {
        private b() {
        }

        private boolean a(JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null || consoleMessage.message() == null) {
                return false;
            }
            if (MraidLog.canSendDLog() && !consoleMessage.message().contains("Uncaught ReferenceError")) {
                MraidLog.d("JS console", String.format("%s%s:%d", consoleMessage.message(), consoleMessage.sourceId() == null ? "" : " at " + consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber())), new Object[0]);
            }
            if (!MraidLog.canSendELog() || !consoleMessage.message().contains("AppodealAlert")) {
                return true;
            }
            MraidLog.e("Appodeal", consoleMessage.message().replace("AppodealAlert:", ""), new Object[0]);
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MraidLog.d("JS alert", str2, new Object[0]);
            return a(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            MraidLog.d("JS confirm", str2, new Object[0]);
            return a(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            MraidLog.d("JS prompt", str2, new Object[0]);
            return a(jsPromptResult);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public MraidWebView(Context context) {
        super(context);
        this.d = false;
        this.e = false;
        this.f = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setScrollBarStyle(33554432);
        setFocusableInTouchMode(false);
        this.f12216a = new WebViewGestureDetector(context);
        setOnTouchListener(new a());
        setWebChromeClient(g);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setBackgroundColor(0);
        this.b = new VisibilityTracker(context, this, new VisibilityTracker.Callback() { // from class: io.bidmachine.iab.mraid.MraidWebView$$ExternalSyntheticLambda0
            @Override // io.bidmachine.iab.utils.VisibilityTracker.Callback
            public final void onVisibilityChanged(boolean z) {
                this.f$0.a(z);
            }
        });
    }

    private void b() {
        MraidLog.d(w.f6664a, b9.h.u0, new Object[0]);
        try {
            onResume();
        } catch (Throwable th) {
            MraidLog.e(w.f6664a, th);
        }
        this.e = false;
        c();
    }

    private void c() {
        boolean z = !this.e && this.b.isVisible();
        if (z != this.d) {
            this.d = z;
            MraidWebViewListener mraidWebViewListener = this.c;
            if (mraidWebViewListener != null) {
                mraidWebViewListener.onViewableChanged(z);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f = true;
        try {
            reset();
            removeAllViews();
            this.b.release();
            super.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    public void injectJs(String js) {
        if (isDestroyed()) {
            MraidLog.d(w.f6664a, "can't evaluating js: WebView is destroyed", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(js)) {
            MraidLog.d(w.f6664a, "can't evaluating js: js is empty", new Object[0]);
            return;
        }
        try {
            MraidLog.d(w.f6664a, "evaluating js: %s", js);
            evaluateJavascript(js, new ValueCallback() { // from class: io.bidmachine.iab.mraid.MraidWebView$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    MraidWebView.a((String) obj);
                }
            });
        } catch (Throwable th) {
            MraidLog.e(w.f6664a, th.getMessage(), new Object[0]);
            MraidLog.d(w.f6664a, "loading url: %s", js);
            BidMachineNetworkBridge.webviewLoadUrl(this, "javascript:" + js);
        }
    }

    public boolean isDestroyed() {
        return this.f;
    }

    public boolean isViewable() {
        return this.d;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void onPageFinished() {
        this.b.start();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            b();
        } else {
            a();
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public void reset() {
        stopLoading();
        BidMachineNetworkBridge.webviewLoadUrl(this, "");
        a();
    }

    public void resetClicked() {
        this.f12216a.resetClick();
    }

    public void setListener(MraidWebViewListener listener) {
        this.c = listener;
    }

    public boolean wasClicked() {
        return this.f12216a.isClicked();
    }

    private void a() {
        MraidLog.d(w.f6664a, b9.h.t0, new Object[0]);
        try {
            onPause();
        } catch (Throwable th) {
            MraidLog.e(w.f6664a, th);
        }
        this.e = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str) {
        MraidLog.d(w.f6664a, "evaluate js complete: %s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        c();
    }
}
