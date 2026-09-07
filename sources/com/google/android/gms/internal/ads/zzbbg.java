package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzbbg {
    private final zzbbm zza;
    private final zzbbn.zzt.zza zzb;
    private final boolean zzc;

    private zzbbg() {
        this.zzb = zzbbn.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbbm();
    }

    public static zzbbg zza() {
        return new zzbbg();
    }

    private final synchronized String zzd(int i) {
        zzbbn.zzt.zza zzaVar;
        zzaVar = this.zzb;
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", zzaVar.zzah(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime()), Integer.valueOf(i - 1), Base64.encodeToString(zzaVar.zzbr().zzaV(), 3));
    }

    private final synchronized void zze(int i) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzfpc.zza(zzfpb.zza(), externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                fileOutputStream.write(zzd(i).getBytes());
            } catch (IOException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Could not write Clearcut to file.");
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused3) {
            com.google.android.gms.ads.internal.util.zze.zza("Could not find file for Clearcut");
        }
    }

    private final synchronized void zzf(int i) {
        zzbbn.zzt.zza zzaVar = this.zzb;
        zzaVar.zzq();
        zzaVar.zzj(com.google.android.gms.ads.internal.util.zzs.zzd());
        zzbbk zzbbkVar = new zzbbk(this.zza, zzaVar.zzbr().zzaV(), null);
        int i2 = i - 1;
        zzbbkVar.zza(i2);
        zzbbkVar.zzc();
        com.google.android.gms.ads.internal.util.zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i2, 10))));
    }

    public final synchronized void zzb(zzbbf zzbbfVar) {
        if (this.zzc) {
            try {
                zzbbfVar.zza(this.zzb);
            } catch (NullPointerException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i) {
        if (this.zzc) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfh)).booleanValue()) {
                zze(i);
            } else {
                zzf(i);
            }
        }
    }

    public zzbbg(zzbbm zzbbmVar) {
        this.zzb = zzbbn.zzt.zzj();
        this.zza = zzbbmVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfg)).booleanValue();
    }
}
