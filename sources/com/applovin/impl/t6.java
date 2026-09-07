package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class t6 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f699a;
    private p2 b;

    class a extends p2 {
        final /* synthetic */ ArrayList e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ArrayList arrayList, ArrayList arrayList2, boolean z) {
            super(context);
            this.e = arrayList;
            this.f = arrayList2;
            this.g = z;
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return b.values().length;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return i == b.TC_NETWORKS.ordinal() ? this.e : this.f;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return i == b.TC_NETWORKS.ordinal() ? this.e.size() : this.f.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            if (i == b.TC_NETWORKS.ordinal()) {
                return new t4("TCF VENDORS (TC STRING)");
            }
            return new t4(this.g ? "ATP NETWORKS (AC STRING)" : "APPLOVIN PRIVACY SETTING");
        }
    }

    private enum b {
        TC_NETWORKS,
        AC_NETWORKS
    }

    private o2 a(String str, String str2) {
        return o2.a().d(str).c(str2).a();
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f699a;
    }

    public void initialize(List<x6> list, com.applovin.impl.sdk.k kVar) {
        this.f699a = kVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strA = p0.b().a(this);
        boolean zB = kVar.s0().b();
        if (!zB) {
            arrayList2.add(a("Has User Consent", strA));
        }
        for (x6 x6Var : list) {
            Boolean boolA = x6Var.a();
            if (boolA != null) {
                if (x6Var.f() == x6.a.TCF_VENDOR) {
                    arrayList.add(a(x6Var.b(), String.valueOf(boolA)));
                } else if (x6Var.f() == x6.a.ATP_NETWORK) {
                    arrayList2.add(a(x6Var.b(), String.valueOf(boolA)));
                }
            } else if (zB && x6Var.f() == x6.a.ATP_NETWORK) {
                arrayList2.add(a(x6Var.b(), strA));
            }
        }
        a aVar = new a(this, arrayList, arrayList2, zB);
        this.b = aVar;
        aVar.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        setTitle("Network Consent Statuses");
        ((ListView) findViewById(R.id.listView)).setAdapter((ListAdapter) this.b);
    }
}
