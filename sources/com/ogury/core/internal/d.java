package com.ogury.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvertisingInterface.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class d implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f7488a;
    public final String b;

    public d(IBinder binder, String descriptor) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f7488a = binder;
        this.b = descriptor;
    }

    public final String a() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
        try {
            parcelObtain.writeInterfaceToken(this.b);
            this.f7488a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            if (string == null) {
                string = "";
            }
            return string;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f7488a;
    }

    public final boolean b() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
        try {
            parcelObtain.writeInterfaceToken(this.b);
            parcelObtain.writeInt(1);
            this.f7488a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
