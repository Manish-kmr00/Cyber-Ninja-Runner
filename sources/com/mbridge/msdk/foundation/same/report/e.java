package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.json.b9;
import com.json.cc;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.tracker.p;
import com.mbridge.msdk.tracker.x;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBRevenueBatchReportManager.java */
/* JADX INFO: loaded from: classes11.dex */
public final class e {
    private static final String l = "e";
    private static String m = "roas";
    private static volatile e n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f5012a;
    private BatchReportDao b;
    private int c = 1;
    private long d = 0;
    private String e = com.mbridge.msdk.foundation.same.net.utils.d.h().O;
    private volatile int f = 0;
    private boolean g = false;
    private Executor h = Executors.newSingleThreadExecutor();
    private Handler i;
    private Stack<Long> j;
    private com.mbridge.msdk.tracker.m k;

    /* JADX INFO: compiled from: MBRevenueBatchReportManager.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Bundle data = message.getData();
                if (e.this.i == null || e.this.b == null || data == null) {
                    return;
                }
                e.this.i.removeMessages(2);
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList<BatchReportMessage> batchReportMessages = e.this.b.getBatchReportMessages(jCurrentTimeMillis, 2);
                e.this.b(batchReportMessages, jCurrentTimeMillis);
                e.this.f5012a.set(0);
                o0.a(e.l, "超时上报触发了，需要上报的数据： " + (batchReportMessages != null ? batchReportMessages.size() : 0));
                return;
            }
            if (i == 2) {
                Bundle data2 = message.getData();
                if (e.this.i == null || e.this.b == null || data2 == null) {
                    return;
                }
                e.this.i.removeMessages(1);
                long j = data2.getLong("last_report_time");
                ArrayList<BatchReportMessage> batchReportMessages2 = e.this.b.getBatchReportMessages(j, 2);
                e.this.b(batchReportMessages2, j);
                o0.a(e.l, "队列上报触发了，需要上报的数据： " + (batchReportMessages2 != null ? batchReportMessages2.size() : 0));
                return;
            }
            if (i == 3) {
                Bundle data3 = message.getData();
                if (data3 != null) {
                    e.this.a((ArrayList<BatchReportMessage>) data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                    return;
                }
                return;
            }
            if (i != 4) {
                return;
            }
            Bundle data4 = message.getData();
            if (e.this.i == null || e.this.b == null || data4 == null || !e.this.g) {
                return;
            }
            e.this.i.removeMessages(4);
            ArrayList<BatchReportMessage> batchReportMessages3 = e.this.b.getBatchReportMessages(System.currentTimeMillis(), 2);
            if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                for (int i2 = 0; i2 < batchReportMessages3.size(); i2++) {
                    BatchReportMessage batchReportMessage = batchReportMessages3.get(i2);
                    e.this.a(batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                }
            }
            o0.a(e.l, "切换上报lib，需要上报的数据： " + (batchReportMessages3 != null ? batchReportMessages3.size() : 0));
        }
    }

    /* JADX INFO: compiled from: MBRevenueBatchReportManager.java */
    class b extends com.mbridge.msdk.foundation.same.report.net.b {
        final /* synthetic */ long b;
        final /* synthetic */ ArrayList c;

        b(long j, ArrayList arrayList) {
            this.b = j;
            this.c = arrayList;
        }

