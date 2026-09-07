package com.yandex.div.core.view2;

import android.view.View;
import android.view.ViewGroup;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.ExpressionFallbacksHelperKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.local.UtilsKt;
import com.yandex.div.core.extension.DivExtensionController;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivContainerBinder;
import com.yandex.div.core.view2.divs.DivCustomBinder;
import com.yandex.div.core.view2.divs.DivGifImageBinder;
import com.yandex.div.core.view2.divs.DivGridBinder;
import com.yandex.div.core.view2.divs.DivImageBinder;
import com.yandex.div.core.view2.divs.DivIndicatorBinder;
import com.yandex.div.core.view2.divs.DivInputBinder;
import com.yandex.div.core.view2.divs.DivSelectBinder;
import com.yandex.div.core.view2.divs.DivSeparatorBinder;
import com.yandex.div.core.view2.divs.DivSliderBinder;
import com.yandex.div.core.view2.divs.DivStateBinder;
import com.yandex.div.core.view2.divs.DivSwitchBinder;
import com.yandex.div.core.view2.divs.DivTextBinder;
import com.yandex.div.core.view2.divs.DivVideoBinder;
import com.yandex.div.core.view2.divs.gallery.DivGalleryBinder;
import com.yandex.div.core.view2.divs.pager.DivPagerBinder;
import com.yandex.div.core.view2.divs.pager.PagerIndicatorConnector;
import com.yandex.div.core.view2.divs.tabs.DivTabsBinder;
import com.yandex.div.core.view2.divs.widgets.DivCustomWrapper;
import com.yandex.div.core.view2.divs.widgets.DivGifImageView;
import com.yandex.div.core.view2.divs.widgets.DivGridLayout;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.divs.widgets.DivImageView;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.core.view2.divs.widgets.DivLineHeightTextView;
import com.yandex.div.core.view2.divs.widgets.DivPagerIndicatorView;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div.core.view2.divs.widgets.DivSelectView;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
import com.yandex.div.core.view2.divs.widgets.DivSliderView;
import com.yandex.div.core.view2.divs.widgets.DivStateLayout;
import com.yandex.div.core.view2.divs.widgets.DivSwitchView;
import com.yandex.div.core.view2.divs.widgets.DivTabsLayout;
import com.yandex.div.core.view2.divs.widgets.DivVideoView;
import com.yandex.div.core.view2.reuse.ReusableTokenList;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivCustom;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivGifImage;
import com.yandex.div2.DivGrid;
import com.yandex.div2.DivImage;
import com.yandex.div2.DivIndicator;
import com.yandex.div2.DivInput;
import com.yandex.div2.DivPager;
import com.yandex.div2.DivSelect;
import com.yandex.div2.DivSeparator;
import com.yandex.div2.DivSlider;
import com.yandex.div2.DivState;
import com.yandex.div2.DivSwitch;
import com.yandex.div2.DivTabs;
import com.yandex.div2.DivText;
import com.yandex.div2.DivVariable;
import com.yandex.div2.DivVideo;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBinder.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B§\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\r\u0010+\u001a\u00020,H\u0011¢\u0006\u0002\b-J(\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0017J(\u00107\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u00105\u001a\u000206H\u0012J(\u0010;\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020<2\u0006\u00105\u001a\u000206H\u0012J(\u0010=\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020>2\u0006\u00105\u001a\u000206H\u0012J \u0010?\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020@H\u0012J(\u0010A\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020B2\u0006\u00105\u001a\u000206H\u0012J \u0010C\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020DH\u0012J \u0010E\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020FH\u0012J(\u0010G\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020H2\u0006\u00105\u001a\u000206H\u0012J \u0010I\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0012J(\u0010M\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020N2\u0006\u00105\u001a\u000206H\u0012J(\u0010O\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020P2\u0006\u00105\u001a\u000206H\u0012J \u0010Q\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020RH\u0012J(\u0010S\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020T2\u0006\u00105\u001a\u000206H\u0012J(\u0010U\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020V2\u0006\u00105\u001a\u000206H\u0012J(\u0010W\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020X2\u0006\u00105\u001a\u000206H\u0012J(\u0010Y\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020Z2\u0006\u00105\u001a\u000206H\u0012J \u0010[\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020\\H\u0012J(\u0010]\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020^2\u0006\u00105\u001a\u000206H\u0012J \u0010_\u001a\u0002002\u0006\u0010/\u001a\u0002002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0012J \u0010`\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020:H\u0012J \u0010a\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J \u0010b\u001a\u00020,2\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00109\u001a\u00020BH\u0012J1\u0010a\u001a\u00020,\"\b\b\u0000\u0010c*\u00020J*\b\u0012\u0004\u0012\u0002Hc0d2\u0006\u00108\u001a\u0002002\u0006\u0010e\u001a\u0002HcH\u0012¢\u0006\u0002\u0010fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/yandex/div/core/view2/DivBinder;", "", "validator", "Lcom/yandex/div/core/view2/DivValidator;", "textBinder", "Lcom/yandex/div/core/view2/divs/DivTextBinder;", "containerBinder", "Lcom/yandex/div/core/view2/divs/DivContainerBinder;", "separatorBinder", "Lcom/yandex/div/core/view2/divs/DivSeparatorBinder;", "imageBinder", "Lcom/yandex/div/core/view2/divs/DivImageBinder;", "gifImageBinder", "Lcom/yandex/div/core/view2/divs/DivGifImageBinder;", "gridBinder", "Lcom/yandex/div/core/view2/divs/DivGridBinder;", "galleryBinder", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryBinder;", "pagerBinder", "Lcom/yandex/div/core/view2/divs/pager/DivPagerBinder;", "tabsBinder", "Lcom/yandex/div/core/view2/divs/tabs/DivTabsBinder;", "stateBinder", "Lcom/yandex/div/core/view2/divs/DivStateBinder;", "customBinder", "Lcom/yandex/div/core/view2/divs/DivCustomBinder;", "indicatorBinder", "Lcom/yandex/div/core/view2/divs/DivIndicatorBinder;", "sliderBinder", "Lcom/yandex/div/core/view2/divs/DivSliderBinder;", "inputBinder", "Lcom/yandex/div/core/view2/divs/DivInputBinder;", "selectBinder", "Lcom/yandex/div/core/view2/divs/DivSelectBinder;", "videoBinder", "Lcom/yandex/div/core/view2/divs/DivVideoBinder;", "extensionController", "Lcom/yandex/div/core/extension/DivExtensionController;", "pagerIndicatorConnector", "Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;", "switchBinder", "Lcom/yandex/div/core/view2/divs/DivSwitchBinder;", "(Lcom/yandex/div/core/view2/DivValidator;Lcom/yandex/div/core/view2/divs/DivTextBinder;Lcom/yandex/div/core/view2/divs/DivContainerBinder;Lcom/yandex/div/core/view2/divs/DivSeparatorBinder;Lcom/yandex/div/core/view2/divs/DivImageBinder;Lcom/yandex/div/core/view2/divs/DivGifImageBinder;Lcom/yandex/div/core/view2/divs/DivGridBinder;Lcom/yandex/div/core/view2/divs/gallery/DivGalleryBinder;Lcom/yandex/div/core/view2/divs/pager/DivPagerBinder;Lcom/yandex/div/core/view2/divs/tabs/DivTabsBinder;Lcom/yandex/div/core/view2/divs/DivStateBinder;Lcom/yandex/div/core/view2/divs/DivCustomBinder;Lcom/yandex/div/core/view2/divs/DivIndicatorBinder;Lcom/yandex/div/core/view2/divs/DivSliderBinder;Lcom/yandex/div/core/view2/divs/DivInputBinder;Lcom/yandex/div/core/view2/divs/DivSelectBinder;Lcom/yandex/div/core/view2/divs/DivVideoBinder;Lcom/yandex/div/core/extension/DivExtensionController;Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;Lcom/yandex/div/core/view2/divs/DivSwitchBinder;)V", "attachIndicators", "", "attachIndicators$div_release", "bind", "parentContext", "Lcom/yandex/div/core/view2/BindingContext;", "view", "Landroid/view/View;", "div", "Lcom/yandex/div2/Div;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "bindContainer", "context", "data", "Lcom/yandex/div2/DivContainer;", "bindCustom", "Lcom/yandex/div2/DivCustom;", "bindGallery", "Lcom/yandex/div2/DivGallery;", "bindGifImage", "Lcom/yandex/div2/DivGifImage;", "bindGrid", "Lcom/yandex/div2/DivGrid;", "bindImage", "Lcom/yandex/div2/DivImage;", "bindIndicator", "Lcom/yandex/div2/DivIndicator;", "bindInput", "Lcom/yandex/div2/DivInput;", "bindLayoutParams", "Lcom/yandex/div2/DivBase;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindPager", "Lcom/yandex/div2/DivPager;", "bindSelect", "Lcom/yandex/div2/DivSelect;", "bindSeparator", "Lcom/yandex/div2/DivSeparator;", "bindSlider", "Lcom/yandex/div2/DivSlider;", "bindState", "Lcom/yandex/div2/DivState;", "bindSwitch", "Lcom/yandex/div2/DivSwitch;", "bindTabs", "Lcom/yandex/div2/DivTabs;", "bindText", "Lcom/yandex/div2/DivText;", "bindVideo", "Lcom/yandex/div2/DivVideo;", "getBindingContext", "setContainerData", "setDataWithoutBinding", "setGridData", "T", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "newDiv", "(Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div2/DivBase;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivBinder {
    private final DivContainerBinder containerBinder;
    private final DivCustomBinder customBinder;
    private final DivExtensionController extensionController;
    private final DivGalleryBinder galleryBinder;
    private final DivGifImageBinder gifImageBinder;
    private final DivGridBinder gridBinder;
    private final DivImageBinder imageBinder;
    private final DivIndicatorBinder indicatorBinder;
    private final DivInputBinder inputBinder;
    private final DivPagerBinder pagerBinder;
    private final PagerIndicatorConnector pagerIndicatorConnector;
    private final DivSelectBinder selectBinder;
    private final DivSeparatorBinder separatorBinder;
    private final DivSliderBinder sliderBinder;
    private final DivStateBinder stateBinder;
    private final DivSwitchBinder switchBinder;
    private final DivTabsBinder tabsBinder;
    private final DivTextBinder textBinder;
    private final DivValidator validator;
    private final DivVideoBinder videoBinder;

    @Inject
    public DivBinder(DivValidator validator, DivTextBinder textBinder, DivContainerBinder containerBinder, DivSeparatorBinder separatorBinder, DivImageBinder imageBinder, DivGifImageBinder gifImageBinder, DivGridBinder gridBinder, DivGalleryBinder galleryBinder, DivPagerBinder pagerBinder, DivTabsBinder tabsBinder, DivStateBinder stateBinder, DivCustomBinder customBinder, DivIndicatorBinder indicatorBinder, DivSliderBinder sliderBinder, DivInputBinder inputBinder, DivSelectBinder selectBinder, DivVideoBinder videoBinder, DivExtensionController extensionController, PagerIndicatorConnector pagerIndicatorConnector, DivSwitchBinder switchBinder) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(textBinder, "textBinder");
        Intrinsics.checkNotNullParameter(containerBinder, "containerBinder");
        Intrinsics.checkNotNullParameter(separatorBinder, "separatorBinder");
        Intrinsics.checkNotNullParameter(imageBinder, "imageBinder");
        Intrinsics.checkNotNullParameter(gifImageBinder, "gifImageBinder");
        Intrinsics.checkNotNullParameter(gridBinder, "gridBinder");
        Intrinsics.checkNotNullParameter(galleryBinder, "galleryBinder");
        Intrinsics.checkNotNullParameter(pagerBinder, "pagerBinder");
        Intrinsics.checkNotNullParameter(tabsBinder, "tabsBinder");
        Intrinsics.checkNotNullParameter(stateBinder, "stateBinder");
        Intrinsics.checkNotNullParameter(customBinder, "customBinder");
        Intrinsics.checkNotNullParameter(indicatorBinder, "indicatorBinder");
        Intrinsics.checkNotNullParameter(sliderBinder, "sliderBinder");
        Intrinsics.checkNotNullParameter(inputBinder, "inputBinder");
        Intrinsics.checkNotNullParameter(selectBinder, "selectBinder");
        Intrinsics.checkNotNullParameter(videoBinder, "videoBinder");
        Intrinsics.checkNotNullParameter(extensionController, "extensionController");
        Intrinsics.checkNotNullParameter(pagerIndicatorConnector, "pagerIndicatorConnector");
        Intrinsics.checkNotNullParameter(switchBinder, "switchBinder");
        this.validator = validator;
        this.textBinder = textBinder;
        this.containerBinder = containerBinder;
        this.separatorBinder = separatorBinder;
        this.imageBinder = imageBinder;
        this.gifImageBinder = gifImageBinder;
        this.gridBinder = gridBinder;
        this.galleryBinder = galleryBinder;
        this.pagerBinder = pagerBinder;
        this.tabsBinder = tabsBinder;
        this.stateBinder = stateBinder;
        this.customBinder = customBinder;
        this.indicatorBinder = indicatorBinder;
        this.sliderBinder = sliderBinder;
        this.inputBinder = inputBinder;
        this.selectBinder = selectBinder;
        this.videoBinder = videoBinder;
        this.extensionController = extensionController;
        this.pagerIndicatorConnector = pagerIndicatorConnector;
        this.switchBinder = switchBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void bind(BindingContext parentContext, View view, Div div, DivStatePath path) {
        DivBase div2;
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            BindingContext bindingContext = getBindingContext(parentContext, div, path);
            Div2View divView = bindingContext.getDivView();
            ExpressionResolver expressionResolver = bindingContext.getExpressionResolver();
            ReusableTokenList currentRebindReusableList$div_release = divView.getCurrentRebindReusableList$div_release();
            if (currentRebindReusableList$div_release == null || currentRebindReusableList$div_release.pop(div) == null) {
                if (!this.validator.validate(div, expressionResolver)) {
                    bindLayoutParams(view, div.value(), expressionResolver);
                    return;
                }
                this.extensionController.beforeBindView(divView, expressionResolver, view, div.value());
                if (!(div instanceof Div.Custom) && (div2 = ((DivHolderView) view).getDiv()) != null) {
                    this.extensionController.unbindView(divView, expressionResolver, view, div2);
                }
                if (div instanceof Div.Text) {
                    bindText(bindingContext, view, ((Div.Text) div).getValue());
                } else if (div instanceof Div.Image) {
                    bindImage(bindingContext, view, ((Div.Image) div).getValue());
                } else if (div instanceof Div.GifImage) {
                    bindGifImage(bindingContext, view, ((Div.GifImage) div).getValue());
                } else if (div instanceof Div.Separator) {
                    bindSeparator(bindingContext, view, ((Div.Separator) div).getValue());
                } else if (div instanceof Div.Container) {
                    bindContainer(bindingContext, view, ((Div.Container) div).getValue(), path);
                } else if (div instanceof Div.Grid) {
                    bindGrid(bindingContext, view, ((Div.Grid) div).getValue(), path);
                } else if (div instanceof Div.Gallery) {
                    bindGallery(bindingContext, view, ((Div.Gallery) div).getValue(), path);
                } else if (div instanceof Div.Pager) {
                    bindPager(bindingContext, view, ((Div.Pager) div).getValue(), path);
                } else if (div instanceof Div.Tabs) {
                    bindTabs(bindingContext, view, ((Div.Tabs) div).getValue(), path);
                } else if (div instanceof Div.State) {
                    bindState(bindingContext, view, ((Div.State) div).getValue(), path);
                } else if (div instanceof Div.Custom) {
                    bindCustom(bindingContext, view, ((Div.Custom) div).getValue(), path);
                } else if (div instanceof Div.Indicator) {
                    bindIndicator(bindingContext, view, ((Div.Indicator) div).getValue());
                } else if (div instanceof Div.Slider) {
                    bindSlider(bindingContext, view, ((Div.Slider) div).getValue(), path);
                } else if (div instanceof Div.Input) {
                    bindInput(bindingContext, view, ((Div.Input) div).getValue(), path);
                } else if (div instanceof Div.Select) {
                    bindSelect(bindingContext, view, ((Div.Select) div).getValue(), path);
                } else if (div instanceof Div.Video) {
                    bindVideo(bindingContext, view, ((Div.Video) div).getValue(), path);
                } else {
                    if (!(div instanceof Div.Switch)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bindSwitch(bindingContext, view, ((Div.Switch) div).getValue(), path);
                }
                Unit unit = Unit.INSTANCE;
                if (div instanceof Div.Custom) {
                    return;
                }
                this.extensionController.bindView(divView, expressionResolver, view, div.value());
            }
        } catch (ParsingException e) {
            if (!ExpressionFallbacksHelperKt.isExpressionResolveFail(e)) {
                throw e;
            }
        }
    }

    public void attachIndicators$div_release() {
        this.pagerIndicatorConnector.attach$div_release();
    }

    private void bindText(BindingContext context, View view, DivText data) {
        DivTextBinder divTextBinder = this.textBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivLineHeightTextView");
        divTextBinder.bindView(context, (DivLineHeightTextView) view, data);
    }

    private void bindImage(BindingContext context, View view, DivImage data) {
        DivImageBinder divImageBinder = this.imageBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivImageView");
        divImageBinder.bindView(context, (DivImageView) view, data);
    }

    private void bindGifImage(BindingContext context, View view, DivGifImage data) {
        DivGifImageBinder divGifImageBinder = this.gifImageBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivGifImageView");
        divGifImageBinder.bindView(context, (DivGifImageView) view, data);
    }

    private void bindSeparator(BindingContext context, View view, DivSeparator data) {
        DivSeparatorBinder divSeparatorBinder = this.separatorBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivSeparatorView");
        divSeparatorBinder.bindView(context, (DivSeparatorView) view, data);
    }

    private void bindContainer(BindingContext context, View view, DivContainer data, DivStatePath path) {
        DivContainerBinder divContainerBinder = this.containerBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        divContainerBinder.bindView(context, (ViewGroup) view, data, path);
    }

    private void bindGrid(BindingContext context, View view, DivGrid data, DivStatePath path) {
        DivGridBinder divGridBinder = this.gridBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivGridLayout");
        divGridBinder.bindView(context, (DivGridLayout) view, data, path);
    }

    private void bindGallery(BindingContext context, View view, DivGallery data, DivStatePath path) {
        DivGalleryBinder divGalleryBinder = this.galleryBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivRecyclerView");
        divGalleryBinder.bindView(context, (DivRecyclerView) view, data, path);
    }

    private void bindPager(BindingContext context, View view, DivPager data, DivStatePath path) {
        DivPagerBinder divPagerBinder = this.pagerBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivPagerView");
        divPagerBinder.bindView(context, (DivPagerView) view, data, path);
    }

    private void bindTabs(BindingContext context, View view, DivTabs data, DivStatePath path) {
        DivTabsBinder divTabsBinder = this.tabsBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivTabsLayout");
        divTabsBinder.bindView(context, (DivTabsLayout) view, data, this, path);
    }

    private void bindState(BindingContext context, View view, DivState data, DivStatePath path) {
        DivStateBinder divStateBinder = this.stateBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivStateLayout");
        divStateBinder.bindView(context, (DivStateLayout) view, data, path);
    }

    private void bindCustom(BindingContext context, View view, DivCustom data, DivStatePath path) {
        DivCustomBinder divCustomBinder = this.customBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivCustomWrapper");
        divCustomBinder.bindView(context, (DivCustomWrapper) view, data, path);
    }

    private void bindIndicator(BindingContext context, View view, DivIndicator data) {
        DivIndicatorBinder divIndicatorBinder = this.indicatorBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivPagerIndicatorView");
        divIndicatorBinder.bindView(context, (DivPagerIndicatorView) view, data);
    }

    private void bindSlider(BindingContext context, View view, DivSlider data, DivStatePath path) {
        DivSliderBinder divSliderBinder = this.sliderBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivSliderView");
        divSliderBinder.bindView(context, (DivSliderView) view, data, path);
    }

    private void bindInput(BindingContext context, View view, DivInput data, DivStatePath path) {
        DivInputBinder divInputBinder = this.inputBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivInputView");
        divInputBinder.bindView(context, (DivInputView) view, data, path);
    }

    private void bindSelect(BindingContext context, View view, DivSelect data, DivStatePath path) {
        DivSelectBinder divSelectBinder = this.selectBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivSelectView");
        divSelectBinder.bindView(context, (DivSelectView) view, data, path);
    }

    private void bindVideo(BindingContext context, View view, DivVideo data, DivStatePath path) {
        DivVideoBinder divVideoBinder = this.videoBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivVideoView");
        divVideoBinder.bindView(context, (DivVideoView) view, data, path);
    }

    private void bindSwitch(BindingContext context, View view, DivSwitch data, DivStatePath path) {
        DivSwitchBinder divSwitchBinder = this.switchBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivSwitchView");
        divSwitchBinder.bindView(context, (DivSwitchView) view, data, path);
    }

    private void bindLayoutParams(View view, DivBase data, ExpressionResolver resolver) {
        BaseDivViewExtensionsKt.applyMargins(view, data.getMargins(), resolver);
    }

    public void setDataWithoutBinding(BindingContext context, View view, Div div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        if (div instanceof Div.Text) {
            setDataWithoutBinding((DivLineHeightTextView) view, context, ((Div.Text) div).getValue());
            return;
        }
        if (div instanceof Div.Image) {
            setDataWithoutBinding((DivImageView) view, context, ((Div.Image) div).getValue());
            return;
        }
        if (div instanceof Div.GifImage) {
            setDataWithoutBinding((DivGifImageView) view, context, ((Div.GifImage) div).getValue());
            return;
        }
        if (div instanceof Div.Separator) {
            setDataWithoutBinding((DivSeparatorView) view, context, ((Div.Separator) div).getValue());
            return;
        }
        if (div instanceof Div.Container) {
            setContainerData(context, view, ((Div.Container) div).getValue());
            return;
        }
        if (div instanceof Div.Grid) {
            setGridData(context, view, ((Div.Grid) div).getValue());
            return;
        }
        if (div instanceof Div.Gallery) {
            setDataWithoutBinding((DivRecyclerView) view, context, ((Div.Gallery) div).getValue());
            return;
        }
        if (div instanceof Div.Pager) {
            setDataWithoutBinding((DivPagerView) view, context, ((Div.Pager) div).getValue());
            return;
        }
        if (div instanceof Div.Tabs) {
            setDataWithoutBinding((DivTabsLayout) view, context, ((Div.Tabs) div).getValue());
            return;
        }
        if (div instanceof Div.State) {
            setDataWithoutBinding((DivStateLayout) view, context, ((Div.State) div).getValue());
            return;
        }
        if (div instanceof Div.Custom) {
            setDataWithoutBinding((DivCustomWrapper) view, context, ((Div.Custom) div).getValue());
            return;
        }
        if (div instanceof Div.Indicator) {
            setDataWithoutBinding((DivPagerIndicatorView) view, context, ((Div.Indicator) div).getValue());
            return;
        }
        if (div instanceof Div.Slider) {
            setDataWithoutBinding((DivSliderView) view, context, ((Div.Slider) div).getValue());
            return;
        }
        if (div instanceof Div.Input) {
            setDataWithoutBinding((DivInputView) view, context, ((Div.Input) div).getValue());
            return;
        }
        if (div instanceof Div.Select) {
            setDataWithoutBinding((DivSelectView) view, context, ((Div.Select) div).getValue());
        } else if (div instanceof Div.Video) {
            setDataWithoutBinding((DivVideoView) view, context, ((Div.Video) div).getValue());
        } else {
            if (!(div instanceof Div.Switch)) {
                throw new NoWhenBranchMatchedException();
            }
            setDataWithoutBinding((DivSwitchView) view, context, ((Div.Switch) div).getValue());
        }
    }

    private <T extends DivBase> void setDataWithoutBinding(DivHolderView<T> divHolderView, BindingContext bindingContext, T t) {
        divHolderView.setDiv(t);
        divHolderView.setBindingContext(bindingContext);
    }

    private void setContainerData(BindingContext context, View view, DivContainer data) {
        DivContainerBinder divContainerBinder = this.containerBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        divContainerBinder.setDataWithoutBinding(context, (ViewGroup) view, data);
    }

    private void setGridData(BindingContext context, View view, DivGrid data) {
        DivGridBinder divGridBinder = this.gridBinder;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.widgets.DivGridLayout");
        divGridBinder.setDataWithoutBinding(context, (DivGridLayout) view, data);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    private BindingContext getBindingContext(BindingContext parentContext, Div div, DivStatePath path) {
        ExpressionResolver expressionResolver;
        if (!UtilsKt.getNeedLocalRuntime(div)) {
            return parentContext;
        }
        RuntimeStore runtimeStore = parentContext.getRuntimeStore();
        if (runtimeStore != null) {
            String fullPath$div_release = path.getFullPath$div_release();
            ExpressionResolver expressionResolver2 = parentContext.getExpressionResolver();
            List<DivVariable> variables = div.value().getVariables();
            ExpressionsRuntime orCreateRuntime$div_release = runtimeStore.getOrCreateRuntime$div_release(fullPath$div_release, (32 & 2) != 0 ? null : variables != null ? DivUtilKt.toVariables(variables) : null, (32 & 4) != 0 ? null : div.value().getVariableTriggers(), (32 & 8) != 0 ? null : div.value().getFunctions(), (32 & 16) != 0 ? null : expressionResolver2, (32 & 32) == 0 ? null : null);
            if (orCreateRuntime$div_release == null || (expressionResolver = orCreateRuntime$div_release.getExpressionResolver()) == null) {
                expressionResolver = parentContext.getExpressionResolver();
            }
        } else {
            expressionResolver = parentContext.getExpressionResolver();
        }
        return parentContext.getFor(expressionResolver);
    }
}
