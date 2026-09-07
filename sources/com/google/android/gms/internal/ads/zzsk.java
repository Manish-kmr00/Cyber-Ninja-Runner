package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzsk implements zzsx {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzdj zzg;
    private boolean zzh;

    public zzsk(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdj zzdjVar = new zzdj(zzdg.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdjVar;
        this.zzf = new AtomicReference();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static /* bridge */ /* synthetic */ void zza(zzsk zzskVar, Message message) {
        zzsj zzsjVar;
        ArrayDeque arrayDeque;
        int i = message.what;
        zzsj zzsjVar2 = null;
        if (i != 1) {
            if (i == 2) {
                zzsjVar = (zzsj) message.obj;
                int i2 = zzsjVar.zza;
                int i3 = zzsjVar.zzb;
                MediaCodec.CryptoInfo cryptoInfo = zzsjVar.zzd;
                long j = zzsjVar.zze;
                int i4 = zzsjVar.zzf;
                try {
                    synchronized (zzb) {
                        zzskVar.zzc.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i4);
                    }
                } catch (RuntimeException e) {
                    zzsh.zza(zzskVar.zzf, null, e);
                }
            } else if (i == 3) {
                zzskVar.zzg.zze();
            } else if (i != 4) {
                zzsh.zza(zzskVar.zzf, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                try {
                    zzskVar.zzc.setParameters((Bundle) message.obj);
                } catch (RuntimeException e2) {
                    zzsh.zza(zzskVar.zzf, null, e2);
                }
            }
            if (zzsjVar2 != null) {
                arrayDeque = zza;
                synchronized (arrayDeque) {
                    arrayDeque.add(zzsjVar2);
                }
            }
        }
        zzsjVar = (zzsj) message.obj;
        int i5 = zzsjVar.zza;
        int i6 = zzsjVar.zzb;
        try {
            zzskVar.zzc.queueInputBuffer(i5, 0, zzsjVar.zzc, zzsjVar.zze, zzsjVar.zzf);
        } catch (RuntimeException e3) {
            zzsh.zza(zzskVar.zzf, null, e3);
        }
        zzsjVar2 = zzsjVar;
        if (zzsjVar2 != null) {
            arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzsjVar2);
            }
        }
    }

    private static zzsj zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new zzsj();
            }
            return (zzsj) arrayDeque.removeFirst();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzdj zzdjVar = this.zzg;
                zzdjVar.zzc();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                zzdjVar.zza();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzd(int i, int i2, int i3, long j, int i4) {
        zzc();
        zzsj zzsjVarZzi = zzi();
        zzsjVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzeu.zza;
        handler.obtainMessage(1, zzsjVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zze(int i, int i2, zzhk zzhkVar, long j, int i3) {
        zzc();
        zzsj zzsjVarZzi = zzi();
        zzsjVarZzi.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzsjVarZzi.zzd;
        cryptoInfo.numSubSamples = zzhkVar.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzhkVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzhkVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzj = zzj(zzhkVar.zzb, cryptoInfo.key);
        bArrZzj.getClass();
        cryptoInfo.key = bArrZzj;
        byte[] bArrZzj2 = zzj(zzhkVar.zza, cryptoInfo.iv);
        bArrZzj2.getClass();
        cryptoInfo.iv = bArrZzj2;
        cryptoInfo.mode = zzhkVar.zzc;
        if (zzeu.zza >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzhkVar.zzg, zzhkVar.zzh));
        }
        this.zze.obtainMessage(2, zzsjVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        int i = zzeu.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final void zzh() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzsi(this, handlerThread.getLooper());
        this.zzh = true;
    }

    private static byte[] zzj(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzk(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
