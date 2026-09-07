package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgwr extends zzgwt {
    public static final /* synthetic */ int zza = 0;
    private final ByteBuffer zzf;
    private final long zzg;
    private long zzh;
    private long zzi;
    private final long zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    /* synthetic */ zzgwr(ByteBuffer byteBuffer, boolean z, zzgws zzgwsVar) {
        super(null);
        this.zzm = Integer.MAX_VALUE;
        this.zzf = byteBuffer.duplicate();
        long jZze = zzhas.zze(byteBuffer);
        this.zzg = jZze;
        this.zzh = ((long) byteBuffer.limit()) + jZze;
        long jPosition = jZze + ((long) byteBuffer.position());
        this.zzi = jPosition;
        this.zzj = jPosition;
    }

    private final int zzC() {
        return (int) (this.zzh - this.zzi);
    }

    private final void zzI() {
        long j = this.zzh + ((long) this.zzk);
        this.zzh = j;
        int i = (int) (j - this.zzj);
        int i2 = this.zzm;
        if (i <= i2) {
            this.zzk = 0;
            return;
        }
        int i3 = i - i2;
        this.zzk = i3;
        this.zzh = j - ((long) i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final boolean zzA() throws IOException {
        return this.zzi == this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final boolean zzB() throws IOException {
        return zzq() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzc() {
        return (int) (this.zzi - this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zze() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzf() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        long j = this.zzi;
        if (this.zzh - j < 4) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzi = 4 + j;
        int iZza = zzhas.zza(j) & 255;
        int iZza2 = zzhas.zza(1 + j) & 255;
        int iZza3 = zzhas.zza(2 + j) & 255;
        return ((zzhas.zza(j + 3) & 255) << 24) | (iZza2 << 8) | iZza | (iZza3 << 16);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzj() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzk() throws IOException {
        return zzD(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzl = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzl = iZzi;
        if ((iZzi >>> 3) != 0) {
            return iZzi;
        }
        throw new zzgyk("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzm() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final long zzn() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        long j = this.zzi;
        if (this.zzh - j < 8) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzi = 8 + j;
        long jZza = zzhas.zza(j);
        long jZza2 = zzhas.zza(1 + j);
        long jZza3 = zzhas.zza(2 + j);
        long jZza4 = zzhas.zza(3 + j);
        long jZza5 = zzhas.zza(4 + j);
        return ((((long) zzhas.zza(j + 7)) & 255) << 56) | (jZza & 255) | ((jZza2 & 255) << 8) | ((jZza3 & 255) << 16) | ((jZza4 & 255) << 24) | ((jZza5 & 255) << 32) | ((zzhas.zza(5 + j) & 255) << 40) | ((zzhas.zza(6 + j) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final long zzs() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final long zzt() throws IOException {
        return zzF(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final long zzu() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final zzgwn zzv() throws IOException {
        int iZzi = zzi();
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return zzgwn.zzb;
            }
            if (iZzi < 0) {
                throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[iZzi];
        long j = iZzi;
        zzhas.zzo(this.zzi, bArr, 0L, j);
        this.zzi += j;
        zzgwn zzgwnVar = zzgwn.zzb;
        return new zzgwk(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final String zzw() throws IOException {
        int iZzi = zzi();
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[iZzi];
        long j = iZzi;
        zzhas.zzo(this.zzi, bArr, 0L, j);
        String str = new String(bArr, zzgyi.zza);
        this.zzi += j;
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final String zzx() throws IOException {
        int iZzi = zzi();
        if (iZzi > 0 && iZzi <= zzC()) {
            String strZzg = zzhax.zzg(this.zzf, (int) (this.zzi - this.zzg), iZzi);
            this.zzi += (long) iZzi;
            return strZzg;
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi <= 0) {
            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final void zzy(int i) throws zzgyk {
        if (this.zzl != i) {
            throw new zzgyk("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final void zzz(int i) {
        this.zzm = i;
        zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzgwt
    public final int zzd(int i) throws zzgyk {
        if (i < 0) {
            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iZzc = i + zzc();
        int i2 = this.zzm;
        if (iZzc > i2) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzm = iZzc;
        zzI();
        return i2;
    }

    final long zzr() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            long j2 = this.zzi;
            if (j2 == this.zzh) {
                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.zzi = 1 + j2;
            byte bZza = zzhas.zza(j2);
            j |= ((long) (bZza & 127)) << i;
            if ((bZza & 128) == 0) {
                return j;
            }
        }
        throw new zzgyk("CodedInputStream encountered a malformed varint.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        if (com.google.android.gms.internal.ads.zzhas.zza(r3) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzi() throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.zzi
            long r2 = r9.zzh
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L92
        La:
            r2 = 1
            long r2 = r2 + r0
            byte r4 = com.google.android.gms.internal.ads.zzhas.zza(r0)
            if (r4 < 0) goto L16
            r9.zzi = r2
            return r4
        L16:
            long r5 = r9.zzh
            long r5 = r5 - r2
            r7 = 9
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L92
            r5 = 2
            long r5 = r5 + r0
            byte r2 = com.google.android.gms.internal.ads.zzhas.zza(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r4
            if (r2 >= 0) goto L2e
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L8f
        L2e:
            r3 = 3
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhas.zza(r5)
            int r5 = r5 << 14
            r2 = r2 ^ r5
            if (r2 < 0) goto L3e
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L3c:
            r5 = r3
            goto L8f
        L3e:
            r5 = 4
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhas.zza(r3)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L4f
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L8f
        L4f:
            r3 = 5
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhas.zza(r5)
            int r6 = r5 << 28
            r2 = r2 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r6
            if (r5 >= 0) goto L8d
            r5 = 6
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhas.zza(r3)
            if (r3 >= 0) goto L8b
            r3 = 7
            long r3 = r3 + r0
            byte r5 = com.google.android.gms.internal.ads.zzhas.zza(r5)
            if (r5 >= 0) goto L8d
            r5 = 8
            long r5 = r5 + r0
            byte r3 = com.google.android.gms.internal.ads.zzhas.zza(r3)
            if (r3 >= 0) goto L8b
            long r3 = r0 + r7
            byte r5 = com.google.android.gms.internal.ads.zzhas.zza(r5)
            if (r5 >= 0) goto L8d
            r5 = 10
            long r5 = r5 + r0
            byte r0 = com.google.android.gms.internal.ads.zzhas.zza(r3)
            if (r0 < 0) goto L92
        L8b:
            r0 = r2
            goto L8f
        L8d:
            r0 = r2
            goto L3c
        L8f:
            r9.zzi = r5
            return r0
        L92:
            long r0 = r9.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwr.zzi():int");
    }

    public final long zzq() throws IOException {
        long j;
        long j2;
        int i;
        long j3 = this.zzi;
        if (this.zzh != j3) {
            long j4 = 1 + j3;
            byte bZza = zzhas.zza(j3);
            if (bZza >= 0) {
                this.zzi = j4;
                return bZza;
            }
            if (this.zzh - j4 >= 9) {
                long j5 = 2 + j3;
                int iZza = (zzhas.zza(j4) << 7) ^ bZza;
                if (iZza >= 0) {
                    long j6 = 3 + j3;
                    int iZza2 = iZza ^ (zzhas.zza(j5) << Ascii.SO);
                    if (iZza2 < 0) {
                        j5 = 4 + j3;
                        int iZza3 = iZza2 ^ (zzhas.zza(j6) << Ascii.NAK);
                        if (iZza3 < 0) {
                            i = (-2080896) ^ iZza3;
                        } else {
                            j6 = 5 + j3;
                            long jZza = (((long) zzhas.zza(j5)) << 28) ^ ((long) iZza3);
                            if (jZza >= 0) {
                                j = 266354560 ^ jZza;
                            } else {
                                long j7 = 6 + j3;
                                long jZza2 = (((long) zzhas.zza(j6)) << 35) ^ jZza;
                                if (jZza2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    j5 = j3 + 7;
                                    long jZza3 = jZza2 ^ (((long) zzhas.zza(j7)) << 42);
                                    if (jZza3 >= 0) {
                                        j = 4363953127296L ^ jZza3;
                                    } else {
                                        j7 = 8 + j3;
                                        jZza2 = jZza3 ^ (((long) zzhas.zza(j5)) << 49);
                                        if (jZza2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j5 = j3 + 9;
                                            long jZza4 = (jZza2 ^ (((long) zzhas.zza(j7)) << 56)) ^ 71499008037633920L;
                                            if (jZza4 < 0) {
                                                long j8 = j3 + 10;
                                                if (zzhas.zza(j5) >= 0) {
                                                    j5 = j8;
                                                }
                                            }
                                            j = jZza4;
                                        }
                                    }
                                }
                                j = j2 ^ jZza2;
                                j5 = j7;
                            }
                        }
                        this.zzi = j5;
                        return j;
                    }
                    j = iZza2 ^ 16256;
                    j5 = j6;
                    this.zzi = j5;
                    return j;
                }
                i = iZza ^ (-128);
                j = i;
                this.zzi = j5;
                return j;
            }
        }
        return zzr();
    }
}
