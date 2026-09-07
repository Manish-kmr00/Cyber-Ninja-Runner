package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: WebViewSpiderLoaderDiff.java */
/* JADX INFO: loaded from: classes9.dex */
public class q {
    public static String a(CampaignEx campaignEx, String str) {
        return str;
    }

    public static void a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, com.mbridge.msdk.click.entity.a aVar, String str, String str2, Context context, o.f fVar, Semaphore semaphore) {
        if (a(jumpLoaderResult.getUrl()) || 200 != aVar.f || TextUtils.isEmpty(jumpLoaderResult.getContent()) || jumpLoaderResult.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
            if (aVar != null) {
                jumpLoaderResult.setType(1);
                jumpLoaderResult.setExceptionMsg(aVar.h);
                jumpLoaderResult.setStatusCode(aVar.f);
                jumpLoaderResult.setHeader(aVar.a());
                jumpLoaderResult.setContent(aVar.g);
            }
            a(jumpLoaderResult.getUrl(), campaignEx, jumpLoaderResult);
            return;
        }
        jumpLoaderResult.setType(2);
        if (TextUtils.isEmpty(jumpLoaderResult.getContent())) {
            try {
                new o().a(str, str2, context, jumpLoaderResult.getUrl(), fVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("WebViewSpiderLoaderDiff", e.getMessage());
                }
            }
        } else {
            new o().a(str, str2, context, jumpLoaderResult.getUrl(), jumpLoaderResult.getContent(), fVar);
        }
        semaphore.acquireUninterruptibly();
    }

    private static boolean a(String str) {
        return s0.a.b(str);
    }

    public static boolean a(String str, CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult) {
        if (campaignEx != null) {
            campaignEx.getLinkType();
        }
        if (a(str)) {
            jumpLoaderResult.setCode(1);
            jumpLoaderResult.setUrl(str);
            jumpLoaderResult.setjumpDone(true);
            return true;
        }
        jumpLoaderResult.setCode(2);
        jumpLoaderResult.setUrl(str);
        return false;
    }
}
