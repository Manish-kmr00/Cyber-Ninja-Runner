package com.yandex.div.core.state;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DivStateTransition.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¨\u0006\u0005"}, d2 = {"visit", "", "Landroid/view/View;", "callback", "Lkotlin/Function1;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivStateTransitionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void visit(View view, Function1<? super View, Unit> function1) {
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                visit(it.next(), function1);
            }
        }
        function1.invoke(view);
    }
}
