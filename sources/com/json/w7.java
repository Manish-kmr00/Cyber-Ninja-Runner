package com.json;

import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.bidding.BiddingDataCallback;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.NetworkSettings;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public class w7 implements Callable<a8> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4553a;
    private final String b;
    private final AdData c;
    private final y7 d;
    private final x7 e;
    private final NetworkSettings f;

    class a implements BiddingDataCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib f4554a;
        final /* synthetic */ BlockingQueue b;

        a(ib ibVar, BlockingQueue blockingQueue) {
            this.f4554a = ibVar;
            this.b = blockingQueue;
        }

        @Override // com.json.mediationsdk.bidding.BiddingDataCallback
        public void onFailure(String str) {
            this.b.add(new a8(w7.this.d(), w7.this.c(), null, ib.a(this.f4554a), str));
        }

        @Override // com.json.mediationsdk.bidding.BiddingDataCallback
        public void onSuccess(Map<String, Object> map) {
            this.b.add(new a8(w7.this.d(), w7.this.c(), map, ib.a(this.f4554a), null));
        }
    }

    public w7(int i, String str, AdData adData, y7 y7Var, x7 x7Var, NetworkSettings networkSettings) {
        this.f4553a = i;
        this.b = str;
        this.c = adData;
        this.d = y7Var;
        this.e = x7Var;
        this.f = networkSettings;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x007f A[PHI: r0 r2
  0x007f: PHI (r0v5 java.lang.String) = (r0v4 java.lang.String), (r0v9 java.lang.String) binds: [B:7:0x0058, B:11:0x007d] A[DONT_GENERATE, DONT_INLINE]
  0x007f: PHI (r2v10 com.ironsource.x7) = (r2v9 com.ironsource.x7), (r2v14 com.ironsource.x7) binds: [B:7:0x0058, B:11:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a8 call() throws Exception {
        String str;
        x7 x7Var;
        ib ibVar = new ib();
        IronLog.INTERNAL.verbose(c() + " fetching bidding data");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        try {
            b().a(this.c, new a(ibVar, arrayBlockingQueue));
        } catch (Exception e) {
            o9.d().a(e);
            str = "Exception while calling collectBiddingData - " + e.getMessage();
            IronLog.INTERNAL.error(str);
            x7Var = this.e;
            if (x7Var != null) {
                x7Var.a(str);
            }
        } catch (NoClassDefFoundError e2) {
            o9.d().a(e2);
            str = "Error while calling collectBiddingData - " + e2.getMessage();
            IronLog.INTERNAL.error(str);
            x7Var = this.e;
            if (x7Var != null) {
                x7Var.a(str);
            }
        }
        x7 x7Var2 = this.e;
        if (x7Var2 != null) {
            x7Var2.a(this.f);
        }
        return (a8) arrayBlockingQueue.take();
    }

    public y7 b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f4553a;
    }
}
