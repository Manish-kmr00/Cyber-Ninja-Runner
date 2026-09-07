package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fa2 implements Parcelable {
    public static final Parcelable.Creator<fa2> CREATOR = new a();
    private final b b;
    private final float c;

    public static final class a implements Parcelable.Creator<fa2> {
        @Override // android.os.Parcelable.Creator
        public final fa2 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "source");
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new fa2(parcel.readInt() == -1 ? null : b.values()[parcel.readInt()], parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final fa2[] newArray(int i) {
            return new fa2[i];
        }

        a() {
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.fa2$b[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.fa2$b[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.fa2$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        b,
        c,
        d;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }

        private b() {
            super(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        b bVar = this.b;
        dest.writeInt(bVar != null ? bVar.ordinal() : -1);
        dest.writeFloat(this.c);
    }

    public fa2(b bVar, float f) {
        this.b = bVar;
        this.c = f;
    }

    public final b c() {
        return this.b;
    }

    public final float d() {
        return this.c;
    }
}
