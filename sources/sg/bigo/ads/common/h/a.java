package sg.bigo.ads.common.h;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.f;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13189a;
    public String b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    long m;
    public String p;
    public final boolean q;
    private c s;
    public int j = 0;
    public int k = 0;
    public long l = 0;
    public boolean n = false;
    public boolean o = false;
    private C0866a r = new C0866a();

    /* JADX INFO: renamed from: sg.bigo.ads.common.h.a$a, reason: collision with other inner class name */
    public static class C0866a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13190a = -1;
        public boolean b = false;

        final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("support_pd_flag", Integer.valueOf(this.f13190a));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, c cVar) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z ? 1 : 0;
        this.f = z3;
        this.q = z2;
        String strA = a();
        long jA = f.a(strA, 1);
        this.g = jA <= 0 ? f.a(f.d(strA), 1) : jA;
        String strValueOf = String.valueOf(str.hashCode());
        this.f13189a = strValueOf;
        this.s = cVar;
        sg.bigo.ads.common.t.a.a(0, 3, "DownloadInfo", "newInstance mId = " + strValueOf + ", savedSize = " + this.g + ", mIsSupportFillTime = " + c());
    }

    public final String a() {
        return this.c + File.separator + this.d;
    }

    public final boolean b() {
        return this.j == 3;
    }

    public final boolean c() {
        c cVar = this.s;
        return cVar != null && cVar.f13205a;
    }

    public final boolean d() {
        c cVar = this.s;
        return cVar != null && cVar.b;
    }

    public final int e() {
        c cVar = this.s;
        if (cVar != null) {
            return cVar.c;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.c.equals(aVar.c);
    }

    public final int f() {
        c cVar = this.s;
        if (cVar != null) {
            return cVar.d;
        }
        return 5;
    }

    public final int g() {
        c cVar = this.s;
        if (cVar != null) {
            return cVar.e;
        }
        return 20;
    }

    public final boolean h() {
        if (this.b.endsWith(".mp4") && this.r.f13190a == -1) {
            if (f.a(f.d(a()))) {
                this.r.f13190a = 1;
            } else {
                this.r.f13190a = 0;
            }
        }
        return this.r.f13190a == 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" url = ");
        sb.append(this.b).append(", fileName = ");
        sb.append(this.d).append(", filePath = ");
        sb.append(this.c).append(", downloadCount = ");
        sb.append(this.k).append(", totalSize = ");
        sb.append(this.i).append(", loadedSize = ");
        sb.append(this.g).append(", mState = ");
        sb.append(this.j).append(", mLastDownloadEndTime = ");
        sb.append(this.l).append(", mExt = ");
        sb.append(this.r.a()).append(", contentType = ");
        sb.append(this.p);
        sb.append(" isSupportFillTime = ").append(c());
        sb.append(" adFillTime = ").append(e());
        sb.append(" adCheckProcessTime = ").append(f());
        sb.append(" adCheckMinProcess = ").append(g());
        return sb.toString();
    }
}
