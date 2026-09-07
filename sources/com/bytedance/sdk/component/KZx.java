package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes10.dex */
public class KZx {
    private static volatile Handler Og;
    private static final Object pA = new Object();
    private static final LinkedList<Runnable> KZx = new LinkedList<>();
    private static Object ZZv = new Object();

    public static void pA(Runnable runnable, boolean z) {
        try {
            Handler handlerOg = Og();
            synchronized (pA) {
                KZx.add(runnable);
                if (z) {
                    handlerOg.sendEmptyMessageDelayed(1, 100L);
                } else {
                    handlerOg.sendEmptyMessage(1);
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    private static Handler Og() {
        Handler handler;
        if (Og == null) {
            synchronized (pA) {
                if (Og == null) {
                    HandlerThread handlerThread = new HandlerThread("queued-work-looper", -2);
                    handlerThread.start();
                    Og = new pA(handlerThread.getLooper());
                }
                handler = Og;
            }
            return handler;
        }
        return Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx() {
        LinkedList linkedList;
        synchronized (ZZv) {
            synchronized (pA) {
                LinkedList<Runnable> linkedList2 = KZx;
                linkedList = (LinkedList) linkedList2.clone();
                linkedList2.clear();
                Og().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    private static class pA extends Handler {
        pA(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    KZx.KZx();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }
}
