package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13380a;
    public long b;
    public long c;
    public long d;
    public long e;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        synchronized (this) {
            parcel.writeLong(this.f13380a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
            parcel.writeLong(this.d);
            parcel.writeLong(this.e);
        }
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        synchronized (this) {
            this.f13380a = n.a(parcel, 0L);
            this.b = n.a(parcel, 0L);
            this.c = n.a(parcel, 0L);
            this.d = n.a(parcel, 0L);
            this.e = n.a(parcel, 0L);
        }
    }

    public final String toString() {
        return super.toString();
    }
}
