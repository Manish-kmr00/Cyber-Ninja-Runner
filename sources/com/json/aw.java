package com.json;

import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.LoadWhileShowSupportState;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.json.mediationsdk.logger.IronLog;
import com.json.q7;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class aw<Smash extends q7<?>> {
    q7<?> d;
    private final List<String> e;
    private final int f;
    bw h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> f3536a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private final Timer g = new Timer();
    private final int i = 5;

    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3537a;

        a(String str) {
            this.f3537a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f3537a + " from memory");
                aw.this.f3536a.remove(this.f3537a);
                ironLog.verbose("waterfall size is currently " + aw.this.f3536a.size());
            } finally {
                cancel();
            }
        }
    }

    public aw(List<String> list, int i, bw bwVar) {
        this.e = list;
        this.f = i;
        this.h = bwVar;
    }

    private void a() {
        for (Smash smash : b()) {
            if (!smash.equals(this.d)) {
                smash.M();
            }
        }
    }

    private synchronized boolean e() {
        q7<?> q7Var;
        q7Var = this.d;
        return q7Var != null && q7Var.C() && this.d.h().equals(this.c);
    }

    public void a(o2.a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        a();
        if (aVar == o2.a.AUTOMATIC_LOAD_WHILE_SHOW || aVar == o2.a.MANUAL_WITH_LOAD_ON_SHOW) {
            this.f3536a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.c)) {
                if (e()) {
                    ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                    String str2 = this.b;
                    this.b = this.c;
                    this.c = str2;
                }
                this.g.schedule(new a(this.c), this.f);
            }
        } else {
            this.f3536a.clear();
            this.f3536a.put(str, copyOnWriteArrayList);
        }
        this.c = this.b;
        this.b = str;
        if (this.f3536a.size() > 5) {
            this.h.a(this.f3536a.size());
        }
    }

    public synchronized void a(q7<?> q7Var) {
        IronLog.INTERNAL.verbose();
        q7<?> q7Var2 = this.d;
        if (q7Var2 != null && !q7Var2.equals(q7Var)) {
            this.d.M();
        }
    }

    public boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0049 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:29:0x0049, B:6:0x0008, B:8:0x000d, B:11:0x0012, B:13:0x0016, B:16:0x001d, B:18:0x0021, B:21:0x002e, B:23:0x0032, B:25:0x003a), top: B:35:0x0001 }] */
    public synchronized boolean a(o2.a aVar, String str, String str2, LoadWhileShowSupportState loadWhileShowSupportState, AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit) {
        boolean z;
        q7<?> q7Var;
        if (!a(adapterBaseInterface, ad_unit, str)) {
            z = true;
            if ((aVar == o2.a.AUTOMATIC_LOAD_WHILE_SHOW || aVar == o2.a.MANUAL_WITH_LOAD_ON_SHOW) && (q7Var = this.d) != null && q7Var.C() && ((loadWhileShowSupportState == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK && this.d.c().equals(str)) || ((loadWhileShowSupportState == LoadWhileShowSupportState.NONE || this.e.contains(str2)) && this.d.n().equals(str2)))) {
            }
            if (!z) {
                IronLog.INTERNAL.verbose(str + " will not be added to the auction request");
            }
        }
        z = false;
        if (!z) {
            IronLog.INTERNAL.verbose(str + " will not be added to the auction request");
        }
        return z;
    }

    public List<Smash> b() {
        CopyOnWriteArrayList<Smash> copyOnWriteArrayList = this.f3536a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    public synchronized void b(q7<?> q7Var) {
        IronLog.INTERNAL.verbose();
        this.d = q7Var;
    }

    public String c() {
        return this.b;
    }

    public q7<?> d() {
        return this.d;
    }
}
