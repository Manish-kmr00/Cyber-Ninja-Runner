package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: SocketRequestTaskDiff.java */
/* JADX INFO: loaded from: classes9.dex */
public class m {
    public static String a(CampaignEx campaignEx, String str) {
        return str;
    }

    public static void a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, com.mbridge.msdk.click.entity.a aVar, String str, String str2, Context context, o.f fVar, k kVar, Semaphore semaphore) {
        if (!s0.a.b(jumpLoaderResult.getUrl()) && 200 == aVar.f && !TextUtils.isEmpty(jumpLoaderResult.getContent()) && !jumpLoaderResult.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
            jumpLoaderResult.setType(2);
            if (TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                try {
                    new o().a(str, str2, context, jumpLoaderResult.getUrl(), fVar);
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("TAG", "webview spider start error");
                    }
                }
            } else {
                new o().a(str, str2, context, jumpLoaderResult.getUrl(), jumpLoaderResult.getContent(), fVar);
            }
            semaphore.acquireUninterruptibly();
            return;
        }
        if (aVar != null) {
            jumpLoaderResult.setType(1);
            jumpLoaderResult.setExceptionMsg(aVar.h);
            jumpLoaderResult.setStatusCode(aVar.f);
            jumpLoaderResult.setHeader(aVar.a());
            jumpLoaderResult.setContent(aVar.g);
        }
        String url = jumpLoaderResult.getUrl();
        if (s0.a.b(url)) {
            jumpLoaderResult.setCode(1);
            jumpLoaderResult.setUrl(url);
            jumpLoaderResult.setjumpDone(true);
        } else {
            jumpLoaderResult.setCode(2);
            jumpLoaderResult.setUrl(url);
        }
        if (kVar != null) {
            kVar.a(jumpLoaderResult);
        }
    }

    public static boolean a(String str, CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult) {
        if (s0.a.b(jumpLoaderResult.getUrl())) {
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
