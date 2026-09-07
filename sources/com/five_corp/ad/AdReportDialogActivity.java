package com.five_corp.ad;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes13.dex */
public class AdReportDialogActivity extends AppCompatActivity {
    public static final String EXTRA_IS_FULLSCREEN = "is_fullscreen";

    public static void a(final Window window) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(2822);
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.five_corp.ad.AdReportDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                window.getDecorView().setSystemUiVisibility(2822);
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.five_corp.ad", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            EdgeToEdge.enable(this);
        }
        super.onCreate(bundle);
        if (i >= 34) {
            overrideActivityTransition(0, 0, 0);
            overrideActivityTransition(1, 0, 0);
        }
        if (getIntent().getBooleanExtra(EXTRA_IS_FULLSCREEN, true)) {
            Window window = getWindow();
            if (i >= 30) {
                window.setDecorFitsSystemWindows(false);
                window.getDecorView().getWindowInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                window.getInsetsController().setSystemBarsBehavior(2);
            } else {
                window.addFlags(1536);
                a(window);
            }
        }
        if (com.five_corp.ad.internal.ad_report.d.f1315a == null) {
            com.five_corp.ad.internal.ad_report.d.f1315a = new com.five_corp.ad.internal.ad_report.a();
        }
        com.five_corp.ad.internal.ad_report.a aVar = com.five_corp.ad.internal.ad_report.d.f1315a;
        com.five_corp.ad.internal.ad_report.c cVar = aVar.f1314a;
        aVar.f1314a = null;
        aVar.b = null;
        if (cVar != null) {
            cVar.a(this);
            return;
        }
        finish();
        if (i < 34) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (com.five_corp.ad.internal.ad_report.d.f1315a == null) {
            com.five_corp.ad.internal.ad_report.d.f1315a = new com.five_corp.ad.internal.ad_report.a();
        }
        com.five_corp.ad.internal.ad_report.a aVar = com.five_corp.ad.internal.ad_report.d.f1315a;
        com.five_corp.ad.internal.ad_report.c cVar = aVar.f1314a;
        aVar.f1314a = null;
        aVar.b = null;
        if (cVar != null) {
            cVar.a(this);
            return;
        }
        finish();
        if (Build.VERSION.SDK_INT < 34) {
            overridePendingTransition(0, 0);
        }
    }
}
