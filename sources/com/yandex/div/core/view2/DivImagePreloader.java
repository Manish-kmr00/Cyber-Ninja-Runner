package com.yandex.div.core.view2;

import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.DivVisitor;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBackground;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivText;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivImagePreloader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u0013H\u0012J0\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u0013H\u0012J\u0017\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0010¢\u0006\u0002\b\u0017J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/DivImagePreloader;", "", "imageLoader", "Lcom/yandex/div/core/images/DivImageLoader;", "(Lcom/yandex/div/core/images/DivImageLoader;)V", "preloadImage", "", "Lcom/yandex/div/core/images/LoadReference;", "div", "Lcom/yandex/div2/Div;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "callback", "Lcom/yandex/div/core/DivPreloader$DownloadCallback;", "", "url", "", "references", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "preloadImageBytes", "asTicket", "Lcom/yandex/div/core/view2/DivImagePreloader$Ticket;", "asTicket$div_release", "toPreloadCallback", "Lcom/yandex/div/core/DivPreloader$Callback;", "Lcom/yandex/div/core/view2/DivImagePreloader$Callback;", "Callback", "PreloadVisitor", "Ticket", "TicketImpl", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivImagePreloader {
    private final DivImageLoader imageLoader;

    /* JADX INFO: compiled from: DivImagePreloader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/DivImagePreloader$Callback;", "", "finish", "", "hasErrors", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void finish(boolean hasErrors);
    }

    /* JADX INFO: compiled from: DivImagePreloader.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/DivImagePreloader$Ticket;", "", TimerController.CANCEL_COMMAND, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Ticket {
        void cancel();
    }

    @Inject
    public DivImagePreloader(DivImageLoader imageLoader) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.imageLoader = imageLoader;
    }

    public List<LoadReference> preloadImage(Div div, ExpressionResolver resolver, DivPreloader.DownloadCallback callback) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new PreloadVisitor(this, callback, resolver, false).preload(div);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadImage(String url, DivPreloader.DownloadCallback callback, ArrayList<LoadReference> references) {
        references.add(this.imageLoader.loadImage(url, callback, -1));
        callback.onSingleLoadingStarted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadImageBytes(String url, DivPreloader.DownloadCallback callback, ArrayList<LoadReference> references) {
        references.add(this.imageLoader.loadImageBytes(url, callback, -1));
        callback.onSingleLoadingStarted();
    }

    /* JADX INFO: compiled from: DivImagePreloader.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/DivImagePreloader$PreloadVisitor;", "Lcom/yandex/div/internal/core/DivVisitor;", "", "callback", "Lcom/yandex/div/core/DivPreloader$DownloadCallback;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "visitContainers", "", "(Lcom/yandex/div/core/view2/DivImagePreloader;Lcom/yandex/div/core/DivPreloader$DownloadCallback;Lcom/yandex/div/json/expressions/ExpressionResolver;Z)V", "references", "Ljava/util/ArrayList;", "Lcom/yandex/div/core/images/LoadReference;", "Lkotlin/collections/ArrayList;", "defaultVisit", "data", "Lcom/yandex/div2/Div;", LinkHeader.Rel.PreLoad, "", "div", "visit", "Lcom/yandex/div2/Div$Container;", "Lcom/yandex/div2/Div$Gallery;", "Lcom/yandex/div2/Div$GifImage;", "Lcom/yandex/div2/Div$Grid;", "Lcom/yandex/div2/Div$Image;", "Lcom/yandex/div2/Div$Pager;", "Lcom/yandex/div2/Div$State;", "Lcom/yandex/div2/Div$Tabs;", "Lcom/yandex/div2/Div$Text;", "visitBackground", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class PreloadVisitor extends DivVisitor<Unit> {
        private final DivPreloader.DownloadCallback callback;
        private final ArrayList<LoadReference> references;
        private final ExpressionResolver resolver;
        final /* synthetic */ DivImagePreloader this$0;
        private final boolean visitContainers;

        public PreloadVisitor(DivImagePreloader divImagePreloader, DivPreloader.DownloadCallback callback, ExpressionResolver resolver, boolean z) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            this.this$0 = divImagePreloader;
            this.callback = callback;
            this.resolver = resolver;
            this.visitContainers = z;
            this.references = new ArrayList<>();
        }

        public /* synthetic */ PreloadVisitor(DivImagePreloader divImagePreloader, DivPreloader.DownloadCallback downloadCallback, ExpressionResolver expressionResolver, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(divImagePreloader, downloadCallback, expressionResolver, (i & 4) != 0 ? true : z);
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
        public /* bridge */ /* synthetic */ Unit visit(Div.Gallery gallery, ExpressionResolver expressionResolver) {
            visit2(gallery, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.GifImage gifImage, ExpressionResolver expressionResolver) {
            visit2(gifImage, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Grid grid, ExpressionResolver expressionResolver) {
            visit2(grid, expressionResolver);
            return Unit.INSTANCE;
        }

        @Override // com.yandex.div.internal.core.DivVisitor
        public /* bridge */ /* synthetic */ Unit visit(Div.Image image, ExpressionResolver expressionResolver) {
            visit2(image, expressionResolver);
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
        public /* bridge */ /* synthetic */ Unit visit(Div.Text text, ExpressionResolver expressionResolver) {
            visit2(text, expressionResolver);
            return Unit.INSTANCE;
        }

        public final List<LoadReference> preload(Div div) {
            Intrinsics.checkNotNullParameter(div, "div");
            visit(div, this.resolver);
            return this.references;
        }

        /* JADX INFO: renamed from: defaultVisit, reason: avoid collision after fix types in other method */
        protected void defaultVisit2(Div data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            visitBackground(data, resolver);
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Text data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            List<DivText.Image> list = data.getValue().images;
            if (list != null) {
                DivImagePreloader divImagePreloader = this.this$0;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String string = ((DivText.Image) it.next()).url.evaluate(resolver).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "it.url.evaluate(resolver).toString()");
                    divImagePreloader.preloadImage(string, this.callback, this.references);
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Image data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (data.getValue().preloadRequired.evaluate(resolver).booleanValue()) {
                DivImagePreloader divImagePreloader = this.this$0;
                String string = data.getValue().imageUrl.evaluate(resolver).toString();
                Intrinsics.checkNotNullExpressionValue(string, "data.value.imageUrl.evaluate(resolver).toString()");
                divImagePreloader.preloadImage(string, this.callback, this.references);
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.GifImage data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (data.getValue().preloadRequired.evaluate(resolver).booleanValue()) {
                DivImagePreloader divImagePreloader = this.this$0;
                String string = data.getValue().gifUrl.evaluate(resolver).toString();
                Intrinsics.checkNotNullExpressionValue(string, "data.value.gifUrl.evaluate(resolver).toString()");
                divImagePreloader.preloadImageBytes(string, this.callback, this.references);
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Container data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                    visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Grid data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                Iterator<T> it = DivCollectionExtensionsKt.getNonNullItems(data.getValue()).iterator();
                while (it.hasNext()) {
                    visit((Div) it.next(), resolver);
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Gallery data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                    visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Pager data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                for (DivItemBuilderResult divItemBuilderResult : DivCollectionExtensionsKt.buildItems(data.getValue(), resolver)) {
                    visit(divItemBuilderResult.getDiv(), divItemBuilderResult.getExpressionResolver());
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.Tabs data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                Iterator<T> it = data.getValue().items.iterator();
                while (it.hasNext()) {
                    visit(((DivTabs.Item) it.next()).div, resolver);
                }
            }
        }

        /* JADX INFO: renamed from: visit, reason: avoid collision after fix types in other method */
        protected void visit2(Div.State data, ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            defaultVisit2((Div) data, resolver);
            if (this.visitContainers) {
                Iterator<T> it = data.getValue().states.iterator();
                while (it.hasNext()) {
                    Div div = ((DivState.State) it.next()).div;
                    if (div != null) {
                        visit(div, resolver);
                    }
                }
            }
        }

        private final void visitBackground(Div data, ExpressionResolver resolver) {
            List<DivBackground> background = data.value().getBackground();
            if (background != null) {
                DivImagePreloader divImagePreloader = this.this$0;
                for (DivBackground divBackground : background) {
                    if (divBackground instanceof DivBackground.Image) {
                        DivBackground.Image image = (DivBackground.Image) divBackground;
                        if (image.getValue().preloadRequired.evaluate(resolver).booleanValue()) {
                            String string = image.getValue().imageUrl.evaluate(resolver).toString();
                            Intrinsics.checkNotNullExpressionValue(string, "background.value.imageUr…uate(resolver).toString()");
                            divImagePreloader.preloadImage(string, this.callback, this.references);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: DivImagePreloader.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/DivImagePreloader$TicketImpl;", "Lcom/yandex/div/core/view2/DivImagePreloader$Ticket;", "()V", "refs", "", "Lcom/yandex/div/core/images/LoadReference;", "getRefs", "()Ljava/util/List;", "addReference", "", "reference", TimerController.CANCEL_COMMAND, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class TicketImpl implements Ticket {
        private final List<LoadReference> refs = new ArrayList();

        public final List<LoadReference> getRefs() {
            return this.refs;
        }

        public final void addReference(LoadReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            this.refs.add(reference);
        }

        @Override // com.yandex.div.core.view2.DivImagePreloader.Ticket
        public void cancel() {
            Iterator<T> it = this.refs.iterator();
            while (it.hasNext()) {
                ((LoadReference) it.next()).cancel();
            }
        }
    }

    public Ticket asTicket$div_release(List<? extends LoadReference> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        TicketImpl ticketImpl = new TicketImpl();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ticketImpl.addReference((LoadReference) it.next());
        }
        return ticketImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toPreloadCallback$lambda$2(Callback this_toPreloadCallback, boolean z) {
        Intrinsics.checkNotNullParameter(this_toPreloadCallback, "$this_toPreloadCallback");
        this_toPreloadCallback.finish(z);
    }

    public DivPreloader.Callback toPreloadCallback(final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "<this>");
        return new DivPreloader.Callback() { // from class: com.yandex.div.core.view2.DivImagePreloader$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.DivPreloader.Callback
            public final void finish(boolean z) {
                DivImagePreloader.toPreloadCallback$lambda$2(callback, z);
            }
        };
    }
}
