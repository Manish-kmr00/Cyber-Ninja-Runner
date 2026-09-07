package com.yandex.div.core.view2.divs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.yandex.div.R;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DivActionBinder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a8\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"isPenetratingLongClickable", "", "Landroid/view/View;", "observe", "", "actions", "", "Lcom/yandex/div2/DivAction;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "callback", "Lkotlin/Function1;", "", "onlyEnabled", "parentIsLongClickable", "setPenetratingLongClickable", "longClickable", "(Landroid/view/View;Ljava/lang/Boolean;)V", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivActionBinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void observe(View view, List<DivAction> list, ExpressionResolver expressionResolver, Function1<Object, Unit> function1) {
        if ((view instanceof ExpressionSubscriber) && list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ExpressionSubscriber) view).addSubscription(((DivAction) it.next()).isEnabled.observe(expressionResolver, function1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DivAction> onlyEnabled(List<DivAction> list, ExpressionResolver expressionResolver) {
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((DivAction) obj).isEnabled.evaluate(expressionResolver).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parentIsLongClickable(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        ViewGroup viewGroup2 = viewGroup;
        return isPenetratingLongClickable(viewGroup2) || parentIsLongClickable(viewGroup2);
    }

    private static final boolean isPenetratingLongClickable(View view) {
        Object tag = view.getTag(R.id.div_penetrating_longtap_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    static /* synthetic */ void setPenetratingLongClickable$default(View view, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = true;
        }
        setPenetratingLongClickable(view, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPenetratingLongClickable(View view, Boolean bool) {
        view.setTag(R.id.div_penetrating_longtap_tag, bool);
    }
}
