package com.mbridge.msdk.video.bt.module.orglistener;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: ProxyShowRewardListener.java */
/* JADX INFO: loaded from: classes8.dex */
public class d extends b {
    private h c;
    private com.mbridge.msdk.videocommon.setting.c d;
    private String e;
    private String f;
    private boolean g;
    private Context h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;

    public d(Context context, boolean z, com.mbridge.msdk.videocommon.setting.c cVar, CampaignEx campaignEx, h hVar, String str, String str2) {
        this.c = hVar;
        this.d = cVar;
        this.e = str2;
        this.f = str;
        this.g = z;
        this.h = context;
        a(cVar, campaignEx);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002c  */
    private void a(com.mbridge.msdk.videocommon.setting.c cVar, CampaignEx campaignEx) {
        long jA0;
        try {
            String strB = com.mbridge.msdk.foundation.controller.c.m().b();
            if (TextUtils.isEmpty(strB)) {
                jA0 = 0;
            } else {
                com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(strB);
                if (gVarD == null) {
                    gVarD = com.mbridge.msdk.setting.h.b().a();
                }
                if (gVarD != null) {
                    jA0 = gVarD.a0() * 1000;
                } else {
                    jA0 = 0;
                }
            }
            com.mbridge.msdk.videocommon.setting.a aVarC = com.mbridge.msdk.videocommon.setting.b.b().c();
            long jE = aVarC != null ? aVarC.e() : 0L;
            if (campaignEx != null) {
                if (!campaignEx.isSpareOffer(jE, jA0)) {
                    campaignEx.setSpareOfferFlag(0);
                    campaignEx.setCbt(0);
                    return;
                }
                campaignEx.setSpareOfferFlag(1);
                if (cVar.A() == 1) {
                    campaignEx.setCbt(1);
                } else {
                    campaignEx.setCbt(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.b(str, str2);
            this.c.a(5, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        super.a(cVar);
        if (this.c == null || this.i) {
            return;
        }
        this.i = true;
        b();
        this.c.a(cVar);
        this.c.a(2, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z, com.mbridge.msdk.videocommon.entity.c cVar2) {
        super.a(cVar, z, cVar2);
        h hVar = this.c;
        if (hVar == null || this.k) {
            return;
        }
        this.k = true;
        hVar.a(7, this.f, this.e);
        this.c.a(cVar, z, cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, int i) {
        super.a(z, i);
        h hVar = this.c;
        if (hVar == null || this.k) {
            return;
        }
        hVar.a(z, i);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        super.a(cVar, str);
        if (this.c == null || this.j) {
            return;
        }
        this.j = true;
        a();
        this.c.a(cVar, str);
        this.c.a(4, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, String str, String str2) {
        super.a(z, str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(z, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(str, str2);
            this.c.a(6, str, str2);
        }
    }
}
