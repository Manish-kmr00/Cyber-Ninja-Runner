package com.yandex.mobile.ads.common;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.yandex.mobile.ads.impl.b1;
import com.yandex.mobile.ads.impl.c1;
import com.yandex.mobile.ads.impl.d1;
import com.yandex.mobile.ads.impl.e1;
import com.yandex.mobile.ads.impl.m1;
import com.yandex.mobile.ads.impl.mh2;
import com.yandex.mobile.ads.impl.o1;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.t8;
import com.yandex.mobile.ads.impl.v1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/yandex/mobile/ads/common/AdActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class AdActivity extends ComponentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b1 f8323a;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.y, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        b1 b1Var = this.f8323a;
        if (b1Var == null || b1Var.c()) {
            super.onBackPressed();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.onConfigurationChanged(config);
        b1 b1Var = this.f8323a;
        if (b1Var != null) {
            b1Var.a(config);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Long lValueOf;
        t8 t8VarD;
        m1 m1VarA;
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter(this, "activity");
        e1 e1Var = new e1(this);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        Intent intent = getIntent();
        Unit unit = null;
        if (intent == null) {
            m1VarA = null;
        } else {
            Window window = getWindow();
            int i = d1.d;
            d1 d1VarA = d1.a.a();
            try {
                if (intent.hasExtra("data_identifier")) {
                    long longExtra = intent.getLongExtra("data_identifier", -1L);
                    lValueOf = Long.valueOf(longExtra);
                    if (longExtra == -1) {
                        lValueOf = null;
                    }
                } else {
                    lValueOf = null;
                }
            } catch (Exception unused) {
                op0.b(new Object[0]);
            }
            c1 c1VarA = lValueOf != null ? d1VarA.a(lValueOf.longValue()) : null;
            if (c1VarA != null) {
                try {
                    t8VarD = c1VarA.d();
                } catch (Exception unused2) {
                    op0.b(new Object[0]);
                    t8VarD = null;
                }
            } else {
                t8VarD = null;
            }
            v1 v1Var = new v1(this, t8VarD);
            o1 o1VarA = o1.b.a();
            Intrinsics.checkNotNull(window);
            m1VarA = o1VarA.a(this, relativeLayout, v1Var, e1Var, intent, window, c1VarA);
        }
        b1 b1Var = m1VarA != null ? new b1(this, relativeLayout, m1VarA, e1Var, new mh2()) : null;
        this.f8323a = b1Var;
        if (b1Var != null) {
            b1Var.b();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        b1 b1Var = this.f8323a;
        if (b1Var != null) {
            b1Var.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        b1 b1Var = this.f8323a;
        if (b1Var != null) {
            b1Var.d();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        b1 b1Var = this.f8323a;
        if (b1Var != null) {
            b1Var.e();
        }
    }
}
