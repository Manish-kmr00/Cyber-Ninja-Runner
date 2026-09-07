package sg.bigo.ads;

import android.content.Context;
import android.os.Parcel;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12462a;

    public a(Context context) {
        super(context);
    }

    @Override // sg.bigo.ads.common.e
    public final String a() {
        return "bigo_app.dat";
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(this.f12462a);
    }

    @Override // sg.bigo.ads.common.e
    public final String b() {
        return "bigo_app.dat";
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.f12462a = n.a(parcel, "");
    }
}
