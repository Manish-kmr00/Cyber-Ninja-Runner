package com.ogury.ad.internal;

import com.ogury.core.internal.IntegrationLogger;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class v0 implements b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n4 f7417a;
    public final d4 b;

    public v0(n4 mraidCommandExecutor, d4 monitoringEventLogger) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        this.f7417a = mraidCommandExecutor;
        this.b = monitoringEventLogger;
    }

    public void a() {
    }

    public void a(c ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    public void a(e8 e8Var) {
    }

    public abstract void a(boolean z);

    public void b() {
    }

    public abstract void b(c cVar);

    public void b(String str, String callbackId) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public abstract void c(boolean z);

    public void a(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
    }

    public void b(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
    }

    public void a(String str, String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
    }

    public void a(String str, String callbackId, c ad) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(ad, "ad");
    }

    public void a(p adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
    }

    @Override // com.ogury.ad.internal.b5
    public final boolean a(String url, d5 webView, c ad) {
        String command;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        u3 u3Var = u3.f7411a;
        m9.a(url);
        u3Var.getClass();
        if (Intrinsics.areEqual(webView.getAdState(), "hidden") || Intrinsics.areEqual(webView.getAdState(), "loading")) {
            return true;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            String strSubstring = url.substring(StringsKt.indexOf$default((CharSequence) url, "/?q=", 0, false, 6, (Object) null) + 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            JSONObject jSONObject = new JSONObject(m9.a(strSubstring));
            command = jSONObject.optString("method", "");
            try {
                linkedHashMap.put("callbackId", jSONObject.optString("callbackId"));
                Object objOpt = jSONObject.opt("args");
                if (objOpt == null) {
                    objOpt = "";
                }
                if (objOpt instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) objOpt;
                    Iterator<String> itKeys = jSONObject2.keys();
                    Intrinsics.checkNotNull(itKeys);
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        linkedHashMap.put(next, jSONObject2.optString(next, ""));
                    }
                }
                a(command, linkedHashMap, ad);
                return true;
            } catch (Exception e) {
                e = e;
                IntegrationLogger.e(e);
                n4 n4Var = this.f7417a;
                n4Var.getClass();
                Intrinsics.checkNotNullParameter(command, "command");
                Intrinsics.checkNotNullParameter("", "message");
                h5.a(n4Var.f7364a, o4.a(command, ""));
                return true;
            }
        } catch (Exception e2) {
            e = e2;
            command = "";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(String str, LinkedHashMap params, c cVar) {
        String message;
        Object obj;
        Object obj2;
        Object obj3;
        e8 e8Var;
        boolean z = false;
        switch (str.hashCode()) {
            case -1289167206:
                if (str.equals("expand")) {
                    a();
                    return;
                }
                return;
            case -984419449:
                if (str.equals("ogyResolveIntent")) {
                    String str2 = (String) params.get("intentUri");
                    String str3 = (String) params.get("callbackId");
                    message = str3 != null ? str3 : "";
                    b(str2, message);
                    return;
                }
                return;
            case -934437708:
                if (str.equals("resize")) {
                    try {
                        c();
                        return;
                    } catch (Throwable th) {
                        n4 n4Var = this.f7417a;
                        String message2 = th.getMessage();
                        message = message2 != null ? message2 : "";
                        n4Var.getClass();
                        Intrinsics.checkNotNullParameter("resize", com.ironsource.sdk.controller.f.b.COMMAND);
                        Intrinsics.checkNotNullParameter(message, "message");
                        h5.a(n4Var.f7364a, o4.a("resize", message));
                        return;
                    }
                }
                return;
            case -840442113:
                if (str.equals(MraidJsMethods.UNLOAD)) {
                    b(cVar);
                    return;
                }
                return;
            case -12713460:
                if (str.equals("ogyOnAdImpression") && cVar.z.b == o2.IMPRESSION_SOURCE_FORMAT) {
                    d4 d4Var = this.b;
                    o7 o7Var = o7.SI_005_SDK_EVENT_AD_CREATIVE_DISPLAYED;
                    Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
                    Pair pair2 = TuplesKt.to("impression_source", p2.a(cVar.z.b));
                    r3 r3Var = cVar.A.f7388a;
                    Intrinsics.checkNotNullParameter(r3Var, "<this>");
                    int iOrdinal = r3Var.ordinal();
                    if (iOrdinal == 0) {
                        obj = "format";
                    } else {
                        if (iOrdinal != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj = "sdk";
                    }
                    Pair pair3 = TuplesKt.to("loaded_source", obj);
                    Pair pair4 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
                    int i = cVar.K;
                    d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, pair4, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
                    d4 d4Var2 = this.b;
                    o7 o7Var2 = o7.SI_006_SDK_EVENT_AD_DISPLAYED;
                    Pair pair5 = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
                    Pair pair6 = TuplesKt.to("impression_source", p2.a(cVar.z.b));
                    Pair pair7 = TuplesKt.to("is_paid", Boolean.valueOf(cVar.z.f7362a));
                    r3 r3Var2 = cVar.A.f7388a;
                    Intrinsics.checkNotNullParameter(r3Var2, "<this>");
                    int iOrdinal2 = r3Var2.ordinal();
                    if (iOrdinal2 == 0) {
                        obj2 = "format";
                    } else {
                        if (iOrdinal2 != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                        obj2 = "sdk";
                    }
                    Pair pair8 = TuplesKt.to("loaded_source", obj2);
                    Pair pair9 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
                    int i2 = cVar.K;
                    d4Var2.a(o7Var2, cVar, p7.a(pair5, pair6, pair7, pair8, pair9, TuplesKt.to(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0284: INVOKE 
                          (r0v14 'd4Var2' com.ogury.ad.internal.d4)
                          (r2v10 'o7Var2' com.ogury.ad.internal.o7)
                          (r22v0 'cVar' com.ogury.ad.internal.c)
                          (wrap org.json.JSONObject:0x0280: INVOKE 
                          (wrap kotlin.Pair[]:0x026b: FILLED_NEW_ARRAY 
                          (r9v6 'pair5' kotlin.Pair)
                          (r10v8 'pair6' kotlin.Pair)
                          (r13v6 'pair7' kotlin.Pair)
                          (r8v14 'pair8' kotlin.Pair)
                          (r14v8 'pair9' kotlin.Pair)
                          (wrap kotlin.Pair:0x0264: INVOKE 
                          (r17v0 ?? I:??[OBJECT, ARRAY])
                          (wrap java.lang.Integer:?: TERNARY null = ((r6v6 'i2' int) > (0 int)) ? (wrap ??:0x025a: INVOKE (r6v6 'i2' int) STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED] (LINE:243)) : (null java.lang.Integer))
                         STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair A[MD:<A, B>:(A, B):kotlin.Pair<A, B> (m), WRAPPED] (LINE:243))
                         A[WRAPPED] elemType: kotlin.Pair)
                         STATIC call: com.ogury.ad.internal.p7.a(kotlin.Pair[]):org.json.JSONObject A[MD:(kotlin.Pair<java.lang.String, ? extends java.lang.Object>[]):org.json.JSONObject VARARG throws org.json.JSONException (m), VARARG_CALL, WRAPPED] (LINE:244))
                         VIRTUAL call: com.ogury.ad.internal.d4.a(com.ogury.ad.internal.o7, com.ogury.ad.internal.c, org.json.JSONObject):void A[MD:(com.ogury.ad.internal.o7, com.ogury.ad.internal.c, org.json.JSONObject):void (m)] (LINE:245) in method: com.ogury.ad.internal.v0.a(java.lang.String, java.util.LinkedHashMap, com.ogury.ad.internal.c):void, file: classes13.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r17v0 ??
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                        */
                    /*
                        Method dump skipped, instruction units count: 928
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ogury.ad.internal.v0.a(java.lang.String, java.util.LinkedHashMap, com.ogury.ad.internal.c):void");
                }

                public final void a(LinkedHashMap linkedHashMap, boolean z) {
                    String str = (String) linkedHashMap.get("showNextAd");
                    boolean z2 = (str == null || str.equals("true")) ? false : true;
                    boolean z3 = !z2;
                    if (z) {
                        b(z3);
                    } else {
                        a(z3);
                    }
                    if (z2) {
                        return;
                    }
                    String str2 = (String) linkedHashMap.get("nextAdId");
                    if (str2 == null) {
                        str2 = "";
                    }
                    b(str2);
                }
            }
