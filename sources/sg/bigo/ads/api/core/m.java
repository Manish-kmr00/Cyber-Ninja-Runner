package sg.bigo.ads.api.core;

import android.os.Parcel;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements sg.bigo.ads.api.a.j, sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13111a = 0;

    @Override // sg.bigo.ads.common.f
    public final void a(Parcel parcel) {
        parcel.writeLong(this.f13111a);
    }

    @Override // sg.bigo.ads.api.a.j
    public final boolean a(int i) {
        return (this.f13111a & (1 << i)) != 0;
    }

    @Override // sg.bigo.ads.common.f
    public final void b(Parcel parcel) {
        this.f13111a = parcel.readLong();
    }

    public final String toString() {
        return "{value=" + this.f13111a + AbstractJsonLexerKt.END_OBJ;
    }
}
