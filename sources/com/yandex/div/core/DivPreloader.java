package com.yandex.div.core;

import android.graphics.drawable.PictureDrawable;
import com.json.b9;
import com.safedk.android.utils.j;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.extension.DivExtensionHandler;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.player.DivPlayerPreloader;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.core.view2.DivImagePreloader;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.DivVisitor;
import com.yandex.div.internal.util.UiThreadHandler;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivVideoSource;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPreloader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u001a2\u00020\u0001:\u0007\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B)\b\u0000\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yandex/div/core/DivPreloader;", "", j.c, "Lcom/yandex/div/core/DivConfiguration;", "(Lcom/yandex/div/core/DivConfiguration;)V", "context", "Lcom/yandex/div/core/Div2Context;", "(Lcom/yandex/div/core/Div2Context;)V", "imagePreloader", "Lcom/yandex/div/core/view2/DivImagePreloader;", "customContainerViewAdapter", "Lcom/yandex/div/core/DivCustomContainerViewAdapter;", "extensionController", "Lcom/yandex/div/core/extension/DivExtensionController;", "videoPreloader", "Lcom/yandex/div/core/player/DivPlayerPreloader;", "(Lcom/yandex/div/core/view2/DivImagePreloader;Lcom/yandex/div/core/DivCustomContainerViewAdapter;Lcom/yandex/div/core/extension/DivExtensionController;Lcom/yandex/div/core/player/DivPlayerPreloader;)V", LinkHeader.Rel.PreLoad, "Lcom/yandex/div/core/DivPreloader$Ticket;", "div", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "callback", "Lcom/yandex/div/core/DivPreloader$Callback;", "Callback", "Companion", "DownloadCallback", "PreloadReference", "PreloadVisitor", "Ticket", "TicketImpl", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivPreloader {
    private static final Companion Companion = new Companion(null);
    private static final Callback NO_CALLBACK = new Callback() { // from class: com.yandex.div.core.DivPreloader$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.DivPreloader.Callback
        public final void finish(boolean z) {
            DivPreloader.NO_CALLBACK$lambda$0(z);
        }
    };
    private final DivCustomContainerViewAdapter customContainerViewAdapter;
    private final DivExtensionController extensionController;
    private final DivImagePreloader imagePreloader;
    private final DivPlayerPreloader videoPreloader;

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/DivPreloader$Callback;", "", "finish", "", "hasErrors", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void finish(boolean hasErrors);
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/DivPreloader$Ticket;", "", TimerController.CANCEL_COMMAND, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Ticket {
        void cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NO_CALLBACK$lambda$0(boolean z) {
    }

    public DivPreloader(DivImagePreloader divImagePreloader, DivCustomContainerViewAdapter customContainerViewAdapter, DivExtensionController extensionController, DivPlayerPreloader videoPreloader) {
        Intrinsics.checkNotNullParameter(customContainerViewAdapter, "customContainerViewAdapter");
        Intrinsics.checkNotNullParameter(extensionController, "extensionController");
        Intrinsics.checkNotNullParameter(videoPreloader, "videoPreloader");
        this.imagePreloader = divImagePreloader;
        this.customContainerViewAdapter = customContainerViewAdapter;
        this.extensionController = extensionController;
        this.videoPreloader = videoPreloader;
    }

    public DivPreloader(DivConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        DivImageLoader imageLoader = configuration.getImageLoader();
        Intrinsics.checkNotNullExpressionValue(imageLoader, "configuration.imageLoader");
        DivImagePreloader divImagePreloader = new DivImagePreloader(imageLoader);
        DivCustomContainerViewAdapter divCustomContainerViewAdapter = configuration.getDivCustomContainerViewAdapter();
        Intrinsics.checkNotNullExpressionValue(divCustomContainerViewAdapter, "configuration.divCustomContainerViewAdapter");
        List<? extends DivExtensionHandler> extensionHandlers = configuration.getExtensionHandlers();
        Intrinsics.checkNotNullExpressionValue(extensionHandlers, "configuration.extensionHandlers");
        DivExtensionController divExtensionController = new DivExtensionController(extensionHandlers);
        DivPlayerPreloader divPlayerPreloader = configuration.getDivPlayerPreloader();
        Intrinsics.checkNotNullExpressionValue(divPlayerPreloader, "configuration.divPlayerPreloader");
        this(divImagePreloader, divCustomContainerViewAdapter, divExtensionController, divPlayerPreloader);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DivPreloader(Div2Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DivImagePreloader imagePreloader = context.getDiv2Component().getImagePreloader();
        DivCustomContainerViewAdapter divCustomContainerViewAdapter = context.getDiv2Component().getDivCustomContainerViewAdapter();
        Intrinsics.checkNotNullExpressionValue(divCustomContainerViewAdapter, "context.div2Component.di…ustomContainerViewAdapter");
        DivExtensionController extensionController = context.getDiv2Component().getExtensionController();
        Intrinsics.checkNotNullExpressionValue(extensionController, "context.div2Component.extensionController");
        DivPlayerPreloader divVideoPreloader = context.getDiv2Component().getDivVideoPreloader();
        Intrinsics.checkNotNullExpressionValue(divVideoPreloader, "context.div2Component.divVideoPreloader");
        this(imagePreloader, divCustomContainerViewAdapter, extensionController, divVideoPreloader);
    }

    public static /* synthetic */ Ticket preload$default(DivPreloader divPreloader, Div div, ExpressionResolver expressionResolver, Callback callback, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preload");
        }
        if ((i & 4) != 0) {
            callback = NO_CALLBACK;
        }
        return divPreloader.preload(div, expressionResolver, callback);
    }

    public Ticket preload(Div div, ExpressionResolver resolver, Callback callback) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DownloadCallback downloadCallback = new DownloadCallback(callback);
        Ticket ticketPreload = new PreloadVisitor(this, downloadCallback, callback, resolver).preload(div);
        downloadCallback.onFullPreloadStarted();
        return ticketPreload;
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/DivPreloader$Companion;", "", "()V", "NO_CALLBACK", "Lcom/yandex/div/core/DivPreloader$Callback;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/core/DivPreloader$PreloadVisitor;", "Lcom/yandex/div/internal/core/DivVisitor;", "", "downloadCallback", "Lcom/yandex/div/core/DivPreloader$DownloadCallback;", "callback", "Lcom/yandex/div/core/DivPreloader$Callback;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div/core/DivPreloader;Lcom/yandex/div/core/DivPreloader$DownloadCallback;Lcom/yandex/div/core/DivPreloader$Callback;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "ticket", "Lcom/yandex/div/core/DivPreloader$TicketImpl;", "defaultVisit", "data", "Lcom/yandex/div2/Div;", LinkHeader.Rel.PreLoad, "Lcom/yandex/div/core/DivPreloader$Ticket;", "div", "visit", "Lcom/yandex/div2/Div$Container;", "Lcom/yandex/div2/Div$Custom;", "Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/Div$Tabs;", "Lcom/yandex/div2/Div$Video;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class PreloadVisitor extends DivVisitor<Unit> {
        private final Callback callback;
        private final DownloadCallback downloadCallback;
        private final ExpressionResolver resolver;
        final /* synthetic */ DivPreloader this$0;
        private final TicketImpl ticket;

        public PreloadVisitor(DivPreloader divPreloader, DownloadCallback downloadCallback, Callback callback, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(downloadCallback, "downloadCallback");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            this.this$0 = divPreloader;
            this.downloadCallback = downloadCallback;
            this.callback = callback;
            this.resolver = resolver;
            this.ticket = new TicketImpl();
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit defaultVisit(Div div, ExpressionResolver expressionResolver) {
            defaultVisit2(div, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Container container, ExpressionResolver expressionResolver) {
            visit2(container, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Custom custom, ExpressionResolver expressionResolver) {
            visit2(custom, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Gallery gallery, ExpressionResolver expressionResolver) {
            visit2(gallery, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Grid grid, ExpressionResolver expressionResolver) {
            visit2(grid, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Pager pager, ExpressionResolver expressionResolver) {
            visit2(pager, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.State state, ExpressionResolver expressionResolver) {
            visit2(state, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Tabs tabs, ExpressionResolver expressionResolver) {
            visit2(tabs, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Video video, ExpressionResolver expressionResolver) {
            visit2(video, expressionResolver);
            return Unit.INSTANCE;
        }

        public final Ticket preload(Div div) {
            Intrinsics.checkNotNullParameter(div, "div");
            visit(div, this.resolver);
            return this.ticket;
        }

        /* JADX INFO: renamed from: defaultVisit, reason: avoid collision after fix types in other method */
        protected void defaultVisit2(Div data, ExpressionResolver resolver) {
            List<LoadReference> listPreloadImage;
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            DivImagePreloader divImagePreloader = this.this$0.imagePreloader;
            if (divImagePreloader != null && (listPreloadImage = divImagePreloader.preloadImage(data, resolver, this.downloadCallback)) != null) {
                Iterator<T> it = listPreloadImage.iterator();
                while (it.hasNext()) {
                    this.ticket.addImageReference((LoadReference) it.next());
                }
            }
            this.this$0.extensionController.preprocessExtensions(data.value(), resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Container data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Grid data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Iterator<T> it = DivCollectionExtensionsKt.getNonNullItems(data.getValue()).iterator();
            while (it.hasNext()) {
                visit((Div) it.next(), resolver);
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Gallery data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Pager data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Tabs data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Iterator<T> it = data.getValue().items.iterator();
            while (it.hasNext()) {
                visit(((DivTabs.Item) it.next()).div, resolver);
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.State data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Iterator<T> it = data.getValue().states.iterator();
            while (it.hasNext()) {
                Div div = ((DivState.State) it.next()).div;
                if (div != null) {
                    visit(div, resolver);
                }
            }
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Custom data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            List<Div> list = data.getValue().items;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    visit((Div) it.next(), resolver);
                }
            }
            this.ticket.addReference(this.this$0.customContainerViewAdapter.preload(data.getValue(), this.callback));
            defaultVisit2((Div) data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Video data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (data.getValue().preloadRequired.evaluate(resolver).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = data.getValue().videoSources.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DivVideoSource) it.next()).url.evaluate(resolver));
                }
                this.ticket.addReference(this.this$0.videoPreloader.preloadVideo(arrayList));
            }
        }
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\tH\u0016J\f\u0010\u000e\u001a\u00020\u0005*\u00020\u000bH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/DivPreloader$TicketImpl;", "Lcom/yandex/div/core/DivPreloader$Ticket;", "()V", "refs", "", "Lcom/yandex/div/core/DivPreloader$PreloadReference;", "getRefs", "()Ljava/util/List;", "addImageReference", "", "reference", "Lcom/yandex/div/core/images/LoadReference;", "addReference", TimerController.CANCEL_COMMAND, "toPreloadReference", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class TicketImpl implements Ticket {
        private final List<PreloadReference> refs = new ArrayList();

        public final List<PreloadReference> getRefs() {
            return this.refs;
        }

        public final void addReference(PreloadReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            this.refs.add(reference);
        }

        public final void addImageReference(LoadReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            this.refs.add(toPreloadReference(reference));
        }

        @Override // com.yandex.div.core.DivPreloader.Ticket
        public void cancel() {
            Iterator<T> it = this.refs.iterator();
            while (it.hasNext()) {
                ((PreloadReference) it.next()).cancel();
            }
        }

        private final PreloadReference toPreloadReference(final LoadReference loadReference) {
            return new PreloadReference() { // from class: com.yandex.div.core.DivPreloader$TicketImpl$toPreloadReference$1
                @Override // com.yandex.div.core.DivPreloader.PreloadReference
                public void cancel() {
                    loadReference.cancel();
                }
            };
        }
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0019\u0010\u0014\u001a\u00020\u000b2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/DivPreloader$DownloadCallback;", "Lcom/yandex/div/core/images/DivImageDownloadCallback;", "callback", "Lcom/yandex/div/core/DivPreloader$Callback;", "(Lcom/yandex/div/core/DivPreloader$Callback;)V", "downloadsLeftCount", "", "failures", b9.h.d0, "", "done", "", "onError", "onFullPreloadStarted", "onSingleLoadingStarted", "onSuccess", "pictureDrawable", "Landroid/graphics/drawable/PictureDrawable;", "cachedBitmap", "Lcom/yandex/div/core/images/CachedBitmap;", "runOnUiThread", "action", "Lkotlin/Function0;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DownloadCallback extends DivImageDownloadCallback {
        private final Callback callback;
        private int downloadsLeftCount;
        private int failures;
        private boolean started;

        public DownloadCallback(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @Override // com.yandex.div.core.images.DivImageDownloadCallback
        public void onSuccess(CachedBitmap cachedBitmap) {
            Intrinsics.checkNotNullParameter(cachedBitmap, "cachedBitmap");
            done();
        }

        @Override // com.yandex.div.core.images.DivImageDownloadCallback
        public void onSuccess(PictureDrawable pictureDrawable) {
            Intrinsics.checkNotNullParameter(pictureDrawable, "pictureDrawable");
            done();
        }

        private final void runOnUiThread(final Function0<Unit> action) {
            UiThreadHandler uiThreadHandler = UiThreadHandler.INSTANCE;
            if (UiThreadHandler.isMainThread()) {
                action.invoke();
            } else {
                UiThreadHandler.get().post(new Runnable() { // from class: com.yandex.div.core.DivPreloader$DownloadCallback$runOnUiThread$$inlined$executeOnMainThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        action.invoke();
                    }
                });
            }
        }

        public final void onSingleLoadingStarted() {
            UiThreadHandler uiThreadHandler = UiThreadHandler.INSTANCE;
            if (UiThreadHandler.isMainThread()) {
                this.downloadsLeftCount++;
            } else {
                UiThreadHandler.get().post(new Runnable() { // from class: com.yandex.div.core.DivPreloader$DownloadCallback$onSingleLoadingStarted$$inlined$runOnUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.this$0.downloadsLeftCount++;
                    }
                });
            }
        }

        @Override // com.yandex.div.core.images.DivImageDownloadCallback
        public void onError() {
            UiThreadHandler uiThreadHandler = UiThreadHandler.INSTANCE;
            if (UiThreadHandler.isMainThread()) {
                this.failures++;
                done();
            } else {
                UiThreadHandler.get().post(new Runnable() { // from class: com.yandex.div.core.DivPreloader$DownloadCallback$onError$$inlined$runOnUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.this$0.failures++;
                        this.this$0.done();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void done() {
            UiThreadHandler uiThreadHandler = UiThreadHandler.INSTANCE;
            if (UiThreadHandler.isMainThread()) {
                this.downloadsLeftCount--;
                if (this.downloadsLeftCount == 0 && this.started) {
                    this.callback.finish(this.failures != 0);
                    return;
                }
                return;
            }
            UiThreadHandler.get().post(new Runnable() { // from class: com.yandex.div.core.DivPreloader$DownloadCallback$done$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.downloadsLeftCount--;
                    if (this.this$0.downloadsLeftCount == 0 && this.this$0.started) {
                        this.this$0.callback.finish(this.this$0.failures != 0);
                    }
                }
            });
        }

        public final void onFullPreloadStarted() {
            UiThreadHandler uiThreadHandler = UiThreadHandler.INSTANCE;
            if (UiThreadHandler.isMainThread()) {
                this.started = true;
                if (this.downloadsLeftCount == 0) {
                    this.callback.finish(this.failures != 0);
                    return;
                }
                return;
            }
            UiThreadHandler.get().post(new Runnable() { // from class: com.yandex.div.core.DivPreloader$DownloadCallback$onFullPreloadStarted$$inlined$runOnUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.started = true;
                    if (this.this$0.downloadsLeftCount == 0) {
                        this.this$0.callback.finish(this.this$0.failures != 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: DivPreloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/DivPreloader$PreloadReference;", "", TimerController.CANCEL_COMMAND, "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface PreloadReference {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        void cancel();

        /* JADX INFO: compiled from: DivPreloader.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/DivPreloader$PreloadReference$Companion;", "", "()V", "EMPTY", "Lcom/yandex/div/core/DivPreloader$PreloadReference;", "getEMPTY", "()Lcom/yandex/div/core/DivPreloader$PreloadReference;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final PreloadReference EMPTY = new PreloadReference() { // from class: com.yandex.div.core.DivPreloader$PreloadReference$Companion$$ExternalSyntheticLambda0
                @Override // com.yandex.div.core.DivPreloader.PreloadReference
                public final void cancel() {
                    DivPreloader.PreloadReference.Companion.EMPTY$lambda$0();
                }
            };

            /* JADX INFO: Access modifiers changed from: private */
            public static final void EMPTY$lambda$0() {
            }

            private Companion() {
            }

            public final PreloadReference getEMPTY() {
                return EMPTY;
            }
        }
    }
}
