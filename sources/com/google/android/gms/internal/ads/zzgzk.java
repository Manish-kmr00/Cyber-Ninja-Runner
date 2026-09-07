package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzk implements zzgzz {
    private final zzgzg zza;
    private final zzhal zzb;
    private final boolean zzc;
    private final zzgxg zzd;

    private zzgzk(zzhal zzhalVar, zzgxg zzgxgVar, zzgzg zzgzgVar) {
        this.zzb = zzhalVar;
        this.zzc = zzgzgVar instanceof zzgxr;
        this.zzd = zzgxgVar;
        this.zza = zzgzgVar;
    }

    static zzgzk zzc(zzhal zzhalVar, zzgxg zzgxgVar, zzgzg zzgzgVar) {
        return new zzgzk(zzhalVar, zzgxgVar, zzgzgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final int zza(Object obj) {
        int iZzb = ((zzgxv) obj).zzt.zzb();
        return this.zzc ? iZzb + ((zzgxr) obj).zza.zzd() : iZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final int zzb(Object obj) {
        int iHashCode = ((zzgxv) obj).zzt.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzgxr) obj).zza.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final Object zze() {
        zzgzg zzgzgVar = this.zza;
        return zzgzgVar instanceof zzgxv ? ((zzgxv) zzgzgVar).zzbj() : zzgzgVar.zzcX().zzbs();
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzg(Object obj, Object obj2) {
        zzhab.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhab.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzh(Object obj, zzgzt zzgztVar, zzgxf zzgxfVar) throws IOException {
        this.zzb.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgwb zzgwbVar) throws IOException {
        zzgxv zzgxvVar = (zzgxv) obj;
        if (zzgxvVar.zzt == zzham.zzc()) {
            zzgxvVar.zzt = zzham.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzj(Object obj, zzhba zzhbaVar) throws IOException {
        Iterator itZzf = ((zzgxr) obj).zza.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzgxj zzgxjVar = (zzgxj) entry.getKey();
            if (zzgxjVar.zzc() != zzhaz.MESSAGE || zzgxjVar.zze() || zzgxjVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgyn) {
                zzhbaVar.zzw(zzgxjVar.zza(), ((zzgyn) entry).zza().zzb());
            } else {
                zzhbaVar.zzw(zzgxjVar.zza(), entry.getValue());
            }
        }
        ((zzgxv) obj).zzt.zzk(zzhbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zzgxv) obj).zzt.equals(((zzgxv) obj2).zzt)) {
            return false;
        }
        if (this.zzc) {
            return ((zzgxr) obj).zza.equals(((zzgxr) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final boolean zzl(Object obj) {
        return ((zzgxr) obj).zza.zzi();
    }
}
