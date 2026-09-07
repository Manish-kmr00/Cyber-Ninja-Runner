package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
public final class zzayw {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzazl zze;
    private final zzazt zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzayw(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
        this.zze = new zzazl(i4);
        this.zzf = new zzazt(i5, i6, i7);
    }

    private final void zzm(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z) {
                    ArrayList arrayList = this.zzi;
                    arrayList.add(str);
                    this.zzj.add(new zzazh(f, f2, f3, f4, arrayList.size() - 1));
                }
            }
        }
    }

    private static final String zzn(ArrayList arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append((String) arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzayw)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzayw) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        return "ActivityContent fetchId: " + this.zzl + " score:" + this.zzn + " total_length:" + this.zzk + "\n text: " + zzn(arrayList, 100) + "\n viewableText" + zzn(this.zzi, 100) + "\n signture: " + this.zzo + "\n viewableSignture: " + this.zzp + "\n viewableSignatureForVertical: " + this.zzq;
    }

    final int zza(int i, int i2) {
        return this.zzd ? this.zzb : (i * this.zza) + (i2 * this.zzb);
    }

    final int zzb() {
        return this.zzk;
    }

    public final String zzc() {
        return this.zzo;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzg(int i) {
        this.zzl = i;
    }

    public final void zzh(String str, boolean z, float f, float f2, float f3, float f4) {
        zzm(str, z, f, f2, f3, f4);
    }

    public final void zzi(String str, boolean z, float f, float f2, float f3, float f4) {
        zzm(str, z, f, f2, f3, f4);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("ActivityContent: negative number of WebViews.");
            }
            zzj();
        }
    }

    public final void zzj() {
        synchronized (this.zzg) {
            int iZza = zza(this.zzk, this.zzl);
            if (iZza > this.zzn) {
                this.zzn = iZza;
                if (!com.google.android.gms.ads.internal.zzv.zzp().zzi().zzK()) {
                    zzazl zzazlVar = this.zze;
                    this.zzo = zzazlVar.zza(this.zzh);
                    this.zzp = zzazlVar.zza(this.zzi);
                }
                if (!com.google.android.gms.ads.internal.zzv.zzp().zzi().zzL()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    public final void zzk() {
        synchronized (this.zzg) {
            int iZza = zza(this.zzk, this.zzl);
            if (iZza > this.zzn) {
                this.zzn = iZza;
            }
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzg) {
            z = this.zzm == 0;
        }
        return z;
    }
}
