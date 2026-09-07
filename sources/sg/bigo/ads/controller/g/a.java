package sg.bigo.ads.controller.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.json.fe;
import com.mbridge.msdk.MBridgeConstans;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.u.a;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a<T extends sg.bigo.ads.common.u.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f13467a;
    protected final sg.bigo.ads.common.g b;
    protected final sg.bigo.ads.controller.a.b c;
    protected final long d;
    protected final String e;
    protected final String f;
    protected final String g;
    public final q h;
    private final sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.b, sg.bigo.ads.common.u.c.d> i;

    /* JADX INFO: renamed from: sg.bigo.ads.controller.g.a$a, reason: collision with other inner class name */
    static class C0886a extends sg.bigo.ads.common.u.b.b<sg.bigo.ads.controller.a.f> {
        private final long o;

        public C0886a(Context context, int i, sg.bigo.ads.controller.a.f fVar, long j) {
            super(i, fVar, context);
            this.o = j;
        }

        @Override // sg.bigo.ads.common.u.b.c
        public final void h() {
            super.h();
            sg.bigo.ads.controller.a.f fVar = (sg.bigo.ads.controller.a.f) this.j;
            HashMap map = new HashMap();
            map.put("pre_host", fVar.f());
            map.put("host_cfg_clear", Integer.valueOf(fVar.h() ? 1 : 0));
            map.put("host_src", fVar.i());
            sg.bigo.ads.controller.a.j jVarG = fVar.g();
            if (jVarG != null) {
                map.put("host_type", Integer.valueOf(jVarG.d()));
            }
            a(map);
            long j = this.o;
            if (j > 0) {
                fVar.a(j);
            }
        }
    }

    public interface b {
        void a(String str, Object obj);
    }

    public a(sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar) {
        this(gVar, bVar, 15000L);
    }

    public a(sg.bigo.ads.common.g gVar, sg.bigo.ads.controller.a.b bVar, long j) {
        this.h = new q();
        this.i = new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.b, sg.bigo.ads.common.u.c.d>() { // from class: sg.bigo.ads.controller.g.a.1
            private long b = -1;
            private boolean c = false;

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ sg.bigo.ads.common.u.c.c a(sg.bigo.ads.common.u.c.a aVar) {
                return new sg.bigo.ads.common.u.c.d(aVar);
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar) {
                super.a((sg.bigo.ads.common.u.b.b) cVar);
                this.b = SystemClock.elapsedRealtime();
                this.c = sg.bigo.ads.common.f.b.d();
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.c.c cVar2) {
                sg.bigo.ads.common.u.b.b bVar2 = (sg.bigo.ads.common.u.b.b) cVar;
                sg.bigo.ads.common.u.c.d dVar = (sg.bigo.ads.common.u.c.d) cVar2;
                String strA = dVar.a();
                if (bVar2.f) {
                    try {
                        if (TextUtils.isEmpty(strA) || !strA.trim().startsWith("{")) {
                            String strA2 = sg.bigo.ads.common.j.a.a(strA, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F", null);
                            if (TextUtils.isEmpty(strA2)) {
                                bVar2.g = 0;
                            } else {
                                try {
                                    bVar2.g = 1;
                                    strA = strA2;
                                } catch (Exception unused) {
                                    strA = strA2;
                                    bVar2.g = 2;
                                    try {
                                        bVar2.h = dVar.a("logid");
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        } else {
                            bVar2.g = 3;
                        }
                        bVar2.h = dVar.a("logid");
                    } catch (Exception unused3) {
                    }
                }
                q qVar = a.this.h;
                boolean z = bVar2.e;
                boolean z2 = bVar2.f;
                int i = bVar2.g;
                String str = bVar2.h;
                qVar.f13114a = z;
                qVar.b = z2;
                qVar.c = i;
                qVar.d = str;
                if (bVar2.e && (!bVar2.f || bVar2.g != 1)) {
                    if (bVar2.f) {
                        a.this.i();
                    } else {
                        sg.bigo.ads.common.x.a.t();
                    }
                }
                sg.bigo.ads.controller.h.a aVar = new sg.bigo.ads.controller.h.a(strA);
                if (aVar.a()) {
                    a.this.a(bVar2.g(), aVar.c, aVar.d);
                } else {
                    a.this.a(bVar2.g(), 1005, aVar.f13472a, aVar.b, aVar.d);
                }
                a.a(a.this, sg.bigo.ads.common.utils.l.a(aVar.d, "host_cfg"), bVar2.g(), this.b);
                if (a.this.g()) {
                    long jElapsedRealtime = this.b > 0 ? SystemClock.elapsedRealtime() - this.b : 0L;
                    T t = bVar2.j;
                    sg.bigo.ads.core.d.b.a(bVar2.g(), t.e() ? t.d() : "", true, jElapsedRealtime, dVar.f13277a.f13275a, "", this.c, bVar2.e(), a.this.e, a.this.f, a.this.g, a.this.b != null ? a.this.b.X() : null, bVar2.e, bVar2.f, bVar2.g, bVar2.h);
                }
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.h hVar) {
                int i;
                String str;
                sg.bigo.ads.common.u.b.b bVar2 = (sg.bigo.ads.common.u.b.b) cVar;
                if (a.this.g()) {
                    long jElapsedRealtime = this.b > 0 ? SystemClock.elapsedRealtime() - this.b : 0L;
                    String strG = bVar2.g();
                    if (hVar.f13280a == 900) {
                        strG = "https://invalid.url";
                    }
                    String str2 = strG;
                    T t = bVar2.j;
                    sg.bigo.ads.core.d.b.a(str2, t.e() ? t.d() : "", false, jElapsedRealtime, hVar.f13280a, hVar.getMessage(), this.c, bVar2.e(), a.this.e, a.this.f, a.this.g, a.this.b == null ? null : a.this.b.X(), bVar2.e, bVar2.f, bVar2.g, bVar2.h);
                }
                if (hVar.f13280a == 701 || hVar.f13280a == 702) {
                    i = 1025;
                    str = "Request timeout.";
                } else {
                    str = "(" + hVar.f13280a + ") " + hVar.getMessage();
                    i = 1026;
                }
                a.this.a(bVar2.g(), i, hVar.f13280a, str, null);
                a.this.a(bVar2.g());
            }
        };
        this.f13467a = sg.bigo.ads.common.y.a.a();
        this.b = gVar;
        this.c = bVar;
        this.d = j;
        this.e = gVar.Q();
        this.f = gVar.R();
        this.g = gVar.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.c == null || !h()) {
            return;
        }
        this.c.a(100L, str);
    }

    static /* synthetic */ void a(a aVar, final String str, final String str2, final long j) {
        if (aVar.c != null) {
            if (TextUtils.isEmpty(str)) {
                aVar.a(str2);
            } else {
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.g.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.c == null || a.this.c.a(str, str2, j, a.this.g()).d == 0) {
                            return;
                        }
                        a.this.a(str2);
                    }
                });
            }
        }
    }

    public final int a() {
        return this.f13467a;
    }

    protected StringBuilder a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(sg.bigo.ads.common.utils.q.a(this.b.a()));
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.b()));
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.c()));
        sb.append(StringUtils.COMMA).append(this.b.d());
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.i()));
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.j()));
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.y()));
        sb.append(",50201,");
        sb.append(j);
        if (sg.bigo.ads.common.x.a.p()) {
            sb.append(",,,");
            sb.append(sg.bigo.ads.common.utils.q.a(this.b.C()));
            sb.append(StringUtils.COMMA);
        } else {
            sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.A()));
            sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.B()));
            sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.C()));
            sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(this.b.G()));
        }
        sb.append(StringUtils.COMMA).append(sg.bigo.ads.common.utils.q.a(str));
        return sb;
    }

    protected abstract void a(int i, int i2, String str);

    protected void a(String str, int i, int i2, String str2, Map<String, Object> map) {
        a(i, i2, str2);
    }

    protected void a(String str, String str2, Map<String, Object> map) {
        a(str2, map);
    }

    protected abstract void a(String str, Map<String, Object> map);

    protected abstract void a(b bVar);

    public final void b() {
        final JSONObject jSONObject;
        String str;
        Object objA;
        String str2;
        sg.bigo.ads.common.u.a aVarF = f();
        sg.bigo.ads.common.u.b.b c0886a = aVarF instanceof sg.bigo.ads.controller.a.f ? new C0886a(this.b.af(), this.f13467a, (sg.bigo.ads.controller.a.f) aVarF, e()) : new sg.bigo.ads.common.u.b.b(this.f13467a, aVarF, this.b.af());
        boolean z = false;
        int i = 0;
        z = false;
        if (sg.bigo.ads.common.x.a.p() && !(this instanceof l)) {
            String str3 = "Missing CCPA consent";
            if (sg.bigo.ads.common.x.a.l() == 2) {
                str2 = "Missing GDPR consent";
                i = 1;
            } else {
                str2 = "Missing CCPA consent";
            }
            if (sg.bigo.ads.common.x.a.n() == 2) {
                i++;
                str2 = "Missing LGPD consent";
            }
            if (sg.bigo.ads.common.x.a.m() == 2) {
                i++;
            } else {
                str3 = str2;
            }
            if (sg.bigo.ads.common.x.a.o() == 2) {
                i++;
                str3 = "Missing COPPA consent";
            }
            if (i > 1) {
                str3 = "Missing user consent";
            }
            this.i.a(c0886a, new sg.bigo.ads.common.u.h(800, str3));
            return;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.putOpt(MBridgeConstans.APP_KEY, sg.bigo.ads.common.utils.q.a(this.b.a()));
            jSONObject.putOpt("pkg_name", sg.bigo.ads.common.utils.q.a(this.b.b()));
            jSONObject.putOpt("pkg_ver", sg.bigo.ads.common.utils.q.a(this.b.c()));
            jSONObject.putOpt("pkg_vc", Integer.valueOf(this.b.d()));
            jSONObject.putOpt("pkg_ch", this.b.e());
            jSONObject.putOpt("os", sg.bigo.ads.common.utils.q.a(this.b.i()));
            jSONObject.putOpt("os_ver", sg.bigo.ads.common.utils.q.a(this.b.j()));
            jSONObject.putOpt("os_lang", this.b.k());
            jSONObject.putOpt("vendor", this.b.l());
            jSONObject.putOpt("model", this.b.m());
            jSONObject.putOpt("isp", this.b.n());
            jSONObject.putOpt("resolution", this.b.o());
            jSONObject.putOpt("dpi", Integer.valueOf(this.b.p()));
            jSONObject.putOpt("dpi_f", this.b.q());
            jSONObject.putOpt("net", this.b.r());
            jSONObject.putOpt("timezone", this.b.s());
            jSONObject.putOpt("country", this.b.t());
            jSONObject.putOpt("state", this.b.w());
            jSONObject.putOpt(POBConstants.KEY_CITY, this.b.x());
            jSONObject.putOpt("sdk_ver", sg.bigo.ads.common.utils.q.a(this.b.y()));
            jSONObject.putOpt("sdk_vc", 50201);
            if (sg.bigo.ads.common.x.a.p()) {
                str = "consent_status";
                objA = Integer.valueOf(sg.bigo.ads.core.d.b.b());
            } else {
                jSONObject.putOpt(fe.Q0, sg.bigo.ads.common.utils.q.a(this.b.A()));
                jSONObject.putOpt("hw_id", sg.bigo.ads.common.utils.q.a(this.b.G()));
                jSONObject.putOpt("fire_id", sg.bigo.ads.common.utils.q.a(this.b.ae()));
                str = "af_id";
                objA = sg.bigo.ads.common.utils.q.a(this.b.B());
            }
            jSONObject.putOpt(str, objA);
            jSONObject.putOpt("uid", sg.bigo.ads.common.utils.q.a(this.b.C()));
            long jD = this.b.D();
            jSONObject.putOpt("timestamp", Long.valueOf(jD));
            jSONObject.putOpt("abflags", this.b.E());
            jSONObject.putOpt("gg_service_ver", this.b.H());
            jSONObject.putOpt("webkit_ver", this.b.I());
            jSONObject.putOpt("cpu_core_num", Integer.valueOf(this.b.J()));
            jSONObject.putOpt("cpu_clock_speed", Long.valueOf(this.b.K()));
            jSONObject.putOpt("total_memory", Long.valueOf(this.b.L()));
            jSONObject.putOpt("free_memory", Long.valueOf(this.b.M()));
            jSONObject.putOpt("rom_free_in", Long.valueOf(this.b.N()));
            jSONObject.putOpt("rom_free_ext", Long.valueOf(this.b.O()));
            String string = UUID.randomUUID().toString();
            jSONObject.putOpt("request_id", sg.bigo.ads.common.utils.q.a(string));
            jSONObject.putOpt("sdk_channel", this.b.aa());
            jSONObject.putOpt("simulator_file", Integer.valueOf(this.b.ab()));
            jSONObject.putOpt("gps_country", this.e);
            jSONObject.putOpt("sim_country", this.f);
            jSONObject.putOpt("system_country", this.g);
            jSONObject.putOpt("inst_src", this.b.T());
            a(new b() { // from class: sg.bigo.ads.controller.g.a.3
                @Override // sg.bigo.ads.controller.g.a.b
                public final void a(String str4, Object obj) {
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    try {
                        jSONObject.putOpt(str4, obj);
                    } catch (JSONException unused) {
                    }
                }
            });
            jSONObject.putOpt("sign", sg.bigo.ads.common.utils.m.a(a(jD, string).toString()));
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (sg.bigo.ads.common.x.a.s() && j()) {
            z = true;
        }
        sg.bigo.ads.common.u.f fVarD = d();
        c0886a.b = jSONObject;
        c0886a.c = null;
        c0886a.d = fVarD;
        c0886a.e = z;
        c0886a.l = this.d;
        c0886a.a("SDK-Version-Code", BigoAdSdk.getSDKVersion());
        c0886a.k = c();
        sg.bigo.ads.common.u.b bVar = this.i;
        if (bVar == null) {
            bVar = sg.bigo.ads.common.u.b.d;
        }
        sg.bigo.ads.common.u.g.f13279a.a(c0886a, bVar);
    }

    protected abstract sg.bigo.ads.common.n.e c();

    protected sg.bigo.ads.common.u.f d() {
        return sg.bigo.ads.common.u.b.b.f13272a;
    }

    protected long e() {
        return 0L;
    }

    protected abstract T f();

    protected boolean g() {
        return true;
    }

    protected boolean h() {
        return true;
    }

    protected abstract void i();

    protected abstract boolean j();
}
