package net.pubnative.lite.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import net.pubnative.lite.sdk.HyBid;

/* JADX INFO: loaded from: classes7.dex */
public class PNAdvertisingIdClient {
    private static final String TAG = "PNAdvertisingIdClient";
    protected Handler mHadler;
    protected Listener mListener;

    public interface Listener {
        void onPNAdvertisingIdFinish(String str, Boolean bool);
    }

    public void request(Context context, Listener listener) {
        this.mListener = listener;
        this.mHadler = new Handler(Looper.getMainLooper());
        getAdvertisingId(context);
    }

    protected void getAdvertisingId(final Context context) {
        new Thread(new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNAdvertisingIdClient.1
            @Override // java.lang.Runnable
            public void run() {
                AdInfo adInfo;
                boolean zIsLimitAdTrackingEnabled;
                String id = null;
                try {
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    AdvertisingConnection advertisingConnection = new AdvertisingConnection();
                    try {
                        try {
                            if (context.bindService(intent, advertisingConnection, 1)) {
                                AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                                adInfo = new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                            } else {
                                adInfo = null;
                            }
                            try {
                                context.unbindService(advertisingConnection);
                            } catch (Exception e) {
                                e = e;
                                HyBid.reportException(e);
                                Log.e(PNAdvertisingIdClient.TAG, "getAdvertisingIdInfo - Error: " + e);
                            }
                        } catch (Throwable th) {
                            context.unbindService(advertisingConnection);
                            throw th;
                        }
                    } catch (Exception e2) {
                        HyBid.reportException(e2);
                        Log.e(PNAdvertisingIdClient.TAG, "getAdvertisingIdInfo - Error: " + e2);
                        context.unbindService(advertisingConnection);
                        adInfo = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    adInfo = null;
                }
                if (adInfo != null) {
                    zIsLimitAdTrackingEnabled = adInfo.isLimitAdTrackingEnabled();
                    if (zIsLimitAdTrackingEnabled) {
                        Log.i(PNAdvertisingIdClient.TAG, "Error: cannot get advertising id, limit ad tracking is enabled");
                    } else {
                        id = adInfo.getId();
                    }
                } else {
                    zIsLimitAdTrackingEnabled = false;
                }
                PNAdvertisingIdClient.this.invokeOnFinish(id, zIsLimitAdTrackingEnabled);
            }
        }).start();
    }

    protected void invokeOnFinish(final String str, final boolean z) {
        this.mHadler.post(new Runnable() { // from class: net.pubnative.lite.sdk.utils.PNAdvertisingIdClient.2
            @Override // java.lang.Runnable
            public void run() {
                if (PNAdvertisingIdClient.this.mListener != null) {
                    PNAdvertisingIdClient.this.mListener.onPNAdvertisingIdFinish(str, Boolean.valueOf(z));
                }
            }
        });
    }

    public static class AdInfo {
        private final String mAdvertisingId;
        private final boolean mLimitAdTrackingEnabled;

        AdInfo(String str, boolean z) {
            this.mAdvertisingId = str;
            this.mLimitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.mAdvertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.mLimitAdTrackingEnabled;
        }
    }

    protected static class AdvertisingConnection implements ServiceConnection {
        boolean retrieved = false;
        private final LinkedBlockingQueue<IBinder> queue = new LinkedBlockingQueue<>(1);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        protected AdvertisingConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException e) {
                HyBid.reportException((Exception) e);
                Log.e(PNAdvertisingIdClient.TAG, "Error: can't connect to AdvertisingId service", e);
            }
        }

        public IBinder getBinder() throws InterruptedException {
            if (this.retrieved) {
                throw new IllegalStateException();
            }
            this.retrieved = true;
            return this.queue.take();
        }
    }

    protected static class AdvertisingInterface implements IInterface {
        private final IBinder binder;

        public AdvertisingInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public String getId() throws RemoteException {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Exception e) {
                    HyBid.reportException(e);
                    Log.e(PNAdvertisingIdClient.TAG, "Error: Can't read AdvertisingId from the service", e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }

        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z2 = false;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() != 0) {
                    z2 = true;
                }
            } catch (Exception e) {
                HyBid.reportException(e);
                Log.e(PNAdvertisingIdClient.TAG, "Error: Can't get is limit Ad tracking enabled", e);
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
            return z2;
        }
    }
}
