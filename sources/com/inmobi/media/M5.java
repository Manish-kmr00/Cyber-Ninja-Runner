package com.inmobi.media;

import com.inmobi.commons.core.configs.CrashConfig;
import com.ogury.sdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class M5 implements InterfaceC3585u9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CrashConfig f3134a;
    public M3 b;
    public final C3367f5 c;
    public final L5 d;

    public M5(CrashConfig crashConfig) {
        Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
        this.f3134a = crashConfig;
        this.c = new C3367f5(crashConfig);
        this.d = new L5(this);
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.M5$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                M5.a(this.f$0);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ec.f3062a.execute(runnable);
    }

    public static final void a(M5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b = new M3(AbstractC3415ib.c(), this$0, this$0.f3134a.getEventConfig(), null);
    }

    public static final void c(M5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    public final void b(C3353e5 incident) {
        Intrinsics.checkNotNullParameter(incident, "incident");
        CrashConfig.ANRConfig aNRConfig = this.f3134a.getAnr();
        if (Ec.a(incident)) {
            if ((incident instanceof N0) && C3435k3.f3355a.z() && aNRConfig.getAppExitReason().getUseForReporting() && this.c.d.a()) {
                Intrinsics.checkNotNullParameter("ANREvent", "<set-?>");
                incident.f3054a = "ANREvent";
                a(incident);
            } else if ((incident instanceof gd) && aNRConfig.getWatchdog().getUseForReporting() && this.c.c.a()) {
                a(incident);
            } else {
                if (!(incident instanceof R2)) {
                    return;
                }
                if (this.f3134a.getCrashConfig().getEnabled() && this.c.f3311a.a()) {
                    a(incident);
                }
            }
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.M5$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    M5.c(this.f$0);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ec.f3062a.execute(runnable);
        }
    }

    public final void c() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.M5$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                M5.b(this.f$0);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ec.f3062a.execute(runnable);
    }

    public final void a(C3353e5 c3353e5) {
        C3311b5 c3311b5C = AbstractC3415ib.c();
        long eventTTL = this.f3134a.getEventTTL();
        c3311b5C.getClass();
        c3311b5C.a("ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (eventTTL * ((long) 1000)))});
        Intrinsics.checkNotNullExpressionValue("K3", "TAG");
        C3311b5 c3311b5C2 = AbstractC3415ib.c();
        c3311b5C2.getClass();
        int iA = (D1.a((D1) c3311b5C2) + 1) - this.f3134a.getMaxEventsToPersist();
        if (iA > 0) {
            AbstractC3415ib.c().a(iA);
        }
        AbstractC3415ib.c().a(c3353e5);
    }

    public final void a(final P1 incident) {
        Intrinsics.checkNotNullParameter(incident, "incident");
        if (this.f3134a.getCatchConfig().getEnabled() && this.c.b.a()) {
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.M5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    M5.a(this.f$0, incident);
                }
            };
            ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ec.f3062a.execute(runnable);
        }
    }

    public static final void a(M5 this$0, P1 incident) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(incident, "$incident");
        this$0.a((C3353e5) incident);
        this$0.b();
    }

    @Override // com.inmobi.media.InterfaceC3585u9
    public final L3 a() {
        int iA;
        String string;
        int iP = C3435k3.f3355a.p();
        int i = 1;
        if (iP == 0 || iP != 1) {
            iA = this.f3134a.getMobileConfig().a();
        } else {
            iA = this.f3134a.getWifiConfig().a();
        }
        ArrayList<C3353e5> arrayListB = AbstractC3415ib.c().b(iA);
        if (arrayListB.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((C3353e5) it.next()).c));
        }
        try {
            HashMap map = new HashMap(C3435k3.f3355a.a(false));
            map.put("im-accid", C3517pb.b());
            map.put("version", BuildConfig.CORE_VERSION);
            map.put("component", "crash");
            map.put("mk-version", C3531qb.a());
            map.putAll(O0.e);
            JSONObject jSONObject = new JSONObject(map);
            JSONArray jSONArray = new JSONArray();
            for (C3353e5 c3353e5 : arrayListB) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", c3353e5.e);
                jSONObject2.put("eventType", c3353e5.f3054a);
                String strA = c3353e5.a();
                int length = strA.length() - i;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = Intrinsics.compare((int) strA.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                if (strA.subSequence(i2, length + 1).toString().length() > 0) {
                    jSONObject2.put("crash_report", c3353e5.a());
                }
                jSONObject2.put("ts", c3353e5.b);
                jSONArray.put(jSONObject2);
                i = 1;
            }
            jSONObject.put("crash", jSONArray);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            string = null;
        }
        if (string != null) {
            return new L3(arrayList, string);
        }
        return null;
    }

    public static final void b(M5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C3311b5 c3311b5C = AbstractC3415ib.c();
        c3311b5C.getClass();
        if (D1.a((D1) c3311b5C) > 0) {
            this$0.b();
        }
    }

    public final void b() {
        Unit unit;
        J3 eventConfig = this.f3134a.getEventConfig();
        eventConfig.k = this.f3134a.getUrl();
        M3 m3 = this.b;
        if (m3 != null) {
            Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
            m3.i = eventConfig;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.b = new M3(AbstractC3415ib.c(), this, eventConfig, null);
        }
        M3 m4 = this.b;
        if (m4 != null) {
            J3 j3 = m4.i;
            if (m4.f.get() || j3 == null) {
                return;
            }
            m4.a(j3.c, false);
        }
    }
}
