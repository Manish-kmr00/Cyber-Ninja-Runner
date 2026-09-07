package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public class zzheg extends zzhej implements zzaqw {
    protected final String zza = "moov";

    public zzheg(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void zzb(zzhek zzhekVar, ByteBuffer byteBuffer, long j, zzaqt zzaqtVar) throws IOException {
        zzhekVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzhekVar;
        this.zze = zzhekVar.zzb();
        zzhekVar.zze(zzhekVar.zzb() + j);
        this.zzf = zzhekVar.zzb();
        this.zzb = zzaqtVar;
    }
}
