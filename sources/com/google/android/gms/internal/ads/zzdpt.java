package com.google.android.gms.internal.ads;

import com.json.mediationsdk.utils.IronSourceConstants;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdpt implements zzcya, zzcwq, zzcvf, zzcvw, com.google.android.gms.ads.internal.client.zza, zzdam {
    private final zzbbg zza;
    private boolean zzb = false;

    public zzdpt(zzbbg zzbbgVar, @Nullable zzeyp zzeypVar) {
        this.zza = zzbbgVar;
        zzbbgVar.zzc(2);
        if (zzeypVar != null) {
            zzbbgVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(final zzfbg zzfbgVar) {
        this.zza.zzb(new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdpp
            @Override // com.google.android.gms.internal.ads.zzbbf
            public final void zza(zzbbn.zzt.zza zzaVar) {
                zzbbn.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbbn.zzi.zza zzaVarZzbM = zzaVar.zze().zzad().zzbM();
                zzaVarZzbM.zzo(zzfbgVar.zzb.zzb.zzb);
                zzbVarZzbM.zzT(zzaVarZzbM);
                zzaVar.zzG(zzbVarZzbM);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvf
    public final void zzdz(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzi(final zzbbn.zzb zzbVar) {
        zzbbf zzbbfVar = new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdps
            @Override // com.google.android.gms.internal.ads.zzbbf
            public final void zza(zzbbn.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbbg zzbbgVar = this.zza;
        zzbbgVar.zzb(zzbbfVar);
        zzbbgVar.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzj(final zzbbn.zzb zzbVar) {
        zzbbf zzbbfVar = new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdpq
            @Override // com.google.android.gms.internal.ads.zzbbf
            public final void zza(zzbbn.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbbg zzbbgVar = this.zza;
        zzbbgVar.zzb(zzbbfVar);
        zzbbgVar.zzc(IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzm(final zzbbn.zzb zzbVar) {
        zzbbf zzbbfVar = new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdpr
            @Override // com.google.android.gms.internal.ads.zzbbf
            public final void zza(zzbbn.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbVar);
            }
        };
        zzbbg zzbbgVar = this.zza;
        zzbbgVar.zzb(zzbbfVar);
        zzbbgVar.zzc(IronSourceConstants.RV_CHECK_PLACEMENT_CAPPED);
    }

    @Override // com.google.android.gms.internal.ads.zzdam
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final synchronized void zzs() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        this.zza.zzc(3);
    }
}
