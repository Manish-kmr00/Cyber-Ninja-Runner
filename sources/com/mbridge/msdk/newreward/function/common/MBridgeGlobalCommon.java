package com.mbridge.msdk.newreward.function.common;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.video.bt.module.orglistener.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class MBridgeGlobalCommon {
    public static String SESSION_ID = "";
    public static Map<String, h> showRewardListenerMap = new HashMap();

    public static void setAlertDialogText(String str, String str2, String str3, String str4, String str5) {
        Context contextD = c.m().d();
        if (!TextUtils.isEmpty(str2)) {
            w0.b(contextD, "MBridge_ConfirmTitle" + str, str2.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            w0.b(contextD, "MBridge_ConfirmContent" + str, str3.trim());
        }
        if (!TextUtils.isEmpty(str5)) {
            w0.b(contextD, "MBridge_CancelText" + str, str5.trim());
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        w0.b(contextD, "MBridge_ConfirmText" + str, str4.trim());
    }
}
