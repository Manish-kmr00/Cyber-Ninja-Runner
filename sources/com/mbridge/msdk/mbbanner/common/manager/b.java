package com.mbridge.msdk.mbbanner.common.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.out.MBridgeIds;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.l;
import com.safedk.android.internal.partials.MintegralFilesBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: BannerLoader.java */
/* JADX INFO: loaded from: classes12.dex */
public class b {
    private static final String n = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5142a;
    private com.mbridge.msdk.mbbanner.common.data.b c;
    private com.mbridge.msdk.mbbanner.common.util.a d;
    private com.mbridge.msdk.mbbanner.common.listener.b e;
    private com.mbridge.msdk.mbbanner.common.listener.d f;
    private int b = 0;
    private volatile boolean g = false;
    private Timer h = new Timer();
    private volatile List<String> i = new ArrayList();
    private volatile boolean j = false;
    private volatile boolean k = false;
    private volatile boolean l = false;
    private String m = "";

    /* JADX INFO: compiled from: BannerLoader.java */
    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5143a;
        final /* synthetic */ CampaignEx b;

        a(String str, CampaignEx campaignEx) {
            this.f5143a = str;
            this.b = campaignEx;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (b.this.g) {
                return;
            }
            b.this.g = true;
            b.this.a(this.f5143a, -1, "", false, this.b);
        }
    }

    /* JADX INFO: compiled from: BannerLoader.java */
    class c extends com.mbridge.msdk.foundation.same.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5144a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ Context c;

        c(String str, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f5144a = str;
            this.b = campaignEx;
            this.c = context;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5144a);
            cVar.a(str, eVar);
            com.mbridge.msdk.mbbanner.common.report.a.a(str, cVar, this.b, this.c, null);
        }
    }

    /* JADX INFO: compiled from: BannerLoader.java */
    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignUnit f5145a;

        d(CampaignUnit campaignUnit) {
            this.f5145a = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.c(b.n, "在单独子线程保存数据库 开始");
            j.a(g.a(b.this.f5142a)).a();
            CampaignUnit campaignUnit = this.f5145a;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.f5145a.getAds().size() > 0) {
                BannerUtils.uisList(b.this.f5142a, this.f5145a.getAds());
            }
            o0.c(b.n, "在单独子线程保存数据库 完成");
        }
    }

    /* JADX INFO: compiled from: BannerLoader.java */
    private static class e implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f5146a;
        private String b;
        private CampaignEx c;

        public e(b bVar, String str, CampaignEx campaignEx) {
            this.f5146a = bVar;
            this.b = str;
            this.c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                o0.c(b.n, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f5146a;
            if (bVar != null) {
                bVar.a(this.b, 1, str2, false, this.c);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c cVarA = com.mbridge.msdk.mbbanner.common.report.a.a(this.b, this.c.getCurrentLocalRid());
                cVarA.a(this.c);
                cVarA.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                cVarA.e(10);
                eVar.a("resource_type", 10);
                eVar.a("result", 3);
                eVar.a("url", str2);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", cVarA, eVar);
            } catch (Throwable th) {
                o0.b(b.n, th.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (MBridgeConstans.DEBUG) {
                o0.c(b.n, "DownloadImageListener campaign image success");
            }
            b bVar = this.f5146a;
            if (bVar != null) {
                bVar.a(this.b, 1, str, true, this.c);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c cVarA = com.mbridge.msdk.mbbanner.common.report.a.a(this.b, this.c.getCurrentLocalRid());
                cVarA.a(this.c);
                cVarA.e(10);
                cVarA.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                eVar.a("result", 1);
                eVar.a("url", str);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", cVarA, eVar);
            } catch (Throwable th) {
                o0.b(b.n, th.getMessage());
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.data.b bVar, com.mbridge.msdk.mbbanner.common.listener.b bVar2, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f5142a = context.getApplicationContext();
        this.c = bVar;
        this.e = bVar2;
        this.d = aVar;
    }

    private void b(String str, List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.i.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.image.b.a(this.f5142a).a(campaignEx.getImageUrl(), new e(this, str, campaignEx));
                com.mbridge.msdk.foundation.same.report.metrics.c cVarA = com.mbridge.msdk.mbbanner.common.report.a.a(str, campaignEx.getCurrentLocalRid());
                cVarA.a(campaignEx);
                cVarA.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_start", cVarA, eVar);
            }
        }
    }

    private void a(String str, int i) {
        if (this.l) {
            return;
        }
        if ((this.j || this.k) && this.i.size() == 0) {
            o0.c(n, "在子线程处理业务逻辑 完成");
            this.g = true;
            this.l = true;
            this.h.cancel();
            this.d.a(this.e, str, i);
            this.f.a(str);
        }
    }

    private void b(String str, String str2, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, 3, str2, true, campaignEx);
    }

    private void a(String str, CampaignEx campaignEx) {
        String str2 = n;
        o0.c(str2, "在子线程处理业务逻辑 完成");
        o0.c(str2, "downloadResource--> Fail");
        this.g = true;
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880027);
        MBridgeIds mBridgeIds = new MBridgeIds();
        mBridgeIds.setUnitId(str);
        bVar.a(mBridgeIds);
        bVar.b(this.c.a());
        bVar.a(campaignEx);
        this.d.b(this.e, bVar);
        this.f.a(str);
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.mbbanner.common.manager.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BannerLoader.java */
    class C0449b extends com.mbridge.msdk.mbbanner.common.response.a {
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a c;

        C0449b(com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.c = aVar;
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(CampaignUnit campaignUnit) throws Throwable {
            try {
                o0.c(b.n, "requestCampaign--> Succeed");
                campaignUnit.setLocalRequestId(this.c.b());
                b.this.d.a(b.this.e, campaignUnit, this.unitId);
                b.this.a(this.unitId, this.c.b(), campaignUnit);
            } catch (Exception e) {
                o0.c(b.n, "requestCampaign--> Fail with exception = " + e.getMessage());
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880000);
                bVar.a(new MBridgeIds(this.placementId, this.unitId));
                bVar.b(this.c.b());
                bVar.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                bVar.a((Throwable) e);
                b.this.d.a(b.this.e, bVar);
                b.this.f.a(this.unitId);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(int i, String str) {
            o0.c(b.n, "requestCampaign--> Fail errorCode:" + i + " msg:" + str);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
            bVar.c(i + "#" + str);
            bVar.a(new MBridgeIds(this.placementId, this.unitId));
            bVar.b(this.c.b());
            b.this.d.a(b.this.e, bVar);
            b.this.f.a(this.unitId);
        }
    }

    private String b() {
        return this.c.d();
    }

    private void b(String str) {
        this.c.b(str);
    }

    public void a(String str, int i, String str2, boolean z, CampaignEx campaignEx) {
        if (!z) {
            if (i == -1) {
                o0.b(n, " unitId =" + str + " --> time out!");
            }
            this.h.cancel();
            a(str, campaignEx);
            return;
        }
        if (i == 1) {
            o0.c(n, "downloadResource--> Success Image");
            synchronized (this) {
                this.i.remove(str2);
                if (this.i.size() == 0) {
                    a(str, i);
                }
            }
            return;
        }
        if (i == 2) {
            o0.c(n, "downloadResource--> Success banner_html");
            this.k = true;
            a(str, i);
        } else if (i == 3) {
            o0.c(n, "downloadResource--> Success banner_url");
            this.j = true;
            a(str, i);
        }
    }

    private void a(String str, int i, CampaignEx campaignEx) {
        this.h.schedule(new a(str, campaignEx), i);
    }

    public void a(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.d dVar) {
        boolean z;
        try {
            o0.c(n, "requestCampaign--> started");
            this.f = dVar;
            C0449b c0449b = new C0449b(aVar);
            c0449b.setUnitId(str2);
            c0449b.setPlacementId(str);
            c0449b.setAdType(l.f);
            com.mbridge.msdk.mbbanner.common.request.a aVar2 = new com.mbridge.msdk.mbbanner.common.request.a(this.f5142a);
            this.b = a(str2);
            com.mbridge.msdk.foundation.same.net.wrapper.e eVarA = com.mbridge.msdk.mbbanner.common.data.c.a(false, this.f5142a, str2, b(), this.b, aVar);
            String strD = t0.d(str2);
            if (!TextUtils.isEmpty(strD)) {
                eVarA.a("j", strD);
            }
            String strA = aVar.a();
            if (TextUtils.isEmpty(strA)) {
                z = false;
            } else {
                c0449b.a(strA);
                z = true;
            }
            this.d.a(z);
            aVar2.choiceV3OrV5BySetting(1, eVarA, c0449b, strA, 30000L);
        } catch (Exception e2) {
            o0.b(n, e2.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
            bVar.a(new MBridgeIds(str, str2));
            this.d.a(this.e, bVar);
            this.f.a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, CampaignUnit campaignUnit) throws Throwable {
        com.mbridge.msdk.foundation.error.b bVar;
        CampaignEx campaignEx;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar2.a(mBridgeIds);
            bVar2.b(str2);
            this.d.a(this.e, bVar2);
            this.f.a(str);
            return;
        }
        List<CampaignEx> listA = a(str, campaignUnit);
        a(campaignUnit);
        int i = 0;
        if (listA != null && listA.size() != 0) {
            o0.c(n, "在子线程处理业务逻辑 开始");
            CampaignEx campaignEx2 = listA.get(0);
            a(str, 60000, campaignEx2);
            b(campaignUnit.getSessionId());
            a(str, listA);
            String strTrim = campaignEx2.getBannerUrl().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                b(str, strTrim, campaignEx2);
                if (listA.size() > 0) {
                    while (i < listA.size()) {
                        listA.get(i).setBannerUrl(campaignEx2.getBannerUrl());
                        listA.get(i).setHasMBTplMark(true);
                        i++;
                    }
                }
            } else {
                String strTrim2 = campaignEx2.getBannerHtml().trim();
                if (!TextUtils.isEmpty(strTrim2)) {
                    String strA = a(str, strTrim2, campaignEx2);
                    if (listA.size() > 0) {
                        while (i < listA.size()) {
                            listA.get(i).setBannerHtml(strA);
                            listA.get(i).setHasMBTplMark(strTrim2.contains("<MBTPLMARK>"));
                            i++;
                        }
                    }
                } else {
                    this.k = true;
                    this.j = true;
                }
            }
            b(str, listA);
            return;
        }
        o0.c(n, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
        if (this.m.contains("INSTALLED")) {
            bVar = new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED");
        } else {
            bVar = new com.mbridge.msdk.foundation.error.b(880003);
        }
        MBridgeIds mBridgeIds2 = new MBridgeIds();
        mBridgeIds2.setUnitId(str);
        bVar.a(mBridgeIds2);
        bVar.b(str2);
        if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
            bVar.a(campaignEx);
        }
        this.d.a(this.e, bVar);
        this.f.a(str);
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    o0.c(n, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    w.a(ads);
                    for (int i = 0; i < ads.size(); i++) {
                        CampaignEx campaignEx = ads.get(i);
                        if (campaignEx != null && campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getBannerUrl()) || !TextUtils.isEmpty(campaignEx.getBannerHtml()) || !TextUtils.isEmpty(campaignEx.getImageUrl()))) {
                            if (t0.c(campaignEx)) {
                                campaignEx.setRtinsType(t0.c(this.f5142a, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.c.b(this.f5142a, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                t0.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.x);
                                this.m = "APP ALREADY INSTALLED";
                            }
                            a(campaignEx, this.f5142a, (com.mbridge.msdk.foundation.same.report.metrics.c) null, str, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
                        }
                    }
                    o0.c(n, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e2) {
                o0.b(n, e2.getMessage());
            }
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, context, cVar, new c(str, campaignEx, context, aVar));
        } catch (Exception e2) {
            o0.b(n, e2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    private String a(String str, String str2, CampaignEx campaignEx) throws Throwable {
        File file;
        Throwable th;
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        String absolutePath = "";
        if (!TextUtils.isEmpty(str2)) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        String strB = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                        String md5 = SameMD5.getMD5(z0.b(str2));
                        if (TextUtils.isEmpty(md5)) {
                            md5 = String.valueOf(System.currentTimeMillis());
                        }
                        File file2 = new File(strB, md5.concat(".html"));
                        Uri.parse(str2).getPath();
                        fileOutputStreamFileOutputStreamCtor = MintegralFilesBridge.fileOutputStreamCtor(file2);
                        try {
                            fileOutputStreamFileOutputStreamCtor.write(str2.getBytes());
                            fileOutputStreamFileOutputStreamCtor.flush();
                            absolutePath = file2.getAbsolutePath();
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                            o0.b(n, e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            } else {
                                file = new File(absolutePath);
                                if (!file.exists()) {
                                    a(str, 2, str2, false, campaignEx);
                                } else {
                                    a(str, 2, str2, false, campaignEx);
                                }
                            }
                            return absolutePath;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStreamFileOutputStreamCtor != null) {
                                try {
                                    fileOutputStreamFileOutputStreamCtor.close();
                                    throw th;
                                } catch (Exception e3) {
                                    o0.b(n, e3.getMessage());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    file = new File(absolutePath);
                    if (!file.exists() && file.isFile() && file.canRead()) {
                        a(str, 2, str2, true, campaignEx);
                    } else {
                        a(str, 2, str2, false, campaignEx);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStreamFileOutputStreamCtor = null;
                }
            } catch (Exception e5) {
                o0.b(n, e5.getMessage());
            }
        }
        return absolutePath;
    }

    private void a(CampaignUnit campaignUnit) {
        new Thread(new d(campaignUnit)).start();
    }

    private int a(String str) {
        try {
            int iC = this.c.c();
            if (iC > this.c.b()) {
                return 0;
            }
            return iC;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void a(String str, List<CampaignEx> list) {
        int size = this.b;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    size += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (size > this.c.b()) {
            o0.c(n, "saveNextOffset 重置offset为0");
            size = 0;
        }
        o0.c(n, "saveNextOffset 算出 下次的offset是:" + size);
        if (y0.b(str)) {
            this.c.a(size);
        }
    }
}
