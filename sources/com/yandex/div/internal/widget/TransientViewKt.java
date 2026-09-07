package com.yandex.div.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransientView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0004"}, d2 = {"isInTransientHierarchy", "", "Landroid/view/View;", "isTransient", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TransientViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isTransient(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view instanceof TransientView) && ((TransientView) view).isTransient();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isInTransientHierarchy(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!(view instanceof TransientView)) {
            return false;
        }
        if (((TransientView) view).isTransient()) {
            return true;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            return isInTransientHierarchy(viewGroup);
        }
        return false;
    }
}
