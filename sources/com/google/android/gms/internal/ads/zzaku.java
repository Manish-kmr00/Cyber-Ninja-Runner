package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaku implements zzaka {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzek zze = new zzek();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j2 = j + (Long.parseLong(strGroup2) * 60000);
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j3 = j2 + (Long.parseLong(strGroup3) * 1000);
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x0132  */
    /* JADX WARN: Code duplicated, block: B:94:0x018c  */
    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(byte[] bArr, int i, int i2, zzajz zzajzVar, zzdk zzdkVar) {
        zzek zzekVar;
        String str;
        byte b;
        byte b2;
        int i3;
        zzcu zzcuVarZzp;
        zzaku zzakuVar = this;
        zzek zzekVar2 = zzakuVar.zze;
        zzekVar2.zzJ(bArr, i + i2);
        zzekVar2.zzL(i);
        Charset charsetZzC = zzekVar2.zzC();
        if (charsetZzC == null) {
            charsetZzC = StandardCharsets.UTF_8;
        }
        while (true) {
            String strZzz = zzekVar2.zzz(charsetZzC);
            if (strZzz == null) {
                return;
            }
            if (strZzz.length() != 0) {
                try {
                    Integer.parseInt(strZzz);
                    zzek zzekVar3 = zzakuVar.zze;
                    String strZzz2 = zzekVar3.zzz(charsetZzC);
                    if (strZzz2 == null) {
                        zzdx.zzf("SubripParser", "Unexpected end");
                        return;
                    }
                    Matcher matcher = zza.matcher(strZzz2);
                    if (matcher.matches()) {
                        long jZzc = zzc(matcher, 1);
                        long jZzc2 = zzc(matcher, 6);
                        StringBuilder sb = zzakuVar.zzc;
                        int i4 = 0;
                        sb.setLength(0);
                        ArrayList arrayList = zzakuVar.zzd;
                        arrayList.clear();
                        String strZzz3 = zzekVar3.zzz(charsetZzC);
                        while (!TextUtils.isEmpty(strZzz3)) {
                            if (sb.length() > 0) {
                                sb.append("<br>");
                            }
                            String strTrim = strZzz3.trim();
                            StringBuilder sb2 = new StringBuilder(strTrim);
                            Matcher matcher2 = zzb.matcher(strTrim);
                            int i5 = i4;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList.add(strGroup);
                                int iStart = matcher2.start() - i5;
                                int length = strGroup.length();
                                sb2.replace(iStart, iStart + length, "");
                                i5 += length;
                                zzekVar2 = zzekVar2;
                            }
                            sb.append(sb2.toString());
                            strZzz3 = zzekVar3.zzz(charsetZzC);
                            i4 = 0;
                        }
                        zzekVar = zzekVar2;
                        Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                        int i6 = 0;
                        while (true) {
                            if (i6 < arrayList.size()) {
                                str = (String) arrayList.get(i6);
                                if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                    i6++;
                                }
                            } else {
                                str = null;
                            }
                        }
                        zzcs zzcsVar = new zzcs();
                        zzcsVar.zzl(spannedFromHtml);
                        if (str == null) {
                            zzcuVarZzp = zzcsVar.zzp();
                        } else {
                            switch (str) {
                                case "{\an1}":
                                    b = 0;
                                    break;
                                case "{\an3}":
                                    b = 3;
                                    break;
                                case "{\an4}":
                                    b = 1;
                                    break;
                                case "{\an6}":
                                    b = 4;
                                    break;
                                case "{\an7}":
                                    b = 2;
                                    break;
                                case "{\an9}":
                                    b = 5;
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            if (b == 0 || b == 1 || b == 2) {
                                zzcsVar.zzi(0);
                            } else if (b == 3 || b == 4 || b == 5) {
                                zzcsVar.zzi(2);
                            } else {
                                zzcsVar.zzi(1);
                            }
                            switch (str) {
                                case "{\an1}":
                                    b2 = 0;
                                    break;
                                case "{\an2}":
                                    b2 = 1;
                                    break;
                                case "{\an3}":
                                    b2 = 2;
                                    break;
                                case "{\an7}":
                                    b2 = 3;
                                    break;
                                case "{\an8}":
                                    b2 = 4;
                                    break;
                                case "{\an9}":
                                    b2 = 5;
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            if (b2 == 0 || b2 == 1) {
                                i3 = 2;
                            } else {
                                if (b2 == 2) {
                                    i3 = 2;
                                } else if (b2 == 3 || b2 == 4 || b2 == 5) {
                                    zzcsVar.zzf(0);
                                } else {
                                    zzcsVar.zzf(1);
                                }
                                zzcsVar.zzh(zzb(zzcsVar.zzb()));
                                zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                                zzcuVarZzp = zzcsVar.zzp();
                            }
                            zzcsVar.zzf(i3);
                            zzcsVar.zzh(zzb(zzcsVar.zzb()));
                            zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                            zzcuVarZzp = zzcsVar.zzp();
                        }
                        zzdkVar.zza(new zzajs(zzfww.zzo(zzcuVarZzp), jZzc, jZzc2 - jZzc));
                    } else {
                        zzekVar = zzekVar2;
                        zzdx.zzf("SubripParser", "Skipping invalid timing: ".concat(strZzz2));
                    }
                } catch (NumberFormatException unused) {
                    zzekVar = zzekVar2;
                    zzdx.zzf("SubripParser", "Skipping invalid index: ".concat(strZzz));
                }
            } else {
                zzekVar = zzekVar2;
            }
            zzakuVar = this;
            zzekVar2 = zzekVar;
        }
    }
}
