package com.yandex.div.core.view2;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.b9;
import com.json.sdk.controller.f;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.Div2Context;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivCreationTracker;
import com.yandex.div.core.DivCustomContainerChildFactory;
import com.yandex.div.core.DivDataChangeListener;
import com.yandex.div.core.DivKit;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.DivViewConfig;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.ObserverList;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.Div2Component;
import com.yandex.div.core.dagger.Div2ViewComponent;
import com.yandex.div.core.downloader.DivDataChangedObserver;
import com.yandex.div.core.downloader.DivPatchApply;
import com.yandex.div.core.downloader.PersistentDivDataObserver;
import com.yandex.div.core.expression.ExpressionFallbacksHelperKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.core.player.DivVideoActionHandler;
import com.yandex.div.core.state.DivStateManager;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.DivViewState;
import com.yandex.div.core.state.StateConflictException;
import com.yandex.div.core.state.TemporaryDivStateCache;
import com.yandex.div.core.timer.DivTimerEventDispatcher;
import com.yandex.div.core.timer.TimerController;
import com.yandex.div.core.tooltip.DivTooltipController;
import com.yandex.div.core.util.DivTreeWalkKt;
import com.yandex.div.core.util.SingleTimeOnAttachCallback;
import com.yandex.div.core.view2.animations.DivComparator;
import com.yandex.div.core.view2.animations.DivTransitionHandler;
import com.yandex.div.core.view2.animations.DivTransitionsKt;
import com.yandex.div.core.view2.animations.SceneRootWatcher;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.divs.DivLayoutProviderVariablesHolder;
import com.yandex.div.core.view2.divs.widgets.DivAnimator;
import com.yandex.div.core.view2.divs.widgets.MediaReleaseViewVisitor;
import com.yandex.div.core.view2.divs.widgets.ReleaseUtils;
import com.yandex.div.core.view2.divs.widgets.ReleaseViewVisitor;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.core.view2.logging.bind.BindingEventReporter;
import com.yandex.div.core.view2.logging.bind.BindingEventReporterProvider;
import com.yandex.div.core.view2.logging.bind.ForceRebindReporter;
import com.yandex.div.core.view2.logging.bind.SimpleRebindReporter;
import com.yandex.div.core.view2.logging.patch.PatchEventReporter;
import com.yandex.div.core.view2.logging.patch.PatchEventReporterProvider;
import com.yandex.div.core.view2.reuse.ComplexRebindReporter;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.core.view2.reuse.RebindTask;
import com.yandex.div.core.view2.reuse.ReusableTokenList;
import com.yandex.div.data.VariableMutationException;
import com.yandex.div.histogram.Div2ViewHistogramReporter;
import com.yandex.div.histogram.HistogramCallType;
import com.yandex.div.histogram.RenderConfiguration;
import com.yandex.div.histogram.reporter.HistogramReporter;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.internal.util.ViewGroupsKt;
import com.yandex.div.internal.widget.FrameContainerLayout;
import com.yandex.div.internal.widget.menu.OverflowMenuSubscriber;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div.util.DivDataUtilsKt;
import com.yandex.div2.Div;
import com.yandex.div2.DivAccessibility;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivData;
import com.yandex.div2.DivPatch;
import com.yandex.div2.DivTransitionSelector;
import com.yandex.div2.DivTransitionTrigger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: Div2View.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000þ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0002ù\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB-\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010Ô\u0001\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020WH\u0016J\u001e\u0010×\u0001\u001a\u00030Õ\u00012\b\u0010Ø\u0001\u001a\u00030\u0085\u00012\b\u0010Ù\u0001\u001a\u00030\u009f\u0001H\u0016JP\u0010Ú\u0001\u001a\u00030Õ\u00012\t\u0010Û\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010Ü\u0001\u001a\u00020O2\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Ì\u00012\b\u0010Þ\u0001\u001a\u00030Ñ\u00012\b\u0010ß\u0001\u001a\u00030\u009f\u00012\u0007\u0010à\u0001\u001a\u00020\u00142\u0007\u0010á\u0001\u001a\u00020\u0014H\u0012J\u001a\u0010â\u0001\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030\u0098\u0001H\u0010¢\u0006\u0003\bã\u0001J\u0013\u0010ä\u0001\u001a\u00020\u00142\b\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\u001c\u0010ç\u0001\u001a\u00030Õ\u00012\u0007\u0010è\u0001\u001a\u0002042\u0007\u0010é\u0001\u001a\u000204H\u0016J'\u0010ê\u0001\u001a\u00020\u00142\u0007\u0010ë\u0001\u001a\u0002042\u0007\u0010é\u0001\u001a\u0002042\n\b\u0002\u0010ì\u0001\u001a\u00030\u0081\u0001H\u0017J\u0013\u0010í\u0001\u001a\u00030Õ\u00012\u0007\u0010î\u0001\u001a\u00020OH\u0012J$\u0010ï\u0001\u001a\u00030Õ\u00012\b\u0010ð\u0001\u001a\u00030\u009f\u00012\b\u0010ñ\u0001\u001a\u00030Ì\u0001H\u0010¢\u0006\u0003\bò\u0001J(\u0010ó\u0001\u001a\u00030\u009f\u00012\b\u0010Þ\u0001\u001a\u00030Ñ\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\t\b\u0002\u0010ô\u0001\u001a\u00020\u0014H\u0012J(\u0010õ\u0001\u001a\u00030\u009f\u00012\b\u0010Þ\u0001\u001a\u00030Ñ\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\t\b\u0002\u0010ô\u0001\u001a\u00020\u0014H\u0012J!\u0010ö\u0001\u001a\u00030Õ\u00012\u000f\u0010÷\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010¨\u0001H\u0010¢\u0006\u0003\bø\u0001J\n\u0010ù\u0001\u001a\u00030Õ\u0001H\u0012J\n\u0010ú\u0001\u001a\u00030Õ\u0001H\u0016J\n\u0010û\u0001\u001a\u00030Õ\u0001H\u0016J\u0013\u0010û\u0001\u001a\u00030Õ\u00012\u0007\u0010ü\u0001\u001a\u00020\u0014H\u0012J\n\u0010ý\u0001\u001a\u00030Õ\u0001H\u0016J%\u0010þ\u0001\u001a\u00020\u00142\u0007\u0010Ü\u0001\u001a\u00020O2\u0007\u0010Û\u0001\u001a\u00020O2\b\u0010ÿ\u0001\u001a\u00030\u0080\u0002H\u0012J\n\u0010\u0081\u0002\u001a\u00030Õ\u0001H\u0012J\u0014\u0010\u0082\u0002\u001a\u00030Õ\u00012\b\u0010\u0083\u0002\u001a\u00030Ñ\u0001H\u0012J\n\u0010\u0084\u0002\u001a\u00030Õ\u0001H\u0016J\n\u0010\u0085\u0002\u001a\u00030Õ\u0001H\u0016J\u0014\u0010\u0086\u0002\u001a\u00030Õ\u00012\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0014J\u0014\u0010\u0089\u0002\u001a\u00030Õ\u00012\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0016J\u001b\u0010\u008a\u0002\u001a\u00020\u00142\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0002\u001a\u00020\u0014H\u0012J\t\u0010\u008c\u0002\u001a\u00020;H\u0016J\f\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008e\u0002H\u0016J\t\u0010\u008f\u0002\u001a\u00020\u000bH\u0016J\u0010\u0010\u0090\u0002\u001a\u00030\u0091\u0002H\u0010¢\u0006\u0003\b\u0092\u0002J\t\u0010\u0093\u0002\u001a\u00020CH\u0016J\n\u0010\u0094\u0002\u001a\u00030\u0081\u0001H\u0016J\u001c\u0010\u0095\u0002\u001a\u0005\u0018\u00010 \u00012\b\u0010ð\u0001\u001a\u00030\u009f\u0001H\u0010¢\u0006\u0003\b\u0096\u0002J\t\u0010\u0097\u0002\u001a\u00020\u0000H\u0016J+\u0010\u0098\u0002\u001a\u00030Õ\u00012\b\u0010\u0099\u0002\u001a\u00030\u009a\u00022\t\b\u0002\u0010\u009b\u0002\u001a\u0002042\n\b\u0002\u0010\u009c\u0002\u001a\u00030\u0081\u0001H\u0017J*\u0010\u009d\u0002\u001a\u00020\u00142\b\u0010\u0099\u0002\u001a\u00030\u009a\u00022\t\b\u0002\u0010\u009b\u0002\u001a\u0002042\n\b\u0002\u0010\u009c\u0002\u001a\u00030\u0081\u0001H\u0017J\u0014\u0010\u009e\u0002\u001a\u00030Õ\u00012\b\u0010\u009f\u0002\u001a\u00030 \u0002H\u0016J\u0013\u0010¡\u0002\u001a\u00020\u00142\b\u0010¢\u0002\u001a\u00030£\u0002H\u0016J\u0013\u0010¤\u0002\u001a\u00030Õ\u00012\u0007\u0010¥\u0002\u001a\u000204H\u0016J\u0019\u0010¦\u0002\u001a\u00020\u00142\b\u0010ð\u0001\u001a\u00030\u009f\u0001H\u0010¢\u0006\u0003\b§\u0002J\u0013\u0010¨\u0002\u001a\u00020\u00142\b\u0010©\u0002\u001a\u00030ª\u0002H\u0016J/\u0010«\u0002\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00020¬\u00022\b\u0010P\u001a\u0004\u0018\u00010O2\b\u0010ñ\u0001\u001a\u00030Ì\u00012\b\u0010\u009c\u0002\u001a\u00030\u0081\u0001H\u0012J\n\u0010®\u0002\u001a\u00030Õ\u0001H\u0012J\n\u0010¯\u0002\u001a\u00030Õ\u0001H\u0012J\n\u0010°\u0002\u001a\u00030Õ\u0001H\u0014J\u0014\u0010±\u0002\u001a\u00030Õ\u00012\b\u0010²\u0002\u001a\u00030³\u0002H\u0016J\n\u0010´\u0002\u001a\u00030Õ\u0001H\u0014J7\u0010µ\u0002\u001a\u00030Õ\u00012\u0007\u0010¶\u0002\u001a\u00020\u00142\u0007\u0010·\u0002\u001a\u00020\b2\u0007\u0010¸\u0002\u001a\u00020\b2\u0007\u0010¹\u0002\u001a\u00020\b2\u0007\u0010º\u0002\u001a\u00020\bH\u0014J\u001c\u0010»\u0002\u001a\u00030Õ\u00012\u0007\u0010¼\u0002\u001a\u00020\b2\u0007\u0010½\u0002\u001a\u00020\bH\u0014J,\u0010¾\u0002\u001a\u00020\u00142\u0007\u0010Ü\u0001\u001a\u00020O2\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010O2\u000b\b\u0002\u0010¿\u0002\u001a\u0004\u0018\u00010CH\u0016J8\u0010À\u0002\u001a\u0005\u0018\u00010Á\u00022\t\u0010Û\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010Ü\u0001\u001a\u00020O2\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Ì\u00012\n\u0010Â\u0002\u001a\u0005\u0018\u00010Ì\u0001H\u0012J&\u0010Ã\u0002\u001a\u00030Õ\u00012\u0007\u0010Ü\u0001\u001a\u00020O2\u0007\u0010Ä\u0002\u001a\u00020\u00142\b\u0010ÿ\u0001\u001a\u00030Å\u0002H\u0012J\n\u0010Æ\u0002\u001a\u00030Õ\u0001H\u0016J\u0013\u0010Ç\u0002\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020WH\u0016J\u001a\u0010È\u0002\u001a\u00030Õ\u00012\b\u0010Ö\u0001\u001a\u00030\u0098\u0001H\u0010¢\u0006\u0003\bÉ\u0002J\n\u0010Ê\u0002\u001a\u00030Õ\u0001H\u0016J\u0012\u0010Ë\u0002\u001a\u0005\u0018\u00010Ì\u0001H\u0010¢\u0006\u0003\bÌ\u0002J\n\u0010Í\u0002\u001a\u00030Õ\u0001H\u0012J\u0013\u0010Î\u0002\u001a\u00030Õ\u00012\u0007\u0010Ï\u0002\u001a\u00020;H\u0016J\u001d\u0010Ð\u0002\u001a\u00020\u00142\t\u0010î\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010Ñ\u0002\u001a\u00020CH\u0016J(\u0010Ð\u0002\u001a\u00020\u00142\t\u0010î\u0001\u001a\u0004\u0018\u00010O2\t\u0010Ò\u0002\u001a\u0004\u0018\u00010O2\u0007\u0010Ñ\u0002\u001a\u00020CH\u0016J7\u0010Ó\u0002\u001a\u00020\u00142\t\u0010î\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010Ñ\u0002\u001a\u00020C2\u000f\u0010Ô\u0002\u001a\n\u0012\u0005\u0012\u00030ª\u00020Õ\u00022\u0007\u0010\u008b\u0002\u001a\u00020\u0014H\u0016J$\u0010Ö\u0002\u001a\u00030Õ\u00012\b\u0010ð\u0001\u001a\u00030\u009f\u00012\b\u0010×\u0002\u001a\u00030 \u0001H\u0010¢\u0006\u0003\bØ\u0002J\u001d\u0010Ù\u0002\u001a\u0005\u0018\u00010Ú\u00022\u0007\u0010Û\u0002\u001a\u0002042\u0006\u00103\u001a\u000204H\u0016J\u0013\u0010Ü\u0002\u001a\u00030Õ\u00012\u0007\u0010¥\u0002\u001a\u000204H\u0016J\u001c\u0010Ü\u0002\u001a\u00030Õ\u00012\u0007\u0010¥\u0002\u001a\u0002042\u0007\u0010Ý\u0002\u001a\u00020\u0014H\u0016J\n\u0010Þ\u0002\u001a\u00030Õ\u0001H\u0016J\u0014\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\u0006\u0010P\u001a\u00020OH\u0016J\n\u0010ß\u0002\u001a\u00030Õ\u0001H\u0016J\n\u0010à\u0002\u001a\u00030Õ\u0001H\u0012J\u0014\u0010á\u0002\u001a\u00030Õ\u00012\b\u0010â\u0002\u001a\u00030\u0093\u0001H\u0016J'\u0010ã\u0002\u001a\u00020\u00142\t\u0010Û\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010Ü\u0001\u001a\u00020O2\b\u0010ÿ\u0001\u001a\u00030ä\u0002H\u0012J\n\u0010å\u0002\u001a\u00030Õ\u0001H\u0016J-\u0010æ\u0002\u001a\u00030Õ\u00012\u000f\u0010ç\u0002\u001a\n\u0012\u0005\u0012\u00030ª\u00020Õ\u00022\u0007\u0010\u008b\u0002\u001a\u00020\u00142\u0007\u0010è\u0002\u001a\u00020\u0014H\u0016J\u001d\u0010é\u0002\u001a\u00030Õ\u00012\b\u0010ê\u0002\u001a\u00030ª\u00022\u0007\u0010\u008b\u0002\u001a\u00020\u0014H\u0016J\u001c\u0010é\u0002\u001a\u00030Õ\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0002\u001a\u00020\u0014H\u0016J\u001c\u0010ë\u0002\u001a\u0005\u0018\u00010Ì\u00012\b\u0010ð\u0001\u001a\u00030\u009f\u0001H\u0010¢\u0006\u0003\bì\u0002J\n\u0010í\u0002\u001a\u00030Õ\u0001H\u0016J\u0014\u0010î\u0002\u001a\u00030Õ\u00012\b\u0010\u0083\u0002\u001a\u00030Ñ\u0001H\u0012J/\u0010ï\u0002\u001a\u00020\u00142\b\u0010å\u0001\u001a\u00030æ\u00012\u0007\u0010Û\u0001\u001a\u00020O2\u0007\u0010ð\u0002\u001a\u00020O2\b\u0010ÿ\u0001\u001a\u00030ñ\u0002H\u0012J\n\u0010ò\u0002\u001a\u00030Õ\u0001H\u0016J\u001c\u0010ó\u0002\u001a\u0005\u0018\u00010Ì\u00012\b\u0010ð\u0001\u001a\u00030\u009f\u0001H\u0010¢\u0006\u0003\bô\u0002J\"\u0010õ\u0002\u001a\u00030Õ\u00012\u000b\b\u0002\u0010î\u0001\u001a\u0004\u0018\u00010O2\t\b\u0002\u0010Ñ\u0002\u001a\u00020CH\u0012J%\u0010ö\u0002\u001a\u00020\u00142\u0007\u0010î\u0001\u001a\u00020O2\u0007\u0010Ñ\u0002\u001a\u00020C2\b\u0010ÿ\u0001\u001a\u00030ä\u0002H\u0012J\u001c\u0010÷\u0002\u001a\u00030\u009f\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0002\u001a\u00020\u0014H\u0012J\n\u0010ø\u0002\u001a\u00030Õ\u0001H\u0012J\u0010\u0010\u0083\u0002\u001a\u0005\u0018\u00010Ñ\u0001*\u00020OH\u0012J\r\u0010³\u0001\u001a\u00020\u000b*\u00020OH\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0010@\u0010X\u0091\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0092\u0004¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00060(R\u00020\u0000X\u0092\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00148PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R(\u00105\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u0001048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\n <*\u0004\u0018\u00010;0;X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u0004\u0018\u00010@8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u00103\u001a\u00020C@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020JX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0092\u0004¢\u0006\u0002\n\u0000R(\u0010P\u001a\u0004\u0018\u00010O2\b\u00103\u001a\u0004\u0018\u00010O@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VX\u0092\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020_X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020c8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u000e\u0010f\u001a\u00020\u0014X\u0092\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001a\u00020\u00148\u0010@\u0010X\u0091\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bn\u0010\u0018\u001a\u0004\bo\u00102\"\u0004\bp\u0010qR\u001b\u0010r\u001a\u00020s8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bt\u0010uR\u001a\u0010x\u001a\u00020\u0014X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00102\"\u0004\bz\u0010qR\u0014\u0010{\u001a\u00020|X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R1\u0010\u007f\u001a\u001d\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\b0\u0080\u00010\u0080\u0001X\u0090\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010VX\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0086\u0001\u001a\u0002048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u00107R\u0018\u0010\u0088\u0001\u001a\u00030\u0089\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0010\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u008e\u0001\u001a\u00030\u0081\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010hX\u0092\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u0093\u00010VX\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R(\u0010\u009a\u0001\u001a\u00020C2\u0007\u0010\u0099\u0001\u001a\u00020C@PX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010F\"\u0005\b\u009c\u0001\u0010HR\u001e\u0010\u009d\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009f\u0001\u0012\u0005\u0012\u00030 \u00010\u009e\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0092\u000e¢\u0006\u0002\n\u0000R\u0018\u0010£\u0001\u001a\u00030¤\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R \u0010§\u0001\u001a\u0013\u0012\u000e\u0012\f <*\u0005\u0018\u00010©\u00010©\u00010¨\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u0016X\u0092\u000e¢\u0006\u0002\n\u0000R\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0016X\u0092\u000e¢\u0006\u0002\n\u0000R\"\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001X\u0090\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0016X\u0092\u000e¢\u0006\u0002\n\u0000R*\u0010³\u0001\u001a\u00020\u000b8\u0010@\u0010X\u0091\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b´\u0001\u0010\u0018\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u000f\u0010¹\u0001\u001a\u00020\u000bX\u0092\u000e¢\u0006\u0002\n\u0000R\u0018\u0010º\u0001\u001a\u00030»\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R%\u0010Â\u0001\u001a\u0010\u0012\u0004\u0012\u00020O\u0012\u0005\u0012\u00030Ã\u00010\u0080\u0001X\u0090\u0004¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0083\u0001R\u0018\u0010Å\u0001\u001a\u00030Æ\u0001X\u0090\u0004¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0018\u0010É\u0001\u001a\u0002048\u0012X\u0093\u0004¢\u0006\t\n\u0000\u0012\u0005\bÊ\u0001\u0010\u0018R\u001e\u0010Ë\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009f\u0001\u0012\u0005\u0012\u00030Ì\u00010\u009e\u0001X\u0092\u0004¢\u0006\u0002\n\u0000R'\u0010Í\u0001\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÎ\u0001\u00102\"\u0005\bÏ\u0001\u0010qR\u001e\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001*\u00020O8RX\u0092\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001¨\u0006ú\u0002"}, d2 = {"Lcom/yandex/div/core/view2/Div2View;", "Lcom/yandex/div/internal/widget/FrameContainerLayout;", "Lcom/yandex/div/core/DivViewFacade;", "context", "Lcom/yandex/div/core/Div2Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Lcom/yandex/div/core/Div2Context;Landroid/util/AttributeSet;I)V", "constructorCallTime", "", "(Lcom/yandex/div/core/Div2Context;Landroid/util/AttributeSet;IJ)V", "actionHandler", "Lcom/yandex/div/core/DivActionHandler;", "getActionHandler", "()Lcom/yandex/div/core/DivActionHandler;", "setActionHandler", "(Lcom/yandex/div/core/DivActionHandler;)V", "bindOnAttachEnabled", "", "bindOnAttachRunnable", "Lcom/yandex/div/core/util/SingleTimeOnAttachCallback;", "getBindOnAttachRunnable$div_release$annotations", "()V", "getBindOnAttachRunnable$div_release", "()Lcom/yandex/div/core/util/SingleTimeOnAttachCallback;", "setBindOnAttachRunnable$div_release", "(Lcom/yandex/div/core/util/SingleTimeOnAttachCallback;)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext$div_release", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext$div_release", "(Lcom/yandex/div/core/view2/BindingContext;)V", "bindingProvider", "Lcom/yandex/div/core/view2/ViewBindingProvider;", "bindingReporterProvider", "Lcom/yandex/div/core/view2/logging/bind/BindingEventReporterProvider;", "bulkActionsHandler", "Lcom/yandex/div/core/view2/Div2View$BulkActionHandler;", "clearVariablesListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getClearVariablesListener$div_release", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setClearVariablesListener$div_release", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "complexRebindEnabled", "complexRebindInProgress", "getComplexRebindInProgress$div_release", "()Z", "value", "", "componentName", "getComponentName", "()Ljava/lang/String;", "setComponentName", "(Ljava/lang/String;)V", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/yandex/div/core/DivViewConfig;", "kotlin.jvm.PlatformType", "getContext$div_release", "()Lcom/yandex/div/core/Div2Context;", "currentRebindReusableList", "Lcom/yandex/div/core/view2/reuse/ReusableTokenList;", "getCurrentRebindReusableList$div_release", "()Lcom/yandex/div/core/view2/reuse/ReusableTokenList;", "Lcom/yandex/div/DivDataTag;", "dataTag", "getDataTag", "()Lcom/yandex/div/DivDataTag;", "setDataTag$div_release", "(Lcom/yandex/div/DivDataTag;)V", "div2Component", "Lcom/yandex/div/core/dagger/Div2Component;", "getDiv2Component$div_release", "()Lcom/yandex/div/core/dagger/Div2Component;", "divBuilder", "Lcom/yandex/div/core/view2/Div2Builder;", "Lcom/yandex/div2/DivData;", "divData", "getDivData", "()Lcom/yandex/div2/DivData;", "setDivData$div_release", "(Lcom/yandex/div2/DivData;)V", "divDataChangedObservers", "", "Lcom/yandex/div/core/downloader/DivDataChangedObserver;", "divTimerEventDispatcher", "Lcom/yandex/div/core/timer/DivTimerEventDispatcher;", "getDivTimerEventDispatcher$div_release", "()Lcom/yandex/div/core/timer/DivTimerEventDispatcher;", "setDivTimerEventDispatcher$div_release", "(Lcom/yandex/div/core/timer/DivTimerEventDispatcher;)V", "divTransitionHandler", "Lcom/yandex/div/core/view2/animations/DivTransitionHandler;", "getDivTransitionHandler$div_release", "()Lcom/yandex/div/core/view2/animations/DivTransitionHandler;", "divVideoActionHandler", "Lcom/yandex/div/core/player/DivVideoActionHandler;", "getDivVideoActionHandler", "()Lcom/yandex/div/core/player/DivVideoActionHandler;", "drawWasSkipped", "expressionsRuntime", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "getExpressionsRuntime$div_release", "()Lcom/yandex/div/core/expression/ExpressionsRuntime;", "setExpressionsRuntime$div_release", "(Lcom/yandex/div/core/expression/ExpressionsRuntime;)V", "forceCanvasClipping", "getForceCanvasClipping$annotations", "getForceCanvasClipping", "setForceCanvasClipping", "(Z)V", "histogramReporter", "Lcom/yandex/div/histogram/Div2ViewHistogramReporter;", "getHistogramReporter", "()Lcom/yandex/div/histogram/Div2ViewHistogramReporter;", "histogramReporter$delegate", "Lkotlin/Lazy;", "inMiddleOfBind", "getInMiddleOfBind$div_release", "setInMiddleOfBind$div_release", "inputFocusTracker", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "getInputFocusTracker$div_release", "()Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "layoutSizes", "", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "getLayoutSizes$div_release", "()Ljava/util/Map;", "loadReferences", "Lcom/yandex/div/core/images/LoadReference;", "logId", "getLogId", "mediaReleaseViewVisitor", "Lcom/yandex/div/core/view2/divs/widgets/MediaReleaseViewVisitor;", "getMediaReleaseViewVisitor$div_release", "()Lcom/yandex/div/core/view2/divs/widgets/MediaReleaseViewVisitor;", "monitor", "", "oldExpressionResolver", "getOldExpressionResolver$div_release", "()Lcom/yandex/div/json/expressions/ExpressionResolver;", "oldExpressionsRuntime", "overflowMenuListeners", "Lcom/yandex/div/internal/widget/menu/OverflowMenuSubscriber$Listener;", "patchReporterProvider", "Lcom/yandex/div/core/view2/logging/patch/PatchEventReporterProvider;", "persistentDivDataObservers", "Lcom/yandex/div/core/ObserverList;", "Lcom/yandex/div/core/downloader/PersistentDivDataObserver;", "<set-?>", "prevDataTag", "getPrevDataTag", "setPrevDataTag$div_release", "propagatedAccessibilityModes", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/yandex/div2/DivAccessibility$Mode;", "rebindTask", "Lcom/yandex/div/core/view2/reuse/RebindTask;", "releaseViewVisitor", "Lcom/yandex/div/core/view2/divs/widgets/ReleaseViewVisitor;", "getReleaseViewVisitor$div_release", "()Lcom/yandex/div/core/view2/divs/widgets/ReleaseViewVisitor;", "renderConfig", "Lkotlin/Function0;", "Lcom/yandex/div/histogram/RenderConfiguration;", "reportBindingFinishedRunnable", "reportBindingResumedRunnable", "runtimeStore", "Lcom/yandex/div/core/expression/local/RuntimeStore;", "getRuntimeStore$div_release", "()Lcom/yandex/div/core/expression/local/RuntimeStore;", "setRuntimeStore$div_release", "(Lcom/yandex/div/core/expression/local/RuntimeStore;)V", "setActiveBindingRunnable", "stateId", "getStateId$div_release$annotations", "getStateId$div_release", "()J", "setStateId$div_release", "(J)V", "timeCreated", "tooltipController", "Lcom/yandex/div/core/tooltip/DivTooltipController;", "getTooltipController", "()Lcom/yandex/div/core/tooltip/DivTooltipController;", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "getVariableController", "()Lcom/yandex/div/core/expression/variables/VariableController;", "variablesHolders", "Lcom/yandex/div/core/view2/divs/DivLayoutProviderVariablesHolder;", "getVariablesHolders$div_release", "viewComponent", "Lcom/yandex/div/core/dagger/Div2ViewComponent;", "getViewComponent$div_release", "()Lcom/yandex/div/core/dagger/Div2ViewComponent;", "viewCreateCallType", "getViewCreateCallType$annotations", "viewToDivBindings", "Lcom/yandex/div2/Div;", "visualErrorsEnabled", "getVisualErrorsEnabled", "setVisualErrorsEnabled", "stateToBind", "Lcom/yandex/div2/DivData$State;", "getStateToBind", "(Lcom/yandex/div2/DivData;)Lcom/yandex/div2/DivData$State;", "addDivDataChangeObserver", "", "observer", "addLoadReference", "loadReference", "targetView", "addNewStateViewWithTransition", "oldData", "newData", "oldDiv", "newState", "newStateView", "allowsTransition", "bindBeforeViewAdded", "addPersistentDivDataObserver", "addPersistentDivDataObserver$div_release", "applyPatch", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div2/DivPatch;", "applyTimerCommand", "id", f.b.COMMAND, "applyVideoCommand", "divId", "expressionResolver", "attachVariableTriggers", "data", "bindViewToDiv", "view", "div", "bindViewToDiv$div_release", "buildViewAndUpdateState", "isUpdateTemporary", "buildViewAsyncAndUpdateState", "bulkActions", "function", "bulkActions$div_release", "cancelImageLoads", "cancelTooltips", "cleanup", "removeChildren", "clearSubscriptions", "complexRebind", "reporter", "Lcom/yandex/div/core/view2/reuse/ComplexRebindReporter;", "discardChildrenVisibility", "discardStateVisibility", "state", "discardVisibilityTracking", "dismissPendingOverflowMenus", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "forceSwitchToState", "temporary", "getConfig", "getCurrentState", "Lcom/yandex/div/core/state/DivViewState;", "getCurrentStateId", "getCustomContainerChildFactory", "Lcom/yandex/div/core/DivCustomContainerChildFactory;", "getCustomContainerChildFactory$div_release", "getDivTag", "getExpressionResolver", "getPropagatedAccessibilityMode", "getPropagatedAccessibilityMode$div_release", "getView", "handleAction", "action", "Lcom/yandex/div2/DivAction;", "reason", "resolver", "handleActionWithResult", "handleUri", "uri", "Landroid/net/Uri;", "hasScrollableViewUnder", "event", "Landroid/view/MotionEvent;", "hideTooltip", "tooltipId", "isDescendantAccessibilityMode", "isDescendantAccessibilityMode$div_release", "isInState", "statePath", "Lcom/yandex/div/core/state/DivStatePath;", "itemSequenceForTransition", "Lkotlin/sequences/Sequence;", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "notifyBindEnded", "notifyBindStarted", "onAttachedToWindow", "onConfigurationChangedOutside", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onLayout", "changed", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "prepareForRecycleOrCleanup", "newDataTag", "prepareTransition", "Landroidx/transition/Transition;", "newDiv", "rebind", "isAutoanimations", "Lcom/yandex/div/core/view2/logging/bind/SimpleRebindReporter;", "releaseMedia", "removeDivDataChangeObserver", "removePersistentDivDataObserver", "removePersistentDivDataObserver$div_release", "resetToInitialState", "rootDiv", "rootDiv$div_release", "sendCreationHistograms", "setConfig", "viewConfig", "setData", "tag", "oldDivData", "setDataWithStates", "paths", "", "setPropagatedAccessibilityMode", b9.a.t, "setPropagatedAccessibilityMode$div_release", "setVariable", "Lcom/yandex/div/data/VariableMutationException;", "name", "showTooltip", "multiple", "startDivAnimation", "stopDivAnimation", "stopLoadAndSubscriptions", "subscribe", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "switchToDivData", "Lcom/yandex/div/core/view2/logging/bind/ForceRebindReporter;", "switchToInitialState", "switchToMultipleStates", "pathList", "withAnimations", "switchToState", "path", "takeBindingDiv", "takeBindingDiv$div_release", "trackChildrenVisibility", "trackStateVisibility", "tryApplyPatch", "newDivData", "Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", "tryLogVisibility", "unbindViewFromDiv", "unbindViewFromDiv$div_release", "updateExpressionsRuntime", "updateNow", "updateState", "updateTimers", "BulkActionHandler", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class Div2View extends FrameContainerLayout implements DivViewFacade {
    private DivActionHandler actionHandler;
    private final boolean bindOnAttachEnabled;
    private SingleTimeOnAttachCallback bindOnAttachRunnable;
    private BindingContext bindingContext;
    private final ViewBindingProvider bindingProvider;
    private final BindingEventReporterProvider bindingReporterProvider;
    private final BulkActionHandler bulkActionsHandler;
    private ViewTreeObserver.OnPreDrawListener clearVariablesListener;
    private final boolean complexRebindEnabled;
    private DivViewConfig config;
    private final long constructorCallTime;
    private final Div2Context context;
    private DivDataTag dataTag;
    private final Div2Component div2Component;
    private final Div2Builder divBuilder;
    private DivData divData;
    private final List<DivDataChangedObserver> divDataChangedObservers;
    private DivTimerEventDispatcher divTimerEventDispatcher;
    private final DivTransitionHandler divTransitionHandler;
    private boolean drawWasSkipped;
    private ExpressionsRuntime expressionsRuntime;
    private boolean forceCanvasClipping;

    /* JADX INFO: renamed from: histogramReporter$delegate, reason: from kotlin metadata */
    private final Lazy histogramReporter;
    private boolean inMiddleOfBind;
    private final InputFocusTracker inputFocusTracker;
    private final Map<ExpressionResolver, Map<String, Integer>> layoutSizes;
    private final List<LoadReference> loadReferences;
    private final Object monitor;
    private ExpressionsRuntime oldExpressionsRuntime;
    private final List<OverflowMenuSubscriber.Listener> overflowMenuListeners;
    private final PatchEventReporterProvider patchReporterProvider;
    private final ObserverList<PersistentDivDataObserver> persistentDivDataObservers;
    private DivDataTag prevDataTag;
    private final WeakHashMap<View, DivAccessibility.Mode> propagatedAccessibilityModes;
    private RebindTask rebindTask;
    private final Function0<RenderConfiguration> renderConfig;
    private SingleTimeOnAttachCallback reportBindingFinishedRunnable;
    private SingleTimeOnAttachCallback reportBindingResumedRunnable;
    private RuntimeStore runtimeStore;
    private SingleTimeOnAttachCallback setActiveBindingRunnable;
    private long stateId;
    private long timeCreated;
    private final Map<DivData, DivLayoutProviderVariablesHolder> variablesHolders;
    private final Div2ViewComponent viewComponent;
    private final String viewCreateCallType;
    private final WeakHashMap<View, Div> viewToDivBindings;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Div2View(Div2Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Div2View(Div2Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getBindOnAttachRunnable$div_release$annotations() {
    }

    public static /* synthetic */ void getForceCanvasClipping$annotations() {
    }

    public static /* synthetic */ void getStateId$div_release$annotations() {
    }

    @HistogramCallType
    private static /* synthetic */ void getViewCreateCallType$annotations() {
    }

    public final boolean applyVideoCommand(String divId, String command) {
        Intrinsics.checkNotNullParameter(divId, "divId");
        Intrinsics.checkNotNullParameter(command, "command");
        return applyVideoCommand$default(this, divId, command, null, 4, null);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public Div2View getView() {
        return this;
    }

    public final void handleAction(DivAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        handleAction$default(this, action, null, null, 6, null);
    }

    public final void handleAction(DivAction action, String reason) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        handleAction$default(this, action, reason, null, 4, null);
    }

    public final boolean handleActionWithResult(DivAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return handleActionWithResult$default(this, action, null, null, 6, null);
    }

    public final boolean handleActionWithResult(DivAction action, String reason) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return handleActionWithResult$default(this, action, reason, null, 4, null);
    }

    /* synthetic */ Div2View(Div2Context div2Context, AttributeSet attributeSet, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(div2Context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, j);
    }

    /* JADX INFO: renamed from: getContext$div_release, reason: from getter */
    public Div2Context getContext() {
        return this.context;
    }

    private Div2View(Div2Context div2Context, AttributeSet attributeSet, int i, long j) {
        super(div2Context, attributeSet, i);
        this.context = div2Context;
        this.constructorCallTime = j;
        this.div2Component = getContext().getDiv2Component();
        this.viewComponent = getDiv2Component().viewComponent().divView(this).build();
        this.bindOnAttachEnabled = getDiv2Component().isBindOnAttachEnabled();
        this.complexRebindEnabled = getDiv2Component().isComplexRebindEnabled();
        this.bindingProvider = getViewComponent().getBindingProvider();
        this.bindingReporterProvider = new BindingEventReporterProvider(this);
        this.patchReporterProvider = new PatchEventReporterProvider(this);
        Div2Builder div2Builder = getContext().getDiv2Component().getDiv2Builder();
        Intrinsics.checkNotNullExpressionValue(div2Builder, "context.div2Component.div2Builder");
        this.divBuilder = div2Builder;
        this.loadReferences = new ArrayList();
        this.overflowMenuListeners = new ArrayList();
        this.divDataChangedObservers = new ArrayList();
        this.persistentDivDataObservers = new ObserverList<>();
        this.viewToDivBindings = new WeakHashMap<>();
        this.propagatedAccessibilityModes = new WeakHashMap<>();
        this.bulkActionsHandler = new BulkActionHandler();
        this.bindingContext = BindingContext.INSTANCE.createEmpty(this);
        this.monitor = new Object();
        this.stateId = DivDataUtilsKt.getINVALID_STATE_ID(DivData.INSTANCE);
        this.config = DivViewConfig.DEFAULT;
        this.renderConfig = new Function0<RenderConfiguration>() { // from class: com.yandex.div.core.view2.Div2View$renderConfig$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RenderConfiguration invoke() {
                return DivKit.INSTANCE.getInstance(this.this$0.getContext()).getComponent().getHistogramRecordConfiguration().getRenderConfiguration().get();
            }
        };
        this.histogramReporter = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Div2ViewHistogramReporter>() { // from class: com.yandex.div.core.view2.Div2View$histogramReporter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Div2ViewHistogramReporter invoke() {
                final Div2View div2View = this.this$0;
                return new Div2ViewHistogramReporter(new Function0<HistogramReporter>() { // from class: com.yandex.div.core.view2.Div2View$histogramReporter$2.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final HistogramReporter invoke() {
                        HistogramReporter histogramReporter = div2View.getDiv2Component().getHistogramReporter();
                        Intrinsics.checkNotNullExpressionValue(histogramReporter, "div2Component.histogramReporter");
                        return histogramReporter;
                    }
                }, this.this$0.renderConfig);
            }
        });
        this.inputFocusTracker = getViewComponent().getInputFocusTracker();
        this.layoutSizes = new LinkedHashMap();
        this.variablesHolders = new LinkedHashMap();
        DivDataTag INVALID = DivDataTag.INVALID;
        Intrinsics.checkNotNullExpressionValue(INVALID, "INVALID");
        this.dataTag = INVALID;
        DivDataTag INVALID2 = DivDataTag.INVALID;
        Intrinsics.checkNotNullExpressionValue(INVALID2, "INVALID");
        this.prevDataTag = INVALID2;
        this.timeCreated = -1L;
        this.viewCreateCallType = getDiv2Component().getDivCreationTracker().getViewCreateCallType();
        this.drawWasSkipped = true;
        this.divTransitionHandler = new DivTransitionHandler(this);
        this.timeCreated = DivCreationTracker.INSTANCE.getCurrentUptimeMillis();
        getDiv2Component().getReleaseManager().observeDivLifecycle(this);
    }

    /* JADX INFO: renamed from: getDiv2Component$div_release, reason: from getter */
    public Div2Component getDiv2Component() {
        return this.div2Component;
    }

    /* JADX INFO: renamed from: getViewComponent$div_release, reason: from getter */
    public Div2ViewComponent getViewComponent() {
        return this.viewComponent;
    }

    private DivVideoActionHandler getDivVideoActionHandler() {
        DivVideoActionHandler divVideoActionHandler = getDiv2Component().getDivVideoActionHandler();
        Intrinsics.checkNotNullExpressionValue(divVideoActionHandler, "div2Component.divVideoActionHandler");
        return divVideoActionHandler;
    }

    private DivTooltipController getTooltipController() {
        DivTooltipController tooltipController = getDiv2Component().getTooltipController();
        Intrinsics.checkNotNullExpressionValue(tooltipController, "div2Component.tooltipController");
        return tooltipController;
    }

    public ReleaseViewVisitor getReleaseViewVisitor$div_release() {
        return getViewComponent().getReleaseViewVisitor();
    }

    public MediaReleaseViewVisitor getMediaReleaseViewVisitor$div_release() {
        return getViewComponent().getMediaReleaseViewVisitor();
    }

    /* JADX INFO: renamed from: getExpressionsRuntime$div_release, reason: from getter */
    public ExpressionsRuntime getExpressionsRuntime() {
        return this.expressionsRuntime;
    }

    public void setExpressionsRuntime$div_release(ExpressionsRuntime expressionsRuntime) {
        this.expressionsRuntime = expressionsRuntime;
    }

    private VariableController getVariableController() {
        ExpressionsRuntime expressionsRuntime = getExpressionsRuntime();
        if (expressionsRuntime != null) {
            return expressionsRuntime.getVariableController();
        }
        return null;
    }

    public ExpressionResolver getOldExpressionResolver$div_release() {
        ExpressionResolver expressionResolver;
        ExpressionsRuntime expressionsRuntime = this.oldExpressionsRuntime;
        return (expressionsRuntime == null || (expressionResolver = expressionsRuntime.getExpressionResolver()) == null) ? ExpressionResolver.EMPTY : expressionResolver;
    }

    /* JADX INFO: renamed from: getRuntimeStore$div_release, reason: from getter */
    public RuntimeStore getRuntimeStore() {
        return this.runtimeStore;
    }

    public void setRuntimeStore$div_release(RuntimeStore runtimeStore) {
        this.runtimeStore = runtimeStore;
    }

    /* JADX INFO: renamed from: getInMiddleOfBind$div_release, reason: from getter */
    public boolean getInMiddleOfBind() {
        return this.inMiddleOfBind;
    }

    public void setInMiddleOfBind$div_release(boolean z) {
        this.inMiddleOfBind = z;
    }

    /* JADX INFO: renamed from: getBindingContext$div_release, reason: from getter */
    public BindingContext getBindingContext() {
        return this.bindingContext;
    }

    public void setBindingContext$div_release(BindingContext bindingContext) {
        Intrinsics.checkNotNullParameter(bindingContext, "<set-?>");
        this.bindingContext = bindingContext;
    }

    /* JADX INFO: renamed from: getDivTimerEventDispatcher$div_release, reason: from getter */
    public DivTimerEventDispatcher getDivTimerEventDispatcher() {
        return this.divTimerEventDispatcher;
    }

    public void setDivTimerEventDispatcher$div_release(DivTimerEventDispatcher divTimerEventDispatcher) {
        this.divTimerEventDispatcher = divTimerEventDispatcher;
    }

    public boolean getForceCanvasClipping() {
        return this.forceCanvasClipping;
    }

    public void setForceCanvasClipping(boolean z) {
        this.forceCanvasClipping = z;
    }

    /* JADX INFO: renamed from: getBindOnAttachRunnable$div_release, reason: from getter */
    public SingleTimeOnAttachCallback getBindOnAttachRunnable() {
        return this.bindOnAttachRunnable;
    }

    public void setBindOnAttachRunnable$div_release(SingleTimeOnAttachCallback singleTimeOnAttachCallback) {
        this.bindOnAttachRunnable = singleTimeOnAttachCallback;
    }

    /* JADX INFO: renamed from: getStateId$div_release, reason: from getter */
    public long getStateId() {
        return this.stateId;
    }

    public void setStateId$div_release(long j) {
        this.stateId = j;
    }

    public ReusableTokenList getCurrentRebindReusableList$div_release() {
        RebindTask rebindTask;
        if (getComplexRebindInProgress$div_release() && (rebindTask = this.rebindTask) != null) {
            return rebindTask.getReusableList();
        }
        return null;
    }

    public boolean getComplexRebindInProgress$div_release() {
        RebindTask rebindTask = this.rebindTask;
        if (rebindTask != null) {
            return rebindTask.getRebindInProgress();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Div2ViewHistogramReporter getHistogramReporter() {
        return (Div2ViewHistogramReporter) this.histogramReporter.getValue();
    }

    /* JADX INFO: renamed from: getInputFocusTracker$div_release, reason: from getter */
    public InputFocusTracker getInputFocusTracker() {
        return this.inputFocusTracker;
    }

    public Map<ExpressionResolver, Map<String, Integer>> getLayoutSizes$div_release() {
        return this.layoutSizes;
    }

    public Map<DivData, DivLayoutProviderVariablesHolder> getVariablesHolders$div_release() {
        return this.variablesHolders;
    }

    /* JADX INFO: renamed from: getClearVariablesListener$div_release, reason: from getter */
    public ViewTreeObserver.OnPreDrawListener getClearVariablesListener() {
        return this.clearVariablesListener;
    }

    public void setClearVariablesListener$div_release(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        this.clearVariablesListener = onPreDrawListener;
    }

    public DivDataTag getDataTag() {
        return this.dataTag;
    }

    public void setDataTag$div_release(DivDataTag value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setPrevDataTag$div_release(this.dataTag);
        this.dataTag = value;
        this.bindingProvider.update(value, getDivData());
    }

    public DivDataTag getPrevDataTag() {
        return this.prevDataTag;
    }

    public void setPrevDataTag$div_release(DivDataTag divDataTag) {
        Intrinsics.checkNotNullParameter(divDataTag, "<set-?>");
        this.prevDataTag = divDataTag;
    }

    public DivData getDivData() {
        return this.divData;
    }

    public void setDivData$div_release(DivData divData) {
        this.divData = divData;
        updateExpressionsRuntime$default(this, null, null, 3, null);
        updateTimers();
        this.bindingProvider.update(getDataTag(), this.divData);
    }

    static /* synthetic */ void updateExpressionsRuntime$default(Div2View div2View, DivData divData, DivDataTag divDataTag, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateExpressionsRuntime");
        }
        if ((i & 1) != 0) {
            divData = div2View.getDivData();
        }
        if ((i & 2) != 0) {
            divDataTag = div2View.getDataTag();
        }
        div2View.updateExpressionsRuntime(divData, divDataTag);
    }

    private void updateExpressionsRuntime(DivData data, DivDataTag tag) {
        RuntimeStore runtimeStore;
        RuntimeStore runtimeStore2;
        if (data == null) {
            return;
        }
        this.oldExpressionsRuntime = getExpressionsRuntime();
        setExpressionsRuntime$div_release(getDiv2Component().getExpressionsRuntimeProvider().getOrCreate$div_release(tag, data, this));
        ExpressionsRuntime expressionsRuntime = getExpressionsRuntime();
        if (expressionsRuntime != null && (runtimeStore2 = expressionsRuntime.getRuntimeStore()) != null) {
            runtimeStore2.updateSubscriptions$div_release();
        }
        if (!Intrinsics.areEqual(this.oldExpressionsRuntime, getExpressionsRuntime()) && (runtimeStore = getRuntimeStore()) != null) {
            runtimeStore.clearBindings$div_release();
        }
        ExpressionsRuntime expressionsRuntime2 = getExpressionsRuntime();
        setRuntimeStore$div_release(expressionsRuntime2 != null ? expressionsRuntime2.getRuntimeStore() : null);
        setBindingContext$div_release(getBindingContext().getFor(getExpressionResolver(), getRuntimeStore()));
    }

    private void attachVariableTriggers(final DivData data) {
        final DivData.State state = state(data);
        if (state == null) {
            return;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View$attachVariableTriggers$attachTriggers$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getViewComponent().getRuntimeVisitor().createAndAttachRuntimes(state.div, DivStatePath.INSTANCE.fromState(this.this$0.stateId(data)), this.this$0);
            }
        };
        if (this.bindOnAttachEnabled) {
            this.setActiveBindingRunnable = new SingleTimeOnAttachCallback(this, new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View.attachVariableTriggers.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    private void updateTimers() {
        DivTimerEventDispatcher divTimerEventDispatcher;
        DivData divData = getDivData();
        if (divData == null) {
            return;
        }
        DivTimerEventDispatcher orCreate$div_release = getDiv2Component().getDivTimersControllerProvider().getOrCreate$div_release(getDataTag(), divData, getExpressionResolver());
        if (!Intrinsics.areEqual(getDivTimerEventDispatcher(), orCreate$div_release) && (divTimerEventDispatcher = getDivTimerEventDispatcher()) != null) {
            divTimerEventDispatcher.onDetach(this);
        }
        setDivTimerEventDispatcher$div_release(orCreate$div_release);
        if (orCreate$div_release != null) {
            orCreate$div_release.onAttach(this);
        }
    }

    public String getLogId() {
        String str;
        DivData divData = getDivData();
        return (divData == null || (str = divData.logId) == null) ? "" : str;
    }

    public DivActionHandler getActionHandler() {
        return this.actionHandler;
    }

    public void setActionHandler(DivActionHandler divActionHandler) {
        this.actionHandler = divActionHandler;
    }

    public String getComponentName() {
        return getHistogramReporter().getComponent();
    }

    public void setComponentName(String str) {
        getHistogramReporter().setComponent(str);
    }

    /* JADX INFO: renamed from: getDivTransitionHandler$div_release, reason: from getter */
    public DivTransitionHandler getDivTransitionHandler() {
        return this.divTransitionHandler;
    }

    public /* synthetic */ Div2View(Div2Context div2Context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(div2Context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Div2View(Div2Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, SystemClock.uptimeMillis());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean setData(DivData data, DivDataTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return setData(data, getDivData(), tag);
    }

    public boolean setData(DivData data, DivData oldDivData, DivDataTag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.monitor) {
            BindingEventReporter bindingEventReporter = this.bindingReporterProvider.get(oldDivData, data);
            boolean zUpdateNow = false;
            if (data == null) {
                bindingEventReporter.onBindingFatalNoData();
                return false;
            }
            if (getDivData() == data) {
                bindingEventReporter.onBindingFatalSameData();
                return false;
            }
            notifyBindStarted();
            SingleTimeOnAttachCallback bindOnAttachRunnable = getBindOnAttachRunnable();
            if (bindOnAttachRunnable != null) {
                bindOnAttachRunnable.cancel();
            }
            getHistogramReporter().onRenderStarted();
            DivData divData = getDivData();
            if (divData != null) {
                oldDivData = divData;
            }
            updateExpressionsRuntime(data, tag);
            setDataTag$div_release(tag);
            for (DivData.State state : data.states) {
                DivPreloader preloader = getDiv2Component().getPreloader();
                Intrinsics.checkNotNullExpressionValue(preloader, "div2Component.preloader");
                DivPreloader.preload$default(preloader, state.div, getExpressionResolver(), null, 4, null);
            }
            boolean zIsDivDataReplaceable = DivComparator.INSTANCE.isDivDataReplaceable(oldDivData, data, getStateId(), getOldExpressionResolver$div_release(), getExpressionResolver(), bindingEventReporter);
            if (oldDivData == null || DivTransitionsKt.allowsTransitionsOnDataChange(data, getExpressionResolver())) {
                zUpdateNow = updateNow(data, tag, bindingEventReporter);
            } else if (zIsDivDataReplaceable || !this.complexRebindEnabled || !(getView().getChildAt(0) instanceof ViewGroup) || !complexRebind(data, oldDivData, bindingEventReporter)) {
                if (zIsDivDataReplaceable) {
                    rebind(data, false, bindingEventReporter);
                } else {
                    zUpdateNow = updateNow(data, tag, bindingEventReporter);
                }
            }
            getDiv2Component().getDivBinder().attachIndicators$div_release();
            sendCreationHistograms();
            this.oldExpressionsRuntime = getExpressionsRuntime();
            notifyBindEnded();
            return zUpdateNow;
        }
    }

    public boolean setDataWithStates(DivData data, DivDataTag tag, List<DivStatePath> paths, boolean temporary) {
        boolean zUpdateNow;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(paths, "paths");
        synchronized (this.monitor) {
            BindingEventReporter bindingEventReporter = this.bindingReporterProvider.get(getDivData(), data);
            if (data == null) {
                bindingEventReporter.onBindingFatalNoData();
                return false;
            }
            if (getDivData() == data) {
                bindingEventReporter.onBindingFatalSameData();
                return false;
            }
            notifyBindStarted();
            SingleTimeOnAttachCallback bindOnAttachRunnable = getBindOnAttachRunnable();
            if (bindOnAttachRunnable != null) {
                bindOnAttachRunnable.cancel();
            }
            getHistogramReporter().onRenderStarted();
            DivData divData = getDivData();
            updateExpressionsRuntime(data, tag);
            boolean zIsDivDataReplaceable = DivComparator.INSTANCE.isDivDataReplaceable(divData, data, getStateId(), getOldExpressionResolver$div_release(), getExpressionResolver(), bindingEventReporter);
            setDataTag$div_release(tag);
            for (DivData.State state : data.states) {
                DivPreloader preloader = getDiv2Component().getPreloader();
                Intrinsics.checkNotNullExpressionValue(preloader, "div2Component.preloader");
                DivPreloader.preload$default(preloader, state.div, getExpressionResolver(), null, 4, null);
            }
            for (DivStatePath divStatePath : paths) {
                DivStateManager stateManager = getDiv2Component().getStateManager();
                String id = getDivTag().getId();
                Intrinsics.checkNotNullExpressionValue(id, "divTag.id");
                stateManager.updateStates(id, divStatePath, temporary);
            }
            if (divData == null) {
                zUpdateNow = updateNow(data, tag, bindingEventReporter);
            } else {
                if (zIsDivDataReplaceable || !this.complexRebindEnabled || !(getView().getChildAt(0) instanceof ViewGroup) || !complexRebind(data, divData, bindingEventReporter)) {
                    if (zIsDivDataReplaceable) {
                        rebind(data, false, bindingEventReporter);
                    } else {
                        zUpdateNow = updateNow(data, tag, bindingEventReporter);
                    }
                }
                zUpdateNow = true;
            }
            getDiv2Component().getDivBinder().attachIndicators$div_release();
            sendCreationHistograms();
            this.oldExpressionsRuntime = getExpressionsRuntime();
            notifyBindEnded();
            return zUpdateNow;
        }
    }

    private void notifyBindStarted() {
        if (getInMiddleOfBind()) {
            DivActionTypedUtilsKt.logError(this, new RuntimeException("New binding started when previous not ended!"));
        }
        setInMiddleOfBind$div_release(true);
        Iterator<PersistentDivDataObserver> it = this.persistentDivDataObservers.iterator();
        while (it.hasNext()) {
            it.next().onBeforeDivDataChanged();
        }
    }

    private void notifyBindEnded() {
        setInMiddleOfBind$div_release(false);
        Iterator<PersistentDivDataObserver> it = this.persistentDivDataObservers.iterator();
        while (it.hasNext()) {
            it.next().onAfterDivDataChanged();
        }
    }

    public boolean applyPatch(DivPatch patch) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        synchronized (this.monitor) {
            DivData divData = getDivData();
            if (divData == null) {
                return false;
            }
            DivData divDataCreatePatchedDivData = getDiv2Component().getPatchManager().createPatchedDivData(divData, getDataTag(), patch, getExpressionResolver());
            PatchEventReporter patchEventReporter = this.patchReporterProvider.get(patch);
            if (divDataCreatePatchedDivData != null && tryApplyPatch(patch, divData, divDataCreatePatchedDivData, patchEventReporter)) {
                getDiv2Component().getPatchManager().removePatch(getDataTag());
                Iterator<T> it = this.divDataChangedObservers.iterator();
                while (it.hasNext()) {
                    ((DivDataChangedObserver) it.next()).onDivPatchApplied(divDataCreatePatchedDivData);
                }
                attachVariableTriggers(divDataCreatePatchedDivData);
                getDiv2Component().getDivBinder().attachIndicators$div_release();
                patchEventReporter.onPatchSuccess();
                DivActionBinder actionBinder = getDiv2Component().getActionBinder();
                Intrinsics.checkNotNullExpressionValue(actionBinder, "div2Component.actionBinder");
                DivActionBinder.handleActions$div_release$default(actionBinder, this, getExpressionResolver(), patch.onAppliedActions, DivActionHandler.DivActionReason.PATCH, null, 16, null);
                return true;
            }
            DivActionBinder actionBinder2 = getDiv2Component().getActionBinder();
            Intrinsics.checkNotNullExpressionValue(actionBinder2, "div2Component.actionBinder");
            DivActionBinder.handleActions$div_release$default(actionBinder2, this, getExpressionResolver(), patch.onFailedActions, DivActionHandler.DivActionReason.PATCH, null, 16, null);
            patchEventReporter.onPatchNoState();
            return false;
        }
    }

    private boolean tryApplyPatch(DivPatch patch, DivData oldData, DivData newDivData, PatchEventReporter reporter) {
        Div div;
        DivBase divBaseValue;
        DivData.State stateToBind = getStateToBind(newDivData);
        if (stateToBind == null) {
            return false;
        }
        SingleTimeOnAttachCallback bindOnAttachRunnable = getBindOnAttachRunnable();
        if (bindOnAttachRunnable != null) {
            bindOnAttachRunnable.cancel();
        }
        DivData.State state = state(oldData);
        Object obj = null;
        Div div2 = state != null ? state.div : null;
        for (Object obj2 : patch.changes) {
            if (Intrinsics.areEqual(((DivPatch.Change) obj2).id, (div2 == null || (divBaseValue = div2.value()) == null) ? null : divBaseValue.getId())) {
                obj = obj2;
                break;
            }
        }
        DivPatch.Change change = (DivPatch.Change) obj;
        if (change == null) {
            rebind(oldData, false, reporter);
            setDivData$div_release(newDivData);
            DivBinder divBinder = getDiv2Component().getDivBinder();
            BindingContext bindingContext = getBindingContext();
            View childAt = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
            divBinder.setDataWithoutBinding(bindingContext, childAt, stateToBind.div);
            return true;
        }
        List<Div> list = change.items;
        List<Div> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.ERROR)) {
                kLog.print(6, DivPatchApply.TAG, "Unable to patch root div because there is no div in patch.");
            }
            return false;
        }
        if (list.size() > 1) {
            KLog kLog2 = KLog.INSTANCE;
            if (kLog2.isAtLeast(Severity.ERROR)) {
                kLog2.print(6, DivPatchApply.TAG, "More than 1 div in patch for root div. The first was applied.");
            }
            div = list.get(0);
        } else {
            div = list.get(0);
        }
        Div div3 = div;
        BindingEventReporter bindingEventReporter = this.bindingReporterProvider.get(newDivData, oldData);
        boolean zAreDivsReplaceable = DivComparator.INSTANCE.areDivsReplaceable(div2, div3, getExpressionResolver(), getExpressionResolver(), bindingEventReporter);
        if (!zAreDivsReplaceable && this.complexRebindEnabled && (getView().getChildAt(0) instanceof ViewGroup) && complexRebind(newDivData, oldData, bindingEventReporter)) {
            return true;
        }
        if (zAreDivsReplaceable) {
            rebind(newDivData, false, reporter);
            return true;
        }
        return updateNow(newDivData, getDataTag(), reporter);
    }

    private boolean updateNow(DivData data, DivDataTag tag, ForceRebindReporter reporter) {
        DivData divData = getDivData();
        if (divData == null) {
            getHistogramReporter().onBindingStarted();
        } else {
            getHistogramReporter().onRebindingStarted();
        }
        cleanup(false);
        setDataTag$div_release(tag);
        setDivData$div_release(data);
        boolean zSwitchToDivData = switchToDivData(divData, data, reporter);
        attachVariableTriggers(data);
        if (divData != null) {
            getHistogramReporter().onRebindingFinished();
            return zSwitchToDivData;
        }
        if (!this.bindOnAttachEnabled) {
            getHistogramReporter().onBindingFinished();
            return zSwitchToDivData;
        }
        getHistogramReporter().onBindingPaused();
        Div2View div2View = this;
        this.reportBindingResumedRunnable = new SingleTimeOnAttachCallback(div2View, new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View.updateNow.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Div2View.this.getHistogramReporter().onBindingResumed();
            }
        });
        this.reportBindingFinishedRunnable = new SingleTimeOnAttachCallback(div2View, new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View.updateNow.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Div2View.this.getHistogramReporter().onBindingFinished();
            }
        });
        return zSwitchToDivData;
    }

    public void tryLogVisibility() {
        List<DivData.State> list;
        DivData divData = getDivData();
        DivData.State state = null;
        Object obj = null;
        state = null;
        if (divData != null && (list = divData.states) != null) {
            for (Object obj2 : list) {
                if (((DivData.State) obj2).stateId == getStateId()) {
                    obj = obj2;
                    break;
                }
            }
            state = (DivData.State) obj;
        }
        if (state != null) {
            trackStateVisibility(state);
        }
        trackChildrenVisibility();
    }

    public void discardVisibilityTracking() {
        List<DivData.State> list;
        DivData divData = getDivData();
        DivData.State state = null;
        Object obj = null;
        state = null;
        if (divData != null && (list = divData.states) != null) {
            for (Object obj2 : list) {
                if (((DivData.State) obj2).stateId == getStateId()) {
                    obj = obj2;
                    break;
                }
            }
            state = (DivData.State) obj;
        }
        if (state != null) {
            discardStateVisibility(state);
        }
        discardChildrenVisibility();
    }

    private void trackStateVisibility(DivData.State state) {
        DivVisibilityActionTracker visibilityActionTracker = getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "div2Component.visibilityActionTracker");
        DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, this, getExpressionResolver(), getView(), state.div, null, 16, null);
    }

    private void discardStateVisibility(DivData.State state) {
        DivVisibilityActionTracker visibilityActionTracker = getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "div2Component.visibilityActionTracker");
        DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, this, getExpressionResolver(), null, state.div, null, 16, null);
    }

    public void trackChildrenVisibility() {
        ExpressionResolver expressionResolver;
        DivVisibilityActionTracker visibilityActionTracker = getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "div2Component.visibilityActionTracker");
        for (Map.Entry<View, Div> entry : this.viewToDivBindings.entrySet()) {
            View view = entry.getKey();
            Div div = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            BindingContext bindingContext = BaseDivViewExtensionsKt.getBindingContext(view);
            if (bindingContext != null && (expressionResolver = bindingContext.getExpressionResolver()) != null) {
                if (ViewCompat.isAttachedToWindow(view)) {
                    Intrinsics.checkNotNullExpressionValue(div, "div");
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, this, expressionResolver, view, div, null, 16, null);
                } else {
                    Intrinsics.checkNotNullExpressionValue(div, "div");
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, this, expressionResolver, null, div, null, 16, null);
                }
            }
        }
    }

    private void discardChildrenVisibility() {
        ExpressionResolver expressionResolver;
        DivVisibilityActionTracker visibilityActionTracker = getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "div2Component.visibilityActionTracker");
        for (Map.Entry<View, Div> entry : this.viewToDivBindings.entrySet()) {
            View view = entry.getKey();
            Div div = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            BindingContext bindingContext = BaseDivViewExtensionsKt.getBindingContext(view);
            if (bindingContext != null && (expressionResolver = bindingContext.getExpressionResolver()) != null) {
                Intrinsics.checkNotNullExpressionValue(div, "div");
                DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, this, expressionResolver, null, div, null, 16, null);
            }
        }
    }

    public DivCustomContainerChildFactory getCustomContainerChildFactory$div_release() {
        DivCustomContainerChildFactory divCustomContainerChildFactory = getDiv2Component().getDivCustomContainerChildFactory();
        Intrinsics.checkNotNullExpressionValue(divCustomContainerChildFactory, "div2Component.divCustomContainerChildFactory");
        return divCustomContainerChildFactory;
    }

    private void sendCreationHistograms() {
        if (this.timeCreated < 0) {
            return;
        }
        DivCreationTracker divCreationTracker = getDiv2Component().getDivCreationTracker();
        long j = this.constructorCallTime;
        long j2 = this.timeCreated;
        HistogramReporter histogramReporter = getDiv2Component().getHistogramReporter();
        Intrinsics.checkNotNullExpressionValue(histogramReporter, "div2Component.histogramReporter");
        divCreationTracker.sendHistograms(j, j2, histogramReporter, this.viewCreateCallType);
        this.timeCreated = -1L;
    }

    @Override // com.yandex.div.internal.widget.FrameContainerLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        getHistogramReporter().onLayoutStarted();
        super.onLayout(changed, left, top, right, bottom);
        tryLogVisibility();
        getHistogramReporter().onLayoutFinished();
    }

    @Override // com.yandex.div.internal.widget.FrameContainerLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        getHistogramReporter().onMeasureStarted();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getHistogramReporter().onMeasureFinished();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.drawWasSkipped = false;
        getHistogramReporter().onDrawStarted();
        super.draw(canvas);
        getHistogramReporter().onDrawFinished();
        this.drawWasSkipped = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SingleTimeOnAttachCallback singleTimeOnAttachCallback = this.reportBindingResumedRunnable;
        if (singleTimeOnAttachCallback != null) {
            singleTimeOnAttachCallback.onAttach();
        }
        SingleTimeOnAttachCallback singleTimeOnAttachCallback2 = this.setActiveBindingRunnable;
        if (singleTimeOnAttachCallback2 != null) {
            singleTimeOnAttachCallback2.onAttach();
        }
        SingleTimeOnAttachCallback bindOnAttachRunnable = getBindOnAttachRunnable();
        if (bindOnAttachRunnable != null) {
            bindOnAttachRunnable.onAttach();
        }
        SingleTimeOnAttachCallback singleTimeOnAttachCallback3 = this.reportBindingFinishedRunnable;
        if (singleTimeOnAttachCallback3 != null) {
            singleTimeOnAttachCallback3.onAttach();
        }
        DivTimerEventDispatcher divTimerEventDispatcher = getDivTimerEventDispatcher();
        if (divTimerEventDispatcher != null) {
            divTimerEventDispatcher.onAttach(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        discardVisibilityTracking();
        DivTimerEventDispatcher divTimerEventDispatcher = getDivTimerEventDispatcher();
        if (divTimerEventDispatcher != null) {
            divTimerEventDispatcher.onDetach(this);
        }
        getViewComponent().getAnimatorController().onDetachedFromWindow();
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void addLoadReference(LoadReference loadReference, View targetView) {
        Intrinsics.checkNotNullParameter(loadReference, "loadReference");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        synchronized (this.monitor) {
            this.loadReferences.add(loadReference);
        }
    }

    public static /* synthetic */ boolean prepareForRecycleOrCleanup$default(Div2View div2View, DivData divData, DivData divData2, DivDataTag divDataTag, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareForRecycleOrCleanup");
        }
        if ((i & 2) != 0) {
            divData2 = null;
        }
        if ((i & 4) != 0) {
            divDataTag = null;
        }
        return div2View.prepareForRecycleOrCleanup(divData, divData2, divDataTag);
    }

    public boolean prepareForRecycleOrCleanup(DivData newData, DivData oldData, DivDataTag newDataTag) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        if (newDataTag == null) {
            newDataTag = new DivDataTag(UUID.randomUUID().toString());
        }
        DivComparator divComparator = DivComparator.INSTANCE;
        DivData divData = getDivData();
        if (divData == null) {
            divData = oldData;
        }
        boolean zIsDivDataReplaceable = divComparator.isDivDataReplaceable(divData, newData, getStateId(), getExpressionResolver(), getDiv2Component().getExpressionsRuntimeProvider().getOrCreate$div_release(newDataTag, newData, this).getExpressionResolver(), (32 & 32) != 0 ? null : null);
        if (zIsDivDataReplaceable) {
            ReleaseUtils.INSTANCE.releaseChildren$div_release(this, this);
            stopLoadAndSubscriptions();
        } else {
            cleanup();
        }
        return zIsDivDataReplaceable;
    }

    public void releaseMedia() {
        cancelImageLoads();
        ReleaseUtils.INSTANCE.releaseMedia$div_release(this, this);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void cleanup() {
        synchronized (this.monitor) {
            cleanup(true);
            Unit unit = Unit.INSTANCE;
        }
    }

    private void cleanup(boolean removeChildren) {
        RebindTask rebindTask = this.rebindTask;
        if (rebindTask != null) {
            rebindTask.clear();
            Unit unit = Unit.INSTANCE;
            this.rebindTask = null;
        }
        discardVisibilityTracking();
        cancelImageLoads();
        Div2View div2View = this;
        ReleaseUtils.INSTANCE.releaseMedia$div_release(div2View, this);
        stopLoadAndSubscriptions();
        if (removeChildren) {
            ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(div2View, this);
        }
        ErrorCollector orNull = getViewComponent().getErrorCollectors().getOrNull(getDataTag(), getDivData());
        if (orNull != null) {
            orNull.cleanRuntimeWarningsAndErrors();
        }
        setDivData$div_release(null);
        DivDataTag INVALID = DivDataTag.INVALID;
        Intrinsics.checkNotNullExpressionValue(INVALID, "INVALID");
        setDataTag$div_release(INVALID);
    }

    private void stopLoadAndSubscriptions() {
        this.viewToDivBindings.clear();
        this.propagatedAccessibilityModes.clear();
        cancelTooltips();
        clearSubscriptions();
        this.divDataChangedObservers.clear();
    }

    private void cancelImageLoads() {
        Iterator<T> it = this.loadReferences.iterator();
        while (it.hasNext()) {
            ((LoadReference) it.next()).cancel();
        }
        this.loadReferences.clear();
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void switchToState(long stateId, boolean temporary) {
        synchronized (this.monitor) {
            if (stateId != DivDataUtilsKt.getINVALID_STATE_ID(DivData.INSTANCE)) {
                SingleTimeOnAttachCallback bindOnAttachRunnable = getBindOnAttachRunnable();
                if (bindOnAttachRunnable != null) {
                    bindOnAttachRunnable.cancel();
                }
                forceSwitchToState(stateId, temporary);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void switchToInitialState() {
        DivData divData = getDivData();
        if (divData == null) {
            return;
        }
        long initialStateId = DivDataUtilsKt.getInitialStateId(divData);
        DivViewState currentState = getCurrentState();
        if (currentState != null) {
            initialStateId = currentState.getCurrentDivStateId();
        }
        switchToState(initialStateId);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.yandex.div.core.DivViewFacade
    public void switchToState(DivStatePath path, boolean temporary) {
        List<DivData.State> list;
        Intrinsics.checkNotNullParameter(path, "path");
        synchronized (this.monitor) {
            DivData divData = getDivData();
            DivData.State state = null;
            Object obj = null;
            state = null;
            if (divData != null && (list = divData.states) != null) {
                for (Object obj2 : list) {
                    if (((DivData.State) obj2).stateId == path.getTopLevelStateId()) {
                        obj = obj2;
                        break;
                    }
                }
                state = (DivData.State) obj;
            }
            this.bulkActionsHandler.switchState(state, path, temporary);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void switchToMultipleStates(List<DivStatePath> pathList, boolean temporary, boolean withAnimations) {
        DivData.State state;
        Object next;
        List<DivData.State> list;
        Object obj;
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        if (!pathList.isEmpty()) {
            DivStatePath divStatePath = pathList.get(0);
            List<DivStatePath> list2 = pathList;
            Iterator<T> it = list2.iterator();
            do {
                state = null;
                obj = null;
                state = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((DivStatePath) next).getTopLevelStateId() == divStatePath.getTopLevelStateId());
            if (((DivStatePath) next) != null) {
                Assert.fail("Trying to switch different top level states in path list!");
            }
            if (getStateId() == divStatePath.getTopLevelStateId()) {
                DivData divData = getDivData();
                if (divData != null && (list = divData.states) != null) {
                    for (Object obj2 : list) {
                        if (((DivData.State) obj2).stateId == divStatePath.getTopLevelStateId()) {
                            obj = obj2;
                            break;
                        }
                    }
                    state = (DivData.State) obj;
                }
                this.bulkActionsHandler.switchMultipleStates(state, pathList, temporary);
                return;
            }
            for (DivStatePath divStatePath2 : list2) {
                DivStateManager stateManager = getDiv2Component().getStateManager();
                String id = getDivTag().getId();
                Intrinsics.checkNotNullExpressionValue(id, "divTag.id");
                stateManager.updateStates(id, divStatePath2, temporary);
            }
            switchToState(divStatePath.getTopLevelStateId());
            return;
        }
        Assert.fail("Empty path list!");
    }

    public boolean isInState(DivStatePath statePath) {
        Intrinsics.checkNotNullParameter(statePath, "statePath");
        TemporaryDivStateCache temporaryDivStateCache = getDiv2Component().getTemporaryDivStateCache();
        Intrinsics.checkNotNullExpressionValue(temporaryDivStateCache, "div2Component.temporaryDivStateCache");
        String id = getDataTag().getId();
        Intrinsics.checkNotNullExpressionValue(id, "dataTag.id");
        return Intrinsics.areEqual(temporaryDivStateCache.getState(id, String.valueOf(statePath.getPathToLastState())), statePath.getLastStateId());
    }

    public void addDivDataChangeObserver(DivDataChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.monitor) {
            this.divDataChangedObservers.add(observer);
        }
    }

    public void removeDivDataChangeObserver(DivDataChangedObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.monitor) {
            this.divDataChangedObservers.remove(observer);
        }
    }

    public void addPersistentDivDataObserver$div_release(PersistentDivDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.monitor) {
            this.persistentDivDataObservers.addObserver(observer);
        }
    }

    public void removePersistentDivDataObserver$div_release(PersistentDivDataObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.monitor) {
            this.persistentDivDataObservers.removeObserver(observer);
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void resetToInitialState() {
        DivViewState currentState = getCurrentState();
        if (currentState != null) {
            currentState.reset();
        }
        TemporaryDivStateCache temporaryDivStateCache = getDiv2Component().getTemporaryDivStateCache();
        String id = getDivTag().getId();
        Intrinsics.checkNotNullExpressionValue(id, "divTag.id");
        temporaryDivStateCache.resetCard(id);
        switchToInitialState();
    }

    private boolean switchToDivData(DivData oldData, DivData newData, ForceRebindReporter reporter) {
        View viewBuildViewAndUpdateState$default;
        DivData.State state = oldData != null ? state(oldData) : null;
        DivData.State state2 = state(newData);
        setStateId$div_release(stateId(newData));
        if (state2 == null) {
            reporter.onForceRebindFatalNoState();
            return false;
        }
        if (oldData == null) {
            viewBuildViewAndUpdateState$default = buildViewAsyncAndUpdateState$default(this, state2, getStateId(), false, 4, null);
        } else {
            viewBuildViewAndUpdateState$default = buildViewAndUpdateState$default(this, state2, getStateId(), false, 4, null);
        }
        View view = viewBuildViewAndUpdateState$default;
        if (state != null) {
            discardStateVisibility(state);
        }
        trackStateVisibility(state2);
        addNewStateViewWithTransition(oldData, newData, state != null ? state.div : null, state2, view, (oldData != null && DivTransitionsKt.allowsTransitionsOnDataChange(oldData, getOldExpressionResolver$div_release())) || DivTransitionsKt.allowsTransitionsOnDataChange(newData, getExpressionResolver()), false);
        if (oldData != null) {
            reporter.onForceRebindSuccess();
        } else {
            reporter.onFirstBindingCompleted();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long stateId(DivData divData) {
        DivViewState currentState = getCurrentState();
        return currentState != null ? currentState.getCurrentDivStateId() : DivDataUtilsKt.getInitialStateId(divData);
    }

    private DivData.State state(DivData divData) {
        Object next;
        long jStateId = stateId(divData);
        Iterator<T> it = divData.states.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((DivData.State) next).stateId == jStateId) {
                return (DivData.State) next;
            }
        }
        next = null;
        return (DivData.State) next;
    }

    public Div rootDiv$div_release() {
        DivData.State state;
        DivData divData = getDivData();
        if (divData == null || (state = state(divData)) == null) {
            return null;
        }
        return state.div;
    }

    private boolean forceSwitchToState(long stateId, boolean temporary) {
        Object next;
        Object next2;
        View viewBuildViewAndUpdateState;
        setStateId$div_release(stateId);
        DivViewState currentState = getCurrentState();
        Long lValueOf = currentState != null ? Long.valueOf(currentState.getCurrentDivStateId()) : null;
        DivData divData = getDivData();
        if (divData == null) {
            return false;
        }
        Iterator<T> it = divData.states.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            long j = ((DivData.State) next).stateId;
            if (lValueOf != null && j == lValueOf.longValue()) {
                break;
            }
        }
        DivData.State state = (DivData.State) next;
        Iterator<T> it2 = divData.states.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (((DivData.State) next2).stateId != stateId);
        DivData.State state2 = (DivData.State) next2;
        if (state2 == null) {
            return false;
        }
        if (state != null) {
            discardStateVisibility(state);
        }
        trackStateVisibility(state2);
        boolean zAreDivsReplaceable$default = DivComparator.areDivsReplaceable$default(DivComparator.INSTANCE, state != null ? state.div : null, state2.div, getExpressionResolver(), getExpressionResolver(), null, 16, null);
        if (zAreDivsReplaceable$default) {
            viewBuildViewAndUpdateState = updateState(stateId, temporary);
        } else {
            viewBuildViewAndUpdateState = buildViewAndUpdateState(state2, stateId, temporary);
        }
        addNewStateViewWithTransition(divData, divData, state != null ? state.div : null, state2, viewBuildViewAndUpdateState, DivTransitionsKt.allowsTransitionsOnDataChange(divData, getExpressionResolver()), zAreDivsReplaceable$default);
        return true;
    }

    private void addNewStateViewWithTransition(DivData oldData, DivData newData, Div oldDiv, DivData.State newState, View newStateView, boolean allowsTransition, boolean bindBeforeViewAdded) {
        Transition transitionPrepareTransition = allowsTransition ? prepareTransition(oldData, newData, oldDiv, newState.div) : null;
        if (transitionPrepareTransition != null) {
            Scene currentScene = Scene.getCurrentScene(this);
            if (currentScene != null) {
                currentScene.setExitAction(new Runnable() { // from class: com.yandex.div.core.view2.Div2View$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Div2View.addNewStateViewWithTransition$lambda$41(this.f$0);
                    }
                });
            }
        } else {
            ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(this, this);
        }
        if (bindBeforeViewAdded) {
            getDiv2Component().getDivBinder().bind(getBindingContext(), newStateView, newState.div, DivStatePath.INSTANCE.fromState(newState.stateId));
        }
        if (transitionPrepareTransition != null) {
            Div2View div2View = this;
            TransitionManager.endTransitions(div2View);
            Scene scene = new Scene(div2View, newStateView);
            SceneRootWatcher.INSTANCE.watchFor(scene, transitionPrepareTransition);
            TransitionManager.go(scene, transitionPrepareTransition);
            return;
        }
        addView(newStateView);
        getViewComponent().getErrorMonitor().connect(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addNewStateViewWithTransition$lambda$41(Div2View this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(this$0, this$0);
    }

    private View updateState(long stateId, boolean temporary) {
        View rootView = getView().getChildAt(0);
        getDiv2Component().getStateManager().updateState(getDataTag(), stateId, temporary);
        getDiv2Component().getDivBinder().attachIndicators$div_release();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    static /* synthetic */ View buildViewAndUpdateState$default(Div2View div2View, DivData.State state, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildViewAndUpdateState");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return div2View.buildViewAndUpdateState(state, j, z);
    }

    private View buildViewAndUpdateState(DivData.State newState, long stateId, boolean isUpdateTemporary) {
        getDiv2Component().getStateManager().updateState(getDataTag(), stateId, isUpdateTemporary);
        View viewBuildView = this.divBuilder.buildView(newState.div, getBindingContext(), DivStatePath.INSTANCE.fromState(newState.stateId));
        getDiv2Component().getDivBinder().attachIndicators$div_release();
        return viewBuildView;
    }

    static /* synthetic */ View buildViewAsyncAndUpdateState$default(Div2View div2View, DivData.State state, long j, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildViewAsyncAndUpdateState");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return div2View.buildViewAsyncAndUpdateState(state, j, z);
    }

    private View buildViewAsyncAndUpdateState(final DivData.State newState, long stateId, boolean isUpdateTemporary) {
        getDiv2Component().getStateManager().updateState(getDataTag(), stateId, isUpdateTemporary);
        final DivStatePath divStatePathFromState = DivStatePath.INSTANCE.fromState(newState.stateId);
        final View viewCreateView = this.divBuilder.createView(newState.div, getBindingContext(), divStatePathFromState);
        if (this.bindOnAttachEnabled) {
            setBindOnAttachRunnable$div_release(new SingleTimeOnAttachCallback(this, new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View.buildViewAsyncAndUpdateState.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Div2View div2View = Div2View.this;
                    View view = viewCreateView;
                    DivData.State state = newState;
                    try {
                        div2View.getDiv2Component().getDivBinder().bind(div2View.getBindingContext(), view, state.div, divStatePathFromState);
                    } catch (ParsingException e) {
                        if (!ExpressionFallbacksHelperKt.isExpressionResolveFail(e)) {
                            throw e;
                        }
                    }
                    Div2View.this.getDiv2Component().getDivBinder().attachIndicators$div_release();
                }
            }));
        } else {
            getDiv2Component().getDivBinder().bind(getBindingContext(), viewCreateView, newState.div, divStatePathFromState);
            final Div2View div2View = this;
            if (div2View.isAttachedToWindow()) {
                getDiv2Component().getDivBinder().attachIndicators$div_release();
            } else {
                div2View.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.view2.Div2View$buildViewAsyncAndUpdateState$$inlined$doOnAttach$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        div2View.removeOnAttachStateChangeListener(this);
                        this.getDiv2Component().getDivBinder().attachIndicators$div_release();
                    }
                });
            }
        }
        return viewCreateView;
    }

    private Transition prepareTransition(DivData oldData, final DivData newData, Div oldDiv, Div newDiv) {
        if (oldDiv == newDiv) {
            return null;
        }
        TransitionSet transitionSetBuildTransitions = getViewComponent().getTransitionBuilder().buildTransitions(oldDiv != null ? itemSequenceForTransition(oldData, oldDiv, getOldExpressionResolver$div_release()) : null, newDiv != null ? itemSequenceForTransition(newData, newDiv, getExpressionResolver()) : null, getOldExpressionResolver$div_release(), getExpressionResolver());
        if (transitionSetBuildTransitions.getTransitionCount() == 0) {
            return null;
        }
        final DivDataChangeListener divDataChangeListener = getDiv2Component().getDivDataChangeListener();
        Intrinsics.checkNotNullExpressionValue(divDataChangeListener, "div2Component.divDataChangeListener");
        divDataChangeListener.beforeAnimatedDataChange(this, newData);
        final TransitionSet transitionSet = transitionSetBuildTransitions;
        transitionSet.addListener((Transition.TransitionListener) new TransitionListenerAdapter() { // from class: com.yandex.div.core.view2.Div2View$prepareTransition$$inlined$doOnEnd$1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                divDataChangeListener.afterAnimatedDataChange(this, newData);
                transitionSet.removeListener(this);
            }
        });
        return transitionSet;
    }

    private Sequence<DivItemBuilderResult> itemSequenceForTransition(DivData divData, Div div, final ExpressionResolver resolver) {
        DivTransitionSelector divTransitionSelectorEvaluate;
        Expression<DivTransitionSelector> expression;
        final ArrayDeque arrayDeque = new ArrayDeque();
        if (divData == null || (expression = divData.transitionAnimationSelector) == null || (divTransitionSelectorEvaluate = expression.evaluate(resolver)) == null) {
            divTransitionSelectorEvaluate = DivTransitionSelector.NONE;
        }
        arrayDeque.addLast(divTransitionSelectorEvaluate);
        return SequencesKt.filter(DivTreeWalkKt.walk(div, resolver).onEnter(new Function1<Div, Boolean>() { // from class: com.yandex.div.core.view2.Div2View.itemSequenceForTransition.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Div div2) {
                Intrinsics.checkNotNullParameter(div2, "div");
                if (div2 instanceof Div.State) {
                    arrayDeque.addLast(((Div.State) div2).getValue().transitionAnimationSelector.evaluate(resolver));
                }
                return true;
            }
        }).onLeave(new Function1<Div, Unit>() { // from class: com.yandex.div.core.view2.Div2View.itemSequenceForTransition.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Div div2) {
                invoke2(div2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Div div2) {
                Intrinsics.checkNotNullParameter(div2, "div");
                if (div2 instanceof Div.State) {
                    arrayDeque.removeLast();
                }
            }
        }), new Function1<DivItemBuilderResult, Boolean>() { // from class: com.yandex.div.core.view2.Div2View.itemSequenceForTransition.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DivItemBuilderResult item) {
                boolean zAllowsTransitionsOnDataChange;
                Intrinsics.checkNotNullParameter(item, "item");
                List<DivTransitionTrigger> transitionTriggers = item.getDiv().value().getTransitionTriggers();
                if (transitionTriggers != null) {
                    zAllowsTransitionsOnDataChange = DivTransitionsKt.allowsTransitionsOnDataChange(transitionTriggers);
                } else {
                    DivTransitionSelector divTransitionSelectorLastOrNull = arrayDeque.lastOrNull();
                    zAllowsTransitionsOnDataChange = divTransitionSelectorLastOrNull != null ? DivTransitionsKt.allowsTransitionsOnDataChange(divTransitionSelectorLastOrNull) : false;
                }
                return Boolean.valueOf(zAllowsTransitionsOnDataChange);
            }
        });
    }

    public void startDivAnimation() {
        if (getChildCount() > 0) {
            KeyEvent.Callback childAt = getChildAt(0);
            DivAnimator divAnimator = childAt instanceof DivAnimator ? (DivAnimator) childAt : null;
            if (divAnimator != null) {
                divAnimator.startDivAnimation();
            }
        }
    }

    public void stopDivAnimation() {
        if (getChildCount() > 0) {
            KeyEvent.Callback childAt = getChildAt(0);
            DivAnimator divAnimator = childAt instanceof DivAnimator ? (DivAnimator) childAt : null;
            if (divAnimator != null) {
                divAnimator.stopDivAnimation();
            }
        }
    }

    public static /* synthetic */ void handleAction$default(Div2View div2View, DivAction divAction, String str, ExpressionResolver expressionResolver, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleAction");
        }
        if ((i & 2) != 0) {
            str = "external";
        }
        if ((i & 4) != 0) {
            expressionResolver = div2View.getExpressionResolver();
        }
        div2View.handleAction(divAction, str, expressionResolver);
    }

    public void handleAction(DivAction action, String reason, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        handleActionWithResult(action, reason, resolver);
    }

    public static /* synthetic */ boolean handleActionWithResult$default(Div2View div2View, DivAction divAction, String str, ExpressionResolver expressionResolver, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleActionWithResult");
        }
        if ((i & 2) != 0) {
            str = "external";
        }
        if ((i & 4) != 0) {
            expressionResolver = div2View.getExpressionResolver();
        }
        return div2View.handleActionWithResult(divAction, str, expressionResolver);
    }

    public boolean handleActionWithResult(DivAction action, String reason, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return getDiv2Component().getActionBinder().handleAction$div_release(this, resolver, action, reason, null, getActionHandler());
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void handleUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        DivActionHandler actionHandler = getActionHandler();
        if (actionHandler == null || !actionHandler.handleActionUrl(uri, this)) {
            getDiv2Component().getActionHandler().handleActionUrl(uri, this);
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void setConfig(DivViewConfig viewConfig) {
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        this.config = viewConfig;
    }

    @Override // com.yandex.div.core.DivViewFacade
    public DivViewConfig getConfig() {
        DivViewConfig config = this.config;
        Intrinsics.checkNotNullExpressionValue(config, "config");
        return config;
    }

    @Override // com.yandex.div.core.DivViewFacade
    public DivDataTag getDivTag() {
        return getDataTag();
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void subscribe(OverflowMenuSubscriber.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.monitor) {
            this.overflowMenuListeners.add(listener);
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void clearSubscriptions() {
        synchronized (this.monitor) {
            this.overflowMenuListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void onConfigurationChangedOutside(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        dismissPendingOverflowMenus();
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void dismissPendingOverflowMenus() {
        synchronized (this.monitor) {
            Iterator<T> it = this.overflowMenuListeners.iterator();
            while (it.hasNext()) {
                ((OverflowMenuSubscriber.Listener) it.next()).dismiss();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.div.core.DivViewFacade
    public boolean hasScrollableViewUnder(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return ViewGroupsKt.hasScrollableChildUnder(this, event);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public long getCurrentStateId() {
        return getStateId();
    }

    @Override // com.yandex.div.core.DivViewFacade
    public DivViewState getCurrentState() {
        DivData divData = getDivData();
        if (divData == null) {
            return null;
        }
        DivViewState state = getDiv2Component().getStateManager().getState(getDataTag());
        List<DivData.State> list = divData.states;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        for (DivData.State state2 : list) {
            if (state != null && state2.stateId == state.getCurrentDivStateId()) {
                return state;
            }
        }
        return null;
    }

    @Override // com.yandex.div.core.DivViewFacade
    public ExpressionResolver getExpressionResolver() {
        ExpressionResolver expressionResolver;
        ExpressionsRuntime expressionsRuntime = getExpressionsRuntime();
        return (expressionsRuntime == null || (expressionResolver = expressionsRuntime.getExpressionResolver()) == null) ? ExpressionResolver.EMPTY : expressionResolver;
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void showTooltip(String tooltipId) {
        Intrinsics.checkNotNullParameter(tooltipId, "tooltipId");
        DivTooltipController.showTooltip$default(getTooltipController(), tooltipId, getBindingContext(), false, 4, null);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void showTooltip(String tooltipId, boolean multiple) {
        Intrinsics.checkNotNullParameter(tooltipId, "tooltipId");
        getTooltipController().showTooltip(tooltipId, getBindingContext(), multiple);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void hideTooltip(String tooltipId) {
        Intrinsics.checkNotNullParameter(tooltipId, "tooltipId");
        getTooltipController().hideTooltip(tooltipId, this);
    }

    @Override // com.yandex.div.core.DivViewFacade
    public void cancelTooltips() {
        getTooltipController().cancelTooltips(getBindingContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.drawWasSkipped) {
            getHistogramReporter().onDrawStarted();
        }
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        super.dispatchDraw(canvas);
        if (this.drawWasSkipped) {
            getHistogramReporter().onDrawFinished();
        }
    }

    public void bindViewToDiv$div_release(View view, Div div) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        this.viewToDivBindings.put(view, div);
    }

    public Div takeBindingDiv$div_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.viewToDivBindings.get(view);
    }

    public void setPropagatedAccessibilityMode$div_release(View view, DivAccessibility.Mode mode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.propagatedAccessibilityModes.put(view, mode);
    }

    public DivAccessibility.Mode getPropagatedAccessibilityMode$div_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.propagatedAccessibilityModes.get(view);
    }

    public boolean isDescendantAccessibilityMode$div_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        return view2 != null && this.propagatedAccessibilityModes.get(view2) == this.propagatedAccessibilityModes.get(view);
    }

    public VariableMutationException setVariable(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return VariableMutationHandler.INSTANCE.setVariable(this, name, value, getExpressionResolver());
    }

    public void applyTimerCommand(String id, String command) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(command, "command");
        DivTimerEventDispatcher divTimerEventDispatcher = getDivTimerEventDispatcher();
        if (divTimerEventDispatcher != null) {
            divTimerEventDispatcher.changeState(id, command);
        }
    }

    public static /* synthetic */ boolean applyVideoCommand$default(Div2View div2View, String str, String str2, ExpressionResolver expressionResolver, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyVideoCommand");
        }
        if ((i & 4) != 0) {
            expressionResolver = div2View.getExpressionResolver();
        }
        return div2View.applyVideoCommand(str, str2, expressionResolver);
    }

    public boolean applyVideoCommand(String divId, String command, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divId, "divId");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        return getDivVideoActionHandler().handleAction(this, divId, command, expressionResolver);
    }

    public Div unbindViewFromDiv$div_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.viewToDivBindings.remove(view);
    }

    private void rebind(DivData newData, boolean isAutoanimations, SimpleRebindReporter reporter) {
        try {
            if (getChildCount() == 0) {
                reporter.onSimpleRebindNoChild();
                updateNow(newData, getDataTag(), reporter);
                return;
            }
            DivData.State stateToBind = getStateToBind(newData);
            if (stateToBind == null) {
                Div2View div2View = this;
                reporter.onSimpleRebindFatalNoState();
                return;
            }
            getHistogramReporter().onRebindingStarted();
            ErrorCollector orNull = getViewComponent().getErrorCollectors().getOrNull(getDataTag(), getDivData());
            if (orNull != null) {
                orNull.cleanRuntimeWarningsAndErrors();
            }
            View rootDivView = getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(rootDivView, "rebind$lambda$55");
            BaseDivViewExtensionsKt.bindLayoutParams(rootDivView, stateToBind.div.value(), getExpressionResolver());
            setDivData$div_release(newData);
            getDiv2Component().getStateManager().updateState(getDataTag(), stateToBind.stateId, true);
            DivBinder divBinder = getDiv2Component().getDivBinder();
            BindingContext bindingContext = getBindingContext();
            Intrinsics.checkNotNullExpressionValue(rootDivView, "rootDivView");
            divBinder.bind(bindingContext, rootDivView, stateToBind.div, DivStatePath.INSTANCE.fromState(getStateId()));
            requestLayout();
            if (isAutoanimations) {
                getDiv2Component().getDivStateChangeListener().onDivAnimatedStateChanged(this);
            }
            attachVariableTriggers(newData);
            getHistogramReporter().onRebindingFinished();
            reporter.onSimpleRebindSuccess();
        } catch (Exception e) {
            reporter.onSimpleRebindException(e);
            updateNow(newData, getDataTag(), reporter);
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("", e);
            }
        }
    }

    private boolean complexRebind(DivData newData, DivData oldData, ComplexRebindReporter reporter) {
        DivData.State stateToBind = getStateToBind(newData);
        if (stateToBind == null) {
            reporter.onComplexRebindFatalNoState();
            return false;
        }
        getHistogramReporter().onRebindingStarted();
        setDivData$div_release(newData);
        RebindTask rebindTask = this.rebindTask;
        if (rebindTask == null) {
            DivBinder divBinder = getDiv2Component().getDivBinder();
            Intrinsics.checkNotNullExpressionValue(divBinder, "div2Component.divBinder");
            rebindTask = new RebindTask(this, divBinder, getOldExpressionResolver$div_release(), getExpressionResolver(), reporter);
            this.rebindTask = rebindTask;
        }
        View childAt = getView().getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) childAt;
        BaseDivViewExtensionsKt.bindLayoutParams(viewGroup, stateToBind.div.value(), getExpressionResolver());
        getDiv2Component().getStateManager().updateState(getDataTag(), stateToBind.stateId, false);
        if (!rebindTask.prepareAndRebind(oldData, newData, viewGroup, DivStatePath.INSTANCE.fromState(stateId(newData)))) {
            return false;
        }
        requestLayout();
        getHistogramReporter().onRebindingFinished();
        return true;
    }

    private DivData.State getStateToBind(DivData divData) {
        Object next;
        Iterator<T> it = divData.states.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((DivData.State) next).stateId != getStateId());
        DivData.State state = (DivData.State) next;
        return state == null ? (DivData.State) CollectionsKt.firstOrNull((List) divData.states) : state;
    }

    public DivData.State stateToBind(DivData divData) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        return getStateToBind(divData);
    }

    public void setVisualErrorsEnabled(boolean z) {
        getViewComponent().getErrorMonitor().setEnabled$div_release(z);
    }

    public boolean getVisualErrorsEnabled() {
        return getViewComponent().getErrorMonitor().getEnabled();
    }

    public void bulkActions$div_release(Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.bulkActionsHandler.bulkActions(function);
    }

    /* JADX INFO: compiled from: Div2View.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\rJ&\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u0016\u001a\u00020\u0006J \u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/view2/Div2View$BulkActionHandler;", "", "(Lcom/yandex/div/core/view2/Div2View;)V", "bulkModeDepth", "", "isPendingStateTemporary", "", "pendingPaths", "", "Lcom/yandex/div/core/state/DivStatePath;", "pendingState", "Lcom/yandex/div2/DivData$State;", "bulkActions", "", "function", "Lkotlin/Function0;", TimerController.RESET_COMMAND, "runBulkActions", "switchMultipleStates", "state", "paths", "", "temporary", "switchState", "path", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class BulkActionHandler {
        private int bulkModeDepth;
        private boolean isPendingStateTemporary = true;
        private final List<DivStatePath> pendingPaths = new ArrayList();
        private DivData.State pendingState;

        public BulkActionHandler() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bulkActions$default(BulkActionHandler bulkActionHandler, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = new Function0<Unit>() { // from class: com.yandex.div.core.view2.Div2View$BulkActionHandler$bulkActions$1
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                };
            }
            bulkActionHandler.bulkActions(function0);
        }

        public final void bulkActions(Function0<Unit> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.bulkModeDepth++;
            function.invoke();
            int i = this.bulkModeDepth - 1;
            this.bulkModeDepth = i;
            if (i == 0) {
                runBulkActions();
            }
        }

        public final void switchState(DivData.State state, DivStatePath path, boolean temporary) {
            Intrinsics.checkNotNullParameter(path, "path");
            switchMultipleStates(state, CollectionsKt.listOf(path), temporary);
        }

        public final void switchMultipleStates(DivData.State state, List<DivStatePath> paths, boolean temporary) {
            Intrinsics.checkNotNullParameter(paths, "paths");
            DivData.State state2 = this.pendingState;
            if (state2 != null && !Intrinsics.areEqual(state, state2)) {
                reset();
            }
            this.pendingState = state;
            this.isPendingStateTemporary = this.isPendingStateTemporary && temporary;
            List<DivStatePath> list = paths;
            CollectionsKt.addAll(this.pendingPaths, list);
            Div2View div2View = Div2View.this;
            for (DivStatePath divStatePath : list) {
                DivStateManager stateManager = div2View.getDiv2Component().getStateManager();
                String id = div2View.getDivTag().getId();
                Intrinsics.checkNotNullExpressionValue(id, "divTag.id");
                stateManager.updateStates(id, divStatePath, temporary);
            }
            if (this.bulkModeDepth == 0) {
                runBulkActions();
            }
        }

        public final void runBulkActions() {
            DivData.State state = this.pendingState;
            if (state == null) {
                return;
            }
            if (state.stateId != Div2View.this.getStateId()) {
                Div2View.this.switchToState(state.stateId, this.isPendingStateTemporary);
            } else if (Div2View.this.getChildCount() > 0) {
                try {
                    Div2View.this.getViewComponent().getStateSwitcher().switchStates(state, com.yandex.div.internal.util.CollectionsKt.immutableCopy(this.pendingPaths), Div2View.this.getExpressionResolver());
                } catch (StateConflictException e) {
                    DivActionTypedUtilsKt.logError(Div2View.this, e);
                    Div2View.this.resetToInitialState();
                }
            }
            reset();
        }

        private final void reset() {
            this.pendingState = null;
            this.isPendingStateTemporary = true;
            this.pendingPaths.clear();
        }
    }
}
