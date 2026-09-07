package com.monetization.ads.core.identifiers.ad.huawei;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unity3d.services.core.di.ServiceProvider;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078fX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/core/identifiers/ad/huawei/OpenDeviceIdentifierService;", "Landroid/os/IInterface;", CommonUrlParts.HUAWEI_OAID, "", "getOaid", "()Ljava/lang/String;", "oaidTrackLimited", "", "getOaidTrackLimited", "()Z", "Stub", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OpenDeviceIdentifierService extends IInterface {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/monetization/ads/core/identifiers/ad/huawei/OpenDeviceIdentifierService$Stub;", "Landroid/os/Binder;", "Lcom/monetization/ads/core/identifiers/ad/huawei/OpenDeviceIdentifierService;", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "<init>", "()V", "Proxy", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f7206a = 0;

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/core/identifiers/ad/huawei/OpenDeviceIdentifierService$Stub$Proxy;", "Lcom/monetization/ads/core/identifiers/ad/huawei/OpenDeviceIdentifierService;", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "", "getOaid", "()Ljava/lang/String;", CommonUrlParts.HUAWEI_OAID, "", "getOaidTrackLimited", "()Z", "oaidTrackLimited", ServiceProvider.NAMED_REMOTE, "<init>", "(Landroid/os/IBinder;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
        static final class Proxy implements OpenDeviceIdentifierService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IBinder f7207a;

            public Proxy(IBinder remote) {
                Intrinsics.checkNotNullParameter(remote, "remote");
                this.f7207a = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7207a;
            }

            @Override // com.monetization.ads.core.identifiers.ad.huawei.OpenDeviceIdentifierService
            public String getOaid() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f7207a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.monetization.ads.core.identifiers.ad.huawei.OpenDeviceIdentifierService
            public boolean getOaidTrackLimited() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f7207a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        protected final boolean onTransact(int i, Parcel data, Parcel parcel, int i2) throws RemoteException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (i == 1) {
                data.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String oaid = getOaid();
                if (parcel != null) {
                    parcel.writeNoException();
                }
                if (parcel == null) {
                    return true;
                }
                parcel.writeString(oaid);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, data, parcel, i2);
                }
                if (parcel == null) {
                    return true;
                }
                parcel.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            data.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean oaidTrackLimited = getOaidTrackLimited();
            if (parcel != null) {
                parcel.writeNoException();
            }
            if (parcel == null) {
                return true;
            }
            parcel.writeInt(oaidTrackLimited ? 1 : 0);
            return true;
        }
    }

    String getOaid() throws RemoteException;

    boolean getOaidTrackLimited() throws RemoteException;
}
