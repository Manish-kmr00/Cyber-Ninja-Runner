package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class s implements sg.bigo.ads.api.a.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13116a = 0;
    private long b = 5000;
    private long c = 21600000;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(this.f13116a + StringUtils.COMMA + this.b + StringUtils.COMMA + this.c);
    }

    @Override // sg.bigo.ads.api.a.n
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13116a = jSONObject.optInt("duration_on", 0);
            this.b = jSONObject.optLong("duration_valid_interval", 5000L);
            this.c = jSONObject.optLong("suspend_limit", 21600000L);
        }
    }

    @Override // sg.bigo.ads.api.a.n
    public final boolean a() {
        return this.f13116a == 1;
    }

    @Override // sg.bigo.ads.api.a.n
    public final long b() {
        return this.b;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            String string = parcel.readString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] strArrSplit = string.split(StringUtils.COMMA);
            if (strArrSplit.length >= 3) {
                this.f13116a = sg.bigo.ads.common.utils.q.a(strArrSplit[0], 0);
                this.b = sg.bigo.ads.common.utils.q.a(strArrSplit[1], 5000L);
                this.c = sg.bigo.ads.common.utils.q.a(strArrSplit[2], 21600000L);
            }
        }
    }

    @Override // sg.bigo.ads.api.a.n
    public final long c() {
        return this.c;
    }
}
