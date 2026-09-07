package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: CampaignDownLoadTask.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {
    private int A;
    private File B;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private com.mbridge.msdk.setting.l H;
    private com.mbridge.msdk.videocommon.setting.c I;
    private com.mbridge.msdk.setting.l J;
    private int b;
    private int c;
    private com.mbridge.msdk.videocommon.listener.a g;
    private com.mbridge.msdk.videocommon.listener.a h;
    private CampaignEx i;
    private String j;
    private Context k;
    private long l;
    private String m;
    private String n;
    private String p;
    private long r;
    private m u;
    private String w;
    private DownloadRequest x;
    private int y;
    private boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5959a = false;
    private boolean d = false;
    private volatile int e = 0;
    private CopyOnWriteArrayList<c> f = new CopyOnWriteArrayList<>();
    private long o = 0;
    private boolean q = false;
    private int s = 100;
    private boolean t = false;
    private boolean v = false;
    private int C = 1;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private OnDownloadStateListener R = new C0523a();
    private OnProgressStateListener S = new b();

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.download.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CampaignDownLoadTask.java */
    class C0523a implements OnDownloadStateListener {
        C0523a() {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onCancelDownload(DownloadMessage downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadComplete(DownloadMessage downloadMessage) {
            String str;
            try {
                o0.b("CampaignDownLoadTask", "onDownloadComplete callback : " + a.this.o + "    " + a.this.l);
                if (a.this.u == null) {
                    a.this.u = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                }
                a.this.u.a(a.this.m, a.this.o, 5);
                if (downloadMessage != null) {
                    try {
                        str = (String) downloadMessage.getExtra("responseHeaders");
                    } catch (Throwable th) {
                        o0.b("CampaignDownLoadTask", th.getMessage());
                        str = "";
                    }
                } else {
                    str = "";
                }
                a aVar = a.this;
                aVar.a(aVar.o, true, str);
                a.this.u.a(a.this.m, a.this.o, 5);
                a aVar2 = a.this;
                aVar2.a(aVar2.o, true, "");
                a.this.a(1, true, "");
            } catch (Exception e) {
                o0.b("CampaignDownLoadTask", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
            if (a.this.x == null || a.this.x.getStatus() == DownloadStatus.CANCELLED) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(Reporting.EventType.CACHE, a.this.x.get(Reporting.EventType.CACHE, "2"));
            a aVar = a.this;
            aVar.a(aVar.i, eVar);
            String message = (downloadError == null || downloadError.getException() == null) ? "Video Download Error" : downloadError.getException().getMessage();
            a.this.m();
            a.this.a(3, message, "");
            a.this.b(message);
            a aVar2 = a.this;
            aVar2.a(3, aVar2.z, message);
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public void onDownloadStart(DownloadMessage downloadMessage) {
            a.this.e = 1;
            if (a.this.u == null) {
                a.this.u = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
            }
            a.this.u.a(a.this.i, a.this.l, a.this.p, a.this.e);
        }
    }

    /* JADX INFO: compiled from: CampaignDownLoadTask.java */
    class b implements OnProgressStateListener {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.download.OnProgressStateListener
        public void onProgress(DownloadMessage downloadMessage, DownloadProgress downloadProgress) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(Reporting.EventType.CACHE, a.this.x.get(Reporting.EventType.CACHE, "2"));
                a aVar = a.this;
                aVar.a(aVar.i, eVar);
                a.this.o = downloadProgress.getCurrent();
                a.this.l = downloadProgress.getTotal();
                a.this.y = downloadProgress.getCurrentDownloadRate();
                if (a.this.s != 100 && downloadProgress.getCurrentDownloadRate() >= a.this.s) {
                    o0.b("CampaignDownLoadTask", "Rate : " + downloadProgress.getCurrentDownloadRate() + " ReadyRate & cdRate = " + a.this.s + " " + a.this.c);
                    if (a.this.d) {
                        return;
                    }
                    a.this.d = true;
                    if (!a.this.z) {
                        a.this.a(1, true, "");
                        a.this.a(downloadProgress.getCurrent(), false, "");
                    }
                    if (a.this.x == null || a.this.C != 2 || a.this.z) {
                        return;
                    }
                    a.this.x.cancel(downloadMessage);
                }
            } catch (Exception e) {
                o0.b("CampaignDownLoadTask", e.getMessage());
            }
        }
    }

    public a(Context context, CampaignEx campaignEx, String str, int i) {
        this.b = 1;
        this.G = false;
        if (context == null && campaignEx == null) {
            return;
        }
        com.mbridge.msdk.setting.g gVarB = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarB != null) {
            this.G = gVarB.D0();
        }
        this.D = com.mbridge.msdk.foundation.same.a.u;
        this.E = com.mbridge.msdk.foundation.same.a.v;
        this.F = com.mbridge.msdk.foundation.same.a.t;
        this.r = System.currentTimeMillis();
        this.k = com.mbridge.msdk.foundation.controller.c.m().d();
        this.i = campaignEx;
        this.j = str;
        this.b = i;
        if (campaignEx != null) {
            this.m = campaignEx.getVideoUrlEncode();
        }
        this.w = m0.d(this.m);
        this.n = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC) + File.separator;
        this.p = this.n + this.w;
        o0.c("CampaignDownLoadTask", this.i.getAppName() + " videoLocalPath:" + this.p + " videoUrl: " + this.i.getVideoUrlEncode() + " " + this.s);
        l();
    }

    private void u() {
        m mVarA = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        com.mbridge.msdk.foundation.entity.l lVarB = mVarA.b(this.m, "");
        if (lVarB != null) {
            this.o = lVarB.c();
            if (this.e != 2) {
                this.e = lVarB.b();
            }
            if (this.e == 1) {
                this.e = 2;
            }
            this.l = lVarB.d();
            if (lVarB.a() > 0) {
                this.r = lVarB.a();
            }
            if (this.e == 5) {
                if (Objects.exists(new File(this.n + this.w), this.n, this.w)) {
                    this.p = this.n + this.w;
                } else {
                    a();
                }
            } else if (this.e != 0) {
                this.p = this.n + this.w;
            }
        } else {
            mVarA.a(this.m, this.r);
        }
        try {
            long j = this.l;
            if (j <= 0 || this.o * 100 < j * ((long) c(this.i))) {
                return;
            }
            if (c(this.i) == 100 || this.e == 5) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(Reporting.EventType.CACHE, 1);
                a(this.i, eVar);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean o() {
        return this.v;
    }

    public boolean p() {
        return this.L;
    }

    public boolean q() {
        return this.Q;
    }

    public boolean r() {
        return this.N;
    }

    public boolean s() {
        return this.M;
    }

    public void t() {
        if (this.f != null) {
            this.f = null;
        }
    }

    public void v() {
        if (this.Q) {
            return;
        }
        try {
            this.z = true;
            if (this.C == 1) {
                o0.b("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.C);
                return;
            }
            if (this.b == 3) {
                o0.b("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.b);
                return;
            }
            o0.b("CampaignDownLoadTask", "resume()");
            this.O = false;
            this.P = false;
            DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.m, this.w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            downloadMessage.setUseCronetDownload(a(this.i));
            DownloadRequest<?> downloadRequestA = a(downloadMessage, this.R, this.S, "2");
            this.x = downloadRequestA;
            downloadRequestA.start();
        } catch (Exception e) {
            o0.b("CampaignDownLoadTask", e.getMessage());
        }
    }

    public void w() {
        o0.b("CampaignDownLoadTask", "start()");
        try {
            if (TextUtils.isEmpty(this.m)) {
                return;
            }
            if (d() != null) {
                o0.b("CampaignDownLoadTask", new URL(d()).getPath());
            }
            if (this.s == 0 && this.C == 2) {
                o0.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                return;
            }
            DownloadRequest downloadRequest = this.x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public void x() {
        o0.b("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.m)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.g;
                if (aVar != null) {
                    aVar.a(this.m);
                    return;
                }
                return;
            }
            if (d() != null) {
                o0.b("CampaignDownLoadTask", new URL(d()).getPath());
            }
            if (this.b == 3) {
                o0.b("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.g;
                if (aVar2 != null) {
                    aVar2.a(this.m);
                    return;
                }
                return;
            }
            if (this.s == 0 && this.C == 2) {
                o0.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.a(this.m);
                    return;
                }
                return;
            }
            try {
                if (this.e == 5 && Utils.getDownloadRate(this.l, this.o) >= this.s && Objects.exists(new File(this.n + this.w), this.n, this.w)) {
                    this.p = this.n + this.w;
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.g;
                    if (aVar4 != null) {
                        aVar4.a(this.m);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                o0.b("CampaignDownLoadTask", "startForLoadRefactor: " + e.getMessage());
            }
            DownloadRequest downloadRequest = this.x;
            if (downloadRequest != null) {
                downloadRequest.start();
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.g;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    private void l() {
        File file;
        File file2;
        try {
            if (TextUtils.isEmpty(this.m)) {
                return;
            }
            if (TextUtils.isEmpty(this.n)) {
                file = null;
            } else {
                file = new File(this.n);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            if (file != null && file.exists() && ((file2 = this.B) == null || !file2.exists())) {
                File file3 = new File(file + "/.nomedia");
                this.B = file3;
                if (!file3.exists()) {
                    this.B.createNewFile();
                }
            }
            u();
            a(this.m);
        } catch (Exception e) {
            o0.c("CampaignDownLoadTask", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            t0.a(this.j, this.i, com.mbridge.msdk.foundation.same.a.x);
        } catch (Exception e) {
            o0.b("CampaignDownLoadTask", e.getMessage());
        }
    }

    public void c(boolean z) {
        this.L = z;
    }

    public String d() {
        return this.m;
    }

    public void e(boolean z) {
        this.N = z;
    }

    public void f(boolean z) {
        this.M = z;
    }

    public String g() {
        if (this.Q) {
            try {
                File file = new File(this.p);
                return (file.exists() && file.isFile()) ? this.p : this.m;
            } catch (Exception e) {
                o0.b("CampaignDownLoadTask", e.getMessage());
                return this.m;
            }
        }
        try {
            File file2 = new File(this.p);
            if (Objects.exists(file2, this.n, this.w) && file2.isFile()) {
                return this.p;
            }
        } catch (Exception e2) {
            o0.b("CampaignDownLoadTask", e2.getMessage());
        }
        return this.m;
    }

    public long h() {
        return this.o;
    }

    public long i() {
        return this.r;
    }

    public int j() {
        return this.e;
    }

    public String k() {
        return this.p;
    }

    public boolean n() {
        return this.K;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(boolean z) {
        this.q = z;
    }

    public long e() {
        return this.l;
    }

    public String f() {
        String message = "";
        if (this.b == 3) {
            return "";
        }
        String str = this.n + this.w;
        File file = new File(str);
        try {
            if (Objects.exists(file, this.n, this.w)) {
                if (file.isFile()) {
                    if (!file.canRead()) {
                        message = "file can not read ";
                    } else if (file.length() > 0) {
                        this.p = str;
                    } else {
                        message = "file length is 0 ";
                    }
                } else {
                    message = "file is not file ";
                }
            } else {
                message = "file is not exist ";
            }
        } catch (Throwable th) {
            o0.b("CampaignDownLoadTask", th.getMessage());
            message = th.getMessage();
        }
        if (this.e == 5 && !TextUtils.isEmpty(message)) {
            a();
        }
        return message;
    }

    public void b(int i) {
        this.c = i;
    }

    public CampaignEx c() {
        return this.i;
    }

    public void d(int i) {
        o0.a("CampaignDownLoadTask", "set ready rate: " + i);
        this.s = i;
    }

    public void e(CampaignEx campaignEx) {
        this.i = campaignEx;
    }

    private int c(CampaignEx campaignEx) {
        int iD;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            iD = campaignEx.getReady_rate();
            o0.a("CampaignDownLoadTask", "ready_rate(campaign): " + iD);
        } else {
            iD = d(campaignEx);
            o0.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + iD);
        }
        try {
            return Math.max(iD, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    public void b(boolean z) {
        this.v = z;
    }

    public void e(int i) {
        this.C = i;
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.H == null) {
                    this.H = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                }
                return this.H.C();
            }
            if (campaignEx.getAdType() == 42) {
                if (this.J == null) {
                    this.J = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                }
                return b((CampaignEx) null);
            }
            if (this.I == null) {
                this.I = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.j, false);
            }
            return this.I.w();
        } catch (Throwable th) {
            o0.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    public void b(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.g;
        if (aVar != null) {
            aVar.a(str, this.m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(str, this.m);
        }
        o0.b("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.e == 4 || this.e == 2 || this.e == 5) {
            return;
        }
        this.e = 4;
        CampaignEx campaignEx = this.i;
        if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && this.i.getRsIgnoreCheckRule().size() > 0 && this.i.getRsIgnoreCheckRule().contains(0)) {
            o0.c("CampaignDownLoadTask", "Is not check video download status");
        } else {
            a(this.o, this.e);
        }
    }

    public void a(boolean z) {
        this.K = z;
    }

    public void a(int i, int i2) {
        this.e = i;
        if (this.u == null) {
            this.u = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        this.u.a(this.m, i2, i);
    }

    public void c(String str) {
        m();
        a(2, str, "");
        this.e = 4;
    }

    public void a(int i) {
        this.A = i;
    }

    public void a(String str) {
        int iC;
        if (TextUtils.isEmpty(str)) {
            this.h.a("VideoUrl is NULL, Please check it.", "");
            return;
        }
        if (this.e == 1) {
            o0.a("CampaignDownLoadTask", "Run : Task is RUNNING, Will return.");
            return;
        }
        if (this.e == 5 && Utils.getDownloadRate(this.l, this.o) >= this.s) {
            o0.a("CampaignDownLoadTask", "Run : Video Done, Will callback.");
            com.mbridge.msdk.videocommon.listener.a aVar = this.g;
            if (aVar != null) {
                aVar.a(this.m);
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a(this.m);
            }
            try {
                File file = new File(this.p);
                if (Objects.exists(file, this.n, this.w) && file.isFile()) {
                    file.setLastModified(System.currentTimeMillis());
                }
            } catch (Exception e) {
                o0.b("CampaignDownLoadTask", e.getMessage());
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(Reporting.EventType.CACHE, 1);
            a(this.i, eVar);
            return;
        }
        if (this.b == 3) {
            o0.a("CampaignDownLoadTask", "Run : Dlnet is 3, Will callback.");
            a(0L, false, "");
            com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar2.a(Reporting.EventType.CACHE, 1);
            a(this.i, eVar2);
            return;
        }
        try {
            iC = c(this.i);
        } catch (Exception unused) {
            iC = 100;
        }
        d(iC);
        if (iC == 0) {
            com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
            if (aVar3 != null) {
                aVar3.a(this.m);
            }
            com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
            if (aVar4 != null) {
                aVar4.a(this.m);
            }
        }
        DownloadMessage downloadMessage = new DownloadMessage(this.i, str, this.w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
        downloadMessage.setUseCronetDownload(a(this.i));
        downloadMessage.addExtra("resource_type", 4);
        this.x = a(downloadMessage, this.R, this.S, "1");
    }

    private int b(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.setting.l lVar = this.J;
            if (lVar != null) {
                return lVar.C();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("CampaignDownLoadTask", e.getMessage());
            }
        }
        return 100;
    }

    public void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.h = aVar;
    }

    public void b() {
        try {
            a();
            CampaignEx campaignEx = this.i;
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.cache.a aVarA = com.mbridge.msdk.videocommon.cache.a.a();
                if (aVarA != null) {
                    aVarA.a(this.i);
                }
            }
        } catch (Exception unused) {
            o0.b("CampaignDownLoadTask", "del file is failed");
        } finally {
            this.e = 0;
        }
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener, String str) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(this.D).withConnectTimeout(this.F).withWriteTimeout(this.E).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.n).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).withTimeout(60000L).with("do_us_fi_re", Boolean.toString(this.G)).with("download_scene", "download_video").with(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.s)).with("scenes", str).build();
    }

    public void a(long j, boolean z, String str) {
        m mVar;
        o0.b("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.o + "  progressSize " + j + "  " + this.y + "%   FileSize : " + this.l + "  " + this.i.getAppName());
        if (this.s == 100 && this.b != 3 && j != this.l && !z) {
            File file = new File(this.p);
            o0.b("CampaignDownLoadTask", "progressSize = " + j + " fileSize = " + this.l + " " + z + " absFileSize = " + (Objects.exists(file, this.n, this.w) ? file.length() : 0L));
            b("File size is not match witch download size.");
            return;
        }
        this.e = 5;
        if (j == this.l) {
            a(1, "", str);
        }
        long j2 = this.l;
        if (j2 != 0 && (mVar = this.u) != null) {
            mVar.b(this.m, j2);
        }
        this.f5959a = false;
        a(j, this.e);
    }

    public void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.g = aVar;
    }

    private void a(long j, int i) {
        this.o = j;
        int i2 = this.s;
        if (100 * j >= ((long) i2) * this.l && !this.t && i != 4) {
            if (i2 == 100 && i != 5) {
                this.e = 5;
                return;
            }
            this.t = true;
            o0.b("CampaignDownLoadTask", "UpdateListener : state: " + i + " progress : " + j);
            String strF = f();
            if (TextUtils.isEmpty(strF)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.g;
                if (aVar != null) {
                    aVar.a(this.m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.h;
                if (aVar2 != null) {
                    aVar2.a(this.m);
                }
            } else {
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.a("file is not effective " + strF, this.m);
                }
                com.mbridge.msdk.videocommon.listener.a aVar4 = this.h;
                if (aVar4 != null) {
                    aVar4.a("file is not effective " + strF, this.m);
                }
            }
        }
        if (!this.f5959a && j > 0) {
            this.f5959a = true;
            if (this.u == null) {
                this.u = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
            }
            this.u.a(this.m, j, this.e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            for (c cVar : copyOnWriteArrayList) {
                if (cVar != null) {
                    cVar.onProgress(j, i);
                }
            }
        }
    }

    private void a() {
        if (this.u == null) {
            this.u = m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        try {
            try {
                this.u.a(this.m);
                if (!q0.a().a("r_d_v_b_l", true)) {
                    File file = new File(this.p);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
                this.e = 0;
            } finally {
                this.e = 0;
            }
        } catch (Throwable unused) {
            o0.b("CampaignDownLoadTask", "del DB or file failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m(this.k, this.i, i, Long.toString(this.r != 0 ? System.currentTimeMillis() - this.r : 0L), this.l, this.A);
        mVar.b(this.i.getId());
        mVar.v(this.i.getVideoUrlEncode());
        mVar.m(str);
        mVar.n(this.i.getRequestId());
        mVar.k(this.i.getCurrentLocalRid());
        mVar.o(this.i.getRequestIdNotice());
        mVar.u(this.j);
        mVar.q(str2);
        mVar.b(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.s));
        mVar.b("url", this.i.getVideoUrlEncode());
        mVar.e(4);
        DownloadRequest downloadRequest = this.x;
        if (downloadRequest != null) {
            mVar.b("scenes", downloadRequest.get("scenes", ""));
            mVar.b("resumed_breakpoint", this.x.get("resumed_breakpoint", ""));
        }
        int i2 = this.A;
        if (i2 == 94 || i2 == 287) {
            return;
        }
        n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(mVar);
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                o0.b("CampaignDownLoadTask", th.getMessage());
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        if (this.P) {
            return;
        }
        try {
            this.P = true;
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            DownloadRequest downloadRequest = this.x;
            if (downloadRequest != null) {
                eVar.a("scenes", downloadRequest.get("scenes", ""));
                eVar.a("url", this.m);
                eVar.a("resumed_breakpoint", this.x.get("resumed_breakpoint", ""));
                eVar.a("h3c", "");
            }
            eVar.a("resource_type", 4);
            eVar.a("file_size", Long.valueOf(this.l));
            eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(this.s));
            eVar.a("result", Integer.valueOf(i));
            eVar.a("reason", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_end", this.i, eVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        if (this.O || campaignEx == null || eVar == null) {
            return;
        }
        this.O = true;
        try {
            eVar.a("resource_type", 4);
            DownloadRequest downloadRequest = this.x;
            if (downloadRequest != null) {
                eVar.a("scenes", downloadRequest.get("scenes", "1"));
                eVar.a("resumed_breakpoint", this.x.get("resumed_breakpoint", "2"));
            } else {
                eVar.a("scenes", "1");
                eVar.a("resumed_breakpoint", "1");
            }
            eVar.a("url", campaignEx.getVideoUrlEncode());
            eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(c(campaignEx)));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx, eVar);
        } catch (Exception e) {
            o0.b("CampaignDownLoadTask", e.getMessage());
        }
    }
}
