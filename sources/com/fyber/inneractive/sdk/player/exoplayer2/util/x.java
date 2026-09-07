package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes14.dex */
public abstract class x {
    public static Uri a(String str, String str2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            strA = sb.toString();
        } else {
            int[] iArrA2 = a(str);
            if (iArrA[3] == 0) {
                strA = sb.append((CharSequence) str, 0, iArrA2[3]).append(str2).toString();
            } else if (iArrA[2] == 0) {
                strA = sb.append((CharSequence) str, 0, iArrA2[2]).append(str2).toString();
            } else {
                int i = iArrA[1];
                if (i != 0) {
                    int i2 = iArrA2[0] + 1;
                    sb.append((CharSequence) str, 0, i2).append(str2);
                    strA = a(sb, iArrA[1] + i2, i2 + iArrA[2]);
                } else if (str2.charAt(i) == '/') {
                    sb.append((CharSequence) str, 0, iArrA2[1]).append(str2);
                    int i3 = iArrA2[1];
                    strA = a(sb, i3, iArrA[2] + i3);
                } else {
                    int i4 = iArrA2[0] + 2;
                    int i5 = iArrA2[1];
                    if (i4 >= i5 || i5 != iArrA2[2]) {
                        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
                        int i6 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
                        sb.append((CharSequence) str, 0, i6).append(str2);
                        strA = a(sb, iArrA2[1], i6 + iArrA[2]);
                    } else {
                        sb.append((CharSequence) str, 0, i5).append('/').append(str2);
                        int i7 = iArrA2[1];
                        strA = a(sb, i7, iArrA[2] + i7 + 1);
                    }
                }
            }
        }
        return Uri.parse(strA);
    }

    public static String a(StringBuilder sb, int i, int i2) {
        int i3;
        int iLastIndexOf;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i4 = i;
        int i5 = i4;
        while (i4 <= i2) {
            if (i4 == i2) {
                i3 = i4;
            } else if (sb.charAt(i4) == '/') {
                i3 = i4 + 1;
            } else {
                i4++;
            }
            int i6 = i5 + 1;
            if (i4 == i6 && sb.charAt(i5) == '.') {
                sb.delete(i5, i3);
                i2 -= i3 - i5;
            } else {
                if (i4 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i6) == '.') {
                    iLastIndexOf = sb.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING, i5 - 2) + 1;
                    int i7 = iLastIndexOf > i ? iLastIndexOf : i;
                    sb.delete(i7, i3);
                    i2 -= i3 - i7;
                } else {
                    iLastIndexOf = i4 + 1;
                }
                i5 = iLastIndexOf;
            }
            i4 = i5;
        }
        return sb.toString();
    }

    public static int[] a(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }
}
