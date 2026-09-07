package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: AdvertisingIdClient.java */
/* JADX INFO: loaded from: classes12.dex */
public class b {

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    public final class C0444b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5045a;
        private final boolean b;

        C0444b(String str, boolean z) {
            this.f5045a = str;
            this.b = z;
        }

        public String a() {
            return this.f5045a;
        }

        public boolean b() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    private final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f5046a;
        boolean b;

        private c() {
            this.f5046a = new LinkedBlockingQueue<>(1);
            this.b = false;
        }

        public IBinder a() throws InterruptedException {
            if (this.b) {
                throw new IllegalStateException();
            }
            this.b = true;
            return this.f5046a.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f5046a.put(iBinder);
            } catch (InterruptedException e) {
                o0.b("AdvertisingIdClient", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: AdvertisingIdClient.java */
    private final class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f5047a;

        public d(IBinder iBinder) {
            this.f5047a = iBinder;
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z2 = false;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.f5047a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                z2 = parcelObtain2.readInt() != 0;
                parcelObtain2.recycle();
                parcelObtain.recycle();
            } catch (Throwable th) {
                try {
                    o0.b("AdvertisingIdClient", th.getMessage());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
            return z2;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f5047a;
        }

        public String getId() throws RemoteException {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f5047a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                try {
                    o0.b("AdvertisingIdClient", th.getMessage());
                    string = null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
            return string;
        }
    }

    public C0444b a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, cVar, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                d dVar = new d(cVar.a());
                C0444b c0444b = new C0444b(dVar.getId(), dVar.a(true));
                context.unbindService(cVar);
                return c0444b;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            context.unbindService(cVar);
            throw th;
        }
    }
}
