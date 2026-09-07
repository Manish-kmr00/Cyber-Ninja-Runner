package com.json;

import android.util.Log;
import android.util.Pair;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.h;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes8.dex */
public class kc {
    private static final String e = "EventsTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cf f3832a;
    private ec b;
    private vf c;
    private ExecutorService d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3833a;

        a(String str) {
            this.f3833a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                fq fqVar = new fq();
                ArrayList<Pair<String, String>> arrayListD = kc.this.b.d();
                if ("POST".equals(kc.this.b.e())) {
                    fqVar = rg.b(kc.this.b.b(), this.f3833a, arrayListD);
                } else if ("GET".equals(kc.this.b.e())) {
                    fqVar = rg.a(kc.this.b.b(), this.f3833a, arrayListD);
                }
                kc.this.a("response status code: " + fqVar.f3701a);
            } catch (Exception e) {
                o9.d().a(e);
            }
        }
    }

    public kc(ec ecVar, cf cfVar) {
        if (ecVar == null) {
            throw new InvalidParameterException("Null configuration not supported ");
        }
        if (ecVar.c() == null) {
            throw new InvalidParameterException("Null formatter not supported ");
        }
        this.b = ecVar;
        this.f3832a = cfVar;
        this.c = ecVar.c();
        this.d = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.b.f()) {
            Log.d(e, str);
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        try {
            map.putAll(map2);
        } catch (Exception e2) {
            o9.d().a(e2);
        }
    }

    private void b(String str) {
        this.d.submit(new a(str));
    }

    public void a(String str, Map<String, Object> map) {
        a(String.format(Locale.ENGLISH, "%s %s", str, map.toString()));
        if (this.b.a() && !str.isEmpty()) {
            HashMap map2 = new HashMap();
            map2.put(h.S, str);
            a(map2, this.f3832a.a());
            a(map2, map);
            b(this.c.a(map2));
        }
    }
}
