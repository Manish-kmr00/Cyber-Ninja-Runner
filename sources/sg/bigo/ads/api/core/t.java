package sg.bigo.ads.api.core;

import android.os.Parcel;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class t implements sg.bigo.ads.api.a.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13117a = 0;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(String.valueOf(this.f13117a));
    }

    @Override // sg.bigo.ads.api.a.o
    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13117a = jSONObject.optInt("ll_on", 0);
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            String string = parcel.readString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] strArrSplit = string.split(StringUtils.COMMA);
            if (strArrSplit.length > 0) {
                this.f13117a = sg.bigo.ads.common.utils.q.a(strArrSplit[0], 0);
            }
        }
    }
}
