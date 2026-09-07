package com.bykv.vk.openvk.pA.pA.Og.Og.JG;

import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.Og.Og.JG;
import com.bykv.vk.openvk.pA.pA.Og.Og.ML;
import com.bykv.vk.openvk.pA.pA.Og.Og.ZZv;
import com.bykv.vk.openvk.pA.pA.pA.SD.KZx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public class pA {
    public static final boolean pA = KZx.KZx();
    private C0154pA KZx;
    private HashMap<String, Boolean> Og;

    private pA() {
        this.Og = new HashMap<>();
        Og();
    }

    public static pA pA() {
        return Og.pA;
    }

    private static class Og {
        private static final pA pA = new pA();
    }

    public boolean Og() {
        if (this.KZx != null) {
            return true;
        }
        com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx KZx = KZx();
        if (KZx == null) {
            return false;
        }
        ML.pA(true);
        ML.Og(true);
        ML.pA(1);
        JG.pA().ZZv();
        try {
            C0154pA c0154pA = new C0154pA();
            this.KZx = c0154pA;
            c0154pA.setName("csj_video_cache_preloader");
            this.KZx.start();
            ML.pA(KZx, com.bykv.vk.openvk.pA.pA.pA.KZx.pA());
            ZZv.KZx();
            ZZv.KZx().pA(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (!Og()) {
            return false;
        }
        this.KZx.pA(kZx);
        return true;
    }

    public String Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        if (kZx == null) {
            return null;
        }
        boolean zIsEmpty = TextUtils.isEmpty(kZx.Sn());
        return JG.pA().pA(false, !zIsEmpty, !zIsEmpty ? kZx.Sn() : kZx.Wx(), kZx.Wx());
    }

    private static com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx KZx() {
        File file = new File(com.bykv.vk.openvk.pA.pA.pA.KZx.pA().getCacheDir(), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx kZx = new com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx(file);
            try {
                kZx.pA(104857600L);
                return kZx;
            } catch (IOException unused) {
                return kZx;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.pA.pA.Og.Og.JG.pA$pA, reason: collision with other inner class name */
    class C0154pA extends Thread {
        private final Queue<C0155pA> ZZv = new ArrayBlockingQueue(10);
        private Queue<C0155pA> Og = new LinkedBlockingQueue();
        private boolean KZx = true;
        private Queue<C0155pA> ML = new LinkedBlockingQueue();

        public C0154pA() {
        }

        private C0155pA pA(int i, com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
            this.ZZv.size();
            C0155pA c0155pAPoll = this.ZZv.poll();
            if (c0155pAPoll == null) {
                c0155pAPoll = new C0155pA();
            }
            c0155pAPoll.pA = i;
            c0155pAPoll.JG = kZx;
            return c0155pAPoll;
        }

        private void pA(C0155pA c0155pA) {
            c0155pA.KZx = null;
            c0155pA.Og = null;
            c0155pA.pA = -1;
            c0155pA.JG = null;
            this.ZZv.offer(c0155pA);
        }

        private synchronized void Og(C0155pA c0155pA) {
            this.ML.add(c0155pA);
            notify();
        }

        private void KZx(C0155pA c0155pA) {
            if (c0155pA == null) {
                return;
            }
            this.Og.offer(c0155pA);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.KZx) {
                synchronized (this) {
                    if (!this.ML.isEmpty()) {
                        pA();
                    }
                    while (!this.Og.isEmpty()) {
                        C0155pA c0155pAPoll = this.Og.poll();
                        if (c0155pAPoll != null) {
                            int i = c0155pAPoll.pA;
                            if (i != 0) {
                                if (i == 1) {
                                    ZZv.KZx().pA(c0155pAPoll.Og);
                                } else if (i == 2) {
                                    ZZv.KZx().ZZv();
                                } else if (i == 3) {
                                    ZZv.KZx().ZZv();
                                    if (ML.KZx() != null) {
                                        ML.KZx();
                                        throw null;
                                    }
                                    if (ML.Og() != null) {
                                        ML.Og().pA();
                                    }
                                } else if (i == 4) {
                                    ZZv.KZx().ZZv();
                                    this.KZx = false;
                                }
                            } else if (c0155pAPoll.KZx != null && c0155pAPoll.KZx.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0155pAPoll.KZx) {
                                    if (com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                ZZv.KZx().pA(false, !TextUtils.isEmpty(c0155pAPoll.ML), c0155pAPoll.ZZv, c0155pAPoll.Og, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            pA(c0155pAPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        private void pA() {
            while (true) {
                C0155pA c0155pAPoll = this.ML.poll();
                if (c0155pAPoll == null) {
                    return;
                }
                c0155pAPoll.Og = c0155pAPoll.JG.Wx();
                c0155pAPoll.KZx = new String[]{c0155pAPoll.JG.Wx()};
                int iPA = c0155pAPoll.JG.pA();
                if (iPA <= 0) {
                    iPA = c0155pAPoll.JG.KZx();
                }
                c0155pAPoll.ZZv = iPA;
                c0155pAPoll.ML = c0155pAPoll.JG.Sn();
                if (!TextUtils.isEmpty(c0155pAPoll.JG.Sn())) {
                    c0155pAPoll.Og = c0155pAPoll.JG.Sn();
                }
                c0155pAPoll.JG = null;
                KZx(c0155pAPoll);
            }
        }

        public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
            Og(pA(0, kZx));
        }

        /* JADX INFO: renamed from: com.bykv.vk.openvk.pA.pA.Og.Og.JG.pA$pA$pA, reason: collision with other inner class name */
        private class C0155pA {
            public com.bykv.vk.openvk.pA.pA.pA.KZx.KZx JG;
            public String[] KZx;
            public String ML;
            public String Og;
            public int ZZv;
            public int pA;

            public C0155pA() {
            }
        }
    }
}
