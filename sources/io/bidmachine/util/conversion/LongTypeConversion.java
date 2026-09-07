package io.bidmachine.util.conversion;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LongTypeConversion.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0014¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/bidmachine/util/conversion/LongTypeConversion;", "Lio/bidmachine/util/conversion/BaseTypeConversion;", "", "()V", "to", "value", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "", "(Ljava/lang/String;)Ljava/lang/Long;", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LongTypeConversion extends BaseTypeConversion<Long> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.util.conversion.BaseTypeConversion
    public Long to(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (value instanceof String) {
            return (Long) TypeConversion.toOrDefault$default((TypeConversion) this, (String) value, (Object) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.util.conversion.BaseTypeConversion
    public Long to(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            LongTypeConversion longTypeConversion = this;
            return Long.valueOf(Long.parseLong(value));
        } catch (Throwable unused) {
            return null;
        }
    }
}
