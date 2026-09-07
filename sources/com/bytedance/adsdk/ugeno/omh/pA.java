package com.bytedance.adsdk.ugeno.omh;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes11.dex */
public abstract class pA implements Parcelable {
    private final Parcelable Og;
    public static final pA pA = new pA() { // from class: com.bytedance.adsdk.ugeno.omh.pA.1
    };
    public static final Parcelable.Creator<pA> CREATOR = new Parcelable.ClassLoaderCreator<pA>() { // from class: com.bytedance.adsdk.ugeno.omh.pA.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public pA createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public pA createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return pA.pA;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public pA[] newArray(int i) {
            return new pA[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private pA() {
        this.Og = null;
    }

    protected pA(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.Og = parcelable == pA ? null : parcelable;
    }

    protected pA(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.Og = parcelable == null ? pA : parcelable;
    }

    public final Parcelable pA() {
        return this.Og;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.Og, i);
    }
}
