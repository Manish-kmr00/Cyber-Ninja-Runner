package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakm implements zzaka {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakf zzg;
    private final zzake zzh;
    private final zzakl zzi;
    private Bitmap zzj;

    public zzakm(List list) {
        zzek zzekVar = new zzek((byte[]) list.get(0));
        int iZzq = zzekVar.zzq();
        int iZzq2 = zzekVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakf(719, 575, 0, 719, 0, 575);
        this.zzh = new zzake(0, zzg(), zzh(), zzi());
        this.zzi = new zzakl(iZzq, iZzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzake zzc(zzej zzejVar, int i) {
        int[] iArr;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i2 = 8;
        int iZzd5 = zzejVar.zzd(8);
        zzejVar.zzn(8);
        int[] iArrZzg = zzg();
        int[] iArrZzh = zzh();
        int[] iArrZzi = zzi();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzd6 = zzejVar.zzd(i2);
            int iZzd7 = zzejVar.zzd(i2);
            if ((iZzd7 & 128) != 0) {
                iArr = iArrZzg;
            } else {
                iArr = (iZzd7 & 64) != 0 ? iArrZzh : iArrZzi;
            }
            if ((iZzd7 & 1) != 0) {
                iZzd3 = zzejVar.zzd(i2);
                iZzd4 = zzejVar.zzd(i2);
                iZzd = zzejVar.zzd(i2);
                iZzd2 = zzejVar.zzd(i2);
                i3 -= 6;
            } else {
                int iZzd8 = zzejVar.zzd(6) << 2;
                int iZzd9 = zzejVar.zzd(4) << 4;
                i3 -= 4;
                iZzd = zzejVar.zzd(4) << 4;
                iZzd2 = zzejVar.zzd(2) << 6;
                iZzd3 = iZzd8;
                iZzd4 = iZzd9;
            }
            if (iZzd3 == 0) {
                iZzd2 = 255;
            }
            if (iZzd3 == 0) {
                iZzd = 0;
            }
            if (iZzd3 == 0) {
                iZzd4 = 0;
            }
            double d = iZzd3;
            int i4 = zzeu.zza;
            double d2 = iZzd4 - 128;
            double d3 = iZzd - 128;
            iArr[iZzd6] = zzb((byte) (255 - (iZzd2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            iZzd5 = iZzd5;
            i2 = 8;
        }
        return new zzake(iZzd5, iArrZzg, iArrZzh, iArrZzi);
    }

    private static zzakg zzd(zzej zzejVar) {
        int iZzd = zzejVar.zzd(16);
        zzejVar.zzn(4);
        int iZzd2 = zzejVar.zzd(2);
        boolean zZzp = zzejVar.zzp();
        zzejVar.zzn(1);
        byte[] bArr = zzeu.zzc;
        byte[] bArr2 = zzeu.zzc;
        if (iZzd2 == 1) {
            zzejVar.zzn(zzejVar.zzd(8) * 16);
        } else if (iZzd2 == 0) {
            int iZzd3 = zzejVar.zzd(16);
            int iZzd4 = zzejVar.zzd(16);
            if (iZzd3 > 0) {
                bArr = new byte[iZzd3];
                zzejVar.zzi(bArr, 0, iZzd3);
            }
            if (iZzd4 > 0) {
                bArr2 = new byte[iZzd4];
                zzejVar.zzi(bArr2, 0, iZzd4);
            } else {
                bArr2 = bArr;
            }
        }
        return new zzakg(iZzd, zZzp, bArr, bArr2);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0219  */
    /* JADX WARN: Code duplicated, block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0222 A[SYNTHETIC] */
    private static void zze(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        char c;
        char c2;
        int iZzd;
        int i4;
        int iZzd2;
        int iZzd3;
        int i5;
        int i6;
        int iZzd4;
        zzej zzejVar = new zzej(bArr, bArr.length);
        int i7 = i2;
        int i8 = i3;
        byte[] bArrZzf = null;
        byte[] bArrZzf2 = null;
        byte[] bArrZzf3 = null;
        while (zzejVar.zza() != 0) {
            int i9 = 8;
            int iZzd5 = zzejVar.zzd(8);
            if (iZzd5 != 240) {
                int i10 = 4;
                int i11 = 1;
                int i12 = 2;
                switch (iZzd5) {
                    case 16:
                        int i13 = 1;
                        if (i == 3) {
                            if (bArrZzf == null) {
                                bArr3 = zzb;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrZzf;
                            }
                        } else if (i != 2) {
                            bArr2 = null;
                        } else if (bArrZzf3 == null) {
                            bArr3 = zza;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrZzf3;
                        }
                        int i14 = i7;
                        int i15 = 0;
                        while (true) {
                            int iZzd6 = zzejVar.zzd(2);
                            if (iZzd6 != 0) {
                                iZzd = i13;
                            } else {
                                if (zzejVar.zzp()) {
                                    iZzd = zzejVar.zzd(3) + 3;
                                    iZzd6 = zzejVar.zzd(2);
                                } else {
                                    if (zzejVar.zzp()) {
                                        iZzd = i13;
                                        iZzd6 = 0;
                                    } else {
                                        int iZzd7 = zzejVar.zzd(2);
                                        if (iZzd7 == 0) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i13;
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else if (iZzd7 == i13) {
                                            c = 4;
                                            c2 = '\b';
                                            i15 = i15;
                                            iZzd = 2;
                                            iZzd6 = 0;
                                        } else if (iZzd7 == 2) {
                                            c = 4;
                                            c2 = '\b';
                                            iZzd = zzejVar.zzd(4) + 12;
                                            iZzd6 = zzejVar.zzd(2);
                                            i15 = i15;
                                        } else if (iZzd7 != 3) {
                                            iZzd6 = 0;
                                            iZzd = 0;
                                        } else {
                                            c2 = '\b';
                                            iZzd = zzejVar.zzd(8) + 29;
                                            iZzd6 = zzejVar.zzd(2);
                                            i15 = i15;
                                            c = 4;
                                        }
                                    }
                                    c = 4;
                                    c2 = '\b';
                                }
                                if (iZzd == 0 && paint != null) {
                                    int i16 = i8 + 1;
                                    float f = i8;
                                    if (bArr2 != 0) {
                                        iZzd6 = bArr2[iZzd6];
                                    }
                                    paint.setColor(iArr[iZzd6]);
                                    canvas.drawRect(i14, f, i14 + iZzd, i16, paint);
                                }
                                i14 += iZzd;
                                if (i15 != 0) {
                                    zzejVar.zzf();
                                    i7 = i14;
                                } else {
                                    i15 = i15;
                                    i13 = 1;
                                }
                            }
                            c = 4;
                            c2 = '\b';
                            if (iZzd == 0) {
                            }
                            i14 += iZzd;
                            if (i15 != 0) {
                                zzejVar.zzf();
                                i7 = i14;
                            } else {
                                i15 = i15;
                                i13 = 1;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrZzf2 == null ? zzc : bArrZzf2 : null;
                        int i17 = i7;
                        boolean z = false;
                        while (true) {
                            int iZzd8 = zzejVar.zzd(i10);
                            if (iZzd8 != 0) {
                                i4 = 1;
                                z = z;
                            } else if (zzejVar.zzp()) {
                                if (zzejVar.zzp()) {
                                    int iZzd9 = zzejVar.zzd(i12);
                                    if (iZzd9 == 0) {
                                        i4 = 1;
                                    } else if (iZzd9 == 1) {
                                        i4 = i12;
                                    } else if (iZzd9 == i12) {
                                        iZzd2 = zzejVar.zzd(i10) + 9;
                                        iZzd3 = zzejVar.zzd(i10);
                                    } else if (iZzd9 != 3) {
                                        z = z;
                                        iZzd8 = 0;
                                        i4 = 0;
                                    } else {
                                        iZzd2 = zzejVar.zzd(i9) + 25;
                                        iZzd3 = zzejVar.zzd(i10);
                                    }
                                    iZzd8 = 0;
                                } else {
                                    iZzd2 = zzejVar.zzd(i12) + i10;
                                    iZzd3 = zzejVar.zzd(i10);
                                }
                                z = z;
                                i4 = iZzd2;
                                iZzd8 = iZzd3;
                            } else {
                                int iZzd10 = zzejVar.zzd(3);
                                if (iZzd10 != 0) {
                                    i4 = iZzd10 + 2;
                                    iZzd8 = 0;
                                } else {
                                    z = true;
                                    iZzd8 = 0;
                                    i4 = 0;
                                }
                            }
                            if (i4 == 0 || paint == null) {
                                i5 = i12;
                            } else {
                                int i18 = i8 + 1;
                                float f2 = i8;
                                if (bArr4 != 0) {
                                    iZzd8 = bArr4[iZzd8];
                                }
                                paint.setColor(iArr[iZzd8]);
                                i5 = 2;
                                canvas.drawRect(i17, f2, i17 + i4, i18, paint);
                            }
                            i17 += i4;
                            if (z) {
                                zzejVar.zzf();
                                i7 = i17;
                            } else {
                                i12 = i5;
                                z = z;
                                i10 = 4;
                                i9 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i19 = i7;
                        int i20 = 0;
                        while (true) {
                            int iZzd11 = zzejVar.zzd(8);
                            if (iZzd11 != 0) {
                                i6 = i20;
                                iZzd4 = i11;
                            } else if (zzejVar.zzp()) {
                                i6 = i20;
                                iZzd4 = zzejVar.zzd(7);
                                iZzd11 = zzejVar.zzd(8);
                            } else {
                                int iZzd12 = zzejVar.zzd(7);
                                if (iZzd12 != 0) {
                                    i6 = i20;
                                    iZzd4 = iZzd12;
                                    iZzd11 = 0;
                                } else {
                                    i6 = i11;
                                    iZzd11 = 0;
                                    iZzd4 = 0;
                                }
                            }
                            if (iZzd4 != 0 && paint != null) {
                                paint.setColor(iArr[iZzd11]);
                                canvas.drawRect(i19, i8, i19 + iZzd4, i8 + 1, paint);
                            }
                            i19 += iZzd4;
                            if (i6 != 0) {
                                i7 = i19;
                            } else {
                                i11 = i11;
                                i20 = i6;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iZzd5) {
                            case 32:
                                bArrZzf3 = zzf(4, 4, zzejVar);
                                break;
                            case 33:
                                bArrZzf = zzf(4, 8, zzejVar);
                                break;
                            case 34:
                                bArrZzf2 = zzf(16, 8, zzejVar);
                                break;
                        }
                        break;
                }
            } else {
                i8 += 2;
                i7 = i2;
            }
        }
    }

    private static byte[] zzf(int i, int i2, zzej zzejVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzejVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzb(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzb(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzajs zzajsVar;
        char c;
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        zzakj zzakjVar;
        int i6;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int iZzd4;
        int i7;
        int iZzd5;
        zzej zzejVar = new zzej(bArr, i + i2);
        zzejVar.zzl(i);
        while (zzejVar.zza() >= 48 && zzejVar.zzd(8) == 15) {
            zzakl zzaklVar = this.zzi;
            int iZzd6 = zzejVar.zzd(8);
            int iZzd7 = zzejVar.zzd(16);
            int iZzd8 = zzejVar.zzd(16);
            int iZzb = zzejVar.zzb() + iZzd8;
            if (iZzd8 * 8 > zzejVar.zza()) {
                zzdx.zzf("DvbParser", "Data field length exceeds limit");
                zzejVar.zzn(zzejVar.zza());
            } else {
                switch (iZzd6) {
                    case 16:
                        if (iZzd7 == zzaklVar.zza) {
                            zzakh zzakhVar = zzaklVar.zzi;
                            int iZzd9 = zzejVar.zzd(8);
                            int iZzd10 = zzejVar.zzd(4);
                            int iZzd11 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i8 = iZzd8 - 2; i8 > 0; i8 -= 6) {
                                int iZzd12 = zzejVar.zzd(8);
                                zzejVar.zzn(8);
                                sparseArray.put(iZzd12, new zzaki(zzejVar.zzd(16), zzejVar.zzd(16)));
                            }
                            zzakh zzakhVar2 = new zzakh(iZzd9, iZzd10, iZzd11, sparseArray);
                            if (zzakhVar2.zzb != 0) {
                                zzaklVar.zzi = zzakhVar2;
                                zzaklVar.zzc.clear();
                                zzaklVar.zzd.clear();
                                zzaklVar.zze.clear();
                            } else if (zzakhVar != null) {
                                if (zzakhVar.zza != zzakhVar2.zza) {
                                    zzaklVar.zzi = zzakhVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzakh zzakhVar3 = zzaklVar.zzi;
                        if (iZzd7 == zzaklVar.zza && zzakhVar3 != null) {
                            int iZzd13 = zzejVar.zzd(8);
                            zzejVar.zzn(4);
                            boolean zZzp = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd14 = zzejVar.zzd(16);
                            int iZzd15 = zzejVar.zzd(16);
                            int iZzd16 = zzejVar.zzd(3);
                            int iZzd17 = zzejVar.zzd(3);
                            zzejVar.zzn(2);
                            int iZzd18 = zzejVar.zzd(8);
                            int iZzd19 = zzejVar.zzd(8);
                            int iZzd20 = zzejVar.zzd(4);
                            int iZzd21 = zzejVar.zzd(2);
                            zzejVar.zzn(2);
                            int i9 = iZzd8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i9 > 0) {
                                int iZzd22 = zzejVar.zzd(16);
                                int iZzd23 = zzejVar.zzd(2);
                                int iZzd24 = zzejVar.zzd(2);
                                int iZzd25 = zzejVar.zzd(12);
                                zzejVar.zzn(4);
                                int iZzd26 = zzejVar.zzd(12);
                                int i10 = i9 - 6;
                                if (iZzd23 == 1) {
                                    i9 -= 8;
                                    i6 = iZzd23;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else if (iZzd23 == 2) {
                                    iZzd23 = 2;
                                    i9 -= 8;
                                    i6 = iZzd23;
                                    iZzd = zzejVar.zzd(8);
                                    iZzd2 = zzejVar.zzd(8);
                                } else {
                                    i6 = iZzd23;
                                    i9 = i10;
                                    iZzd = 0;
                                    iZzd2 = 0;
                                }
                                sparseArray2.put(iZzd22, new zzakk(i6, iZzd24, iZzd25, iZzd26, iZzd, iZzd2));
                            }
                            zzakj zzakjVar2 = new zzakj(iZzd13, zZzp, iZzd14, iZzd15, iZzd16, iZzd17, iZzd18, iZzd19, iZzd20, iZzd21, sparseArray2);
                            if (zzakhVar3.zzb == 0 && (zzakjVar = (zzakj) zzaklVar.zzc.get(zzakjVar2.zza)) != null) {
                                int i11 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzakjVar.zzj;
                                    if (i11 < sparseArray3.size()) {
                                        zzakjVar2.zzj.put(sparseArray3.keyAt(i11), (zzakk) sparseArray3.valueAt(i11));
                                        i11++;
                                    }
                                }
                            }
                            zzaklVar.zzc.put(zzakjVar2.zza, zzakjVar2);
                        }
                        break;
                    case 18:
                        if (iZzd7 == zzaklVar.zza) {
                            zzake zzakeVarZzc = zzc(zzejVar, iZzd8);
                            zzaklVar.zzd.put(zzakeVarZzc.zza, zzakeVarZzc);
                        } else if (iZzd7 == zzaklVar.zzb) {
                            zzake zzakeVarZzc2 = zzc(zzejVar, iZzd8);
                            zzaklVar.zzf.put(zzakeVarZzc2.zza, zzakeVarZzc2);
                        }
                        break;
                    case 19:
                        if (iZzd7 == zzaklVar.zza) {
                            zzakg zzakgVarZzd = zzd(zzejVar);
                            zzaklVar.zze.put(zzakgVarZzd.zza, zzakgVarZzd);
                        } else if (iZzd7 == zzaklVar.zzb) {
                            zzakg zzakgVarZzd2 = zzd(zzejVar);
                            zzaklVar.zzg.put(zzakgVarZzd2.zza, zzakgVarZzd2);
                        }
                        break;
                    case 20:
                        if (iZzd7 == zzaklVar.zza) {
                            zzejVar.zzn(4);
                            boolean zZzp2 = zzejVar.zzp();
                            zzejVar.zzn(3);
                            int iZzd27 = zzejVar.zzd(16);
                            int iZzd28 = zzejVar.zzd(16);
                            if (zZzp2) {
                                int iZzd29 = zzejVar.zzd(16);
                                iZzd3 = zzejVar.zzd(16);
                                iZzd5 = zzejVar.zzd(16);
                                iZzd4 = zzejVar.zzd(16);
                                i7 = iZzd29;
                            } else {
                                iZzd3 = iZzd27;
                                iZzd4 = iZzd28;
                                i7 = 0;
                                iZzd5 = 0;
                            }
                            zzaklVar.zzh = new zzakf(iZzd27, iZzd28, i7, iZzd3, iZzd5, iZzd4);
                        }
                        break;
                }
                zzejVar.zzo(iZzb - zzejVar.zzb());
            }
        }
        zzakl zzaklVar2 = this.zzi;
        zzakh zzakhVar4 = zzaklVar2.zzi;
        if (zzakhVar4 == null) {
            zzajsVar = new zzajs(zzfww.zzn(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakf zzakfVar = zzaklVar2.zzh;
            if (zzakfVar == null) {
                zzakfVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakfVar.zza + 1 != bitmap.getWidth() || zzakfVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzakfVar.zza + 1, zzakfVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakhVar4.zzc;
            int i12 = 0;
            while (i12 < sparseArray4.size()) {
                Canvas canvas = this.zzf;
                canvas.save();
                zzaki zzakiVar = (zzaki) sparseArray4.valueAt(i12);
                zzakj zzakjVar3 = (zzakj) zzaklVar2.zzc.get(sparseArray4.keyAt(i12));
                int i13 = zzakiVar.zza + zzakfVar.zzc;
                int i14 = zzakiVar.zzb + zzakfVar.zze;
                int i15 = zzakjVar3.zzc;
                int i16 = i13 + i15;
                int iMin = Math.min(i16, zzakfVar.zzd);
                int i17 = zzakjVar3.zzd;
                int i18 = i14 + i17;
                canvas.clipRect(i13, i14, iMin, Math.min(i18, zzakfVar.zzf));
                int i19 = zzakjVar3.zzf;
                zzake zzakeVar = (zzake) zzaklVar2.zzd.get(i19);
                if (zzakeVar == null && (zzakeVar = (zzake) zzaklVar2.zzf.get(i19)) == null) {
                    zzakeVar = this.zzh;
                }
                SparseArray sparseArray5 = zzakjVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i20 = i16;
                int i21 = 0;
                while (i21 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i21);
                    SparseArray sparseArray7 = sparseArray5;
                    zzakk zzakkVar = (zzakk) sparseArray5.valueAt(i21);
                    int i22 = i15;
                    zzakg zzakgVar = (zzakg) zzaklVar2.zze.get(iKeyAt);
                    if (zzakgVar == null) {
                        zzakgVar = (zzakg) zzaklVar2.zzg.get(iKeyAt);
                    }
                    if (zzakgVar != null) {
                        Paint paint = zzakgVar.zzb ? null : this.zzd;
                        int i23 = zzakjVar3.zze;
                        int i24 = zzakkVar.zza + i13;
                        int i25 = zzakkVar.zzb + i14;
                        int i26 = i13;
                        int[] iArr = i23 == 3 ? zzakeVar.zzd : i23 == 2 ? zzakeVar.zzc : zzakeVar.zzb;
                        i5 = i22;
                        i4 = i26;
                        zze(zzakgVar.zzc, iArr, i23, i24, i25, paint, canvas);
                        zze(zzakgVar.zzd, iArr, i23, i24, i25 + 1, paint, canvas);
                    } else {
                        i4 = i13;
                        i5 = i22;
                    }
                    i21++;
                    i13 = i4;
                    zzakjVar3 = zzakjVar3;
                    i20 = i20;
                    sparseArray5 = sparseArray7;
                    zzaklVar2 = zzaklVar2;
                    i12 = i12;
                    arrayList = arrayList;
                    zzakfVar = zzakfVar;
                    i17 = i17;
                    i15 = i5;
                }
                zzakl zzaklVar3 = zzaklVar2;
                zzakf zzakfVar2 = zzakfVar;
                int i27 = i17;
                int i28 = i12;
                ArrayList arrayList2 = arrayList;
                int i29 = i15;
                int i30 = i13;
                zzakj zzakjVar4 = zzakjVar3;
                int i31 = i20;
                float f = i14;
                float f2 = i30;
                if (zzakjVar4.zzb) {
                    int i32 = zzakjVar4.zze;
                    if (i32 == 3) {
                        i3 = zzakeVar.zzd[zzakjVar4.zzg];
                        c3 = 2;
                    } else {
                        c3 = 2;
                        i3 = i32 == 2 ? zzakeVar.zzc[zzakjVar4.zzh] : zzakeVar.zzb[zzakjVar4.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i3);
                    float f3 = i18;
                    float f4 = i31;
                    c = c3;
                    c2 = 3;
                    canvas.drawRect(f2, f, f4, f3, paint2);
                } else {
                    c = 2;
                    c2 = 3;
                }
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(Bitmap.createBitmap(this.zzj, i30, i14, i29, i27));
                zzakfVar = zzakfVar2;
                float f5 = zzakfVar.zza;
                zzcsVar.zzh(f2 / f5);
                zzcsVar.zzi(0);
                float f6 = zzakfVar.zzb;
                zzcsVar.zze(f / f6, 0);
                zzcsVar.zzf(0);
                zzcsVar.zzk(i29 / f5);
                zzcsVar.zzd(i27 / f6);
                arrayList2.add(zzcsVar.zzp());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                sparseArray4 = sparseArray6;
                arrayList = arrayList2;
                i12 = i28 + 1;
                zzaklVar2 = zzaklVar3;
            }
            zzajsVar = new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdkVar.zza(zzajsVar);
    }
}
