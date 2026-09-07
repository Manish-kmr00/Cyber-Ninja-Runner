package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.LoadWhileShowSupportState;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.r;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class al {
    private static final String i = "WaterfallLifeCycleHolder";
    private r d;
    private final List<String> e;
    private final int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<r>> f3528a = new ConcurrentHashMap<>();
    private String b = "";
    private String c = "";
    private final Timer g = new Timer();
    ConcurrentHashMap<String, AdInfo> h = new ConcurrentHashMap<>();

    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3529a;

        a(String str) {
            this.f3529a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f3529a + " from memory");
                al.this.f3528a.remove(this.f3529a);
                ironLog.verbose("waterfall size is currently " + al.this.f3528a.size());
                ironLog.verbose("removing adInfo with id " + this.f3529a + " from memory");
                al.this.h.remove(this.f3529a);
                ironLog.verbose("adInfo size is currently " + al.this.h.size());
            } finally {
                cancel();
            }
        }
    }

    public al(List<String> list, int i2) {
        this.e = list;
        this.f = i2;
    }

    private void b() {
        for (r rVar : c()) {
            if (!rVar.equals(this.d)) {
                rVar.q();
            }
        }
    }

    public AdInfo a(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }

    public synchronized void a(r rVar) {
        IronLog.INTERNAL.verbose();
        r rVar2 = this.d;
        if (rVar2 != null && !rVar2.equals(rVar)) {
            this.d.q();
        }
        this.d = rVar;
    }

    public void a(String str, ImpressionData impressionData, am amVar) {
        if (TextUtils.isEmpty(str) || impressionData == null) {
            return;
        }
        this.h.put(str, new AdInfo(impressionData, amVar));
    }

    public void a(CopyOnWriteArrayList<r> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        b();
        this.f3528a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.c)) {
            if (g()) {
                ironLog.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.c;
                this.c = str2;
            }
            this.g.schedule(new a(this.c), this.f);
        }
        this.c = this.b;
        this.b = str;
    }

    public boolean a() {
        return this.f3528a.size() > 5;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    public synchronized boolean b(r rVar) {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (rVar == null || rVar.o()) {
            z = true;
        } else {
            z = false;
            if (this.d != null && ((rVar.w() == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK && this.d.c().equals(rVar.c())) || ((rVar.w() == LoadWhileShowSupportState.NONE || this.e.contains(rVar.j())) && this.d.j().equals(rVar.j())))) {
                z = true;
            }
        }
        if (z && rVar != null) {
            ironLog.verbose(rVar.c() + " will not be added to the auction request");
        }
        return !z;
    }

    public CopyOnWriteArrayList<r> c() {
        CopyOnWriteArrayList<r> copyOnWriteArrayList = this.f3528a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.f3528a.size();
    }

    public r f() {
        return this.d;
    }

    public synchronized boolean g() {
        r rVar;
        rVar = this.d;
        return rVar != null && rVar.u().equals(this.c);
    }
}
