package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfoe {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfoe(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfof.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfof.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    public final boolean zza(zzaxt zzaxtVar, zzfok zzfokVar) {
        boolean z;
        String strZzk = zzaxtVar.zzc().zzk();
        byte[] bArrZzA = zzaxtVar.zzf().zzA();
        byte[] bArrZzA2 = zzaxtVar.zzd().zzA();
        if (!TextUtils.isEmpty(strZzk) && bArrZzA2 != null && bArrZzA2.length != 0) {
            File file = this.zza;
            zzfof.zzd(file);
            file.mkdirs();
            zzfof.zzc(strZzk, file).mkdirs();
            File fileZzb = zzfof.zzb(strZzk, "pcam.jar", file);
            if ((bArrZzA == null || bArrZzA.length <= 0 || zzfof.zze(fileZzb, bArrZzA)) && zzfof.zze(zzfof.zzb(strZzk, "pcbc", file), bArrZzA2)) {
                File fileZzb2 = zzfof.zzb(zzaxtVar.zzc().zzk(), "pcam.jar", file);
                if (fileZzb2.exists() && zzfokVar != null && !zzfokVar.zza(fileZzb2)) {
                    return false;
                }
                String strZzk2 = zzaxtVar.zzc().zzk();
                if (TextUtils.isEmpty(strZzk2)) {
                    z = false;
                } else {
                    File fileZzb3 = zzfof.zzb(strZzk2, "pcam.jar", file);
                    File fileZzb4 = zzfof.zzb(strZzk2, "pcbc", file);
                    File fileZzb5 = zzfof.zzb(strZzk2, "pcam.jar", zzd());
                    File fileZzb6 = zzfof.zzb(strZzk2, "pcbc", zzd());
                    if ((!fileZzb3.exists() || fileZzb3.renameTo(fileZzb5)) && fileZzb4.exists() && fileZzb4.renameTo(fileZzb6)) {
                        zzaxu zzaxuVarZzd = zzaxw.zzd();
                        zzaxuVarZzd.zze(zzaxtVar.zzc().zzk());
                        zzaxuVarZzd.zza(zzaxtVar.zzc().zzj());
                        zzaxuVarZzd.zzb(zzaxtVar.zzc().zza());
                        zzaxuVarZzd.zzd(zzaxtVar.zzc().zzc());
                        zzaxuVarZzd.zzc(zzaxtVar.zzc().zzb());
                        zzaxw zzaxwVar = (zzaxw) zzaxuVarZzd.zzbr();
                        zzaxw zzaxwVarZzb = zzb(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzaxwVarZzb != null && !zzaxwVar.zzk().equals(zzaxwVarZzb.zzk())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzaxwVarZzb.zzaV()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzaxwVar.zzaV()));
                        if (editorEdit.commit()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                }
                HashSet hashSet = new HashSet();
                zzaxw zzaxwVarZzb2 = zzb(1);
                if (zzaxwVarZzb2 != null) {
                    hashSet.add(zzaxwVarZzb2.zzk());
                }
                zzaxw zzaxwVarZzb3 = zzb(2);
                if (zzaxwVarZzb3 != null) {
                    hashSet.add(zzaxwVarZzb3.zzk());
                }
                for (File file2 : zzd().listFiles()) {
                    String name = file2.getName();
                    if (!hashSet.contains(name)) {
                        zzfof.zzd(zzfof.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    final zzaxw zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgwn zzgwnVar = zzgwn.zzb;
            zzaxw zzaxwVarZzh = zzaxw.zzh(zzgwn.zzv(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzaxwVarZzh.zzk();
            File fileZzb = zzfof.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfof.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfof.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists() && fileZzb2.exists()) {
                return zzaxwVarZzh;
            }
            return null;
        } catch (zzgyk unused) {
        }
    }

    public final zzfod zzc(int i) {
        zzaxw zzaxwVarZzb = zzb(1);
        if (zzaxwVarZzb == null) {
            return null;
        }
        String strZzk = zzaxwVarZzb.zzk();
        File fileZzb = zzfof.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfof.zzb(strZzk, "pcam", zzd());
        }
        return new zzfod(zzaxwVarZzb, fileZzb, zzfof.zzb(strZzk, "pcbc", zzd()), zzfof.zzb(strZzk, "pcopt", zzd()));
    }
}
