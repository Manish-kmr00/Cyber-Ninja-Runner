package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfol {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfns zze;
    private boolean zzf;

    public zzfol(Context context, int i, zzfns zzfnsVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfnsVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzaxt zzaxtVar) {
        zzaxu zzaxuVarZzd = zzaxw.zzd();
        zzaxuVarZzd.zze(zzaxtVar.zzc().zzk());
        zzaxuVarZzd.zza(zzaxtVar.zzc().zzj());
        zzaxuVarZzd.zzb(zzaxtVar.zzc().zza());
        zzaxuVarZzd.zzd(zzaxtVar.zzc().zzc());
        zzaxuVarZzd.zzc(zzaxtVar.zzc().zzb());
        return Hex.bytesToStringLowercase(((zzaxw) zzaxuVarZzd.zzbr()).zzaV());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzaxw zzk(int i) {
        String string = i == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgwn zzgwnVar = zzgwn.zzb;
            return zzaxw.zzi(zzgwn.zzv(bArrStringToBytes, 0, bArrStringToBytes.length), this.zzf ? zzgxf.zza() : zzgxf.zzb());
        } catch (zzgyk unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzaxt zzaxtVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            if (!zzfof.zze(new File(zze(zzaxtVar.zzc().zzk()), "pcbc"), zzaxtVar.zzd().zzA())) {
                zzi(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN, jCurrentTimeMillis);
                return false;
            }
            String strZzf = zzf(zzaxtVar);
            SharedPreferences.Editor editorEdit = this.zzc.edit();
            editorEdit.putString(zzh(), strZzf);
            boolean zCommit = editorEdit.commit();
            if (zCommit) {
                zzi(5015, jCurrentTimeMillis);
            } else {
                zzi(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS, jCurrentTimeMillis);
            }
            return zCommit;
        }
    }

    public final boolean zzb(zzaxt zzaxtVar, zzfok zzfokVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaxw zzaxwVarZzk = zzk(1);
            String strZzk = zzaxtVar.zzc().zzk();
            if (zzaxwVarZzk != null && zzaxwVarZzk.zzk().equals(strZzk)) {
                zzi(4014, jCurrentTimeMillis);
                return false;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            File fileZze = zze(strZzk);
            if (fileZze.exists()) {
                zzj(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                zzi(4015, jCurrentTimeMillis2);
            } else if (!fileZze.mkdirs()) {
                zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                zzi(4015, jCurrentTimeMillis2);
                return false;
            }
            File fileZze2 = zze(strZzk);
            File file = new File(fileZze2, "pcam.jar");
            File file2 = new File(fileZze2, "pcbc");
            if (!zzfof.zze(file, zzaxtVar.zzf().zzA())) {
                zzi(4016, jCurrentTimeMillis);
                return false;
            }
            if (!zzfof.zze(file2, zzaxtVar.zzd().zzA())) {
                zzi(4017, jCurrentTimeMillis);
                return false;
            }
            if (zzfokVar != null && !zzfokVar.zza(file)) {
                zzi(4018, jCurrentTimeMillis);
                zzfof.zzd(fileZze2);
                return false;
            }
            String strZzf = zzf(zzaxtVar);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.zzc;
            String string = sharedPreferences.getString(zzh(), null);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(zzh(), strZzf);
            if (string != null) {
                editorEdit.putString(zzg(), string);
            }
            if (!editorEdit.commit()) {
                zzi(4019, jCurrentTimeMillis3);
                return false;
            }
            HashSet hashSet = new HashSet();
            zzaxw zzaxwVarZzk2 = zzk(1);
            if (zzaxwVarZzk2 != null) {
                hashSet.add(zzaxwVarZzk2.zzk());
            }
            zzaxw zzaxwVarZzk3 = zzk(2);
            if (zzaxwVarZzk3 != null) {
                hashSet.add(zzaxwVarZzk3.zzk());
            }
            for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                if (!hashSet.contains(file3.getName())) {
                    zzfof.zzd(file3);
                }
            }
            zzi(5014, jCurrentTimeMillis);
            return true;
        }
    }

    public final zzfod zzc(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaxw zzaxwVarZzk = zzk(1);
            if (zzaxwVarZzk == null) {
                zzi(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, jCurrentTimeMillis);
                return null;
            }
            File fileZze = zze(zzaxwVarZzk.zzk());
            File file = new File(fileZze, "pcam.jar");
            if (!file.exists()) {
                file = new File(fileZze, "pcam");
            }
            File file2 = new File(fileZze, "pcbc");
            File file3 = new File(fileZze, "pcopt");
            zzi(5016, jCurrentTimeMillis);
            return new zzfod(zzaxwVarZzk, file, file2, file3);
        }
    }

    public final boolean zzd(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaxw zzaxwVarZzk = zzk(1);
            if (zzaxwVarZzk == null) {
                zzi(4025, jCurrentTimeMillis);
                return false;
            }
            File fileZze = zze(zzaxwVarZzk.zzk());
            if (!new File(fileZze, "pcam.jar").exists()) {
                zzi(4026, jCurrentTimeMillis);
                return false;
            }
            if (new File(fileZze, "pcbc").exists()) {
                zzi(5019, jCurrentTimeMillis);
                return true;
            }
            zzi(4027, jCurrentTimeMillis);
            return false;
        }
    }
}
