package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzabf {
    private final zzaag zza = new zzaag();
    private final zzabd zzb;
    private final zzabe zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    static /* bridge */ /* synthetic */ void zzb(zzabf zzabfVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzabfVar.zzk = refreshRate;
            zzabfVar.zzl = (refreshRate * 80) / 100;
        } else {
            zzdx.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zzabfVar.zzk = -9223372036854775807L;
            zzabfVar.zzl = -9223372036854775807L;
        }
    }

    private final void zzk() {
        Surface surface;
        if (zzeu.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzabc.zza(surface, 0.0f);
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzm() {
        if (zzeu.zza < 30 || this.zze == null) {
            return;
        }
        zzaag zzaagVar = this.zza;
        float fZza = zzaagVar.zzg() ? zzaagVar.zza() : this.zzf;
        float f = this.zzg;
        if (fZza != f) {
            if (fZza != -1.0f && f != -1.0f) {
                float f2 = 1.0f;
                if (zzaagVar.zzg() && zzaagVar.zzd() >= 5000000000L) {
                    f2 = 0.02f;
                }
                if (Math.abs(fZza - this.zzg) < f2) {
                    return;
                }
            } else if (fZza == -1.0f && zzaagVar.zzb() < 30) {
                return;
            }
            this.zzg = fZza;
            zzn(false);
        }
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzeu.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.zzd) {
            float f2 = this.zzg;
            if (f2 != -1.0f) {
                f = this.zzi * f2;
            }
        }
        if (z || this.zzh != f) {
            this.zzh = f;
            zzabc.zza(surface, f);
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1) {
            zzaag zzaagVar = this.zza;
            if (zzaagVar.zzg()) {
                long jZzc = this.zzq + ((long) ((zzaagVar.zzc() * (this.zzm - this.zzp)) / this.zzi));
                if (Math.abs(j - jZzc) > 20000000) {
                    zzl();
                } else {
                    j = jZzc;
                }
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzabe zzabeVar = this.zzc;
        if (zzabeVar != null && this.zzk != -9223372036854775807L) {
            long j3 = zzabeVar.zza;
            if (j3 != -9223372036854775807L) {
                long j4 = this.zzk;
                long j5 = j3 + (((j - j3) / j4) * j4);
                if (j <= j5) {
                    j2 = j5 - j4;
                } else {
                    j5 = j4 + j5;
                    j2 = j5;
                }
                long j6 = this.zzl;
                if (j5 - j >= j - j2) {
                    j5 = j2;
                }
                return j5 - j6;
            }
        }
        return j;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzb();
            zzabdVar.zza();
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzabd zzabdVar = this.zzb;
        if (zzabdVar != null) {
            zzabdVar.zzb();
            zzabe zzabeVar = this.zzc;
            zzabeVar.getClass();
            zzabeVar.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (this.zze == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i) {
        if (this.zzj == i) {
            return;
        }
        this.zzj = i;
        zzn(true);
    }

    public zzabf(Context context) {
        DisplayManager displayManager;
        zzabd zzabdVar = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new zzabd(this, displayManager);
        this.zzb = zzabdVar;
        this.zzc = zzabdVar != null ? zzabe.zza() : null;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }
}
