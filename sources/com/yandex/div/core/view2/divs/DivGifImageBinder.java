package com.yandex.div.core.view2.divs;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.yandex.div.core.DivIdLoggingImageDownloadCallback;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.util.ImageRepresentation;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivPlaceholderLoader;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivGifImageView;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.widget.AspectImageView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivGifImage;
import com.yandex.div2.DivImageScale;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivGifImageBinder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J0\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002J,\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0003J0\u0010$\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivGifImageBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivGifImage;", "Lcom/yandex/div/core/view2/divs/widgets/DivGifImageView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "placeholderLoader", "Lcom/yandex/div/core/view2/DivPlaceholderLoader;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/images/DivImageLoader;Lcom/yandex/div/core/view2/DivPlaceholderLoader;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "applyContentAlignment", "Lcom/yandex/div/internal/widget/AspectImageView;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "horizontalAlignment", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "verticalAlignment", "Lcom/yandex/div2/DivAlignmentVertical;", "applyGifImage", "divView", "Lcom/yandex/div/core/view2/Div2View;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "loadDrawable", "cachedBitmap", "Lcom/yandex/div/core/images/CachedBitmap;", "observeContentAlignment", "Companion", "LoadDrawableOnPostPTask", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivGifImageBinder implements DivViewBinder<DivGifImage, DivGifImageView> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "DivGifImageBinder";
    private final DivBaseBinder baseBinder;
    private final ErrorCollectors errorCollectors;
    private final DivImageLoader imageLoader;
    private final DivPlaceholderLoader placeholderLoader;

    @Inject
    public DivGifImageBinder(DivBaseBinder baseBinder, DivImageLoader imageLoader, DivPlaceholderLoader placeholderLoader, ErrorCollectors errorCollectors) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(placeholderLoader, "placeholderLoader");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        this.baseBinder = baseBinder;
        this.imageLoader = imageLoader;
        this.placeholderLoader = placeholderLoader;
        this.errorCollectors = errorCollectors;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, final DivGifImageView view, final DivGifImage div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        DivGifImage div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        final Div2View divView = context.getDivView();
        final ErrorCollector orCreate = this.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData());
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivGifImageView divGifImageView = view;
        this.baseBinder.bindView(context, divGifImageView, div, div2);
        BaseDivViewExtensionsKt.applyDivActions(divGifImageView, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        BaseDivViewExtensionsKt.bindAspectRatio(divGifImageView, div.aspect, div2 != null ? div2.aspect : null, expressionResolver);
        view.addSubscription(div.scale.observeAndGet(expressionResolver, new Function1<DivImageScale, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder.bindView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivImageScale divImageScale) {
                invoke2(divImageScale);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivImageScale scale) {
                Intrinsics.checkNotNullParameter(scale, "scale");
                view.setImageScale(BaseDivViewExtensionsKt.toImageScale(scale));
            }
        }));
        observeContentAlignment(view, expressionResolver, div.contentAlignmentHorizontal, div.contentAlignmentVertical);
        view.addSubscription(div.gifUrl.observeAndGet(expressionResolver, new Function1<Uri, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder.bindView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                invoke2(uri);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Uri it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivGifImageBinder.this.applyGifImage(view, divView, expressionResolver, div, orCreate);
            }
        }));
    }

    private final void observeContentAlignment(final DivGifImageView divGifImageView, final ExpressionResolver expressionResolver, final Expression<DivAlignmentHorizontal> expression, final Expression<DivAlignmentVertical> expression2) {
        applyContentAlignment(divGifImageView, expressionResolver, expression, expression2);
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder$observeContentAlignment$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyContentAlignment(divGifImageView, expressionResolver, expression, expression2);
            }
        };
        divGifImageView.addSubscription(expression.observe(expressionResolver, function1));
        divGifImageView.addSubscription(expression2.observe(expressionResolver, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyContentAlignment(AspectImageView aspectImageView, ExpressionResolver expressionResolver, Expression<DivAlignmentHorizontal> expression, Expression<DivAlignmentVertical> expression2) {
        aspectImageView.setGravity(BaseDivViewExtensionsKt.evaluateGravity(expression.evaluate(expressionResolver), expression2.evaluate(expressionResolver)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyGifImage(final DivGifImageView divGifImageView, final Div2View div2View, ExpressionResolver expressionResolver, DivGifImage divGifImage, ErrorCollector errorCollector) {
        Uri uriEvaluate = divGifImage.gifUrl.evaluate(expressionResolver);
        if (Intrinsics.areEqual(uriEvaluate, divGifImageView.getGifUrl())) {
            return;
        }
        divGifImageView.resetImageLoaded();
        LoadReference loadReference$div_release = divGifImageView.getLoadReference();
        if (loadReference$div_release != null) {
            loadReference$div_release.cancel();
        }
        DivPlaceholderLoader divPlaceholderLoader = this.placeholderLoader;
        DivGifImageView divGifImageView2 = divGifImageView;
        Expression<String> expression = divGifImage.preview;
        divPlaceholderLoader.applyPlaceholder(divGifImageView2, errorCollector, expression != null ? expression.evaluate(expressionResolver) : null, divGifImage.placeholderColor.evaluate(expressionResolver).intValue(), false, new Function1<Drawable, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder.applyGifImage.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                if (divGifImageView.isImageLoaded() || divGifImageView.isImagePreview()) {
                    return;
                }
                divGifImageView.setPlaceholder(drawable);
            }
        }, new Function1<ImageRepresentation, Unit>() { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder.applyGifImage.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImageRepresentation imageRepresentation) {
                invoke2(imageRepresentation);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageRepresentation imageRepresentation) {
                if (divGifImageView.isImageLoaded()) {
                    return;
                }
                if (imageRepresentation instanceof ImageRepresentation.Bitmap) {
                    divGifImageView.setPreview(((ImageRepresentation.Bitmap) imageRepresentation).m6129unboximpl());
                } else if (imageRepresentation instanceof ImageRepresentation.PictureDrawable) {
                    divGifImageView.setPreview(((ImageRepresentation.PictureDrawable) imageRepresentation).m6136unboximpl());
                }
                divGifImageView.previewLoaded();
            }
        });
        divGifImageView.setGifUrl$div_release(uriEvaluate);
        LoadReference loadReferenceLoadImageBytes = this.imageLoader.loadImageBytes(uriEvaluate.toString(), new DivIdLoggingImageDownloadCallback(div2View) { // from class: com.yandex.div.core.view2.divs.DivGifImageBinder$applyGifImage$reference$1
            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(CachedBitmap cachedBitmap) {
                Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
                super.onSuccess(cachedBitmap);
                if (Build.VERSION.SDK_INT >= 28) {
                    this.loadDrawable(divGifImageView, cachedBitmap);
                } else {
                    divGifImageView.setImage(cachedBitmap.getBitmap());
                    divGifImageView.imageLoaded();
                }
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onSuccess(Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                super.onSuccess(drawable);
                divGifImageView.setImage(drawable);
                divGifImageView.imageLoaded();
            }

            @Override // com.yandex.div.core.images.DivImageDownloadCallback
            public void onError() {
                super.onError();
                divGifImageView.setGifUrl$div_release(null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImageBytes, "private fun DivGifImageV…ference = reference\n    }");
        div2View.addLoadReference(loadReferenceLoadImageBytes, divGifImageView);
        divGifImageView.setLoadReference$div_release(loadReferenceLoadImageBytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadDrawable(DivGifImageView divGifImageView, CachedBitmap cachedBitmap) {
        new LoadDrawableOnPostPTask(new WeakReference(divGifImageView), cachedBitmap).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX INFO: compiled from: DivGifImageBinder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0003H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J'\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0013\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivGifImageBinder$LoadDrawableOnPostPTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "view", "Ljava/lang/ref/WeakReference;", "Lcom/yandex/div/core/view2/divs/widgets/DivGifImageView;", "cachedBitmap", "Lcom/yandex/div/core/images/CachedBitmap;", "(Ljava/lang/ref/WeakReference;Lcom/yandex/div/core/images/CachedBitmap;)V", "getCachedBitmap", "()Lcom/yandex/div/core/images/CachedBitmap;", "getView", "()Ljava/lang/ref/WeakReference;", "createDrawableFromBytes", "createSourceFromUri", "Landroid/graphics/ImageDecoder$Source;", "doInBackground", "params", "", "([Ljava/lang/Void;)Landroid/graphics/drawable/Drawable;", "onPostExecute", "", "result", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LoadDrawableOnPostPTask extends AsyncTask<Void, Void, Drawable> {
        private final CachedBitmap cachedBitmap;
        private final WeakReference<DivGifImageView> view;

        public final WeakReference<DivGifImageView> getView() {
            return this.view;
        }

        public final CachedBitmap getCachedBitmap() {
            return this.cachedBitmap;
        }

        public LoadDrawableOnPostPTask(WeakReference<DivGifImageView> view, CachedBitmap cachedBitmap) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
            this.view = view;
            this.cachedBitmap = cachedBitmap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:23:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // android.os.AsyncTask
        public Drawable doInBackground(Void... params) {
            ImageDecoder.Source sourceCreateSourceFromUri;
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                return createDrawableFromBytes();
            } catch (IOException e) {
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.ERROR)) {
                    kLog.print(6, DivGifImageBinder.TAG, "Failed writing bytes to temp file, exception: " + e.getMessage());
                }
                sourceCreateSourceFromUri = createSourceFromUri();
                if (sourceCreateSourceFromUri == null) {
                    return null;
                }
                try {
                    return ImageDecoder.decodeDrawable(sourceCreateSourceFromUri);
                } catch (IOException e2) {
                    KLog kLog2 = KLog.INSTANCE;
                    if (!kLog2.isAtLeast(Severity.ERROR)) {
                        return null;
                    }
                    kLog2.print(6, DivGifImageBinder.TAG, "Decode drawable from uri exception " + e2.getMessage());
                    return null;
                }
            } catch (IllegalStateException e3) {
                KLog kLog3 = KLog.INSTANCE;
                if (kLog3.isAtLeast(Severity.ERROR)) {
                    kLog3.print(6, DivGifImageBinder.TAG, "Failed create drawable from bytes, exception: " + e3.getMessage());
                }
                sourceCreateSourceFromUri = createSourceFromUri();
                if (sourceCreateSourceFromUri == null) {
                    return ImageDecoder.decodeDrawable(sourceCreateSourceFromUri);
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Drawable result) {
            super.onPostExecute(result);
            if (result != null && (result instanceof AnimatedImageDrawable)) {
                DivGifImageView divGifImageView = this.view.get();
                if (divGifImageView != null) {
                    divGifImageView.setImage(result);
                }
            } else {
                DivGifImageView divGifImageView2 = this.view.get();
                if (divGifImageView2 != null) {
                    divGifImageView2.setImage(this.cachedBitmap.getBitmap());
                }
            }
            DivGifImageView divGifImageView3 = this.view.get();
            if (divGifImageView3 != null) {
                divGifImageView3.imageLoaded();
            }
        }

        private final Drawable createDrawableFromBytes() throws IllegalStateException, IOException {
            byte[] bytes = this.cachedBitmap.getBytes();
            if (bytes == null) {
                throw new IllegalStateException("no bytes stored in cached bitmap");
            }
            DivGifImageView divGifImageView = this.view.get();
            Context context = divGifImageView != null ? divGifImageView.getContext() : null;
            if (context == null) {
                throw new IllegalStateException("failed retrieve context");
            }
            File tempFile = File.createTempFile("if_u_see_me_in_file_system_plz_report", ".gif", context.getCacheDir());
            try {
                Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
                FilesKt.writeBytes(tempFile, bytes);
                ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(tempFile);
                Intrinsics.checkNotNullExpressionValue(sourceCreateSource, "createSource(tempFile)");
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(sourceCreateSource);
                Intrinsics.checkNotNullExpressionValue(drawableDecodeDrawable, "{\n                tempFi…ble(source)\n            }");
                return drawableDecodeDrawable;
            } finally {
                tempFile.delete();
            }
        }

        private final ImageDecoder.Source createSourceFromUri() {
            Uri cacheUri = this.cachedBitmap.getCacheUri();
            String path = cacheUri != null ? cacheUri.getPath() : null;
            if (path != null) {
                try {
                    return ImageDecoder.createSource(new File(path));
                } catch (IOException e) {
                    if (!KLog.INSTANCE.isAtLeast(Severity.ERROR)) {
                        return null;
                    }
                    Log.e(DivGifImageBinder.TAG, "", e);
                    return null;
                }
            }
            KLog kLog = KLog.INSTANCE;
            if (!kLog.isAtLeast(Severity.ERROR)) {
                return null;
            }
            kLog.print(6, DivGifImageBinder.TAG, "No bytes or file in cache to decode gif drawable");
            return null;
        }
    }

    /* JADX INFO: compiled from: DivGifImageBinder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivGifImageBinder$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
