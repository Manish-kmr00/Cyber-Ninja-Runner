package com.applovin.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.webkit.internal.AssetHelper;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTcfConsentStatusesListActivity;
import com.applovin.mediation.MaxDebuggerTcfInfoListActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.mediation.MaxDebuggerTestModeNetworkActivity;
import com.applovin.mediation.MaxDebuggerUnifiedFlowActivity;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j3 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l3 f451a;
    private DataSetObserver b;
    private FrameLayout c;
    private ListView d;
    private com.applovin.impl.a e;

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            j3.this.a();
            j3 j3Var = j3.this;
            j3Var.b((Context) j3Var);
        }
    }

    class b implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.c f453a;

        class a implements com.applovin.impl.d.b {
            a() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerUnifiedFlowActivity maxDebuggerUnifiedFlowActivity) {
                maxDebuggerUnifiedFlowActivity.initialize(j3.this.f451a.t());
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.j3$b$b, reason: collision with other inner class name */
        class C0133b implements com.applovin.impl.d.b {
            C0133b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfInfoListActivity maxDebuggerTcfInfoListActivity) {
                maxDebuggerTcfInfoListActivity.initialize(j3.this.f451a.d(), j3.this.f451a.t());
            }
        }

        class c implements com.applovin.impl.d.b {
            c() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfConsentStatusesListActivity maxDebuggerTcfConsentStatusesListActivity) {
                maxDebuggerTcfConsentStatusesListActivity.initialize(j3.this.f451a.d(), j3.this.f451a.t());
            }
        }

        class d implements com.applovin.impl.d.b {
            d() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(j3.this.f451a.f(), false, j3.this.f451a.t());
            }
        }

        class e implements com.applovin.impl.d.b {
            e() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                maxDebuggerTestLiveNetworkActivity.initialize(j3.this.f451a.k(), j3.this.f451a.w(), j3.this.f451a.t());
            }
        }

        class f implements com.applovin.impl.d.b {
            f() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTestModeNetworkActivity maxDebuggerTestModeNetworkActivity) {
                maxDebuggerTestModeNetworkActivity.initialize(j3.this.f451a.v(), j3.this.f451a.t());
            }
        }

        class g implements com.applovin.impl.d.b {
            g() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                maxDebuggerAdUnitsListActivity.initialize(j3.this.f451a.o(), true, j3.this.f451a.t());
            }
        }

        class h implements com.applovin.impl.d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o2 f461a;

            h(o2 o2Var) {
                this.f461a = o2Var;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                maxDebuggerDetailActivity.initialize(((w3) this.f461a).r());
            }
        }

        b(com.applovin.impl.c cVar) {
            this.f453a = cVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            int iB = i2Var.b();
            if (iB == l3.e.APP_INFO.ordinal()) {
                k7.a(o2Var.c(), o2Var.b(), j3.this);
                return;
            }
            if (iB == l3.e.MAX.ordinal()) {
                if (j3.this.f451a.a(o2Var)) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerUnifiedFlowActivity.class, this.f453a, new a());
                    return;
                } else {
                    k7.a(o2Var.c(), o2Var.b(), j3.this);
                    return;
                }
            }
            if (iB == l3.e.PRIVACY.ordinal()) {
                if (i2Var.a() != l3.d.CMP.ordinal()) {
                    if (i2Var.a() == l3.d.NETWORK_CONSENT_STATUSES.ordinal()) {
                        com.applovin.impl.d.a(j3.this, MaxDebuggerTcfConsentStatusesListActivity.class, this.f453a, new c());
                        return;
                    }
                    return;
                } else if (StringUtils.isValidString(j3.this.f451a.t().s0().j())) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerTcfInfoListActivity.class, this.f453a, new C0133b());
                    return;
                } else {
                    k7.a(o2Var.c(), o2Var.b(), j3.this);
                    return;
                }
            }
            if (iB != l3.e.ADS.ordinal()) {
                if ((iB == l3.e.MICRO_SDK_PARTNER_NETWORKS.ordinal() || iB == l3.e.INCOMPLETE_NETWORKS.ordinal() || iB == l3.e.COMPLETED_NETWORKS.ordinal()) && (o2Var instanceof w3)) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerDetailActivity.class, this.f453a, new h(o2Var));
                    return;
                }
                return;
            }
            if (i2Var.a() == l3.b.AD_UNITS.ordinal()) {
                if (j3.this.f451a.f().size() > 0) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerAdUnitsListActivity.class, this.f453a, new d());
                    return;
                } else {
                    k7.a("No live ad units", "Please setup or enable your MAX ad units on https://applovin.com.", j3.this);
                    return;
                }
            }
            if (i2Var.a() == l3.b.SELECT_LIVE_NETWORKS.ordinal()) {
                if (j3.this.f451a.k().size() <= 0 && j3.this.f451a.w().size() <= 0) {
                    k7.a("Complete Integrations", "Please complete integrations in order to access this.", j3.this);
                    return;
                } else if (j3.this.f451a.t().t0().c()) {
                    k7.a("Restart Required", o2Var.b(), j3.this);
                    return;
                } else {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerTestLiveNetworkActivity.class, this.f453a, new e());
                    return;
                }
            }
            if (i2Var.a() != l3.b.SELECT_TEST_MODE_NETWORKS.ordinal()) {
                if (i2Var.a() == l3.b.INITIALIZATION_AD_UNITS.ordinal()) {
                    com.applovin.impl.d.a(j3.this, MaxDebuggerAdUnitsListActivity.class, this.f453a, new g());
                }
            } else if (!j3.this.f451a.t().t0().c()) {
                j3.this.getSdk().t0().a();
                k7.a("Restart Required", o2Var.b(), j3.this);
            } else if (j3.this.f451a.v().size() > 0) {
                com.applovin.impl.d.a(j3.this, MaxDebuggerTestModeNetworkActivity.class, this.f453a, new f());
            } else {
                k7.a("Complete Integrations", "Please complete integrations in order to access this.", j3.this);
            }
        }
    }

    private void c() {
        a();
        com.applovin.impl.a aVar = new com.applovin.impl.a(this, 50, R.attr.progressBarStyleLarge);
        this.e = aVar;
        aVar.setColor(-3355444);
        this.c.addView(this.e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.c.bringChildToFront(this.e);
        this.e.a();
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.f8160a);
        p0.startActivity(p1);
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        l3 l3Var = this.f451a;
        if (l3Var != null) {
            return l3Var.t();
        }
        return null;
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(com.applovin.sdk.R.layout.mediation_debugger_list_view);
        this.c = (FrameLayout) findViewById(R.id.content);
        ListView listView = (ListView) findViewById(com.applovin.sdk.R.id.listView);
        this.d = listView;
        listView.setAdapter((ListAdapter) this.f451a);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.applovin.sdk.R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        l3 l3Var = this.f451a;
        if (l3Var != null) {
            l3Var.unregisterDataSetObserver(this.b);
            this.f451a.a((p2.a) null);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (com.applovin.sdk.R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        l3 l3Var = this.f451a;
        if (l3Var == null || l3Var.y()) {
            return;
        }
        c();
    }

    public void setListAdapter(l3 l3Var, c cVar) {
        DataSetObserver dataSetObserver;
        l3 l3Var2 = this.f451a;
        if (l3Var2 != null && (dataSetObserver = this.b) != null) {
            l3Var2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f451a = l3Var;
        this.b = new a();
        b((Context) this);
        this.f451a.registerDataSetObserver(this.b);
        this.f451a.a(new b(cVar));
    }

    private void b() {
        l3 l3Var = this.f451a;
        if (l3Var == null) {
            return;
        }
        String strP = l3Var.p();
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", strP);
        intent.putExtra("android.intent.extra.TITLE", "Mediation Debugger logs");
        intent.putExtra("android.intent.extra.SUBJECT", "MAX Mediation Debugger logs");
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this, Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.applovin.impl.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
            this.c.removeView(this.e);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        k7.a(this.f451a.i(), this.f451a.h(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context) {
        if (!StringUtils.isValidString(this.f451a.h()) || this.f451a.x()) {
            return;
        }
        this.f451a.b(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.j3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(context);
            }
        });
    }
}
