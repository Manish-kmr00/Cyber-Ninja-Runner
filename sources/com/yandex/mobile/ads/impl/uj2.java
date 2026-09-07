package com.yandex.mobile.ads.impl;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes9.dex */
public final class uj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f10393a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map<String, Integer> c;
    private static final Map<String, Integer> d;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        d = Collections.unmodifiableMap(map2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, b bVar, String str, List list, List list2) {
        int i;
        ArrayList arrayList;
        List list3 = list2;
        int i2 = bVar.b;
        int length = spannableStringBuilder.length();
        String str2 = bVar.f10395a;
        str2.getClass();
        str2.hashCode();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case "c":
                for (String str3 : bVar.d) {
                    Map<String, Integer> map = c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str3).intValue()), i2, length, 33);
                    } else {
                        Map<String, Integer> map2 = d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str3).intValue()), i2, length, 33);
                        }
                    }
                }
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case "ruby":
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    sj2 sj2Var = (sj2) list3.get(i3);
                    int iA = sj2Var.a(str, bVar.f10395a, bVar.d, bVar.c);
                    if (iA > 0) {
                        arrayList2.add(new c(iA, sj2Var));
                    }
                }
                Collections.sort(arrayList2);
                for (int i4 = 0; i4 < arrayList2.size() && ((c) arrayList2.get(i4)).c.g() == -1; i4++) {
                }
                ArrayList arrayList3 = new ArrayList(list.size());
                arrayList3.addAll(list);
                Collections.sort(arrayList3, a.c);
                int i5 = bVar.b;
                int i6 = 0;
                int length2 = 0;
                while (i6 < arrayList3.size()) {
                    if ("rt".equals(((a) arrayList3.get(i6)).f10394a.f10395a)) {
                        a aVar = (a) arrayList3.get(i6);
                        b bVar2 = aVar.f10394a;
                        ArrayList arrayList4 = new ArrayList();
                        int i7 = 0;
                        while (i7 < list2.size()) {
                            sj2 sj2Var2 = (sj2) list3.get(i7);
                            ArrayList arrayList5 = arrayList3;
                            int iA2 = sj2Var2.a(str, bVar2.f10395a, bVar2.d, bVar2.c);
                            if (iA2 > 0) {
                                arrayList4.add(new c(iA2, sj2Var2));
                            }
                            i7++;
                            list3 = list2;
                            arrayList3 = arrayList5;
                        }
                        arrayList = arrayList3;
                        Collections.sort(arrayList4);
                        for (int i8 = 0; i8 < arrayList4.size(); i8++) {
                            sj2 sj2Var3 = ((c) arrayList4.get(i8)).c;
                            if (sj2Var3.g() != -1) {
                                sj2Var3.g();
                                int i9 = aVar.f10394a.b - length2;
                                int i10 = aVar.b - length2;
                                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i9, i10);
                                spannableStringBuilder.delete(i9, i10);
                                charSequenceSubSequence.toString();
                                spannableStringBuilder.setSpan(new ss1(), i5, i9, 33);
                                length2 += charSequenceSubSequence.length();
                                i5 = i9;
                            }
                        }
                        int i11 = aVar.f10394a.b - length2;
                        int i12 = aVar.b - length2;
                        CharSequence charSequenceSubSequence2 = spannableStringBuilder.subSequence(i11, i12);
                        spannableStringBuilder.delete(i11, i12);
                        charSequenceSubSequence2.toString();
                        spannableStringBuilder.setSpan(new ss1(), i5, i11, 33);
                        length2 += charSequenceSubSequence2.length();
                        i5 = i11;
                    } else {
                        arrayList = arrayList3;
                    }
                    i6++;
                    list3 = list2;
                    arrayList3 = arrayList;
                }
                break;
            default:
                return;
        }
        ArrayList arrayList6 = new ArrayList();
        for (int i13 = 0; i13 < list2.size(); i13++) {
            sj2 sj2Var4 = (sj2) list2.get(i13);
            int iA3 = sj2Var4.a(str, bVar.f10395a, bVar.d, bVar.c);
            if (iA3 > 0) {
                arrayList6.add(new c(iA3, sj2Var4));
            }
        }
        Collections.sort(arrayList6);
        for (int i14 = 0; i14 < arrayList6.size(); i14++) {
            sj2 sj2Var5 = ((c) arrayList6.get(i14)).c;
            if (sj2Var5 != null) {
                if (sj2Var5.h() != -1) {
                    h12.a(spannableStringBuilder, new StyleSpan(sj2Var5.h()), i2, length);
                }
                if (sj2Var5.k()) {
                    i = 33;
                    spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, length, 33);
                } else {
                    i = 33;
                }
                if (sj2Var5.l()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, i);
                }
                if (sj2Var5.j()) {
                    h12.a(spannableStringBuilder, new ForegroundColorSpan(sj2Var5.c()), i2, length);
                }
                if (sj2Var5.i()) {
                    h12.a(spannableStringBuilder, new BackgroundColorSpan(sj2Var5.a()), i2, length);
                }
                if (sj2Var5.d() != null) {
                    h12.a(spannableStringBuilder, new TypefaceSpan(sj2Var5.d()), i2, length);
                }
                int iF = sj2Var5.f();
                if (iF == 1) {
                    h12.a(spannableStringBuilder, new AbsoluteSizeSpan((int) sj2Var5.e(), true), i2, length);
                } else if (iF == 2) {
                    h12.a(spannableStringBuilder, new RelativeSizeSpan(sj2Var5.e()), i2, length);
                } else if (iF == 3) {
                    h12.a(spannableStringBuilder, new RelativeSizeSpan(sj2Var5.e() / 100.0f), i2, length);
                }
                if (sj2Var5.b()) {
                    spannableStringBuilder.setSpan(new vf0(), i2, length, 33);
                }
            }
        }
    }

    public static tj2 a(wf1 wf1Var, ArrayList arrayList) {
        String strJ = wf1Var.j();
        if (strJ == null) {
            return null;
        }
        Pattern pattern = f10393a;
        Matcher matcher = pattern.matcher(strJ);
        if (matcher.matches()) {
            return a(null, matcher, wf1Var, arrayList);
        }
        String strJ2 = wf1Var.j();
        if (strJ2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strJ2);
        if (matcher2.matches()) {
            return a(strJ.trim(), matcher2, wf1Var, arrayList);
        }
        return null;
    }

    private static tj2 a(String str, Matcher matcher, wf1 wf1Var, ArrayList arrayList) {
        d dVar = new d();
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            dVar.f10396a = wj2.a(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            dVar.b = wj2.a(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            a(strGroup3, dVar);
            StringBuilder sb = new StringBuilder();
            String strJ = wf1Var.j();
            while (!TextUtils.isEmpty(strJ)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strJ.trim());
                strJ = wf1Var.j();
            }
            dVar.c = a(str, sb.toString(), arrayList);
            return new tj2(dVar.a().a(), dVar.f10396a, dVar.b);
        } catch (NumberFormatException unused) {
            at0.d("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    private static void b(String str, d dVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            strSubstring.getClass();
            strSubstring.hashCode();
            int i = 2;
            switch (strSubstring) {
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i = 0;
                    break;
                default:
                    at0.d("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                    i = Integer.MIN_VALUE;
                    break;
            }
            dVar.g = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            int i2 = wj2.f10568a;
            if (str.endsWith("%")) {
                dVar.e = Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
                dVar.f = 0;
                return;
            }
            throw new NumberFormatException("Percentages must end with %");
        }
        dVar.e = Integer.parseInt(str);
        dVar.f = 1;
    }

    static ev.a a(String str) {
        d dVar = new d();
        a(str, dVar);
        return dVar.a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static SpannedString a(String str, String str2, List<sj2> list) {
        int i;
        String str3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i3 < str2.length()) {
            char cCharAt = str2.charAt(i3);
            if (cCharAt == '&') {
                i3++;
                int iIndexOf = str2.indexOf(59, i3);
                int iIndexOf2 = str2.indexOf(32, i3);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(i3, iIndexOf);
                    strSubstring.getClass();
                    strSubstring.hashCode();
                    switch (strSubstring) {
                        case "gt":
                            spannableStringBuilder.append(Typography.greater);
                            break;
                        case "lt":
                            spannableStringBuilder.append(Typography.less);
                            break;
                        case "amp":
                            spannableStringBuilder.append(Typography.amp);
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            at0.d("WebvttCueParser", "ignoring unsupported entity: '&" + strSubstring + ";'");
                            break;
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i3 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
                i2 = 0;
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i3++;
            } else {
                int length = i3 + 1;
                if (length < str2.length()) {
                    int i4 = str2.charAt(length) == '/' ? 1 : i2;
                    int iIndexOf3 = str2.indexOf(62, length);
                    length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                    int i5 = length - 2;
                    int i6 = str2.charAt(i5) == '/' ? 1 : i2;
                    int i7 = i3 + (i4 != 0 ? 2 : 1);
                    if (i6 == 0) {
                        i5 = length - 1;
                    }
                    String strSubstring2 = str2.substring(i7, i5);
                    if (!strSubstring2.trim().isEmpty()) {
                        String strTrim = strSubstring2.trim();
                        if (!strTrim.isEmpty()) {
                            int i8 = x82.f10629a;
                            String str4 = strTrim.split("[ \\.]", 2)[i2];
                            str4.getClass();
                            str4.hashCode();
                            switch (str4.hashCode()) {
                                case 98:
                                    i = str4.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B) ? i2 : -1;
                                    break;
                                case 99:
                                    i = str4.equals(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM) ? 1 : -1;
                                    break;
                                case 105:
                                    i = str4.equals("i") ? 2 : -1;
                                    break;
                                case 117:
                                    i = str4.equals(ApsMetricsDataMap.APSMETRICS_FIELD_URL) ? 3 : -1;
                                    break;
                                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                                    i = str4.equals("v") ? 4 : -1;
                                    break;
                                case 3650:
                                    i = str4.equals("rt") ? 5 : -1;
                                    break;
                                case 3314158:
                                    i = str4.equals(com.json.fe.q) ? 6 : -1;
                                    break;
                                case 3511770:
                                    i = str4.equals("ruby") ? 7 : -1;
                                    break;
                                default:
                                    i = -1;
                                    break;
                            }
                            switch (i) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    if (i4 == 0) {
                                        if (i6 == 0) {
                                            int length2 = spannableStringBuilder.length();
                                            String strTrim2 = strSubstring2.trim();
                                            if (!strTrim2.isEmpty()) {
                                                int iIndexOf4 = strTrim2.indexOf(" ");
                                                if (iIndexOf4 == -1) {
                                                    str3 = "";
                                                } else {
                                                    String strTrim3 = strTrim2.substring(iIndexOf4).trim();
                                                    strTrim2 = strTrim2.substring(i2, iIndexOf4);
                                                    str3 = strTrim3;
                                                }
                                                String[] strArrSplit = strTrim2.split(DnsName.ESCAPED_DOT, -1);
                                                String str5 = strArrSplit[i2];
                                                HashSet hashSet = new HashSet();
                                                for (int i9 = 1; i9 < strArrSplit.length; i9++) {
                                                    hashSet.add(strArrSplit[i9]);
                                                }
                                                arrayDeque.push(new b(str5, length2, str3, hashSet));
                                            } else {
                                                throw new IllegalArgumentException();
                                            }
                                        }
                                        break;
                                    } else {
                                        while (!arrayDeque.isEmpty()) {
                                            b bVar = (b) arrayDeque.pop();
                                            a(spannableStringBuilder, bVar, str, arrayList, list);
                                            if (!arrayDeque.isEmpty()) {
                                                arrayList.add(new a(bVar, spannableStringBuilder.length()));
                                            } else {
                                                arrayList.clear();
                                            }
                                            if (bVar.f10395a.equals(str4)) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                default:
                                    i3 = length;
                                    break;
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                i3 = length;
            }
        }
        while (!arrayDeque.isEmpty()) {
            a(spannableStringBuilder, (b) arrayDeque.pop(), str, arrayList, list);
        }
        a(spannableStringBuilder, new b("", 0, "", Collections.emptySet()), str, Collections.emptyList(), list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(String str, d dVar) {
        int i;
        Matcher matcher = b.matcher(str);
        while (matcher.find()) {
            int i2 = 1;
            String strGroup = matcher.group(1);
            strGroup.getClass();
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                if ("line".equals(strGroup)) {
                    b(strGroup2, dVar);
                } else if ("align".equals(strGroup)) {
                    strGroup2.hashCode();
                    switch (strGroup2) {
                        case "center":
                        case "middle":
                            i2 = 2;
                            break;
                        case "end":
                            i2 = 3;
                            break;
                        case "left":
                            i2 = 4;
                            break;
                        case "right":
                            i2 = 5;
                            break;
                        case "start":
                            break;
                        default:
                            at0.d("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                            i2 = 2;
                            break;
                    }
                    dVar.d = i2;
                } else if (com.ironsource.b9.h.L.equals(strGroup)) {
                    int iIndexOf = strGroup2.indexOf(44);
                    if (iIndexOf != -1) {
                        String strSubstring = strGroup2.substring(iIndexOf + 1);
                        strSubstring.getClass();
                        strSubstring.hashCode();
                        switch (strSubstring.hashCode()) {
                            case -1842484672:
                                if (strSubstring.equals("line-left")) {
                                }
                                break;
                            case -1364013995:
                                if (strSubstring.equals("center")) {
                                }
                                break;
                            case -1276788989:
                                if (strSubstring.equals("line-right")) {
                                }
                                break;
                            case -1074341483:
                                if (strSubstring.equals("middle")) {
                                }
                                break;
                            case 100571:
                                if (strSubstring.equals("end")) {
                                }
                                break;
                            case 109757538:
                                if (strSubstring.equals("start")) {
                                }
                                break;
                        }
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Switch insn not found in header
                            	at java.base/java.util.Objects.requireNonNull(Unknown Source)
                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
                            */
                        /*
                            Method dump skipped, instruction units count: 542
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.uj2.a(java.lang.String, com.yandex.mobile.ads.impl.uj2$d):void");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    static final class d {
                        public CharSequence c;

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public long f10396a = 0;
                        public long b = 0;
                        public int d = 2;
                        public float e = -3.4028235E38f;
                        public int f = 1;
                        public int g = 0;
                        public float h = -3.4028235E38f;
                        public int i = Integer.MIN_VALUE;
                        public float j = 1.0f;
                        public int k = Integer.MIN_VALUE;

                        /* JADX WARN: Code duplicated, block: B:20:0x0032  */
                        /* JADX WARN: Code duplicated, block: B:21:0x0034  */
                        /* JADX WARN: Code duplicated, block: B:29:0x004f  */
                        /* JADX WARN: Code duplicated, block: B:31:0x0055  */
                        /* JADX WARN: Code duplicated, block: B:43:0x0074  */
                        public final ev.a a() {
                            Layout.Alignment alignment;
                            float f = this.h;
                            float f2 = -3.4028235E38f;
                            if (f == -3.4028235E38f) {
                                int i = this.d;
                                if (i != 4) {
                                    f = i != 5 ? 0.5f : 1.0f;
                                } else {
                                    f = 0.0f;
                                }
                            }
                            int i2 = this.i;
                            if (i2 == Integer.MIN_VALUE) {
                                int i3 = this.d;
                                if (i3 == 1) {
                                    i2 = 0;
                                } else if (i3 == 3) {
                                    i2 = 2;
                                } else if (i3 == 4) {
                                    i2 = 0;
                                } else if (i3 != 5) {
                                    i2 = 1;
                                } else {
                                    i2 = 2;
                                }
                            }
                            ev.a aVar = new ev.a();
                            int i4 = this.d;
                            if (i4 == 1) {
                                alignment = Layout.Alignment.ALIGN_NORMAL;
                            } else if (i4 == 2) {
                                alignment = Layout.Alignment.ALIGN_CENTER;
                            } else if (i4 == 3) {
                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            } else if (i4 == 4) {
                                alignment = Layout.Alignment.ALIGN_NORMAL;
                            } else if (i4 != 5) {
                                tr0.a("Unknown textAlignment: ", i4, "WebvttCueParser");
                                alignment = null;
                            } else {
                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            }
                            ev.a aVarB = aVar.b(alignment);
                            float f3 = this.e;
                            int i5 = this.f;
                            if (f3 != -3.4028235E38f && i5 == 0 && (f3 < 0.0f || f3 > 1.0f)) {
                                f2 = 1.0f;
                            } else if (f3 != -3.4028235E38f) {
                                f2 = f3;
                            } else if (i5 == 0) {
                                f2 = 1.0f;
                            }
                            ev.a aVarB2 = aVarB.a(i5, f2).a(this.g).b(f).b(i2);
                            float f4 = this.j;
                            if (i2 == 0) {
                                f = 1.0f - f;
                            } else if (i2 == 1) {
                                f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
                            } else if (i2 != 2) {
                                throw new IllegalStateException(String.valueOf(i2));
                            }
                            ev.a aVarC = aVarB2.d(Math.min(f4, f)).c(this.k);
                            CharSequence charSequence = this.c;
                            if (charSequence != null) {
                                aVarC.a(charSequence);
                            }
                            return aVarC;
                        }
                    }

                    private static final class c implements Comparable<c> {
                        public final int b;
                        public final sj2 c;

                        @Override // java.lang.Comparable
                        public final int compareTo(c cVar) {
                            return Integer.compare(this.b, cVar.b);
                        }

                        public c(int i, sj2 sj2Var) {
                            this.b = i;
                            this.c = sj2Var;
                        }
                    }

                    private static final class b {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final String f10395a;
                        public final int b;
                        public final String c;
                        public final Set<String> d;

                        private b(String str, int i, String str2, Set<String> set) {
                            this.b = i;
                            this.f10395a = str;
                            this.c = str2;
                            this.d = set;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    static class a {
                        private static final Comparator<a> c = new Comparator() { // from class: com.yandex.mobile.ads.impl.uj2$a$$ExternalSyntheticLambda0
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return uj2.a.a((uj2.a) obj, (uj2.a) obj2);
                            }
                        };

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        private final b f10394a;
                        private final int b;

                        /* JADX INFO: Access modifiers changed from: private */
                        public static /* synthetic */ int a(a aVar, a aVar2) {
                            return Integer.compare(aVar.f10394a.b, aVar2.f10394a.b);
                        }

                        private a(b bVar, int i) {
                            this.f10394a = bVar;
                            this.b = i;
                        }
                    }
                }
