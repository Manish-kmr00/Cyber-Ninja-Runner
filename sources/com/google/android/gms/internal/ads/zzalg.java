package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalg {
    private boolean zzb;
    private boolean zzc;
    private int[] zzd;
    private int zze;
    private int zzf;
    private Rect zzg;
    private final int[] zza = new int[4];
    private int zzh = -1;
    private int zzi = -1;

    private static int zze(int[] iArr, int i) {
        if (i >= iArr.length) {
            i = 0;
        }
        return iArr[i];
    }

    private static int zzf(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 * 17) << 24);
    }

    private final void zzg(zzej zzejVar, boolean z, Rect rect, int[] iArr) {
        int i;
        int i2;
        int i3 = !z ? 1 : 0;
        int iWidth = rect.width();
        int i4 = i3 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i5 = 0;
            do {
                int i6 = 1;
                int iZzd = 0;
                while (true) {
                    if (iZzd >= i6 || i6 > 64) {
                        i = iZzd & 3;
                        if (iZzd >= 4) {
                            i2 = iZzd >> 2;
                            break;
                        } else {
                            i2 = iWidth;
                            break;
                        }
                    }
                    if (zzejVar.zza() < 4) {
                        i = -1;
                        i2 = 0;
                        break;
                    } else {
                        iZzd = (iZzd << 4) | zzejVar.zzd(4);
                        i6 <<= 2;
                    }
                }
                int iMin = Math.min(i2, iWidth - i5);
                if (iMin > 0) {
                    int i7 = i4 + iMin;
                    Arrays.fill(iArr, i4, i7, this.zza[i]);
                    i5 += iMin;
                    i4 = i7;
                }
            } while (i5 < iWidth);
            i3 += 2;
            if (i3 >= iHeight) {
                return;
            }
            i4 = i3 * iWidth;
            zzejVar.zzf();
        }
    }

    public final zzcu zza(zzek zzekVar) {
        Rect rect;
        if (this.zzd == null || !this.zzb || !this.zzc || (rect = this.zzg) == null || this.zzh == -1 || this.zzi == -1 || rect.width() < 2 || this.zzg.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzg;
        int[] iArr = new int[rect2.width() * rect2.height()];
        zzej zzejVar = new zzej();
        zzekVar.zzL(this.zzh);
        zzejVar.zzj(zzekVar);
        zzg(zzejVar, true, rect2, iArr);
        zzekVar.zzL(this.zzi);
        zzejVar.zzj(zzekVar);
        zzg(zzejVar, false, rect2, iArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(bitmapCreateBitmap);
        zzcsVar.zzh(rect2.left / this.zze);
        zzcsVar.zzi(0);
        zzcsVar.zze(rect2.top / this.zzf, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(rect2.width() / this.zze);
        zzcsVar.zzd(rect2.height() / this.zzf);
        return zzcsVar.zzp();
    }

    public final void zzb(String str) {
        int i;
        String strTrim = str.trim();
        int i2 = zzeu.zza;
        for (String str2 : strTrim.split("\\r?\\n", -1)) {
            if (str2.startsWith("palette: ")) {
                String[] strArrSplit = str2.substring(9).split(StringUtils.COMMA, -1);
                this.zzd = new int[strArrSplit.length];
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    int[] iArr = this.zzd;
                    try {
                        i = Integer.parseInt(strArrSplit[i3].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i3] = i;
                }
            } else if (str2.startsWith("size: ")) {
                String[] strArrSplit2 = str2.substring(6).trim().split(VastAttributes.HORIZONTAL_POSITION, -1);
                if (strArrSplit2.length == 2) {
                    try {
                        this.zze = Integer.parseInt(strArrSplit2[0]);
                        this.zzf = Integer.parseInt(strArrSplit2[1]);
                        this.zzb = true;
                    } catch (RuntimeException e) {
                        zzdx.zzg("VobsubParser", "Parsing IDX failed", e);
                    }
                }
            }
        }
    }

    public final void zzc(zzek zzekVar) {
        int[] iArr = this.zzd;
        if (iArr == null || !this.zzb) {
            return;
        }
        zzekVar.zzM(zzekVar.zzq() - 2);
        int iZzq = zzekVar.zzq();
        while (zzekVar.zzc() < iZzq && zzekVar.zza() > 0) {
            switch (zzekVar.zzm()) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    if (zzekVar.zza() < 2) {
                        return;
                    }
                    int iZzm = zzekVar.zzm();
                    int iZzm2 = zzekVar.zzm();
                    int[] iArr2 = this.zza;
                    iArr2[3] = zze(iArr, iZzm >> 4);
                    iArr2[2] = zze(iArr, iZzm & 15);
                    iArr2[1] = zze(iArr, iZzm2 >> 4);
                    iArr2[0] = zze(iArr, iZzm2 & 15);
                    this.zzc = true;
                    break;
                case 4:
                    if (zzekVar.zza() < 2 || !this.zzc) {
                        return;
                    }
                    int iZzm3 = zzekVar.zzm();
                    int iZzm4 = zzekVar.zzm();
                    int[] iArr3 = this.zza;
                    iArr3[3] = zzf(iArr3[3], iZzm3 >> 4);
                    iArr3[2] = zzf(iArr3[2], iZzm3 & 15);
                    iArr3[1] = zzf(iArr3[1], iZzm4 >> 4);
                    iArr3[0] = zzf(iArr3[0], iZzm4 & 15);
                    break;
                case 5:
                    if (zzekVar.zza() < 6) {
                        return;
                    }
                    int iZzm5 = zzekVar.zzm();
                    int iZzm6 = zzekVar.zzm();
                    int i = iZzm6 >> 4;
                    int iZzm7 = ((iZzm6 & 15) << 8) | zzekVar.zzm();
                    int iZzm8 = zzekVar.zzm();
                    int iZzm9 = zzekVar.zzm();
                    this.zzg = new Rect((iZzm5 << 4) | i, (iZzm8 << 4) | (iZzm9 >> 4), iZzm7 + 1, (((iZzm9 & 15) << 8) | zzekVar.zzm()) + 1);
                    break;
                case 6:
                    if (zzekVar.zza() < 4) {
                        return;
                    }
                    this.zzh = zzekVar.zzq();
                    this.zzi = zzekVar.zzq();
                    break;
                default:
                    return;
            }
        }
    }

    public final void zzd() {
        this.zzc = false;
        this.zzg = null;
        this.zzh = -1;
        this.zzi = -1;
    }
}
