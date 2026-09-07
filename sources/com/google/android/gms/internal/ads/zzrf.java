package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzrf implements zzqf {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private boolean zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private long zzI;
    private float zzJ;
    private ByteBuffer zzK;
    private int zzL;
    private ByteBuffer zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private int zzR;
    private zzf zzS;
    private zzph zzT;
    private long zzU;
    private boolean zzV;
    private boolean zzW;
    private Looper zzX;
    private long zzY;
    private long zzZ;
    private Handler zzaa;
    private final zzqv zzab;
    private final zzql zzac;
    private final Context zzd;
    private final zzqk zze;
    private final zzrp zzf;
    private final zzfww zzg;
    private final zzfww zzh;
    private final zzqj zzi;
    private final ArrayDeque zzj;
    private zzrd zzk;
    private final zzqz zzl;
    private final zzqz zzm;
    private zzoz zzn;
    private zzqc zzo;
    private zzqu zzp;
    private zzqu zzq;
    private zzck zzr;
    private AudioTrack zzs;
    private zzpb zzt;
    private zzpg zzu;
    private zzqy zzv;
    private zze zzw;
    private zzqw zzx;
    private zzqw zzy;
    private zzbb zzz;

    /* synthetic */ zzrf(zzqt zzqtVar, zzre zzreVar) {
        Context context = zzqtVar.zza;
        this.zzd = context;
        this.zzw = zze.zza;
        zzre zzreVar2 = null;
        this.zzt = context != null ? null : zzqtVar.zzb;
        this.zzab = zzqtVar.zzf;
        int i = zzeu.zza;
        zzql zzqlVar = zzqtVar.zzg;
        zzqlVar.getClass();
        this.zzac = zzqlVar;
        this.zzi = new zzqj(new zzra(this, zzreVar2));
        zzqk zzqkVar = new zzqk();
        this.zze = zzqkVar;
        zzrp zzrpVar = new zzrp();
        this.zzf = zzrpVar;
        this.zzg = zzfww.zzq(new zzcr(), zzqkVar, zzrpVar);
        this.zzh = zzfww.zzq(new zzro(), zzqkVar, zzrpVar);
        this.zzJ = 1.0f;
        this.zzR = 0;
        this.zzS = new zzf(0, 0.0f);
        this.zzy = new zzqw(zzbb.zza, 0L, 0L, null);
        this.zzz = zzbb.zza;
        this.zzA = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzqz();
        this.zzm = new zzqz();
    }

    public static /* synthetic */ void zzG(zzrf zzrfVar) {
        if (zzrfVar.zzZ >= 300000) {
            ((zzrj) zzrfVar.zzo).zza.zzn = true;
            zzrfVar.zzZ = 0L;
        }
    }

    static /* synthetic */ void zzI(AudioTrack audioTrack, final zzqc zzqcVar, Handler handler, final zzpz zzpzVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqcVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqo
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzrj) zzqcVar).zza.zzc.zzp(zzpzVar);
                    }
                });
            }
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqcVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqo
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((zzrj) zzqcVar).zza.zzc.zzp(zzpzVar);
                    }
                });
            }
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzK() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzL() {
        zzqu zzquVar = this.zzq;
        return zzquVar.zzc == 0 ? this.zzB / ((long) zzquVar.zzb) : this.zzC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzM() {
        zzqu zzquVar = this.zzq;
        if (zzquVar.zzc != 0) {
            return this.zzE;
        }
        long j = this.zzD;
        long j2 = zzquVar.zzd;
        int i = zzeu.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzN(zzqu zzquVar) throws zzqb {
        try {
            return zzac(zzquVar.zza(), this.zzw, this.zzR, zzquVar.zza);
        } catch (zzqb e) {
            zzqc zzqcVar = this.zzo;
            if (zzqcVar != null) {
                zzqcVar.zza(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) {
        zzbb zzbbVar;
        boolean z;
        if (zzab()) {
            zzqv zzqvVar = this.zzab;
            zzbbVar = this.zzz;
            zzqvVar.zzc(zzbbVar);
        } else {
            zzbbVar = zzbb.zza;
        }
        zzbb zzbbVar2 = zzbbVar;
        this.zzz = zzbbVar2;
        if (zzab()) {
            zzqv zzqvVar2 = this.zzab;
            z = this.zzA;
            zzqvVar2.zzd(z);
        } else {
            z = false;
        }
        this.zzA = z;
        this.zzj.add(new zzqw(zzbbVar2, Math.max(0L, j), zzeu.zzt(zzM(), this.zzq.zze), null));
        zzX();
        zzqc zzqcVar = this.zzo;
        if (zzqcVar != null) {
            ((zzrj) zzqcVar).zza.zzc.zzw(this.zzA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    private final void zzP(long j) throws Exception {
        zzqc zzqcVar;
        if (this.zzM == null) {
            return;
        }
        zzqz zzqzVar = this.zzm;
        if (zzqzVar.zzc()) {
            return;
        }
        int iRemaining = this.zzM.remaining();
        boolean z = true;
        int iWrite = this.zzs.write(this.zzM, iRemaining, 1);
        this.zzU = SystemClock.elapsedRealtime();
        if (iWrite < 0) {
            if ((zzeu.zza < 24 || iWrite != -6) && iWrite != -32) {
                z = false;
            } else if (zzM() <= 0) {
                if (zzaa(this.zzs)) {
                    zzQ();
                } else {
                    z = false;
                }
            }
            zzqe zzqeVar = new zzqe(iWrite, this.zzq.zza, z);
            zzqc zzqcVar2 = this.zzo;
            if (zzqcVar2 != null) {
                zzqcVar2.zza(zzqeVar);
            }
            if (!zzqeVar.zzb || this.zzd == null) {
                zzqzVar.zzb(zzqeVar);
                return;
            } else {
                this.zzt = zzpb.zza;
                throw zzqeVar;
            }
        }
        zzqzVar.zza();
        if (zzaa(this.zzs)) {
            if (this.zzE > 0) {
                this.zzW = false;
            }
            if (this.zzQ && (zzqcVar = this.zzo) != null && iWrite < iRemaining) {
            }
        }
        int i = this.zzq.zzc;
        if (i == 0) {
            this.zzD += (long) iWrite;
        }
        if (iWrite == iRemaining) {
            if (i != 0) {
                zzdc.zzf(this.zzM == this.zzK);
                this.zzE += ((long) this.zzF) * ((long) this.zzL);
            }
            this.zzM = null;
        }
    }

    private final void zzQ() {
        if (this.zzq.zzc == 1) {
            this.zzV = true;
        }
    }

    @EnsuresNonNull({"audioCapabilities"})
    private final void zzR() {
        Context context;
        if (this.zzu == null && (context = this.zzd) != null) {
            this.zzX = Looper.myLooper();
            zzpg zzpgVar = new zzpg(context, new zzqp(this), this.zzw, this.zzT);
            this.zzu = zzpgVar;
            this.zzt = zzpgVar.zzc();
        }
        this.zzt.getClass();
    }

    private final void zzS() {
        if (this.zzO) {
            return;
        }
        this.zzO = true;
        this.zzi.zzb(zzM());
        if (zzaa(this.zzs)) {
            this.zzP = false;
        }
        this.zzs.stop();
    }

    private final void zzT(long j) throws Exception {
        zzP(j);
        if (this.zzM != null) {
            return;
        }
        if (!this.zzr.zzh()) {
            ByteBuffer byteBuffer = this.zzK;
            if (byteBuffer != null) {
                zzV(byteBuffer);
                zzP(j);
                return;
            }
            return;
        }
        while (!this.zzr.zzg()) {
            do {
                ByteBuffer byteBufferZzb = this.zzr.zzb();
                if (byteBufferZzb.hasRemaining()) {
                    zzV(byteBufferZzb);
                    zzP(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzK;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzr.zze(this.zzK);
                    }
                }
            } while (this.zzM == null);
            return;
        }
    }

    private final void zzU(zzbb zzbbVar) {
        zzqw zzqwVar = new zzqw(zzbbVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzZ()) {
            this.zzx = zzqwVar;
        } else {
            this.zzy = zzqwVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0140  */
    /* JADX WARN: Code duplicated, block: B:49:0x0144  */
    /* JADX WARN: Code duplicated, block: B:51:0x0148  */
    /* JADX WARN: Code duplicated, block: B:53:0x014c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0150  */
    /* JADX WARN: Code duplicated, block: B:57:0x0154  */
    /* JADX WARN: Code duplicated, block: B:60:0x0172  */
    /* JADX WARN: Code duplicated, block: B:61:0x0185  */
    /* JADX WARN: Code duplicated, block: B:62:0x0192  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x01be  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x004b A[SYNTHETIC] */
    private final void zzV(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzdc.zzf(this.zzM == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzq.zzc == 0) {
                int iZzp = (int) zzeu.zzp(zzeu.zzs(20L), this.zzq.zze);
                long jZzM = zzM();
                long j = iZzp;
                if (jZzM < j) {
                    zzqu zzquVar = this.zzq;
                    int i12 = zzquVar.zzg;
                    int i13 = zzquVar.zzd;
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    int i14 = (int) jZzM;
                    while (byteBuffer.hasRemaining() && i14 < iZzp) {
                        if (i12 != 2) {
                            if (i12 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    if (i12 == 22) {
                                        i8 = byteBuffer.get() & 255;
                                        i9 = (byteBuffer.get() & 255) << 8;
                                        i10 = (byteBuffer.get() & 255) << 16;
                                        i11 = (byteBuffer.get() & 255) << 24;
                                    } else if (i12 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i12 == 1342177280) {
                                        i5 = (byteBuffer.get() & 255) << 24;
                                        i6 = (byteBuffer.get() & 255) << 16;
                                        i7 = (byteBuffer.get() & 255) << 8;
                                    } else {
                                        if (i12 != 1610612736) {
                                            throw new IllegalStateException();
                                        }
                                        i8 = (byteBuffer.get() & 255) << 24;
                                        i9 = (byteBuffer.get() & 255) << 16;
                                        i10 = (byteBuffer.get() & 255) << 8;
                                        i11 = byteBuffer.get() & 255;
                                    }
                                    i3 = i8 | i9 | i10 | i11;
                                } else {
                                    i5 = (byteBuffer.get() & 255) << 8;
                                    i6 = (byteBuffer.get() & 255) << 16;
                                    i7 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i5 | i6 | i7;
                            } else {
                                float fMax = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                if (fMax < 0.0f) {
                                    fMax = -fMax;
                                    f = -2.1474836E9f;
                                } else {
                                    f = 2.1474836E9f;
                                }
                                i3 = (int) (fMax * f);
                            }
                            i4 = (int) ((((long) i3) * ((long) i14)) / j);
                            if (i12 != 2) {
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 3) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 22) {
                                    byteBufferOrder.put((byte) i4);
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 268435456) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                } else if (i12 != 1342177280) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                } else {
                                    if (i12 == 1610612736) {
                                        throw new IllegalStateException();
                                    }
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) i4);
                                }
                            } else if (i4 < 0) {
                                byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                            } else {
                                byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() == iPosition + i13) {
                                i14++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i | i2;
                        i4 = (int) ((((long) i3) * ((long) i14)) / j);
                        if (i12 != 2) {
                            byteBufferOrder.put((byte) (i4 >> 16));
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 3) {
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 4) {
                            if (i12 != 21) {
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 22) {
                                byteBufferOrder.put((byte) i4);
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 268435456) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                            } else if (i12 != 1342177280) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                            } else {
                                if (i12 == 1610612736) {
                                    throw new IllegalStateException();
                                }
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) i4);
                            }
                        } else if (i4 < 0) {
                            byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                        } else {
                            byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                        }
                        if (byteBuffer.position() == iPosition + i13) {
                            i14++;
                            iPosition = byteBuffer.position();
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                    byteBuffer2 = byteBufferOrder;
                } else {
                    byteBuffer2 = byteBuffer;
                }
            } else {
                byteBuffer2 = byteBuffer;
            }
            this.zzM = byteBuffer2;
        }
    }

    private final void zzW() {
        if (zzZ()) {
            this.zzs.setVolume(this.zzJ);
        }
    }

    private final void zzX() {
        zzck zzckVar = this.zzq.zzi;
        this.zzr = zzckVar;
        zzckVar.zzc();
    }

    private final boolean zzY() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.zzr.zzh()) {
            zzP(Long.MIN_VALUE);
            return this.zzM == null;
        }
        this.zzr.zzd();
        zzT(Long.MIN_VALUE);
        return this.zzr.zzg() && ((byteBuffer = this.zzM) == null || !byteBuffer.hasRemaining());
    }

    private final boolean zzZ() {
        return this.zzs != null;
    }

    private static boolean zzaa(AudioTrack audioTrack) {
        return zzeu.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzab() {
        zzqu zzquVar = this.zzq;
        if (zzquVar.zzc != 0) {
            return false;
        }
        int i = zzquVar.zza.zzG;
        return true;
    }

    private static final AudioTrack zzac(zzpz zzpzVar, zze zzeVar, int i, zzz zzzVar) throws zzqb {
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzeVar.zza().zza).setAudioFormat(zzeu.zzx(zzpzVar.zzb, zzpzVar.zzc, zzpzVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzpzVar.zze).setSessionId(i);
            if (zzeu.zza >= 29) {
                sessionId.setOffloadedPlayback(zzpzVar.zzd);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            int state = audioTrackBuild.getState();
            if (state == 1) {
                return audioTrackBuild;
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqb(state, zzpzVar.zzb, zzpzVar.zzc, zzpzVar.zza, zzzVar, zzpzVar.zzd, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzqb(0, zzpzVar.zzb, zzpzVar.zzc, zzpzVar.zza, zzzVar, zzpzVar.zzd, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final boolean zzA(zzz zzzVar) {
        return zza(zzzVar) != 0;
    }

    public final void zzJ(zzpb zzpbVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzX;
        if (looper != looperMyLooper) {
            String name = looper == null ? "null" : looper.getThread().getName();
            throw new IllegalStateException("Current looper (" + (looperMyLooper != null ? looperMyLooper.getThread().getName() : "null") + ") is not the playback looper (" + name + ")");
        }
        zzpb zzpbVar2 = this.zzt;
        if (zzpbVar2 == null || zzpbVar.equals(zzpbVar2)) {
            return;
        }
        this.zzt = zzpbVar;
        zzqc zzqcVar = this.zzo;
        if (zzqcVar != null) {
            ((zzrj) zzqcVar).zza.zzB();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final int zza(zzz zzzVar) {
        zzR();
        if (!"audio/raw".equals(zzzVar.zzo)) {
            return this.zzt.zzb(zzzVar, this.zzw) != null ? 2 : 0;
        }
        int i = zzzVar.zzG;
        if (zzeu.zzK(i)) {
            return i != 2 ? 1 : 2;
        }
        zzdx.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final long zzb(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzZ() || this.zzH) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzi.zza(), zzeu.zzt(zzM(), this.zzq.zze));
        while (true) {
            arrayDeque = this.zzj;
            if (arrayDeque.isEmpty() || jMin < ((zzqw) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzy = (zzqw) arrayDeque.remove();
        }
        zzqw zzqwVar = this.zzy;
        long j2 = jMin - zzqwVar.zzc;
        long jZzq = zzeu.zzq(j2, zzqwVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZza = this.zzab.zza(j2);
            zzqw zzqwVar2 = this.zzy;
            j = zzqwVar2.zzb + jZza;
            zzqwVar2.zzd = jZza - jZzq;
        } else {
            zzqw zzqwVar3 = this.zzy;
            j = zzqwVar3.zzb + jZzq + zzqwVar3.zzd;
        }
        long jZzb = this.zzab.zzb();
        long jZzt = j + zzeu.zzt(jZzb, this.zzq.zze);
        long j3 = this.zzY;
        if (jZzb > j3) {
            long jZzt2 = zzeu.zzt(jZzb - j3, this.zzq.zze);
            this.zzY = jZzb;
            this.zzZ += jZzt2;
            if (this.zzaa == null) {
                this.zzaa = new Handler(Looper.myLooper());
            }
            this.zzaa.removeCallbacksAndMessages(null);
            this.zzaa.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqn
                @Override // java.lang.Runnable
                public final void run() {
                    zzrf.zzG(this.zza);
                }
            }, 100L);
        }
        return jZzt;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final zzbb zzc() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final zzpk zzd(zzz zzzVar) {
        return this.zzV ? zzpk.zza : this.zzac.zza(zzzVar, this.zzw);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x015d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0160  */
    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zze(zzz zzzVar, int i, int[] iArr) throws zzqa {
        int i2;
        zzck zzckVar;
        int iZzk;
        int iIntValue;
        int iZzk2;
        int i3;
        int i4;
        int iMax;
        int i5;
        zzqu zzquVar;
        zzR();
        if ("audio/raw".equals(zzzVar.zzo)) {
            int i6 = zzzVar.zzG;
            zzdc.zzd(zzeu.zzK(i6));
            int i7 = zzzVar.zzE;
            iZzk2 = zzeu.zzk(i6) * i7;
            zzfwt zzfwtVar = new zzfwt();
            zzfwtVar.zzh(this.zzg);
            zzfwtVar.zzg(this.zzab.zze());
            zzck zzckVar2 = new zzck(zzfwtVar.zzi());
            if (zzckVar2.equals(this.zzr)) {
                zzckVar2 = this.zzr;
            }
            this.zzf.zzq(zzzVar.zzH, zzzVar.zzI);
            this.zze.zzo(iArr);
            try {
                zzcl zzclVarZza = zzckVar2.zza(new zzcl(zzzVar.zzF, i7, i6));
                i4 = zzclVarZza.zzd;
                i3 = zzclVarZza.zzb;
                int i8 = zzclVarZza.zzc;
                iIntValue = zzeu.zzi(i8);
                iZzk = zzeu.zzk(i4) * i8;
                zzckVar = zzckVar2;
                i2 = 0;
            } catch (zzcm e) {
                throw new zzqa(e, zzzVar);
            }
        } else {
            zzck zzckVar3 = new zzck(zzfww.zzn());
            int i9 = zzzVar.zzF;
            zzpk zzpkVar = zzpk.zza;
            Pair pairZzb = this.zzt.zzb(zzzVar, this.zzw);
            if (pairZzb == null) {
                throw new zzqa("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzzVar))), zzzVar);
            }
            int iIntValue2 = ((Integer) pairZzb.first).intValue();
            i2 = 2;
            zzckVar = zzckVar3;
            iZzk = -1;
            iIntValue = ((Integer) pairZzb.second).intValue();
            iZzk2 = -1;
            i3 = i9;
            i4 = iIntValue2;
        }
        if (i4 == 0) {
            throw new zzqa("Invalid output encoding (mode=" + i2 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        if (iIntValue == 0) {
            throw new zzqa("Invalid output channel config (mode=" + i2 + ") for: " + String.valueOf(zzzVar), zzzVar);
        }
        int i10 = zzzVar.zzj;
        if ("audio/vnd.dts.hd;profile=lbr".equals(zzzVar.zzo) && i10 == -1) {
            i10 = 768000;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i3, iIntValue, i4);
        zzdc.zzf(minBufferSize != -2);
        int i11 = iZzk != -1 ? iZzk : 1;
        int i12 = 250000;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i4 == 5) {
                    i12 = 500000;
                } else if (i4 == 8) {
                    i12 = 1000000;
                    i4 = 8;
                }
                iMax = zzfzz.zzb((((long) i12) * ((long) (i10 != -1 ? zzfzs.zzb(i10, 8, RoundingMode.CEILING) : zzrh.zzb(i4)))) / 1000000);
                i5 = i4;
            } else {
                iMax = zzfzz.zzb((((long) zzrh.zzb(i4)) * 50000000) / 1000000);
            }
            int iMax2 = (((Math.max(minBufferSize, iMax) + i11) - 1) / i11) * i11;
            this.zzV = false;
            zzquVar = new zzqu(zzzVar, iZzk2, i2, iZzk, i3, iIntValue, i5, iMax2, zzckVar, false, false, false);
            if (zzZ()) {
                this.zzp = zzquVar;
            } else {
                this.zzq = zzquVar;
            }
        }
        int iZza = zzrh.zza(250000, i3, i11);
        int iZza2 = zzrh.zza(750000, i3, i11);
        int i13 = zzeu.zza;
        iMax = Math.max(iZza, Math.min(minBufferSize * 4, iZza2));
        i5 = i4;
        int iMax3 = (((Math.max(minBufferSize, iMax) + i11) - 1) / i11) * i11;
        this.zzV = false;
        zzquVar = new zzqu(zzzVar, iZzk2, i2, iZzk, i3, iIntValue, i5, iMax3, zzckVar, false, false, false);
        if (zzZ()) {
            this.zzp = zzquVar;
        } else {
            this.zzq = zzquVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzf() {
        zzqy zzqyVar;
        if (zzZ()) {
            this.zzB = 0L;
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzW = false;
            this.zzF = 0;
            this.zzy = new zzqw(this.zzz, 0L, 0L, null);
            this.zzI = 0L;
            this.zzx = null;
            this.zzj.clear();
            this.zzK = null;
            this.zzL = 0;
            this.zzM = null;
            this.zzO = false;
            this.zzN = false;
            this.zzP = false;
            this.zzf.zzp();
            zzX();
            zzqj zzqjVar = this.zzi;
            if (zzqjVar.zzh()) {
                this.zzs.pause();
            }
            if (zzaa(this.zzs)) {
                zzrd zzrdVar = this.zzk;
                zzrdVar.getClass();
                zzrdVar.zzb(this.zzs);
            }
            final zzpz zzpzVarZza = this.zzq.zza();
            zzqu zzquVar = this.zzp;
            if (zzquVar != null) {
                this.zzq = zzquVar;
                this.zzp = null;
            }
            zzqjVar.zzc();
            if (zzeu.zza >= 24 && (zzqyVar = this.zzv) != null) {
                zzqyVar.zzb();
                this.zzv = null;
            }
            final AudioTrack audioTrack = this.zzs;
            final zzqc zzqcVar = this.zzo;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    final String str = "ExoPlayer:AudioTrackReleaseThread";
                    zzb = Executors.newSingleThreadScheduledExecutor(new ThreadFactory(str) { // from class: com.google.android.gms.internal.ads.zzet
                        public final /* synthetic */ String zza = "ExoPlayer:AudioTrackReleaseThread";

                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            int i = zzeu.zza;
                            return new Thread(runnable, this.zza);
                        }
                    });
                }
                zzc++;
                zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqm
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzrf.zzI(audioTrack, zzqcVar, handler, zzpzVarZza);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            }
            this.zzs = null;
        }
        this.zzm.zza();
        this.zzl.zza();
        this.zzY = 0L;
        this.zzZ = 0L;
        Handler handler2 = this.zzaa;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzg() {
        this.zzG = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzh() {
        this.zzQ = false;
        if (zzZ()) {
            if (this.zzi.zzk() || zzaa(this.zzs)) {
                this.zzs.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzi() {
        this.zzQ = true;
        if (zzZ()) {
            this.zzi.zzf();
            this.zzs.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzj() throws zzqe {
        if (!this.zzN && zzZ() && zzY()) {
            zzS();
            this.zzN = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzk() {
        zzpg zzpgVar = this.zzu;
        if (zzpgVar != null) {
            zzpgVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzl() {
        zzf();
        zzfww zzfwwVar = this.zzg;
        int size = zzfwwVar.size();
        for (int i = 0; i < size; i++) {
            ((zzcn) zzfwwVar.get(i)).zzf();
        }
        zzfww zzfwwVar2 = this.zzh;
        int size2 = zzfwwVar2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzcn) zzfwwVar2.get(i2)).zzf();
        }
        zzck zzckVar = this.zzr;
        if (zzckVar != null) {
            zzckVar.zzf();
        }
        this.zzQ = false;
        this.zzV = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzm(zze zzeVar) {
        if (this.zzw.equals(zzeVar)) {
            return;
        }
        this.zzw = zzeVar;
        zzpg zzpgVar = this.zzu;
        if (zzpgVar != null) {
            zzpgVar.zzg(zzeVar);
        }
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzn(int i) {
        if (this.zzR != i) {
            this.zzR = i;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzo(zzf zzfVar) {
        if (this.zzS.equals(zzfVar)) {
            return;
        }
        if (this.zzs != null) {
            int i = this.zzS.zza;
        }
        this.zzS = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzp(zzdg zzdgVar) {
        this.zzi.zze(zzdgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzq(zzqc zzqcVar) {
        this.zzo = zzqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzr(int i, int i2) {
        AudioTrack audioTrack = this.zzs;
        if (audioTrack != null) {
            zzaa(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzs(zzbb zzbbVar) {
        float f = zzbbVar.zzb;
        int i = zzeu.zza;
        this.zzz = new zzbb(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzbbVar.zzc, 8.0f)));
        zzU(zzbbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzt(zzoz zzozVar) {
        this.zzn = zzozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzv(boolean z) {
        this.zzA = z;
        zzU(this.zzz);
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzw(float f) {
        if (this.zzJ != f) {
            this.zzJ = f;
            zzW();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:130:0x0272  */
    /* JADX WARN: Code duplicated, block: B:132:0x0279  */
    /* JADX WARN: Code duplicated, block: B:134:0x0285  */
    /* JADX WARN: Code duplicated, block: B:137:0x028f  */
    /* JADX WARN: Code duplicated, block: B:139:0x0298  */
    /* JADX WARN: Code duplicated, block: B:140:0x029b  */
    /* JADX WARN: Code duplicated, block: B:142:0x02a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:150:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:152:0x0301  */
    /* JADX WARN: Code duplicated, block: B:215:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzqf
    public final boolean zzx(ByteBuffer byteBuffer, long j, int i) throws Exception {
        AudioTrack audioTrackZzN;
        zzpg zzpgVar;
        zzoz zzozVar;
        boolean z;
        int iZzb;
        int iPosition;
        byte b;
        int i2;
        int i3;
        int i4;
        byte b2;
        int i5;
        int i6;
        ByteBuffer byteBuffer2 = this.zzK;
        zzdc.zzd(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzp != null) {
            if (!zzY()) {
                return false;
            }
            zzqu zzquVar = this.zzp;
            zzqu zzquVar2 = this.zzq;
            if (zzquVar2.zzc == zzquVar.zzc && zzquVar2.zzg == zzquVar.zzg && zzquVar2.zze == zzquVar.zze && zzquVar2.zzf == zzquVar.zzf && zzquVar2.zzd == zzquVar.zzd) {
                boolean z2 = zzquVar2.zzj;
                boolean z3 = zzquVar.zzj;
                boolean z4 = zzquVar2.zzk;
                boolean z5 = zzquVar.zzk;
                this.zzq = zzquVar;
                this.zzp = null;
                AudioTrack audioTrack = this.zzs;
                if (audioTrack != null && zzaa(audioTrack)) {
                    boolean z6 = this.zzq.zzk;
                }
            } else {
                zzS();
                if (zzy()) {
                    return false;
                }
                zzf();
            }
            zzO(j);
        }
        if (!zzZ()) {
            try {
                if (this.zzl.zzc()) {
                    return false;
                }
                try {
                    zzqu zzquVar3 = this.zzq;
                    if (zzquVar3 == null) {
                        throw null;
                    }
                    audioTrackZzN = zzN(zzquVar3);
                    this.zzs = audioTrackZzN;
                    if (zzaa(audioTrackZzN)) {
                        AudioTrack audioTrack2 = this.zzs;
                        if (this.zzk == null) {
                            this.zzk = new zzrd(this);
                        }
                        this.zzk.zza(audioTrack2);
                        boolean z7 = this.zzq.zzk;
                    }
                    if (zzeu.zza >= 31 && (zzozVar = this.zzn) != null) {
                        AudioTrack audioTrack3 = this.zzs;
                        LogSessionId logSessionIdZza = zzozVar.zza();
                        if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                            audioTrack3.setLogSessionId(logSessionIdZza);
                        }
                    }
                    this.zzR = this.zzs.getAudioSessionId();
                    zzqj zzqjVar = this.zzi;
                    AudioTrack audioTrack4 = this.zzs;
                    zzqu zzquVar4 = this.zzq;
                    zzqjVar.zzd(audioTrack4, zzquVar4.zzc == 2, zzquVar4.zzg, zzquVar4.zzd, zzquVar4.zzh);
                    zzW();
                    int i7 = this.zzS.zza;
                    zzph zzphVar = this.zzT;
                    if (zzphVar != null) {
                        zzqq.zza(this.zzs, zzphVar);
                        zzpg zzpgVar2 = this.zzu;
                        if (zzpgVar2 != null) {
                            zzpgVar2.zzh(this.zzT.zza);
                        }
                    }
                    if (zzeu.zza >= 24 && (zzpgVar = this.zzu) != null) {
                        this.zzv = new zzqy(this.zzs, zzpgVar);
                    }
                    this.zzH = true;
                    zzqc zzqcVar = this.zzo;
                    if (zzqcVar != null) {
                        ((zzrj) zzqcVar).zza.zzc.zzo(this.zzq.zza());
                    }
                } catch (zzqb e) {
                    zzqu zzquVar5 = this.zzq;
                    if (zzquVar5.zzh > 1000000) {
                        zzz zzzVar = zzquVar5.zza;
                        int i8 = zzquVar5.zzb;
                        int i9 = zzquVar5.zzc;
                        int i10 = zzquVar5.zzd;
                        int i11 = zzquVar5.zze;
                        int i12 = zzquVar5.zzf;
                        int i13 = zzquVar5.zzg;
                        zzck zzckVar = zzquVar5.zzi;
                        boolean z8 = zzquVar5.zzj;
                        boolean z9 = zzquVar5.zzk;
                        boolean z10 = zzquVar5.zzl;
                        zzqu zzquVar6 = new zzqu(zzzVar, i8, i9, i10, i11, i12, i13, 1000000, zzckVar, false, false, false);
                        try {
                            audioTrackZzN = zzN(zzquVar6);
                            this.zzq = zzquVar6;
                        } catch (zzqb e2) {
                            e.addSuppressed(e2);
                            zzQ();
                            throw e;
                        }
                    }
                    zzQ();
                    throw e;
                }
            } catch (zzqb e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzl.zzb(e3);
                return false;
            }
        }
        this.zzl.zza();
        if (this.zzH) {
            this.zzI = Math.max(0L, j);
            this.zzG = false;
            this.zzH = false;
            zzO(j);
            if (this.zzQ) {
                zzi();
            }
        }
        zzqj zzqjVar2 = this.zzi;
        zzqjVar2.zzj(zzM());
        if (this.zzK == null) {
            zzdc.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzqu zzquVar7 = this.zzq;
            if (zzquVar7.zzc != 0 && this.zzF == 0) {
                int i14 = zzquVar7.zzg;
                if (i14 == 20) {
                    z = true;
                    iZzb = zzadx.zzb(byteBuffer);
                } else if (i14 != 30) {
                    switch (i14) {
                        case 5:
                        case 6:
                            iZzb = zzacb.zza(byteBuffer);
                            z = true;
                            break;
                        case 7:
                        case 8:
                            int i15 = zzadb.zza;
                            if (byteBuffer.getInt(0) == -233094848) {
                                z = true;
                                iZzb = 1024;
                            } else {
                                if (byteBuffer.getInt(0) == -398277519) {
                                    iZzb = 1024;
                                } else if (byteBuffer.getInt(0) != 622876772) {
                                    iPosition = byteBuffer.position();
                                    b = byteBuffer.get(iPosition);
                                    if (b != -2) {
                                        if (b != -1) {
                                            if (b != 31) {
                                                i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                                i5 = byteBuffer.get(iPosition + 5) & 252;
                                                i3 = 2;
                                            } else {
                                                i3 = 2;
                                                i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                                b2 = byteBuffer.get(iPosition + 6);
                                            }
                                            i2 = (i5 >> i3) | i4;
                                            z = true;
                                        } else {
                                            i3 = 2;
                                            i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                            b2 = byteBuffer.get(iPosition + 7);
                                        }
                                        i5 = b2 & 60;
                                        i2 = (i5 >> i3) | i4;
                                        z = true;
                                    } else {
                                        z = true;
                                        i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                                    }
                                    iZzb = (i2 + (z ? 1 : 0)) * 32;
                                } else {
                                    iZzb = 4096;
                                }
                                z = true;
                            }
                            break;
                        case 9:
                            iZzb = zzadv.zzc(zzeu.zzj(byteBuffer, byteBuffer.position()));
                            if (iZzb == -1) {
                                throw new IllegalArgumentException();
                            }
                            z = true;
                            break;
                        case 10:
                            iZzb = 1024;
                            z = true;
                            break;
                        case 11:
                        case 12:
                            iZzb = 2048;
                            z = true;
                            break;
                        default:
                            switch (i14) {
                                case 14:
                                    int i16 = zzacb.zza;
                                    int iPosition2 = byteBuffer.position();
                                    int iLimit = byteBuffer.limit() - 10;
                                    int i17 = iPosition2;
                                    while (true) {
                                        if (i17 > iLimit) {
                                            i6 = -1;
                                        } else if ((zzeu.zzj(byteBuffer, i17 + 4) & (-2)) == -126718022) {
                                            i6 = i17 - iPosition2;
                                        } else {
                                            i17++;
                                        }
                                    }
                                    if (i6 != -1) {
                                        iZzb = (40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                    } else {
                                        iZzb = 0;
                                    }
                                    break;
                                case 15:
                                    iZzb = 512;
                                    break;
                                case 16:
                                    iZzb = 1024;
                                    break;
                                case 17:
                                    int i18 = zzacf.zza;
                                    byte[] bArr = new byte[16];
                                    int iPosition3 = byteBuffer.position();
                                    byteBuffer.get(bArr);
                                    byteBuffer.position(iPosition3);
                                    iZzb = zzacf.zzb(new zzej(bArr, 16)).zzc;
                                    break;
                                case 18:
                                    iZzb = zzacb.zza(byteBuffer);
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected audio encoding: " + i14);
                            }
                            z = true;
                            break;
                    }
                } else {
                    int i19 = zzadb.zza;
                    if (byteBuffer.getInt(0) == -233094848) {
                        if (byteBuffer.getInt(0) == -398277519) {
                            iZzb = 1024;
                        } else if (byteBuffer.getInt(0) != 622876772) {
                            iZzb = 4096;
                        } else {
                            iPosition = byteBuffer.position();
                            b = byteBuffer.get(iPosition);
                            if (b != -2) {
                                if (b != -1) {
                                    if (b != 31) {
                                        i4 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                        i5 = byteBuffer.get(iPosition + 5) & 252;
                                        i3 = 2;
                                    } else {
                                        i3 = 2;
                                        i4 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                        b2 = byteBuffer.get(iPosition + 6);
                                    }
                                    i2 = (i5 >> i3) | i4;
                                    z = true;
                                } else {
                                    i3 = 2;
                                    i4 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                    b2 = byteBuffer.get(iPosition + 7);
                                }
                                i5 = b2 & 60;
                                i2 = (i5 >> i3) | i4;
                                z = true;
                            } else {
                                z = true;
                                i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                            }
                            iZzb = (i2 + (z ? 1 : 0)) * 32;
                        }
                        z = true;
                    } else {
                        z = true;
                        iZzb = 1024;
                    }
                }
                this.zzF = iZzb;
                if (iZzb == 0) {
                    return z;
                }
            }
            if (this.zzx != null) {
                if (!zzY()) {
                    return false;
                }
                zzO(j);
                this.zzx = null;
            }
            long jZzt = this.zzI + zzeu.zzt(zzL() - this.zzf.zzo(), this.zzq.zza.zzF);
            if (!this.zzG && Math.abs(jZzt - j) > 200000) {
                zzqc zzqcVar2 = this.zzo;
                if (zzqcVar2 != null) {
                    zzqcVar2.zza(new zzqd(j, jZzt));
                }
                this.zzG = true;
            }
            if (this.zzG) {
                if (!zzY()) {
                    return false;
                }
                long j2 = j - jZzt;
                this.zzI += j2;
                this.zzG = false;
                zzO(j);
                zzqc zzqcVar3 = this.zzo;
                if (zzqcVar3 != null && j2 != 0) {
                    ((zzrj) zzqcVar3).zza.zzao();
                }
            }
            if (this.zzq.zzc == 0) {
                this.zzB += (long) byteBuffer.remaining();
            } else {
                this.zzC += ((long) this.zzF) * ((long) i);
            }
            this.zzK = byteBuffer;
            this.zzL = i;
        }
        zzT(j);
        if (!this.zzK.hasRemaining()) {
            this.zzK = null;
            this.zzL = 0;
            return true;
        }
        if (!zzqjVar2.zzi(zzM())) {
            return false;
        }
        zzdx.zzf("DefaultAudioSink", "Resetting stalled audio track");
        zzf();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final boolean zzy() {
        if (zzZ()) {
            return !(zzeu.zza >= 29 && this.zzs.isOffloadedPlayback() && this.zzP) && this.zzi.zzg(zzM());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final boolean zzz() {
        if (zzZ()) {
            return this.zzN && !zzy();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqf
    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        this.zzT = audioDeviceInfo == null ? null : new zzph(audioDeviceInfo);
        zzpg zzpgVar = this.zzu;
        if (zzpgVar != null) {
            zzpgVar.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzs;
        if (audioTrack != null) {
            zzqq.zza(audioTrack, this.zzT);
        }
    }
}
