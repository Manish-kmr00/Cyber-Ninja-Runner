package sg.bigo.ads.common.u.b;

import android.content.Context;
import android.text.TextUtils;
import com.json.cc;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.u.a;
import sg.bigo.ads.common.u.f;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes10.dex */
public class b<T extends sg.bigo.ads.common.u.a> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13272a = f.a("text/plain;charset=utf-8");
    public JSONObject b;
    public byte[] c;
    public f d;
    public boolean e;
    public boolean f;
    public int g;
    public String h;
    private String o;

    public b(int i, T t, Context context) {
        super(i, t, true, context);
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final String a() {
        return "POST";
    }

    protected final void a(Map<String, Object> map) {
        if (this.b == null || k.a(map)) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                this.b.putOpt(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        this.c = null;
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final f b() {
        f fVar = this.d;
        return fVar != null ? fVar : f13272a;
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final byte[] c() {
        JSONObject jSONObject;
        if (this.c == null && (jSONObject = this.b) != null) {
            String string = jSONObject.toString();
            this.o = string;
            try {
                if (this.e) {
                    String strA = sg.bigo.ads.common.j.a.a(string, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
                    if (TextUtils.isEmpty(strA)) {
                        this.f = false;
                    } else {
                        this.f = true;
                        this.o = strA;
                        a("enc", "1");
                    }
                }
            } catch (Exception unused) {
                this.f = false;
            }
            try {
                this.c = this.o.getBytes(cc.N);
            } catch (UnsupportedEncodingException unused2) {
            }
        }
        return this.c;
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final String d() {
        return e() >= 0 ? this.o : "content is null.";
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final int e() {
        byte[] bArrC = c();
        return bArrC != null ? bArrC.length : super.e();
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final boolean f() {
        return this.f;
    }
}
