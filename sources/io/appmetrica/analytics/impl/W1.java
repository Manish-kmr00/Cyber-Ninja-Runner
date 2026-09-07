package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class W1 implements InterfaceC4301n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11400a = new ArrayList();
    public volatile G7 b = null;

    public final void a(G7 g7) {
        ArrayList arrayListA;
        synchronized (this) {
            this.b = g7;
            arrayListA = a();
        }
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            ((Sd) it.next()).consume(g7);
        }
    }

    public final void b() {
        C4455t4.i().e.a(this, EnumC4276m.CREATED);
    }

    public final void c() {
        C4455t4.i().e.b(this, EnumC4276m.CREATED);
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f11400a);
        this.f11400a.clear();
        return arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4301n
    public final void a(Activity activity, EnumC4276m enumC4276m) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new U1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        V1 v1 = new V1(dataString);
        synchronized (this) {
            G7 g7 = this.b;
            if (g7 == null) {
                this.f11400a.add(v1);
            } else {
                ((G9) C4455t4.i().c.a()).b.post(new T1(v1, g7));
            }
        }
    }
}
