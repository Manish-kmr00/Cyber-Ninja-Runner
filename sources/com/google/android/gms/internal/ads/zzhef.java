package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public abstract class zzhef implements zzaqw {
    private static final zzheq zzg = zzheq.zzb(zzhef.class);
    protected final String zza;
    long zzd;
    zzhek zzf;
    private ByteBuffer zzh;
    long zze = -1;
    boolean zzc = true;
    boolean zzb = true;

    protected zzhef(String str) {
        this.zza = str;
    }

    private final synchronized void zzc() {
        if (this.zzc) {
            return;
        }
        try {
            zzheq zzheqVar = zzg;
            String str = this.zza;
            zzheqVar.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
            this.zzh = this.zzf.zzd(this.zzd, this.zze);
            this.zzc = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void zzb(zzhek zzhekVar, ByteBuffer byteBuffer, long j, zzaqt zzaqtVar) throws IOException {
        this.zzd = zzhekVar.zzb();
        byteBuffer.remaining();
        this.zze = j;
        this.zzf = zzhekVar;
        zzhekVar.zze(zzhekVar.zzb() + j);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    protected abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        zzc();
        zzheq zzheqVar = zzg;
        String str = this.zza;
        zzheqVar.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.zzh;
        if (byteBuffer != null) {
            this.zzb = true;
            byteBuffer.rewind();
            zze(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.zzh = null;
        }
    }
}
