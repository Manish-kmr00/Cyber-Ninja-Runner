package com.yandex.div.core.view2.errors;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.data.Variable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableMonitorView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0001H\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u00140\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableMonitorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "variableMonitor", "Lcom/yandex/div/core/view2/errors/VariableMonitor;", "(Landroid/content/Context;Lcom/yandex/div/core/view2/errors/VariableMonitor;)V", "title", "variablesAdapter", "Lcom/yandex/div/core/view2/errors/VariableAdapter;", "createCellTitle", "Landroid/widget/TextView;", "", "createTable", "Landroidx/recyclerview/widget/RecyclerView;", "createTableTitle", "updateTable", "", "newList", "", "Lkotlin/Pair;", "Lcom/yandex/div/data/Variable;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VariableMonitorView extends LinearLayout {
    private final Context context;
    private final LinearLayout title;
    private final VariableAdapter variablesAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableMonitorView(Context context, VariableMonitor variableMonitor) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(variableMonitor, "variableMonitor");
        this.context = context;
        this.variablesAdapter = new VariableAdapter(new VariableMonitorView$variablesAdapter$1(variableMonitor));
        LinearLayout linearLayoutCreateTableTitle = createTableTitle();
        this.title = linearLayoutCreateTableTitle;
        setOrientation(1);
        variableMonitor.setVariablesUpdatedCallback(new AnonymousClass1(this));
        addView(linearLayoutCreateTableTitle, new LinearLayout.LayoutParams(-1, -2));
        addView(createTable(), new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: renamed from: com.yandex.div.core.view2.errors.VariableMonitorView$1, reason: invalid class name */
    /* JADX INFO: compiled from: VariableMonitorView.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<List<? extends Pair<? extends String, ? extends Variable>>, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, VariableMonitorView.class, "updateTable", "updateTable(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Pair<? extends String, ? extends Variable>> list) {
            invoke2((List<? extends Pair<String, ? extends Variable>>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Pair<String, ? extends Variable>> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((VariableMonitorView) this.receiver).updateTable(p0);
        }
    }

    private final LinearLayout createTableTitle() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{200, 60, 100});
        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"name", "type", "value"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf2, 10));
        Iterator it = listListOf2.iterator();
        while (it.hasNext()) {
            arrayList.add(createCellTitle((String) it.next()));
        }
        for (Pair pair : CollectionsKt.zip(arrayList, listListOf)) {
            TextView textView = (TextView) pair.component1();
            Integer numValueOf = Integer.valueOf(((Number) pair.component2()).intValue());
            DisplayMetrics displayMetrics = linearLayout.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            linearLayout.addView(textView, new LinearLayout.LayoutParams(BaseDivViewExtensionsKt.dpToPx(numValueOf, displayMetrics), -2));
        }
        return linearLayout;
    }

    private final RecyclerView createTable() {
        RecyclerView recyclerView = new RecyclerView(this.context);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.variablesAdapter);
        recyclerView.setBackgroundColor(Color.argb(50, 0, 0, 0));
        return recyclerView;
    }

    private final TextView createCellTitle(String title) {
        TextView textView = new TextView(this.context);
        DisplayMetrics displayMetrics = textView.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx((Integer) 8, displayMetrics);
        textView.setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        textView.setTextColor(-1);
        textView.setText(title);
        textView.setTypeface(textView.getTypeface(), 1);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTable(List<? extends Pair<String, ? extends Variable>> newList) {
        VariableAdapter variableAdapter = this.variablesAdapter;
        List<? extends Pair<String, ? extends Variable>> list = newList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(VariableMonitorViewKt.toModel((Variable) pair.component2(), (String) pair.component1()));
        }
        variableAdapter.submitList(arrayList, new Runnable() { // from class: com.yandex.div.core.view2.errors.VariableMonitorView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VariableMonitorView.updateTable$lambda$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTable$lambda$5(VariableMonitorView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.title.setVisibility(this$0.variablesAdapter.getItemCount() != 0 ? 0 : 8);
    }
}
