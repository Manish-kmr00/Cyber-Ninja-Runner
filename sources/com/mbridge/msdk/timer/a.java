package com.mbridge.msdk.timer;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: LoopTimer.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5607a;
    private boolean b;
    private LinkedList<i> c;
    private LinkedList<i> d;
    private int e;
    private int f;
    private e g;
    private com.mbridge.msdk.videocommon.setting.a h;
    private l i;
    private g j;
    private Handler k;

    /* JADX INFO: renamed from: com.mbridge.msdk.timer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoopTimer.java */
    class HandlerC0502a extends Handler {
        HandlerC0502a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (a.this) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        a.this.c();
                    }
                } else {
                    if (a.this.b) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.a(aVar.f5607a);
                    sendMessageDelayed(obtainMessage(1), a.this.f5607a);
                }
            }
        }
    }

    /* JADX INFO: compiled from: LoopTimer.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f5610a = new a(null);
    }

    /* synthetic */ a(HandlerC0502a handlerC0502a) {
        this();
    }

    /* JADX INFO: compiled from: LoopTimer.java */
    class b implements com.mbridge.msdk.reward.adapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f5609a;

        b(com.mbridge.msdk.reward.adapter.c cVar) {
            this.f5609a = cVar;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.k.sendMessage(a.this.k.obtainMessage(2));
            this.f5609a.a((com.mbridge.msdk.reward.adapter.a) null);
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.k.sendMessage(a.this.k.obtainMessage(2));
            this.f5609a.a((com.mbridge.msdk.reward.adapter.a) null);
        }
    }

    private a() {
        this.b = false;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.k = new HandlerC0502a();
    }

    private void b() {
        if (this.j == null) {
            this.j = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        if (this.i == null) {
            this.i = l.a(this.j);
        }
        List<i> listA = this.i.a(287);
        if (listA != null) {
            this.d.addAll(listA);
            for (i iVar : listA) {
                a(iVar.a(), iVar.b());
            }
        }
        List<i> listA2 = this.i.a(94);
        if (listA2 != null) {
            this.c.addAll(listA2);
            for (i iVar2 : listA2) {
                b(iVar2.a(), iVar2.b());
            }
        }
        if (this.g == null) {
            this.g = e.a(this.j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.setting.b.b().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            LinkedList<i> linkedList = this.c;
            if (linkedList == null || linkedList.size() <= 0 || this.e >= this.c.size()) {
                LinkedList<i> linkedList2 = this.d;
                if (linkedList2 != null && linkedList2.size() > 0 && this.f < this.d.size()) {
                    i iVar = this.d.get(this.f);
                    this.f++;
                    if (a(iVar)) {
                        c(iVar.a(), iVar.b());
                    }
                }
            } else {
                i iVar2 = this.c.get(this.e);
                this.e++;
                if (a(iVar2)) {
                    a(iVar2.a(), iVar2.b(), false);
                }
            }
        } catch (Throwable th) {
            o0.b("LoopTimer", th.getMessage(), th);
        }
    }

    public static a a() {
        return c.f5610a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        LinkedList<i> linkedList = this.c;
        if (linkedList == null || linkedList.size() <= 0 || this.e == 0 || this.c.size() <= this.e) {
            LinkedList<i> linkedList2 = this.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || this.f == 0 || this.d.size() == this.f) {
                this.f = 0;
                this.e = 0;
                Handler handler = this.k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    private boolean a(i iVar) {
        boolean z = false;
        if (iVar == null || TextUtils.isEmpty(iVar.b())) {
            return false;
        }
        String strB = iVar.b();
        try {
            if (this.g != null) {
                com.mbridge.msdk.videocommon.setting.a aVar = this.h;
                int iA = this.g.a(strB, aVar != null ? aVar.e() : 0L);
                if (iA == -1) {
                    a(strB);
                } else if (iA != 1) {
                }
                try {
                    Handler handler = this.k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    o0.b("LoopTimer", th.getMessage(), th);
                    return z;
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    private void c(String str, String str2) {
        a(str, str2, true);
    }

    public void b(long j) {
        b();
        this.f5607a = j;
        this.b = false;
        Handler handler = this.k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f5607a);
    }

    public void b(String str, String str2) {
        if (this.c.contains(str2)) {
            return;
        }
        this.c.add(new i(str, str2, 94));
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str, str2, 94);
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (contextD == null) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(contextD, str, str2);
            cVar.d(z);
            cVar.a(new b(cVar));
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar2.h(SameMD5.getMD5(t0.d()));
            cVar2.m(str2);
            if (z) {
                cVar2.a(287);
            } else {
                cVar2.a(94);
            }
            cVar2.g("0");
            cVar2.e("1");
            cVar.a(1, 8000, false, cVar2);
        } catch (Exception e) {
            o0.b("LoopTimer", e.getMessage(), e);
        }
    }

    private void b(String str) {
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str);
        }
    }

    public void a(String str, String str2) {
        if (this.d.contains(str2)) {
            return;
        }
        this.d.add(new i(str, str2, 287));
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str, str2, 287);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedList<i> linkedList = this.c;
        if (linkedList != null && linkedList.contains(str)) {
            this.c.remove(str);
        } else {
            LinkedList<i> linkedList2 = this.d;
            if (linkedList2 != null && linkedList2.contains(str)) {
                this.d.remove(str);
            }
        }
        b(str);
    }
}
