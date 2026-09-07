package io.bidmachine.ads.networks.adaptiverendering;

import io.bidmachine.ads.networks.adaptiverendering.measurer.AdMeasurerFactory;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.rendering.Rendering;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.EventParams;
import io.bidmachine.rendering.model.EventTaskParams;
import io.bidmachine.rendering.model.EventTaskType;
import io.bidmachine.rendering.model.EventType;
import io.bidmachine.rendering.model.FontStyleType;
import io.bidmachine.rendering.model.MeasurerParams;
import io.bidmachine.rendering.model.MethodParams;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.model.SideBindParams;
import io.bidmachine.rendering.model.SideType;
import io.bidmachine.rendering.model.VisibilityParams;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
class AdaptiveRenderingParams extends UnifiedParams {
    final AdParams adParams;

    AdaptiveRenderingParams(UnifiedMediationParams unifiedMediationParams) {
        super(unifiedMediationParams);
        Float floatOrNull = unifiedMediationParams.getFloatOrNull(UnifiedMediationParams.KEY_VIEWABILITY_PIXEL_THRESHOLD);
        Boolean booleanOrNull = unifiedMediationParams.getBooleanOrNull(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_WINDOW_FOCUS);
        Boolean booleanOrNull2 = unifiedMediationParams.getBooleanOrNull(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_OVERLAP);
        Object objectOrNull = unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_RENDERING_CONFIGURATION);
        if (objectOrNull instanceof Rendering) {
            VisibilityParams.Builder builder = new VisibilityParams.Builder();
            if (floatOrNull != null) {
                builder.setVisibilityPercent(floatOrNull.floatValue());
            }
            if (booleanOrNull != null) {
                builder.setIgnoreWindowFocus(booleanOrNull.booleanValue());
            }
            if (booleanOrNull2 != null) {
                builder.setIgnoreOverlap(booleanOrNull2.booleanValue());
            }
            this.adParams = createAdParams((Rendering) objectOrNull, builder.build());
            return;
        }
        this.adParams = null;
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback unifiedAdCallback) {
        if (this.adParams != null) {
            return true;
        }
        unifiedAdCallback.onAdLoadFailed(BMError.notFound(UnifiedMediationParams.KEY_RENDERING_CONFIGURATION));
        return false;
    }

    static AdParams createAdParams(Rendering rendering, VisibilityParams visibilityParams) {
        AdMeasurerFactory adMeasurerFactory = new AdMeasurerFactory();
        AdParams.Builder customParams = new AdParams.Builder().setOrientation(map(rendering.getOrientation())).setVisibilityParams(visibilityParams).setCustomParams(rendering.getCustomParamsMap());
        CacheType map = map(rendering.getCacheType());
        if (map != null) {
            customParams.setCacheType(map);
        }
        LinkedList<Rendering.Phase> linkedList = new LinkedList(rendering.getPhasesList());
        sortAscBySequence(linkedList);
        for (Rendering.Phase phase : linkedList) {
            AdPhaseParams adPhaseParamsCreateAdPhaseParams = createAdPhaseParams(phase, adMeasurerFactory);
            if (adPhaseParamsCreateAdPhaseParams != null) {
                if (phase.getSequence() == -1) {
                    customParams.setPlaceholderParams(adPhaseParamsCreateAdPhaseParams);
                } else {
                    customParams.addAdPhaseParams(adPhaseParamsCreateAdPhaseParams);
                }
            }
        }
        return customParams.build();
    }

    static AdPhaseParams createAdPhaseParams(Rendering.Phase phase, MeasurerFactory measurerFactory) {
        if (phase == null || phase == Rendering.Phase.getDefaultInstance()) {
            return null;
        }
        AdPhaseParams.Builder customParams = new AdPhaseParams.Builder().setCustomParams(phase.getCustomParamsMap());
        Integer numSafeParseColor = Utils.safeParseColor(phase.getBackgroundColor());
        if (numSafeParseColor != null) {
            customParams.setBackgroundColor(numSafeParseColor.intValue());
        }
        Iterator<Rendering.Phase.ViewComponent> it = phase.getAdsList().iterator();
        while (it.hasNext()) {
            AdElementParams adElementParamsCreateAdElementParams = createAdElementParams(it.next(), measurerFactory);
            if (adElementParamsCreateAdElementParams != null) {
                customParams.addAdsElementParams(adElementParamsCreateAdElementParams);
            }
        }
        Iterator<Rendering.Phase.ViewComponent> it2 = phase.getControlsList().iterator();
        while (it2.hasNext()) {
            AdElementParams adElementParamsCreateAdElementParams2 = createAdElementParams(it2.next(), measurerFactory);
            if (adElementParamsCreateAdElementParams2 != null) {
                customParams.addControlsElementParams(adElementParamsCreateAdElementParams2);
            }
        }
        Iterator<Rendering.Phase.Event> it3 = phase.getEventsList().iterator();
        while (it3.hasNext()) {
            EventParams eventParamsCreateEventParams = createEventParams(it3.next());
            if (eventParamsCreateEventParams != null) {
                customParams.addEventParams(eventParamsCreateEventParams);
            }
        }
        Iterator<Rendering.Phase.MethodComponent> it4 = phase.getMethodsList().iterator();
        while (it4.hasNext()) {
            customParams.addMethodParams(new MethodParams(it4.next().getName()));
        }
        return customParams.build();
    }

    static AdElementParams createAdElementParams(Rendering.Phase.ViewComponent viewComponent, MeasurerFactory measurerFactory) {
        AdElementType map;
        if (viewComponent == null || viewComponent == Rendering.Phase.ViewComponent.getDefaultInstance() || (map = map(viewComponent.getType())) == null) {
            return null;
        }
        return new AdElementParams(map, viewComponent.getName(), viewComponent.getSource(), viewComponent.getPlaceholder(), createElementLayoutParams(viewComponent.getLayout()), createAppearanceParams(viewComponent.getAppearance()), viewComponent.getCustomParamsMap(), measurerFactory, createMeasurerParamsList(viewComponent.getMeasurersList()));
    }

    static ElementLayoutParams createElementLayoutParams(Rendering.Phase.ViewComponent.Layout layout) {
        ElementLayoutParams.Builder builder = new ElementLayoutParams.Builder();
        if (layout == null) {
            return builder.build();
        }
        for (Rendering.Phase.ViewComponent.Layout.Constraint constraint : layout.getConstraintsList()) {
            final Rendering.Phase.ViewComponent.Layout.Constraint.Anchor sourceAnchor = constraint.getSourceAnchor();
            Rendering.Phase.ViewComponent.Layout.Constraint.Anchor targetAnchor = constraint.getTargetAnchor();
            String target = constraint.getTarget();
            float value = (float) constraint.getValue();
            float multiplier = (float) constraint.getMultiplier();
            switch (AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[sourceAnchor.ordinal()]) {
                case 1:
                    builder.setWidth(value);
                    builder.setWidthPercent(multiplier);
                    break;
                case 2:
                    builder.setHeight(value);
                    builder.setHeightPercent(multiplier);
                    break;
                case 3:
                    SideType map = map(targetAnchor);
                    if (map != null) {
                        builder.setLeftSideBindParams(new SideBindParams(map, target));
                    }
                    builder.setMarginLeft(value);
                    break;
                case 4:
                    SideType map2 = map(targetAnchor);
                    if (map2 != null) {
                        builder.setTopSideBindParams(new SideBindParams(map2, target));
                    }
                    builder.setMarginTop(value);
                    break;
                case 5:
                    SideType map3 = map(targetAnchor);
                    if (map3 != null) {
                        builder.setRightSideBindParams(new SideBindParams(map3, target));
                    }
                    builder.setMarginRight(value);
                    break;
                case 6:
                    SideType map4 = map(targetAnchor);
                    if (map4 != null) {
                        builder.setBottomSideBindParams(new SideBindParams(map4, target));
                    }
                    builder.setMarginBottom(value);
                    break;
                case 7:
                    builder.setTranslationX(value);
                    break;
                case 8:
                    builder.setTranslationY(value);
                    break;
                default:
                    Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda1
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return String.format("Unsupported SourceAnchor - %s", sourceAnchor);
                        }
                    });
                    break;
            }
        }
        return builder.build();
    }

    static AppearanceParams createAppearanceParams(Rendering.Phase.ViewComponent.Appearance appearance) {
        AppearanceParams.Builder builder = new AppearanceParams.Builder();
        if (appearance == null || appearance == Rendering.Phase.ViewComponent.Appearance.getDefaultInstance()) {
            return builder.build();
        }
        builder.setBackgroundColor(Utils.safeParseColor(appearance.getBackgroundColor()));
        builder.setVisible(Boolean.valueOf(appearance.getVisible()));
        builder.setClickable(Boolean.valueOf(appearance.getClickable()));
        builder.setOpacity(Float.valueOf((float) appearance.getOpacity()));
        builder.setFontStyleType(FontStyleType.fromKey(appearance.getFontStyle()));
        builder.setStrokeWidth(Float.valueOf((float) appearance.getStrokeWidth()));
        builder.setStrokeColor(Utils.safeParseColor(appearance.getStrokeColor()));
        return builder.build();
    }

    static List<MeasurerParams> createMeasurerParamsList(List<Rendering.Phase.ViewComponent.Measurer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Rendering.Phase.ViewComponent.Measurer measurer : list) {
            arrayList.add(new MeasurerParams(measurer.getName(), measurer.getParametersMap()));
        }
        return arrayList;
    }

    static EventParams createEventParams(Rendering.Phase.Event event) {
        EventParams eventParams = null;
        if (event != null && event != Rendering.Phase.Event.getDefaultInstance()) {
            EventType map = map(event.getName());
            if (map == null) {
                return null;
            }
            eventParams = new EventParams(map, event.getSource());
            Iterator<Rendering.Phase.Event.Task> it = event.getTasksList().iterator();
            while (it.hasNext()) {
                EventTaskParams eventTaskParamsCreateEventTaskParams = createEventTaskParams(it.next());
                if (eventTaskParamsCreateEventTaskParams != null) {
                    eventParams.addTaskParams(eventTaskParamsCreateEventTaskParams);
                }
            }
        }
        return eventParams;
    }

    static EventTaskParams createEventTaskParams(Rendering.Phase.Event.Task task) {
        EventTaskType map;
        if (task == null || (map = map(task.getName())) == null) {
            return null;
        }
        return new EventTaskParams(map, task.getTarget(), task.getValue());
    }

    static void sortAscBySequence(List<Rendering.Phase> list) {
        Collections.sort(list, new Comparator() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((Rendering.Phase) obj).getSequence(), ((Rendering.Phase) obj2).getSequence());
            }
        });
    }

    static Orientation map(final Rendering.Orientation orientation) {
        if (orientation == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation[orientation.ordinal()];
        if (i == 1) {
            return Orientation.Portrait;
        }
        if (i == 2) {
            return Orientation.Landscape;
        }
        if (i != 3) {
            if (i == 4 || i == 5) {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda6
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Unsupported Orientation - %s", orientation);
                    }
                });
            } else {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda7
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Unsupported Orientation - %s", orientation);
                    }
                });
                return null;
            }
        }
        return null;
    }

    static CacheType map(final Rendering.CacheType cacheType) {
        if (cacheType == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType[cacheType.ordinal()];
        if (i == 1) {
            return CacheType.FullLoad;
        }
        if (i == 2) {
            return CacheType.PartialLoad;
        }
        if (i == 3) {
            return CacheType.StreamLoad;
        }
        if (i == 4 || i == 5) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("Unsupported CacheType - %s", cacheType);
                }
            });
            return null;
        }
        Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Unsupported CacheType - %s", cacheType);
            }
        });
        return null;
    }

    static AdElementType map(final Rendering.Phase.ViewComponent.ViewComponentType viewComponentType) {
        if (viewComponentType == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType[viewComponentType.ordinal()];
        if (i == 1) {
            return AdElementType.Video;
        }
        if (i == 2) {
            return AdElementType.Mraid;
        }
        if (i == 3) {
            return AdElementType.Image;
        }
        if (i == 4) {
            return AdElementType.Countdown;
        }
        if (i == 5) {
            return AdElementType.Progress;
        }
        Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Unsupported ViewComponentType - %s", viewComponentType);
            }
        });
        return null;
    }

    static SideType map(final Rendering.Phase.ViewComponent.Layout.Constraint.Anchor anchor) {
        if (anchor == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[anchor.ordinal()];
        if (i == 3) {
            return SideType.Left;
        }
        if (i == 4) {
            return SideType.Top;
        }
        if (i == 5) {
            return SideType.Right;
        }
        if (i == 6) {
            return SideType.Bottom;
        }
        Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda9
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("Unsupported Anchor for SideType - %s", anchor);
            }
        });
        return null;
    }

    static EventType map(final Rendering.Phase.Event.EventName eventName) {
        if (eventName == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[eventName.ordinal()]) {
            case 1:
                return EventType.OnImpression;
            case 2:
                return EventType.OnClick;
            case 3:
                return EventType.OnProgress;
            case 4:
                return EventType.OnNavigate;
            case 5:
                return EventType.OnMute;
            case 6:
                return EventType.OnUnMute;
            case 7:
                return EventType.OnPause;
            case 8:
                return EventType.OnResume;
            case 9:
                return EventType.OnSkip;
            case 10:
                return EventType.OnClose;
            case 11:
                return EventType.OnStart;
            case 12:
                return EventType.OnFirstQuartile;
            case 13:
                return EventType.OnMidpoint;
            case 14:
                return EventType.OnThirdQuartile;
            case 15:
                return EventType.OnComplete;
            case 16:
                return EventType.OnUseCustomClose;
            case 17:
                return EventType.OnScheduled;
            default:
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Unsupported EventName - %s", eventName);
                    }
                });
                return null;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType;

        static {
            int[] iArr = new int[Rendering.Phase.Event.Task.TaskName.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName = iArr;
            try {
                iArr[Rendering.Phase.Event.Task.TaskName.TASK_NAME_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_MUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_UNMUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_TRACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_CLOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_SKIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_SHOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_HIDE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_PROGRESS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_SCHEDULE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_LOCK_VISIBILITY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_UNLOCK_VISIBILITY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_NOTIFY_OPEN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_SIMULATE_CLICK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[Rendering.Phase.Event.Task.TaskName.TASK_NAME_PRIVACY_SHEET.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[Rendering.Phase.Event.EventName.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName = iArr2;
            try {
                iArr2[Rendering.Phase.Event.EventName.EVENT_NAME_ON_IMPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_NAVIGATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_MUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_UNMUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_PAUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_RESUME.ordinal()] = 8;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_SKIP.ordinal()] = 9;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_CLOSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_START.ordinal()] = 11;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_FIRST_QUARTILE.ordinal()] = 12;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_MIDPOINT.ordinal()] = 13;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_THIRD_QUARTILE.ordinal()] = 14;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_COMPLETE.ordinal()] = 15;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_USE_CUSTOM_CLOSE.ordinal()] = 16;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$EventName[Rendering.Phase.Event.EventName.EVENT_NAME_ON_SCHEDULED.ordinal()] = 17;
            } catch (NoSuchFieldError unused33) {
            }
            int[] iArr3 = new int[Rendering.Phase.ViewComponent.ViewComponentType.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType = iArr3;
            try {
                iArr3[Rendering.Phase.ViewComponent.ViewComponentType.VIEW_COMPONENT_TYPE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType[Rendering.Phase.ViewComponent.ViewComponentType.VIEW_COMPONENT_TYPE_MRAID.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType[Rendering.Phase.ViewComponent.ViewComponentType.VIEW_COMPONENT_TYPE_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType[Rendering.Phase.ViewComponent.ViewComponentType.VIEW_COMPONENT_TYPE_COUNTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$ViewComponentType[Rendering.Phase.ViewComponent.ViewComponentType.VIEW_COMPONENT_TYPE_PROGRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr4 = new int[Rendering.CacheType.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType = iArr4;
            try {
                iArr4[Rendering.CacheType.CACHE_TYPE_FULL_LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType[Rendering.CacheType.CACHE_TYPE_PARTIAL_LOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType[Rendering.CacheType.CACHE_TYPE_STREAM_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType[Rendering.CacheType.CACHE_TYPE_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$CacheType[Rendering.CacheType.UNRECOGNIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr5 = new int[Rendering.Orientation.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation = iArr5;
            try {
                iArr5[Rendering.Orientation.ORIENTATION_PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation[Rendering.Orientation.ORIENTATION_LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation[Rendering.Orientation.ORIENTATION_SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation[Rendering.Orientation.ORIENTATION_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Orientation[Rendering.Orientation.UNRECOGNIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused48) {
            }
            int[] iArr6 = new int[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor = iArr6;
            try {
                iArr6[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$ViewComponent$Layout$Constraint$Anchor[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused56) {
            }
        }
    }

    static EventTaskType map(final Rendering.Phase.Event.Task.TaskName taskName) {
        if (taskName == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$rendering$Rendering$Phase$Event$Task$TaskName[taskName.ordinal()]) {
            case 1:
                return EventTaskType.Start;
            case 2:
                return EventTaskType.Mute;
            case 3:
                return EventTaskType.UnMute;
            case 4:
                return EventTaskType.Track;
            case 5:
                return EventTaskType.Close;
            case 6:
                return EventTaskType.Skip;
            case 7:
                return EventTaskType.Open;
            case 8:
                return EventTaskType.Show;
            case 9:
                return EventTaskType.Hide;
            case 10:
                return EventTaskType.Progress;
            case 11:
                return EventTaskType.Schedule;
            case 12:
                return EventTaskType.LockVisibility;
            case 13:
                return EventTaskType.UnlockVisibility;
            case 14:
                return EventTaskType.NotifyOpen;
            case 15:
                return EventTaskType.SimulateClick;
            case 16:
                return EventTaskType.OpenPrivacySheet;
            default:
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda8
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return String.format("Unsupported TaskName - %s", taskName);
                    }
                });
                return null;
        }
    }
}
