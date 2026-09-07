package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import com.json.b9;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzpa {
    public static final zzpa zza;
    public final int zzb;
    public final int zzc;
    private final zzfxb zzd;

    static {
        zzpa zzpaVar;
        if (zzeu.zza >= 33) {
            zzfxa zzfxaVar = new zzfxa();
            for (int i = 1; i <= 10; i++) {
                zzfxaVar.zzf(Integer.valueOf(zzeu.zzi(i)));
            }
            zzpaVar = new zzpa(2, zzfxaVar.zzi());
        } else {
            zzpaVar = new zzpa(2, 10);
        }
        zza = zzpaVar;
    }

    public zzpa(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzpa(int i, Set set) {
        this.zzb = i;
        zzfxb zzfxbVarZzl = zzfxb.zzl(set);
        this.zzd = zzfxbVarZzl;
        zzfzc it = zzfxbVarZzl.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpa)) {
            return false;
        }
        zzpa zzpaVar = (zzpa) obj;
        return this.zzb == zzpaVar.zzb && this.zzc == zzpaVar.zzc && Objects.equals(this.zzd, zzpaVar.zzd);
    }

    public final int hashCode() {
        zzfxb zzfxbVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfxbVar == null ? 0 : zzfxbVar.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + String.valueOf(this.zzd) + b9.i.e;
    }

    public final int zza(int i, zze zzeVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzeu.zza < 29) {
            Integer num = (Integer) zzpb.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i2 = this.zzb;
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzi = zzeu.zzi(i3);
            if (iZzi != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i).setChannelMask(iZzi).build(), zzeVar.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public final boolean zzb(int i) {
        zzfxb zzfxbVar = this.zzd;
        if (zzfxbVar == null) {
            return i <= this.zzc;
        }
        int iZzi = zzeu.zzi(i);
        if (iZzi == 0) {
            return false;
        }
        return zzfxbVar.contains(Integer.valueOf(iZzi));
    }
}
