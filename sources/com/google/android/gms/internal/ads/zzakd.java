package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakd implements zzaei {
    private final zzaei zza;
    private final zzajy zzb;
    private zzaka zzg;
    private zzz zzh;
    private boolean zzi;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzeu.zzc;
    private final zzek zzc = new zzek();

    public zzakd(zzaei zzaeiVar, zzajy zzajyVar) {
        this.zza = zzaeiVar;
        this.zzb = zzajyVar;
    }

    public static /* synthetic */ void zza(zzakd zzakdVar, long j, int i, zzajs zzajsVar) {
        zzdc.zzb(zzakdVar.zzh);
        zzfww zzfwwVar = zzajsVar.zza;
        long j2 = zzajsVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzfwwVar.size());
        Iterator<E> it = zzfwwVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzcu) it.next()).zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, arrayList);
        bundle.putLong("d", j2);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzek zzekVar = zzakdVar.zzc;
        int length = bArrMarshall.length;
        zzekVar.zzJ(bArrMarshall, length);
        zzaei zzaeiVar = zzakdVar.zza;
        zzaeiVar.zzr(zzekVar, length);
        long j3 = zzajsVar.zzb;
        if (j3 == -9223372036854775807L) {
            zzdc.zzf(zzakdVar.zzh.zzt == Long.MAX_VALUE);
        } else {
            long j4 = zzakdVar.zzh.zzt;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        zzaeiVar.zzt(j, i | 1, length, 0, null);
    }

    private final void zzc(int i) {
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 >= i) {
            return;
        }
        int i3 = i2 - this.zzd;
        int iMax = Math.max(i3 + i3, i + i3);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i3);
        this.zzd = 0;
        this.zze = i3;
        this.zzf = bArr2;
    }

    public final void zzb(boolean z) {
        this.zzi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaeg.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzg(zzlVar, i, z, 0);
        }
        zzc(i);
        int iZza = zzlVar.zza(this.zzf, this.zze, i);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzm(zzz zzzVar) {
        String str = zzzVar.zzo;
        str.getClass();
        zzdc.zzd(zzay.zzb(str) == 3);
        if (!zzzVar.equals(this.zzh)) {
            this.zzh = zzzVar;
            zzajy zzajyVar = this.zzb;
            this.zzg = zzajyVar.zzc(zzzVar) ? zzajyVar.zzb(zzzVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzm(zzzVar);
            return;
        }
        zzaei zzaeiVar = this.zza;
        zzx zzxVarZzb = zzzVar.zzb();
        zzxVarZzb.zzad("application/x-media3-cues");
        zzxVarZzb.zzC(str);
        zzxVarZzb.zzah(Long.MAX_VALUE);
        zzxVarZzb.zzG(this.zzb.zza(zzzVar));
        zzaeiVar.zzm(zzxVarZzb.zzaj());
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ void zzr(zzek zzekVar, int i) {
        zzaeg.zzb(this, zzekVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzs(zzek zzekVar, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzs(zzekVar, i, i2);
            return;
        }
        zzc(i);
        zzekVar.zzH(this.zzf, this.zze, i);
        this.zze += i;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzt(final long j, final int i, int i2, int i3, zzaeh zzaehVar) {
        if (this.zzg == null) {
            this.zza.zzt(j, i, i2, i3, zzaehVar);
            return;
        }
        zzdc.zze(zzaehVar == null, "DRM on subtitles is not supported");
        int i4 = (this.zze - i3) - i2;
        try {
            this.zzg.zza(this.zzf, i4, i2, zzajz.zza(), new zzdk() { // from class: com.google.android.gms.internal.ads.zzakc
                @Override // com.google.android.gms.internal.ads.zzdk
                public final void zza(Object obj) {
                    zzakd.zza(this.zza, j, i, (zzajs) obj);
                }
            });
        } catch (RuntimeException e) {
            if (!this.zzi) {
                throw e;
            }
            zzdx.zzg("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e);
        }
        int i5 = i4 + i2;
        this.zzd = i5;
        if (i5 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
