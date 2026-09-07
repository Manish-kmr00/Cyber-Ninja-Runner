package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static ConcurrentHashMap<String, f> g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f5316a;
    private boolean b;
    private final String c;
    private final String d;
    private final String e;
    private volatile List<WindVaneWebView> f;

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f5317a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ n h;

        a(CopyOnWriteArrayList copyOnWriteArrayList, Context context, String str, int i, String str2, String str3, String str4, n nVar) {
            this.f5317a = copyOnWriteArrayList;
            this.b = context;
            this.c = str;
            this.d = i;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = nVar;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x02da  */
        /* JADX WARN: Code duplicated, block: B:130:0x037c  */
        /* JADX WARN: Code duplicated, block: B:138:0x0394  */
        /* JADX WARN: Code duplicated, block: B:162:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:164:0x027a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:166:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x017e  */
        /* JADX WARN: Code duplicated, block: B:68:0x01f0  */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            Iterator it;
            String str2;
            String str3;
            CharSequence charSequence;
            String str4;
            boolean zIsDynamicView;
            String iconUrl;
            String imageUrl;
            String strC;
            CampaignEx campaignEx;
            List<CampaignEx.c.a> listA;
            List<String> list;
            int i;
            String str5;
            String str6 = "_";
            CopyOnWriteArrayList copyOnWriteArrayList = this.f5317a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            try {
                ResDownloadCheckManager.getInstance().setCampaignList(this.f5317a);
                com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.b, this.c, this.f5317a, this.d, new k(b.this.f5316a, this.e, this.c, this.f, this.g));
                com.mbridge.msdk.videocommon.download.b.getInstance().load(this.c);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
            Iterator it2 = this.f5317a.iterator();
            while (it2.hasNext()) {
                CampaignEx campaignEx2 = (CampaignEx) it2.next();
                if (campaignEx2 != null) {
                    try {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 106;
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, this.e);
                        bundle.putString("request_id", this.f);
                        bundle.putString("key", this.c + str6 + this.f + str6 + campaignEx2.getSecondRequestIndex());
                        messageObtain.setData(bundle);
                        b.this.f5316a.sendMessage(messageObtain);
                    } catch (Exception unused) {
                    }
                    CampaignEx.c rewardTemplateMode = campaignEx2.getRewardTemplateMode();
                    if (rewardTemplateMode != null) {
                        String strE = rewardTemplateMode.e();
                        int iF = rewardTemplateMode.f();
                        if (campaignEx2.isDynamicView() && t0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, strE)) {
                            b.this.a(1, campaignEx2, iF + "", strE);
                        } else if (!TextUtils.isEmpty(strE) && !strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                            com.mbridge.msdk.foundation.same.report.metrics.c cVarA = b.this.a(campaignEx2, 2);
                            if (strE.contains(".zip")) {
                                try {
                                    H5DownLoadManager h5DownLoadManager = H5DownLoadManager.getInstance();
                                    Context context = this.b;
                                    String str7 = this.e;
                                    String str8 = this.c;
                                    String str9 = this.f;
                                    str = str6;
                                    try {
                                        m mVar = b.this.f5316a;
                                        try {
                                            n nVar = this.h;
                                            CopyOnWriteArrayList copyOnWriteArrayList2 = this.f5317a;
                                            it = it2;
                                            str5 = "";
                                            str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                            charSequence = ".zip";
                                            try {
                                                h5DownLoadManager.downloadH5Res(cVarA, strE, new l(context, str7, str8, str9, campaignEx2, 859, mVar, nVar, copyOnWriteArrayList2));
                                            } catch (Exception e2) {
                                                e = e2;
                                                if (MBridgeConstans.DEBUG) {
                                                    o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            it = it2;
                                            str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                            charSequence = ".zip";
                                            str5 = "";
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        it = it2;
                                        str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                        str5 = "";
                                        charSequence = ".zip";
                                        if (MBridgeConstans.DEBUG) {
                                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                        str3 = str5;
                                        str4 = campaignEx2.getendcard_url();
                                        zIsDynamicView = campaignEx2.isDynamicView();
                                        boolean zL = t0.l(str4);
                                        if (!TextUtils.isEmpty(str4)) {
                                            if (zIsDynamicView) {
                                                b.this.a(this.b, this.e, this.c, this.f, campaignEx2, str4, this.h, (CopyOnWriteArrayList<CampaignEx>) this.f5317a);
                                            } else if (t0.a(str2, str4)) {
                                                try {
                                                    i = Integer.parseInt(z0.a(str4, "ecid"));
                                                } catch (Throwable th) {
                                                    o0.b("RewardCampaignsResourceManager", th.getMessage());
                                                    i = 404;
                                                }
                                                b.this.a(2, campaignEx2, i + str3, str4);
                                            }
                                        }
                                        if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl())) {
                                            H5DownLoadManager.getInstance().download(b.this.a(campaignEx2, 6), campaignEx2.getEndScreenUrl());
                                        }
                                        iconUrl = campaignEx2.getIconUrl();
                                        if (!TextUtils.isEmpty(iconUrl)) {
                                            try {
                                                com.mbridge.msdk.foundation.same.image.b.a(this.b).a(iconUrl, new j(b.this.f5316a, 0, this.e, this.c, this.f, campaignEx2));
                                            } catch (Exception e5) {
                                                if (MBridgeConstans.DEBUG) {
                                                    o0.b("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                                                }
                                            }
                                        }
                                        imageUrl = campaignEx2.getImageUrl();
                                        if (!TextUtils.isEmpty(imageUrl)) {
                                            try {
                                                com.mbridge.msdk.foundation.same.image.b.a(this.b).a(imageUrl, new j(b.this.f5316a, 0, this.e, this.c, this.f, campaignEx2));
                                            } catch (Exception e6) {
                                                if (MBridgeConstans.DEBUG) {
                                                    o0.b("RewardCampaignsResourceManager", e6.getLocalizedMessage());
                                                }
                                            }
                                        }
                                        if (rewardTemplateMode != null) {
                                            strC = rewardTemplateMode.c();
                                            if (TextUtils.isEmpty(strC)) {
                                                campaignEx = campaignEx2;
                                            } else {
                                                campaignEx = campaignEx2;
                                            }
                                            listA = rewardTemplateMode.a();
                                            if (listA != null) {
                                                while (r2.hasNext()) {
                                                    if (aVar == null) {
                                                    }
                                                }
                                            }
                                        }
                                        str6 = str;
                                        it2 = it;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    str = str6;
                                }
                                str3 = str5;
                            } else {
                                str = str6;
                                it = it2;
                                str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                charSequence = ".zip";
                                o0.a("RewardCampaignsResourceManager", "开始下载 html 类型的 template");
                                try {
                                    str3 = "";
                                    try {
                                        H5DownLoadManager.getInstance().downloadH5Res(cVarA, strE, new i(859, this.e, this.c, this.f, campaignEx2, this.h, b.this.f5316a, this.f5317a));
                                    } catch (Exception e8) {
                                        e = e8;
                                        if (MBridgeConstans.DEBUG) {
                                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                    }
                                } catch (Exception e9) {
                                    e = e9;
                                    str3 = "";
                                }
                            }
                        }
                        str = str6;
                        it = it2;
                        str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                        str3 = "";
                        charSequence = ".zip";
                    } else {
                        str = str6;
                        it = it2;
                        str2 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                        str3 = "";
                        charSequence = ".zip";
                    }
                    str4 = campaignEx2.getendcard_url();
                    zIsDynamicView = campaignEx2.isDynamicView();
                    boolean zL2 = t0.l(str4);
                    if (!TextUtils.isEmpty(str4)) {
                        if (zIsDynamicView || zL2) {
                            b.this.a(this.b, this.e, this.c, this.f, campaignEx2, str4, this.h, (CopyOnWriteArrayList<CampaignEx>) this.f5317a);
                        } else if (t0.a(str2, str4)) {
                            i = Integer.parseInt(z0.a(str4, "ecid"));
                            b.this.a(2, campaignEx2, i + str3, str4);
                        }
                    }
                    if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl()) && !campaignEx2.isDynamicView()) {
                        H5DownLoadManager.getInstance().download(b.this.a(campaignEx2, 6), campaignEx2.getEndScreenUrl());
                    }
                    iconUrl = campaignEx2.getIconUrl();
                    if (!TextUtils.isEmpty(iconUrl)) {
                        com.mbridge.msdk.foundation.same.image.b.a(this.b).a(iconUrl, new j(b.this.f5316a, 0, this.e, this.c, this.f, campaignEx2));
                    }
                    imageUrl = campaignEx2.getImageUrl();
                    if (!TextUtils.isEmpty(imageUrl)) {
                        com.mbridge.msdk.foundation.same.image.b.a(this.b).a(imageUrl, new j(b.this.f5316a, 0, this.e, this.c, this.f, campaignEx2));
                    }
                    if (rewardTemplateMode != null) {
                        strC = rewardTemplateMode.c();
                        if (TextUtils.isEmpty(strC) || campaignEx2.isDynamicView()) {
                            campaignEx = campaignEx2;
                        } else {
                            int i2 = campaignEx2.getAabEntity() != null ? campaignEx2.getAabEntity().h3c : 0;
                            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c(true);
                            cVar.f(i2);
                            if (strC.contains(charSequence)) {
                                o0.a("RewardCampaignsResourceManager", "开始下载 zip 类型的 pause");
                                try {
                                    campaignEx = campaignEx2;
                                    try {
                                        H5DownLoadManager.getInstance().downloadH5Res(cVar, strC, new l(this.b, this.e, this.c, this.f, campaignEx2, 313, b.this.f5316a, this.h, this.f5317a));
                                    } catch (Exception e10) {
                                        e = e10;
                                        if (MBridgeConstans.DEBUG) {
                                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    campaignEx = campaignEx2;
                                }
                            } else {
                                campaignEx = campaignEx2;
                                try {
                                    H5DownLoadManager.getInstance().downloadH5Res(cVar, strC, new i(313, this.e, this.c, this.f, campaignEx, this.h, b.this.f5316a, this.f5317a));
                                } catch (Exception e12) {
                                    if (MBridgeConstans.DEBUG) {
                                        o0.b("RewardCampaignsResourceManager", e12.getLocalizedMessage());
                                    }
                                }
                            }
                        }
                        listA = rewardTemplateMode.a();
                        if (listA != null && listA.size() > 0) {
                            for (CampaignEx.c.a aVar : listA) {
                                if (aVar == null && (list = aVar.f4931a) != null && list.size() > 0) {
                                    for (String str10 : aVar.f4931a) {
                                        if (!TextUtils.isEmpty(str10)) {
                                            try {
                                                com.mbridge.msdk.foundation.same.image.b.a(this.b).a(str10, new j(b.this.f5316a, 1, this.e, this.c, this.f, campaignEx));
                                            } catch (Exception e13) {
                                                if (MBridgeConstans.DEBUG) {
                                                    o0.b("RewardCampaignsResourceManager", e13.getLocalizedMessage());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    str6 = str;
                    it2 = it;
                }
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    class c implements H5DownLoadManager.ZipDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5319a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ CampaignEx d;
        final /* synthetic */ n e;
        final /* synthetic */ Context f;

        c(String str, String str2, String str3, CampaignEx campaignEx, n nVar, Context context) {
            this.f5319a = str;
            this.b = str2;
            this.c = str3;
            this.d = campaignEx;
            this.e = nVar;
            this.f = context;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            Exception exc;
            String str3;
            String str4 = "";
            String str5 = MBridgeConstans.PROPERTIES_UNIT_ID;
            String str6 = "RewardCampaignsResourceManager";
            String str7 = "_";
            try {
                ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
                Message messageObtain = Message.obtain();
                messageObtain.what = 205;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5319a);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                bundle.putString("request_id", this.c);
                bundle.putString("url", str2);
                bundle.putString("key", this.f5319a + "_" + this.c + "_" + this.d.getSecondRequestIndex());
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                b.this.f5316a.sendMessage(messageObtain);
                if (this.e != null) {
                    try {
                        try {
                            this.e.a(str2, this.c, b.b(880005, new MBridgeIds(this.b, this.f5319a, this.c), "", null, null));
                        } catch (Exception e) {
                            e = e;
                            try {
                                o0.b("RewardCampaignsResourceManager", e.getMessage());
                            } catch (Exception e2) {
                                exc = e2;
                                str7 = "_";
                                str6 = "RewardCampaignsResourceManager";
                                str4 = "";
                                str5 = MBridgeConstans.PROPERTIES_UNIT_ID;
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 105;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(str5, this.f5319a);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                                bundle2.putString("request_id", this.c);
                                String str8 = str7;
                                bundle2.putString("key", this.f5319a + str8 + this.c + str8 + this.d.getSecondRequestIndex());
                                bundle2.putString("url", str2);
                                bundle2.putString("message", exc.getMessage());
                                messageObtain2.setData(bundle2);
                                b.this.f5316a.sendMessage(messageObtain2);
                                if (this.e != null) {
                                    try {
                                        this.e.a(str2, this.c, b.b(880005, new MBridgeIds(this.b, this.f5319a, this.c), str4, exc, null));
                                    } catch (Exception e3) {
                                        str3 = str6;
                                        o0.b(str3, e3.getMessage());
                                        o0.b(str3, exc.getLocalizedMessage());
                                    }
                                }
                                str3 = str6;
                                o0.b(str3, exc.getLocalizedMessage());
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                try {
                    b.this.a(this.f, 3, this.d, str2, str, this.f5319a, "");
                } catch (Exception e5) {
                    e = e5;
                    exc = e;
                    ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
                    Message messageObtain3 = Message.obtain();
                    messageObtain3.what = 105;
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(str5, this.f5319a);
                    bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                    bundle3.putString("request_id", this.c);
                    String str9 = str7;
                    bundle3.putString("key", this.f5319a + str9 + this.c + str9 + this.d.getSecondRequestIndex());
                    bundle3.putString("url", str2);
                    bundle3.putString("message", exc.getMessage());
                    messageObtain3.setData(bundle3);
                    b.this.f5316a.sendMessage(messageObtain3);
                    if (this.e != null) {
                        this.e.a(str2, this.c, b.b(880005, new MBridgeIds(this.b, this.f5319a, this.c), str4, exc, null));
                    }
                    str3 = str6;
                    o0.b(str3, exc.getLocalizedMessage());
                }
            } catch (Exception e6) {
                e = e6;
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            String str3;
            try {
                o0.a("RewardCampaignsResourceManager", "zip btl template download success");
                ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
                Message messageObtain = Message.obtain();
                messageObtain.what = 105;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5319a);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                bundle.putString("request_id", this.c);
                bundle.putString("key", this.f5319a + "_" + this.c + "_" + this.d.getSecondRequestIndex());
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                b.this.f5316a.sendMessage(messageObtain);
                n nVar = this.e;
                if (nVar != null) {
                    nVar.a(this.b, this.f5319a, this.c, str);
                }
                if (z) {
                    return;
                }
                try {
                    b.this.a(this.f, 1, this.d, str, "", this.f5319a, str2);
                    return;
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
            }
            Exception exc = e;
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 205;
            Bundle bundle2 = new Bundle();
            bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5319a);
            bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.b);
            bundle2.putString("request_id", this.c);
            bundle2.putString("key", this.f5319a + r9 + this.c + "_" + this.d.getSecondRequestIndex());
            bundle2.putString("url", str);
            messageObtain2.setData(bundle2);
            b.this.f5316a.sendMessage(messageObtain2);
            if (this.e != null) {
                try {
                    this.e.a(str, this.c, b.b(880005, new MBridgeIds(this.b, this.f5319a, this.c), "", exc, null));
                } catch (Exception e3) {
                    str3 = r15;
                    o0.b(str3, e3.getMessage());
                }
            }
            str3 = "RewardCampaignsResourceManager";
            b.this.a(this.f, 3, this.d, str, exc.getLocalizedMessage(), this.f5319a, str2);
            if (MBridgeConstans.DEBUG) {
                o0.b(str3, exc.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5320a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        d(CampaignEx campaignEx, Context context, int i, String str, String str2, String str3, String str4) {
            this.f5320a = campaignEx;
            this.b = context;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5320a == null || this.b == null) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                mVar.j("m_download_end");
                Context context = this.b;
                if (context != null) {
                    mVar.c(k0.s(context.getApplicationContext()));
                }
                mVar.d(this.c);
                CampaignEx campaignEx = this.f5320a;
                if (campaignEx != null) {
                    mVar.b(campaignEx.getId());
                    mVar.n(this.f5320a.getRequestId());
                    mVar.k(this.f5320a.getCurrentLocalRid());
                    mVar.o(this.f5320a.getRequestIdNotice());
                }
                mVar.b("url", this.d);
                mVar.t(this.d);
                mVar.m(this.e);
                mVar.u(this.f);
                if (!TextUtils.isEmpty(this.g)) {
                    mVar.q(this.g);
                }
                mVar.e(1);
                mVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.f5320a);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f5321a;
        final /* synthetic */ WindVaneWebView b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ CopyOnWriteArrayList d;
        final /* synthetic */ String e;
        final /* synthetic */ com.mbridge.msdk.videocommon.setting.c f;
        final /* synthetic */ String g;

        e(boolean z, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str, com.mbridge.msdk.videocommon.setting.c cVar, String str2) {
            this.f5321a = z;
            this.b = windVaneWebView;
            this.c = campaignEx;
            this.d = copyOnWriteArrayList;
            this.e = str;
            this.f = cVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f5321a, this.b, this.c.getRewardTemplateMode().e(), 0, this.c, (CopyOnWriteArrayList<CampaignEx>) this.d, H5DownLoadManager.getInstance().getH5ResAddress(this.c.getRewardTemplateMode().e()), this.e, this.f, this.g, b.this.b);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5322a;
        boolean b;
        int c;
        int d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<CampaignEx> h;
        CopyOnWriteArrayList<CampaignEx> i;

        public f(boolean z, boolean z2, int i, int i2, String str, String str2, int i3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f5322a = z;
            this.b = z2;
            this.c = i;
            this.d = i2;
            this.e = str;
            this.f = str2;
            this.g = i3;
            this.h = copyOnWriteArrayList;
            this.i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface h {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar);
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class i implements H5DownLoadManager.IH5SourceDownloadListener {
        private int b;
        private final String c;
        private final String d;
        private final String e;
        private CampaignEx f;
        private n g;
        private Handler h;
        private CopyOnWriteArrayList<CampaignEx> i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5324a = false;
        private final long j = System.currentTimeMillis();

        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5325a;
            final /* synthetic */ long b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            a(int i, long j, String str, String str2, String str3) {
                this.f5325a = i;
                this.b = j;
                this.c = str;
                this.d = str2;
                this.e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("m_download_end", this.f5325a, this.b + "", this.c, i.this.f.getId(), i.this.d, this.d, "2");
                    mVar.n(i.this.f.getRequestId());
                    mVar.k(i.this.f.getCurrentLocalRid());
                    mVar.o(i.this.f.getRequestIdNotice());
                    mVar.b(i.this.f.getId());
                    mVar.a(i.this.f.getAdSpaceT());
                    mVar.b("scenes", "1");
                    mVar.b("url", this.c);
                    if (i.this.f.getAdType() == 287) {
                        mVar.a("3");
                    } else if (i.this.f.getAdType() == 94) {
                        mVar.a("1");
                    }
                    if (!TextUtils.isEmpty(this.e)) {
                        mVar.q(this.e);
                    }
                    b.b(mVar, i.this.f);
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, i.this.d, i.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        public i(int i, String str, String str2, String str3, CampaignEx campaignEx, n nVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = nVar;
            this.h = handler;
            this.i = copyOnWriteArrayList;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i = this.b;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                bundle.putString("message", str2);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5324a) {
                    a(3, System.currentTimeMillis() - this.j, str, "url download failed", "");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 205;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle3.putString("request_id", this.e);
            bundle3.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            bundle3.putString("message", str2);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            if (this.g != null) {
                try {
                    this.g.a(str, this.e, b.b(880006, new MBridgeIds(this.c, this.d, this.e), str2, null, null));
                } catch (Exception e) {
                    o0.b("RewardCampaignsResourceManager", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i = this.b;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5324a) {
                    a(1, System.currentTimeMillis() - this.j, str, "", str2);
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 105;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle3.putString("request_id", this.e);
            bundle3.putString("key", this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            n nVar = this.g;
            if (nVar != null) {
                nVar.a(this.c, this.d, this.e, str);
            }
        }

        public void a(boolean z) {
            this.f5324a = z;
        }

        private void a(int i, long j, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i, j, str, str2, str3));
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class j implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f5326a;
        private int b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;

        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f5327a;

            a(String str) {
                this.f5327a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f != null) {
                    try {
                        com.mbridge.msdk.foundation.db.n nVarA = com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                        o0.a("RewardCampaignsResourceManager", "campaign is null");
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                        mVar.j("2000044");
                        mVar.c(k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
                        mVar.b(j.this.f.getId());
                        mVar.i(j.this.f.getImageUrl());
                        mVar.n(j.this.f.getRequestId());
                        mVar.k(j.this.f.getCurrentLocalRid());
                        mVar.o(j.this.f.getRequestIdNotice());
                        mVar.u(j.this.c);
                        mVar.m(this.f5327a);
                        mVar.b("scenes", "1");
                        nVarA.a(mVar);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }

        public j(Handler handler, int i, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f5326a = handler;
            this.b = i;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = this.b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            bundle.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            messageObtain.setData(bundle);
            this.f5326a.sendMessage(messageObtain);
            a aVar = new a(str);
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
            } else {
                aVar.run();
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            bundle.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            messageObtain.setData(bundle);
            this.f5326a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class l implements H5DownLoadManager.ZipDownloadListener {
        private Context b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;
        private int g;
        private Handler h;
        private n i;
        private CopyOnWriteArrayList<CampaignEx> j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5329a = false;
        private long k = System.currentTimeMillis();

        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5330a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;

            a(int i, String str, String str2, String str3) {
                this.f5330a = i;
                this.b = str;
                this.c = str2;
                this.d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f == null || l.this.b == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                    mVar.j("m_download_end");
                    if (l.this.b != null) {
                        mVar.c(k0.s(l.this.b.getApplicationContext()));
                    }
                    mVar.d(this.f5330a);
                    if (l.this.f != null) {
                        mVar.b(l.this.f.getId());
                        mVar.n(l.this.f.getRequestId());
                        mVar.k(l.this.f.getCurrentLocalRid());
                        mVar.o(l.this.f.getRequestIdNotice());
                    }
                    mVar.t(this.b);
                    mVar.m(this.c);
                    mVar.u(l.this.c);
                    if (!TextUtils.isEmpty(this.d)) {
                        mVar.q(this.d);
                    }
                    mVar.e(2);
                    mVar.b("scenes", "1");
                    mVar.b("url", this.b);
                    b.b(mVar, l.this.f);
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, l.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.b$l$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class RunnableC0470b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5331a;
            final /* synthetic */ long b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            RunnableC0470b(int i, long j, String str, String str2, String str3) {
                this.f5331a = i;
                this.b = j;
                this.c = str;
                this.d = str2;
                this.e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("m_download_end", this.f5331a, this.b + "", this.c, l.this.f.getId(), l.this.c, this.d, "1");
                    mVar.n(l.this.f.getRequestId());
                    mVar.k(l.this.f.getCurrentLocalRid());
                    mVar.o(l.this.f.getRequestIdNotice());
                    mVar.b(l.this.f.getId());
                    mVar.a(l.this.f.getAdSpaceT());
                    mVar.q(this.e);
                    mVar.b("scenes", "1");
                    if (l.this.f.getAdType() == 287) {
                        mVar.a("3");
                    } else if (l.this.f.getAdType() == 94) {
                        mVar.a("1");
                    }
                    mVar.b("url", this.c);
                    mVar.e(3);
                    b.b(mVar, l.this.f);
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, l.this.c, l.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        public l(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i, Handler handler, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i;
            this.h = handler;
            this.i = nVar;
            this.j = copyOnWriteArrayList;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str2);
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str2);
                bundle2.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("message", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5329a) {
                    a(3, jCurrentTimeMillis, str2, "zip download failed", "");
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 203;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle3.putString("request_id", this.e);
            bundle3.putString("url", str2);
            bundle3.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            bundle3.putString("message", str);
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            if (this.i != null) {
                try {
                    this.i.a(str2, this.e, b.b(880006, new MBridgeIds(this.d, this.c, this.e), "", null, null));
                } catch (Exception e) {
                    o0.b("RewardCampaignsResourceManager", e.getMessage());
                }
            }
            a(3, str2, str, "");
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.h.sendMessage(messageObtain);
                return;
            }
            if (i == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.h.sendMessage(messageObtain2);
                if (this.f5329a) {
                    a(1, jCurrentTimeMillis, str, "", str2);
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle3.putString("request_id", this.e);
            bundle3.putString("key", this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            messageObtain3.setData(bundle3);
            this.h.sendMessage(messageObtain3);
            n nVar = this.i;
            if (nVar != null) {
                nVar.a(this.d, this.c, this.e, str);
            }
            if (z) {
                return;
            }
            a(1, str, "", str2);
        }

        public void a(boolean z) {
            this.f5329a = z;
        }

        private void a(int i, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i, str, str2, str3));
        }

        private void a(int i, long j, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new RunnableC0470b(i, j, str, str2, str3));
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class m extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f5332a;
        private ConcurrentHashMap<String, h> b;
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> c;

        public m(Looper looper) {
            super(looper);
            this.b = new ConcurrentHashMap<>();
            this.c = new ConcurrentHashMap<>();
        }

        public void a(String str, h hVar) {
            this.b.put(str, hVar);
        }

        /* JADX WARN: Code duplicated, block: B:187:0x03ba A[Catch: Exception -> 0x048c, TRY_LEAVE, TryCatch #4 {Exception -> 0x048c, blocks: (B:179:0x038d, B:187:0x03ba), top: B:245:0x00ef }] */
        /* JADX WARN: Code duplicated, block: B:192:0x03fa A[Catch: Exception -> 0x0485, TryCatch #11 {Exception -> 0x0485, blocks: (B:190:0x03f4, B:192:0x03fa, B:194:0x0405, B:196:0x040b, B:198:0x0415, B:207:0x0426, B:210:0x0435, B:213:0x0444, B:216:0x0453, B:219:0x045e), top: B:259:0x03f4 }] */
        /* JADX WARN: Code duplicated, block: B:193:0x0403  */
        /* JADX WARN: Code duplicated, block: B:200:0x0419  */
        /* JADX WARN: Code duplicated, block: B:202:0x041d  */
        /* JADX WARN: Code duplicated, block: B:204:0x0421  */
        /* JADX WARN: Code duplicated, block: B:210:0x0435 A[Catch: Exception -> 0x0485, TryCatch #11 {Exception -> 0x0485, blocks: (B:190:0x03f4, B:192:0x03fa, B:194:0x0405, B:196:0x040b, B:198:0x0415, B:207:0x0426, B:210:0x0435, B:213:0x0444, B:216:0x0453, B:219:0x045e), top: B:259:0x03f4 }] */
        /* JADX WARN: Code duplicated, block: B:213:0x0444 A[Catch: Exception -> 0x0485, TryCatch #11 {Exception -> 0x0485, blocks: (B:190:0x03f4, B:192:0x03fa, B:194:0x0405, B:196:0x040b, B:198:0x0415, B:207:0x0426, B:210:0x0435, B:213:0x0444, B:216:0x0453, B:219:0x045e), top: B:259:0x03f4 }] */
        /* JADX WARN: Code duplicated, block: B:216:0x0453 A[Catch: Exception -> 0x0485, TryCatch #11 {Exception -> 0x0485, blocks: (B:190:0x03f4, B:192:0x03fa, B:194:0x0405, B:196:0x040b, B:198:0x0415, B:207:0x0426, B:210:0x0435, B:213:0x0444, B:216:0x0453, B:219:0x045e), top: B:259:0x03f4 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v28 */
        /* JADX WARN: Type inference failed for: r10v33 */
        /* JADX WARN: Type inference failed for: r10v37 */
        /* JADX WARN: Type inference failed for: r10v38 */
        /* JADX WARN: Type inference failed for: r10v39 */
        /* JADX WARN: Type inference failed for: r10v45 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7, types: [com.mbridge.msdk.foundation.entity.CampaignEx] */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r14v11 */
        /* JADX WARN: Type inference failed for: r14v12 */
        /* JADX WARN: Type inference failed for: r14v16 */
        /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r14v8 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r15v11 */
        /* JADX WARN: Type inference failed for: r15v14 */
        /* JADX WARN: Type inference failed for: r15v15 */
        /* JADX WARN: Type inference failed for: r15v2, types: [int] */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference failed for: r15v4 */
        /* JADX WARN: Type inference failed for: r15v5 */
        /* JADX WARN: Type inference failed for: r15v6 */
        /* JADX WARN: Type inference failed for: r15v7 */
        /* JADX WARN: Type inference failed for: r15v9 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v24 */
        /* JADX WARN: Type inference failed for: r9v25 */
        /* JADX WARN: Type inference failed for: r9v26 */
        /* JADX WARN: Type inference failed for: r9v46 */
        /* JADX WARN: Type inference failed for: r9v48 */
        /* JADX WARN: Type inference failed for: r9v49, types: [int] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v51 */
        /* JADX WARN: Type inference failed for: r9v52 */
        /* JADX WARN: Type inference failed for: r9v53 */
        /* JADX WARN: Type inference failed for: r9v54 */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8, types: [int] */
        /* JADX WARN: Type inference failed for: r9v9 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean zA;
            ?? r6;
            ?? r10;
            Object obj;
            com.mbridge.msdk.videocommon.download.b bVar;
            String str;
            boolean z;
            int i;
            boolean z2;
            int i2;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String string4 = data.getString("key");
            f fVar = (f) b.g.get(string4);
            h hVar = this.b.get(string4);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.c.get(string4);
            int i3 = message.what;
            switch (i3) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i3) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            ?? r9 = "RewardCampaignsResourceManager";
                            if (fVar != null && hVar != null) {
                                String string5 = data.getString("message");
                                if (string5 == null) {
                                    string5 = "";
                                }
                                ?? C = b.c(message.what);
                                ?? r14 = "resource download failed " + b.d(message.what) + " " + string5;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = fVar.h;
                                CampaignEx campaignEx = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : fVar.h.get(0);
                                try {
                                    try {
                                        if (!fVar.f5322a) {
                                            r9 = C;
                                            bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
                                            str = fVar.e;
                                            z = fVar.b;
                                            i = fVar.d;
                                            z2 = fVar.f5322a;
                                            if (bVar.a(94, str, z, i, z2, fVar.c, copyOnWriteArrayList)) {
                                                hVar.a(string, string2, string3, fVar.h);
                                                r6 = r14;
                                                r10 = 0;
                                            } else {
                                                if (campaignEx != null) {
                                                    i2 = message.what;
                                                    if (i2 != 200) {
                                                        if (i2 != 201) {
                                                            if (i2 != 203) {
                                                                if (i2 != 205) {
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    }
                                                }
                                                r6 = r14;
                                                r10 = 0;
                                                r10 = 0;
                                                hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, null, null));
                                                r6 = r6;
                                            }
                                            this.b.remove(string4);
                                            b.g.remove(string4);
                                            this.c.remove(string4);
                                            r9 = r9;
                                            r14 = i;
                                            C = z2;
                                        } else {
                                            try {
                                                if (fVar.i != null) {
                                                    if (fVar.c != 1) {
                                                        try {
                                                            String string6 = data.getString("url");
                                                            int i4 = message.what;
                                                            try {
                                                                if (i4 == 200) {
                                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                                        o0.c(r9, "Is TPL but  video download fail but hit ignoreCheckRule");
                                                                    } else {
                                                                        for (int i5 = 0; i5 < fVar.i.size(); i5++) {
                                                                            if (fVar.i.get(i5).getVideoUrlEncode().equals(string6)) {
                                                                                fVar.i.remove(i5);
                                                                            }
                                                                        }
                                                                        b.g.remove(string4);
                                                                        b.g.put(string4, fVar);
                                                                    }
                                                                } else if (i4 == 201) {
                                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                        o0.c(r9, "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                                    } else {
                                                                        for (int i6 = 0; i6 < fVar.i.size(); i6++) {
                                                                            CampaignEx campaignEx2 = fVar.i.get(i6);
                                                                            if (campaignEx2.getRewardTemplateMode() != null && campaignEx2.getRewardTemplateMode().c().equals(string6)) {
                                                                                fVar.i.remove(i6);
                                                                            }
                                                                            if (!TextUtils.isEmpty(campaignEx2.getendcard_url()) && campaignEx2.getendcard_url().equals(string6)) {
                                                                                fVar.i.remove(i6);
                                                                            }
                                                                        }
                                                                        b.g.remove(string4);
                                                                        b.g.put(string4, fVar);
                                                                    }
                                                                } else if (i4 == 203) {
                                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                        o0.c(r9, "Is TPL but download template fail but hit ignoreCheckRule");
                                                                    } else {
                                                                        for (int i7 = 0; i7 < fVar.i.size(); i7++) {
                                                                            CampaignEx campaignEx3 = fVar.i.get(i7);
                                                                            if (campaignEx3.getRewardTemplateMode() != null && campaignEx3.getRewardTemplateMode().e().equals(string6)) {
                                                                                fVar.i.remove(i7);
                                                                            }
                                                                        }
                                                                        b.g.remove(string4);
                                                                        b.g.put(string4, fVar);
                                                                    }
                                                                } else if (i4 == 205) {
                                                                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                        o0.c(r9, "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                                    } else {
                                                                        fVar.i.clear();
                                                                        b.g.remove(string4);
                                                                        b.g.put(string4, fVar);
                                                                    }
                                                                }
                                                                try {
                                                                    if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, fVar.e, fVar.b, fVar.d, fVar.f5322a, fVar.c, copyOnWriteArrayList)) {
                                                                        try {
                                                                            hVar.a(string, string2, string3, fVar.h);
                                                                            this.b.remove(string4);
                                                                            b.g.remove(string4);
                                                                            this.c.remove(string4);
                                                                        } catch (Exception e) {
                                                                            e = e;
                                                                            r6 = r14;
                                                                            r9 = C;
                                                                            r10 = 0;
                                                                            hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, e, r10));
                                                                            return;
                                                                        }
                                                                    } else if (fVar.i.size() == 0) {
                                                                        ?? r15 = r14;
                                                                        ?? r11 = C;
                                                                        r14 = 0;
                                                                        hVar.a(fVar.h, b.b(r11 == true ? 1 : 0, new MBridgeIds(string, string2, string3), r15, null, null));
                                                                        this.b.remove(string4);
                                                                        b.g.remove(string4);
                                                                        this.c.remove(string4);
                                                                        r9 = r11;
                                                                        C = r15;
                                                                    }
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    C = r14;
                                                                    r9 = C;
                                                                    r14 = 0;
                                                                    r10 = r14;
                                                                    r6 = C;
                                                                    hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, e, r10));
                                                                    return;
                                                                }
                                                            } catch (Exception e3) {
                                                                e = e3;
                                                                r6 = r14;
                                                                r9 = C;
                                                                r10 = 0;
                                                            }
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            r9 = C;
                                                            C = r14;
                                                            r14 = 0;
                                                            r10 = r14;
                                                            r6 = C;
                                                        }
                                                        break;
                                                    } else {
                                                        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                            int i8 = message.what;
                                                            if (i8 != 200) {
                                                                if (i8 != 201) {
                                                                    if (i8 != 203) {
                                                                        if (i8 == 205) {
                                                                            if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = fVar.h;
                                                                                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                                                    CampaignEx campaignEx4 = fVar.h.get(0);
                                                                                    if (campaignEx4.getCMPTEntryUrl().equals(campaignEx4.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                    }
                                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                            }
                                                        }
                                                        try {
                                                            obj = null;
                                                            try {
                                                                hVar.a(fVar.h, b.b(C, new MBridgeIds(string, string2, string3), r14, null, null));
                                                                this.b.remove(string4);
                                                                b.g.remove(string4);
                                                                this.c.remove(string4);
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                r10 = obj;
                                                                r6 = r14;
                                                                r9 = C;
                                                                hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, e, r10));
                                                                return;
                                                            }
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            obj = null;
                                                        }
                                                    }
                                                } else {
                                                    r9 = C;
                                                    bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
                                                    str = fVar.e;
                                                    try {
                                                        z = fVar.b;
                                                        i = fVar.d;
                                                        z2 = fVar.f5322a;
                                                        try {
                                                            if (bVar.a(94, str, z, i, z2, fVar.c, copyOnWriteArrayList)) {
                                                                hVar.a(string, string2, string3, fVar.h);
                                                                r6 = r14;
                                                                r10 = 0;
                                                            } else {
                                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                                    i2 = message.what;
                                                                    if (i2 != 200) {
                                                                        if (i2 != 201) {
                                                                            if (i2 != 203) {
                                                                                if (i2 != 205 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                                }
                                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                            }
                                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                        }
                                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                                    }
                                                                }
                                                                r6 = r14;
                                                                r10 = 0;
                                                                r10 = 0;
                                                                try {
                                                                    hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, null, null));
                                                                    r6 = r6;
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                }
                                                            }
                                                            this.b.remove(string4);
                                                            b.g.remove(string4);
                                                            this.c.remove(string4);
                                                            r9 = r9;
                                                            r14 = i;
                                                            C = z2;
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            r6 = r14;
                                                            r9 = r9;
                                                            r10 = 0;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        r6 = r14;
                                                        r9 = r9;
                                                    }
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                r9 = C;
                                                C = r14;
                                            }
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    r6 = r14;
                                    r9 = C;
                                }
                                hVar.a(fVar.h, b.b(r9, new MBridgeIds(string, string2, string3), r6, e, r10));
                                break;
                            }
                            break;
                    }
                    return;
            }
            if (fVar == null || hVar == null) {
                return;
            }
            try {
                try {
                    zA = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, fVar.e, fVar.b, fVar.d, fVar.f5322a, fVar.c, copyOnWriteArrayList);
                } catch (Exception e13) {
                    e = e13;
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                    zA = false;
                }
            } catch (Exception e14) {
                e = e14;
            }
            if (zA) {
                hVar.a(string, string2, string3, fVar.h);
                this.b.remove(string4);
                b.g.remove(string4);
                this.c.remove(string4);
            }
        }

        public void a(Context context) {
            this.f5332a = context;
        }

        public void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.c.put(str, copyOnWriteArrayList);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface n {
        void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    public interface o {
        void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.a.C0521a c0521a, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, com.mbridge.msdk.videocommon.a.C0521a c0521a);
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5337a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i2) {
        if (i2 == 200) {
            return 880004;
        }
        if (i2 == 201) {
            return 880007;
        }
        if (i2 != 203) {
            return i2 != 205 ? 880024 : 880005;
        }
        return 880006;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String d(int i2) {
        if (i2 == 200) {
            return "video";
        }
        if (i2 == 201) {
            return "zip/html";
        }
        if (i2 != 203) {
            return i2 != 205 ? "unknown" : "tpl";
        }
        return "temp";
    }

    public void c() {
    }

    private b() {
        this.c = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.d = "down_type";
        this.e = "h3c";
        this.f = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        g = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f5316a = new m(handlerThread.getLooper());
    }

    public static b b() {
        return r.f5337a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.mbridge.msdk.foundation.entity.m mVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.setting.c cVarC = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId());
            if (cVarC != null) {
                mVar.s(cVarC.x());
            }
            com.mbridge.msdk.videocommon.setting.a aVarC = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (aVarC != null) {
                mVar.r(aVarC.f());
            }
        } catch (Exception e2) {
            o0.b("RewardCampaignsResourceManager", e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static final class k implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f5328a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;

        public k(Handler handler, String str, String str2, String str3, String str4) {
            this.f5328a = handler;
            this.c = str;
            this.b = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("key", this.e);
            bundle.putString("url", str);
            messageObtain.setData(bundle);
            this.f5328a.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString("key", this.e);
            bundle.putString("message", str);
            messageObtain.setData(bundle);
            this.f5328a.sendMessage(messageObtain);
        }
    }

    public synchronized void a(Context context, boolean z, int i2, boolean z2, int i3, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, h hVar, n nVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        String str4 = str2 + "_" + str3 + "_" + copyOnWriteArrayList2.get(0).getSecondRequestIndex();
        g.put(str4, new f(z, z2, i2, copyOnWriteArrayList2.size(), str2, str3, i3, copyOnWriteArrayList2));
        this.f5316a.a(str4, hVar);
        this.f5316a.a(context);
        this.f5316a.a(str4, copyOnWriteArrayList2);
        this.f5316a.post(new a(copyOnWriteArrayList2, context, str2, i3, str, str3, str4, nVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.error.b b(int i2, MBridgeIds mBridgeIds, String str, Throwable th, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i2);
        bVar.a(mBridgeIds);
        bVar.a(th);
        bVar.c(str);
        bVar.a(campaignEx);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, CampaignEx campaignEx, String str, String str2) {
        x.a(i2, str, str2, new C0469b(i2, campaignEx), campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVarA = a(campaignEx, 3);
        if (str4.contains(".zip") && str4.contains(ResourceManager.KEY_MD5FILENAME)) {
            boolean zIsEmpty = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str4));
            try {
                l lVar = new l(context, str, str2, str3, campaignEx, 497, this.f5316a, nVar, copyOnWriteArrayList);
                lVar.a(zIsEmpty);
                H5DownLoadManager.getInstance().downloadH5Res(cVarA, str4, lVar);
                return;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str4));
        try {
            i iVar = new i(497, str, str2, str3, campaignEx, nVar, this.f5316a, copyOnWriteArrayList);
            iVar.a(zIsEmpty2);
            H5DownLoadManager.getInstance().downloadH5Res(cVarA, str4, iVar);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class g extends com.mbridge.msdk.mbsignalcommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f5323a;
        private final Runnable b;
        private final boolean c;
        private final boolean d;
        private int e;
        private String f;
        private String g;
        private String h;
        private String i;
        private com.mbridge.msdk.videocommon.a.C0521a j;
        private CampaignEx k;
        private CopyOnWriteArrayList<CampaignEx> l;
        private com.mbridge.msdk.videocommon.setting.c m;
        private final o n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r = 0;
        private boolean s;
        private long t;

        public g(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i, String str, String str2, String str3, String str4, com.mbridge.msdk.videocommon.a.C0521a c0521a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, o oVar, boolean z4, long j) {
            this.f5323a = handler;
            this.b = runnable;
            this.c = z2;
            this.d = z3;
            this.e = i;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.i = str4;
            this.j = c0521a;
            this.k = campaignEx;
            this.l = copyOnWriteArrayList;
            this.m = cVar;
            this.n = oVar;
            this.o = z4;
            this.s = z;
            this.t = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 1);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.k, eVar);
            } catch (Throwable th) {
                o0.b("RVWindVaneWebView", th.getMessage());
            }
            if (this.q) {
                return;
            }
            String str = this.g + "_" + this.f;
            if (i == 1) {
                if (this.o) {
                    com.mbridge.msdk.videocommon.a.d(this.g + "_" + this.i);
                } else {
                    com.mbridge.msdk.videocommon.a.c(this.g + "_" + this.i);
                }
                com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.i + "_" + this.f, this.j, true, this.o);
                Handler handler = this.f5323a;
                if (handler != null && (runnable = this.b) != null) {
                    handler.removeCallbacks(runnable);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, true);
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.j;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                o oVar = this.n;
                if (oVar != null) {
                    oVar.a(str, this.h, this.g, this.i, this.f, this.j);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, false);
                com.mbridge.msdk.videocommon.a.C0521a c0521a2 = this.j;
                if (c0521a2 != null) {
                    c0521a2.a(false);
                }
                if (this.n != null) {
                    this.n.a(str, this.i, this.f, this.j, b.b(880008, new MBridgeIds(this.h, this.g, this.i), "readyState:" + i, null, this.k));
                }
            }
            this.q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(WebView webView, String str, String str2, int i, int i2) {
            boolean z = true;
            if (i == 1) {
                try {
                    com.mbridge.msdk.reward.controller.a aVar = new com.mbridge.msdk.reward.controller.a();
                    aVar.e(false);
                    if (i2 != 2) {
                        z = false;
                    }
                    aVar.d(z);
                    aVar.c(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.orglistener.a(null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, i2, str2, true, 1));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RVWindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    String strOptString = MintegralNetworkBridge.jsonObjectInit(str).optString("id");
                    com.mbridge.msdk.video.bt.component.d.c().b(obj, strOptString);
                    String strF = com.mbridge.msdk.video.bt.component.d.c().f(strOptString);
                    CampaignEx campaignExC = com.mbridge.msdk.video.bt.component.d.c().c(strOptString);
                    com.mbridge.msdk.videocommon.setting.c cVarD = com.mbridge.msdk.video.bt.component.d.c().d(strOptString);
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(campaignExC);
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                    if (windVaneWebView != null) {
                        b.b().a(this.s, windVaneWebView, campaignExC, (CopyOnWriteArrayList<CampaignEx>) copyOnWriteArrayList, cVarD, strF, strOptString, this.r == 0 ? 3 : 6);
                        this.r++;
                    }
                } catch (Throwable th) {
                    o0.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.p) {
                return;
            }
            String str2 = this.g + "_" + this.f;
            if (!str.contains("wfr=1")) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, true);
                Handler handler = this.f5323a;
                if (handler != null && (runnable = this.b) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.j;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                o oVar = this.n;
                if (oVar != null) {
                    oVar.a(str2, this.h, this.g, this.i, this.f, this.j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, false);
            if (this.n != null) {
                String str3 = this.g + "_" + this.f;
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.j;
                if (c0521a != null) {
                    c0521a.a(false);
                }
                this.n.a(str3, this.i, this.f, this.j, b.b(880008, new MBridgeIds(this.h, this.g, this.i), "onReceivedError： " + i + "  " + str, null, this.k));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView) {
            if (webView != null) {
                try {
                    com.mbridge.msdk.video.bt.component.d.c().c(this.g, this.i);
                } catch (Throwable th) {
                    o0.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    class C0469b implements x.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5318a;
        final /* synthetic */ CampaignEx b;

        C0469b(int i, CampaignEx campaignEx) {
            this.f5318a = i;
            this.b = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, String str2, String str3, String str4, boolean z) {
            if (z) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                int i = this.f5318a;
                if (i == 0) {
                    mVar.e(1);
                    mVar.d(1);
                    mVar.j("m_download_end");
                } else if (i == 1) {
                    mVar.e(2);
                    mVar.d(1);
                    mVar.j("m_download_end");
                } else if (i == 2) {
                    mVar.e(3);
                    mVar.d(1);
                    mVar.j("m_download_end");
                    mVar.b(this.b.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                    mVar.f("1");
                }
                mVar.o(this.b.getRequestIdNotice());
                mVar.b("url", str);
                mVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.b);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, DownloadError downloadError) {
            String message = "";
            if (downloadError != null) {
                try {
                    if (downloadError.getException() != null) {
                        message = downloadError.getException().getMessage();
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            int i = this.f5318a;
            if (i == 0) {
                mVar.e(1);
                mVar.d(3);
                mVar.j("m_download_end");
            } else if (i == 1) {
                mVar.e(2);
                mVar.d(3);
                mVar.j("m_download_end");
            } else if (i == 2) {
                mVar.e(3);
                mVar.d(3);
                mVar.j("m_download_end");
                mVar.b(this.b.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                mVar.f("1");
            }
            b.b(mVar, this.b);
            mVar.o(this.b.getRequestIdNotice());
            mVar.m(message);
            mVar.b("scenes", "1");
            mVar.b("url", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.b);
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class q extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5336a;
        private final boolean b;
        private final WindVaneWebView c;
        private final String d;
        private final String e;
        private final com.mbridge.msdk.videocommon.a.C0521a f;
        private final CampaignEx g;
        private boolean h;
        private String i;
        private boolean j;
        private boolean k;

        public q(String str, boolean z, WindVaneWebView windVaneWebView, String str2, String str3, com.mbridge.msdk.videocommon.a.C0521a c0521a, CampaignEx campaignEx, boolean z2, String str4) {
            this.b = z;
            this.c = windVaneWebView;
            this.d = str2;
            this.e = str3;
            this.f = c0521a;
            this.g = campaignEx;
            this.f5336a = str;
            this.h = z2;
            this.i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.g, eVar);
            } catch (Throwable th) {
                o0.b("WindVaneWebView", th.getMessage());
            }
            if (this.k) {
                return;
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f5336a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
            String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
            if (i == 1) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, true);
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.f;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                if (this.b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, false);
                com.mbridge.msdk.videocommon.a.C0521a c0521a2 = this.f;
                if (c0521a2 != null) {
                    c0521a2.a(false);
                }
            }
            this.k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, false);
            com.mbridge.msdk.videocommon.a.C0521a c0521a = this.f;
            if (c0521a != null) {
                c0521a.a(false);
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f5336a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            if (this.j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f5336a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("WindVaneWebView", e.getLocalizedMessage());
                        }
                    }
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, true);
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.f;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                if (this.b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.j = true;
        }
    }

    public synchronized void a(Context context, CampaignEx campaignEx, String str, String str2, String str3, n nVar) {
        this.f5316a.a(context);
        if (campaignEx != null) {
            String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
            if (campaignEx.isDynamicView()) {
                if (t0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, cMPTEntryUrl)) {
                    a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                }
                ResDownloadCheckManager.getInstance().setZipDownloadDone(cMPTEntryUrl, true);
                Message messageObtain = Message.obtain();
                messageObtain.what = 105;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString("request_id", str3);
                bundle.putString("key", str2 + "_" + str3 + "_" + campaignEx.getSecondRequestIndex());
                bundle.putString("url", cMPTEntryUrl);
                messageObtain.setData(bundle);
                this.f5316a.sendMessage(messageObtain);
                if (nVar != null) {
                    nVar.a(str, str2, str3, cMPTEntryUrl);
                }
                return;
            }
        }
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c cVarA = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(campaignEx.getCurrentLocalRid());
                if (cVarA == null) {
                    cVarA = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                com.mbridge.msdk.foundation.same.report.metrics.c cVar = cVarA;
                cVar.a(campaignEx);
                cVar.e(1);
                cVar.f(a(campaignEx));
                H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getCMPTEntryUrl(), new c(str2, str, str3, campaignEx, nVar, context));
            } catch (Exception e2) {
                o0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
    private static class p extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f5333a;
        private Runnable b;
        private final boolean c;
        private final boolean d;
        private String e;
        private final o f;
        private final WindVaneWebView g;
        private final String h;
        private final String i;
        private final String j;
        private final com.mbridge.msdk.videocommon.a.C0521a k;
        private final CampaignEx l;
        private CopyOnWriteArrayList<CampaignEx> m;
        private long n;
        private boolean o;
        private boolean p;
        private final Runnable q;
        private final Runnable r;

        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f5334a;
            final /* synthetic */ com.mbridge.msdk.videocommon.a.C0521a b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ String f;

            a(o oVar, com.mbridge.msdk.videocommon.a.C0521a c0521a, String str, String str2, String str3, String str4) {
                this.f5334a = oVar;
                this.b = c0521a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView windVaneWebViewB;
                com.mbridge.msdk.videocommon.a.C0521a c0521a;
                if (this.f5334a != null && (c0521a = this.b) != null) {
                    c0521a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.c + "_" + this.d + "_" + this.e, true);
                    this.f5334a.a(this.c + "_" + this.e, this.f, this.c, this.d, this.e, this.b);
                }
                com.mbridge.msdk.videocommon.a.C0521a c0521a2 = this.b;
                if (c0521a2 == null || (windVaneWebViewB = c0521a2.b()) == null) {
                    return;
                }
                try {
                    windVaneWebViewB.release();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.b$p$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RewardCampaignsResourceManager.java */
        class RunnableC0471b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f5335a;
            final /* synthetic */ com.mbridge.msdk.videocommon.a.C0521a b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ String f;

            RunnableC0471b(o oVar, com.mbridge.msdk.videocommon.a.C0521a c0521a, String str, String str2, String str3, String str4) {
                this.f5335a = oVar;
                this.b = c0521a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView windVaneWebViewB;
                com.mbridge.msdk.videocommon.a.C0521a c0521a;
                if (this.f5335a != null && (c0521a = this.b) != null) {
                    c0521a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.c + "_" + this.d + "_" + this.e, true);
                    this.f5335a.a(this.c + "_" + this.e, this.f, this.c, this.d, this.e, this.b);
                }
                com.mbridge.msdk.videocommon.a.C0521a c0521a2 = this.b;
                if (c0521a2 == null || (windVaneWebViewB = c0521a2.b()) == null) {
                    return;
                }
                try {
                    windVaneWebViewB.release();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        public p(Handler handler, Runnable runnable, boolean z, boolean z2, String str, o oVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, com.mbridge.msdk.videocommon.a.C0521a c0521a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j) {
            this.f5333a = handler;
            this.b = runnable;
            this.c = z;
            this.d = z2;
            this.e = str;
            this.f = oVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.i = str4;
            this.j = str3;
            this.k = c0521a;
            this.l = campaignEx;
            this.m = copyOnWriteArrayList;
            this.n = j;
            a aVar = new a(oVar, c0521a, str4, str, str2, str3);
            this.r = aVar;
            this.q = new RunnableC0471b(oVar, c0521a, str4, str, str2, str3);
            if (handler != null) {
                handler.postDelayed(aVar, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i);
            Handler handler2 = this.f5333a;
            if (handler2 != null && (runnable2 = this.q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f5333a;
            if (handler3 != null && (runnable = this.r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.l, eVar);
            } catch (Throwable th) {
                o0.b("WindVaneWebView", th.getMessage());
            }
            if (this.p) {
                return;
            }
            String str = this.i + "_" + this.h;
            if (i == 1) {
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f5333a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, true);
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.k;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                if (this.c) {
                    if (this.d) {
                        com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.d) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                o oVar = this.f;
                if (oVar != null) {
                    oVar.a(str, this.j, this.i, this.e, this.h, this.k);
                }
            } else if (this.f != null) {
                this.f.a(str, this.e, this.h, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), "readyState:" + i, null, this.l));
            }
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f5333a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.f5333a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.i + "_" + this.h;
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.k;
                if (c0521a != null) {
                    c0521a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str3, this.e, str2, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), i + "#" + str, null, this.l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f5333a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.f5333a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.i + "_" + this.h;
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.k;
                if (c0521a != null) {
                    c0521a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str, this.e, this.h, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), "onReceivedSslError:" + (sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError())), null, this.l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f5333a;
            if (handler2 != null && (runnable2 = this.r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.o) {
                return;
            }
            if (!str.contains("wfr=1")) {
                String str2 = this.i + "_" + this.h;
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, true);
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f5333a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.mbridge.msdk.videocommon.a.C0521a c0521a = this.k;
                if (c0521a != null) {
                    c0521a.a(true);
                }
                if (this.c) {
                    if (this.l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.l.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                o oVar = this.f;
                if (oVar != null) {
                    oVar.a(str2, this.j, this.i, this.e, this.h, this.k);
                }
            } else {
                Handler handler3 = this.f5333a;
                if (handler3 != null && (runnable = this.q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i2, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new d(campaignEx, context, i2, str, str2, str3, str4));
    }

    /* JADX WARN: Code duplicated, block: B:62:0x01bf A[Catch: all -> 0x01ee, TryCatch #9 {, blocks: (B:4:0x000b, B:5:0x0026, B:8:0x002e, B:11:0x0040, B:18:0x0077, B:21:0x007d, B:23:0x0083, B:26:0x008e, B:28:0x00c7, B:30:0x00dd, B:60:0x01bb, B:62:0x01bf, B:64:0x01ca, B:25:0x0089, B:52:0x0162, B:38:0x00f8, B:40:0x0108, B:42:0x011e), top: B:82:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01ca A[Catch: all -> 0x01ee, TRY_LEAVE, TryCatch #9 {, blocks: (B:4:0x000b, B:5:0x0026, B:8:0x002e, B:11:0x0040, B:18:0x0077, B:21:0x007d, B:23:0x0083, B:26:0x008e, B:28:0x00c7, B:30:0x00dd, B:60:0x01bb, B:62:0x01bf, B:64:0x01ca, B:25:0x0089, B:52:0x0162, B:38:0x00f8, B:40:0x0108, B:42:0x011e), top: B:82:0x000b }] */
    public synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, String str4, String str5, String str6, com.mbridge.msdk.videocommon.setting.c cVar, o oVar) {
        String str7;
        String str8;
        String str9;
        String str10;
        com.mbridge.msdk.video.signal.impl.k kVar;
        String str11 = str4 + "_" + str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (t0.i(str)) {
                if (oVar != null) {
                    oVar.a(str11, str3, str4, str5, str, null);
                }
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
            com.mbridge.msdk.videocommon.a.C0521a c0521a = new com.mbridge.msdk.videocommon.a.C0521a();
            try {
                try {
                    try {
                        try {
                            try {
                                WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
                                if (campaignEx != null) {
                                    windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                }
                                windVaneWebView2.setTempTypeForMetrics(2);
                                try {
                                    c0521a.a(windVaneWebView2);
                                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                                        kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                                    } else {
                                        kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                                    }
                                    com.mbridge.msdk.video.signal.impl.k kVar2 = kVar;
                                    kVar2.g(i2);
                                    kVar2.setUnitId(str4);
                                    kVar2.setRewardUnitSetting(cVar);
                                    kVar2.d(z);
                                    try {
                                        windVaneWebView2.setWebViewListener(new p(handler, null, z2, z3, str5, oVar, windVaneWebView, str, str3, str4, c0521a, campaignEx, copyOnWriteArrayList, jCurrentTimeMillis));
                                        windVaneWebView2.setObject(kVar2);
                                        MintegralNetworkBridge.webviewLoadUrl(windVaneWebView2, str2);
                                        windVaneWebView2.setRid(str5);
                                    } catch (Exception e2) {
                                        e = e2;
                                        str7 = str5;
                                        str8 = str4;
                                        if (MBridgeConstans.DEBUG) {
                                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                        if (oVar != null) {
                                            oVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str8, str7), "", e, campaignEx));
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str7 = str5;
                                }
                            } catch (Exception unused) {
                                str10 = str;
                                str9 = str4;
                                if (oVar != null) {
                                    c0521a.a(true);
                                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str9 + "_" + str5 + "_" + str10, true);
                                    oVar.a(str9 + "_" + str10, str3, str4, str5, str, c0521a);
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            if (MBridgeConstans.DEBUG) {
                                o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                            }
                            if (oVar != null) {
                                oVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str8, str7), "", e, campaignEx));
                            }
                        }
                    } catch (Exception unused2) {
                        str9 = str4;
                        str10 = str;
                    }
                } catch (Throwable unused3) {
                    str7 = str5;
                    if (oVar != null) {
                        c0521a.a(true);
                        str8 = str4;
                        try {
                            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str8 + "_" + str7 + "_" + str, true);
                            oVar.a(str8 + "_" + str, str3, str4, str5, str, c0521a);
                        } catch (Exception e5) {
                            e = e5;
                            if (MBridgeConstans.DEBUG) {
                                o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                            }
                            if (oVar != null) {
                                oVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str8, str7), "", e, campaignEx));
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e7) {
            e = e7;
            str7 = str5;
            str8 = str4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01d6 A[Catch: all -> 0x0207, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x000d, B:7:0x0036, B:10:0x004a, B:12:0x007d, B:13:0x0084, B:15:0x009f, B:17:0x00a5, B:19:0x00af, B:22:0x00b6, B:24:0x00bc, B:25:0x00c6, B:27:0x00cc, B:29:0x00e0, B:31:0x00ee, B:33:0x00f7, B:34:0x00fb, B:36:0x0108, B:38:0x0159, B:40:0x016d, B:42:0x018d, B:54:0x01d6, B:55:0x01f8, B:57:0x01fc, B:35:0x0102), top: B:67:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01fc A[Catch: all -> 0x0207, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x000d, B:7:0x0036, B:10:0x004a, B:12:0x007d, B:13:0x0084, B:15:0x009f, B:17:0x00a5, B:19:0x00af, B:22:0x00b6, B:24:0x00bc, B:25:0x00c6, B:27:0x00cc, B:29:0x00e0, B:31:0x00ee, B:33:0x00f7, B:34:0x00fb, B:36:0x0108, B:38:0x0159, B:40:0x016d, B:42:0x018d, B:54:0x01d6, B:55:0x01f8, B:57:0x01fc, B:35:0x0102), top: B:67:0x000d }] */
    public synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str6, String str7, com.mbridge.msdk.videocommon.setting.c cVar, o oVar, boolean z4) {
        String str8;
        String str9;
        com.mbridge.msdk.video.signal.impl.k kVar;
        this.b = z4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str10 = str4 + "_" + str5;
        this.b = z4;
        if (t0.i(str5)) {
            if (oVar != null) {
                oVar.a(str10, str3, str4, str, str5, null);
            }
            return;
        }
        try {
            o0.a("RewardCampaignsResourceManager", "开始预加载大模板资源");
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", 1);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
            com.mbridge.msdk.videocommon.a.C0521a c0521a = new com.mbridge.msdk.videocommon.a.C0521a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            if (campaignEx != null) {
                windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
            }
            windVaneWebView.setTempTypeForMetrics(1);
            c0521a.a(windVaneWebView);
            String strB = com.mbridge.msdk.video.bt.component.d.c().b();
            String strB2 = com.mbridge.msdk.video.bt.component.d.c().b();
            c0521a.a(strB2);
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB = com.mbridge.msdk.videocommon.download.b.getInstance().b(str4);
                if (copyOnWriteArrayListB != null && copyOnWriteArrayListB.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i3);
                        for (CampaignEx campaignEx3 : copyOnWriteArrayListB) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i3, campaignEx2);
                            }
                        }
                    }
                }
                kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
            } else {
                kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
            }
            com.mbridge.msdk.video.signal.impl.k kVar2 = kVar;
            kVar2.g(i2);
            kVar2.setUnitId(str7);
            kVar2.c(strB2);
            kVar2.d(strB);
            kVar2.c(true);
            kVar2.setRewardUnitSetting(cVar);
            kVar2.d(z);
            try {
                windVaneWebView.setWebViewListener(new g(z, handler, null, z2, z3, i2, str5, str3, str4, str, c0521a, campaignEx, copyOnWriteArrayList, cVar, oVar, z4, jCurrentTimeMillis));
                windVaneWebView.setObject(kVar2);
                MintegralNetworkBridge.webviewLoadUrl(windVaneWebView, str6);
                str9 = str;
                try {
                    windVaneWebView.setRid(str9);
                    MBridgeBTRootLayout mBridgeBTRootLayout = new MBridgeBTRootLayout(com.mbridge.msdk.foundation.controller.c.m().d());
                    mBridgeBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    mBridgeBTRootLayout.setInstanceId(strB);
                    str8 = str4;
                    try {
                        mBridgeBTRootLayout.setUnitId(str8);
                        MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().d());
                        mBridgeBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        mBridgeBTLayout.setInstanceId(strB2);
                        mBridgeBTLayout.setUnitId(str8);
                        mBridgeBTLayout.setWebView(windVaneWebView);
                        AbstractMap abstractMapB = com.mbridge.msdk.video.bt.component.d.c().b(str8, str9);
                        abstractMapB.put(strB2, mBridgeBTLayout);
                        abstractMapB.put(strB, mBridgeBTRootLayout);
                        mBridgeBTRootLayout.addView(mBridgeBTLayout, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception e2) {
                        e = e2;
                        if (oVar != null) {
                            oVar.a(str10, str, str5, null, b(880008, new MBridgeIds(str3, str8, str9), "", e, campaignEx));
                        }
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    str8 = str4;
                    if (oVar != null) {
                        oVar.a(str10, str, str5, null, b(880008, new MBridgeIds(str3, str8, str9), "", e, campaignEx));
                    }
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            } catch (Exception e4) {
                e = e4;
                str9 = str;
            }
        } catch (Exception e5) {
            e = e5;
            str8 = str4;
            str9 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (campaignEx != null && cVar != null && campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", str2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "data is null");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                            return;
                        }
                        return;
                    }
                }
                if (!TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) && campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                    o0.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new e(z, windVaneWebView, campaignEx, copyOnWriteArrayList, str, cVar, str2), i2 * 1000);
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", str2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", 2);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, com.mbridge.msdk.videocommon.setting.c cVar, String str4, boolean z2) {
        com.mbridge.msdk.video.signal.impl.k kVar;
        String requestId;
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
            com.mbridge.msdk.videocommon.a.C0521a c0521a = new com.mbridge.msdk.videocommon.a.C0521a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            if (campaignEx != null) {
                windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
            }
            windVaneWebView2.setTempTypeForMetrics(2);
            c0521a.a(windVaneWebView2);
            String requestId2 = "";
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListB = com.mbridge.msdk.videocommon.download.b.getInstance().b(str3);
                if (copyOnWriteArrayListB != null && copyOnWriteArrayListB.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i3);
                        for (CampaignEx campaignEx3 : copyOnWriteArrayListB) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i3, campaignEx2);
                            }
                        }
                    }
                }
                com.mbridge.msdk.video.signal.impl.k kVar2 = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                requestId = copyOnWriteArrayList.get(0).getRequestId();
                kVar = kVar2;
            } else {
                com.mbridge.msdk.video.signal.impl.k kVar3 = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                if (campaignEx != null) {
                    requestId2 = campaignEx.getRequestId();
                }
                kVar = kVar3;
                requestId = requestId2;
            }
            kVar.g(i2);
            kVar.setUnitId(str3);
            kVar.c(str4);
            kVar.setRewardUnitSetting(cVar);
            kVar.d(z);
            windVaneWebView2.setWebViewListener(new q(str4, false, windVaneWebView, str, str3, c0521a, campaignEx, z2, requestId));
            windVaneWebView2.setObject(kVar);
            MintegralNetworkBridge.webviewLoadUrl(windVaneWebView2, str2);
            windVaneWebView2.setRid(requestId);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                o0.b("RewardCampaignsResourceManager", th.getMessage());
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVarA = campaignEx != null ? com.mbridge.msdk.foundation.same.report.metrics.d.b().a(campaignEx.getCurrentLocalRid()) : null;
        if (cVarA == null) {
            cVarA = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        cVarA.a(campaignEx);
        cVarA.f(a(campaignEx));
        cVarA.e(i2);
        return cVarA;
    }
}
