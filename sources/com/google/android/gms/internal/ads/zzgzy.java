package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgzy extends zzgwn {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgwn zzd;
    private final zzgwn zze;
    private final int zzf;
    private final int zzg;

    private zzgzy(zzgwn zzgwnVar, zzgwn zzgwnVar2) {
        this.zzd = zzgwnVar;
        this.zze = zzgwnVar2;
        int iZzd = zzgwnVar.zzd();
        this.zzf = iZzd;
        this.zzc = iZzd + zzgwnVar2.zzd();
        this.zzg = Math.max(zzgwnVar.zzf(), zzgwnVar2.zzf()) + 1;
    }

    static zzgwn zzC(zzgwn zzgwnVar, zzgwn zzgwnVar2) {
        if (zzgwnVar2.zzd() == 0) {
            return zzgwnVar;
        }
        if (zzgwnVar.zzd() == 0) {
            return zzgwnVar2;
        }
        int iZzd = zzgwnVar.zzd() + zzgwnVar2.zzd();
        if (iZzd < 128) {
            return zzD(zzgwnVar, zzgwnVar2);
        }
        if (zzgwnVar instanceof zzgzy) {
            zzgzy zzgzyVar = (zzgzy) zzgwnVar;
            zzgwn zzgwnVar3 = zzgzyVar.zze;
            if (zzgwnVar3.zzd() + zzgwnVar2.zzd() < 128) {
                return new zzgzy(zzgzyVar.zzd, zzD(zzgwnVar3, zzgwnVar2));
            }
            zzgwn zzgwnVar4 = zzgzyVar.zzd;
            if (zzgwnVar4.zzf() > zzgwnVar3.zzf() && zzgzyVar.zzg > zzgwnVar2.zzf()) {
                return new zzgzy(zzgwnVar4, new zzgzy(zzgwnVar3, zzgwnVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgwnVar.zzf(), zzgwnVar2.zzf()) + 1) ? new zzgzy(zzgwnVar, zzgwnVar2) : zzgzv.zza(new zzgzv(null), zzgwnVar, zzgwnVar2);
    }

    private static zzgwn zzD(zzgwn zzgwnVar, zzgwn zzgwnVar2) {
        int iZzd = zzgwnVar.zzd();
        int iZzd2 = zzgwnVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgwnVar.zzz(bArr, 0, 0, iZzd);
        zzgwnVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgwk(bArr);
    }

    static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgwn)) {
            return false;
        }
        zzgwn zzgwnVar = (zzgwn) obj;
        int i = this.zzc;
        if (i != zzgwnVar.zzd()) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgwnVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzgzx zzgzxVar = null;
        zzgzw zzgzwVar = new zzgzw(this, zzgzxVar);
        zzgwj zzgwjVarZza = zzgzwVar.next();
        zzgzw zzgzwVar2 = new zzgzw(zzgwnVar, zzgzxVar);
        zzgwj zzgwjVarZza2 = zzgzwVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int iZzd = zzgwjVarZza.zzd() - i2;
            int iZzd2 = zzgwjVarZza2.zzd() - i3;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i2 == 0 ? zzgwjVarZza.zzg(zzgwjVarZza2, i3, iMin) : zzgwjVarZza2.zzg(zzgwjVarZza, i2, iMin))) {
                return false;
            }
            i4 += iMin;
            if (i4 >= i) {
                if (i4 == i) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzgwjVarZza = zzgzwVar.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
            if (iMin == iZzd2) {
                zzgwjVarZza = zzgwjVarZza;
                zzgwjVarZza2 = zzgzwVar2.next();
                i3 = 0;
            } else {
                zzgwjVarZza = zzgwjVarZza;
                i3 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwn, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzgzu(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final byte zza(int i) {
        zzy(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final zzgwn zzk(int i, int i2) {
        int i3 = this.zzc;
        int iZzq = zzq(i, i2, i3);
        if (iZzq == 0) {
            return zzgwn.zzb;
        }
        if (iZzq == i3) {
            return this;
        }
        int i4 = this.zzf;
        if (i2 <= i4) {
            return this.zzd.zzk(i, i2);
        }
        int i5 = i2 - i4;
        if (i >= i4) {
            return this.zze.zzk(i - i4, i5);
        }
        zzgwn zzgwnVar = this.zzd;
        return new zzgzy(zzgwnVar.zzk(i, zzgwnVar.zzd()), this.zze.zzk(0, i5));
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final zzgwt zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        byte b = 0;
        zzgzw zzgzwVar = new zzgzw(this, null);
        while (zzgzwVar.hasNext()) {
            arrayList.add(zzgzwVar.next().zzn());
        }
        int i = zzgwt.zze;
        int i2 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        return i2 == 2 ? new zzgwp(arrayList, iRemaining, true, b == true ? 1 : 0) : zzgwt.zzG(new zzgyl(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    protected final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    final void zzo(zzgwe zzgweVar) throws IOException {
        this.zzd.zzo(zzgweVar);
        this.zze.zzo(zzgweVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    public final boolean zzp() {
        zzgwn zzgwnVar = this.zzd;
        zzgwn zzgwnVar2 = this.zze;
        return zzgwnVar2.zzj(zzgwnVar.zzj(0, 0, this.zzf), 0, zzgwnVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwn
    /* JADX INFO: renamed from: zzs */
    public final zzgwi iterator() {
        return new zzgzu(this);
    }
}
