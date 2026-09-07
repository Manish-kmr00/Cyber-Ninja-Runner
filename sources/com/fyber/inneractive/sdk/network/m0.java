package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f1927a;

    public m0(n0 n0Var) {
        this.f1927a = n0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        n0 n0Var = this.f1927a;
        U u = (U) AbstractC3256u.a(n0Var.b);
        Thread thread = (Thread) AbstractC3256u.a(this.f1927a.f1928a);
        if (u == null || u.f == i0.DONE || u.f == i0.RESOLVED) {
            return;
        }
        boolean zT = u.t();
        IAlog.a("%s : NetworkWatchdogHolder : should report: %s", IAlog.a(n0.class), Boolean.valueOf(zT));
        if (zT) {
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                Exception exc = new Exception();
                exc.setStackTrace(stackTrace);
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.getBuffer().toString();
            } else {
                string = "";
            }
            String strP = u.p();
            InneractiveAdRequest inneractiveAdRequest = u instanceof Q ? ((Q) u).p : null;
            com.fyber.inneractive.sdk.response.e eVar = u instanceof f0 ? ((f0) u).s : null;
            EnumC3144u enumC3144u = EnumC3144u.NETWORK_REQUEST_PASSED_ALLOWED_TIME;
            JSONArray jSONArrayB = u.i() != null ? u.i().b() : null;
            C3146w c3146w = new C3146w(eVar);
            c3146w.c = enumC3144u;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", strP);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "url", strP);
            }
            try {
                jSONObject.put("stack_trace", string);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", string);
            }
            Integer numValueOf = Integer.valueOf(n0Var.c);
            try {
                jSONObject.put("total_time", numValueOf);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "total_time", numValueOf);
            }
            c3146w.f.put(jSONObject);
            c3146w.a((String) null);
        }
        IAlog.a("%s : NetworkWatchdogHolder should cancel by timeout: %d", IAlog.a(n0Var), Integer.valueOf(n0Var.c));
        u.c();
    }
}
