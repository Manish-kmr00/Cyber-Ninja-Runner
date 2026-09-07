package sg.bigo.ads.common.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
class e implements ServiceConnection, IBinder.DeathRecipient {
    private static volatile e c;
    private static final Object d = new Object();
    private final Context e;
    boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BlockingQueue<IBinder> f13233a = new LinkedBlockingQueue(1);

    private e(Context context) {
        this.e = context;
    }

    public static e a(Context context) {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e(context);
                }
            }
        }
        return c;
    }

    private void a(IBinder iBinder) {
        try {
            synchronized (d) {
                this.f13233a.clear();
                this.f13233a.add(iBinder);
            }
        } catch (Exception unused) {
        }
    }

    private void b() {
        try {
            synchronized (d) {
                this.f13233a.clear();
            }
        } catch (Exception unused) {
        }
    }

    public final f a(long j, TimeUnit timeUnit) {
        try {
            IBinder iBinderPoll = this.f13233a.poll(j, timeUnit);
            if (iBinderPoll == null) {
                return null;
            }
            a(iBinderPoll);
            return f.a.a(iBinderPoll);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public final synchronized void a() {
        if (this.b) {
            try {
                this.b = false;
                b();
                this.e.unbindService(this);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        b();
    }
}
