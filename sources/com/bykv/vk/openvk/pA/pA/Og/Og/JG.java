package com.bykv.vk.openvk.pA.pA.Og.Og;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class JG {
    private static volatile JG ZZv;
    private volatile KZx BSW;
    private final SD.KZx Bzk;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx JG;
    private final AtomicInteger KZx = new AtomicInteger(0);
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx ML;
    private volatile int Og;
    private volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.Og SD;
    private volatile KZx SGo;
    private final Runnable WV;
    private final AtomicBoolean Wx;
    private final SparseArray<Set<SD>> omh;
    private volatile ServerSocket pA;

    static /* synthetic */ void pA(String str, String str2) {
    }

    boolean pA(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.omh) {
            Set<SD> set = this.omh.get(i);
            if (set != null) {
                for (SD sd : set) {
                    if (sd != null && str.equals(sd.omh)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static JG pA() {
        if (ZZv == null) {
            synchronized (JG.class) {
                if (ZZv == null) {
                    ZZv = new JG();
                }
            }
        }
        return ZZv;
    }

    private JG() {
        SparseArray<Set<SD>> sparseArray = new SparseArray<>(2);
        this.omh = sparseArray;
        this.Bzk = new SD.KZx() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.JG.1
            @Override // com.bykv.vk.openvk.pA.pA.Og.Og.SD.KZx
            public void pA(SD sd) {
                synchronized (JG.this.omh) {
                    Set set = (Set) JG.this.omh.get(sd.JG());
                    if (set != null) {
                        set.add(sd);
                    }
                }
            }

            @Override // com.bykv.vk.openvk.pA.pA.Og.Og.SD.KZx
            public void Og(SD sd) {
                if (ML.KZx) {
                    Log.d("ProxyServer", "afterExecute, ProxyTask: ".concat(String.valueOf(sd)));
                }
                int iJG = sd.JG();
                synchronized (JG.this.omh) {
                    Set set = (Set) JG.this.omh.get(iJG);
                    if (set != null) {
                        set.remove(sd);
                    }
                }
            }
        };
        this.WV = new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.JG.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = 0;
                    JG.this.pA = new ServerSocket(0, 50, InetAddress.getByName(JG.this.Bzk()));
                    JG jg = JG.this;
                    jg.Og = jg.pA.getLocalPort();
                    if (JG.this.Og != -1) {
                        SGo.pA(JG.this.Bzk(), JG.this.Og);
                        if (JG.this.SD()) {
                            new Object[]{"run:  state = ", JG.this.KZx};
                            if (JG.this.KZx.compareAndSet(0, 1)) {
                                new Object[]{"run:  state = ", JG.this.KZx};
                                boolean z = ML.KZx;
                                while (JG.this.KZx.get() == 1) {
                                    try {
                                        try {
                                            Socket socketAccept = JG.this.pA.accept();
                                            com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx = JG.this.ML;
                                            if (kZx != null) {
                                                final SD sdPA = new SD.pA().pA(kZx).pA(socketAccept).pA(JG.this.Bzk).pA();
                                                com.bytedance.sdk.component.omh.JG.KZx().execute(new com.bytedance.sdk.component.omh.omh("ProxyTask", 10) { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.JG.2.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        sdPA.run();
                                                    }
                                                });
                                            } else {
                                                com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(socketAccept);
                                            }
                                        } catch (IOException e) {
                                            JG.pA("accept error", Log.getStackTraceString(e));
                                            i++;
                                            if (i > 3) {
                                                boolean z2 = ML.KZx;
                                                JG.this.ML();
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        String stackTraceString = Log.getStackTraceString(th);
                                        Log.e("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                        JG.pA("error", stackTraceString);
                                    }
                                }
                                boolean z3 = ML.KZx;
                                JG.this.ML();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JG.pA("socket not bound", "");
                    JG.this.ML();
                } catch (IOException e2) {
                    if (ML.KZx) {
                        Log.e("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                    }
                    JG.pA("create ServerSocket error", Log.getStackTraceString(e2));
                    JG.this.ML();
                }
            }
        };
        this.Wx = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    KZx Og() {
        return this.SGo;
    }

    KZx KZx() {
        return this.BSW;
    }

    void pA(com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx) {
        this.ML = kZx;
    }

    void pA(com.bykv.vk.openvk.pA.pA.Og.Og.pA.KZx kZx) {
        this.JG = kZx;
    }

    public String pA(boolean z, boolean z2, String str, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.ML == null) {
            return strArr[0];
        }
        if ((z ? this.SD : this.JG) == null) {
            return strArr[0];
        }
        if (this.KZx.get() != 1) {
            return strArr[0];
        }
        List<String> listPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(strArr);
        if (listPA == null) {
            return strArr[0];
        }
        String strPA = Bzk.pA(str, z2 ? str : com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(str), listPA);
        if (strPA == null) {
            return strArr[0];
        }
        return (z ? "https://" + Bzk() + ":" + this.Og + "?f=1&" + strPA : "https://" + Bzk() + ":" + this.Og + "?" + strPA).replaceFirst("s", "");
    }

    public void ZZv() {
        if (this.Wx.compareAndSet(false, true)) {
            Thread thread = new Thread(this.WV);
            thread.setName("csj_proxy_server");
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        if (this.KZx.compareAndSet(1, 2) || this.KZx.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(this.pA);
            JG();
        }
    }

    private void JG() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.omh) {
            int size = this.omh.size();
            for (int i = 0; i < size; i++) {
                SparseArray<Set<SD>> sparseArray = this.omh;
                Set<SD> set = sparseArray.get(sparseArray.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SD) it.next()).pA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean SD() {
        com.bytedance.sdk.component.omh.SD sd = new com.bytedance.sdk.component.omh.SD(new pA(Bzk(), this.Og), 5, 1);
        com.bytedance.sdk.component.omh.JG.KZx().submit(sd);
        omh();
        try {
            if (!((Boolean) sd.get()).booleanValue()) {
                Log.e("ProxyServer", "Ping error");
                ML();
                return false;
            }
            boolean z = ML.KZx;
            return true;
        } catch (Throwable th) {
            Log.getStackTraceString(th);
            ML();
            return false;
        }
    }

    private static final class pA implements Callable<Boolean> {
        private final int Og;
        private final String pA;

        pA(String str, int i) {
            this.pA = str;
            this.Og = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.pA, this.Og);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        Boolean bool = Boolean.TRUE;
                        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(socket);
                        return bool;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.getMessage();
                        JG.pA("ping error", Log.getStackTraceString(th));
                    } finally {
                        com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(socket);
                    }
                }
            } catch (Throwable th3) {
                socket = null;
                th = th3;
            }
            return Boolean.FALSE;
        }
    }

    private void omh() {
        Socket socketAccept = null;
        try {
            socketAccept = this.pA.accept();
            socketAccept.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socketAccept.getInputStream())).readLine())) {
                OutputStream outputStream = socketAccept.getOutputStream();
                outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA));
                outputStream.flush();
            }
        } catch (IOException e) {
            Log.getStackTraceString(e);
        } finally {
            com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(socketAccept);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bzk() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }
}
