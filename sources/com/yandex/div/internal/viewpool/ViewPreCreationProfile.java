package com.yandex.div.internal.viewpool;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ViewPreCreationProfile.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSB×\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bBÅ\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003JÉ\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0007HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001J!\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QHÇ\u0001R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006T"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "", "seen1", "", "id", "", "text", "Lcom/yandex/div/internal/viewpool/PreCreationModel;", "image", "gifImage", "overlapContainer", "linearContainer", "wrapContainer", "grid", "gallery", "pager", "tab", "state", "custom", "indicator", "slider", "input", "select", "video", "switch", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;Lcom/yandex/div/internal/viewpool/PreCreationModel;)V", "getCustom", "()Lcom/yandex/div/internal/viewpool/PreCreationModel;", "getGallery", "getGifImage", "getGrid", "getId", "()Ljava/lang/String;", "getImage", "getIndicator", "getInput", "getLinearContainer", "getOverlapContainer", "getPager", "getSelect", "getSlider", "getState", "getSwitch", "getTab", "getText", "getVideo", "getWrapContainer", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class ViewPreCreationProfile {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PreCreationModel custom;
    private final PreCreationModel gallery;
    private final PreCreationModel gifImage;
    private final PreCreationModel grid;
    private final String id;
    private final PreCreationModel image;
    private final PreCreationModel indicator;
    private final PreCreationModel input;
    private final PreCreationModel linearContainer;
    private final PreCreationModel overlapContainer;
    private final PreCreationModel pager;
    private final PreCreationModel select;
    private final PreCreationModel slider;
    private final PreCreationModel state;
    private final PreCreationModel switch;
    private final PreCreationModel tab;
    private final PreCreationModel text;
    private final PreCreationModel video;
    private final PreCreationModel wrapContainer;

    public ViewPreCreationProfile() {
        this((String) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, (PreCreationModel) null, 524287, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PreCreationModel getPager() {
        return this.pager;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final PreCreationModel getTab() {
        return this.tab;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final PreCreationModel getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final PreCreationModel getCustom() {
        return this.custom;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final PreCreationModel getIndicator() {
        return this.indicator;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PreCreationModel getSlider() {
        return this.slider;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final PreCreationModel getInput() {
        return this.input;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final PreCreationModel getSelect() {
        return this.select;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final PreCreationModel getVideo() {
        return this.video;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final PreCreationModel getSwitch() {
        return this.switch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreCreationModel getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PreCreationModel getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PreCreationModel getGifImage() {
        return this.gifImage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PreCreationModel getOverlapContainer() {
        return this.overlapContainer;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PreCreationModel getLinearContainer() {
        return this.linearContainer;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PreCreationModel getWrapContainer() {
        return this.wrapContainer;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final PreCreationModel getGrid() {
        return this.grid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final PreCreationModel getGallery() {
        return this.gallery;
    }

    public final ViewPreCreationProfile copy(String id, PreCreationModel text, PreCreationModel image, PreCreationModel gifImage, PreCreationModel overlapContainer, PreCreationModel linearContainer, PreCreationModel wrapContainer, PreCreationModel grid, PreCreationModel gallery, PreCreationModel pager, PreCreationModel tab, PreCreationModel state, PreCreationModel custom, PreCreationModel indicator, PreCreationModel slider, PreCreationModel input, PreCreationModel select, PreCreationModel video, PreCreationModel preCreationModel) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(gifImage, "gifImage");
        Intrinsics.checkNotNullParameter(overlapContainer, "overlapContainer");
        Intrinsics.checkNotNullParameter(linearContainer, "linearContainer");
        Intrinsics.checkNotNullParameter(wrapContainer, "wrapContainer");
        Intrinsics.checkNotNullParameter(grid, "grid");
        Intrinsics.checkNotNullParameter(gallery, "gallery");
        Intrinsics.checkNotNullParameter(pager, "pager");
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(slider, "slider");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(select, "select");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(preCreationModel, "switch");
        return new ViewPreCreationProfile(id, text, image, gifImage, overlapContainer, linearContainer, wrapContainer, grid, gallery, pager, tab, state, custom, indicator, slider, input, select, video, preCreationModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewPreCreationProfile)) {
            return false;
        }
        ViewPreCreationProfile viewPreCreationProfile = (ViewPreCreationProfile) other;
        return Intrinsics.areEqual(this.id, viewPreCreationProfile.id) && Intrinsics.areEqual(this.text, viewPreCreationProfile.text) && Intrinsics.areEqual(this.image, viewPreCreationProfile.image) && Intrinsics.areEqual(this.gifImage, viewPreCreationProfile.gifImage) && Intrinsics.areEqual(this.overlapContainer, viewPreCreationProfile.overlapContainer) && Intrinsics.areEqual(this.linearContainer, viewPreCreationProfile.linearContainer) && Intrinsics.areEqual(this.wrapContainer, viewPreCreationProfile.wrapContainer) && Intrinsics.areEqual(this.grid, viewPreCreationProfile.grid) && Intrinsics.areEqual(this.gallery, viewPreCreationProfile.gallery) && Intrinsics.areEqual(this.pager, viewPreCreationProfile.pager) && Intrinsics.areEqual(this.tab, viewPreCreationProfile.tab) && Intrinsics.areEqual(this.state, viewPreCreationProfile.state) && Intrinsics.areEqual(this.custom, viewPreCreationProfile.custom) && Intrinsics.areEqual(this.indicator, viewPreCreationProfile.indicator) && Intrinsics.areEqual(this.slider, viewPreCreationProfile.slider) && Intrinsics.areEqual(this.input, viewPreCreationProfile.input) && Intrinsics.areEqual(this.select, viewPreCreationProfile.select) && Intrinsics.areEqual(this.video, viewPreCreationProfile.video) && Intrinsics.areEqual(this.switch, viewPreCreationProfile.switch);
    }

    public int hashCode() {
        String str = this.id;
        return ((((((((((((((((((((((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31) + this.image.hashCode()) * 31) + this.gifImage.hashCode()) * 31) + this.overlapContainer.hashCode()) * 31) + this.linearContainer.hashCode()) * 31) + this.wrapContainer.hashCode()) * 31) + this.grid.hashCode()) * 31) + this.gallery.hashCode()) * 31) + this.pager.hashCode()) * 31) + this.tab.hashCode()) * 31) + this.state.hashCode()) * 31) + this.custom.hashCode()) * 31) + this.indicator.hashCode()) * 31) + this.slider.hashCode()) * 31) + this.input.hashCode()) * 31) + this.select.hashCode()) * 31) + this.video.hashCode()) * 31) + this.switch.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ViewPreCreationProfile(id=");
        sb.append(this.id).append(", text=").append(this.text).append(", image=").append(this.image).append(", gifImage=").append(this.gifImage).append(", overlapContainer=").append(this.overlapContainer).append(", linearContainer=").append(this.linearContainer).append(", wrapContainer=").append(this.wrapContainer).append(", grid=").append(this.grid).append(", gallery=").append(this.gallery).append(", pager=").append(this.pager).append(", tab=").append(this.tab).append(", state=");
        sb.append(this.state).append(", custom=").append(this.custom).append(", indicator=").append(this.indicator).append(", slider=").append(this.slider).append(", input=").append(this.input).append(", select=").append(this.select).append(", video=").append(this.video).append(", switch=").append(this.switch).append(')');
        return sb.toString();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ViewPreCreationProfile(int i, String str, PreCreationModel preCreationModel, PreCreationModel preCreationModel2, PreCreationModel preCreationModel3, PreCreationModel preCreationModel4, PreCreationModel preCreationModel5, PreCreationModel preCreationModel6, PreCreationModel preCreationModel7, PreCreationModel preCreationModel8, PreCreationModel preCreationModel9, PreCreationModel preCreationModel10, PreCreationModel preCreationModel11, PreCreationModel preCreationModel12, PreCreationModel preCreationModel13, PreCreationModel preCreationModel14, PreCreationModel preCreationModel15, PreCreationModel preCreationModel16, PreCreationModel preCreationModel17, PreCreationModel preCreationModel18, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? null : str;
        this.text = (i & 2) == 0 ? new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel;
        this.image = (i & 4) == 0 ? new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel2;
        this.gifImage = (i & 8) == 0 ? new PreCreationModel(3, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel3;
        this.overlapContainer = (i & 16) == 0 ? new PreCreationModel(8, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel4;
        this.linearContainer = (i & 32) == 0 ? new PreCreationModel(12, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel5;
        this.wrapContainer = (i & 64) == 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel6;
        this.grid = (i & 128) == 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel7;
        this.gallery = (i & 256) == 0 ? new PreCreationModel(6, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel8;
        this.pager = (i & 512) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel9;
        this.tab = (i & 1024) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel10;
        this.state = (i & 2048) == 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel11;
        this.custom = (i & 4096) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel12;
        this.indicator = (i & 8192) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel13;
        this.slider = (i & 16384) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel14;
        this.input = (32768 & i) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel15;
        this.select = (65536 & i) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel16;
        this.video = (131072 & i) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel17;
        this.switch = (i & 262144) == 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel18;
    }

    public ViewPreCreationProfile(String str, PreCreationModel text, PreCreationModel image, PreCreationModel gifImage, PreCreationModel overlapContainer, PreCreationModel linearContainer, PreCreationModel wrapContainer, PreCreationModel grid, PreCreationModel gallery, PreCreationModel pager, PreCreationModel tab, PreCreationModel state, PreCreationModel custom, PreCreationModel indicator, PreCreationModel slider, PreCreationModel input, PreCreationModel select, PreCreationModel video, PreCreationModel preCreationModel) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(gifImage, "gifImage");
        Intrinsics.checkNotNullParameter(overlapContainer, "overlapContainer");
        Intrinsics.checkNotNullParameter(linearContainer, "linearContainer");
        Intrinsics.checkNotNullParameter(wrapContainer, "wrapContainer");
        Intrinsics.checkNotNullParameter(grid, "grid");
        Intrinsics.checkNotNullParameter(gallery, "gallery");
        Intrinsics.checkNotNullParameter(pager, "pager");
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(slider, "slider");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(select, "select");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(preCreationModel, "switch");
        this.id = str;
        this.text = text;
        this.image = image;
        this.gifImage = gifImage;
        this.overlapContainer = overlapContainer;
        this.linearContainer = linearContainer;
        this.wrapContainer = wrapContainer;
        this.grid = grid;
        this.gallery = gallery;
        this.pager = pager;
        this.tab = tab;
        this.state = state;
        this.custom = custom;
        this.indicator = indicator;
        this.slider = slider;
        this.input = input;
        this.select = select;
        this.video = video;
        this.switch = preCreationModel;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0259  */
    /* JADX WARN: Code duplicated, block: B:109:0x027e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    /* JADX WARN: Code duplicated, block: B:19:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:31:0x009f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:49:0x010c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0131  */
    /* JADX WARN: Code duplicated, block: B:61:0x0156  */
    /* JADX WARN: Code duplicated, block: B:67:0x017b  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:91:0x020f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0234  */
    @JvmStatic
    public static final /* synthetic */ void write$Self(ViewPreCreationProfile self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            output.encodeSerializableElement(serialDesc, 1, PreCreationModel$$serializer.INSTANCE, self.text);
        } else {
            if (!Intrinsics.areEqual(self.text, new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 1, PreCreationModel$$serializer.INSTANCE, self.text);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
            output.encodeSerializableElement(serialDesc, 2, PreCreationModel$$serializer.INSTANCE, self.image);
        } else {
            if (!Intrinsics.areEqual(self.image, new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 2, PreCreationModel$$serializer.INSTANCE, self.image);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3)) {
            output.encodeSerializableElement(serialDesc, 3, PreCreationModel$$serializer.INSTANCE, self.gifImage);
        } else {
            if (!Intrinsics.areEqual(self.gifImage, new PreCreationModel(3, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 3, PreCreationModel$$serializer.INSTANCE, self.gifImage);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4)) {
            output.encodeSerializableElement(serialDesc, 4, PreCreationModel$$serializer.INSTANCE, self.overlapContainer);
        } else {
            if (!Intrinsics.areEqual(self.overlapContainer, new PreCreationModel(8, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 4, PreCreationModel$$serializer.INSTANCE, self.overlapContainer);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5)) {
            output.encodeSerializableElement(serialDesc, 5, PreCreationModel$$serializer.INSTANCE, self.linearContainer);
        } else {
            if (!Intrinsics.areEqual(self.linearContainer, new PreCreationModel(12, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 5, PreCreationModel$$serializer.INSTANCE, self.linearContainer);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6)) {
            output.encodeSerializableElement(serialDesc, 6, PreCreationModel$$serializer.INSTANCE, self.wrapContainer);
        } else {
            if (!Intrinsics.areEqual(self.wrapContainer, new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 6, PreCreationModel$$serializer.INSTANCE, self.wrapContainer);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7)) {
            output.encodeSerializableElement(serialDesc, 7, PreCreationModel$$serializer.INSTANCE, self.grid);
        } else {
            if (!Intrinsics.areEqual(self.grid, new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 7, PreCreationModel$$serializer.INSTANCE, self.grid);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8)) {
            output.encodeSerializableElement(serialDesc, 8, PreCreationModel$$serializer.INSTANCE, self.gallery);
        } else {
            if (!Intrinsics.areEqual(self.gallery, new PreCreationModel(6, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 8, PreCreationModel$$serializer.INSTANCE, self.gallery);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9)) {
            output.encodeSerializableElement(serialDesc, 9, PreCreationModel$$serializer.INSTANCE, self.pager);
        } else {
            if (!Intrinsics.areEqual(self.pager, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 9, PreCreationModel$$serializer.INSTANCE, self.pager);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10)) {
            output.encodeSerializableElement(serialDesc, 10, PreCreationModel$$serializer.INSTANCE, self.tab);
        } else {
            if (!Intrinsics.areEqual(self.tab, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 10, PreCreationModel$$serializer.INSTANCE, self.tab);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11)) {
            output.encodeSerializableElement(serialDesc, 11, PreCreationModel$$serializer.INSTANCE, self.state);
        } else {
            if (!Intrinsics.areEqual(self.state, new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 11, PreCreationModel$$serializer.INSTANCE, self.state);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12)) {
            output.encodeSerializableElement(serialDesc, 12, PreCreationModel$$serializer.INSTANCE, self.custom);
        } else {
            if (!Intrinsics.areEqual(self.custom, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 12, PreCreationModel$$serializer.INSTANCE, self.custom);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13)) {
            output.encodeSerializableElement(serialDesc, 13, PreCreationModel$$serializer.INSTANCE, self.indicator);
        } else {
            if (!Intrinsics.areEqual(self.indicator, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 13, PreCreationModel$$serializer.INSTANCE, self.indicator);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14)) {
            output.encodeSerializableElement(serialDesc, 14, PreCreationModel$$serializer.INSTANCE, self.slider);
        } else {
            if (!Intrinsics.areEqual(self.slider, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 14, PreCreationModel$$serializer.INSTANCE, self.slider);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15)) {
            output.encodeSerializableElement(serialDesc, 15, PreCreationModel$$serializer.INSTANCE, self.input);
        } else {
            if (!Intrinsics.areEqual(self.input, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 15, PreCreationModel$$serializer.INSTANCE, self.input);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16)) {
            output.encodeSerializableElement(serialDesc, 16, PreCreationModel$$serializer.INSTANCE, self.select);
        } else {
            if (!Intrinsics.areEqual(self.select, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 16, PreCreationModel$$serializer.INSTANCE, self.select);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17)) {
            output.encodeSerializableElement(serialDesc, 17, PreCreationModel$$serializer.INSTANCE, self.video);
        } else {
            if (!Intrinsics.areEqual(self.video, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                output.encodeSerializableElement(serialDesc, 17, PreCreationModel$$serializer.INSTANCE, self.video);
            }
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18)) {
            if (Intrinsics.areEqual(self.switch, new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null))) {
                return;
            }
        }
        output.encodeSerializableElement(serialDesc, 18, PreCreationModel$$serializer.INSTANCE, self.switch);
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ ViewPreCreationProfile(String str, PreCreationModel preCreationModel, PreCreationModel preCreationModel2, PreCreationModel preCreationModel3, PreCreationModel preCreationModel4, PreCreationModel preCreationModel5, PreCreationModel preCreationModel6, PreCreationModel preCreationModel7, PreCreationModel preCreationModel8, PreCreationModel preCreationModel9, PreCreationModel preCreationModel10, PreCreationModel preCreationModel11, PreCreationModel preCreationModel12, PreCreationModel preCreationModel13, PreCreationModel preCreationModel14, PreCreationModel preCreationModel15, PreCreationModel preCreationModel16, PreCreationModel preCreationModel17, PreCreationModel preCreationModel18, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel, (i & 4) != 0 ? new PreCreationModel(20, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel2, (i & 8) != 0 ? new PreCreationModel(3, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel3, (i & 16) != 0 ? new PreCreationModel(8, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel4, (i & 32) != 0 ? new PreCreationModel(12, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel5, (i & 64) != 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel6, (i & 128) != 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel7, (i & 256) != 0 ? new PreCreationModel(6, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel8, (i & 512) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel9, (i & 1024) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel10, (i & 2048) != 0 ? new PreCreationModel(4, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel11, (i & 4096) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel12, (i & 8192) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel13, (i & 16384) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel14, (i & 32768) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel15, (i & 65536) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel16, (i & 131072) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel17, (i & 262144) != 0 ? new PreCreationModel(2, 0, 0, 6, (DefaultConstructorMarker) null) : preCreationModel18);
    }

    public final PreCreationModel getText() {
        return this.text;
    }

    public final PreCreationModel getImage() {
        return this.image;
    }

    public final PreCreationModel getGifImage() {
        return this.gifImage;
    }

    public final PreCreationModel getOverlapContainer() {
        return this.overlapContainer;
    }

    public final PreCreationModel getLinearContainer() {
        return this.linearContainer;
    }

    public final PreCreationModel getWrapContainer() {
        return this.wrapContainer;
    }

    public final PreCreationModel getGrid() {
        return this.grid;
    }

    public final PreCreationModel getGallery() {
        return this.gallery;
    }

    public final PreCreationModel getPager() {
        return this.pager;
    }

    public final PreCreationModel getTab() {
        return this.tab;
    }

    public final PreCreationModel getState() {
        return this.state;
    }

    public final PreCreationModel getCustom() {
        return this.custom;
    }

    public final PreCreationModel getIndicator() {
        return this.indicator;
    }

    public final PreCreationModel getSlider() {
        return this.slider;
    }

    public final PreCreationModel getInput() {
        return this.input;
    }

    public final PreCreationModel getSelect() {
        return this.select;
    }

    public final PreCreationModel getVideo() {
        return this.video;
    }

    public final PreCreationModel getSwitch() {
        return this.switch;
    }

    /* JADX INFO: compiled from: ViewPreCreationProfile.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001JÆ\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/yandex/div/internal/viewpool/ViewPreCreationProfile;", "unconstrained", "id", "", "textCapacity", "", "imageCapacity", "gifImageCapacity", "overlapContainerCapacity", "linearContainerCapacity", "wrapContainerCapacity", "gridCapacity", "galleryCapacity", "pagerCapacity", "tabCapacity", "stateCapacity", "customCapacity", "indicatorCapacity", "sliderCapacity", "inputCapacity", "selectCapacity", "videoCapacity", "switchCapacity", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ViewPreCreationProfile> serializer() {
            return ViewPreCreationProfile$$serializer.INSTANCE;
        }

        public final ViewPreCreationProfile unconstrained(String id, int textCapacity, int imageCapacity, int gifImageCapacity, int overlapContainerCapacity, int linearContainerCapacity, int wrapContainerCapacity, int gridCapacity, int galleryCapacity, int pagerCapacity, int tabCapacity, int stateCapacity, int customCapacity, int indicatorCapacity, int sliderCapacity, int inputCapacity, int selectCapacity, int videoCapacity, int switchCapacity) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            return new ViewPreCreationProfile(id, new PreCreationModel(textCapacity, 0, 0, 6, (DefaultConstructorMarker) null), new PreCreationModel(imageCapacity, 0, 0, 6, (DefaultConstructorMarker) null), new PreCreationModel(gifImageCapacity, i, i2, 6, (DefaultConstructorMarker) null), new PreCreationModel(overlapContainerCapacity, 0, 0, 6, (DefaultConstructorMarker) null), new PreCreationModel(linearContainerCapacity, i3, i4, 6, (DefaultConstructorMarker) null), new PreCreationModel(wrapContainerCapacity, 0, i5, 6, (DefaultConstructorMarker) null), new PreCreationModel(gridCapacity, i5, i6, 6, (DefaultConstructorMarker) null), new PreCreationModel(galleryCapacity, i6, i3, 6, (DefaultConstructorMarker) null), new PreCreationModel(pagerCapacity, i3, i4, 6, (DefaultConstructorMarker) null), new PreCreationModel(tabCapacity, i4, i7, 6, (DefaultConstructorMarker) null), new PreCreationModel(stateCapacity, i7, i8, 6, (DefaultConstructorMarker) null), new PreCreationModel(customCapacity, i8, i9, 6, (DefaultConstructorMarker) null), new PreCreationModel(indicatorCapacity, i9, i10, 6, (DefaultConstructorMarker) null), new PreCreationModel(sliderCapacity, i10, i11, 6, (DefaultConstructorMarker) null), new PreCreationModel(inputCapacity, i11, i12, 6, (DefaultConstructorMarker) null), new PreCreationModel(selectCapacity, i12, i, 6, (DefaultConstructorMarker) null), new PreCreationModel(videoCapacity, i, i2, 6, (DefaultConstructorMarker) null), new PreCreationModel(switchCapacity, i2, 0, 6, (DefaultConstructorMarker) null));
        }
    }
}
