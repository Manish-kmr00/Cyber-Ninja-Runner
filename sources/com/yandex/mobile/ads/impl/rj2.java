package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
final class rj2 {
    private static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f10114a = new wf1();
    private final StringBuilder b = new StringBuilder();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01de  */
    /* JADX WARN: Code duplicated, block: B:101:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:106:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:108:0x0205  */
    /* JADX WARN: Code duplicated, block: B:109:0x020a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0212  */
    /* JADX WARN: Code duplicated, block: B:117:0x0225  */
    /* JADX WARN: Code duplicated, block: B:119:0x022b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0233  */
    /* JADX WARN: Code duplicated, block: B:123:0x023b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0240  */
    /* JADX WARN: Code duplicated, block: B:126:0x0248  */
    /* JADX WARN: Code duplicated, block: B:127:0x024d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0255  */
    /* JADX WARN: Code duplicated, block: B:131:0x025d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0262  */
    /* JADX WARN: Code duplicated, block: B:134:0x026a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0272  */
    /* JADX WARN: Code duplicated, block: B:137:0x0277  */
    /* JADX WARN: Code duplicated, block: B:139:0x027f  */
    /* JADX WARN: Code duplicated, block: B:141:0x028f  */
    /* JADX WARN: Code duplicated, block: B:142:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:144:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:145:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:148:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:152:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:156:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:160:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:161:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:162:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:174:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:97:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d6  */
    public final ArrayList a(wf1 wf1Var) {
        String strSubstring;
        String string;
        Matcher matcher;
        String strGroup;
        boolean z;
        int i = 0;
        this.b.setLength(0);
        int iD = wf1Var.d();
        while (!TextUtils.isEmpty(wf1Var.j())) {
        }
        this.f10114a.a(wf1Var.d(), wf1Var.c());
        this.f10114a.e(iD);
        ArrayList arrayList = new ArrayList();
        while (true) {
            wf1 wf1Var2 = this.f10114a;
            StringBuilder sb = this.b;
            b(wf1Var2);
            if (wf1Var2.a() >= 5 && "::cue".equals(wf1Var2.a(5, ko.c))) {
                int iD2 = wf1Var2.d();
                String strB = b(wf1Var2, sb);
                if (strB == null) {
                    strSubstring = null;
                } else if ("{".equals(strB)) {
                    wf1Var2.e(iD2);
                    strSubstring = "";
                } else {
                    if ("(".equals(strB)) {
                        int iD3 = wf1Var2.d();
                        int iE = wf1Var2.e();
                        int i2 = i;
                        while (iD3 < iE && i2 == 0) {
                            int i3 = iD3 + 1;
                            i2 = ((char) wf1Var2.c()[iD3]) == ')' ? 1 : i;
                            iD3 = i3;
                        }
                        strSubstring = wf1Var2.a((iD3 - 1) - wf1Var2.d(), ko.c).trim();
                    } else {
                        strSubstring = null;
                    }
                    if (!")".equals(b(wf1Var2, sb))) {
                        strSubstring = null;
                    }
                }
            } else {
                strSubstring = null;
            }
            if (strSubstring == null || !"{".equals(b(this.f10114a, this.b))) {
                return arrayList;
            }
            sj2 sj2Var = new sj2();
            if (!"".equals(strSubstring)) {
                int iIndexOf = strSubstring.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = c.matcher(strSubstring.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        sj2Var.d(strGroup2);
                    }
                    strSubstring = strSubstring.substring(i, iIndexOf);
                }
                int i4 = x82.f10629a;
                String[] strArrSplit = strSubstring.split(DnsName.ESCAPED_DOT, -1);
                String str = strArrSplit[i];
                int iIndexOf2 = str.indexOf(35);
                if (iIndexOf2 != -1) {
                    sj2Var.c(str.substring(i, iIndexOf2));
                    sj2Var.b(str.substring(iIndexOf2 + 1));
                } else {
                    sj2Var.c(str);
                }
                if (strArrSplit.length > 1) {
                    sj2Var.a((String[]) x82.a(strArrSplit, strArrSplit.length));
                }
            }
            int i5 = i;
            String strB2 = null;
            while (i5 == 0) {
                int iD4 = this.f10114a.d();
                strB2 = b(this.f10114a, this.b);
                int i6 = (strB2 == null || "}".equals(strB2)) ? 1 : i;
                if (i6 == 0) {
                    this.f10114a.e(iD4);
                    wf1 wf1Var3 = this.f10114a;
                    StringBuilder sb2 = this.b;
                    b(wf1Var3);
                    String strA = a(wf1Var3, sb2);
                    if (!"".equals(strA) && ":".equals(b(wf1Var3, sb2))) {
                        b(wf1Var3);
                        StringBuilder sb3 = new StringBuilder();
                        int i7 = i;
                        while (true) {
                            if (i7 == 0) {
                                int iD5 = wf1Var3.d();
                                String strB3 = b(wf1Var3, sb2);
                                if (strB3 == null) {
                                    string = null;
                                } else if ("}".equals(strB3) || ";".equals(strB3)) {
                                    wf1Var3.e(iD5);
                                    i7 = 1;
                                } else {
                                    sb3.append(strB3);
                                }
                            } else {
                                string = sb3.toString();
                            }
                        }
                        if (string != null && !"".equals(string)) {
                            int iD6 = wf1Var3.d();
                            String strB4 = b(wf1Var3, sb2);
                            if (";".equals(strB4)) {
                                if ("color".equals(strA)) {
                                    sj2Var.b(qq.a(string));
                                } else if ("background-color".equals(strA)) {
                                    sj2Var.a(qq.a(string));
                                } else if ("ruby-position".equals(strA)) {
                                    if ("over".equals(string)) {
                                        sj2Var.d(1);
                                    } else if ("under".equals(string)) {
                                        sj2Var.d(2);
                                    }
                                } else if ("text-combine-upright".equals(strA)) {
                                    if ("all".equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    sj2Var.a(z);
                                } else if ("text-decoration".equals(strA)) {
                                    if ("underline".equals(string)) {
                                        sj2Var.o();
                                    }
                                } else if ("font-family".equals(strA)) {
                                    sj2Var.a(string);
                                } else if ("font-weight".equals(strA)) {
                                    if ("bold".equals(string)) {
                                        sj2Var.m();
                                    }
                                } else if ("font-style".equals(strA)) {
                                    if ("italic".equals(string)) {
                                        sj2Var.n();
                                    }
                                } else if ("font-size".equals(strA)) {
                                    matcher = d.matcher(fg.b(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        strGroup.hashCode();
                                        switch (strGroup) {
                                            case "%":
                                                sj2Var.c(3);
                                                break;
                                            case "em":
                                                sj2Var.c(2);
                                                break;
                                            case "px":
                                                sj2Var.c(1);
                                                break;
                                            default:
                                                throw new IllegalStateException();
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        sj2Var.a(Float.parseFloat(strGroup3));
                                    } else {
                                        at0.d("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strB4)) {
                                wf1Var3.e(iD6);
                                if ("color".equals(strA)) {
                                    sj2Var.b(qq.a(string));
                                } else if ("background-color".equals(strA)) {
                                    sj2Var.a(qq.a(string));
                                } else if ("ruby-position".equals(strA)) {
                                    if ("over".equals(string)) {
                                        sj2Var.d(1);
                                    } else if ("under".equals(string)) {
                                        sj2Var.d(2);
                                    }
                                } else if ("text-combine-upright".equals(strA)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    sj2Var.a(z);
                                } else if ("text-decoration".equals(strA)) {
                                    if ("underline".equals(string)) {
                                        sj2Var.o();
                                    }
                                } else if ("font-family".equals(strA)) {
                                    sj2Var.a(string);
                                } else if ("font-weight".equals(strA)) {
                                    if ("bold".equals(string)) {
                                        sj2Var.m();
                                    }
                                } else if ("font-style".equals(strA)) {
                                    if ("italic".equals(string)) {
                                        sj2Var.n();
                                    }
                                } else if ("font-size".equals(strA)) {
                                    matcher = d.matcher(fg.b(string));
                                    if (matcher.matches()) {
                                        at0.d("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        strGroup.hashCode();
                                        switch (strGroup) {
                                            case 37:
                                                if (strGroup.equals("%")) {
                                                }
                                                break;
                                            case 3240:
                                                if (strGroup.equals(UserDataStore.EMAIL)) {
                                                }
                                                break;
                                            case 3592:
                                                if (strGroup.equals("px")) {
                                                }
                                                break;
                                            default:
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
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
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
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
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
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
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
                                            Method dump skipped, instruction units count: 810
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.rj2.a(com.yandex.mobile.ads.impl.wf1):java.util.ArrayList");
                                    }

                                    static String b(wf1 wf1Var, StringBuilder sb) {
                                        b(wf1Var);
                                        if (wf1Var.a() == 0) {
                                            return null;
                                        }
                                        String strA = a(wf1Var, sb);
                                        return !"".equals(strA) ? strA : "" + ((char) wf1Var.t());
                                    }

                                    static void b(wf1 wf1Var) {
                                        while (true) {
                                            for (boolean z = true; wf1Var.a() > 0 && z; z = false) {
                                                char c2 = (char) wf1Var.c()[wf1Var.d()];
                                                if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                                                    int iD = wf1Var.d();
                                                    int iE = wf1Var.e();
                                                    byte[] bArrC = wf1Var.c();
                                                    int i = iD + 2;
                                                    if (i <= iE) {
                                                        int i2 = iD + 1;
                                                        if (bArrC[iD] == 47 && bArrC[i2] == 42) {
                                                            while (true) {
                                                                int i3 = i + 1;
                                                                if (i3 >= iE) {
                                                                    break;
                                                                }
                                                                if (((char) bArrC[i]) == '*' && ((char) bArrC[i3]) == '/') {
                                                                    i += 2;
                                                                    iE = i;
                                                                } else {
                                                                    i = i3;
                                                                }
                                                            }
                                                            wf1Var.f(iE - wf1Var.d());
                                                        }
                                                    }
                                                } else {
                                                    wf1Var.f(1);
                                                }
                                            }
                                            return;
                                        }
                                    }

                                    private static String a(wf1 wf1Var, StringBuilder sb) {
                                        boolean z = false;
                                        sb.setLength(0);
                                        int iD = wf1Var.d();
                                        int iE = wf1Var.e();
                                        while (iD < iE && !z) {
                                            char c2 = (char) wf1Var.c()[iD];
                                            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                                                z = true;
                                            } else {
                                                iD++;
                                                sb.append(c2);
                                            }
                                        }
                                        wf1Var.f(iD - wf1Var.d());
                                        return sb.toString();
                                    }
                                }
