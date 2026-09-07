package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements sg.bigo.ads.api.a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13110a = 2;
    private int b = 3;
    private int c = 5;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(this.f13110a + StringUtils.COMMA + this.b + StringUtils.COMMA + this.c);
    }

    @Override // sg.bigo.ads.api.a.g
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13110a = jSONObject.optInt("id_show_loading", 2);
            this.b = jSONObject.optInt("loading_timeout", 3);
            this.c = jSONObject.optInt("material_show_close_button", 5);
        }
    }

    @Override // sg.bigo.ads.api.a.g
    public final boolean a() {
        return this.f13110a == 2;
    }

    @Override // sg.bigo.ads.api.a.g
    public final int b() {
        return this.b;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        String[] strArrSplit;
        if (parcel.dataAvail() > 0) {
            String string = parcel.readString();
            if (TextUtils.isEmpty(string) || (strArrSplit = string.split(StringUtils.COMMA)) == null || strArrSplit.length != 3) {
                return;
            }
            this.f13110a = sg.bigo.ads.common.utils.q.a(strArrSplit[0], 2);
            this.b = sg.bigo.ads.common.utils.q.a(strArrSplit[1], 3);
            this.c = sg.bigo.ads.common.utils.q.a(strArrSplit[2], 5);
        }
    }

    @Override // sg.bigo.ads.api.a.g
    public final int c() {
        return this.c;
    }
}
