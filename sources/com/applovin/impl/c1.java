package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public class c1 extends p2 {
    private com.applovin.impl.sdk.k e;
    private List f;
    private final AtomicBoolean g;
    private List h;

    public enum a {
        RECENT_ADS,
        COUNT
    }

    public c1(Context context) {
        super(context);
        this.g = new AtomicBoolean();
        this.h = new ArrayList();
    }

    public void a(List list, com.applovin.impl.sdk.k kVar) {
        Activity activityV0;
        this.e = kVar;
        this.f = list;
        if (!(this.f577a instanceof Activity) && (activityV0 = kVar.v0()) != null) {
            this.f577a = activityV0;
        }
        if (list != null && this.g.compareAndSet(false, true)) {
            this.h = a(this.f);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.c1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    @Override // com.applovin.impl.p2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.p2
    protected List c(int i) {
        return this.h;
    }

    public List d() {
        return this.f;
    }

    public com.applovin.impl.sdk.k e() {
        return this.e;
    }

    public boolean f() {
        return this.h.size() == 0;
    }

    public void g() {
        this.g.compareAndSet(true, false);
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.g.get() + "}";
    }

    @Override // com.applovin.impl.p2
    protected int d(int i) {
        return this.h.size();
    }

    @Override // com.applovin.impl.p2
    protected o2 e(int i) {
        return new t4("RECENT ADS");
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new o1((p1) it.next(), this.f577a));
        }
        return arrayList;
    }
}
