package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b1 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c1 f354a;
    private FrameLayout b;
    private ListView c;

    class a implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f355a;

        /* JADX INFO: renamed from: com.applovin.impl.b1$a$a, reason: collision with other inner class name */
        class C0129a implements d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i2 f356a;

            C0129a(i2 i2Var) {
                this.f356a = i2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                maxCreativeDebuggerDisplayedAdActivity.a((p1) b1.this.f354a.d().get(this.f356a.a()), b1.this.f354a.e());
            }
        }

        a(c cVar) {
            this.f355a = cVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            if (i2Var.b() != c1.a.RECENT_ADS.ordinal()) {
                return;
            }
            d.a(b1.this, MaxCreativeDebuggerDisplayedAdActivity.class, this.f355a, new C0129a(i2Var));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Creative Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.b = (FrameLayout) findViewById(android.R.id.content);
        this.c = (ListView) findViewById(R.id.listView);
        b8.a(this.b, com.applovin.impl.sdk.k.D0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c1 c1Var = this.f354a;
        if (c1Var != null) {
            c1Var.a((p2.a) null);
            this.f354a.g();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        c1 c1Var = this.f354a;
        if (c1Var == null) {
            finish();
            return;
        }
        this.c.setAdapter((ListAdapter) c1Var);
        c1 c1Var2 = this.f354a;
        if (c1Var2 != null && !c1Var2.e().z().g()) {
            a(R.string.applovin_creative_debugger_disabled_text);
            return;
        }
        c1 c1Var3 = this.f354a;
        if (c1Var3 == null || !c1Var3.f()) {
            return;
        }
        a(R.string.applovin_creative_debugger_no_ads_text);
    }

    public void a(c1 c1Var, c cVar) {
        this.f354a = c1Var;
        c1Var.a(new a(cVar));
    }

    private void a(int i) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i);
        this.b.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.b.bringChildToFront(textView);
    }
}
