package com.apm.insight.g;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.adjust.sdk.Constants;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.i;
import com.apm.insight.runtime.k;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: JavaCrash.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f210a;

    @Override // com.apm.insight.g.c
    public final void a(final long j, final Thread thread, final Throwable th, final String str, final String str2, final boolean z) {
        final File file = new File(j.a(this.f210a), str);
        a.a().a(file.getName());
        file.mkdirs();
        f.d(file);
        final boolean zC = m.c(th);
        com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(CrashType.JAVA, new com.apm.insight.runtime.a.c.a() { // from class: com.apm.insight.g.d.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f211a = 0;

            @Override // com.apm.insight.runtime.a.c.a
            public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                this.f211a = SystemClock.uptimeMillis();
                if (i == 0) {
                    aVar.a("data", (Object) m.a(th));
                    aVar.a("isOOM", Boolean.valueOf(zC));
                    aVar.a("isJava", (Object) 1);
                    aVar.a("crash_time", Long.valueOf(j));
                    aVar.a("launch_mode", Integer.valueOf(com.apm.insight.runtime.a.b.b()));
                    aVar.a("launch_time", Long.valueOf(com.apm.insight.runtime.a.b.c()));
                    String str3 = str2;
                    if (str3 != null) {
                        aVar.a("crash_md5", (Object) str3);
                        aVar.a("crash_md5", str2);
                        boolean z2 = z;
                        if (z2) {
                            aVar.a("has_ignore", String.valueOf(z2));
                        }
                    }
                } else if (i == 1) {
                    Thread thread2 = thread;
                    aVar.a("crash_thread_name", (Object) (thread2 != null ? thread2.getName() : ""));
                    aVar.a(ScarConstants.TOKEN_ID_KEY, Integer.valueOf(Process.myTid()));
                    aVar.a("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                    aVar.a("crash_after_native", NativeImpl.e() ? "true" : "false");
                    a.a().a(thread, th, false, aVar);
                } else if (i == 2) {
                    if (zC) {
                        com.apm.insight.l.a.a(d.this.f210a, aVar.c());
                    }
                    JSONArray jSONArrayB = com.apm.insight.b.f.b().b();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    JSONObject jSONObjectA = com.apm.insight.b.f.b().a(jUptimeMillis).a();
                    JSONArray jSONArrayA = com.apm.insight.b.j.a(jUptimeMillis);
                    aVar.a("history_message", (Object) jSONArrayB);
                    aVar.a("current_message", jSONObjectA);
                    aVar.a("pending_messages", (Object) jSONArrayA);
                    aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                    aVar.a("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.a()));
                } else if (i == 3) {
                    JSONObject jSONObjectB = m.b(Thread.currentThread().getName());
                    if (jSONObjectB != null) {
                        aVar.a("all_thread_stacks", jSONObjectB);
                    }
                    aVar.a("logcat", (Object) i.a(e.f()));
                } else if (i != 4) {
                    if (i == 5) {
                        aVar.a("crash_uuid", (Object) str);
                    }
                } else if (!zC) {
                    com.apm.insight.l.a.a(d.this.f210a, aVar.c());
                }
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public final com.apm.insight.entity.a b(int i, com.apm.insight.entity.a aVar) {
                try {
                    f.a(new File(file, file.getName() + "." + i), aVar.c());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return aVar;
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        try {
            aVarA.a("crash_type", Constants.NORMAL);
            aVarA.b("crash_cost", String.valueOf(jCurrentTimeMillis));
            aVarA.a("crash_cost", String.valueOf(jCurrentTimeMillis / 1000));
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            k.a(th2, "NPTH_CATCH");
        }
    }

    public d(Context context) {
        this.f210a = context;
    }
}
