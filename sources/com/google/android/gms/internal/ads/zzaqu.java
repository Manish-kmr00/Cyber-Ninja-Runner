package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqu extends zzhej implements Closeable {
    static {
        zzheq.zzb(zzaqu.class);
    }

    public zzaqu(zzhek zzhekVar, zzaqt zzaqtVar) throws IOException {
        zze(zzhekVar, zzhekVar.zzc(), zzaqtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhej, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
