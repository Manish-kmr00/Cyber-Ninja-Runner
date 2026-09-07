package com.yandex.mobile.ads.impl;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class y12 extends ny1 {
    private static final Pattern r = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean m;
    private final z12 n;
    private LinkedHashMap o;
    private float p = -3.4028235E38f;
    private float q = -3.4028235E38f;

    private static int a(long j, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i, Long.valueOf(j));
        arrayList2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i - 1)));
        return i;
    }

    public y12(List<byte[]> list) {
        if (list != null && !list.isEmpty()) {
            this.m = true;
            String strA = x82.a(list.get(0));
            hg.a(strA.startsWith("Format:"));
            this.n = (z12) hg.a(z12.a(strA));
            a(new wf1(list.get(1)));
            return;
        }
        this.m = false;
        this.n = null;
    }

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) {
        wf1 wf1Var;
        int i2;
        Layout.Alignment alignment;
        int i3;
        float f;
        int i4;
        int i5;
        int i6;
        y12 y12Var = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        wf1 wf1Var2 = new wf1(i, bArr);
        if (!y12Var.m) {
            y12Var.a(wf1Var2);
        }
        z12 z12VarA = y12Var.m ? y12Var.n : null;
        while (true) {
            String strJ = wf1Var2.j();
            if (strJ != null) {
                if (strJ.startsWith("Format:")) {
                    z12VarA = z12.a(strJ);
                } else {
                    if (strJ.startsWith("Dialogue:")) {
                        if (z12VarA == null) {
                            at0.d("SsaDecoder", "Skipping dialogue line before complete format: ".concat(strJ));
                        } else if (strJ.startsWith("Dialogue:")) {
                            String[] strArrSplit = strJ.substring(9).split(StringUtils.COMMA, z12VarA.e);
                            if (strArrSplit.length != z12VarA.e) {
                                at0.d("SsaDecoder", "Skipping dialogue line with fewer columns than format: ".concat(strJ));
                            } else {
                                long jA = a(strArrSplit[z12VarA.f10783a]);
                                if (jA == -9223372036854775807L) {
                                    at0.d("SsaDecoder", "Skipping invalid timing: ".concat(strJ));
                                } else {
                                    long jA2 = a(strArrSplit[z12VarA.b]);
                                    if (jA2 == -9223372036854775807L) {
                                        at0.d("SsaDecoder", "Skipping invalid timing: ".concat(strJ));
                                    } else {
                                        LinkedHashMap linkedHashMap = y12Var.o;
                                        a22 a22Var = (linkedHashMap == null || (i6 = z12VarA.c) == -1) ? null : (a22) linkedHashMap.get(strArrSplit[i6].trim());
                                        String str = strArrSplit[z12VarA.d];
                                        a22.b bVarA = a22.b.a(str);
                                        String strReplace = a22.b.c(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                        float f2 = y12Var.p;
                                        float f3 = y12Var.q;
                                        SpannableString spannableString = new SpannableString(strReplace);
                                        ev.a aVarA = new ev.a().a(spannableString);
                                        if (a22Var != null) {
                                            wf1Var = wf1Var2;
                                            if (a22Var.c != null) {
                                                spannableString.setSpan(new ForegroundColorSpan(a22Var.c.intValue()), 0, spannableString.length(), 33);
                                            }
                                            if (a22Var.j == 3 && a22Var.d != null) {
                                                spannableString.setSpan(new BackgroundColorSpan(a22Var.d.intValue()), 0, spannableString.length(), 33);
                                            }
                                            float f4 = a22Var.e;
                                            if (f4 != -3.4028235E38f && f3 != -3.4028235E38f) {
                                                aVarA.b(1, f4 / f3);
                                            }
                                            boolean z2 = a22Var.f;
                                            if (z2 && a22Var.g) {
                                                i4 = 33;
                                                i5 = 0;
                                                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                            } else {
                                                i4 = 33;
                                                i5 = 0;
                                                if (z2) {
                                                    spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                                } else if (a22Var.g) {
                                                    spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                }
                                            }
                                            if (a22Var.h) {
                                                spannableString.setSpan(new UnderlineSpan(), i5, spannableString.length(), i4);
                                            }
                                            if (a22Var.i) {
                                                spannableString.setSpan(new StrikethroughSpan(), i5, spannableString.length(), i4);
                                            }
                                        } else {
                                            wf1Var = wf1Var2;
                                            z12VarA = z12VarA;
                                            jA2 = jA2;
                                        }
                                        int i7 = bVarA.f8356a;
                                        if (i7 != -1) {
                                            i2 = i7;
                                        } else {
                                            i2 = a22Var != null ? a22Var.b : -1;
                                        }
                                        switch (i2) {
                                            case 0:
                                            default:
                                                tr0.a("Unknown alignment: ", i2, "SsaDecoder");
                                            case -1:
                                                alignment = null;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                alignment = Layout.Alignment.ALIGN_NORMAL;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                alignment = Layout.Alignment.ALIGN_CENTER;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                break;
                                        }
                                        ev.a aVarB = aVarA.b(alignment);
                                        int i8 = Integer.MIN_VALUE;
                                        switch (i2) {
                                            case 0:
                                            default:
                                                tr0.a("Unknown alignment: ", i2, "SsaDecoder");
                                            case -1:
                                                i3 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                i3 = 0;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                i3 = 1;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                i3 = 2;
                                                break;
                                        }
                                        ev.a aVarB2 = aVarB.b(i3);
                                        switch (i2) {
                                            case -1:
                                                break;
                                            case 0:
                                            default:
                                                tr0.a("Unknown alignment: ", i2, "SsaDecoder");
                                                break;
                                            case 1:
                                            case 2:
                                            case 3:
                                                i8 = 2;
                                                break;
                                            case 4:
                                            case 5:
                                            case 6:
                                                i8 = 1;
                                                break;
                                            case 7:
                                            case 8:
                                            case 9:
                                                i8 = 0;
                                                break;
                                        }
                                        aVarB2.a(i8);
                                        PointF pointF = bVarA.b;
                                        if (pointF != null && f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            aVarA.b(pointF.x / f2);
                                            aVarA.a(0, bVarA.b.y / f3);
                                        } else {
                                            int iC = aVarA.c();
                                            float f5 = 0.95f;
                                            if (iC == 0) {
                                                f = 0.05f;
                                            } else if (iC != 1) {
                                                f = iC != 2 ? -3.4028235E38f : 0.95f;
                                            } else {
                                                f = 0.5f;
                                            }
                                            aVarA.b(f);
                                            int iB = aVarA.b();
                                            if (iB == 0) {
                                                f5 = 0.05f;
                                            } else if (iB == 1) {
                                                f5 = 0.5f;
                                            } else if (iB != 2) {
                                                f5 = -3.4028235E38f;
                                            }
                                            aVarA.a(0, f5);
                                        }
                                        ev evVarA = aVarA.a();
                                        int iA = a(jA2, arrayList2, arrayList);
                                        for (int iA2 = a(jA, arrayList2, arrayList); iA2 < iA; iA2++) {
                                            ((List) arrayList.get(iA2)).add(evVarA);
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        wf1Var = wf1Var2;
                        z12VarA = z12VarA;
                    } else {
                        wf1Var = wf1Var2;
                        z12VarA = z12VarA;
                    }
                    y12Var = this;
                    wf1Var2 = wf1Var;
                    z12VarA = z12VarA;
                }
            } else {
                return new b22(arrayList, arrayList2);
            }
        }
    }

    private void a(wf1 wf1Var) {
        while (true) {
            String strJ = wf1Var.j();
            if (strJ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strJ)) {
                while (true) {
                    String strJ2 = wf1Var.j();
                    if (strJ2 == null || (wf1Var.a() != 0 && wf1Var.g() == 91)) {
                        break;
                    }
                    String[] strArrSplit = strJ2.split(":");
                    if (strArrSplit.length == 2) {
                        String strB = fg.b(strArrSplit[0].trim());
                        strB.getClass();
                        if (strB.equals("playresx")) {
                            this.p = Float.parseFloat(strArrSplit[1].trim());
                        } else if (strB.equals("playresy")) {
                            try {
                                this.q = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strJ)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                a22.a aVarA = null;
                while (true) {
                    String strJ3 = wf1Var.j();
                    if (strJ3 == null || (wf1Var.a() != 0 && wf1Var.g() == 91)) {
                        break;
                    }
                    if (strJ3.startsWith("Format:")) {
                        aVarA = a22.a.a(strJ3);
                    } else if (strJ3.startsWith("Style:")) {
                        if (aVarA == null) {
                            at0.d("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: ".concat(strJ3));
                        } else {
                            a22 a22VarA = a22.a(strJ3, aVarA);
                            if (a22VarA != null) {
                                linkedHashMap.put(a22VarA.f8354a, a22VarA);
                            }
                        }
                    }
                }
                this.o = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strJ)) {
                at0.c("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strJ)) {
                return;
            }
        }
    }

    private static long a(String str) {
        Matcher matcher = r.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = x82.f10629a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(strGroup) * 3600000000L);
    }
}
