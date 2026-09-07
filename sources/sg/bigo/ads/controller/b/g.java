package sg.bigo.ads.controller.b;

import android.os.Parcel;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sg.bigo.ads.api.a.k;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements k, sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f13410a = true;
    boolean b = false;
    int c = 0;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        n.a(parcel, this.f13410a);
        n.a(parcel, this.b);
        parcel.writeInt(this.c);
    }

    @Override // sg.bigo.ads.api.a.k
    public final boolean a() {
        return this.f13410a;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.f13410a = n.b(parcel, true);
        this.f13410a = n.b(parcel, false);
        this.c = n.a(parcel, 0);
    }

    @Override // sg.bigo.ads.api.a.k
    public final boolean b() {
        return this.b;
    }

    @Override // sg.bigo.ads.api.a.k
    public final int c() {
        return this.c;
    }

    public final String toString() {
        return "{isNativeVideoClickable=" + this.f13410a + ", isNativeVideoClickable=" + this.f13410a + ", clickTriggerType=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
