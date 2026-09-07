package com.mbridge.msdk.mbnative.cache;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: APICache.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends b<String, List<Campaign>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f5181a = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
    private int b;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbnative.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: APICache.java */
    class RunnableC0456a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f5182a;
        final /* synthetic */ String b;

        RunnableC0456a(List list, String str) {
            this.f5182a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f5182a.size(); i++) {
                CampaignEx campaignEx = (CampaignEx) this.f5182a.get(i);
                campaignEx.setCacheLevel(1);
                a.this.f5181a.a(campaignEx, this.b, 1);
            }
        }
    }

    public a(int i) {
        this.b = i;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public List<Campaign> b(String str, int i) {
        List<CampaignEx> listA = this.f5181a.a(str, i, 2, this.b);
        if (listA == null) {
            return null;
        }
        if (a(listA, 2)) {
            this.f5181a.a(str, 2, this.b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listA);
        return arrayList;
    }

    public void a(List<CampaignEx> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = list.get(i);
            campaignEx.setCacheLevel(2);
            this.f5181a.a(campaignEx, str, 1);
        }
    }

    public boolean a(List<CampaignEx> list, int i) {
        long jA;
        if (list != null && list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long timestamp = list.get(0).getTimestamp();
            if (i != 1) {
                jA = i != 2 ? 0L : b();
            } else {
                jA = a();
            }
            if (jCurrentTimeMillis - timestamp > jA) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, List<Campaign> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f5181a.a(str, 1, this.b, false);
        this.f5181a.a(str, 2, this.b, false);
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i);
            campaignEx.setCacheLevel(1);
            this.f5181a.a(campaignEx, str, 1);
        }
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, List<Campaign> list, String str2) {
        boolean z = !TextUtils.isEmpty(str2);
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        this.f5181a.a(str, 1, this.b, z);
        this.f5181a.a(str, 2, this.b, z);
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0456a(list, str));
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public List<Campaign> a(String str, int i) {
        List<CampaignEx> listA = this.f5181a.a(str, i, 1, this.b);
        if (listA == null) {
            return null;
        }
        if (a(listA, 1)) {
            a(listA, str);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listA);
        return arrayList;
    }

    @Override // com.mbridge.msdk.mbnative.cache.b
    public void a(String str, Campaign campaign, String str2) {
        boolean z = !TextUtils.isEmpty(str2);
        if (campaign == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CampaignEx campaignEx = (CampaignEx) campaign;
            if (this.f5181a.a(campaignEx.getId(), campaignEx.getTab(), str, campaignEx.getCacheLevel(), campaignEx.getType(), z)) {
                this.f5181a.a(campaignEx.getId(), str, campaignEx.getCacheLevel(), this.b, z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
