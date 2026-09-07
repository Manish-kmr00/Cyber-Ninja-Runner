package com.yandex.div.core.view2.reuse;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.safedk.android.analytics.brandsafety.l;
import com.yandex.div2.Div;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: ReusableTokenList.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0007R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/core/view2/reuse/ReusableTokenList;", "", "()V", "reusable", "Ljava/util/HashMap;", "", "Ljava/util/LinkedList;", "Lcom/yandex/div/core/view2/reuse/ExistingToken;", "Lkotlin/collections/HashMap;", "viewIndexShift", "", l.l, "", "token", "asList", "", "clear", "contains", "", "div", "Lcom/yandex/div2/Div;", "hash", "count", "get", "getUniqueViewForDiv", "Landroid/view/View;", "isEmpty", "pop", "remove", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReusableTokenList {
    private final HashMap<Integer, LinkedList<ExistingToken>> reusable = new HashMap<>();
    private final Map<Integer, Integer> viewIndexShift = new LinkedHashMap();

    public final int count() {
        return this.reusable.size();
    }

    public final boolean isEmpty() {
        return this.reusable.isEmpty();
    }

    public final List<ExistingToken> asList() {
        Collection<LinkedList<ExistingToken>> collectionValues = this.reusable.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "reusable.values");
        return CollectionsKt.flatten(collectionValues);
    }

    public final boolean contains(int hash) {
        return this.reusable.containsKey(Integer.valueOf(hash));
    }

    public final boolean contains(Div div) {
        Intrinsics.checkNotNullParameter(div, "div");
        return this.reusable.containsKey(Integer.valueOf(div.propertiesHash()));
    }

    public final void add(ExistingToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        int divHash = token.getDivHash();
        HashMap<Integer, LinkedList<ExistingToken>> map = this.reusable;
        Integer numValueOf = Integer.valueOf(divHash);
        LinkedList<ExistingToken> linkedList = map.get(numValueOf);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            map.put(numValueOf, linkedList);
        }
        linkedList.add(token);
    }

    public final ExistingToken pop(int hash) {
        LinkedList<ExistingToken> linkedList = this.reusable.get(Integer.valueOf(hash));
        LinkedList<ExistingToken> linkedList2 = linkedList;
        if (linkedList2 == null || linkedList2.isEmpty()) {
            return null;
        }
        ExistingToken existingTokenPop = linkedList.pop();
        LinkedList<ExistingToken> linkedList3 = this.reusable.get(Integer.valueOf(hash));
        if (linkedList3 == null || linkedList3.isEmpty()) {
            this.reusable.remove(Integer.valueOf(hash));
        }
        return existingTokenPop;
    }

    public final ExistingToken pop(Div div) {
        Intrinsics.checkNotNullParameter(div, "div");
        return pop(div.propertiesHash());
    }

    public final ExistingToken get(Div div) {
        Intrinsics.checkNotNullParameter(div, "div");
        LinkedList<ExistingToken> linkedList = this.reusable.get(Integer.valueOf(div.propertiesHash()));
        if (linkedList != null) {
            return (ExistingToken) CollectionsKt.firstOrNull((List) linkedList);
        }
        return null;
    }

    public final View getUniqueViewForDiv(Div div) {
        ExistingToken existingToken;
        Intrinsics.checkNotNullParameter(div, "div");
        int iPropertiesHash = div.propertiesHash();
        Map<Integer, Integer> map = this.viewIndexShift;
        Integer numValueOf = Integer.valueOf(iPropertiesHash);
        Integer num = map.get(numValueOf);
        if (num == null) {
            num = 0;
            map.put(numValueOf, num);
        }
        int iIntValue = num.intValue();
        LinkedList<ExistingToken> linkedList = this.reusable.get(Integer.valueOf(iPropertiesHash));
        if (linkedList == null || (existingToken = (ExistingToken) CollectionsKt.getOrNull(linkedList, iIntValue)) == null) {
            return null;
        }
        this.viewIndexShift.put(Integer.valueOf(iPropertiesHash), Integer.valueOf(iIntValue + 1));
        ViewParent parent = existingToken.getView().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(existingToken.getView());
        }
        return existingToken.getView();
    }

    public final boolean remove(ExistingToken token) {
        Object next;
        Intrinsics.checkNotNullParameter(token, "token");
        LinkedList<ExistingToken> linkedList = this.reusable.get(Integer.valueOf(token.getDivHash()));
        if (linkedList == null) {
            return false;
        }
        LinkedList<ExistingToken> linkedList2 = linkedList;
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((ExistingToken) next).getView(), token.getView())) {
                return TypeIntrinsics.asMutableCollection(linkedList2).remove(next);
            }
        }
        next = null;
        return TypeIntrinsics.asMutableCollection(linkedList2).remove(next);
    }

    public final void clear() {
        this.reusable.clear();
        this.viewIndexShift.clear();
    }
}
