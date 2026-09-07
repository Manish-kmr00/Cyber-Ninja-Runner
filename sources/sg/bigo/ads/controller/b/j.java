package sg.bigo.ads.controller.b;

import com.smaato.sdk.core.dns.DnsName;
import org.json.JSONObject;
import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f13415a;

    public j(JSONObject jSONObject) {
        this.f13415a = jSONObject;
    }

    private Object d(String str) {
        String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
        if (strArrSplit.length == 0) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = this.f13415a;
        for (int i = 0; i < strArrSplit.length - 1; i++) {
            jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject(strArrSplit[i]);
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
        }
        return jSONObjectOptJSONObject.opt(strArrSplit[strArrSplit.length - 1]);
    }

    @Override // sg.bigo.ads.api.a.m
    public final int a(String str) {
        Integer numA = sg.bigo.ads.common.utils.j.a(d(str));
        if (numA != null) {
            return numA.intValue();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.a.m
    public final int a(String str, int i) {
        Integer numA = sg.bigo.ads.common.utils.j.a(d(str));
        return numA != null ? numA.intValue() : i;
    }

    @Override // sg.bigo.ads.api.a.m
    public final float b(String str) {
        Float fB = sg.bigo.ads.common.utils.j.b(d(str));
        if (fB != null) {
            return fB.floatValue();
        }
        return 0.0f;
    }

    @Override // sg.bigo.ads.api.a.m
    public final boolean c(String str) {
        return a(str) == 1;
    }

    public final String toString() {
        return this.f13415a.toString();
    }
}
