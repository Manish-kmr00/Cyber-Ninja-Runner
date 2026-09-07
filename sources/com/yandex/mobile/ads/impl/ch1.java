package com.yandex.mobile.ads.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ch1 extends BroadcastReceiver {
    public static final a h = new a(0);
    private static volatile ch1 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8609a;
    private final iw1 b;
    private final bh1 c;
    private final ah1 d;
    private final WeakHashMap<b, Object> e;
    private final Object f;
    private zg1 g;

    public interface b {
        void a(zg1 zg1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ch1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zg1 zg1VarA = this$0.c.a();
        this$0.g = zg1VarA;
        String str = "Initial phone state: " + zg1VarA;
        op0.d(new Object[0]);
        try {
            this$0.d.getClass();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (Build.VERSION.SDK_INT >= 33) {
                this$0.f8609a.registerReceiver(this$0, intentFilter, 2);
            } else {
                this$0.f8609a.registerReceiver(this$0, intentFilter);
            }
        } catch (Exception unused) {
            Object[] args = new Object[0];
            int i2 = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zg1 zg1Var;
        zg1 zg1Var2;
        HashSet hashSet;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        synchronized (this.f) {
            zg1 zg1Var3 = this.g;
            String action = intent.getAction();
            if (Intrinsics.areEqual(action, "android.intent.action.SCREEN_OFF")) {
                zg1Var = zg1.c;
            } else if (Intrinsics.areEqual(action, "android.intent.action.USER_PRESENT")) {
                zg1Var = zg1.d;
            } else {
                zg1Var = (this.g == zg1.d || !Intrinsics.areEqual(action, "android.intent.action.SCREEN_ON")) ? this.g : zg1.b;
            }
            this.g = zg1Var;
            if (zg1Var3 != zg1Var) {
                String str = "Phone state has changed: " + zg1Var;
                op0.d(new Object[0]);
            }
            zg1Var2 = this.g;
            hashSet = new HashSet(this.e.keySet());
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(zg1Var2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* synthetic */ ch1(Context context, Executor executor) {
        this(context, executor, iw1.a.a(), new bh1(context), new ah1());
        int i2 = iw1.l;
    }

    private ch1(Context context, Executor executor, iw1 iw1Var, bh1 bh1Var, ah1 ah1Var) {
        this.f8609a = context;
        this.b = iw1Var;
        this.c = bh1Var;
        this.d = ah1Var;
        this.e = new WeakHashMap<>();
        this.f = new Object();
        this.g = zg1.d;
        executor.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.ch1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ch1.a(this.f$0);
            }
        });
    }

    public final void a(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f) {
            this.e.put(callback, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class a {
        @JvmStatic
        public final ch1 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ch1 ch1Var = ch1.i;
            if (ch1Var == null) {
                synchronized (this) {
                    Context applicationContext = context.getApplicationContext();
                    int i = is0.f;
                    Executor executorC = is0.a.a().c();
                    ch1 ch1Var2 = ch1.i;
                    if (ch1Var2 == null) {
                        Intrinsics.checkNotNull(applicationContext);
                        ch1Var2 = new ch1(applicationContext, executorC);
                        ch1.i = ch1Var2;
                    }
                    ch1Var = ch1Var2;
                }
            }
            return ch1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x001f), top: B:22:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0026  */
    public final boolean b() {
        boolean z;
        cu1 cu1VarA = this.b.a(this.f8609a);
        synchronized (this.f) {
            z = true;
            if (cu1VarA != null) {
                if (cu1VarA.m0()) {
                    zg1 zg1Var = this.g;
                    if (zg1Var != zg1.b && zg1Var != zg1.d) {
                        z = false;
                    }
                } else if (this.g != zg1.d) {
                    z = false;
                }
            } else if (this.g != zg1.d) {
                z = false;
            }
            throw th;
        }
        return z;
    }

    public final void b(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f) {
            this.e.remove(callback);
        }
    }
}
