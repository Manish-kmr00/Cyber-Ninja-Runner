package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;

/* JADX INFO: loaded from: classes6.dex */
public interface a extends ServiceConnection, com.digitalturbine.ignite.authenticator.listeners.api.a {
    void a(ComponentName componentName, IBinder iBinder);

    void a(a aVar);

    void a(String str);

    boolean a();

    void b();

    void b(a aVar);

    void b(String str);

    void c(String str);

    boolean c();

    String d();

    void destroy();

    String e();

    boolean f();

    Context g();

    boolean h();

    String i();

    boolean j();

    IIgniteServiceAPI k();

    void l();
}
