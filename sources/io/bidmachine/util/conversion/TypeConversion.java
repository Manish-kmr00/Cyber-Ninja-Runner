package io.bidmachine.util.conversion;

import com.pubmatic.sdk.nativead.POBNativeConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: TypeConversion.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006J%\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/conversion/TypeConversion;", "T", "", "toOrDefault", "value", POBNativeConstants.NATIVE_FALLBACK_URL, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TypeConversion<T> {
    T toOrDefault(Object value, T fallback);

    T toOrDefault(String value, T fallback);

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object toOrDefault$default(TypeConversion typeConversion, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toOrDefault");
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        return typeConversion.toOrDefault(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object toOrDefault$default(TypeConversion typeConversion, String str, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toOrDefault");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        return typeConversion.toOrDefault(str, obj);
    }
}
