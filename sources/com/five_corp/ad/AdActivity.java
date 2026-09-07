package com.five_corp.ad;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes13.dex */
public class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1241a;

    public interface Callback {
        void onAdActivityBackPressed();

        void onAdActivityDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("com.five_corp.ad", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.onAdActivityBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
            window.getDecorView().getWindowInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            window.getInsetsController().setSystemBarsBehavior(2);
        } else {
            window.addFlags(1536);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(2822);
            decorView.setOnSystemUiVisibilityChangeListener(new a(window));
        }
        if (com.five_corp.ad.internal.fullscreen.b.f1376a == null) {
            com.five_corp.ad.internal.fullscreen.b.f1376a = new com.five_corp.ad.internal.fullscreen.a();
        }
        com.five_corp.ad.internal.fullscreen.a aVar = com.five_corp.ad.internal.fullscreen.b.f1376a;
        f fVar = aVar.b;
        aVar.b = null;
        if (fVar == null) {
            finish();
            return;
        }
        this.f1241a = fVar;
        fVar.o.f();
        synchronized (fVar.m) {
            i = fVar.u;
        }
        if (i == 1) {
            com.five_corp.ad.internal.context.l lVar = fVar.l;
            com.five_corp.ad.internal.ad.fullscreen.j jVar = lVar.e.c;
            if (jVar != null) {
                com.five_corp.ad.internal.fullscreen.c cVar = new com.five_corp.ad.internal.fullscreen.c(this, fVar.h, lVar, jVar, fVar, fVar.b.s, fVar.x, fVar.i, fVar.w);
                fVar.v = cVar;
                cVar.c();
                com.five_corp.ad.internal.viewability.a aVar2 = cVar.j;
                FrameLayout frameLayout = cVar.g;
                aVar2.f = frameLayout;
                cVar.f1377a.setContentView(frameLayout);
                return;
            }
        }
        finish();
        fVar.a(0, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.b4, null, null, null));
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.onAdActivityDestroy();
        }
    }
}
