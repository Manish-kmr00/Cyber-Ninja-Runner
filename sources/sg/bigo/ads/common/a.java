package sg.bigo.ads.common;

import android.os.Parcel;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13122a = new a();
    public String b;
    public boolean c;
    private long d;

    private a() {
        this.b = "";
        this.c = true;
    }

    public a(Parcel parcel) {
        b(parcel);
    }

    public a(String str, boolean z) {
        this.b = str;
        this.c = z;
        this.d = r.b();
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeLong(this.d);
    }

    public final boolean a() {
        return Math.abs(r.b() - this.d) > r.d.a(1);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readLong();
    }

    public final String toString() {
        return "{advertisingId='" + this.b + "', isLimitAdTrackingEnabled=" + this.c + ", lastUpdateTime=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
