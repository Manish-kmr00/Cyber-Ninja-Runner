package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.s0;
import java.net.URI;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: WebViewSpiderLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends f implements com.mbridge.msdk.foundation.same.task.a.InterfaceC0441a {
    private g b;
    private JumpLoaderResult c;
    private boolean e;
    private Context f;
    private com.mbridge.msdk.foundation.same.task.b g;
    private com.mbridge.msdk.click.entity.a h;
    private boolean d = true;
    private Handler i = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: WebViewSpiderLoader.java */
    class a implements k {
        a() {
        }

        @Override // com.mbridge.msdk.click.k
        public void a(JumpLoaderResult jumpLoaderResult) {
            p.this.c = jumpLoaderResult;
        }
    }

    /* JADX INFO: compiled from: WebViewSpiderLoader.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.b != null) {
                if (p.this.c.isSuccess()) {
                    p.this.b.a(p.this.c);
                } else {
                    p.this.b.a(p.this.c, p.this.c.getMsg());
                }
            }
        }
    }

    /* JADX INFO: compiled from: WebViewSpiderLoader.java */
    private class c extends com.mbridge.msdk.foundation.same.task.a {
        private final Context b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;
        private boolean g;
        private boolean h;
        private int i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Semaphore f4750a = new Semaphore(0);
        private o.f j = new a();

        public c(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z, boolean z2, int i) {
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = z;
            this.h = z2;
            this.i = i;
        }

        private boolean a(int i) {
            return i == 200;
        }

        private boolean b(int i) {
            return i == 301 || i == 302 || i == 307;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        private boolean c(String str) {
            return str.startsWith(RemoteSettings.FORWARD_SLASH_STRING);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d(String str) {
            return q.a(str, this.f, p.this.c);
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void pauseTask(boolean z) {
        }

        @Override // com.mbridge.msdk.foundation.same.task.a
        public void runTask() {
            if (p.this.b != null) {
                p.this.b.b(null);
            }
            p.this.c = new JumpLoaderResult();
            p.this.c.setUrl(this.c);
            p.this.c = a(this.c, this.g, this.h, this.f, this.i);
            if (!TextUtils.isEmpty(p.this.c.getExceptionMsg())) {
                p.this.c.setSuccess(true);
            }
            if (p.this.d && p.this.c.isSuccess()) {
                if (p.this.h != null) {
                    p.this.c.setStatusCode(p.this.h.f);
                }
                q.a(this.f, p.this.c, p.this.h, this.d, this.e, this.b, this.j, this.f4750a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f4750a.release();
        }

        private JumpLoaderResult a(String str, boolean z, boolean z2, CampaignEx campaignEx, int i) {
            String scheme;
            String str2;
            String strA = str;
            String host = "";
            if (p.this.e) {
                String strA2 = com.mbridge.msdk.setting.b.a(this.b, strA);
                if (!TextUtils.isEmpty(strA2)) {
                    strA = strA + strA2;
                }
            }
            if (com.mbridge.msdk.util.b.a()) {
                strA = q.a(this.f, strA);
            }
            String str3 = strA;
            JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
            i iVar = new i();
            try {
                if (b(str3)) {
                    str2 = "";
                } else {
                    URI uriCreate = URI.create(str3);
                    scheme = uriCreate.getScheme();
                    try {
                        host = uriCreate.getHost();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                    str2 = host;
                    host = scheme;
                }
            } catch (Exception e2) {
                e = e2;
                scheme = "";
            }
            String strA3 = str3;
            String scheme2 = host;
            String host2 = str2;
            for (int i2 = 0; i2 < 10; i2++) {
                if (!p.this.d) {
                    return null;
                }
                p.this.h = iVar.a(strA3, z, z2, campaignEx);
                if (p.this.h != null) {
                    if (!TextUtils.isEmpty(p.this.h.h)) {
                        jumpLoaderResult.setUrl(strA3);
                        jumpLoaderResult.setExceptionMsg(p.this.h.h);
                        jumpLoaderResult.setType(1);
                        jumpLoaderResult.setHeader(p.this.h.a());
                        jumpLoaderResult.setSuccess(false);
                        if (i2 != 0) {
                            break;
                        }
                        com.mbridge.msdk.click.retry.a.b().a(strA3, p.this.h.h, campaignEx, this.e, z, z2, i);
                        break;
                    }
                    jumpLoaderResult.setSuccess(true);
                    if (!b(p.this.h.f)) {
                        if (a(p.this.h.f)) {
                            jumpLoaderResult.setjumpDone(true);
                            jumpLoaderResult.setUrl(strA3);
                            jumpLoaderResult.setContent(p.this.h.g);
                            break;
                        }
                        jumpLoaderResult.setjumpDone(false);
                        jumpLoaderResult.setUrl(strA3);
                        if (i2 != 0) {
                            break;
                        }
                        com.mbridge.msdk.click.retry.a.b().a(strA3, "error code:" + p.this.h.f, campaignEx, this.e, z, z2, i);
                        break;
                    }
                    jumpLoaderResult.setIs302Jump(true);
                    if (!TextUtils.isEmpty(p.this.h.f4734a)) {
                        strA3 = p.this.h.f4734a;
                        if (b(strA3)) {
                            if (c(strA3) && !TextUtils.isEmpty(scheme2) && !TextUtils.isEmpty(host2)) {
                                strA3 = scheme2 + "://" + host2 + strA3;
                                host2 = null;
                                scheme2 = null;
                            } else {
                                jumpLoaderResult.setjumpDone(true);
                                jumpLoaderResult.setUrl(strA3);
                                break;
                            }
                        } else if (!b(strA3)) {
                            try {
                                URI uriCreate2 = URI.create(strA3);
                                scheme2 = uriCreate2.getScheme();
                                host2 = uriCreate2.getHost();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (!a(strA3)) {
                            if (p.this.e) {
                                String strA4 = com.mbridge.msdk.setting.b.a(this.b, strA3);
                                if (!TextUtils.isEmpty(strA4)) {
                                    strA3 = strA3 + strA4;
                                }
                            }
                            if (com.mbridge.msdk.util.b.a()) {
                                strA3 = q.a(this.f, strA3);
                            }
                        } else {
                            jumpLoaderResult.setjumpDone(true);
                            jumpLoaderResult.setUrl(strA3);
                            break;
                        }
                    } else {
                        jumpLoaderResult.setjumpDone(true);
                        jumpLoaderResult.setUrl(strA3);
                        break;
                    }
                } else {
                    jumpLoaderResult.setUrl(strA3);
                    jumpLoaderResult.setSuccess(false);
                    jumpLoaderResult.setMsg("request url is invalided");
                    break;
                }
            }
            return jumpLoaderResult;
        }

        /* JADX INFO: compiled from: WebViewSpiderLoader.java */
        class a implements o.f {
            a() {
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean a(String str) {
                boolean zD = c.this.d(str);
                if (zD) {
                    a();
                }
                return zD;
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean b(String str) {
                return false;
            }

            @Override // com.mbridge.msdk.click.o.f
            public boolean c(String str) {
                boolean zD = c.this.d(str);
                if (zD) {
                    a();
                }
                return zD;
            }

            @Override // com.mbridge.msdk.click.o.f
            public void a(String str, boolean z, String str2) {
                c.this.d(str);
                p.this.c.setContent(str2);
                a();
            }

            @Override // com.mbridge.msdk.click.o.f
            public void a(int i, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    p.this.c.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    p.this.c.setContent(str3);
                }
                c.this.d(str);
                a();
            }

            private void a() {
                synchronized (p.this) {
                    p.this.c.setSuccess(true);
                    c.this.a();
                }
            }
        }

        private boolean a(String str) {
            return s0.a.b(str);
        }
    }

    public p(Context context) {
        this.f = context;
        this.g = new com.mbridge.msdk.foundation.same.task.b(context, 2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(String str, g gVar, boolean z, String str2, String str3, CampaignEx campaignEx, boolean z2, boolean z3, int i) {
        com.mbridge.msdk.foundation.same.task.a cVar;
        this.b = gVar;
        this.e = z;
        com.mbridge.msdk.click.entity.b bVar = new com.mbridge.msdk.click.entity.b();
        bVar.a(this.f);
        bVar.c(str);
        bVar.b(z);
        bVar.a(str2);
        bVar.b(str3);
        bVar.a(campaignEx);
        bVar.a(z2);
        bVar.c(z3);
        bVar.a(i);
        if (str.startsWith("tcp")) {
            l lVar = new l(bVar);
            lVar.a(this.b);
            lVar.a(new a());
            cVar = lVar;
        } else {
            cVar = new c(this.f, str, str2, str3, campaignEx, z2, z3, i);
        }
        this.g.b(cVar, this);
    }

    @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0441a
    public void a(com.mbridge.msdk.foundation.same.task.a.b bVar) {
        if (bVar == com.mbridge.msdk.foundation.same.task.a.b.FINISH && this.d) {
            this.i.post(new b());
        }
    }
}
