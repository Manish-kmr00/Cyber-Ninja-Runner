package com.yandex.div.internal.viewpool.optimization;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.gms.common.Scopes;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.Names;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.viewpool.ViewPreCreationProfile;
import com.yandex.div.logging.Severity;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.WeakHashMap;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JvmStreamsKt;

/* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileRepository;", "", "context", "Landroid/content/Context;", "defaultProfile", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "(Landroid/content/Context;Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;)V", "get", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", Scopes.PROFILE, "(Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ViewPreCreationProfileSerializer", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class ViewPreCreationProfileRepository {

    @Deprecated
    public static final String STORE_PATH = "divkit_optimized_viewpool_profile_%s.json";

    @Deprecated
    public static final String TAG = "OptimizedViewPreCreationProfileRepository";
    private final Context context;
    private final ViewPreCreationProfile defaultProfile;
    private static final Companion Companion = new Companion(null);
    private static final WeakHashMap<String, DataStore<ViewPreCreationProfile>> stores = new WeakHashMap<>();

    public Object get(String str, Continuation<? super ViewPreCreationProfile> continuation) {
        return get$suspendImpl(this, str, continuation);
    }

    public Object save(ViewPreCreationProfile viewPreCreationProfile, Continuation<? super Boolean> continuation) {
        return save$suspendImpl(this, viewPreCreationProfile, continuation);
    }

    @Inject
    public ViewPreCreationProfileRepository(@Named(Names.APP_CONTEXT) Context context, ViewPreCreationProfile defaultProfile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultProfile, "defaultProfile");
        this.context = context;
        this.defaultProfile = defaultProfile;
    }

    /* JADX INFO: renamed from: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$get$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$get$2", f = "ViewPreCreationProfileRepository.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewPreCreationProfile>, Object> {
        final /* synthetic */ String $id;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ViewPreCreationProfileRepository.this.new AnonymousClass2(this.$id, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ViewPreCreationProfile> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7904constructorimpl;
            Object objFirst;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewPreCreationProfileRepository viewPreCreationProfileRepository = ViewPreCreationProfileRepository.this;
                    String str = this.$id;
                    Result.Companion companion = Result.INSTANCE;
                    Flow<ViewPreCreationProfile> data = ViewPreCreationProfileRepository.Companion.getStoreForId(viewPreCreationProfileRepository.context, str).getData();
                    this.label = 1;
                    objFirst = FlowKt.first(data, this);
                    if (objFirst == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objFirst = obj;
                }
                objM7904constructorimpl = Result.m7904constructorimpl((ViewPreCreationProfile) objFirst);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null && KLog.INSTANCE.isAtLeast(Severity.ERROR)) {
                Log.e(ViewPreCreationProfileRepository.TAG, "", thM7907exceptionOrNullimpl);
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            ViewPreCreationProfile viewPreCreationProfile = (ViewPreCreationProfile) objM7904constructorimpl;
            if (viewPreCreationProfile != null) {
                return viewPreCreationProfile;
            }
            ViewPreCreationProfile viewPreCreationProfile2 = ViewPreCreationProfileRepository.this.defaultProfile;
            return viewPreCreationProfile2.copy((524286 & 1) != 0 ? viewPreCreationProfile2.id : this.$id, (524286 & 2) != 0 ? viewPreCreationProfile2.text : null, (524286 & 4) != 0 ? viewPreCreationProfile2.image : null, (524286 & 8) != 0 ? viewPreCreationProfile2.gifImage : null, (524286 & 16) != 0 ? viewPreCreationProfile2.overlapContainer : null, (524286 & 32) != 0 ? viewPreCreationProfile2.linearContainer : null, (524286 & 64) != 0 ? viewPreCreationProfile2.wrapContainer : null, (524286 & 128) != 0 ? viewPreCreationProfile2.grid : null, (524286 & 256) != 0 ? viewPreCreationProfile2.gallery : null, (524286 & 512) != 0 ? viewPreCreationProfile2.pager : null, (524286 & 1024) != 0 ? viewPreCreationProfile2.tab : null, (524286 & 2048) != 0 ? viewPreCreationProfile2.state : null, (524286 & 4096) != 0 ? viewPreCreationProfile2.custom : null, (524286 & 8192) != 0 ? viewPreCreationProfile2.indicator : null, (524286 & 16384) != 0 ? viewPreCreationProfile2.slider : null, (524286 & 32768) != 0 ? viewPreCreationProfile2.input : null, (524286 & 65536) != 0 ? viewPreCreationProfile2.select : null, (524286 & 131072) != 0 ? viewPreCreationProfile2.video : null, (524286 & 262144) != 0 ? viewPreCreationProfile2.switch : null);
        }
    }

    static /* synthetic */ Object get$suspendImpl(ViewPreCreationProfileRepository viewPreCreationProfileRepository, String str, Continuation<? super ViewPreCreationProfile> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), viewPreCreationProfileRepository.new AnonymousClass2(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$save$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$save$2", f = "ViewPreCreationProfileRepository.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    static final class C39502 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ViewPreCreationProfile $profile;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C39502(ViewPreCreationProfile viewPreCreationProfile, Continuation<? super C39502> continuation) {
            super(2, continuation);
            this.$profile = viewPreCreationProfile;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C39502 c39502 = ViewPreCreationProfileRepository.this.new C39502(this.$profile, continuation);
            c39502.L$0 = obj;
            return c39502;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C39502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7904constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewPreCreationProfileRepository viewPreCreationProfileRepository = ViewPreCreationProfileRepository.this;
                    ViewPreCreationProfile viewPreCreationProfile = this.$profile;
                    Result.Companion companion = Result.INSTANCE;
                    Companion companion2 = ViewPreCreationProfileRepository.Companion;
                    Context context = viewPreCreationProfileRepository.context;
                    String id = viewPreCreationProfile.getId();
                    Intrinsics.checkNotNull(id);
                    DataStore<ViewPreCreationProfile> storeForId = companion2.getStoreForId(context, id);
                    ViewPreCreationProfileRepository$save$2$1$1 viewPreCreationProfileRepository$save$2$1$1 = new ViewPreCreationProfileRepository$save$2$1$1(viewPreCreationProfile, null);
                    this.label = 1;
                    obj = storeForId.updateData(viewPreCreationProfileRepository$save$2$1$1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM7904constructorimpl = Result.m7904constructorimpl((ViewPreCreationProfile) obj);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null && KLog.INSTANCE.isAtLeast(Severity.ERROR)) {
                Log.e(ViewPreCreationProfileRepository.TAG, "", thM7907exceptionOrNullimpl);
            }
            return Boxing.boxBoolean(Result.m7911isSuccessimpl(objM7904constructorimpl));
        }
    }

    static /* synthetic */ Object save$suspendImpl(ViewPreCreationProfileRepository viewPreCreationProfileRepository, ViewPreCreationProfile viewPreCreationProfile, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), viewPreCreationProfileRepository.new C39502(viewPreCreationProfile, null), continuation);
    }

    /* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileRepository$ViewPreCreationProfileSerializer;", "Landroidx/datastore/core/Serializer;", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "()V", "defaultValue", "getDefaultValue", "()Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "json", "Lkotlinx/serialization/json/Json;", "readFrom", "input", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "output", "Ljava/io/OutputStream;", "(Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ViewPreCreationProfileSerializer implements Serializer<ViewPreCreationProfile> {
        private static final ViewPreCreationProfile defaultValue = null;
        public static final ViewPreCreationProfileSerializer INSTANCE = new ViewPreCreationProfileSerializer();
        private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$ViewPreCreationProfileSerializer$json$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setEncodeDefaults(false);
            }
        }, 1, null);

        private ViewPreCreationProfileSerializer() {
        }

        @Override // androidx.datastore.core.Serializer
        public /* bridge */ /* synthetic */ Object writeTo(ViewPreCreationProfile viewPreCreationProfile, OutputStream outputStream, Continuation continuation) {
            return writeTo2(viewPreCreationProfile, outputStream, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.datastore.core.Serializer
        public ViewPreCreationProfile getDefaultValue() {
            return defaultValue;
        }

        @Override // androidx.datastore.core.Serializer
        public Object readFrom(InputStream inputStream, Continuation<? super ViewPreCreationProfile> continuation) {
            Object objM7904constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                ViewPreCreationProfileSerializer viewPreCreationProfileSerializer = this;
                Json json2 = json;
                objM7904constructorimpl = Result.m7904constructorimpl((ViewPreCreationProfile) JvmStreamsKt.decodeFromStream(json2, SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(ViewPreCreationProfile.class)), inputStream));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null && KLog.INSTANCE.isAtLeast(Severity.ERROR)) {
                Log.e(ViewPreCreationProfileRepository.TAG, "", thM7907exceptionOrNullimpl);
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                return null;
            }
            return objM7904constructorimpl;
        }

        /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
        public Object writeTo2(ViewPreCreationProfile viewPreCreationProfile, OutputStream outputStream, Continuation<? super Unit> continuation) {
            Object objM7904constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                ViewPreCreationProfileSerializer viewPreCreationProfileSerializer = this;
                Json json2 = json;
                JvmStreamsKt.encodeToStream(json2, SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(ViewPreCreationProfile.class)), viewPreCreationProfile, outputStream);
                objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null && KLog.INSTANCE.isAtLeast(Severity.ERROR)) {
                Log.e(ViewPreCreationProfileRepository.TAG, "", thM7907exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ViewPreCreationProfileRepository.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/internal/viewpool/optimization/ViewPreCreationProfileRepository$Companion;", "", "()V", "STORE_PATH", "", "TAG", "stores", "Ljava/util/WeakHashMap;", "Landroidx/datastore/core/DataStore;", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "getStores", "()Ljava/util/WeakHashMap;", "getStoreForId", "Landroid/content/Context;", "id", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeakHashMap<String, DataStore<ViewPreCreationProfile>> getStores() {
            return ViewPreCreationProfileRepository.stores;
        }

        public final DataStore<ViewPreCreationProfile> getStoreForId(final Context context, final String id) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(id, "id");
            WeakHashMap<String, DataStore<ViewPreCreationProfile>> stores = getStores();
            DataStore<ViewPreCreationProfile> dataStoreCreate$default = stores.get(id);
            if (dataStoreCreate$default == null) {
                dataStoreCreate$default = DataStoreFactory.create$default(DataStoreFactory.INSTANCE, ViewPreCreationProfileSerializer.INSTANCE, null, null, null, new Function0<File>() { // from class: com.yandex.div.internal.viewpool.optimization.ViewPreCreationProfileRepository$Companion$getStoreForId$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final File invoke() {
                        File filesDir = context.getFilesDir();
                        String str = String.format(ViewPreCreationProfileRepository.STORE_PATH, Arrays.copyOf(new Object[]{id}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return new File(filesDir, str);
                    }
                }, 14, null);
                stores.put(id, dataStoreCreate$default);
            }
            Intrinsics.checkNotNullExpressionValue(dataStoreCreate$default, "stores.getOrPut(id) {\n  …          )\n            }");
            return dataStoreCreate$default;
        }
    }
}
