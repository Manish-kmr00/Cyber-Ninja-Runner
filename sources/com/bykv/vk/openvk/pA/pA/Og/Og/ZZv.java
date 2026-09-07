package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv {
    private static volatile ZZv ML;
    private volatile KZx BSW;
    private final HashSet<pA> Bzk;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx JG;
    private final Og<Runnable> KZx;
    private final SparseArray<Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og>> Og;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx SD;
    private final com.bykv.vk.openvk.pA.pA.Og.Og.Og.InterfaceC0156Og SGo;
    private volatile boolean Sn;
    private volatile KZx WV;
    private volatile String Wx;
    private final ExecutorService ZZv;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.Og omh;
    private volatile int pA = 163840;

    void pA(com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx kZx) {
        this.SD = kZx;
    }

    void pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx) {
        this.JG = kZx;
    }

    public void pA(int i) {
        if (i > 0) {
            this.pA = i;
        }
        if (ML.KZx) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    private ZZv() {
        SparseArray<Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og>> sparseArray = new SparseArray<>(2);
        this.Og = sparseArray;
        this.Bzk = new HashSet<>();
        this.SGo = new com.bykv.vk.openvk.pA.pA.Og.Og.Og.InterfaceC0156Og() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.1
            @Override // com.bykv.vk.openvk.pA.pA.Og.Og.Og.InterfaceC0156Og
            public void pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og og) {
                int iJG = og.JG();
                synchronized (ZZv.this.Og) {
                    Map map = (Map) ZZv.this.Og.get(iJG);
                    if (map != null) {
                        map.remove(og.omh);
                    }
                }
                if (ML.KZx) {
                    Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + og.omh);
                }
            }
        };
        Og<Runnable> og = new Og<>();
        this.KZx = og;
        ExecutorService executorServicePA = pA(og);
        this.ZZv = executorServicePA;
        og.pA((ThreadPoolExecutor) executorServicePA);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    KZx pA() {
        return this.BSW;
    }

    KZx Og() {
        return this.WV;
    }

    public static ZZv KZx() {
        if (ML == null) {
            synchronized (ZZv.class) {
                if (ML == null) {
                    ML = new ZZv();
                }
            }
        }
        return ML;
    }

    void pA(boolean z, String str) {
        com.bykv.vk.openvk.pA.pA.Og.Og.Og ogRemove;
        this.Wx = str;
        this.Sn = z;
        if (ML.KZx) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, ".concat(String.valueOf(str)));
        }
        HashSet<com.bykv.vk.openvk.pA.pA.Og.Og.Og> hashSet = null;
        HashSet<pA> hashSet2 = null;
        if (str == null) {
            synchronized (this.Bzk) {
                if (!this.Bzk.isEmpty()) {
                    hashSet2 = new HashSet(this.Bzk);
                    this.Bzk.clear();
                }
            }
            if (hashSet2 != null) {
                for (pA pAVar : hashSet2) {
                    pA(pAVar.pA, pAVar.Og, pAVar.KZx, pAVar.ZZv, pAVar.ML, pAVar.JG);
                    if (ML.KZx) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + pAVar.ZZv);
                    }
                }
                return;
            }
            return;
        }
        int i = ML.omh;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.Og) {
                    Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og> map = this.Og.get(com.bykv.vk.openvk.pA.pA.Og.Og.Og.Og.pA(z));
                    ogRemove = map != null ? map.remove(str) : null;
                }
                if (ogRemove != null) {
                    ogRemove.pA();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.Og) {
            int size = this.Og.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og>> sparseArray = this.Og;
                Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og> map2 = sparseArray.get(sparseArray.keyAt(i2));
                if (map2 != null) {
                    Collection<com.bykv.vk.openvk.pA.pA.Og.Og.Og> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (com.bykv.vk.openvk.pA.pA.Og.Og.Og og : hashSet) {
            og.pA();
            if (ML.KZx) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + og.SD);
            }
        }
        if (i == 3) {
            synchronized (this.Bzk) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    pA pAVar2 = (pA) ((com.bykv.vk.openvk.pA.pA.Og.Og.Og) it.next()).Sn;
                    if (pAVar2 != null) {
                        this.Bzk.add(pAVar2);
                    }
                }
            }
        }
    }

    public void pA(boolean z, boolean z2, int i, String str, String... strArr) {
        pA(z, z2, i, str, null, strArr);
    }

    public void pA(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        if (ML.KZx) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pAVar = z ? this.omh : this.SD;
        com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx = this.JG;
        if (pAVar == null || kZx == null) {
            if (ML.KZx) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.pA : i;
        String strPA = z2 ? str : com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(str);
        File fileZZv = pAVar.ZZv(strPA);
        if (fileZZv != null && fileZZv.length() >= i2) {
            if (ML.KZx) {
                Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + fileZZv.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        if (JG.pA().pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.Og.pA(z), strPA)) {
            if (ML.KZx) {
                Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        synchronized (this.Og) {
            Map<String, com.bykv.vk.openvk.pA.pA.Og.Og.Og> map2 = this.Og.get(z ? 1 : 0);
            if (map2.containsKey(strPA)) {
                return;
            }
            int i3 = i2;
            pA pAVar2 = new pA(z, z2, i2, str, map, strArr);
            String str2 = this.Wx;
            if (str2 != null) {
                int i4 = ML.omh;
                if (i4 == 3) {
                    synchronized (this.Bzk) {
                        this.Bzk.add(pAVar2);
                    }
                    if (ML.KZx) {
                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                    }
                    return;
                }
                if (i4 == 2) {
                    if (ML.KZx) {
                        Log.w("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                    }
                    return;
                } else if (i4 == 1 && this.Sn == z && str2.equals(strPA)) {
                    if (ML.KZx) {
                        Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                    }
                    return;
                }
            }
            List<Bzk.Og> listPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(map));
            if (listPA != null) {
                arrayList = new ArrayList(listPA.size());
                int size = listPA.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Bzk.Og og = listPA.get(i5);
                    if (og != null) {
                        arrayList.add(new Bzk.Og(og.pA, og.Og));
                    }
                }
            } else {
                arrayList = null;
            }
            com.bykv.vk.openvk.pA.pA.Og.Og.Og ogPA = new com.bykv.vk.openvk.pA.pA.Og.Og.Og.pA().pA(pAVar).pA(kZx).pA(str).Og(strPA).pA(new WV(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(strArr))).pA((List<Bzk.Og>) arrayList).pA(i3).pA(this.SGo).pA(pAVar2).pA();
            map2.put(strPA, ogPA);
            this.ZZv.execute(ogPA);
        }
    }

    public void pA(String str) {
        pA(false, false, str);
    }

    public void pA(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(new com.bytedance.sdk.component.omh.omh("cancel b b S") { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.pA.pA.Og.Og.Og og;
                synchronized (ZZv.this.Og) {
                    Map map = (Map) ZZv.this.Og.get(com.bykv.vk.openvk.pA.pA.Og.Og.Og.Og.pA(z));
                    if (map != null) {
                        og = (com.bykv.vk.openvk.pA.pA.Og.Og.Og) map.remove(z2 ? str : com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(str));
                    } else {
                        og = null;
                    }
                }
                if (og != null) {
                    og.pA();
                }
            }
        });
    }

    public void ZZv() {
        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(new com.bytedance.sdk.component.omh.omh("cancelAll") { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.pA.pA.Og.Og.Og> arrayList = new ArrayList();
                synchronized (ZZv.this.Og) {
                    int size = ZZv.this.Og.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) ZZv.this.Og.get(ZZv.this.Og.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    ZZv.this.KZx.clear();
                }
                for (com.bykv.vk.openvk.pA.pA.Og.Og.Og og : arrayList) {
                    og.pA();
                    if (ML.KZx) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + og + ", canceled!!!");
                    }
                }
            }
        });
    }

    private static final class pA {
        final String[] JG;
        final int KZx;
        final Map<String, String> ML;
        final boolean Og;
        final String ZZv;
        final boolean pA;

        pA(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.pA = z;
            this.Og = z2;
            this.KZx = i;
            this.ZZv = str;
            this.ML = map;
            this.JG = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            pA pAVar = (pA) obj;
            if (this.pA == pAVar.pA && this.Og == pAVar.Og && this.KZx == pAVar.KZx) {
                return this.ZZv.equals(pAVar.ZZv);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.pA ? 1 : 0) * 31) + (this.Og ? 1 : 0)) * 31) + this.KZx) * 31) + this.ZZv.hashCode();
        }
    }

    private static final class Og<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor pA;

        private Og() {
        }

        public void pA(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.pA != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.pA = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.pA.getPoolSize();
                int activeCount = this.pA.getActiveCount();
                int maximumPoolSize = this.pA.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (ML.KZx) {
                        Log.i("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService pA(final Og<Runnable> og) {
        int i;
        int iPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA();
        if (iPA > 0) {
            if (iPA > 4) {
                i = 4;
            }
            return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, og, new ThreadFactory() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable unused) {
                            }
                            super.run();
                        }
                    };
                    thread.setName("csj_video_preload_" + thread.getId());
                    thread.setDaemon(true);
                    if (ML.KZx) {
                        Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                    }
                    return thread;
                }
            }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        og.offerFirst(runnable);
                        if (ML.KZx) {
                            Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        iPA = 1;
        i = iPA;
        return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, og, new ThreadFactory() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable unused) {
                        }
                        super.run();
                    }
                };
                thread.setName("csj_video_preload_" + thread.getId());
                thread.setDaemon(true);
                if (ML.KZx) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    og.offerFirst(runnable);
                    if (ML.KZx) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
