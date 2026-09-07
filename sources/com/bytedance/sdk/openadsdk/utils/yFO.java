package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class yFO {
    public static void pA(com.bytedance.sdk.component.Bzk.ZZv zZv, String str) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
        zZv.pA(str, map);
    }
}
