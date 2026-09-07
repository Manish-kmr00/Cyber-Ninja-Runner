package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.o0;

/* JADX INFO: compiled from: BannerDelivery.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    private static final String c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f5166a = new Handler(Looper.getMainLooper());
    private boolean b;

    /* JADX INFO: renamed from: com.mbridge.msdk.mbbanner.common.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerDelivery.java */
    class RunnableC0453a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f5167a;
        final /* synthetic */ String b;
        final /* synthetic */ CampaignUnit c;

        RunnableC0453a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, CampaignUnit campaignUnit) {
            this.f5167a = bVar;
            this.b = str;
            this.c = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f5167a;
            if (bVar != null) {
                bVar.a(this.b, this.c, a.this.b);
            }
        }
    }

    /* JADX INFO: compiled from: BannerDelivery.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f5168a;
        final /* synthetic */ com.mbridge.msdk.foundation.error.b b;

        b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f5168a = bVar;
            this.b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5168a != null) {
                this.b.a(a.this.b);
                this.f5168a.a(this.b);
            }
        }
    }

    /* JADX INFO: compiled from: BannerDelivery.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f5169a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        c(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i) {
            this.f5169a = bVar;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f5169a;
            if (bVar != null) {
                bVar.a(this.b, this.c, a.this.b);
            }
        }
    }

    /* JADX INFO: compiled from: BannerDelivery.java */
    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f5170a;
        final /* synthetic */ com.mbridge.msdk.foundation.error.b b;

        d(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f5170a = bVar;
            this.b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5170a != null) {
                this.b.a(a.this.b);
                this.f5170a.b(this.b);
            }
        }
    }

    public void b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        o0.b(c, "postResourceFail unitId=" + bVar2);
        this.f5166a.post(new d(bVar, bVar2));
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, CampaignUnit campaignUnit, String str) {
        o0.b(c, "postCampaignSuccess unitId=" + str);
        this.f5166a.post(new RunnableC0453a(bVar, str, campaignUnit));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        this.f5166a.post(new b(bVar, bVar2));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i) {
        o0.b(c, "postResourceSuccess unitId=" + str);
        this.f5166a.post(new c(bVar, str, i));
    }
}
