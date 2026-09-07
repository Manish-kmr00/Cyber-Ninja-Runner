package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class t32 implements ef0 {
    private static final ArrayList b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10265a;

    private static a d() {
        a aVar;
        ArrayList arrayList = b;
        synchronized (arrayList) {
            aVar = arrayList.isEmpty() ? new a() : (a) arrayList.remove(arrayList.size() - 1);
        }
        return aVar;
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final boolean b() {
        return this.f10265a.hasMessages(0);
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final void c() {
        this.f10265a.removeMessages(2);
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final ef0.a b(int i) {
        a aVarD = d();
        aVarD.f10266a = this.f10265a.obtainMessage(i);
        return aVarD;
    }

    public t32(Handler handler) {
        this.f10265a = handler;
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final boolean a(Runnable runnable) {
        return this.f10265a.post(runnable);
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final void a() {
        this.f10265a.removeCallbacksAndMessages(null);
    }

    private static final class a implements ef0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Message f10266a;

        private a() {
        }

        @Override // com.yandex.mobile.ads.impl.ef0.a
        public final void a() {
            Message message = this.f10266a;
            message.getClass();
            message.sendToTarget();
            b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f10266a = null;
            ArrayList arrayList = t32.b;
            synchronized (arrayList) {
                if (arrayList.size() < 50) {
                    arrayList.add(this);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final boolean a(int i) {
        return this.f10265a.sendEmptyMessage(i);
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final boolean a(long j) {
        return this.f10265a.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final boolean a(ef0.a aVar) {
        a aVar2 = (a) aVar;
        Handler handler = this.f10265a;
        Message message = aVar2.f10266a;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        aVar2.b();
        return zSendMessageAtFrontOfQueue;
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final ef0.a a(int i, Object obj) {
        a aVarD = d();
        aVarD.f10266a = this.f10265a.obtainMessage(i, obj);
        return aVarD;
    }

    @Override // com.yandex.mobile.ads.impl.ef0
    public final ef0.a a(int i, int i2) {
        a aVarD = d();
        aVarD.f10266a = this.f10265a.obtainMessage(1, i, i2);
        return aVarD;
    }
}
