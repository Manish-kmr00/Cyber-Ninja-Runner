package com.bytedance.sdk.component.JG.pA.Og.KZx;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.JG.pA.ML;
import com.bytedance.sdk.component.JG.pA.omh;
import com.bytedance.sdk.component.JG.pA.pA.ZZv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends HandlerThread implements Handler.Callback {
    private static int aBv = 10;
    private static int yFO = 200;
    private final long BSW;
    private final AtomicInteger Bzk;
    private final AtomicInteger DX;
    private volatile int JG;
    private final Object KZx;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.JG.pA.ZZv.pA> ML;
    private volatile boolean Og;
    private volatile long SD;
    private final long SGo;
    private final int Sd;
    private final List<com.bytedance.sdk.component.JG.pA.ZZv.pA> Sn;
    private final int TX;
    private final AtomicInteger WV;
    private volatile Handler Wx;
    private long XT;
    private com.bytedance.sdk.component.JG.pA.Og.KZx ZZv;
    private final AtomicInteger oX;
    private volatile long omh;
    protected ZZv pA;
    private final int vZF;

    public static void pA(int i) {
        aBv = i;
    }

    public static void Og(int i) {
        yFO = i;
    }

    public KZx(PriorityBlockingQueue<com.bytedance.sdk.component.JG.pA.ZZv.pA> priorityBlockingQueue) {
        super("csj_log");
        this.Og = true;
        this.KZx = new Object();
        this.SD = 0L;
        this.omh = 0L;
        this.Bzk = new AtomicInteger(0);
        this.SGo = 5000L;
        this.BSW = 5000000000L;
        this.WV = new AtomicInteger(0);
        this.Sn = new ArrayList();
        this.DX = new AtomicInteger(0);
        this.oX = new AtomicInteger(0);
        this.XT = 60000L;
        this.vZF = 1;
        this.Sd = 2;
        this.TX = 3;
        this.ML = priorityBlockingQueue;
        this.pA = new com.bytedance.sdk.component.JG.pA.pA.Og();
        if (com.bytedance.sdk.component.JG.pA.Og.Og()) {
            return;
        }
        long jDX = omh.SD().oX().DX();
        if (jDX > 0) {
            this.XT = jDX;
        }
    }

    public void pA(boolean z) {
        this.Og = z;
    }

    public boolean pA() {
        return this.Og;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Bzk(), 1);
                Og();
                pA(true);
                ML();
            } else {
                if (i != 2 && i != 3) {
                    if (i == 11) {
                        ArrayList arrayList = new ArrayList(this.Sn);
                        this.Sn.clear();
                        pA((List<com.bytedance.sdk.component.JG.pA.ZZv.pA>) arrayList, false, "timeout_dispatch");
                        SGo();
                    }
                    return true;
                }
                KZx();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return true;
    }

    private void Og() {
        long jABv = omh.SD().aBv();
        if (jABv <= 0) {
            return;
        }
        this.pA.pA(Integer.MAX_VALUE, jABv);
    }

    private void KZx() {
        ZZv();
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.gbA(), 1);
        KZx(1);
    }

    private void ZZv() {
        if (!isAlive()) {
            com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.ZZv();
        } else {
            if (pA()) {
                return;
            }
            KZx(6);
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.Wx = new Handler(getLooper(), this);
        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.pA(this.Wx);
        this.Wx.sendEmptyMessage(1);
    }

    public boolean pA(int i, boolean z) {
        ML mlOX = omh.SD().oX();
        if (mlOX == null || !mlOX.pA(omh.SD().JG())) {
            return false;
        }
        return this.pA.pA(i, z);
    }

    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, boolean z) {
        if (pAVar == null) {
            return;
        }
        pAVar.ZZv();
        if (z) {
            if (this.Wx != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(pAVar);
                pA((List<com.bytedance.sdk.component.JG.pA.ZZv.pA>) arrayList, true, "ignore_result_dispatch");
                return;
            }
            return;
        }
        this.ML.add(pAVar);
        ML(2);
    }

    public void KZx(int i) {
        try {
            boolean zPA = pA(i, com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og);
            if (i == 6 || zPA) {
                com.bytedance.sdk.component.JG.pA.ZZv.Og og = new com.bytedance.sdk.component.JG.pA.ZZv.Og();
                og.Og(i);
                this.ML.add(og);
                ML(3);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        this.Bzk.set(0);
        if (i == 0) {
            this.JG = ((com.bytedance.sdk.component.JG.pA.ZZv.Og) pAVar).BSW();
            if (this.JG != 6) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Gx(), 1);
                Og(pAVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.JG.pA.ZZv.Og og = (com.bytedance.sdk.component.JG.pA.ZZv.Og) pAVar;
        if (og.BSW() == 1) {
            this.JG = 1;
            Og(pAVar);
        } else if (og.BSW() == 2) {
            SD();
            this.JG = 2;
            Og(pAVar);
        }
    }

    private void ML() {
        while (pA()) {
            try {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.omh(), 1);
                com.bytedance.sdk.component.JG.pA.ZZv.pA pAVarPoll = this.ML.poll(this.XT, TimeUnit.MILLISECONDS);
                int size = this.ML.size();
                if (pAVarPoll instanceof com.bytedance.sdk.component.JG.pA.ZZv.Og) {
                    pA(pAVarPoll, size);
                } else if (pAVarPoll == null) {
                    int iIncrementAndGet = this.Bzk.incrementAndGet();
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Bf(), 1);
                    if (ZZv(iIncrementAndGet)) {
                        JG();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        this.JG = 1;
                        Og((com.bytedance.sdk.component.JG.pA.ZZv.pA) null);
                    }
                } else {
                    pA(pAVarPoll);
                    Og(pAVarPoll);
                }
            } catch (Throwable th) {
                th.getMessage();
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.CIG(), 1);
            }
        }
    }

    private boolean ZZv(int i) {
        return i >= 4 && this.WV.get() == 0 && !com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og && !com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx;
    }

    private void JG() {
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.TX(), 1);
        pA(false);
        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx();
    }

    private void SD() {
        if (this.ML.size() >= 100) {
            for (int i = 0; i < 100; i++) {
                com.bytedance.sdk.component.JG.pA.ZZv.pA pAVarPoll = this.ML.poll();
                if (!(pAVarPoll instanceof com.bytedance.sdk.component.JG.pA.ZZv.Og) && pAVarPoll != null) {
                    pA(pAVarPoll);
                }
            }
        }
    }

    private void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        this.Bzk.set(0);
        if (com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og) {
            this.JG = 5;
        } else if (com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx) {
            this.JG = 7;
        } else {
            this.JG = 4;
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.fJy(), 1);
        this.pA.pA(pAVar, this.JG);
        com.bytedance.sdk.component.JG.pA.KZx.pA.SD(pAVar);
    }

    private boolean omh() {
        if (com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og) {
            return this.JG == 4 || this.JG == 7 || this.JG == 6 || this.JG == 5 || this.JG == 2;
        }
        return false;
    }

    private void Og(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        List<com.bytedance.sdk.component.JG.pA.ZZv.pA> listPA;
        if (com.bytedance.sdk.component.JG.pA.KZx.pA.Og() && omh.SD().pA()) {
            return;
        }
        int i = 0;
        if (omh()) {
            com.bytedance.sdk.component.JG.pA.KZx.pA.pA(this.JG);
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.WV(), 1);
            if (this.ML.size() != 0) {
                return;
            }
            if (!this.Wx.hasMessages(2)) {
                com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                this.omh = 0L;
                this.SD = 0L;
                this.DX.set(0);
                this.oX.set(0);
            } else {
                pA(false);
                return;
            }
        }
        do {
            boolean zPA = pA(this.JG, com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og);
            com.bytedance.sdk.component.JG.pA.KZx.pA.pA(zPA, this.JG, pAVar);
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Wx(), 1);
            if (zPA && (listPA = this.pA.pA(this.JG, -1, null)) != null) {
                listPA.size();
                pA(listPA);
            } else {
                Bzk();
            }
            i++;
            if (!zPA) {
                return;
            }
        } while (i <= 6);
    }

    private void Bzk() {
        try {
            if (this.ML.size() == 0 && this.Wx.hasMessages(11) && pA()) {
                pA(false);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void pA(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, String str) {
        pA(str);
        pA(list, false, str);
        SGo();
    }

    private void pA(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.JG.pA.KZx.pA.pA(list, this.ML.size());
            if (list.size() > 1 || com.bytedance.sdk.component.JG.pA.KZx.pA.KZx()) {
                pA(list, "batchRead");
                return;
            }
            com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(0);
            if (pAVar != null) {
                if (pAVar.ML() == 1) {
                    pA(list, "highPriority");
                    return;
                }
                if (pAVar.ZZv() == 0 && pAVar.ML() == 2) {
                    if (pAVar.Og() == 3) {
                        pA(list, "version_v3");
                        return;
                    } else {
                        Og(list);
                        return;
                    }
                }
                if (pAVar.ZZv() == 1) {
                    pA(list, "stats");
                    return;
                } else if (pAVar.ZZv() == 3) {
                    pA(list, "adType_v3");
                    return;
                } else {
                    if (pAVar.ZZv() == 2) {
                        pA(list, "other");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        Bzk();
    }

    private void Og(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        this.Sn.addAll(list);
        this.Sn.size();
        ML mlOX = omh.SD().oX();
        if (mlOX != null && mlOX.WV() != null) {
            aBv = mlOX.WV().Og();
        }
        if (this.Sn.size() >= aBv) {
            if (this.Wx.hasMessages(11)) {
                this.Wx.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.Sn);
            this.Sn.clear();
            pA((List<com.bytedance.sdk.component.JG.pA.ZZv.pA>) arrayList, false, "max_size_dispatch");
            SGo();
            return;
        }
        if (this.ML.size() == 0) {
            pA(false);
            if (this.Wx.hasMessages(11)) {
                this.Wx.removeMessages(11);
            }
            if (this.Wx.hasMessages(1)) {
                this.Wx.removeMessages(1);
            }
            long jPA = yFO;
            if (mlOX != null && mlOX.WV() != null) {
                jPA = mlOX.WV().pA();
            }
            this.Wx.sendEmptyMessageDelayed(11, jPA);
            return;
        }
        this.Sn.size();
    }

    private void pA(String str) {
        if (this.Wx.hasMessages(11)) {
            this.Wx.removeMessages(11);
        }
        if (this.Sn.size() != 0) {
            ArrayList arrayList = new ArrayList(this.Sn);
            this.Sn.clear();
            pA((List<com.bytedance.sdk.component.JG.pA.ZZv.pA>) arrayList, false, "before_".concat(String.valueOf(str)));
            SGo();
            arrayList.size();
        }
    }

    private void pA(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, boolean z, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.JG.pA.KZx.pA.pA(list, this.JG, str);
        com.bytedance.sdk.component.JG.pA.Og.KZx kZxOmh = omh.SD().omh();
        this.ZZv = kZxOmh;
        if (kZxOmh != null) {
            Og(list, z, jCurrentTimeMillis);
        } else {
            pA(list, z, jCurrentTimeMillis);
        }
    }

    private void pA(final List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, final boolean z, final long j) {
        ML mlOX = omh.SD().oX();
        if (mlOX != null) {
            Executor executorML = mlOX.ML();
            if (list.get(0).ML() == 1) {
                executorML = mlOX.ZZv();
            }
            if (executorML == null) {
                return;
            }
            this.WV.incrementAndGet();
            executorML.execute(new com.bytedance.sdk.component.JG.pA.ML.ML("csj_log_upload") { // from class: com.bytedance.sdk.component.JG.pA.Og.KZx.KZx.1
                @Override // java.lang.Runnable
                public void run() {
                    KZx kZx = KZx.this;
                    kZx.pA((List<com.bytedance.sdk.component.JG.pA.ZZv.pA>) list, z, j, kZx.JG);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, boolean z, long j, int i) {
        Og ogPA;
        try {
            com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar = list.get(0);
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.fw(), 1);
            if (pAVar.ZZv() == 0) {
                ogPA = omh.ML().pA(list);
                pA(ogPA, list);
                if (ogPA != null) {
                    com.bytedance.sdk.component.JG.pA.KZx.pA.pA(list, ogPA.ZZv);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.JG.pA.ZZv.pA> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().SD());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    e.getMessage();
                }
                ogPA = omh.ML().pA(jSONObject);
            }
            Og og = ogPA;
            this.WV.decrementAndGet();
            pA(z, og, list, j);
        } catch (Throwable th) {
            th.getMessage();
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.CIG(), 1);
            this.WV.decrementAndGet();
        }
    }

    private void Og(List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, final boolean z, final long j) {
        this.WV.incrementAndGet();
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.fw(), 1);
        try {
            HashMap map = new HashMap();
            Iterator<com.bytedance.sdk.component.JG.pA.ZZv.pA> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.JG.pA.ZZv.pA next = it.next();
                int iSGo = next == null ? 0 : next.SGo();
                if (map.get(Integer.valueOf(iSGo)) == null) {
                    map.put(Integer.valueOf(iSGo), new ArrayList());
                }
                ((List) map.get(Integer.valueOf(iSGo))).add(next);
            }
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Integer) it2.next()).intValue();
                if (iIntValue == 0 || omh.SD().KZx() == null || omh.SD().KZx().get(Integer.valueOf(iIntValue)) == null) {
                    this.ZZv.pA(list, new com.bytedance.sdk.component.JG.pA.Og.Og() { // from class: com.bytedance.sdk.component.JG.pA.Og.KZx.KZx.2
                        @Override // com.bytedance.sdk.component.JG.pA.Og.Og
                        public void pA(List<pA> list2) {
                            try {
                                KZx.this.WV.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i = 0; i < size; i++) {
                                    pA pAVar = list2.get(i);
                                    if (pAVar != null) {
                                        KZx.this.pA(z, pAVar.pA(), pAVar.Og(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                } else {
                    omh.SD().KZx().get(Integer.valueOf(iIntValue)).pA(list, new com.bytedance.sdk.component.JG.pA.Og.Og() { // from class: com.bytedance.sdk.component.JG.pA.Og.KZx.KZx.3
                        @Override // com.bytedance.sdk.component.JG.pA.Og.Og
                        public void pA(List<pA> list2) {
                            try {
                                KZx.this.WV.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i = 0; i < size; i++) {
                                    pA pAVar = list2.get(i);
                                    if (pAVar != null) {
                                        KZx.this.pA(z, pAVar.pA(), pAVar.Og(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.getMessage();
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.CIG(), 1);
            this.WV.decrementAndGet();
        }
    }

    private void ML(int i) {
        if (!pA()) {
            if (this.Wx == null) {
                return;
            }
            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.KZx(), 1);
            if (this.Wx.hasMessages(1)) {
                return;
            }
            if (i == 1) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.JG(), 1);
            } else if (i == 2) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.ZZv(), 1);
            } else if (i == 3) {
                com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.ML(), 1);
            }
            this.Wx.sendEmptyMessage(1);
            return;
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.pA(), 1);
    }

    private void pA(Og og, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list) {
        if (og == null || !og.pA) {
            return;
        }
        List<Object> listPA = com.bytedance.sdk.component.JG.pA.Og.pA();
        if (list == null || listPA == null || listPA.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar : list) {
            if (pAVar.ML() == 1) {
                com.bytedance.sdk.component.JG.pA.KZx.pA.pA(pAVar);
                com.bytedance.sdk.component.JG.pA.KZx.pA.ML(pAVar);
                Iterator<Object> it = listPA.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void SGo() {
        if (this.Wx.hasMessages(11)) {
            Bzk();
        } else {
            ML(1);
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Og(), 1);
        if (this.JG != 2) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.SD(), 1);
        synchronized (this.KZx) {
            try {
                try {
                    long jNanoTime = System.nanoTime();
                    this.KZx.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    if (!com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og) {
                        boolean z = com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx;
                    }
                    if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                        if (!com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og && !com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx) {
                            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.Vgu(), 1);
                            KZx(2);
                            return;
                        }
                        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.BSW(), 1);
                        return;
                    }
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.SGo(), 1);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z, Og og, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, long j) {
        if (z || og == null) {
            return;
        }
        int i = og.Og;
        int i2 = -2;
        if (og.ML) {
            i = -1;
        } else if (i < 0) {
            i = -2;
        }
        if (i == 510 || i == 511) {
            i = -2;
        }
        if (og.pA || ((i < 500 || i >= 509) && i <= 513)) {
            i2 = i;
        }
        if (list != null) {
            list.size();
            this.WV.get();
        }
        pA(i2, list, j);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0069 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0075 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0085 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0092 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b4 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4 A[Catch: all -> 0x00fd, DONT_GENERATE, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d3 A[Catch: all -> 0x00fd, DONT_GENERATE, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d5 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    private void pA(int i, List<com.bytedance.sdk.component.JG.pA.ZZv.pA> list, long j) {
        synchronized (this.KZx) {
            if (list != null) {
                if (this.Wx != null) {
                    com.bytedance.sdk.component.JG.pA.KZx.pA.pA(i, list, j);
                    this.pA.pA(i, list);
                    omh.SD().oX();
                    if (i == -2) {
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = true;
                        if (this.Wx.hasMessages(3)) {
                            return;
                        }
                        if (System.currentTimeMillis() - this.omh < 15000) {
                            return;
                        }
                        this.omh = System.currentTimeMillis();
                        if (this.Wx.hasMessages(2)) {
                            this.Wx.removeMessages(2);
                        }
                        pA(3, 15000L);
                    } else if (i == -1) {
                        if (!com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og || com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx) {
                            com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                            com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = false;
                            if (this.Wx.hasMessages(2)) {
                                this.Wx.removeMessages(2);
                            }
                            if (this.Wx.hasMessages(3)) {
                                this.Wx.removeMessages(3);
                            }
                            this.omh = 0L;
                            this.SD = 0L;
                            this.DX.set(0);
                            this.oX.set(0);
                            com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.SzT(), 1);
                            KZx(2);
                        }
                    } else if (i == 0) {
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = true;
                        if (this.Wx.hasMessages(3)) {
                            return;
                        }
                        if (System.currentTimeMillis() - this.omh < 15000) {
                            return;
                        }
                        this.omh = System.currentTimeMillis();
                        if (this.Wx.hasMessages(2)) {
                            this.Wx.removeMessages(2);
                        }
                        pA(3, 15000L);
                    } else if (i != 200) {
                        if (i == 509) {
                            com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = true;
                            com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = false;
                            if (this.Wx.hasMessages(2)) {
                                return;
                            }
                            if (System.currentTimeMillis() - this.SD < 30000) {
                                return;
                            }
                            this.SD = System.currentTimeMillis();
                            if (this.Wx.hasMessages(3)) {
                                this.Wx.removeMessages(3);
                            }
                            pA(2, 30000L);
                        }
                    } else if (!com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og) {
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = false;
                        if (this.Wx.hasMessages(2)) {
                            this.Wx.removeMessages(2);
                        }
                        if (this.Wx.hasMessages(3)) {
                            this.Wx.removeMessages(3);
                        }
                        this.omh = 0L;
                        this.SD = 0L;
                        this.DX.set(0);
                        this.oX.set(0);
                        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.SzT(), 1);
                        KZx(2);
                    } else {
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.Og = false;
                        com.bytedance.sdk.component.JG.pA.Og.ZZv.pA.KZx = false;
                        if (this.Wx.hasMessages(2)) {
                            this.Wx.removeMessages(2);
                        }
                        if (this.Wx.hasMessages(3)) {
                            this.Wx.removeMessages(3);
                        }
                        this.omh = 0L;
                        this.SD = 0L;
                        this.DX.set(0);
                        this.oX.set(0);
                        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(com.bytedance.sdk.component.JG.pA.Og.ZZv.ZZv.SzT(), 1);
                        KZx(2);
                    }
                    if (this.JG == 2) {
                        this.KZx.notify();
                    }
                    this.ML.size();
                }
            }
        }
    }

    public void pA(int i, long j) {
        if (this.Wx == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        if (i == 2) {
            this.Wx.sendMessageDelayed(messageObtain, ((long) (((this.DX.incrementAndGet() - 1) % 4) + 1)) * j);
        } else if (i == 3) {
            this.Wx.sendMessageDelayed(messageObtain, ((long) (((this.oX.incrementAndGet() - 1) % 4) + 1)) * j);
        }
    }
}
