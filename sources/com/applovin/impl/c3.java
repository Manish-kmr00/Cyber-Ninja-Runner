package com.applovin.impl;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c3 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d3 f377a;
    private ListView b;

    class a implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b3 f378a;

        /* JADX INFO: renamed from: com.applovin.impl.c3$a$a, reason: collision with other inner class name */
        class C0130a implements d.b {
            C0130a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f378a);
            }
        }

        a(b3 b3Var) {
            this.f378a = b3Var;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            if (i2Var.b() != d3.a.TEST_ADS.ordinal()) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
                return;
            }
            com.applovin.impl.sdk.k kVarO = this.f378a.o();
            b3.b bVarY = this.f378a.y();
            if (!c3.this.f377a.a(i2Var)) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
                return;
            }
            if (b3.b.READY == bVarY) {
                d.a(c3.this, MaxDebuggerMultiAdActivity.class, kVarO.e(), new C0130a());
            } else if (b3.b.DISABLED != bVarY) {
                k7.a(o2Var.c(), o2Var.b(), c3.this);
            } else {
                kVarO.t0().a();
                k7.a(o2Var.c(), o2Var.b(), c3.this);
            }
        }
    }

    public c3() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        d3 d3Var = this.f377a;
        if (d3Var != null) {
            return d3Var.h().o();
        }
        return null;
    }

    public void initialize(b3 b3Var) {
        setTitle(b3Var.g());
        d3 d3Var = new d3(b3Var, this);
        this.f377a = d3Var;
        d3Var.a(new a(b3Var));
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.b = listView;
        listView.setAdapter((ListAdapter) this.f377a);
    }

    @Override // com.applovin.impl.k3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f377a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f377a.k();
            this.f377a.c();
        }
    }
}
