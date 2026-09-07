package com.json.sdk.controller;

import com.json.b9;
import com.json.cc;
import com.json.er;
import com.json.gb;
import com.json.gh;
import com.json.lh;
import com.json.nh;
import com.json.o9;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class d {
    static final String h = "controllerSourceData";
    private static final String i = "next_";
    private static final String j = "fallback_";
    private static final String k = "controllerSourceCode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4289a;
    private int b;
    private c c;
    private EnumC0403d d = EnumC0403d.NONE;
    private String e;
    private String f;
    private gb g;

    class a extends JSONObject {
        a() throws JSONException {
            putOpt(b9.a.j, Integer.valueOf(d.this.b));
            putOpt(d.k, Integer.valueOf(d.this.d.a()));
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4291a;

        static {
            int[] iArr = new int[c.values().length];
            f4291a = iArr;
            try {
                iArr[c.FETCH_FROM_SERVER_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4291a[c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4291a[c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum c {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.d$d, reason: collision with other inner class name */
    public enum EnumC0403d {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4293a;

        EnumC0403d(int i) {
            this.f4293a = i;
        }

        public int a() {
            return this.f4293a;
        }
    }

    d(JSONObject jSONObject, String str, String str2, gb gbVar) {
        int iOptInt = jSONObject.optInt(b9.a.j, -1);
        this.b = iOptInt;
        this.c = a(iOptInt);
        this.e = str;
        this.f = str2;
        this.g = gbVar;
    }

    private c a(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? c.FETCH_FROM_SERVER_NO_FALLBACK : c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL;
        }
        return c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private void a(nh nhVar) {
        if (this.g.c()) {
            return;
        }
        this.g.a(nhVar, this.f);
    }

    private void a(EnumC0403d enumC0403d) {
        gh ghVarA = new gh().a(cc.y, Integer.valueOf(this.b)).a(cc.z, Integer.valueOf(enumC0403d.a()));
        if (this.f4289a > 0) {
            ghVarA.a(cc.B, Long.valueOf(System.currentTimeMillis() - this.f4289a));
        }
        lh.a(er.w, ghVarA.a());
    }

    private boolean a() {
        try {
            if (j()) {
                return IronSourceStorageUtils.renameFile(h().getPath(), g().getPath());
            }
            return false;
        } catch (Exception e) {
            o9.d().a(e);
            return false;
        }
    }

    private boolean b() throws Exception {
        return IronSourceStorageUtils.renameFile(i().getPath(), g().getPath());
    }

    private void c() {
        try {
            nh nhVarG = g();
            if (nhVarG.exists()) {
                nh nhVarH = h();
                if (nhVarH.exists()) {
                    nhVarH.delete();
                }
                IronSourceStorageUtils.renameFile(nhVarG.getPath(), nhVarH.getPath());
            }
        } catch (Exception e) {
            o9.d().a(e);
        }
    }

    private void d() {
        IronSourceStorageUtils.deleteFile(h());
    }

    private void e() {
        IronSourceStorageUtils.deleteFile(g());
    }

    private nh h() {
        return new nh(this.e, "fallback_mobileController.html");
    }

    private nh i() {
        return new nh(this.e, "next_mobileController.html");
    }

    private boolean j() {
        return h().exists();
    }

    private void l() {
        gh ghVarA = new gh().a(cc.y, Integer.valueOf(this.b));
        if (this.f4289a > 0) {
            ghVarA.a(cc.B, Long.valueOf(System.currentTimeMillis() - this.f4289a));
        }
        lh.a(er.x, ghVarA.a());
    }

    void a(gh ghVar) {
        ghVar.a(cc.y, Integer.valueOf(this.b));
        lh.a(er.v, ghVar.a());
        this.f4289a = System.currentTimeMillis();
    }

    void a(Runnable runnable) {
        if (m()) {
            return;
        }
        if (this.c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
            d();
        }
        EnumC0403d enumC0403d = EnumC0403d.CONTROLLER_FROM_SERVER;
        this.d = enumC0403d;
        a(enumC0403d);
        runnable.run();
    }

    void a(Runnable runnable, Runnable runnable2) {
        if (m()) {
            return;
        }
        if (this.c != c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK || !a()) {
            l();
            runnable2.run();
        } else {
            EnumC0403d enumC0403d = EnumC0403d.FALLBACK_CONTROLLER_RECOVERY;
            this.d = enumC0403d;
            a(enumC0403d);
            runnable.run();
        }
    }

    JSONObject f() throws JSONException {
        return SafeIronSourceControllerBridge.com_ironsource_sdk_controller_d$a_jsonObjectInit(this);
    }

    nh g() {
        return new nh(this.e, b9.f);
    }

    boolean k() {
        nh nhVar;
        int i2 = b.f4291a[this.c.ordinal()];
        if (i2 == 1) {
            e();
            nhVar = new nh(this.e, SDKUtils.getFileName(this.f));
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    try {
                        nh nhVarG = g();
                        nh nhVarI = i();
                        if (!nhVarI.exists() && !nhVarG.exists()) {
                            a(new nh(this.e, SDKUtils.getFileName(this.f)));
                            return false;
                        }
                        if (!nhVarI.exists() && nhVarG.exists()) {
                            EnumC0403d enumC0403d = EnumC0403d.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            this.d = enumC0403d;
                            a(enumC0403d);
                            a(new nh(this.e, nhVarI.getName()));
                            return true;
                        }
                        c();
                        if (b()) {
                            EnumC0403d enumC0403d2 = EnumC0403d.PREPARED_CONTROLLER_LOADED;
                            this.d = enumC0403d2;
                            a(enumC0403d2);
                            d();
                            a(new nh(this.e, nhVarI.getName()));
                            return true;
                        }
                        if (!a()) {
                            a(new nh(this.e, SDKUtils.getFileName(this.f)));
                            return false;
                        }
                        EnumC0403d enumC0403d3 = EnumC0403d.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        this.d = enumC0403d3;
                        a(enumC0403d3);
                        a(new nh(this.e, nhVarI.getName()));
                        return true;
                    } catch (Exception e) {
                        o9.d().a(e);
                    }
                }
                return false;
            }
            c();
            nhVar = new nh(this.e, SDKUtils.getFileName(this.f));
        }
        a(nhVar);
        return false;
    }

    boolean m() {
        return this.d != EnumC0403d.NONE;
    }
}
