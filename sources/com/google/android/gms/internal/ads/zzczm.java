package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzczm implements AppEventListener, OnAdMetadataChangedListener, zzcvc, com.google.android.gms.ads.internal.client.zza, zzcxo, zzcvw, zzcxb, com.google.android.gms.ads.internal.overlay.zzr, zzcvs, zzddc {
    private final zzczj zza = new zzczj(this, null);

    @Nullable
    private zzejr zzb;

    @Nullable
    private zzejv zzc;

    @Nullable
    private zzews zzd;

    @Nullable
    private zzezx zze;

    private static void zzn(Object obj, zzczk zzczkVar) {
        if (obj != null) {
            zzczkVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyc
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).onAdClicked();
            }
        });
        zzn(this.zzc, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyd
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejv) obj).onAdClicked();
            }
        });
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyi
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyo
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zza() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczh
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zza();
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczi
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zza();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzb() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcza
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzb();
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczb
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzc() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyj
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzc();
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyk
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyv
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzdd() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyx
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzdd();
            }
        });
        zzn(this.zzc, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczc
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejv) obj).zzdd();
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczd
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzdd();
            }
        });
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcze
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzdd();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdi() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyh
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyu
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzdo();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyq
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzdp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzdq(final zzbvk zzbvkVar, final String str, final String str2) {
        zzn(this.zzb, new zzczk(zzbvkVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzcyl
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyn
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzdq(zzbvkVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdr() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyw
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzdr();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds(final int i) {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyy
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzds(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zze() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyb
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcym
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvc
    public final void zzf() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcye
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyf
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxb
    public final void zzg() {
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyz
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxo
    public final void zzh(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyr
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzh(zztVar);
            }
        });
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcys
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzh(zztVar);
            }
        });
        zzn(this.zzd, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyt
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzews) obj).zzh(zztVar);
            }
        });
    }

    public final zzczj zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final void zzr(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzn(this.zze, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczf
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzezx) obj).zzr(zzeVar);
            }
        });
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzczg
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzr(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzs() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyg
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzs();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddc
    public final void zzu() {
        zzn(this.zzb, new zzczk() { // from class: com.google.android.gms.internal.ads.zzcyp
            @Override // com.google.android.gms.internal.ads.zzczk
            public final void zza(Object obj) {
                ((zzejr) obj).zzu();
            }
        });
    }
}
