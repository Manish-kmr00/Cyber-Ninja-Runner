package com.yandex.div.core.view2;

import android.graphics.Typeface;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div2.DivFontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTypefaceResolver.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"getTypeface", "Landroid/graphics/Typeface;", "Lcom/yandex/div/core/view2/DivTypefaceResolver;", "fontFamily", "", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "", "(Lcom/yandex/div/core/view2/DivTypefaceResolver;Ljava/lang/String;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Long;)Landroid/graphics/Typeface;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivTypefaceResolverKt {
    public static final Typeface getTypeface(DivTypefaceResolver divTypefaceResolver, String str, DivFontWeight divFontWeight, Long l) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(divTypefaceResolver, "<this>");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return divTypefaceResolver.getTypeface$div_release(str, divFontWeight, numValueOf);
    }
}
