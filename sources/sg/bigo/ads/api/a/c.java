package sg.bigo.ads.api.a;

import android.os.Parcel;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13089a = new c();
    public static final sg.bigo.ads.common.f.a<c> b = new sg.bigo.ads.common.f.a<c>() { // from class: sg.bigo.ads.api.a.c.1
        @Override // sg.bigo.ads.common.f.a
        public final /* synthetic */ sg.bigo.ads.common.f a() {
            return new c((byte) 0);
        }
    };
    private String c;

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public c(String str) {
        this.c = str;
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(this.c);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.c = parcel.readString();
    }

    public final String toString() {
        return q.a(this.c);
    }
}
