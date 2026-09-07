package com.yandex.div.core.view2.errors;

import com.yandex.div.core.Disposable;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.Binding;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.util.JsonNode;
import com.yandex.div.json.ParsingException;
import com.yandex.div2.DivData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ErrorVisualMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002J\u0010\u0010%\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020\u0007J\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(J\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010+\u001a\u00020\u0013J\u001a\u0010,\u001a\u00020\u000e2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010.\u001a\u00020\u0013J\u0016\u0010/\u001a\u00020#2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\u0004\u0012\u00020\u00130\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorModel;", "", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "visualErrorsEnabled", "", "(Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/view2/Div2View;Z)V", "currentErrors", "", "", "currentWarnings", "existingSubscription", "Lcom/yandex/div/core/Disposable;", "observers", "", "Lkotlin/Function1;", "Lcom/yandex/div/core/view2/errors/ErrorViewModel;", "", "value", "state", "setState", "(Lcom/yandex/div/core/view2/errors/ErrorViewModel;)V", "updateOnErrors", "Lkotlin/Function2;", "", "bind", "binding", "Lcom/yandex/div/core/view2/Binding;", "dumpCardWithContextVariables", "Lorg/json/JSONObject;", "dumpGlobalVariables", "Lorg/json/JSONArray;", "errorsToDetails", "", "errors", "generateReport", "dumpCardContent", "getAllControllers", "", "Lcom/yandex/div/core/expression/variables/VariableController;", "getErrorHandler", "hideDetails", "observeAndGet", "observer", "showDetails", "warningsToDetails", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorModel {
    private final List<Throwable> currentErrors;
    private final List<Throwable> currentWarnings;
    private final Div2View div2View;
    private final ErrorCollectors errorCollectors;
    private Disposable existingSubscription;
    private final Set<Function1<ErrorViewModel, Unit>> observers;
    private ErrorViewModel state;
    private final Function2<List<? extends Throwable>, List<? extends Throwable>, Unit> updateOnErrors;
    private final boolean visualErrorsEnabled;

    public ErrorModel(ErrorCollectors errorCollectors, Div2View div2View, boolean z) {
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        this.errorCollectors = errorCollectors;
        this.div2View = div2View;
        this.visualErrorsEnabled = z;
        this.observers = new LinkedHashSet();
        this.currentErrors = new ArrayList();
        this.currentWarnings = new ArrayList();
        this.updateOnErrors = new Function2<List<? extends Throwable>, List<? extends Throwable>, Unit>() { // from class: com.yandex.div.core.view2.errors.ErrorModel$updateOnErrors$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Throwable> list, List<? extends Throwable> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Throwable> errors, List<? extends Throwable> warnings) {
                Intrinsics.checkNotNullParameter(errors, "errors");
                Intrinsics.checkNotNullParameter(warnings, "warnings");
                if (this.this$0.visualErrorsEnabled) {
                    List list = this.this$0.currentErrors;
                    list.clear();
                    list.addAll(CollectionsKt.reversed(errors));
                    List list2 = this.this$0.currentWarnings;
                    list2.clear();
                    list2.addAll(CollectionsKt.reversed(warnings));
                    ErrorModel errorModel = this.this$0;
                    ErrorViewModel errorViewModel = errorModel.state;
                    int size = this.this$0.currentErrors.size();
                    ErrorModel errorModel2 = this.this$0;
                    String strErrorsToDetails = errorModel2.errorsToDetails(errorModel2.currentErrors);
                    int size2 = this.this$0.currentWarnings.size();
                    ErrorModel errorModel3 = this.this$0;
                    errorModel.setState(ErrorViewModel.copy$default(errorViewModel, false, size, size2, strErrorsToDetails, errorModel3.warningsToDetails(errorModel3.currentWarnings), 1, null));
                }
            }
        };
        this.state = new ErrorViewModel(false, 0, 0, null, null, 31, null);
    }

    public final void bind(Binding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Disposable disposable = this.existingSubscription;
        if (disposable != null) {
            disposable.close();
        }
        this.existingSubscription = this.errorCollectors.getOrCreate(binding.getTag(), binding.getData()).observeAndGet(this.updateOnErrors);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String errorsToDetails(List<? extends Throwable> errors) {
        return "Last 25 errors:\n" + CollectionsKt.joinToString$default(CollectionsKt.take(errors, 25), "\n", null, null, 0, null, new Function1<Throwable, CharSequence>() { // from class: com.yandex.div.core.view2.errors.ErrorModel$errorsToDetails$errorsList$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it instanceof ParsingException ? " - " + ((ParsingException) it).getReason() + ": " + ErrorVisualMonitorKt.getFullStackMessage(it) : " - " + ErrorVisualMonitorKt.getFullStackMessage(it);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String warningsToDetails(List<? extends Throwable> currentWarnings) {
        return "Last 25 warnings:\n" + CollectionsKt.joinToString$default(CollectionsKt.take(currentWarnings, 25), "\n", null, null, 0, null, new Function1<Throwable, CharSequence>() { // from class: com.yandex.div.core.view2.errors.ErrorModel$warningsToDetails$warningsList$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return " - " + ErrorVisualMonitorKt.getFullStackMessage(it);
            }
        }, 30, null);
    }

    public final Disposable observeAndGet(final Function1<? super ErrorViewModel, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
        observer.invoke(this.state);
        return new Disposable() { // from class: com.yandex.div.core.view2.errors.ErrorModel$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                ErrorModel.observeAndGet$lambda$0(this.f$0, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAndGet$lambda$0(ErrorModel this$0, Function1 observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        this$0.observers.remove(observer);
    }

    public final void showDetails() {
        setState(ErrorViewModel.copy$default(this.state, true, 0, 0, null, null, 30, null));
    }

    public final void hideDetails() {
        setState(ErrorViewModel.copy$default(this.state, false, 0, 0, null, null, 30, null));
    }

    public static /* synthetic */ String generateReport$default(ErrorModel errorModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return errorModel.generateReport(z);
    }

    public final String generateReport(boolean dumpCardContent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.currentErrors.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Throwable th : this.currentErrors) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", ErrorVisualMonitorKt.getFullStackMessage(th));
                jSONObject2.put("stacktrace", ExceptionsKt.stackTraceToString(th));
                if (th instanceof ParsingException) {
                    ParsingException parsingException = (ParsingException) th;
                    jSONObject2.put("reason", parsingException.getReason());
                    JsonNode source = parsingException.getSource();
                    jSONObject2.put("json_source", source != null ? source.dump() : null);
                    jSONObject2.put("json_summary", parsingException.getJsonSummary());
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("errors", jSONArray);
        }
        if (this.currentWarnings.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (Throwable th2 : this.currentWarnings) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("warning_message", th2.getMessage());
                jSONObject3.put("stacktrace", ExceptionsKt.stackTraceToString(th2));
                jSONArray2.put(jSONObject3);
            }
            jSONObject.put("warnings", jSONArray2);
        }
        if (dumpCardContent) {
            jSONObject.put("card", dumpCardWithContextVariables());
        }
        String string = jSONObject.toString(4);
        Intrinsics.checkNotNullExpressionValue(string, "results.toString(/*indentSpaces*/ 4)");
        return string;
    }

    public final Map<String, VariableController> getAllControllers() {
        RuntimeStore runtimeStore = this.div2View.getRuntimeStore();
        if (runtimeStore == null) {
            return MapsKt.emptyMap();
        }
        Map<String, ExpressionsRuntime> uniquePathsAndRuntimes$div_release = runtimeStore.getUniquePathsAndRuntimes$div_release();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ExpressionsRuntime rootRuntime = runtimeStore.getRootRuntime();
        if (rootRuntime != null) {
            linkedHashMap.put("", rootRuntime.getVariableController());
        }
        for (Map.Entry<String, ExpressionsRuntime> entry : uniquePathsAndRuntimes$div_release.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().getVariableController());
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: com.yandex.div.core.view2.errors.ErrorModel$getErrorHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: ErrorVisualMonitor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, DivActionTypedUtilsKt.class, "logError", "logError(Lcom/yandex/div/core/view2/Div2View;Ljava/lang/Throwable;)V", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            DivActionTypedUtilsKt.logError((Div2View) this.receiver, p0);
        }
    }

    public final Function1<Throwable, Unit> getErrorHandler() {
        return new AnonymousClass1(this.div2View);
    }

    private final JSONObject dumpCardWithContextVariables() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("templates", new JSONObject());
        DivData divData = this.div2View.getDivData();
        jSONObject.put("card", divData != null ? divData.writeToJSON() : null);
        jSONObject.put("variables", dumpGlobalVariables());
        return jSONObject;
    }

    private final JSONArray dumpGlobalVariables() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.div2View.getDiv2Component().getDivVariableController().captureAllVariables$div_release().iterator();
        while (it.hasNext()) {
            jSONArray.put(((Variable) it.next()).writeToJSON());
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(ErrorViewModel errorViewModel) {
        this.state = errorViewModel;
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(errorViewModel);
        }
    }
}
