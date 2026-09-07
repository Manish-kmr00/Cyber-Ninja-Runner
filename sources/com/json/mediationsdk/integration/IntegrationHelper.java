package com.json.mediationsdk.integration;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.aps.ads.ApsConstants;
import com.facebook.AccessToken;
import com.json.environment.StringUtils;
import com.json.mediationsdk.IntegrationData;
import com.json.mediationsdk.p;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.o9;
import com.vungle.ads.BuildConfig;
import io.bidmachine.BidMachine;

/* JADX INFO: loaded from: classes8.dex */
public class IntegrationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3979a = "IntegrationHelper";
    private static final String b = "4.1";
    private static final String c = "4.3";

    class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3980a;

        a(Context context) {
            this.f3980a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.w(IntegrationHelper.f3979a, "--------------- Google Play Services --------------");
                if (this.f3980a.getPackageManager().getApplicationInfo(this.f3980a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.i(IntegrationHelper.f3979a, "Google Play Services - VERIFIED");
                    String strB = p.m().b(this.f3980a);
                    if (!TextUtils.isEmpty(strB)) {
                        Log.i(IntegrationHelper.f3979a, "GAID is: " + strB + " (use this for test devices)");
                    }
                } else {
                    Log.e(IntegrationHelper.f3979a, "Google Play Services - MISSING");
                }
            } catch (Exception e) {
                o9.d().a(e);
                Log.e(IntegrationHelper.f3979a, "Google Play Services - MISSING");
            }
        }
    }

    private static IntegrationData a(Context context, String str) {
        String str2;
        try {
            IntegrationData integrationData = (IntegrationData) Class.forName(str).getMethod("getIntegrationData", Context.class).invoke(null, context);
            Log.i(f3979a, "Adapter " + integrationData.version + " - VERIFIED");
            return integrationData;
        } catch (ClassNotFoundException e) {
            o9.d().a(e);
            str2 = "Adapter - MISSING";
            Log.e(f3979a, str2);
            return null;
        } catch (Exception e2) {
            o9.d().a(e2);
            str2 = "Adapter version - NOT VERIFIED";
            Log.e(f3979a, str2);
            return null;
        }
    }

    private static void a(Context context) {
        new a(context).start();
    }

    private static void a(String str) {
        try {
            Log.i(f3979a, "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception e) {
            o9.d().a(e);
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }

    private static boolean a(IntegrationData integrationData) {
        if (integrationData.version.startsWith(b) || integrationData.version.startsWith(c)) {
            Log.i(f3979a, "Adapter - VERIFIED");
            return true;
        }
        Log.e(f3979a, integrationData.name + " adapter " + integrationData.version + " is incompatible with SDK version " + IronSourceUtils.getSDKVersion() + ", please update your adapter to version 4.1.*");
        return false;
    }

    private static void b(Context context) {
        Log.i(f3979a, "*** Permissions ***");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
            Log.i(f3979a, "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e(f3979a, "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
            Log.i(f3979a, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e(f3979a, "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003f  */
    private static boolean b(Context context, String str) {
        byte b2;
        String str2;
        try {
            String lowerCase = StringUtils.toLowerCase(str);
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -805296079) {
                if (iHashCode != 92668925) {
                    if (iHashCode == 497130182 && lowerCase.equals(AccessToken.DEFAULT_GRAPH_DOMAIN)) {
                        b2 = 0;
                    } else {
                        b2 = -1;
                    }
                } else if (lowerCase.equals("admob")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (lowerCase.equals("vungle")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                str2 = "--------------- Meta --------------";
            } else if (b2 != 1) {
                str2 = b2 != 2 ? "--------------- " + str + " --------------" : "--------------- Liftoff Monetization --------------";
            } else {
                str2 = "--------------- Google (AdMob and Ad Manager) --------------";
            }
            Log.i(f3979a, str2);
            String str3 = "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
            IntegrationData integrationDataA = a(context, str3);
            if (integrationDataA == null) {
                return false;
            }
            if (!str.equalsIgnoreCase("IronSource") && !a(integrationDataA)) {
                return false;
            }
            a(str3);
            return true;
        } catch (Exception e) {
            o9.d().a(e);
            Log.e(f3979a, "isAdapterValid " + str, e);
            return false;
        }
    }

    public static void validateIntegration(Context context) {
        String str;
        Log.i(f3979a, "Verifying Integration:");
        b(context);
        String[] strArr = {"AppLovin", ApsConstants.UNITYLEVELPLAY_NETWORK_DATA_KEY, BidMachine.NAME, "Bigo", "Chartboost", "Fyber", "AdMob", "HyprMX", "InMobi", "IronSource", BuildConfig.OMSDK_PARTNER_NAME, "Maio", "Facebook", "Mintegral", "MobileFuse", "Moloco", "MyTarget", "Ogury", "Pangle", "Smaato", "SuperAwesome", "UnityAds", "Verve", "Yandex"};
        for (int i = 0; i < 24; i++) {
            String str2 = strArr[i];
            if (!b(context, str2)) {
                String lowerCase = StringUtils.toLowerCase(str2);
                lowerCase.hashCode();
                lowerCase.hashCode();
                switch (lowerCase) {
                    case "vungle":
                        str = ">>>> Liftoff Monetization - NOT VERIFIED";
                        break;
                    case "admob":
                        str = ">>>> Google (AdMob and Ad Manager) - NOT VERIFIED";
                        break;
                    case "facebook":
                        str = ">>>> Meta - NOT VERIFIED";
                        break;
                    default:
                        Log.e(f3979a, ">>>> " + str2 + " - NOT VERIFIED");
                        continue;
                        break;
                }
            } else {
                String lowerCase2 = StringUtils.toLowerCase(str2);
                lowerCase2.hashCode();
                lowerCase2.hashCode();
                switch (lowerCase2.hashCode()) {
                    case -805296079:
                        if (lowerCase2.equals("vungle")) {
                        }
                        break;
                    case 92668925:
                        if (lowerCase2.equals("admob")) {
                        }
                        break;
                    case 497130182:
                        if (lowerCase2.equals(AccessToken.DEFAULT_GRAPH_DOMAIN)) {
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
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:195)
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
                    Method dump skipped, instruction units count: 384
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.json.mediationsdk.integration.IntegrationHelper.validateIntegration(android.content.Context):void");
            }
        }
