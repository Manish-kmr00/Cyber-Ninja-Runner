package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* JADX INFO: compiled from: CommonClickControlDiff.java */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static void a() {
    }

    public static void a(Context context, String str, CampaignEx campaignEx, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a.a(context, campaignEx, str, str2, true, false, com.mbridge.msdk.click.retry.a.o);
    }

    public static void a(JumpLoaderResult jumpLoaderResult, Context context, String str, CampaignEx campaignEx, Boolean bool, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
    }

    public static void a(CampaignEx campaignEx) {
    }

    public static void a(String str, Context context, String str2, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
    }

    public static void a(com.mbridge.msdk.foundation.db.d dVar, CampaignEx campaignEx, String str) {
        dVar.a(campaignEx, str);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, JumpLoaderResult jumpLoaderResult, Boolean bool, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        s0.a(context, jumpLoaderResult.getUrl(), nativeTrackingListener, campaignEx, list);
    }
}
