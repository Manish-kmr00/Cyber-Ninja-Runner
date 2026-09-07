package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzcw {
    private static final String zza;
    private static final String zzb;
    private static final String zzc;
    private static final String zzd;
    private static final String zze;

    static {
        int i = zzeu.zza;
        zza = Integer.toString(0, 36);
        zzb = Integer.toString(1, 36);
        zzc = Integer.toString(2, 36);
        zzd = Integer.toString(3, 36);
        zze = Integer.toString(4, 36);
    }

    public static ArrayList zza(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (zzcy zzcyVar : (zzcy[]) spanned.getSpans(0, spanned.length(), zzcy.class)) {
            arrayList.add(zzb(spanned, zzcyVar, 1, zzcyVar.zza()));
        }
        for (zzda zzdaVar : (zzda[]) spanned.getSpans(0, spanned.length(), zzda.class)) {
            arrayList.add(zzb(spanned, zzdaVar, 2, zzdaVar.zza()));
        }
        for (zzcx zzcxVar : (zzcx[]) spanned.getSpans(0, spanned.length(), zzcx.class)) {
            arrayList.add(zzb(spanned, zzcxVar, 3, null));
        }
        for (zzdb zzdbVar : (zzdb[]) spanned.getSpans(0, spanned.length(), zzdb.class)) {
            arrayList.add(zzb(spanned, zzdbVar, 4, zzdbVar.zza()));
        }
        return arrayList;
    }

    private static Bundle zzb(Spanned spanned, Object obj, int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(zza, spanned.getSpanStart(obj));
        bundle2.putInt(zzb, spanned.getSpanEnd(obj));
        bundle2.putInt(zzc, spanned.getSpanFlags(obj));
        bundle2.putInt(zzd, i);
        if (bundle != null) {
            bundle2.putBundle(zze, bundle);
        }
        return bundle2;
    }
}
