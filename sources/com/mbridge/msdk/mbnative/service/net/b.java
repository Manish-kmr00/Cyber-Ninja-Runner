package com.mbridge.msdk.mbnative.service.net;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeResponseHandler.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends c<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5217a;
    private String b;

    /* JADX INFO: compiled from: NativeResponseHandler.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5218a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ List c;
        final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.mbridge.msdk.mbnative.service.net.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeResponseHandler.java */
        class RunnableC0461a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f5219a;

            RunnableC0461a(CampaignUnit campaignUnit) {
                this.f5219a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f5219a;
                if (campaignUnit == null || campaignUnit.getAds() == null || this.f5219a.getAds().size() <= 0) {
                    a aVar = a.this;
                    b.this.a(aVar.d, aVar.b.optString("msg"));
                } else {
                    a aVar2 = a.this;
                    b.this.a(aVar2.c, this.f5219a);
                    b.this.saveRequestTime(this.f5219a.getAds().size());
                }
            }
        }

        a(String str, JSONObject jSONObject, List list, int i) {
            this.f5218a = str;
            this.b = jSONObject;
            this.c = list;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0461a("v5".equals(this.f5218a) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(this.b.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(this.b.optJSONObject("data"))));
        }
    }

    private void a(List<g> list, JSONObject jSONObject) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbnative/service/net/b;->a(Ljava/util/List;Lorg/json/JSONObject;)V");
        BrandSafetyUtils.onMintegralNativeController(this, jSONObject);
        safedk_b_a_2fdb1bea85f44b445bbad20b72619ad3(list, jSONObject);
    }

    private void b(List<g> list, JSONObject jSONObject) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/mbnative/service/net/b;->b(Ljava/util/List;Lorg/json/JSONObject;)V");
        BrandSafetyUtils.onMintegralNativeController(this, jSONObject);
        safedk_b_b_89595a4281019aa9433291627d9c3c28(list, jSONObject);
    }

    public abstract void a(int i, String str);

    public void a(String str) {
        this.b = str;
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    public String b() {
        return this.b;
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        a(aVar.f4982a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.b) == null) {
            return;
        }
        int i = this.f5217a;
        if (i == 0) {
            b(aVar.b, eVar.c);
        } else if (i == 1) {
            a(aVar.b, eVar.c);
        }
    }

    private void safedk_b_b_89595a4281019aa9433291627d9c3c28(List<g> list, JSONObject p1) {
        int iOptInt = p1.optInt("status");
        if (1 != iOptInt) {
            a(iOptInt, p1.optString("msg"));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(p1.optString("version"), p1, list, iOptInt));
    }

    public void a(int i) {
        this.f5217a = i;
    }

    public int a() {
        return this.f5217a;
    }

    private void safedk_b_a_2fdb1bea85f44b445bbad20b72619ad3(List<g> list, JSONObject p1) {
        CampaignUnit campaignUnit;
        int iOptInt = p1.optInt("status");
        if (1 == iOptInt) {
            calcRequestTime(System.currentTimeMillis());
            if ("v5".equals(p1.optString("version"))) {
                campaignUnit = com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(p1.optJSONObject("data"));
            } else {
                campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(p1.optJSONObject("data"));
            }
            if (campaignUnit != null && campaignUnit.getListFrames() != null && campaignUnit.getListFrames().size() > 0) {
                a(campaignUnit.getListFrames());
                saveRequestTime(campaignUnit.getListFrames().size());
                return;
            } else {
                a(iOptInt, p1.optString("msg"));
                return;
            }
        }
        a(iOptInt, p1.optString("msg"));
    }
}
