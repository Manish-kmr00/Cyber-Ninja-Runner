package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.dash.DashMediaSource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalh implements zzaka {
    private final zzek zza = new zzek();
    private final zzek zzb = new zzek();
    private final zzalg zzc;
    private Inflater zzd;

    public zzalh(List list) {
        zzalg zzalgVar = new zzalg();
        this.zzc = zzalgVar;
        zzalgVar.zzb(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzek zzekVar = this.zza;
        zzekVar.zzJ(bArr, i2 + i);
        zzekVar.zzL(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzek zzekVar2 = this.zzb;
        if (zzeu.zzO(zzekVar, zzekVar2, this.zzd)) {
            zzekVar.zzJ(zzekVar2.zzN(), zzekVar2.zzd());
        }
        zzalg zzalgVar = this.zzc;
        zzalgVar.zzd();
        int iZza = zzekVar.zza();
        zzcu zzcuVarZza = null;
        if (iZza >= 2 && zzekVar.zzq() == iZza) {
            zzalgVar.zzc(zzekVar);
            zzcuVarZza = zzalgVar.zza(zzekVar);
        }
        zzdkVar.zza(new zzajs(zzcuVarZza != null ? zzfww.zzo(zzcuVarZza) : zzfww.zzn(), -9223372036854775807L, DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US));
    }
}