        @Override // com.mbridge.msdk.foundation.same.report.net.b
        public void a(String str) {
            Stack stack;
            o0.a(e.l, "批量上报失败： " + str);
            e.this.a(2, str);
            synchronized (e.this.j) {
                e.this.j.add(Long.valueOf(this.b));
                if (e.this.b != null) {
                    e.this.b.updateMessagesReportState(this.c);
                }
                if (e.this.j.size() >= 5) {
                    o0.a(e.l, "批量上报失败，上报失败的数据超过阈值");
                    try {
                        try {
                            e.this.j.pop();
                            long jLongValue = ((Long) e.this.j.pop()).longValue();
                            e.this.j.clear();
                            if (e.this.b != null) {
                                e.this.b.deleteBatchReportMessagesByTimestamp(jLongValue);
                            }
                            stack = e.this.j;
                        } catch (Exception e) {
                            o0.b(e.l, e.getMessage());
                            stack = e.this.j;
                        }
                        stack.clear();
                    } catch (Throwable th) {
                        e.this.j.clear();
                        throw th;
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.same.report.net.b
        public void b(String str) {
            o0.a(e.l, "批量上报成功");
            e.this.a(1, "");
            try {
                if (e.this.b != null) {
                    e.this.b.deleteBatchReportMessagesByTimestamp(this.b);
                }
            } catch (Exception e) {
                o0.b(e.l, e.getMessage());
            }
            synchronized (e.this.j) {
                e.this.j.clear();
            }
        }
    }

    /* JADX INFO: compiled from: MBRevenueBatchReportManager.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5014a;

        c(String str) {
            this.f5014a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b == null) {
                return;
            }
            o0.a(e.l, "接收到上报数据： " + this.f5014a);
            if (!e.this.g) {
                if (e.this.f != 1) {
                    e.this.c(this.f5014a);
                }
            } else {
                e.this.a(this.f5014a, 0L);
                if (((Integer) w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "roas_use_event", 0)).intValue() == 0) {
                    w0.b(com.mbridge.msdk.foundation.controller.c.m().d(), "roas_use_event", 1);
                    e.this.i.sendEmptyMessage(4);
                }
            }
        }
    }

    private e() {
        d();
    }

    public static synchronized e c() {
        if (n == null) {
            n = new e();
        }
        return n;
    }

    private void d() {
        com.mbridge.msdk.setting.a aVarJ;
        com.mbridge.msdk.setting.g gVarD = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (gVarD != null && (aVarJ = gVarD.j()) != null) {
            this.c = aVarJ.a();
            this.d = ((long) aVarJ.c()) * 1000;
            this.e = com.mbridge.msdk.foundation.same.net.utils.d.h().O;
            this.f = aVarJ.b();
            boolean z = aVarJ.d() == 1;
            this.g = z;
            if (z && this.f != 1) {
                int iB = q0.a().b("bcp", "type", q0.a().b("t_r_t", 1));
                if (iB != 0 && iB != 1) {
                    iB = 0;
                }
                this.k = com.mbridge.msdk.tracker.m.a(m, com.mbridge.msdk.foundation.controller.c.m().d(), new x.b().a(new d()).a(new n()).a(iB, a(iB)).a(q0.a().b("t_m_e_t", 604800000)).b(q0.a().b("t_m_e_s", 50)).d(q0.a().b("t_m_r_c", 50)).c(q0.a().b("t_m_t", 15000)).e(q0.a().b("t_m_r_t_s", 1)).a());
                JSONObject jSONObjectB = com.mbridge.msdk.foundation.same.report.c.b();
                try {
                    jSONObjectB.put(CommonUrlParts.DEVICE_TYPE, k0.E(com.mbridge.msdk.foundation.controller.c.m().d()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        jSONObjectB.put(com.mbridge.msdk.foundation.same.net.wrapper.e.j, k0.u());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.k.a(jSONObjectB);
                this.k.h();
            }
        }
        o0.a(l, "初始化批量上报： " + this.e + " " + this.c + " " + this.d + " " + this.f);
        this.f5012a = new AtomicInteger(0);
        this.j = new Stack<>();
        this.b = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.c.m().d());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.i = new a(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<BatchReportMessage> arrayList, long j) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j);
        messageObtain.setData(bundle);
        messageObtain.what = 3;
        this.i.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.b.addReportMessage(str, 2);
        Handler handler = this.i;
        if (handler != null && !handler.hasMessages(1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.i.sendMessageDelayed(messageObtain, this.d);
        }
        if (this.f5012a.incrementAndGet() < this.c || this.i == null) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("last_report_time", System.currentTimeMillis());
        messageObtain2.setData(bundle);
        messageObtain2.what = 2;
        this.i.sendMessage(messageObtain2);
        this.f5012a.set(0);
    }

    private p a(int i) {
        if (i == 1) {
            return new p(new m((byte) 2), com.mbridge.msdk.foundation.same.net.utils.d.h().l, com.mbridge.msdk.foundation.same.net.utils.d.h().p);
        }
        return new p(new com.mbridge.msdk.tracker.network.toolbox.h(), com.mbridge.msdk.foundation.same.net.utils.d.h().O, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<BatchReportMessage> arrayList, long j) {
        if (arrayList != null && arrayList.size() > 0) {
            o0.a(l, "需要上报的数据条数： " + arrayList.size());
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (contextD == null) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.wrapper.e eVarA = j.a(contextD);
            eVarA.a("app_id", com.mbridge.msdk.foundation.controller.c.m().b());
            eVarA.a("m_sdk", "msdk");
            eVarA.a("lqswt", String.valueOf(1));
            eVarA.a(CommonUrlParts.DEVICE_TYPE, k0.E(contextD) ? "pad" : "phone");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
                eVarA.a(com.mbridge.msdk.foundation.same.net.wrapper.e.j, k0.u());
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    BatchReportMessage batchReportMessage = arrayList.get(i);
                    if (batchReportMessage != null) {
                        sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                        if (i >= 0 && i < size - 1) {
                            sb.append("\n");
                        }
                    }
                } catch (Throwable th) {
                    o0.b(l, th.getMessage());
                }
            }
            try {
                String strEncode = URLEncoder.encode(sb.toString(), cc.N);
                eVarA.a("data", strEncode);
                o0.a(l, "需要批量上报的数据： " + strEncode);
                com.mbridge.msdk.foundation.same.report.net.a aVar = new com.mbridge.msdk.foundation.same.report.net.a(com.mbridge.msdk.foundation.controller.c.m().d());
                a(0, "");
                aVar.post(0, this.e, eVarA, new b(j, arrayList), "roas", 60000L);
                return;
            } catch (Exception e) {
                o0.b(l, e.getMessage());
                return;
            }
        }
        o0.a(l, "需要上报的数据条数： 0");
    }

    public void b() {
        Handler handler = this.i;
        if (handler == null || handler.hasMessages(1) || this.f == 1 || this.g) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        this.i.sendMessageDelayed(messageObtain, 5000L);
    }

    public synchronized void b(String str) {
        Executor executor;
        if (this.f == 1) {
            return;
        }
        c cVar = new c(str);
        if (com.mbridge.msdk.foundation.controller.d.a().e() && (executor = this.h) != null) {
            executor.execute(cVar);
        } else {
            cVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j) {
        if (this.k != null) {
            com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e("roas");
            eVar.a(true);
            if (j != 0) {
                eVar.c(j);
            }
            eVar.a(1);
            try {
                eVar.a(a(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.k.d(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("state", Integer.valueOf(i));
        if (i == 2) {
            eVar.a("reason", str);
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a("m_ad_rev_s_s", eVar);
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_ad_rev_s_s", cVar);
    }

    private JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split(b9.i.c)) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
