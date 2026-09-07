package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.common.util.concurrent.ListenableFuture;
import com.safedk.android.analytics.brandsafety.l;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzelj implements zzesv {
    private final zzesv zza;
    private final zzfbp zzb;
    private final Context zzc;
    private final zzbza zzd;

    zzelj(zzenn zzennVar, zzfbp zzfbpVar, Context context, zzbza zzbzaVar) {
        this.zza = zzennVar;
        this.zzb = zzfbpVar;
        this.zzc = context;
        this.zzd = zzbzaVar;
    }

    public static /* synthetic */ zzelk zzc(zzelj zzeljVar, zzete zzeteVar) {
        String str;
        boolean z;
        String strZzj;
        float f;
        int i;
        int i2;
        int i3;
        DisplayMetrics displayMetrics;
        zzfbp zzfbpVar = zzeljVar.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVar = zzfbpVar.zze;
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.zzg;
        if (zzrVarArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                boolean z4 = zzrVar2.zzi;
                if (!z4 && !z2) {
                    str = zzrVar2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (z3) {
                        z3 = true;
                    } else {
                        z3 = true;
                        z = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzrVar.zza;
            z = zzrVar.zzi;
        }
        Resources resources = zzeljVar.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            strZzj = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            zzbza zzbzaVar = zzeljVar.zzd;
            float f2 = displayMetrics.density;
            i2 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            strZzj = zzbzaVar.zzi().zzj();
            i = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzrVarArr != null) {
            boolean z5 = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar3 : zzrVarArr) {
                if (zzrVar3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append(l.ad);
                    }
                    int i5 = zzrVar3.zze;
                    if (i5 == -1) {
                        i5 = f != 0.0f ? (int) (zzrVar3.zzf / f) : -1;
                    }
                    sb.append(i5);
                    sb.append(VastAttributes.HORIZONTAL_POSITION);
                    int i6 = zzrVar3.zzb;
                    if (i6 == -2) {
                        i6 = f != 0.0f ? (int) (zzrVar3.zzc / f) : -2;
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, l.ad);
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzelk(zzrVar, str, z, sb.toString(), f, i2, i, strZzj, zzfbpVar.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return zzgbs.zzm(this.zza.zzb(), new zzftl() { // from class: com.google.android.gms.internal.ads.zzeli
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return zzelj.zzc(this.zza, (zzete) obj);
            }
        }, zzbzk.zzg);
    }
}
