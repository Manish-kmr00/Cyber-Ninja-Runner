package com.monetization.ads.core.identifiers.ad.gms.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.rc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/monetization/ads/core/identifiers/ad/gms/service/GmsServiceAdvertisingInfoReader;", "Lcom/yandex/mobile/ads/impl/rc;", "Landroid/os/IInterface;", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "", "readAdvertisingId", "()Ljava/lang/String;", "", "readAdTrackingLimited", "()Ljava/lang/Boolean;", "binder", "<init>", "(Landroid/os/IBinder;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class GmsServiceAdvertisingInfoReader implements rc, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f7205a;

    public GmsServiceAdvertisingInfoReader(IBinder binder) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.f7205a = binder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f7205a;
    }

    @Override // com.yandex.mobile.ads.impl.rc
    public Boolean readAdTrackingLimited() {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
        try {
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                parcelObtain.writeInt(1);
                this.f7205a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() == 0) {
                    z = false;
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return boolValueOf;
            } catch (Throwable unused) {
                op0.c(new Object[0]);
                return null;
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // com.yandex.mobile.ads.impl.rc
    public String readAdvertisingId() {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        Parcel parcelObtain2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain(...)");
        try {
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f7205a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable unused) {
                op0.c(new Object[0]);
                return null;
            }
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
