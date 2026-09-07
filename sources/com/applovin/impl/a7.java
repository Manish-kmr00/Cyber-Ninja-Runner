package com.applovin.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannedString;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a7 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f323a;
    private List b;
    private List c;
    private p2 d;
    private List e;
    private List f;
    private ListView g;

    class a extends p2 {
        a(Context context) {
            super(context);
        }

        @Override // com.applovin.impl.p2
        protected o2 a() {
            return new o2.b(o2.c.SECTION_CENTERED).d("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return c.COUNT.ordinal();
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return i == c.BIDDERS.ordinal() ? a7.this.e : a7.this.f;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return i == c.BIDDERS.ordinal() ? a7.this.e.size() : a7.this.f.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return i == c.BIDDERS.ordinal() ? new t4("BIDDERS") : new t4("WATERFALL");
        }
    }

    class b extends w3 {
        final /* synthetic */ r2 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(b3 b3Var, Context context, r2 r2Var) {
            super(b3Var, context);
            this.p = r2Var;
        }

        @Override // com.applovin.impl.w3, com.applovin.impl.o2
        public int d() {
            if (a7.this.f323a.t0().b() == null || !a7.this.f323a.t0().b().equals(this.p.b())) {
                return 0;
            }
            return R.drawable.applovin_ic_check_mark_borderless;
        }

        @Override // com.applovin.impl.w3, com.applovin.impl.o2
        public int e() {
            if (a7.this.f323a.t0().b() == null || !a7.this.f323a.t0().b().equals(this.p.b())) {
                return super.e();
            }
            return -16776961;
        }

        @Override // com.applovin.impl.o2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.p.a(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    enum c {
        BIDDERS,
        WATERFALL,
        COUNT
    }

    public a7() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f323a;
    }

    public void initialize(List<r2> list, List<r2> list2, final com.applovin.impl.sdk.k kVar) {
        this.f323a = kVar;
        this.b = list;
        this.c = list2;
        this.e = a(list);
        this.f = a(list2);
        a aVar = new a(this);
        this.d = aVar;
        aVar.a(new p2.a() { // from class: com.applovin.impl.a7$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.p2.a
            public final void a(i2 i2Var, o2 o2Var) {
                this.f$0.a(kVar, i2Var, o2Var);
            }
        });
        this.d.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.g = listView;
        listView.setAdapter((ListAdapter) this.d);
    }

    @Override // com.applovin.impl.k3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.e = a(this.b);
        this.f = a(this.c);
        this.d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.k kVar, i2 i2Var, o2 o2Var) {
        List listB = a(i2Var).b();
        if (listB.equals(kVar.t0().b())) {
            kVar.t0().a((List) null);
        } else {
            kVar.t0().a(listB);
        }
        this.d.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r2 r2Var = (r2) it.next();
            arrayList.add(new b(r2Var.d(), this, r2Var));
        }
        return arrayList;
    }

    private r2 a(i2 i2Var) {
        if (i2Var.b() == c.BIDDERS.ordinal()) {
            return (r2) this.b.get(i2Var.a());
        }
        return (r2) this.c.get(i2Var.a());
    }
}
