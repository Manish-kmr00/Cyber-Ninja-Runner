package com.mbridge.msdk.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ReportMonitor.java */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f5665a;
    private x b;
    private volatile boolean c = false;
    private int d = 30000;
    private final HashMap<String, String> e = new HashMap<>();
    Handler f = new a(Looper.getMainLooper());

    /* JADX INFO: compiled from: ReportMonitor.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                u.this.b();
                u.this.f.removeMessages(1);
                u.this.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f.sendEmptyMessageDelayed(1, this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005a A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:5:0x0008, B:7:0x000d, B:9:0x001b, B:12:0x002e, B:15:0x003a, B:18:0x005a, B:23:0x00a8, B:20:0x0074), top: B:28:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[SYNTHETIC] */
    public void b() {
        m[] mVarArrB = m.b();
        if (mVarArrB.length == 0) {
            return;
        }
        try {
            for (m mVar : mVarArrB) {
                String strF = mVar.f();
                if (!"monitor".equals(strF)) {
                    String strD = mVar.d();
                    long[] jArrE = mVar.e();
                    long j = jArrE[1];
                    if (j != 0) {
                        long j2 = jArrE[0];
                        if (this.e.containsKey(strF)) {
                            if (!(j2 + "").equals(this.e.get(strF))) {
                                this.e.put(strF, j2 + "");
                                if (this.f5665a != null) {
                                    try {
                                        e eVar = new e("event_lib_monitor");
                                        eVar.a(1);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("key", "m_report_rate");
                                        jSONObject.put("task_name", strF);
                                        jSONObject.put("task_count", j);
                                        jSONObject.put("task_session_id", strD);
                                        jSONObject.put("task_ts", j2);
                                        eVar.a(jSONObject);
                                        this.f5665a.d(eVar);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            this.e.put(strF, j2 + "");
                            if (this.f5665a != null) {
                                e eVar2 = new e("event_lib_monitor");
                                eVar2.a(1);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("key", "m_report_rate");
                                jSONObject2.put("task_name", strF);
                                jSONObject2.put("task_count", j);
                                jSONObject2.put("task_session_id", strD);
                                jSONObject2.put("task_ts", j2);
                                eVar2.a(jSONObject2);
                                this.f5665a.d(eVar2);
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        d();
    }

    public void a(Context context, x xVar, int i, JSONObject jSONObject) {
        this.b = xVar;
        this.d = i;
        m mVarA = m.a("monitor", context, xVar);
        this.f5665a = mVarA;
        if (mVarA != null) {
            mVarA.a(jSONObject);
            this.f5665a.h();
        }
        c();
    }

    public static u a() {
        if (g == null) {
            synchronized (u.class) {
                if (g == null) {
                    g = new u();
                }
            }
        }
        return g;
    }
}
