package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfdd implements zzfdc {
    private final ConcurrentHashMap zza;
    private final zzfdj zzb;
    private final zzfdf zzc = new zzfdf();

    public zzfdd(zzfdj zzfdjVar) {
        this.zza = new ConcurrentHashMap(zzfdjVar.zzd);
        this.zzb = zzfdjVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfdj> creator = zzfdj.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgo)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfdj zzfdjVar = this.zzb;
            sb.append(zzfdjVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfdm) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfdb) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzb = ((zzfdb) entry.getValue()).zzb(); iZzb < zzfdjVar.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfdb) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < zzfdjVar.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(string);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfdc
    public final zzfdj zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfdc
    public final synchronized zzfdl zzb(zzfdm zzfdmVar) {
        zzfdl zzfdlVarZze;
        zzfdb zzfdbVar = (zzfdb) this.zza.get(zzfdmVar);
        if (zzfdbVar != null) {
            zzfdlVarZze = zzfdbVar.zze();
            if (zzfdlVarZze == null) {
                this.zzc.zze();
            }
            zzfdz zzfdzVarZzf = zzfdbVar.zzf();
            if (zzfdlVarZze != null) {
                zzbbn.zzb.zzc zzcVarZzd = zzbbn.zzb.zzd();
                zzbbn.zzb.zza.C0273zza c0273zzaZza = zzbbn.zzb.zza.zza();
                c0273zzaZza.zzf(zzbbn.zzb.zzd.IN_MEMORY);
                zzbbn.zzb.zze.zza zzaVarZzb = zzbbn.zzb.zze.zzb();
                zzaVarZzb.zzd(zzfdzVarZzf.zza);
                zzaVarZzb.zze(zzfdzVarZzf.zzb);
                c0273zzaZza.zzg(zzaVarZzb);
                zzcVarZzd.zzd(c0273zzaZza);
                zzfdlVarZze.zza.zzb().zzc().zzi(zzcVarZzd.zzbr());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfdlVarZze = null;
        }
        return zzfdlVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfdc
    @Deprecated
    public final zzfdm zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfdj zzfdjVar = this.zzb;
        return new zzfdn(zzmVar, str, new zzbvb(zzfdjVar.zza).zza().zzj, zzfdjVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfdc
    public final synchronized boolean zzd(zzfdm zzfdmVar, zzfdl zzfdlVar) {
        boolean zZzh;
        ConcurrentHashMap concurrentHashMap = this.zza;
        zzfdb zzfdbVar = (zzfdb) concurrentHashMap.get(zzfdmVar);
        zzfdlVar.zzd = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
        if (zzfdbVar == null) {
            zzfdj zzfdjVar = this.zzb;
            zzfdb zzfdbVar2 = new zzfdb(zzfdjVar.zzd, zzfdjVar.zze * 1000);
            if (concurrentHashMap.size() == zzfdjVar.zzc) {
                int i = zzfdjVar.zzg;
                int i2 = i - 1;
                zzfdm zzfdmVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long jZzc = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : concurrentHashMap.entrySet()) {
                        if (((zzfdb) entry.getValue()).zzc() < jZzc) {
                            jZzc = ((zzfdb) entry.getValue()).zzc();
                            zzfdmVar2 = (zzfdm) entry.getKey();
                        }
                    }
                    if (zzfdmVar2 != null) {
                        concurrentHashMap.remove(zzfdmVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                        if (((zzfdb) entry2.getValue()).zzd() < jZzc) {
                            jZzc = ((zzfdb) entry2.getValue()).zzd();
                            zzfdmVar2 = (zzfdm) entry2.getKey();
                        }
                    }
                    if (zzfdmVar2 != null) {
                        concurrentHashMap.remove(zzfdmVar2);
                    }
                } else if (i2 == 2) {
                    int iZza = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                        if (((zzfdb) entry3.getValue()).zza() < iZza) {
                            iZza = ((zzfdb) entry3.getValue()).zza();
                            zzfdmVar2 = (zzfdm) entry3.getKey();
                        }
                    }
                    if (zzfdmVar2 != null) {
                        concurrentHashMap.remove(zzfdmVar2);
                    }
                }
                this.zzc.zzg();
            }
            concurrentHashMap.put(zzfdmVar, zzfdbVar2);
            this.zzc.zzd();
            zzfdbVar = zzfdbVar2;
        }
        zZzh = zzfdbVar.zzh(zzfdlVar);
        zzfdf zzfdfVar = this.zzc;
        zzfdfVar.zzc();
        zzfde zzfdeVarZza = zzfdfVar.zza();
        zzfdz zzfdzVarZzf = zzfdbVar.zzf();
        if (zzfdlVar != null) {
            zzbbn.zzb.zzc zzcVarZzd = zzbbn.zzb.zzd();
            zzbbn.zzb.zza.C0273zza c0273zzaZza = zzbbn.zzb.zza.zza();
            c0273zzaZza.zzf(zzbbn.zzb.zzd.IN_MEMORY);
            zzbbn.zzb.zzg.zza zzaVarZzb = zzbbn.zzb.zzg.zzb();
            zzaVarZzb.zze(zzfdeVarZza.zza);
            zzaVarZzb.zzf(zzfdeVarZza.zzb);
            zzaVarZzb.zzg(zzfdzVarZzf.zzb);
            c0273zzaZza.zzi(zzaVarZzb);
            zzcVarZzd.zzd(c0273zzaZza);
            zzfdlVar.zza.zzb().zzc().zzj(zzcVarZzd.zzbr());
        }
        zzf();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfdc
    public final synchronized boolean zze(zzfdm zzfdmVar) {
        zzfdb zzfdbVar = (zzfdb) this.zza.get(zzfdmVar);
        if (zzfdbVar == null) {
            return true;
        }
        return zzfdbVar.zzb() < this.zzb.zzd;
    }
}
