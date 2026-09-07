package com.apm.insight.runtime.a;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.apm.insight.l.m;
import com.apm.insight.l.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseAssembly.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CrashType f274a;
    protected Context b;
    private ICommonParams c = com.apm.insight.e.a().c();
    private b d;
    private d e;

    /* JADX INFO: compiled from: BaseAssembly.java */
    public interface a {
        com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar);

        com.apm.insight.entity.a b(int i, com.apm.insight.entity.a aVar);
    }

    public int a() {
        return 6;
    }

    public com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        return aVar;
    }

    protected boolean b() {
        return true;
    }

    protected boolean c() {
        return true;
    }

    c(CrashType crashType, Context context, b bVar, d dVar) {
        this.f274a = crashType;
        this.b = context;
        this.d = bVar;
        this.e = dVar;
    }

    public final com.apm.insight.entity.a a(com.apm.insight.entity.a aVar, a aVar2, boolean z) {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        com.apm.insight.entity.a aVar3 = aVar;
        for (int i = 0; i < a(); i++) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (aVar2 != null) {
                try {
                    aVar3 = aVar2.a(i, aVar3);
                } catch (Throwable unused) {
                }
            }
            try {
                aVar3 = a(i, aVar3);
            } catch (Throwable unused2) {
            }
            if (aVar2 != null) {
                try {
                    a();
                    aVar3 = aVar2.b(i, aVar3);
                } catch (Throwable unused3) {
                }
                if (z) {
                    if (i != 0) {
                        aVar.c(aVar3.c());
                    } else {
                        aVar = aVar3;
                    }
                    aVar3 = new com.apm.insight.entity.a();
                }
            }
            aVar.b("step_cost_".concat(String.valueOf(i)), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
        }
        return a(aVar);
    }

    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        if (aVar == null) {
            aVar = new com.apm.insight.entity.a();
        }
        if (i != 0) {
            if (i == 1) {
                c(aVar);
                List<AttachUserData> listA = com.apm.insight.e.b().a(this.f274a);
                HashMap map = new HashMap();
                JSONObject jSONObjectOptJSONObject = aVar.c().optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    aVar.a("custom", jSONObjectOptJSONObject);
                }
                if (listA != null) {
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        try {
                            AttachUserData attachUserData = listA.get(i2);
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject, attachUserData.getUserData(this.f274a));
                            map.put("custom_cost_" + attachUserData.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
                        } catch (Throwable th) {
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject, th);
                        }
                    }
                }
                try {
                    jSONObjectOptJSONObject.put("fd_count", com.apm.insight.a.f());
                } catch (Throwable unused) {
                }
                List<AttachUserData> listB = com.apm.insight.e.b().b(this.f274a);
                if (listB != null) {
                    JSONObject jSONObjectOptJSONObject2 = aVar.c().optJSONObject("custom_long");
                    if (jSONObjectOptJSONObject2 == null) {
                        jSONObjectOptJSONObject2 = new JSONObject();
                        aVar.a("custom_long", jSONObjectOptJSONObject2);
                    }
                    for (int i3 = 0; i3 < listB.size(); i3++) {
                        try {
                            AttachUserData attachUserData2 = listB.get(i3);
                            long jUptimeMillis2 = SystemClock.uptimeMillis();
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, attachUserData2.getUserData(this.f274a));
                            map.put("custom_cost_" + attachUserData2.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis2));
                        } catch (Throwable th2) {
                            com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, th2);
                        }
                    }
                }
                for (Map.Entry entry : map.entrySet()) {
                    jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } else if (i == 2) {
                d dVar = this.e;
                aVar.a("battery", Integer.valueOf(dVar != null ? dVar.a() : 0));
                aVar.c(com.apm.insight.e.b().a());
            } else if (i == 5 && c()) {
                aVar.b(n.a());
            }
        } else {
            b(aVar);
        }
        return aVar;
    }

    private com.apm.insight.entity.a b(com.apm.insight.entity.a aVar) {
        aVar.a(com.apm.insight.e.q(), com.apm.insight.e.r());
        if (com.apm.insight.e.n()) {
            aVar.a("is_mp", (Object) 1);
        }
        try {
            aVar.a(this.c.getPluginInfo());
        } catch (Throwable th) {
            try {
                HashMap map = new HashMap();
                map.put("Data fetch failed since source misstake:\n" + m.a(th), 0);
                aVar.a(map);
            } catch (Throwable unused) {
            }
        }
        aVar.b(com.apm.insight.e.p());
        aVar.a("process_name", com.apm.insight.l.a.d(com.apm.insight.e.g()));
        return aVar;
    }

    private com.apm.insight.entity.a c(com.apm.insight.entity.a aVar) {
        b bVar;
        if (!com.apm.insight.l.a.c(com.apm.insight.e.g())) {
            aVar.a("remote_process", (Object) 1);
        }
        aVar.a("pid", Integer.valueOf(Process.myPid()));
        aVar.a(com.apm.insight.e.j());
        if (b() && (bVar = this.d) != null) {
            aVar.a(bVar);
        }
        try {
            aVar.a(this.c.getPatchInfo());
        } catch (Throwable th) {
            try {
                aVar.a(Arrays.asList("Data fetch failed since source misstake:\n" + m.a(th)));
            } catch (Throwable unused) {
            }
        }
        String strK = com.apm.insight.e.k();
        if (strK != null) {
            aVar.a("business", (Object) strK);
        }
        aVar.a("is_background", Boolean.valueOf(!com.apm.insight.l.a.a(this.b)));
        return aVar;
    }
}
