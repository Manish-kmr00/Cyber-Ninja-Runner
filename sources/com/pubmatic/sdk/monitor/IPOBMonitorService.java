package com.pubmatic.sdk.monitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public interface IPOBMonitorService extends IInterface {
    public static final String DESCRIPTOR = "com.pubmatic.sdk.monitor.IPOBMonitorService";

    public static class Default implements IPOBMonitorService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.pubmatic.sdk.monitor.IPOBMonitorService
        public String getMonitorData() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IPOBMonitorService {

        private static class a implements IPOBMonitorService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7660a;

            a(IBinder iBinder) {
                this.f7660a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7660a;
            }

            @Override // com.pubmatic.sdk.monitor.IPOBMonitorService
            public String getMonitorData() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPOBMonitorService.DESCRIPTOR);
                    this.f7660a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPOBMonitorService.DESCRIPTOR);
        }

        public static IPOBMonitorService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPOBMonitorService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPOBMonitorService)) ? new a(iBinder) : (IPOBMonitorService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPOBMonitorService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPOBMonitorService.DESCRIPTOR);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            String monitorData = getMonitorData();
            parcel2.writeNoException();
            parcel2.writeString(monitorData);
            return true;
        }
    }

    String getMonitorData() throws RemoteException;
}
