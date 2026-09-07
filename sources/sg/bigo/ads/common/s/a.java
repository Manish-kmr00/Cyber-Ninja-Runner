package sg.bigo.ads.common.s;

import android.content.Context;
import android.os.Parcel;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f13261a = r.c.a(1);
    private final Context b;
    private boolean c;
    private double d;
    private double e;
    private String f;
    private String g;
    private String h;
    private long i;

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        this.c = false;
        this.b = context;
        this.i = 0L;
    }

    public a(Context context, Parcel parcel) {
        this.c = false;
        this.b = context;
        b(parcel);
    }

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.d = parcel.readDouble();
        this.e = parcel.readDouble();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readLong();
    }

    public final String toString() {
        return "{longitude=" + this.d + ", latitude=" + this.e + ", countryCode='" + this.f + "', state='" + this.g + "', city='" + this.h + "', updateTime='" + this.i + "'}";
    }
}
