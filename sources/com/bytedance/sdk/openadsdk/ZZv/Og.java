package com.bytedance.sdk.openadsdk.ZZv;

import com.json.m5;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public static final String pA = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.pA;
    public static final String Og = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.Og;
    public static final String KZx = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.KZx;
    public static final String ZZv = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.ZZv;
    public static final String ML = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.ML;
    public static final String JG = com.bytedance.sdk.openadsdk.ZZv.KZx.pA.InterfaceC0215pA.JG;
    public static final Set<String> SD = new HashSet(Arrays.asList("click", m5.v, "insight_log"));

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ZZv.Og$Og, reason: collision with other inner class name */
    public static class C0216Og {
        public static int KZx = 100;
        public static int Og = 2;
        public static int pA = 1;
    }

    public static class pA {
        public static String KZx = "direct";
        public static String Og = "openAdLandPageLinks";
        public static String ZZv = "saLandingPageLinks";
        public static String pA = "openDetailPage";
    }

    public static boolean pA(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
