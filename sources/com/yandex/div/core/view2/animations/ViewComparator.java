package com.yandex.div.core.view2.animations;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ViewComparator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/view2/animations/ViewComparator;", "", "()V", "structureEquals", "", "Landroid/view/View;", "other", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewComparator {
    public static final ViewComparator INSTANCE = new ViewComparator();

    private ViewComparator() {
    }

    public final boolean structureEquals(View view, View other) {
        Object obj;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(view.getClass(), other.getClass())) {
            return false;
        }
        if (!(view instanceof ViewGroup) || !(other instanceof ViewGroup)) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        ViewGroup viewGroup2 = (ViewGroup) other;
        if (viewGroup.getChildCount() != viewGroup2.getChildCount()) {
            return false;
        }
        Iterator it = SequencesKt.map(SequencesKt.zip(ViewGroupKt.getChildren(viewGroup), ViewGroupKt.getChildren(viewGroup2)), new Function1<Pair<? extends View, ? extends View>, Boolean>() { // from class: com.yandex.div.core.view2.animations.ViewComparator.structureEquals.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Pair<? extends View, ? extends View> it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return Boolean.valueOf(ViewComparator.INSTANCE.structureEquals(it2.getFirst(), it2.getSecond()));
            }
        }).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Boolean.valueOf(((Boolean) next).booleanValue() && ((Boolean) it.next()).booleanValue());
            }
            obj = next;
        } else {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }
}
