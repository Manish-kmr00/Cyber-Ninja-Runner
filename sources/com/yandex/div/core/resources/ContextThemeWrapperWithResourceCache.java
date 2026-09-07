package com.yandex.div.core.resources;

import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.view.ContextThemeWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextThemeWrapperWithResourceCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\bH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/resources/ContextThemeWrapperWithResourceCache;", "Landroidx/appcompat/view/ContextThemeWrapper;", "baseContext", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "resourceCache", "Landroid/content/res/Resources;", "getResourceCache", "()Landroid/content/res/Resources;", "resourceCache$delegate", "Lkotlin/Lazy;", "getResources", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextThemeWrapperWithResourceCache extends ContextThemeWrapper {

    /* JADX INFO: renamed from: resourceCache$delegate, reason: from kotlin metadata */
    private final Lazy resourceCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextThemeWrapperWithResourceCache(Context baseContext, int i) {
        super(baseContext, i);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        this.resourceCache = LazyKt.lazy(new Function0<PrimitiveResourceCache>() { // from class: com.yandex.div.core.resources.ContextThemeWrapperWithResourceCache$resourceCache$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PrimitiveResourceCache invoke() {
                Resources resources = super/*androidx.appcompat.view.ContextThemeWrapper*/.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
                return new PrimitiveResourceCache(resources);
            }
        });
    }

    private final Resources getResourceCache() {
        return (Resources) this.resourceCache.getValue();
    }

    @Override // androidx.appcompat.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourceCache();
    }
}
