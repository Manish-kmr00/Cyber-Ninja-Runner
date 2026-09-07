package com.json;

import android.os.Handler;
import com.json.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class gb implements of {
    private static final int e = 5;
    private static gb f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fb f3718a;
    private final JSONObject b;
    private Thread c;
    private final String d;

    private gb(String str, hg hgVar, JSONObject jSONObject) {
        this.d = str;
        this.f3718a = new fb(hgVar.a());
        this.b = jSONObject;
        IronSourceStorageUtils.deleteFolder(b());
        IronSourceStorageUtils.makeDir(b());
    }

    public static synchronized gb a(String str, hg hgVar, JSONObject jSONObject) {
        if (f == null) {
            f = new gb(str, hgVar, jSONObject);
        }
        return f;
    }

    private Thread a(db dbVar, Handler handler) {
        return new Thread(new pt(dbVar, handler));
    }

    private String b() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.d, "temp");
    }

    private Thread b(nh nhVar, String str, int i, int i2, Handler handler) {
        if (i <= 0) {
            i = this.b.optInt("connectionTimeout", 5);
        }
        if (i2 <= 0) {
            i2 = this.b.optInt("readTimeout", 5);
        }
        boolean zOptBoolean = this.b.optBoolean(d9.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a(new db(nhVar, str, (int) timeUnit.toMillis(i), (int) timeUnit.toMillis(i2), zOptBoolean, b()), handler);
    }

    public String a() {
        return this.d;
    }

    @Override // com.json.of
    public void a(nh nhVar, String str) {
        int iOptInt = this.b.optInt("connectionTimeout", 5);
        int iOptInt2 = this.b.optInt("readTimeout", 5);
        boolean zOptBoolean = this.b.optBoolean(d9.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Thread threadA = a(new db(nhVar, str, (int) timeUnit.toMillis(iOptInt), (int) timeUnit.toMillis(iOptInt2), zOptBoolean, b()), this.f3718a);
        this.c = threadA;
        threadA.start();
    }

    @Override // com.json.of
    public void a(nh nhVar, String str, int i, int i2) {
        b(nhVar, str, i, i2, this.f3718a).start();
    }

    @Override // com.json.of
    public void a(nh nhVar, String str, int i, int i2, Handler handler) {
        b(nhVar, str, i, i2, handler).start();
    }

    @Override // com.json.of
    public void a(po poVar) {
        this.f3718a.a(poVar);
    }

    public boolean c() {
        Thread thread = this.c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f = null;
        fb fbVar = this.f3718a;
        if (fbVar != null) {
            fbVar.a();
            this.f3718a = null;
        }
    }
}
