package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdzw implements zzgbo {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzdzx zzb;

    zzdzw(zzdzx zzdzxVar, boolean z) {
        this.zza = z;
        this.zzb = zzdzxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x0078  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094  */
    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab  */
    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listEmptyList;
        List listAsList;
        final ArrayList arrayList;
        Iterator it;
        byte b;
        zzbbn.zzd.zza zzaVar;
        zzdzx zzdzxVar = this.zzb;
        zzcue zzcueVar = (zzcue) obj;
        if (zzdzxVar.zzf()) {
            return;
        }
        Bundle bundle = zzcueVar.zza;
        Object obj2 = bundle.get("ad_types");
        if (!(obj2 instanceof List)) {
            if (obj2 instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj2);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList();
            it = listEmptyList.iterator();
            while (it.hasNext()) {
                switch ((String) it.next()) {
                    case "banner":
                        b = 0;
                        break;
                    case "native":
                        b = 2;
                        break;
                    case "rewarded":
                        b = 3;
                        break;
                    case "interstitial":
                        b = 1;
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0) {
                    zzaVar = zzbbn.zzd.zza.BANNER;
                } else if (b != 1) {
                    zzaVar = zzbbn.zzd.zza.INTERSTITIAL;
                } else if (b != 2) {
                    zzaVar = zzbbn.zzd.zza.NATIVE_APP_INSTALL;
                } else if (b != 3) {
                    zzaVar = zzbbn.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                } else {
                    zzaVar = zzbbn.zzd.zza.REWARD_BASED_VIDEO_AD;
                }
                arrayList.add(zzaVar);
            }
            final zzbbn.zzaf.zzd zzdVarZzb = zzdzx.zzb(zzdzxVar, bundle);
            final zzbbn.zzab zzabVarZza = zzdzx.zza(zzdzxVar, bundle);
            final boolean z = this.zza;
            zzdzxVar.zza.zza(new zzfex() { // from class: com.google.android.gms.internal.ads.zzdzv
                @Override // com.google.android.gms.internal.ads.zzfex
                public final Object zza(Object obj3) {
                    zzdzx zzdzxVar2 = this.zza.zzb;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                    if (zzdzxVar2.zzf()) {
                        return null;
                    }
                    zzbbn.zzaf.zzd zzdVar = zzdVarZzb;
                    zzbbn.zzab zzabVar = zzabVarZza;
                    ArrayList arrayList2 = arrayList;
                    boolean z2 = z;
                    byte[] bArrZze = zzdzx.zze(zzdzxVar2, z2, arrayList2, zzabVar, zzdVar);
                    zzeaa.zzf(sQLiteDatabase, z2, true);
                    zzeaa.zzc(sQLiteDatabase, zzdzxVar2.zzf.zzd(), bArrZze);
                    return null;
                }
            });
        }
        listAsList = (List) obj2;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList();
        it = listEmptyList.iterator();
        while (it.hasNext()) {
            switch ((String) it.next()) {
                case -1396342996:
                    if (!r2.equals("banner")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case -1052618729:
                    if (!r2.equals("native")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case -239580146:
                    if (!r2.equals("rewarded")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                case 604727084:
                    if (!r2.equals("interstitial")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                zzaVar = zzbbn.zzd.zza.BANNER;
            } else if (b != 1) {
                zzaVar = zzbbn.zzd.zza.INTERSTITIAL;
            } else if (b != 2) {
                zzaVar = zzbbn.zzd.zza.NATIVE_APP_INSTALL;
            } else if (b != 3) {
                zzaVar = zzbbn.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
            } else {
                zzaVar = zzbbn.zzd.zza.REWARD_BASED_VIDEO_AD;
            }
            arrayList.add(zzaVar);
        }
        final zzbbn.zzaf.zzd zzdVarZzb2 = zzdzx.zzb(zzdzxVar, bundle);
        final zzbbn.zzab zzabVarZza2 = zzdzx.zza(zzdzxVar, bundle);
        final boolean z2 = this.zza;
        zzdzxVar.zza.zza(new zzfex() { // from class: com.google.android.gms.internal.ads.zzdzv
            @Override // com.google.android.gms.internal.ads.zzfex
            public final Object zza(Object obj4) {
                zzdzx zzdzxVar2 = this.zza.zzb;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj4;
                if (zzdzxVar2.zzf()) {
                    return null;
                }
                zzbbn.zzaf.zzd zzdVar = zzdVarZzb2;
                zzbbn.zzab zzabVar = zzabVarZza2;
                ArrayList arrayList3 = arrayList;
                boolean z3 = z2;
                byte[] bArrZze = zzdzx.zze(zzdzxVar2, z3, arrayList3, zzabVar, zzdVar);
                zzeaa.zzf(sQLiteDatabase, z3, true);
                zzeaa.zzc(sQLiteDatabase, zzdzxVar2.zzf.zzd(), bArrZze);
                return null;
            }
        });
    }
}
