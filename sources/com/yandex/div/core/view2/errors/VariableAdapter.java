package com.yandex.div.core.view2.errors;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.json.b9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableMonitorView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017BV\u0012O\u0010\u0004\u001aK\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016RW\u0010\u0004\u001aK\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/yandex/div/core/view2/errors/VariableModel;", "Lcom/yandex/div/core/view2/errors/VariableAdapter$VariableViewHolder;", "variableMutator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "path", "value", "", "Lcom/yandex/div/core/view2/errors/VariableMutator;", "(Lkotlin/jvm/functions/Function3;)V", "onBindViewHolder", "holder", b9.h.L, "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VariableDiffUtilCallback", "VariableViewHolder", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class VariableAdapter extends ListAdapter<VariableModel, VariableViewHolder> {
    private final Function3<String, String, String, Unit> variableMutator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VariableAdapter(Function3<? super String, ? super String, ? super String, Unit> variableMutator) {
        super(new VariableDiffUtilCallback());
        Intrinsics.checkNotNullParameter(variableMutator, "variableMutator");
        this.variableMutator = variableMutator;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VariableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new VariableViewHolder(new VariableView(context), this.variableMutator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VariableViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        VariableModel variableModel = getCurrentList().get(position);
        Intrinsics.checkNotNullExpressionValue(variableModel, "currentList[position]");
        holder.bind(variableModel);
    }

    /* JADX INFO: compiled from: VariableMonitorView.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012O\u0010\u0004\u001aK\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\u00020\u0006*\u00020\u0010H\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RW\u0010\u0004\u001aK\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableAdapter$VariableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Lcom/yandex/div/core/view2/errors/VariableView;", "variableMutator", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "path", "value", "", "Lcom/yandex/div/core/view2/errors/VariableMutator;", "(Lcom/yandex/div/core/view2/errors/VariableView;Lkotlin/jvm/functions/Function3;)V", "bind", "variable", "Lcom/yandex/div/core/view2/errors/VariableModel;", "fullName", "inputType", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VariableViewHolder extends RecyclerView.ViewHolder {
        private final VariableView root;
        private final Function3<String, String, String, Unit> variableMutator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public VariableViewHolder(VariableView root, Function3<? super String, ? super String, ? super String, Unit> variableMutator) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(variableMutator, "variableMutator");
            this.root = root;
            this.variableMutator = variableMutator;
        }

        public final void bind(final VariableModel variable) {
            Intrinsics.checkNotNullParameter(variable, "variable");
            VariableView variableView = this.root;
            variableView.getNameText().setText(fullName(variable));
            variableView.getTypeText().setText(variable.getType());
            variableView.getValueText().setText(variable.getValue());
            variableView.getValueText().setInputType(inputType(variable));
            variableView.setOnEnterAction(new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.errors.VariableAdapter$VariableViewHolder$bind$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String newValue) {
                    Intrinsics.checkNotNullParameter(newValue, "newValue");
                    this.this$0.variableMutator.invoke(variable.getName(), variable.getPath(), newValue);
                }
            });
        }

        private final String fullName(VariableModel variableModel) {
            return variableModel.getPath().length() > 0 ? variableModel.getPath() + '/' + variableModel.getName() : variableModel.getName();
        }

        private final int inputType(VariableModel variableModel) {
            String type = variableModel.getType();
            return Intrinsics.areEqual(type, "number") ? true : Intrinsics.areEqual(type, "integer") ? 2 : 1;
        }
    }

    /* JADX INFO: compiled from: VariableMonitorView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/errors/VariableAdapter$VariableDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/yandex/div/core/view2/errors/VariableModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class VariableDiffUtilCallback extends DiffUtil.ItemCallback<VariableModel> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(VariableModel oldItem, VariableModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getName(), newItem.getName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(VariableModel oldItem, VariableModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getValue(), newItem.getValue());
        }
    }
}
