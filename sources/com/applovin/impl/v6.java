package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerCmpNetworksListActivity;
import com.applovin.mediation.MaxDebuggerTcfStringActivity;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v6 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f725a;
    private p2 b;
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private final List g = new ArrayList();

    class a extends p2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return e.values().length;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? v6.this.c() : v6.this.a();
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? d.values().length : c.values().length;
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return i == e.IAB_TCF_PARAMETERS.ordinal() ? new t4("IAB TCF Parameters") : new t4("CMP CONFIGURATION");
        }
    }

    class b implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w6 f726a;
        final /* synthetic */ com.applovin.impl.sdk.k b;

        class a implements com.applovin.impl.d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f727a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f727a = str;
                this.b = str2;
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerTcfStringActivity maxDebuggerTcfStringActivity) {
                maxDebuggerTcfStringActivity.initialize(this.f727a, this.b, b.this.b);
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.v6$b$b, reason: collision with other inner class name */
        class C0145b implements com.applovin.impl.d.b {
            C0145b() {
            }

            @Override // com.applovin.impl.d.b
            public void a(MaxDebuggerCmpNetworksListActivity maxDebuggerCmpNetworksListActivity) {
                maxDebuggerCmpNetworksListActivity.initialize(v6.this.e, v6.this.f, v6.this.c, v6.this.d, v6.this.g, b.this.b);
            }
        }

        b(w6 w6Var, com.applovin.impl.sdk.k kVar) {
            this.f726a = w6Var;
            this.b = kVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            String strA;
            String strC;
            if (i2Var.b() != e.IAB_TCF_PARAMETERS.ordinal()) {
                if (i2Var.a() == c.CONFIGURED_NETWORKS.ordinal()) {
                    com.applovin.impl.d.a(v6.this, MaxDebuggerCmpNetworksListActivity.class, this.b.e(), new C0145b());
                    return;
                } else {
                    k7.a(o2Var.c(), o2Var.b(), v6.this);
                    return;
                }
            }
            if (i2Var.a() == d.TC_STRING.ordinal()) {
                strA = x4.w.a();
                strC = this.f726a.j();
            } else {
                strA = x4.x.a();
                strC = this.f726a.c();
            }
            com.applovin.impl.d.a(v6.this, MaxDebuggerTcfStringActivity.class, this.b.e(), new a(strA, strC));
        }
    }

    private enum c {
        CMP_SDK_ID,
        CMP_SDK_VERSION,
        INSTRUCTIONS,
        CONFIGURED_NETWORKS
    }

    private enum d {
        GDPR_APPLIES,
        TC_STRING,
        AC_STRING
    }

    private enum e {
        IAB_TCF_PARAMETERS,
        CMP_CONFIGURATION
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f725a;
    }

    public void initialize(List<x6> list, com.applovin.impl.sdk.k kVar) {
        this.f725a = kVar;
        w6 w6VarS0 = kVar.s0();
        a(list);
        a aVar = new a(this);
        this.b = aVar;
        aVar.a(new b(w6VarS0, kVar));
        this.b.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("CMP (Consent Management Platform)");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p2 p2Var = this.b;
        if (p2Var != null) {
            p2Var.a((p2.a) null);
        }
    }

    private void a(List list) {
        boolean zB = this.f725a.s0().b();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x6 x6Var = (x6) it.next();
            if (x6Var.f() == x6.a.TCF_VENDOR) {
                if (Boolean.TRUE.equals(x6Var.a())) {
                    a(x6Var, this.c);
                } else {
                    a(x6Var, this.e);
                }
            } else if (x6Var.f() != x6.a.ATP_NETWORK) {
                this.g.add(x6Var);
            } else if (!zB) {
                this.g.add(x6Var);
            } else if (Boolean.TRUE.equals(x6Var.a())) {
                a(x6Var, this.d);
            } else {
                a(x6Var, this.f);
            }
        }
    }

    private o2 b() {
        o2.b bVarA;
        String strA = x4.t.a();
        Integer numE = this.f725a.s0().e();
        if (StringUtils.isValidString(this.f725a.s0().d())) {
            bVarA = o2.a(o2.c.RIGHT_DETAIL);
        } else {
            bVarA = o2.a(o2.c.DETAIL).b("Unknown CMP SDK ID").a("Your integrated CMP might not be Google-certified. " + ("SharedPreferences value for key " + strA + " is " + numE + ".") + "\n\nIf you use Google AdMob or Google Ad Manager, make sure that the integrated CMP is included in the list of Google-certified CMPs at: https://support.google.com/admob/answer/13554116").a(R.drawable.applovin_ic_warning).b(m0.a(R.color.applovin_sdk_warningColor, this)).a(true);
        }
        bVarA.d(strA);
        bVarA.c(numE != null ? numE.toString() : "No value set");
        bVarA.c(numE != null ? ViewCompat.MEASURED_STATE_MASK : SupportMenu.CATEGORY_MASK);
        return bVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List c() {
        ArrayList arrayList = new ArrayList(d.values().length);
        Integer numG = this.f725a.s0().g();
        String strJ = this.f725a.s0().j();
        String strC = this.f725a.s0().c();
        arrayList.add(a(x4.v.a(), numG));
        arrayList.add(a(x4.w.a(), strJ, !z6.b(strJ)));
        arrayList.add(a(x4.x.a(), strC, false));
        return arrayList;
    }

    private void a(x6 x6Var, List list) {
        if (x6Var.d() != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (x6Var.d().equals(((x6) it.next()).d())) {
                    return;
                }
            }
        }
        list.add(x6Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a() {
        ArrayList arrayList = new ArrayList(c.values().length);
        int size = this.e.size() + this.f.size();
        arrayList.add(b());
        arrayList.add(a(x4.u.a(), this.f725a.s0().f()));
        arrayList.add(o2.a(o2.c.DETAIL).d("To check which networks are missing from your CMP, first make sure that you have granted consent to all networks through your CMP flow. Then add the following networks to your CMP network list.").a());
        arrayList.add(o2.a(o2.c.RIGHT_DETAIL).d("Configured CMP Networks").c(size > 0 ? "Missing " + size + " network(s)" : "").c(size > 0 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).a(this).a(true).a());
        return arrayList;
    }

    private o2 a(String str, Integer num) {
        return o2.a(o2.c.RIGHT_DETAIL).d(str).c(num != null ? num.toString() : "No value set").c(num != null ? ViewCompat.MEASURED_STATE_MASK : SupportMenu.CATEGORY_MASK).a();
    }

    private o2 a(String str, String str2, boolean z) {
        boolean zIsValidString = StringUtils.isValidString(str2);
        if (zIsValidString && str2.length() > 35) {
            str2 = str2.substring(0, 35) + APSSharedUtil.TRUNCATE_SEPARATOR;
        }
        o2.b bVarD = o2.a(o2.c.DETAIL).d(str);
        if (!zIsValidString) {
            str2 = "No value set";
        }
        o2.b bVarA = bVarD.c(str2).c(z ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK).a(zIsValidString);
        if (zIsValidString) {
            bVarA.a(this);
        }
        return bVarA.a();
    }
}
