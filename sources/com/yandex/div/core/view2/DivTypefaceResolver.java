package com.yandex.div.core.view2;

import android.graphics.Typeface;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div2.DivFontWeight;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTypefaceResolver.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/DivTypefaceResolver;", "", "typefaceProviders", "", "", "Lcom/yandex/div/core/font/DivTypefaceProvider;", "defaultTypeface", "(Ljava/util/Map;Lcom/yandex/div/core/font/DivTypefaceProvider;)V", "getTypeface", "Landroid/graphics/Typeface;", "fontFamily", "fontWeight", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "", "getTypeface$div_release", "(Ljava/lang/String;Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;)Landroid/graphics/Typeface;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivTypefaceResolver {
    private final DivTypefaceProvider defaultTypeface;
    private final Map<String, DivTypefaceProvider> typefaceProviders;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public DivTypefaceResolver(Map<String, ? extends DivTypefaceProvider> typefaceProviders, DivTypefaceProvider defaultTypeface) {
        Intrinsics.checkNotNullParameter(typefaceProviders, "typefaceProviders");
        Intrinsics.checkNotNullParameter(defaultTypeface, "defaultTypeface");
        this.typefaceProviders = typefaceProviders;
        this.defaultTypeface = defaultTypeface;
    }

    public Typeface getTypeface$div_release(String fontFamily, int fontWeightValue) {
        DivTypefaceProvider divTypefaceProvider;
        if (fontFamily == null || (divTypefaceProvider = this.typefaceProviders.get(fontFamily)) == null) {
            divTypefaceProvider = this.defaultTypeface;
        }
        return BaseDivViewExtensionsKt.getTypeface(fontWeightValue, divTypefaceProvider);
    }

    public Typeface getTypeface$div_release(String fontFamily, DivFontWeight fontWeight, Integer fontWeightValue) {
        DivTypefaceProvider divTypefaceProvider;
        if (fontFamily == null || (divTypefaceProvider = this.typefaceProviders.get(fontFamily)) == null) {
            divTypefaceProvider = this.defaultTypeface;
        }
        return BaseDivViewExtensionsKt.getTypeface(BaseDivViewExtensionsKt.getTypefaceValue(fontWeight, fontWeightValue), divTypefaceProvider);
    }
}
