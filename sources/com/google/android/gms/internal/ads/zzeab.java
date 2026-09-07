package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeab implements zzffu {
    private final zzdzp zza;
    private final zzdzt zzb;

    zzeab(zzdzp zzdzpVar, zzdzt zzdztVar) {
        this.zza = zzdzpVar;
        this.zzb = zzdztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzd(zzffn zzffnVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue() && zzffn.RENDERER == zzffnVar) {
            zzdzp zzdzpVar = this.zza;
            if (zzdzpVar.zzc() != 0) {
                zzdzpVar.zzf(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzdzpVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdA(zzffn zzffnVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdB(zzffn zzffnVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue() && zzffn.RENDERER == zzffnVar) {
            zzdzp zzdzpVar = this.zza;
            if (zzdzpVar.zzc() != 0) {
                zzdzpVar.zzf(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzdzpVar.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzffu
    public final void zzdC(zzffn zzffnVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue()) {
            if (zzffn.RENDERER == zzffnVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime());
                return;
            }
            if (zzffn.PRELOADED_LOADER == zzffnVar || zzffn.SERVER_TRANSACTION == zzffnVar) {
                zzdzp zzdzpVar = this.zza;
                zzdzpVar.zzh(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime());
                final zzdzt zzdztVar = this.zzb;
                final long jZzd = zzdzpVar.zzd();
                zzdztVar.zza.zza(new zzfex() { // from class: com.google.android.gms.internal.ads.zzdzs
                    @Override // com.google.android.gms.internal.ads.zzfex
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzdztVar.zzf()) {
                            return null;
                        }
                        long j = jZzd;
                        zzbbn.zzaf.zza.C0272zza c0272zzaZzn = zzbbn.zzaf.zza.zzn();
                        c0272zzaZzn.zzP(j);
                        byte[] bArrZzaV = c0272zzaZzn.zzbr().zzaV();
                        zzeaa.zzf(sQLiteDatabase, false, false);
                        zzeaa.zzc(sQLiteDatabase, j, bArrZzaV);
                        return null;
                    }
                });
            }
        }
    }
}
