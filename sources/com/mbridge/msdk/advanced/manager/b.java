package com.mbridge.msdk.advanced.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.out.MBridgeIds;
import com.safedk.android.internal.partials.MintegralFilesBridge;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static String z = "NativeAdvancedLoadManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4682a;
    private String b;
    private long c;
    private com.mbridge.msdk.advanced.middle.b d;
    private MBNativeAdvancedView f;
    private com.mbridge.msdk.setting.l g;
    private List<CampaignEx> h;
    private CampaignEx i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private boolean p;
    private volatile boolean q;
    private com.mbridge.msdk.videocommon.listener.a r;
    private H5DownLoadManager.ZipDownloadListener s;
    private H5DownLoadManager.ZipDownloadListener t;
    private String u;
    private int v;
    private String w = "";
    private Handler x = new e(Looper.getMainLooper());
    private Runnable y = new f();
    private Context e = com.mbridge.msdk.foundation.controller.c.m().d();

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class a implements H5DownLoadManager.ZipDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4683a;
        final /* synthetic */ int b;

        a(CampaignEx campaignEx, int i) {
            this.f4683a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            o0.a(b.z, "zip 下载失败： " + str2 + " " + str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4683a);
            bundle.putString("msg", str);
            bundle.putInt("type", 3);
            messageObtain.obj = bundle;
            b.this.x.sendMessage(messageObtain);
            b.this.a(this.f4683a, str2, false, str);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            o0.a(b.z, "zip 下载成功： " + str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = this.f4683a;
            messageObtain.arg1 = this.b;
            b.this.x.sendMessage(messageObtain);
            if (z) {
                return;
            }
            b.this.a(this.f4683a, str, true, "");
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedWebview f4685a;
        final /* synthetic */ String b;

        c(MBNativeAdvancedWebview mBNativeAdvancedWebview, String str) {
            this.f4685a = mBNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MintegralNetworkBridge.webviewLoadUrl(this.f4685a, this.b);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            int i;
            Object obj;
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                Object obj2 = message.obj;
                int i3 = message.arg1;
                if (obj2 == null || !(obj2 instanceof CampaignEx)) {
                    return;
                }
                CampaignEx campaignEx = (CampaignEx) obj2;
                b.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i3);
                return;
            }
            if (i2 == 2) {
                Object obj3 = message.obj;
                try {
                    if (obj3 instanceof Bundle) {
                        int i4 = ((Bundle) obj3).getInt("type");
                        if (i4 == 1) {
                            i = 880004;
                        } else if (i4 == 2) {
                            i = 880007;
                        } else {
                            i = i4 == 3 ? 880006 : 880024;
                        }
                        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i);
                        String string = ((Bundle) obj3).getString("msg");
                        CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                        bVar.c(string);
                        bVar.a(campaignEx2);
                        b bVar2 = b.this;
                        bVar2.a(bVar, bVar2.n, b.this.o, campaignEx2);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    com.mbridge.msdk.foundation.error.b bVar3 = new com.mbridge.msdk.foundation.error.b(880000);
                    bVar3.a((Throwable) e);
                    b bVar4 = b.this;
                    bVar4.a(bVar3, bVar4.n, b.this.o, (CampaignEx) null);
                    return;
                }
            }
            if (i2 == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof CampaignEx)) {
                    return;
                }
                b bVar5 = b.this;
                bVar5.i((CampaignEx) obj4, bVar5.o);
                return;
            }
            if (i2 != 4) {
                if (i2 == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                    if (b.this.f != null) {
                        b.this.f.setVideoReady(true);
                    }
                    b bVar6 = b.this;
                    bVar6.i((CampaignEx) obj, bVar6.o);
                    return;
                }
                return;
            }
            Object obj5 = message.obj;
            if (obj5 == null || !(obj5 instanceof CampaignEx)) {
                return;
            }
            if (b.this.f != null) {
                b.this.f.setEndCardReady(true);
            }
            b bVar7 = b.this;
            bVar7.i((CampaignEx) obj5, bVar7.o);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880010);
            b bVar2 = b.this;
            bVar2.a(bVar, bVar2.n, b.this.o, (CampaignEx) null);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class g extends com.mbridge.msdk.advanced.request.b {
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Exception f4689a;
            final /* synthetic */ int b;
            final /* synthetic */ CampaignUnit c;

            a(Exception exc, int i, CampaignUnit campaignUnit) {
                this.f4689a = exc;
                this.b = i;
                this.c = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
                bVar.a((Throwable) this.f4689a);
                g gVar = g.this;
                b bVar2 = b.this;
                String str = gVar.e;
                int i = this.b;
                CampaignUnit campaignUnit = this.c;
                bVar2.a(bVar, str, i, (campaignUnit == null || campaignUnit.getAds() == null || this.c.getAds().size() == 0) ? null : this.c.getAds().get(0));
            }
        }

        /* JADX INFO: renamed from: com.mbridge.msdk.advanced.manager.b$g$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class RunnableC0417b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4690a;

            RunnableC0417b(String str) {
                this.f4690a = str;
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
                bVar.c(this.f4690a);
                g gVar = g.this;
                b.this.a(bVar, gVar.e, gVar.f, (CampaignEx) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, String str, int i2) {
            super(i);
            this.e = str;
            this.f = i2;
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void a(CampaignUnit campaignUnit, int i) throws Throwable {
            try {
                b bVar = b.this;
                bVar.a(campaignUnit, i, bVar.f4682a, this.e);
                b.this.w = campaignUnit.getRequestId();
                b.this.h = campaignUnit.getAds();
            } catch (Exception e) {
                o0.b(b.z, e.getMessage());
                o0.c(b.z, "onLoadCompaginSuccess 数据刚请求失败");
                if (b.this.x != null) {
                    b.this.x.post(new a(e, i, campaignUnit));
                }
                b.this.f();
            }
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void b(int i, String str) {
            o0.b(b.z, str);
            o0.c(b.z, "onLoadCompaginFailed load failed errorCode:" + i + " msg:" + str);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0417b(str));
            }
            b.this.f();
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class h extends com.mbridge.msdk.foundation.same.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4691a;

        h(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f4691a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.advanced.report.a.a(str, cVar, this.f4691a, b.this.e, null);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4692a;

        i(CampaignEx campaignEx) {
            this.f4692a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(b.this.e)).a();
            w.a(b.this.e, this.f4692a);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class j implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4693a;
        final /* synthetic */ int b;

        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f4693a, jVar.b);
            }
        }

        /* JADX INFO: renamed from: com.mbridge.msdk.advanced.manager.b$j$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class RunnableC0418b implements Runnable {
            RunnableC0418b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f4693a, jVar.b);
            }
        }

        j(CampaignEx campaignEx, int i) {
            this.f4693a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.a(b.z, "gifurl 下载失败： " + str2);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0418b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            o0.a(b.z, "giturl 下载成功： " + str);
            if (b.this.x != null) {
                b.this.x.post(new a());
            }
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class k implements H5DownLoadManager.ZipDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4696a;
        final /* synthetic */ int b;

        k(CampaignEx campaignEx, int i) {
            this.f4696a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            o0.a(b.z, "endcard 下载失败： " + str2);
            if (b.this.f != null) {
                b.this.f.setEndCardReady(false);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4696a);
            bundle.putString("msg", str);
            bundle.putInt("type", 2);
            messageObtain.obj = bundle;
            b.this.x.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            o0.a(b.z, "endcard 下载成功： " + str);
            if (b.this.x != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = this.f4696a;
                messageObtain.arg1 = this.b;
                b.this.x.sendMessage(messageObtain);
            }
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class l implements com.mbridge.msdk.foundation.same.image.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4697a;
        final /* synthetic */ int b;

        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f4697a, lVar.b);
            }
        }

        /* JADX INFO: renamed from: com.mbridge.msdk.advanced.manager.b$l$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
        class RunnableC0419b implements Runnable {
            RunnableC0419b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f4697a, lVar.b);
            }
        }

        l(CampaignEx campaignEx, int i) {
            this.f4697a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.a(b.z, "image 下载失败： " + str2);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0419b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            o0.a(b.z, "image 下载成功： " + str);
            if (b.this.x != null) {
                b.this.x.post(new a());
            }
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f4700a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ int c;

        m(File file, CampaignEx campaignEx, int i) {
            this.f4700a = file;
            this.b = campaignEx;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            b.this.a("file:////" + this.f4700a.getAbsolutePath(), this.b, this.c);
        }
    }

    public b(String str, String str2, long j2) {
        this.b = str;
        this.f4682a = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CampaignEx campaignEx, int i2) {
        if (!com.mbridge.msdk.advanced.manager.d.a(this.f, campaignEx, this.b, this.f4682a) || this.q) {
            return;
        }
        b();
        com.mbridge.msdk.advanced.manager.d.a(campaignEx, this.f4682a);
        this.q = true;
        com.mbridge.msdk.advanced.middle.b bVar = this.d;
        if (bVar != null) {
            bVar.a(campaignEx, i2);
        }
    }

    private void j(CampaignEx campaignEx, int i2) throws Throwable {
        this.i = campaignEx;
        if (com.mbridge.msdk.advanced.manager.d.a(this.f, campaignEx, this.b, this.f4682a)) {
            i(campaignEx, i2);
        } else {
            e(campaignEx, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.v = 0;
    }

    private void g() {
        try {
            int i2 = this.v + 1;
            this.v = i2;
            com.mbridge.msdk.setting.l lVar = this.g;
            if (lVar == null || i2 > lVar.y()) {
                o0.c(z, "onload 重置offset为0");
                this.v = 0;
            }
            o0.c(z, "onload 算出 下次的offset是:" + this.v);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CampaignEx campaignEx, int i2) {
        if (this.f.isH5Ready()) {
            i(campaignEx, i2);
            com.mbridge.msdk.advanced.report.a.a(1, "", this.f4682a, campaignEx);
        }
    }

    public String c() {
        return com.mbridge.msdk.foundation.same.c.b(this.h);
    }

    public String d() {
        return this.w;
    }

    public void e() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void c(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl(), new l(campaignEx, i2));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c6 A[Catch: Exception -> 0x011e, all -> 0x0139, TRY_ENTER, TryCatch #6 {Exception -> 0x011e, blocks: (B:40:0x00c6, B:42:0x00ca, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:50:0x00ee, B:51:0x00f7, B:27:0x00a5), top: B:86:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:89:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void d(CampaignEx campaignEx, int i2) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        FileOutputStream fileOutputStream;
        File file;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        File file2 = null;
        FileOutputStream fileOutputStream3 = null;
        FileOutputStream fileOutputStream4 = null;
        try {
            try {
                try {
                    try {
                        try {
                            com.mbridge.msdk.foundation.same.report.g.a("m_download_start", campaignEx, "", this.f4682a, "8");
                            File file3 = new File(campaignEx.getAdHtml());
                            try {
                                if (file3.exists()) {
                                    file = file3;
                                } else {
                                    String strB = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                                    String md5 = SameMD5.getMD5(z0.b(campaignEx.getAdHtml()));
                                    if (TextUtils.isEmpty(md5)) {
                                        md5 = String.valueOf(System.currentTimeMillis());
                                    }
                                    file = new File(strB, md5.concat(".html"));
                                    try {
                                        if (!file.exists()) {
                                            fileOutputStreamFileOutputStreamCtor = MintegralFilesBridge.fileOutputStreamCtor(file);
                                            try {
                                                StringBuilder sb = new StringBuilder("<script>");
                                                sb.append(com.mbridge.msdk.setting.util.a.a().b()).append("</script>");
                                                sb.append(campaignEx.getAdHtml());
                                                String strInjectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, sb.toString());
                                                if (campaignEx.isActiveOm()) {
                                                    strInjectScriptContentIntoHtml = com.mbridge.msdk.omsdk.b.a(strInjectScriptContentIntoHtml);
                                                }
                                                fileOutputStreamFileOutputStreamCtor.write(strInjectScriptContentIntoHtml.getBytes());
                                                fileOutputStreamFileOutputStreamCtor.flush();
                                                fileOutputStream4 = fileOutputStreamFileOutputStreamCtor;
                                            } catch (Exception e2) {
                                                e = e2;
                                                fileOutputStream4 = fileOutputStreamFileOutputStreamCtor;
                                                file3 = file;
                                                e.printStackTrace();
                                                campaignEx.setMraid("");
                                                com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f4682a, "8");
                                                if (fileOutputStream4 != null) {
                                                    fileOutputStream4.close();
                                                }
                                                file = file3;
                                            } catch (Throwable th) {
                                                th = th;
                                                if (fileOutputStreamFileOutputStreamCtor != null) {
                                                    try {
                                                        fileOutputStreamFileOutputStreamCtor.close();
                                                    } catch (Exception unused) {
                                                        fileOutputStream2 = fileOutputStreamFileOutputStreamCtor;
                                                        a(new com.mbridge.msdk.foundation.error.b(880013), this.n, i2, campaignEx);
                                                        if (fileOutputStream2 != null) {
                                                            fileOutputStream2.close();
                                                        }
                                                        return;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        fileOutputStream3 = fileOutputStreamFileOutputStreamCtor;
                                                        if (fileOutputStream3 != null) {
                                                            try {
                                                                fileOutputStream3.close();
                                                            } catch (IOException e3) {
                                                                o0.b(z, e3.getMessage());
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                }
                                try {
                                    com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, "", this.f4682a, "8");
                                    if (fileOutputStream4 != null) {
                                        fileOutputStream4.close();
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    fileOutputStream = fileOutputStream4;
                                    file2 = file;
                                    file3 = file2;
                                    fileOutputStream4 = fileOutputStream;
                                    e.printStackTrace();
                                    campaignEx.setMraid("");
                                    com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f4682a, "8");
                                    if (fileOutputStream4 != null) {
                                        fileOutputStream4.close();
                                    }
                                    file = file3;
                                }
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream3 != null) {
                                fileOutputStream3.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStreamFileOutputStreamCtor = fileOutputStream4;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream = null;
                }
                if (file.exists() && file.isFile() && file.canRead()) {
                    campaignEx.setAdHtml(file.getAbsolutePath());
                    o0.a(z, "开始渲染 HTML： ");
                    Handler handler = this.x;
                    if (handler != null) {
                        handler.post(new m(file, campaignEx, i2));
                    }
                } else {
                    o0.a(z, "渲染 HTML 失败： html file write failed");
                    com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880013);
                    a(bVar, this.n, i2, campaignEx);
                    a(bVar, this.n, i2, campaignEx);
                }
                if (fileOutputStream4 != null) {
                    fileOutputStream4.close();
                }
            } catch (IOException e8) {
                o0.b(z, e8.getMessage());
            }
        } catch (Exception unused2) {
        }
    }

    private void f(CampaignEx campaignEx, int i2) {
        this.r = new d(campaignEx);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.e, this.f4682a, copyOnWriteArrayList, 298, this.r);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(298, this.f4682a, campaignEx.isBidCampaign())) {
            o0.a(z, " load Video");
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f4682a);
        } else {
            o0.a(z, " load Video isReady true");
            this.f.setVideoReady(true);
            i(campaignEx, i2);
        }
    }

    public void b(String str, int i2) throws Throwable {
        CampaignEx campaignExA;
        List<Integer> listC;
        this.q = false;
        this.n = str;
        this.o = i2;
        this.i = null;
        if (this.f == null) {
            a(new com.mbridge.msdk.foundation.error.b(880030), str, i2, (CampaignEx) null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            campaignExA = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f4682a, str, this.j, false, false);
        } else {
            campaignExA = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f4682a, str, this.j, false, true);
        }
        long timestamp = campaignExA != null ? campaignExA.getTimestamp() : 0L;
        com.mbridge.msdk.setting.l lVar = this.g;
        if (lVar != null && lVar.t() == 1 && this.f != null && campaignExA != null) {
            j(campaignExA, i2);
            return;
        }
        this.p = false;
        com.mbridge.msdk.setting.l lVar2 = this.g;
        if (lVar2 != null && (listC = lVar2.c()) != null && listC.size() > 0) {
            this.c = listC.get(0).intValue() * 1000;
        } else {
            this.c = 30000L;
        }
        o0.a(z, "开始从V3请求新的 offer，超时 ：" + this.c);
        if (this.g == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.c);
            a(this.e, str, i2);
        } else if (System.currentTimeMillis() - timestamp > this.g.v() * 1000) {
            a(this.c);
            a(this.e, str, i2);
        } else {
            j(campaignExA, i2);
        }
    }

    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class d implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4686a;

        d(CampaignEx campaignEx) {
            this.f4686a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            o0.a(b.z, "Video 下载成功： " + str);
            Message messageObtain = Message.obtain();
            messageObtain.obj = this.f4686a;
            messageObtain.what = 5;
            b.this.x.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            o0.a(b.z, "Video 下载失败： " + str);
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4686a);
            bundle.putString("msg", str);
            bundle.putInt("type", 1);
            messageObtain.obj = bundle;
            messageObtain.what = 2;
            b.this.x.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.advanced.manager.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeAdvancedLoadManager.java */
    class C0416b extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4684a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        C0416b(CampaignEx campaignEx, int i, long j) {
            this.f4684a = campaignEx;
            this.b = i;
            this.c = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) throws Throwable {
            super.a(webView, i);
            o0.b("NativeAdvancedLoadManager", "=========readyState: " + i);
            if (i != 1) {
                b.this.a(this.f4684a, "readyState 2", this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4684a, b.this.f4682a, "readyState 2", this.c, 3);
            } else {
                b.this.f.setH5Ready(true);
                com.mbridge.msdk.advanced.common.c.a(b.this.b + b.this.f4682a + this.f4684a.getRequestId(), true);
                b.this.h(this.f4684a, this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4684a, b.this.f4682a, "", this.c, 1);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) throws Throwable {
            super.a(webView, i, str, str2);
            o0.b("NativeAdvancedLoadManager", "onReceivedError： " + i + "  " + str + "  " + str2);
            b.this.a(this.f4684a, str, this.b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4684a, b.this.f4682a, "error code:" + i + str, this.c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) throws Throwable {
            super.a(webView, sslErrorHandler, sslError);
            o0.b("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
            b.this.a(this.f4684a, "onReceivedSslError:" + sslError.getUrl(), this.b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4684a, b.this.f4682a, "error url:" + sslError.getUrl(), this.c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            o0.b("NativeAdvancedLoadManager", "onPageFinished");
            if (!this.f4684a.isHasMBTplMark()) {
                b.this.f.setH5Ready(true);
                o0.b("NativeAdvancedLoadManager", "=======onPageFinished OK");
                com.mbridge.msdk.advanced.common.c.a(b.this.b + b.this.f4682a + this.f4684a.getRequestId(), true);
                b.this.h(this.f4684a, this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4684a, b.this.f4682a, "", this.c, 1);
            }
            com.mbridge.msdk.advanced.signal.a.a(webView);
        }
    }

    private void g(CampaignEx campaignEx, int i2) {
        String adZip;
        this.s = new a(campaignEx, i2);
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        int i3 = 0;
        if (campaignEx == null) {
            adZip = "";
        } else {
            i3 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            adZip = campaignEx.getAdZip();
        }
        cVar.f(i3);
        cVar.e(2);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, adZip, this.s);
    }

    public void a(com.mbridge.msdk.setting.l lVar) {
        this.g = lVar;
    }

    private void e(CampaignEx campaignEx, int i2) throws Throwable {
        MBNativeAdvancedView mBNativeAdvancedView = this.f;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            o0.a(z, "开始下载zip： " + campaignEx.getAdZip());
            g(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            o0.a(z, "开始下载HTML： " + campaignEx.getAdHtml());
            d(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            o0.a(z, "开始下载Video： " + campaignEx.getVideoUrlEncode());
            f(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            o0.a(z, "开始下载image： " + campaignEx.getImageUrl());
            c(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            o0.a(z, "开始下载EndCard： " + campaignEx.getendcard_url());
            a(campaignEx, i2);
        }
        if (TextUtils.isEmpty(campaignEx.getGifUrl())) {
            return;
        }
        o0.a(z, "开始下载gitUrl： " + campaignEx.getGifUrl());
        b(campaignEx, i2);
    }

    public void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.f = mBNativeAdvancedView;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void a(int i2, int i3) {
        this.m = i2;
        this.l = i3;
    }

    private void a(long j2) {
        this.x.postDelayed(this.y, j2);
    }

    private void a(Context context, String str, int i2) throws Throwable {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.error.b(880025), str, i2, (CampaignEx) null);
                return;
            }
            if (y0.a(this.f4682a)) {
                a(new com.mbridge.msdk.foundation.error.b(880032), str, i2, (CampaignEx) null);
                return;
            }
            try {
                com.mbridge.msdk.advanced.manager.d.b(this.f4682a);
            } catch (Throwable th) {
                o0.b(z, th.getMessage());
            }
            o0.c(z, "load 开始准备请求参数");
            MBridgeIds mBridgeIds = new MBridgeIds(this.b, this.f4682a);
            com.mbridge.msdk.advanced.request.f fVar = new com.mbridge.msdk.advanced.request.f();
            fVar.d(i2);
            fVar.c(this.v);
            fVar.a(this.u);
            fVar.b(this.m);
            fVar.a(this.l);
            com.mbridge.msdk.foundation.same.net.wrapper.e eVarB = com.mbridge.msdk.advanced.request.e.b(context, mBridgeIds, fVar);
            if (eVarB == null) {
                o0.c(z, "load 请求参数为空 load失败");
                a(new com.mbridge.msdk.foundation.error.b(880001), str, i2, (CampaignEx) null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                eVarB.a("token", str);
            }
            String strD = t0.d(this.f4682a);
            if (!TextUtils.isEmpty(strD)) {
                eVarB.a("j", strD);
            }
            new com.mbridge.msdk.advanced.request.c(context).choiceV3OrV5BySetting(1, eVarB, a(str, i2), str, com.mbridge.msdk.foundation.same.c.a(this.c, 30000L));
        } catch (Exception e2) {
            o0.b(z, e2.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880020);
            bVar.a((Throwable) e2);
            a(bVar, str, i2, (CampaignEx) null);
            f();
        }
    }

    private void b() {
        this.x.removeCallbacks(this.y);
    }

    private void b(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getGifUrl(), new j(campaignEx, i2));
    }

    private com.mbridge.msdk.advanced.request.b a(String str, int i2) {
        g gVar = new g(i2, str, i2);
        gVar.a(str);
        gVar.setUnitId(this.f4682a);
        gVar.setPlacementId(this.b);
        gVar.setAdType(298);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit, int i2, String str, String str2) throws Throwable {
        List<CampaignEx> listA = a(campaignUnit);
        if (listA != null && listA.size() > 0) {
            g();
            o0.c(z, "onload load成功 size:" + listA.size());
            CampaignEx campaignEx = listA.get(0);
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && (TextUtils.isEmpty(campaignEx.getAdHtml()) || !campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
                campaignEx.setHasMBTplMark(false);
                campaignEx.setIsMraid(true);
            } else {
                campaignEx.setHasMBTplMark(true);
                campaignEx.setIsMraid(false);
            }
            j(campaignEx, i2);
            return;
        }
        o0.c(z, "onload load失败 返回的compaign没有可以用的");
        a(new com.mbridge.msdk.foundation.error.b(880033), str2, i2, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
    }

    private List<CampaignEx> a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = campaignUnit.getAds().get(0);
        campaignEx.setCampaignUnitId(this.f4682a);
        a(campaignEx);
        this.u = campaignUnit.getSessionId();
        if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
            if (t0.c(campaignEx)) {
                campaignEx.setRtinsType(t0.c(this.e, campaignEx.getPackageName()) ? 1 : 2);
            }
            if (com.mbridge.msdk.foundation.same.c.b(this.e, campaignEx)) {
                arrayList.add(campaignEx);
            } else {
                t0.a(this.f4682a, campaignEx, com.mbridge.msdk.foundation.same.a.x);
            }
            a(campaignEx, (com.mbridge.msdk.foundation.same.report.metrics.c) null, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.e, cVar, new h(campaignEx, aVar));
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new i(campaignEx)).start();
    }

    public void a(com.mbridge.msdk.advanced.middle.b bVar) {
        this.d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, String str, int i2, CampaignEx campaignEx) throws Throwable {
        if (this.p) {
            this.p = false;
            a(bVar, i2, str);
        } else {
            if (bVar != null) {
                bVar.a(campaignEx);
            }
            a(bVar, i2, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, String str) throws Throwable {
        CampaignEx campaignExA = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f4682a, str, this.j, true, true);
        if (campaignExA != null) {
            o0.b(z, "load failed cache ");
            j(campaignExA, i2);
        } else {
            a(bVar, i2, campaignExA);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, CampaignEx campaignEx) {
        if (this.q) {
            return;
        }
        b();
        if (bVar != null) {
            o0.b(z, "real failed: " + bVar.g());
        }
        this.q = true;
        com.mbridge.msdk.advanced.middle.b bVar2 = this.d;
        if (bVar2 != null) {
            bVar2.a(bVar, i2);
        }
    }

    private void a(CampaignEx campaignEx, int i2) {
        String str;
        this.t = new k(campaignEx, i2);
        int i3 = 0;
        if (campaignEx == null) {
            str = "";
        } else {
            i3 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getendcard_url();
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        cVar.f(i3);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, str, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx, int i2) throws Throwable {
        MBNativeAdvancedView mBNativeAdvancedView = this.f;
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.report.a.b(this.f4682a, campaignEx);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(this.f.getContext(), this.b, this.f4682a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(this.j);
        bVar.b(this.k);
        this.f.setAdvancedNativeSignalCommunicationImpl(bVar);
        long jCurrentTimeMillis = System.currentTimeMillis();
        MBNativeAdvancedWebview advancedNativeWebview = this.f.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            a(campaignEx, "webview is null", i2);
            return;
        }
        if (advancedNativeWebview.isDestoryed()) {
            a(campaignEx, "webview is destroyed", i2);
            return;
        }
        advancedNativeWebview.setWebViewListener(new C0416b(campaignEx, i2, jCurrentTimeMillis));
        if (!advancedNativeWebview.isDestoryed()) {
            o0.b(z, "=======开始渲染: " + str);
            Handler handler = this.x;
            if (handler != null) {
                handler.post(new c(advancedNativeWebview, str));
                return;
            }
            return;
        }
        a(new com.mbridge.msdk.foundation.error.b(880031), this.n, i2, campaignEx);
        com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, this.f4682a, "webview had destory", jCurrentTimeMillis, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i2) throws Throwable {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880009);
        bVar.c(str);
        a(bVar, this.n, i2, campaignEx);
        com.mbridge.msdk.advanced.report.a.a(2, str, this.f4682a, campaignEx);
    }

    public String a(String str) {
        int iJ;
        if (this.i != null) {
            try {
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f4682a, this.i.getId() + this.i.getVideoUrlEncode() + this.i.getBidToken());
                if (aVarA == null || (iJ = aVarA.j()) != 5) {
                    return str;
                }
                String strK = aVarA.k();
                if (!new File(strK).exists()) {
                    return str;
                }
                o0.b(z, "本地已下载完 拿本地播放地址：" + strK + " state：" + iJ);
                return strK;
            } catch (Exception e2) {
                o0.b(z, e2.getMessage());
                return str;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, boolean z2, String str2) {
        try {
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            mVar.e(2);
            mVar.j("m_download_end");
            if (campaignEx != null) {
                mVar.b(campaignEx.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                mVar.o(campaignEx.getRequestIdNotice());
            }
            mVar.b("url", str);
            mVar.b("scenes", "1");
            if (z2) {
                mVar.d(1);
            } else {
                mVar.d(3);
                mVar.m(str2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, campaignEx);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                o0.b(z, e2.getMessage());
            }
        }
    }
}
