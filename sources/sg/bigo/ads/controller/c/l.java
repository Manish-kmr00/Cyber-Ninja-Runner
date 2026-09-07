package sg.bigo.ads.controller.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.u;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends b implements sg.bigo.ads.core.a.a {
    private static final AtomicInteger N = new AtomicInteger();
    protected String D;
    protected sg.bigo.ads.api.core.o.a E;
    protected sg.bigo.ads.api.core.o.a[] F;
    protected sg.bigo.ads.api.core.o.c G;
    protected int H;
    protected int I;
    protected sg.bigo.ads.api.core.o.b J;
    protected sg.bigo.ads.api.core.o.d K;
    public int L;
    protected sg.bigo.ads.api.core.i.b M;
    private sg.bigo.ads.core.f.a.p O;
    private sg.bigo.ads.api.core.n P;
    private boolean Q;
    private String R;
    private int S;
    private int T;
    private long U;
    private sg.bigo.ads.core.f.a.a.C0894a V;
    private sg.bigo.ads.core.f.a.a.C0894a W;
    private boolean X;
    private boolean Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private Pair<Bitmap, String> ad;
    private boolean ae;
    private final String af;
    private String ag;
    private boolean ah;
    private u ai;

    protected l(long j, sg.bigo.ads.api.core.h hVar, sg.bigo.ads.api.a.l lVar, JSONObject jSONObject) {
        super(j, hVar, lVar, jSONObject);
        this.I = 0;
        this.L = 0;
        this.Q = false;
        this.S = 0;
        this.T = 0;
        this.X = false;
        this.Y = false;
        this.Z = 4;
        this.aa = 6;
        this.ab = 4;
        this.ac = 0;
        this.ae = false;
        this.D = jSONObject.optString("iurl");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("icon");
        if (jSONObjectOptJSONObject != null) {
            this.E = new i(jSONObjectOptJSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    arrayList.add(new i(jSONObjectOptJSONObject2));
                }
            }
            i[] iVarArr = new i[arrayList.size()];
            this.F = iVarArr;
            this.F = (sg.bigo.ads.api.core.o.a[]) arrayList.toArray(iVarArr);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject3 != null) {
            this.G = new q(jSONObjectOptJSONObject3);
        }
        this.J = new j(jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_play_cfg");
        if (jSONObjectOptJSONObject4 != null) {
            this.K = new r(jSONObjectOptJSONObject4);
        }
        this.H = jSONObject.optInt("immersive_ad_type", 0);
        try {
            if (1 == this.A) {
                List<sg.bigo.ads.api.core.c> list = this.f13416a;
                if (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
                    sg.bigo.ads.api.a.m mVar = this.y;
                    if (mVar == null || mVar.a("multi_ads.multi_ads_type") != 1) {
                        this.I = 1;
                    } else {
                        this.I = 2;
                    }
                    for (sg.bigo.ads.api.core.c cVar : list) {
                        if (cVar instanceof l) {
                            ((l) cVar).I = this.I;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("display");
        if (jSONObjectOptJSONObject5 != null) {
            this.M = new h(jSONObjectOptJSONObject5);
        }
        this.af = this.l + "_" + this.c + "_" + N.addAndGet(1);
    }

    private sg.bigo.ads.core.f.a.b bp() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.n;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String a(Context context) {
        return aR() ? sg.bigo.ads.common.o.c(context) : sg.bigo.ads.common.o.b(context);
    }

    @Override // sg.bigo.ads.api.core.o
    public final void a(Pair<Bitmap, String> pair) {
        this.ad = pair;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void a(sg.bigo.ads.api.core.n nVar) {
        sg.bigo.ads.api.core.n nVar2 = this.P;
        if (nVar2 == null || nVar2.c <= 0 || nVar.c != 0) {
            this.P = nVar;
        }
    }

    @Override // sg.bigo.ads.core.a.a
    public final void a(sg.bigo.ads.core.f.a.a.C0894a c0894a) {
        this.V = c0894a;
    }

    @Override // sg.bigo.ads.core.a.a
    public final void a(sg.bigo.ads.core.f.a.p pVar) {
        this.O = pVar;
        if (pVar != null && sg.bigo.ads.common.utils.q.b((CharSequence) pVar.m)) {
            N().a(this.O.m);
        }
        this.K.a(aT());
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.o.d aA() {
        return this.K;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aB() {
        return this.S;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aC() {
        return this.T;
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aD() {
        return this.U;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aE() {
        sg.bigo.ads.core.f.a.a.C0894a c0894a = this.W;
        return c0894a != null && c0894a.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aF() {
        sg.bigo.ads.core.f.a.a.C0894a c0894a = this.V;
        return c0894a != null && c0894a.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aG() {
        return this.I;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aH() {
        return this.ag;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aI() {
        return !TextUtils.isEmpty(this.af) ? this.af : String.valueOf(this.j);
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aJ() {
        sg.bigo.ads.core.f.a.b bVarBp = bp();
        if (bVarBp != null) {
            return bVarBp.c;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aK() {
        sg.bigo.ads.api.core.o.d dVar = this.K;
        if (dVar != null) {
            return dVar.a();
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aL() {
        return this.L;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aM() {
        sg.bigo.ads.core.f.a.b bVarBp = bp();
        String str = bVarBp != null ? bVarBp.e : null;
        if (sg.bigo.ads.common.utils.q.b((CharSequence) str)) {
            return str;
        }
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.o;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aN() {
        sg.bigo.ads.api.core.o.d dVar;
        if (!aR() && (dVar = this.K) != null && dVar.b() && dVar.c() < 100) {
            sg.bigo.ads.core.f.a.b bVarBp = bp();
            if (bVarBp != null ? "video/mp4".equals(bVarBp.d) : false) {
                return true;
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aO() {
        return aJ();
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aP() {
        String strAM = aM();
        return sg.bigo.ads.common.utils.q.a((CharSequence) strAM) ? new StringBuilder().append(hashCode()).toString() : strAM;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aQ() {
        return this.h == 2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aR() {
        sg.bigo.ads.core.f.a.b bVarBp = bp();
        return bVarBp != null && bVarBp.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aS() {
        sg.bigo.ads.api.core.o.a aVar;
        sg.bigo.ads.api.core.o.a[] aVarArr = this.F;
        if (aVarArr == null || aVarArr.length <= 0 || (aVar = aVarArr[0]) == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aT() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.s;
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.n aU() {
        return this.P;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aV() {
        return this.Q;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void aW() {
        this.Q = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aX() {
        String strAS;
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.R)) {
            return this.R;
        }
        if (aQ()) {
            sg.bigo.ads.core.f.a.b bVarBp = bp();
            if (bVarBp != null) {
                this.R = bVarBp.d;
            }
            if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.R)) {
                return this.R;
            }
            strAS = aJ();
        } else {
            strAS = aS();
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(strAS));
        this.R = mimeTypeFromExtension;
        return mimeTypeFromExtension;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aY() {
        return this.ae;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void aZ() {
        this.ae = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.o.a au() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.i.b av() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.o.a[] aw() {
        return this.F;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.o.c ax() {
        return this.G;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String ay() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.core.o
    public final sg.bigo.ads.api.core.o.b az() {
        return this.J;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String b(Context context) {
        return a(context) + File.separator + aP();
    }

    @Override // sg.bigo.ads.api.core.o
    public final void b(long j) {
        this.U = j;
    }

    @Override // sg.bigo.ads.core.a.a
    public final void b(sg.bigo.ads.core.f.a.a.C0894a c0894a) {
        this.W = c0894a;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean ba() {
        return this.X;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bb() {
        this.X = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bc() {
        return this.Z;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bd() {
        return this.aa;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int be() {
        return this.ab;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bf() {
        return this.ac;
    }

    @Override // sg.bigo.ads.api.core.o
    public final Pair<Bitmap, String> bg() {
        return this.ad;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean bh() {
        return this.Y;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bi() {
        this.Y = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bj() {
        this.ah = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean bk() {
        return this.ah;
    }

    @Override // sg.bigo.ads.core.a.a
    public final sg.bigo.ads.core.f.a.a.C0894a bl() {
        return this.V;
    }

    @Override // sg.bigo.ads.core.a.a
    public final sg.bigo.ads.core.f.a.a.C0894a bm() {
        return this.W;
    }

    @Override // sg.bigo.ads.core.a.a
    public final u bn() {
        if (this.ai == null) {
            this.ai = new u(this.C);
        }
        return this.ai;
    }

    @Override // sg.bigo.ads.core.a.a
    public final sg.bigo.ads.core.f.a.p bo() {
        return this.O;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String c(Context context) {
        Pair pair;
        if (!aN()) {
            this.L = 0;
            return b(context);
        }
        sg.bigo.ads.core.player.a.d dVarB = sg.bigo.ads.core.player.b.a().b();
        String strAJ = aJ();
        String strA = a(context);
        String strAP = aP();
        File file = new File(strA, strAP);
        if (file.exists()) {
            pair = new Pair(Uri.fromFile(file).toString(), 1);
        } else if (dVarB.a()) {
            StringBuilder sb = new StringBuilder(strAJ);
            if (strAJ.contains("?")) {
                sb.append(b9.i.c);
            } else {
                sb.append("?");
            }
            sb.append("path=").append(strA).append("&name=");
            sb.append(strAP);
            pair = new Pair(String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(dVarB.c), sg.bigo.ads.common.utils.q.e(sb.toString())), 2);
        } else {
            pair = new Pair(strAJ, 3);
        }
        this.L = ((Integer) pair.second).intValue();
        return (String) pair.first;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void c(String str) {
        if (this.I == 2) {
            this.I = 3;
            List<sg.bigo.ads.api.core.c> list = this.f13416a;
            if (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
                for (sg.bigo.ads.api.core.c cVar : list) {
                    if (cVar instanceof l) {
                        ((l) cVar).I = this.I;
                    }
                }
            }
        }
        if (this.ag == null) {
            this.ag = str;
        } else {
            this.ag += StringUtils.COMMA + str;
        }
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean c(long j) {
        sg.bigo.ads.api.core.o.d dVar = this.K;
        return j >= ((long) (dVar != null ? dVar.c() : 50));
    }

    @Override // sg.bigo.ads.api.core.o
    public final void d(String str) {
        if ("video/mp4".equals(this.R) || sg.bigo.ads.common.utils.q.a((CharSequence) str)) {
            return;
        }
        this.R = str;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void f(int i) {
        this.S = i;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void g(int i) {
        this.T = i;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void h(int i) {
        this.Z = i;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void i(int i) {
        this.aa = i;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void j(int i) {
        this.ab = i;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void k(int i) {
        this.ac = i;
    }

    @Override // sg.bigo.ads.controller.c.b, sg.bigo.ads.api.core.c
    public final String s() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        return (pVar == null || !sg.bigo.ads.common.utils.q.b((CharSequence) pVar.p)) ? super.s() : this.O.p;
    }

    @Override // sg.bigo.ads.controller.c.b, sg.bigo.ads.api.core.c
    public final String t() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        return (pVar == null || !sg.bigo.ads.common.utils.q.b((CharSequence) pVar.q)) ? super.t() : this.O.q;
    }
}
