package com.json.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.au;
import com.json.gi;
import com.json.mu;
import com.json.ru;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.safedk.android.utils.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "Landroid/app/Activity;", "Lcom/ironsource/gi;", "Lorg/json/JSONObject;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "a", "Landroid/widget/RelativeLayout$LayoutParams;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onBackPressed", "onDestroy", "onUIReady", "onClosed", "Landroid/widget/RelativeLayout;", "getContainer", "Landroid/widget/RelativeLayout;", "mContainer", "Lcom/ironsource/ru;", "Lcom/ironsource/ru;", "mWebViewWrapper", "Lcom/ironsource/mu;", "Lcom/ironsource/mu;", "mNativeBridge", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class TestSuiteActivity extends Activity implements gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContainer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private ru mWebViewWrapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private mu mNativeBridge;

    private final String a() {
        Bundle extras;
        if (getIntent() == null || getIntent().getExtras() == null || (extras = getIntent().getExtras()) == null) {
            return null;
        }
        return extras.getString("controllerUrl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final JSONObject b() {
        JSONObject jSONObjectJsonObjectInit;
        String strB = new au().b(this);
        if (strB != null) {
            try {
                jSONObjectJsonObjectInit = strB.length() == 0 ? IronSourceNetworkBridge.jsonObjectInit() : IronSourceNetworkBridge.jsonObjectInit(strB);
            } catch (Exception unused) {
                return IronSourceNetworkBridge.jsonObjectInit();
            }
        }
        return jSONObjectJsonObjectInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ru ruVar = this$0.mWebViewWrapper;
        ru ruVar2 = null;
        if (ruVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            ruVar = null;
        }
        if (ruVar.getMAppWebView().getParent() == null) {
            RelativeLayout relativeLayout = this$0.mContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout = null;
            }
            ru ruVar3 = this$0.mWebViewWrapper;
            if (ruVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                ruVar3 = null;
            }
            relativeLayout.removeView(ruVar3.getMLoadingScreenWebView());
            RelativeLayout relativeLayout2 = this$0.mContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout2 = null;
            }
            ru ruVar4 = this$0.mWebViewWrapper;
            if (ruVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                ruVar4 = null;
            }
            relativeLayout2.addView(ruVar4.getMAppWebView(), this$0.c());
            ru ruVar5 = this$0.mWebViewWrapper;
            if (ruVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            } else {
                ruVar2 = ruVar5;
            }
            ruVar2.b();
        }
    }

    private final RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f, me);
        return super.dispatchTouchEvent(me);
    }

    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.json.gi
    public void onClosed() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.TestSuiteActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.a(this.f$0);
            }
        });
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.mContainer = relativeLayout;
        setContentView(relativeLayout, c());
        ru ruVar = new ru(this, this, b(), a());
        this.mWebViewWrapper = ruVar;
        mu muVar = new mu(ruVar);
        this.mNativeBridge = muVar;
        muVar.d();
        RelativeLayout relativeLayout2 = this.mContainer;
        ru ruVar2 = null;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout2 = null;
        }
        ru ruVar3 = this.mWebViewWrapper;
        if (ruVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            ruVar2 = ruVar3;
        }
        relativeLayout2.addView(ruVar2.getMLoadingScreenWebView(), c());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        mu muVar = this.mNativeBridge;
        ru ruVar = null;
        if (muVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNativeBridge");
            muVar = null;
        }
        muVar.a();
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        ru ruVar2 = this.mWebViewWrapper;
        if (ruVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            ruVar = ruVar2;
        }
        ruVar.a();
        super.onDestroy();
    }

    @Override // com.json.gi
    public void onUIReady() {
        runOnUiThread(new Runnable() { // from class: com.ironsource.mediationsdk.testSuite.TestSuiteActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TestSuiteActivity.b(this.f$0);
            }
        });
    }
}
