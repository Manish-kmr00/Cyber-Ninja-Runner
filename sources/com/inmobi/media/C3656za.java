package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3656za extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3496a;

    public C3656za(Ba ba) {
        this.f3496a = ba;
    }

    public static final void a(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.confirm();
    }

    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void b(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.confirm();
    }

    public static final void c(JsResult result, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.cancel();
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage cm) {
        Intrinsics.checkNotNullParameter(cm, "cm");
        String str = cm.message() + " -- From line " + cm.lineNumber() + " of " + cm.sourceId();
        L4 l4 = this.f3496a.i;
        if (l4 == null) {
            return true;
        }
        String str2 = Ba.O0;
        ((M4) l4).c(str2, P5.a(str2, "access$getTAG$cp(...)", "Console message:", str));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        a();
        super.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        L4 l4 = this.f3496a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "jsAlert called with: " + message + url);
        }
        if (!Ba.a(this.f3496a, result)) {
            return true;
        }
        Activity fullScreenActivity = this.f3496a.getFullScreenActivity();
        if (fullScreenActivity != null) {
            new AlertDialog.Builder(fullScreenActivity).setMessage(message).setTitle(url).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3656za.a(result, dialogInterface, i);
                }
            }).setCancelable(false).create().show();
            return true;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(result, "result");
        L4 l4 = this.f3496a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "jsConfirm called with: " + message + url);
        }
        if (!Ba.a(this.f3496a, result)) {
            return true;
        }
        if (this.f3496a.getFullScreenActivity() != null) {
            new AlertDialog.Builder(this.f3496a.getFullScreenActivity()).setMessage(message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3656za.b(result, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3656za.c(result, dialogInterface, i);
                }
            }).create().show();
            return true;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(result, "result");
        L4 l4 = this.f3496a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "jsPrompt called with: " + message + url);
        }
        if (!Ba.a(this.f3496a, result)) {
            return true;
        }
        if (this.f3496a.getFullScreenActivity() != null) {
            return false;
        }
        result.cancel();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        L4 l4 = this.f3496a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).c(str, "webview progress changed - " + i);
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.f3496a.l.get() != null) {
            Ba ba = this.f3496a;
            ba.N = view;
            ba.O = callback;
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        Logger.d("InMobi|SafeDK: Execution> Lcom/inmobi/media/za$$ExternalSyntheticLambda0;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                        CreativeInfoManager.onViewTouched(com.safedk.android.utils.h.i, view2, motionEvent);
                        return safedk_za$$ExternalSyntheticLambda0_onTouch_aa6d44cf83c4704acfe71f4758f47795(view2, motionEvent);
                    }

                    public boolean safedk_za$$ExternalSyntheticLambda0_onTouch_aa6d44cf83c4704acfe71f4758f47795(View p0, MotionEvent p1) {
                        return C3656za.a(p0, p1);
                    }
                });
            }
            Activity activity = (Activity) this.f3496a.l.get();
            FrameLayout frameLayout = activity != null ? (FrameLayout) activity.findViewById(R.id.content) : null;
            View view2 = this.f3496a.N;
            if (view2 != null) {
                view2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (frameLayout != null) {
                frameLayout.addView(this.f3496a.N, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            }
            View view3 = this.f3496a.N;
            if (view3 != null) {
                view3.requestFocus();
            }
            final Ba ba2 = this.f3496a;
            View view4 = ba2.N;
            View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view5, int i, KeyEvent keyEvent) {
                    return C3656za.a(ba2, this, view5, i, keyEvent);
                }
            };
            if (view4 != null) {
                view4.setOnKeyListener(onKeyListener);
            }
            if (view4 != null) {
                view4.setFocusable(true);
            }
            if (view4 != null) {
                view4.setFocusableInTouchMode(true);
            }
            if (view4 != null) {
                view4.requestFocus();
            }
        }
    }

    public static final void b(GeolocationPermissions.Callback callback, String origin, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(origin, "$origin");
        callback.invoke(origin, false, false);
    }

    public static final boolean a(Ba this$0, C3656za this$1, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
            return false;
        }
        L4 l4 = this$0.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "Back pressed when HTML5 video is playing.");
        }
        this$1.a();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.f3496a.l.get() != null) {
            new AlertDialog.Builder((Context) this.f3496a.l.get()).setTitle("Location Permission").setMessage("Allow location access").setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3656za.a(callback, origin, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.inmobi.media.za$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3656za.b(callback, origin, dialogInterface, i);
                }
            }).create().show();
        }
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    public final void a() {
        Ba ba = this.f3496a;
        if (ba.N == null) {
            return;
        }
        WebChromeClient.CustomViewCallback customViewCallback = ba.O;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        Ba ba2 = this.f3496a;
        ba2.O = null;
        View view = ba2.N;
        if ((view != null ? view.getParent() : null) != null) {
            View view2 = this.f3496a.N;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.f3496a.N);
            }
            this.f3496a.N = null;
        }
    }

    public static final void a(GeolocationPermissions.Callback callback, String origin, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(origin, "$origin");
        callback.invoke(origin, true, false);
    }
}
