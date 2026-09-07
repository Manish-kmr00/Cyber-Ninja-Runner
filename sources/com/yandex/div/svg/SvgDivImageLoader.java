package com.yandex.div.svg;

import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import io.bidmachine.unified.UnifiedMediationParams;
import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: SvgDivImageLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/svg/SvgDivImageLoader;", "Lcom/yandex/div/core/images/DivImageLoader;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "httpClient", "Lokhttp3/OkHttpClient;", "svgCacheManager", "Lcom/yandex/div/svg/SvgCacheManager;", "svgDecoder", "Lcom/yandex/div/svg/SvgDecoder;", "createCall", "Lokhttp3/Call;", UnifiedMediationParams.KEY_IMAGE_URL, "", "hasSvgSupport", "", "()Ljava/lang/Boolean;", "loadImage", "Lcom/yandex/div/core/images/LoadReference;", "imageView", "Landroid/widget/ImageView;", "callback", "Lcom/yandex/div/core/images/DivImageDownloadCallback;", "loadImageBytes", "div-svg_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SvgDivImageLoader implements DivImageLoader {
    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private final CoroutineScope coroutineScope = CoroutineScopeKt.MainScope();
    private final SvgDecoder svgDecoder = new SvgDecoder(false, 1, null);
    private final SvgCacheManager svgCacheManager = new SvgCacheManager();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$0() {
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public Boolean hasSvgSupport() {
        return true;
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Call callCreateCall = createCall(imageUrl);
        PictureDrawable pictureDrawable = this.svgCacheManager.get(imageUrl);
        if (pictureDrawable == null) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(callback, this, imageUrl, callCreateCall, null), 3, null);
            return new LoadReference() { // from class: com.yandex.div.svg.SvgDivImageLoader$$ExternalSyntheticLambda1
                @Override // com.yandex.div.core.images.LoadReference
                public final void cancel() {
                    SvgDivImageLoader.loadImage$lambda$1(callCreateCall);
                }
            };
        }
        callback.onSuccess(pictureDrawable);
        return new LoadReference() { // from class: com.yandex.div.svg.SvgDivImageLoader$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                SvgDivImageLoader.loadImage$lambda$0();
            }
        };
    }

    /* JADX INFO: renamed from: com.yandex.div.svg.SvgDivImageLoader$loadImage$2, reason: invalid class name */
    /* JADX INFO: compiled from: SvgDivImageLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.yandex.div.svg.SvgDivImageLoader$loadImage$2", f = "SvgDivImageLoader.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Call $call;
        final /* synthetic */ DivImageDownloadCallback $callback;
        final /* synthetic */ String $imageUrl;
        int label;
        final /* synthetic */ SvgDivImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DivImageDownloadCallback divImageDownloadCallback, SvgDivImageLoader svgDivImageLoader, String str, Call call, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = divImageDownloadCallback;
            this.this$0 = svgDivImageLoader;
            this.$imageUrl = str;
            this.$call = call;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$callback, this.this$0, this.$imageUrl, this.$call, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yandex.div.svg.SvgDivImageLoader$loadImage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SvgDivImageLoader.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/PictureDrawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.yandex.div.svg.SvgDivImageLoader$loadImage$2$1", f = "SvgDivImageLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PictureDrawable>, Object> {
            final /* synthetic */ Call $call;
            final /* synthetic */ String $imageUrl;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SvgDivImageLoader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SvgDivImageLoader svgDivImageLoader, String str, Call call, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = svgDivImageLoader;
                this.$imageUrl = str;
                this.$call = call;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$imageUrl, this.$call, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PictureDrawable> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objM7904constructorimpl;
                PictureDrawable pictureDrawableDecode;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Call call = this.$call;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ResponseBody responseBodyBody = call.execute().body();
                    objM7904constructorimpl = Result.m7904constructorimpl(responseBodyBody != null ? responseBodyBody.bytes() : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                    objM7904constructorimpl = null;
                }
                byte[] bArr = (byte[]) objM7904constructorimpl;
                if (bArr == null || (pictureDrawableDecode = this.this$0.svgDecoder.decode(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                this.this$0.svgCacheManager.set(this.$imageUrl, pictureDrawableDecode);
                return pictureDrawableDecode;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Unit unit = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$imageUrl, this.$call, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PictureDrawable pictureDrawable = (PictureDrawable) obj;
            if (pictureDrawable != null) {
                this.$callback.onSuccess(pictureDrawable);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.$callback.onError();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$1(Call call) {
        Intrinsics.checkNotNullParameter(call, "$call");
        call.cancel();
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        final Call callCreateCall = createCall(imageUrl);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass4(callCreateCall, imageView, null), 3, null);
        return new LoadReference() { // from class: com.yandex.div.svg.SvgDivImageLoader$$ExternalSyntheticLambda3
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                SvgDivImageLoader.loadImage$lambda$2(callCreateCall);
            }
        };
    }

    /* JADX INFO: renamed from: com.yandex.div.svg.SvgDivImageLoader$loadImage$4, reason: invalid class name */
    /* JADX INFO: compiled from: SvgDivImageLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.yandex.div.svg.SvgDivImageLoader$loadImage$4", f = "SvgDivImageLoader.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Call $call;
        final /* synthetic */ ImageView $imageView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Call call, ImageView imageView, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$call = call;
            this.$imageView = imageView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SvgDivImageLoader.this.new AnonymousClass4(this.$call, this.$imageView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yandex.div.svg.SvgDivImageLoader$loadImage$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: SvgDivImageLoader.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/PictureDrawable;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.yandex.div.svg.SvgDivImageLoader$loadImage$4$1", f = "SvgDivImageLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PictureDrawable>, Object> {
            final /* synthetic */ Call $call;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SvgDivImageLoader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SvgDivImageLoader svgDivImageLoader, Call call, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = svgDivImageLoader;
                this.$call = call;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$call, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PictureDrawable> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objM7904constructorimpl;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Call call = this.$call;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ResponseBody responseBodyBody = call.execute().body();
                    objM7904constructorimpl = Result.m7904constructorimpl(responseBodyBody != null ? responseBodyBody.bytes() : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                    objM7904constructorimpl = null;
                }
                byte[] bArr = (byte[]) objM7904constructorimpl;
                if (bArr == null) {
                    return null;
                }
                return this.this$0.svgDecoder.decode(new ByteArrayInputStream(bArr));
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(SvgDivImageLoader.this, this.$call, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PictureDrawable pictureDrawable = (PictureDrawable) obj;
            if (pictureDrawable != null) {
                this.$imageView.setImageDrawable(pictureDrawable);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$2(Call call) {
        Intrinsics.checkNotNullParameter(call, "$call");
        call.cancel();
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImageBytes(final String imageUrl, final DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new LoadReference() { // from class: com.yandex.div.svg.SvgDivImageLoader$$ExternalSyntheticLambda2
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                SvgDivImageLoader.loadImageBytes$lambda$3(this.f$0, imageUrl, callback);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImageBytes$lambda$3(SvgDivImageLoader this$0, String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageUrl, "$imageUrl");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.loadImage(imageUrl, callback);
    }

    private final Call createCall(String imageUrl) {
        return this.httpClient.newCall(new Request.Builder().url(imageUrl).build());
    }
}
