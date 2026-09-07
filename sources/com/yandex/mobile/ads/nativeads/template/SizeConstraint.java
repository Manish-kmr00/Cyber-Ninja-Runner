package com.yandex.mobile.ads.nativeads.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.yandex.mobile.ads.impl.ha1;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint;", "Landroid/os/Parcelable;", "Lcom/yandex/mobile/ads/impl/ha1;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint$SizeConstraintType;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint$SizeConstraintType;", "getSizeConstraintType", "()Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint$SizeConstraintType;", "sizeConstraintType", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "F", "getValue", "()F", "value", "<init>", "(Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint$SizeConstraintType;F)V", "SizeConstraintType", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class SizeConstraint implements Parcelable, ha1 {
    public static final Parcelable.Creator<SizeConstraint> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final SizeConstraintType sizeConstraintType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float value;

    public static final class a implements Parcelable.Creator<SizeConstraint> {
        @Override // android.os.Parcelable.Creator
        public final SizeConstraint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SizeConstraint(SizeConstraintType.valueOf(parcel.readString()), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final SizeConstraint[] newArray(int i) {
            return new SizeConstraint[i];
        }
    }

    public SizeConstraint(SizeConstraintType sizeConstraintType, float f) {
        Intrinsics.checkNotNullParameter(sizeConstraintType, "sizeConstraintType");
        this.sizeConstraintType = sizeConstraintType;
        this.value = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(SizeConstraint.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.mobile.ads.nativeads.template.SizeConstraint");
        SizeConstraint sizeConstraint = (SizeConstraint) other;
        return getSizeConstraintType() == sizeConstraint.getSizeConstraintType() && getValue() == sizeConstraint.getValue();
    }

    @Override // com.yandex.mobile.ads.impl.ha1
    public float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.hashCode(getValue()) + (getSizeConstraintType().hashCode() * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.sizeConstraintType.name());
        parcel.writeFloat(this.value);
    }

    @Override // com.yandex.mobile.ads.impl.ha1
    public SizeConstraintType getSizeConstraintType() {
        return this.sizeConstraintType;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.nativeads.template.SizeConstraint$SizeConstraintType[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.nativeads.template.SizeConstraint$SizeConstraintType[]) from 0x002a: INVOKE (r0v1 com.yandex.mobile.ads.nativeads.template.SizeConstraint$SizeConstraintType[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yandex/mobile/ads/nativeads/template/SizeConstraint$SizeConstraintType;", "", "Lcom/yandex/mobile/ads/impl/ha1$b;", "FIXED", "FIXED_RATIO", "PREFERRED_RATIO", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SizeConstraintType implements ha1.b {
        FIXED(ha1.a.b),
        FIXED_RATIO(ha1.a.c),
        PREFERRED_RATIO(ha1.a.d);

        private final ha1.a b;

        static {
            EnumEntriesKt.enumEntries(sizeConstraintTypeArr);
        }

        public static SizeConstraintType valueOf(String str) {
            return (SizeConstraintType) Enum.valueOf(SizeConstraintType.class, str);
        }

        public static SizeConstraintType[] values() {
            return (SizeConstraintType[]) c.clone();
        }

        private SizeConstraintType(ha1.a aVar) {
            super(str, i);
            this.b = aVar;
        }

        @Override // com.yandex.mobile.ads.impl.ha1.b
        /* JADX INFO: renamed from: getType, reason: from getter */
        public final ha1.a getB() {
            return this.b;
        }
    }
}
