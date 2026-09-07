package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeag {
    private final zzbbg zza;
    private final Context zzb;
    private final zzdzl zzc;
    private final VersionInfoParcel zzd;

    public zzeag(Context context, VersionInfoParcel versionInfoParcel, zzbbg zzbbgVar, zzdzl zzdzlVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbbgVar;
        this.zzc = zzdzlVar;
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfex() { // from class: com.google.android.gms.internal.ads.zzead
                @Override // com.google.android.gms.internal.ads.zzfex
                public final Object zza(Object obj) {
                    zzeag.zza(this.zza, z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error in offline signals database startup: ".concat(strValueOf));
        }
    }

    public static /* synthetic */ Void zza(zzeag zzeagVar, boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            zzeagVar.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(zzbbn.zzaf.zza.zzx(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgyk e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(e.getMessage());
                }
            }
            cursorQuery.close();
            Context context = zzeagVar.zzb;
            zzbbn.zzaf.zzc zzcVarZzi = zzbbn.zzaf.zzi();
            zzcVarZzi.zzv(context.getPackageName());
            zzcVarZzi.zzy(Build.MODEL);
            zzcVarZzi.zzA(zzeaa.zza(sQLiteDatabase, 0));
            zzcVarZzi.zzh(arrayList);
            zzcVarZzi.zzE(zzeaa.zza(sQLiteDatabase, 1));
            zzcVarZzi.zzx(zzeaa.zza(sQLiteDatabase, 3));
            zzcVarZzi.zzF(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
            zzcVarZzi.zzB(zzeaa.zzb(sQLiteDatabase, 2));
            final zzbbn.zzaf zzafVarZzbr = zzcVarZzi.zzbr();
            int size = arrayList.size();
            long jZze = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbbn.zzaf.zza zzaVar = (zzbbn.zzaf.zza) arrayList.get(i2);
                if (zzaVar.zzk() == zzbbn.zzq.ENUM_TRUE && zzaVar.zze() > jZze) {
                    jZze = zzaVar.zze();
                }
            }
            if (jZze != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(jZze));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            zzbbg zzbbgVar = zzeagVar.zza;
            zzbbgVar.zzb(new zzbbf() { // from class: com.google.android.gms.internal.ads.zzeae
                @Override // com.google.android.gms.internal.ads.zzbbf
                public final void zza(zzbbn.zzt.zza zzaVar2) {
                    zzaVar2.zzW(zzafVarZzbr);
                }
            });
            VersionInfoParcel versionInfoParcel = zzeagVar.zzd;
            zzbbn.zzar.zza zzaVarZzd = zzbbn.zzar.zzd();
            zzaVarZzd.zzg(versionInfoParcel.buddyApkVersion);
            zzaVarZzd.zzi(versionInfoParcel.clientJarVersion);
            zzaVarZzd.zzh(true != versionInfoParcel.isClientJar ? 2 : 0);
            final zzbbn.zzar zzarVarZzbr = zzaVarZzd.zzbr();
            zzbbgVar.zzb(new zzbbf() { // from class: com.google.android.gms.internal.ads.zzeaf
                @Override // com.google.android.gms.internal.ads.zzbbf
                public final void zza(zzbbn.zzt.zza zzaVar2) {
                    zzbbn.zzm.zza zzaVarZzbM = zzaVar2.zzg().zzbM();
                    zzaVarZzbM.zzw(zzarVarZzbr);
                    zzaVar2.zzK(zzaVarZzbM);
                }
            });
            zzbbgVar.zzc(10004);
            zzeaa.zze(sQLiteDatabase);
        }
        return null;
    }
}
