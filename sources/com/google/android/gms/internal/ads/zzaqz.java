package com.google.android.gms.internal.ads;

import com.json.b9;
import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqz extends zzheh {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzher zzm;
    private long zzn;

    public zzaqz() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzher.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + b9.i.e;
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhef
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzhem.zza(zzaqv.zzf(byteBuffer));
            this.zzh = zzhem.zza(zzaqv.zzf(byteBuffer));
            this.zzi = zzaqv.zze(byteBuffer);
            this.zzj = zzaqv.zzf(byteBuffer);
        } else {
            this.zzg = zzhem.zza(zzaqv.zze(byteBuffer));
            this.zzh = zzhem.zza(zzaqv.zze(byteBuffer));
            this.zzi = zzaqv.zze(byteBuffer);
            this.zzj = zzaqv.zze(byteBuffer);
        }
        this.zzk = zzaqv.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8))))) / 256.0f;
        zzaqv.zzd(byteBuffer);
        zzaqv.zze(byteBuffer);
        zzaqv.zze(byteBuffer);
        this.zzm = new zzher(zzaqv.zzb(byteBuffer), zzaqv.zzb(byteBuffer), zzaqv.zzb(byteBuffer), zzaqv.zzb(byteBuffer), zzaqv.zza(byteBuffer), zzaqv.zza(byteBuffer), zzaqv.zza(byteBuffer), zzaqv.zzb(byteBuffer), zzaqv.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzaqv.zze(byteBuffer);
    }
}
