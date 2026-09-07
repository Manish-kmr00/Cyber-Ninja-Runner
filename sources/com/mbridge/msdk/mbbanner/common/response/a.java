package com.mbridge.msdk.mbbanner.common.response;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerResponseHandler.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a extends c<JSONObject> {
    private static final String b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5162a = "";

    /* JADX INFO: renamed from: com.mbridge.msdk.mbbanner.common.response.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerResponseHandler.java */
    class RunnableC0451a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5163a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.mbridge.msdk.mbbanner.common.response.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BannerResponseHandler.java */
        class RunnableC0452a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f5164a;

            RunnableC0452a(CampaignUnit campaignUnit) {
                this.f5164a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f5164a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f5164a.getAds().size() > 0) {
                    a.this.a(this.f5164a);
                    if (!TextUtils.isEmpty(a.this.f5162a)) {
                        a.this.saveHbState(1);
                    }
                    a.this.saveRequestTime(this.f5164a.getAds().size());
                    return;
                }
                CampaignUnit campaignUnit2 = this.f5164a;
                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = RunnableC0451a.this.b.optString("msg");
                }
                RunnableC0451a runnableC0451a = RunnableC0451a.this;
                a.this.a(runnableC0451a.c, msg);
            }
        }

        RunnableC0451a(String str, JSONObject jSONObject, int i) {
            this.f5163a = str;
            this.b = jSONObject;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0452a("v5".equals(this.f5163a) ? b.parseV5CampaignUnit(this.b.optJSONObject("data"), a.this.f5162a) : b.parseCampaignUnit(this.b.optJSONObject("data"), a.this.f5162a)));
        }
    }

    public abstract void a(int i, String str);

    public abstract void a(CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.c(b, "onFailed errorCode = " + aVar.f4982a);
        a(aVar.f4982a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        super.onSuccess(eVar);
        a(eVar.b.b, eVar.c);
    }

    public void a(String str) {
        this.f5162a = str;
    }

    private void a(List<g> list, JSONObject jSONObject) {
        o0.c(b, "parseLoad content = " + jSONObject);
        int iOptInt = jSONObject.optInt("status");
        if (1 == iOptInt) {
            calcRequestTime(System.currentTimeMillis());
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0451a(jSONObject.optString("version"), jSONObject, iOptInt));
            return;
        }
        a(iOptInt, jSONObject.optString("msg"));
    }
}
