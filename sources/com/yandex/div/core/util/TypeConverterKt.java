package com.yandex.div.core.util;

import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import kotlin.Metadata;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, d2 = {"toIntSafely", "", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TypeConverterKt {
    public static final int toIntSafely(long j) {
        long j2 = j >> 31;
        if (j2 == 0 || j2 == -1) {
            return (int) j;
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("Unable convert '" + j + "' to Int");
        }
        return j > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }
}
