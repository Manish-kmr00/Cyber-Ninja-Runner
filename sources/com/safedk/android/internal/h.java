package com.safedk.android.internal;

import android.os.Bundle;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8142a = "master";
    public static final String b = "collect_host_urls";
    private static final String c = "SafeDKToggles";
    private static final String d = "network";
    private static final String e = "location";
    private static final String f = "calllog";
    private static final String g = "accounts";
    private static final String h = "contacts";
    private static final String i = "calendar";
    private static final String j = "browser";
    private static final String k = "sms";
    private static final String l = "files";
    private static final String m = "camera";
    private static final String n = "microphone";
    private static final String o = "accelerometer";
    private static final String p = "notifications";
    private static final String q = "packagemanager";
    private static final String r = "advertising_identifier";
    private boolean s = true;
    private boolean t = true;
    private boolean u = true;
    private boolean v = true;
    private boolean w = true;
    private boolean x = true;
    private boolean y = true;
    private boolean z = true;
    private boolean A = true;
    private boolean B = true;
    private boolean C = true;
    private boolean D = true;
    private boolean E = true;
    private boolean F = true;
    private boolean G = true;
    private boolean H = true;
    private boolean I = false;

    public h(boolean z) {
        b(z);
    }

    private void b(boolean z) {
        this.H = z;
        this.G = z;
        this.F = z;
        this.E = z;
        this.D = z;
        this.C = z;
        this.B = z;
        this.A = z;
        this.z = z;
        this.y = z;
        this.x = z;
        this.w = z;
        this.v = z;
        this.u = z;
        this.t = z;
        this.s = z;
        this.I = false;
    }

    public h(String str) {
        a(str);
    }

    public h(JSONObject jSONObject) {
        a(jSONObject);
    }

    private Bundle s() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(f8142a, this.s);
        bundle.putBoolean("network", this.t);
        bundle.putBoolean("location", this.u);
        bundle.putBoolean(g, this.w);
        bundle.putBoolean(f, this.v);
        bundle.putBoolean(h, this.x);
        bundle.putBoolean("calendar", this.y);
        bundle.putBoolean(j, this.z);
        bundle.putBoolean("sms", this.A);
        bundle.putBoolean("files", this.B);
        bundle.putBoolean(m, this.C);
        bundle.putBoolean(n, this.D);
        bundle.putBoolean(o, this.E);
        bundle.putBoolean("notifications", this.F);
        bundle.putBoolean(q, this.G);
        bundle.putBoolean(r, this.H);
        bundle.putBoolean(b, this.I);
        return bundle;
    }

    private void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            Logger.e(c, "Failed to convert toggles to json", e2);
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.has(f8142a)) {
                this.s = jSONObject.getBoolean(f8142a);
            }
            if (jSONObject.has("network")) {
                this.t = jSONObject.getBoolean("network");
            }
            if (jSONObject.has("location")) {
                this.u = jSONObject.getBoolean("location");
            }
            if (jSONObject.has(g)) {
                this.w = jSONObject.getBoolean(g);
            }
            if (jSONObject.has(f)) {
                this.v = jSONObject.getBoolean(f);
            }
            if (jSONObject.has(h)) {
                this.x = jSONObject.getBoolean(h);
            }
            if (jSONObject.has("calendar")) {
                this.y = jSONObject.getBoolean("calendar");
            }
            if (jSONObject.has(j)) {
                this.z = jSONObject.getBoolean(j);
            }
            if (jSONObject.has("sms")) {
                this.A = jSONObject.getBoolean("sms");
            }
            if (jSONObject.has("files")) {
                this.B = jSONObject.getBoolean("files");
            }
            if (jSONObject.has(m)) {
                this.C = jSONObject.getBoolean(m);
            }
            if (jSONObject.has(n)) {
                this.D = jSONObject.getBoolean(n);
            }
            if (jSONObject.has(o)) {
                this.E = jSONObject.getBoolean(o);
            }
            if (jSONObject.has("notifications")) {
                this.F = jSONObject.getBoolean("notifications");
            }
            if (jSONObject.has(q)) {
                this.G = jSONObject.getBoolean(q);
            }
            if (jSONObject.has(r)) {
                this.H = jSONObject.getBoolean(r);
            }
            if (jSONObject.has(b)) {
                this.I = jSONObject.getBoolean(b);
            }
        } catch (Throwable th) {
            Logger.e(c, "Failed to parse toggles: " + (jSONObject == null ? "null" : jSONObject.toString()), th);
            new CrashReporter().caughtException(th);
            b(true);
        }
    }

    public ArrayList<String> a() {
        return a(true);
    }

    public ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Bundle bundleS = s();
            for (String str : bundleS.keySet()) {
                if (!str.equals(b) && !bundleS.getBoolean(str)) {
                    arrayList.add(str);
                }
            }
        } catch (Throwable th) {
            Logger.e(c, "caught exception", th);
            if (z) {
                new CrashReporter().caughtException(th);
            }
        }
        return arrayList;
    }

    public boolean b() {
        return this.s;
    }

    public boolean c() {
        return this.t;
    }

    public boolean d() {
        return this.u;
    }

    public boolean e() {
        return this.w;
    }

    public boolean f() {
        return this.v;
    }

    public boolean g() {
        return this.x;
    }

    public boolean h() {
        return this.y;
    }

    public boolean i() {
        return this.z;
    }

    public boolean j() {
        return this.A;
    }

    public boolean k() {
        return this.B;
    }

    public boolean l() {
        return this.C;
    }

    public boolean m() {
        return this.D;
    }

    public boolean n() {
        return this.E;
    }

    public boolean o() {
        return this.F;
    }

    public boolean p() {
        return this.G;
    }

    public boolean q() {
        return this.H;
    }

    public boolean r() {
        return this.I;
    }

    public String toString() {
        return "SafeDKToggles: master=" + this.s + "; network=" + this.t + "; location=" + this.u + "; ; accounts=" + this.w + "; call_log=" + this.v + "; contacts=" + this.x + "; calendar=" + this.y + "; browser=" + this.z + "; sms_mms=" + this.A + "; files=" + this.B + "; camera=" + this.C + "; microphone=" + this.D + "; accelerometer=" + this.E + "; notifications=" + this.F + "; packageManager=" + this.G + "; advertisingId=" + this.H;
    }
}
