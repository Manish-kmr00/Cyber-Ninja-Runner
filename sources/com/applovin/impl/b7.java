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
public abstract class b7 extends k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.k f367a;
    private List b;
    private p2 c;
    private List d;
    private ListView e;

    class a extends p2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, List list) {
            super(context);
            this.e = list;
        }

        @Override // com.applovin.impl.p2
        protected o2 a() {
            return new o2.b(o2.c.SECTION_CENTERED).d("Select a network to load test ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").a();
        }

        @Override // com.applovin.impl.p2
        protected int b() {
            return 1;
        }

        @Override // com.applovin.impl.p2
        protected List c(int i) {
            return b7.this.d;
        }

        @Override // com.applovin.impl.p2
        protected int d(int i) {
            return this.e.size();
        }

        @Override // com.applovin.impl.p2
        protected o2 e(int i) {
            return new t4("TEST MODE NETWORKS");
        }
    }

    class b implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f368a;
        final /* synthetic */ com.applovin.impl.sdk.k b;

        b(List list, com.applovin.impl.sdk.k kVar) {
            this.f368a = list;
            this.b = kVar;
        }

        @Override // com.applovin.impl.p2.a
        public void a(i2 i2Var, o2 o2Var) {
            List listU = ((b3) this.f368a.get(i2Var.a())).u();
            if (listU.equals(this.b.t0().b())) {
                this.b.t0().a((List) null);
            } else {
                this.b.t0().a(listU);
            }
            b7.this.c.notifyDataSetChanged();
        }
    }

    class c extends w3 {
        final /* synthetic */ b3 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b3 b3Var, Context context, b3 b3Var2) {
            super(b3Var, context);
            this.p = b3Var2;
        }

        @Override // com.applovin.impl.w3, com.applovin.impl.o2
        public int d() {
            if (this.p.u().equals(b7.this.f367a.t0().b())) {
                return R.drawable.applovin_ic_check_mark_borderless;
            }
            return 0;
        }

        @Override // com.applovin.impl.w3, com.applovin.impl.o2
        public int e() {
            if (this.p.u().equals(b7.this.f367a.t0().b())) {
                return -16776961;
            }
            return super.e();
        }

        @Override // com.applovin.impl.o2
        public SpannedString k() {
            return StringUtils.createSpannedString(this.p.g(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
        }
    }

    public b7() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.k3, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.f8160a, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.impl.k3
    protected com.applovin.impl.sdk.k getSdk() {
        return this.f367a;
    }

    public void initialize(List<b3> list, com.applovin.impl.sdk.k kVar) {
        this.f367a = kVar;
        this.b = list;
        this.d = a(list);
        a aVar = new a(this, list);
        this.c = aVar;
        aVar.a(new b(list, kVar));
        this.c.notifyDataSetChanged();
    }

    @Override // com.applovin.impl.k3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Test Mode Network");
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.e = listView;
        listView.setAdapter((ListAdapter) this.c);
    }

    @Override // com.applovin.impl.k3, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.d = a(this.b);
        this.c.notifyDataSetChanged();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b3 b3Var = (b3) it.next();
            arrayList.add(new c(b3Var, this, b3Var));
        }
        return arrayList;
    }
}
