package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.focus.FocusPropertiesModifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.json.c9;
import com.json.m5;
import com.json.mediationsdk.utils.IronSourceConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 Ã\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\bÃ\u0002Ä\u0002Å\u0002Æ\u0002B\u000f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ-\u0010¼\u0001\u001a\u00030\u0083\u00012\b\u0010½\u0001\u001a\u00030¾\u00012\u0007\u0010¿\u0001\u001a\u00020w2\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030Á\u00010\rH\u0002J \u0010Â\u0001\u001a\u00020w2\f\u0010½\u0001\u001a\u0007\u0012\u0002\b\u00030Ã\u00012\u0007\u0010¿\u0001\u001a\u00020wH\u0002J\n\u0010Ä\u0001\u001a\u00030\u0083\u0001H\u0002J\u001a\u0010Å\u0001\u001a\u00030\u0083\u00012\b\u0010\u0092\u0001\u001a\u00030\u0082\u0001H\u0000¢\u0006\u0003\bÆ\u0001J\u001d\u0010Ç\u0001\u001a\u0010\u0012\u0005\u0012\u00030É\u0001\u0012\u0004\u0012\u0002010È\u0001H\u0000¢\u0006\u0003\bÊ\u0001J\n\u0010Ë\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u0083\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030\u0083\u0001H\u0002J\u0014\u0010Î\u0001\u001a\u00030Ï\u00012\b\b\u0002\u00100\u001a\u000201H\u0002J\u0010\u0010Ð\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\bÑ\u0001J\u0010\u0010Ò\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\bÓ\u0001J\u001a\u0010Ô\u0001\u001a\u00030\u0083\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0000¢\u0006\u0003\b×\u0001J&\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u00012\b\u0010½\u0001\u001a\u00030Ú\u00012\u000e\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030Á\u00010\rH\u0002J#\u0010Û\u0001\u001a\u00030\u0083\u00012\u0016\u0010Ü\u0001\u001a\u0011\u0012\u0005\u0012\u00030µ\u0001\u0012\u0005\u0012\u00030\u0083\u00010\u0081\u0001H\u0082\bJ\"\u0010Ý\u0001\u001a\u00030\u0083\u00012\u0015\u0010Ü\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030\u0083\u00010\u0081\u0001H\u0082\bJ\"\u0010Þ\u0001\u001a\u00030\u0083\u00012\u0015\u0010Ü\u0001\u001a\u0010\u0012\u0004\u0012\u00020w\u0012\u0005\u0012\u00030\u0083\u00010\u0081\u0001H\u0082\bJ\n\u0010ß\u0001\u001a\u00030\u0083\u0001H\u0016J\u0010\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030á\u00010\"H\u0016J#\u0010â\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00010\rH\u0000¢\u0006\u0003\bã\u0001J\u001a\u0010ä\u0001\u001a\u00030\u0083\u00012\b\u0010å\u0001\u001a\u00030æ\u0001H\u0000¢\u0006\u0003\bç\u0001J\t\u0010è\u0001\u001a\u00020\bH\u0002JJ\u0010é\u0001\u001a\u00030\u0083\u00012\b\u0010ê\u0001\u001a\u00030ë\u00012\u000f\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030î\u00010í\u00012\t\b\u0002\u0010ï\u0001\u001a\u00020\b2\t\b\u0002\u0010ð\u0001\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bñ\u0001\u0010ò\u0001JJ\u0010ó\u0001\u001a\u00030\u0083\u00012\b\u0010ê\u0001\u001a\u00030ë\u00012\u000f\u0010ô\u0001\u001a\n\u0012\u0005\u0012\u00030õ\u00010í\u00012\t\b\u0002\u0010ï\u0001\u001a\u00020\b2\t\b\u0002\u0010ð\u0001\u001a\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bö\u0001\u0010ò\u0001J$\u0010:\u001a\u00030\u0083\u00012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030\u0083\u00010÷\u0001H\u0080\bø\u0001\u0002¢\u0006\u0003\bø\u0001J\"\u0010ù\u0001\u001a\u00030\u0083\u00012\u0007\u0010ú\u0001\u001a\u0002012\u0007\u0010û\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bü\u0001J\u0010\u0010ý\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\bþ\u0001J\u0010\u0010ÿ\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u0080\u0002J\n\u0010\u0081\u0002\u001a\u00030\u0083\u0001H\u0002J\u0010\u0010\u0082\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u0083\u0002J\u0010\u0010\u0084\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u0085\u0002J\u0010\u0010\u0086\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u0087\u0002J\n\u0010\u0088\u0002\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u0089\u0002\u001a\u00030\u0083\u00012\u0006\u0010q\u001a\u00020pH\u0002J\n\u0010\u008a\u0002\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u008b\u0002\u001a\u0002012\u0007\u0010²\u0001\u001a\u000201H\u0016J\u0011\u0010\u008c\u0002\u001a\u0002012\u0006\u00108\u001a\u000201H\u0016J#\u0010\u008d\u0002\u001a\u00030\u008e\u00022\b\u0010\u008f\u0002\u001a\u00030\u0090\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u0012\u0010\u0093\u0002\u001a\u0002012\u0007\u0010²\u0001\u001a\u000201H\u0016J\u0011\u0010\u0094\u0002\u001a\u0002012\u0006\u00108\u001a\u000201H\u0016J+\u0010\u0095\u0002\u001a\u00030\u0083\u00012\u0007\u0010\u0096\u0002\u001a\u0002012\u0007\u0010\u0097\u0002\u001a\u0002012\u0007\u0010\u0098\u0002\u001a\u000201H\u0000¢\u0006\u0003\b\u0099\u0002J\u0010\u0010\u009a\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b\u009b\u0002J\n\u0010\u009c\u0002\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010\u009d\u0002\u001a\u00030\u0083\u00012\u0007\u0010\u009e\u0002\u001a\u00020\u0000H\u0002J\n\u0010\u009f\u0002\u001a\u00030\u0083\u0001H\u0002J\n\u0010 \u0002\u001a\u00030\u0083\u0001H\u0016J\u0010\u0010¡\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b¢\u0002J\n\u0010£\u0002\u001a\u00030\u0083\u0001H\u0002J#\u0010¤\u0002\u001a\u00030\u0083\u00012\b\u0010\u008f\u0002\u001a\u00030\u0090\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¥\u0002\u0010¦\u0002J\"\u0010§\u0002\u001a\u00030\u0083\u00012\u0007\u0010¨\u0002\u001a\u0002012\u0007\u0010©\u0002\u001a\u000201H\u0000¢\u0006\u0003\bª\u0002J\n\u0010«\u0002\u001a\u00030\u0083\u0001H\u0002J#\u0010¬\u0002\u001a\u00020\b2\f\b\u0002\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0003\b\u00ad\u0002J\u0010\u0010®\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b¯\u0002J\"\u0010°\u0002\u001a\u00030\u0083\u00012\u0007\u0010ú\u0001\u001a\u0002012\u0007\u0010\u0098\u0002\u001a\u000201H\u0000¢\u0006\u0003\b±\u0002J\u0010\u0010²\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b³\u0002J\u001b\u0010´\u0002\u001a\u00030\u0083\u00012\t\b\u0002\u0010µ\u0002\u001a\u00020\bH\u0000¢\u0006\u0003\b¶\u0002J\u001b\u0010·\u0002\u001a\u00030\u0083\u00012\t\b\u0002\u0010µ\u0002\u001a\u00020\bH\u0000¢\u0006\u0003\b¸\u0002J\u0013\u0010¹\u0002\u001a\u00030\u0083\u00012\u0007\u0010º\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010»\u0002\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b¼\u0002J\u001e\u0010½\u0002\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010¾\u0002\u001a\u00020\u00152\u0007\u0010q\u001a\u00030¿\u0002H\u0002J\u0012\u0010À\u0002\u001a\u00030\u0083\u00012\u0006\u0010q\u001a\u00020pH\u0002J\t\u0010Á\u0002\u001a\u00020\bH\u0002J\n\u0010Â\u0002\u001a\u00030Ï\u0001H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\r8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\tR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00000\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R$\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00000\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u0010$R\u0014\u00108\u001a\u0002018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00103R\u000e\u0010:\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010\tR\u0014\u0010A\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001fR\u001e\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001fR\u0014\u0010P\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010R\u001a\u00020Q2\u0006\u0010)\u001a\u00020Q@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u001fR\u001e\u0010Z\u001a\u00020Y2\u0006\u0010N\u001a\u00020Y@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020^8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u001e\u0010a\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u001fR$\u0010d\u001a\u00020c2\u0006\u0010)\u001a\u00020c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020jX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u001a\u0010m\u001a\u00020HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010J\"\u0004\bo\u0010LR$\u0010q\u001a\u00020p2\u0006\u0010)\u001a\u00020p@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020wX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u001e\u0010z\u001a\u00020w2\u0006\u0010N\u001a\u00020w@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b{\u0010yR\u001a\u0010|\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u001f\"\u0004\b~\u0010\tR\u000e\u0010\u007f\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0080\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0081\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R0\u0010\u0088\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0081\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0085\u0001\"\u0006\b\u008a\u0001\u0010\u0087\u0001R%\u0010\u008b\u0001\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u0001\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u008e\u0001\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010=R\u0010\u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0082\u00012\t\u0010N\u001a\u0005\u0018\u00010\u0082\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R \u0010\u009f\u0001\u001a\u0002012\u0006\u0010N\u001a\u000201@BX\u0080\u000e¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u00103R\u000f\u0010¡\u0001\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u000f\u0010ª\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010«\u0001\u001a\u00030¬\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u000f\u0010±\u0001\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010²\u0001\u001a\u0002018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u00103R\u0016\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¶\u0001\u001a\u00030·\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\r8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\b¹\u0001\u0010\u000f\u001a\u0005\bº\u0001\u0010\u0011R\u000f\u0010»\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006Ç\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "(Z)V", "ZComparator", "Ljava/util/Comparator;", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release$annotations", "()V", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "_foldedParent", "_innerLayerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "_unfoldedChildren", "_zSortedChildren", "alignmentLines", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "getAlignmentLines$ui_release", "()Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "getCanMultiMeasure$ui_release", "()Z", "setCanMultiMeasure$ui_release", "children", "", "getChildren$ui_release", "()Ljava/util/List;", c9.COORDINATES, "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerLayerWrapper", "getInnerLayerWrapper", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "innerLayerWrapperIsDirty", "getInnerLayerWrapperIsDirty$ui_release", "setInnerLayerWrapperIsDirty$ui_release", "innerLayoutNodeWrapper", "getInnerLayoutNodeWrapper$ui_release", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "<set-?>", "isPlaced", "isValid", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope$ui_release", "()Landroidx/compose/ui/layout/MeasureScope;", "measuredByParent", "getMeasuredByParent$ui_release", "setMeasuredByParent$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "modifierLocalsHead", "Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "getModifierLocalsHead$ui_release", "()Landroidx/compose/ui/node/ModifierLocalProviderEntity;", "modifierLocalsTail", "getModifierLocalsTail$ui_release", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "onPositionedCallbacks", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "outerLayoutNodeWrapper", "getOuterLayoutNodeWrapper$ui_release", "outerMeasurablePlaceable", "Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "previousPlaceOrder", "relayoutWithoutParentInProgress", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "wrapperCache", "Landroidx/compose/ui/node/ModifiedLayoutNode;", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "addModifierLocalConsumer", "mod", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", IronSourceConstants.EVENTS_PROVIDER, "consumers", "Landroidx/compose/ui/node/ModifierLocalConsumerEntity;", "addModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "alignmentLinesQueriedByModifier", "attach", "attach$ui_release", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLines$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreePlacementIntrinsicsUsage", "copyWrappersToCache", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "findFocusPropertiesModifier", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "Landroidx/compose/ui/focus/FocusOrderModifier;", "forEachDelegate", "block", "forEachDelegateIncludingInner", "forEachModifierLocalProvider", "forceRemeasure", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "getOrCreateOnPositionedCallbacks", "getOrCreateOnPositionedCallbacks$ui_release", "handleMeasureResult", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "handleMeasureResult$ui_release", "hasNewPositioningCallback", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "Landroidx/compose/ui/semantics/SemanticsEntity;", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", m5.p, "insertAt$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateUnfoldedVirtualChildren", "layoutChildren", "layoutChildren$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsPlaced", "markReusedModifiers", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "move", TypedValues.TransitionType.S_FROM, "to", "count", "move$ui_release", "onAlignmentsChanged", "onAlignmentsChanged$ui_release", "onBeforeLayoutChildren", "onChildRemoved", "child", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onNodePlaced", "onNodePlaced$ui_release", "onZSortedChildrenInvalidated", "performMeasure", "performMeasure-BRTryo0$ui_release", "(J)V", "place", VastAttributes.HORIZONTAL_POSITION, VastAttributes.VERTICAL_POSITION, "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestRelayout", "forceRequest", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "reuseLayoutNodeWrapper", "toWrap", "Landroidx/compose/ui/layout/LayoutModifier;", "setModifierLocals", "shouldInvalidateParentLayer", "toString", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LayoutNode implements Measurable, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private final Comparator<LayoutNode> ZComparator;
    private final MutableVector<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private LayoutNodeWrapper _innerLayerWrapper;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private final LayoutNodeAlignmentLines alignmentLines;
    private boolean canMultiMeasure;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerWrapperIsDirty;
    private final LayoutNodeWrapper innerLayoutNodeWrapper;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isPlaced;
    private final boolean isVirtual;
    private LayoutDirection layoutDirection;
    private boolean layoutPending;
    private LayoutState layoutState;
    private boolean measurePending;
    private MeasurePolicy measurePolicy;
    private final MeasureScope measureScope;
    private UsageByParent measuredByParent;
    private Modifier modifier;
    private final ModifierLocalProviderEntity modifierLocalsHead;
    private ModifierLocalProviderEntity modifierLocalsTail;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> onPositionedCallbacks;
    private final OuterMeasurablePlaceable outerMeasurablePlaceable;
    private Owner owner;
    private int placeOrder;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private MutableVector<ModifiedLayoutNode> wrapperCache;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo18measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return (MeasureResult) m3254measure3p2s80s(measureScope, (List<? extends Measurable>) list, j);
        }

        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m3254measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 1, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo3253getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m3951getZeroMYxV2XQ();
        }
    };
    private static final ProvidableModifierLocal ModifierLocalNothing = ModifierLocalKt.modifierLocalOf(new Function0() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ModifierLocalNothing$1
        @Override // kotlin.jvm.functions.Function0
        public final Void invoke() {
            throw new IllegalStateException("default value for sentinel shouldn't be read".toString());
        }
    });
    private static final LayoutNode$Companion$SentinelModifierLocalProvider$1 SentinelModifierLocalProvider = new ModifierLocalProvider() { // from class: androidx.compose.ui.node.LayoutNode$Companion$SentinelModifierLocalProvider$1
        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        public ProvidableModifierLocal getKey() {
            return LayoutNode.ModifierLocalNothing;
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        public Void getValue() {
            throw new IllegalStateException("Sentinel ModifierLocal shouldn't be read".toString());
        }
    };

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum LayoutState {
        Measuring,
        LayingOut,
        Idle
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            iArr[LayoutState.Idle.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 1, null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public static /* synthetic */ void get_children$ui_release$annotations() {
    }

    public LayoutNode(boolean z) {
        this.isVirtual = z;
        this._foldedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.layoutState = LayoutState.Idle;
        this.wrapperCache = new MutableVector<>(new ModifiedLayoutNode[16], 0);
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.measureScope = new LayoutNode$measureScope$1(this);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.alignmentLines = new LayoutNodeAlignmentLines(this);
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.measuredByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        InnerPlaceable innerPlaceable = new InnerPlaceable(this);
        this.innerLayoutNodeWrapper = innerPlaceable;
        this.outerMeasurablePlaceable = new OuterMeasurablePlaceable(this, innerPlaceable);
        this.innerLayerWrapperIsDirty = true;
        ModifierLocalProviderEntity modifierLocalProviderEntity = new ModifierLocalProviderEntity(this, SentinelModifierLocalProvider);
        this.modifierLocalsHead = modifierLocalProviderEntity;
        this.modifierLocalsTail = modifierLocalProviderEntity;
        this.modifier = Modifier.INSTANCE;
        this.ZComparator = new Comparator() { // from class: androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LayoutNode.m3245ZComparator$lambda52((LayoutNode) obj, (LayoutNode) obj2);
            }
        };
    }

    public /* synthetic */ LayoutNode(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asMutableList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> mutableVector2 = this._foldedChildren;
            int size = mutableVector2.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector2.getContent();
                do {
                    LayoutNode layoutNode = content[i];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
        }
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (parent$ui_release = getParent$ui_release()) == null) {
            return;
        }
        parent$ui_release.unfoldedVirtualChildrenListDirty = true;
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren;
        }
        recreateUnfoldedChildrenIfDirty();
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        if (layoutNode == null || !layoutNode.isVirtual) {
            return layoutNode;
        }
        if (layoutNode != null) {
            return layoutNode.getParent$ui_release();
        }
        return null;
    }

    /* JADX INFO: renamed from: getOwner$ui_release, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    /* JADX INFO: renamed from: getDepth$ui_release, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    /* JADX INFO: renamed from: getLayoutState$ui_release, reason: from getter */
    public final LayoutState getLayoutState() {
        return this.layoutState;
    }

    public final void insertAt$ui_release(int index, LayoutNode instance) {
        MutableVector<LayoutNode> mutableVector;
        int size;
        Intrinsics.checkNotNullParameter(instance, "instance");
        int i = 0;
        LayoutNodeWrapper layoutNodeWrapper = null;
        if (instance._foldedParent != null) {
            StringBuilder sbAppend = new StringBuilder("Cannot insert ").append(instance).append(" because it already has a parent. This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            throw new IllegalStateException(sbAppend.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null).toString().toString());
        }
        if (instance.owner != null) {
            throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null)).toString());
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated();
        if (instance.isVirtual) {
            if (this.isVirtual) {
                throw new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
            }
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = instance.getOuterLayoutNodeWrapper$ui_release();
        if (this.isVirtual) {
            LayoutNode layoutNode2 = this._foldedParent;
            if (layoutNode2 != null) {
                layoutNodeWrapper = layoutNode2.innerLayoutNodeWrapper;
            }
        } else {
            layoutNodeWrapper = this.innerLayoutNodeWrapper;
        }
        outerLayoutNodeWrapper$ui_release.setWrappedBy$ui_release(layoutNodeWrapper);
        if (instance.isVirtual && (size = (mutableVector = instance._foldedChildren).getSize()) > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                content[i].getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(this.innerLayoutNodeWrapper);
                i++;
            } while (i < size);
        }
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onZSortedChildrenInvalidated() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int index, int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("count (" + count + ") must be greater than 0").toString());
        }
        int i = (count + index) - 1;
        if (index > i) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.removeAt(i));
            if (i == index) {
                return;
            } else {
                i--;
            }
        }
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 < size) {
                onChildRemoved(this._foldedChildren.getContent()[size]);
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> mutableVector = child._foldedChildren;
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i = 0;
                do {
                    content[i].getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(null);
                    i++;
                } while (i < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated();
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < count; i++) {
            this._foldedChildren.add(from > to ? to + i : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i : from));
        }
        onZSortedChildrenInvalidated();
        invalidateUnfoldedVirtualChildren();
        requestRemeasure$ui_release$default(this, false, 1, null);
    }

    public final void attach$ui_release(Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.owner != null) {
            throw new IllegalStateException(("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString$default(this, 0, 1, null)).toString());
        }
        LayoutNode layoutNode = this._foldedParent;
        if (layoutNode != null) {
            if (!Intrinsics.areEqual(layoutNode != null ? layoutNode.owner : null, owner)) {
                StringBuilder sbAppend = new StringBuilder("Attaching to a different owner(").append(owner).append(") than the parent's owner(");
                LayoutNode parent$ui_release = getParent$ui_release();
                StringBuilder sbAppend2 = sbAppend.append(parent$ui_release != null ? parent$ui_release.owner : null).append("). This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Parent tree: ");
                LayoutNode layoutNode2 = this._foldedParent;
                throw new IllegalStateException(sbAppend2.append(layoutNode2 != null ? debugTreeToString$default(layoutNode2, 0, 1, null) : null).toString().toString());
            }
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 == null) {
            this.isPlaced = true;
        }
        this.owner = owner;
        this.depth = (parent$ui_release2 != null ? parent$ui_release2.depth : -1) + 1;
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner.onSemanticsChange();
        }
        owner.onAttach(this);
        MutableVector<LayoutNode> mutableVector = this._foldedChildren;
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].attach$ui_release(owner);
                i++;
            } while (i < size);
        }
        requestRemeasure$ui_release$default(this, false, 1, null);
        if (parent$ui_release2 != null) {
            requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
        }
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            outerLayoutNodeWrapper$ui_release.attach();
        }
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            next.attach();
        }
        Function1<? super Owner, Unit> function1 = this.onAttach;
        if (function1 != null) {
            function1.invoke(owner);
        }
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            throw new IllegalStateException(sb.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null).toString().toString());
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
        }
        this.alignmentLines.reset$ui_release();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            next.detach();
        }
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            outerLayoutNodeWrapper$ui_release.detach();
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner.onSemanticsChange();
        }
        owner.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector<LayoutNode> mutableVector = this._foldedChildren;
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].detach$ui_release();
                i++;
            } while (i < size);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(this.ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                sb.append(content[i2].debugTreeToString(depth + 1));
                i2++;
            } while (i2 < size);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "tree.toString()");
        if (depth != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m3255maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m3256maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m3257minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m3258minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        /* JADX INFO: renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m3258minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m3257minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m3256maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m3255maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.measurePolicy, value)) {
            return;
        }
        this.measurePolicy = value;
        this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
        requestRemeasure$ui_release$default(this, false, 1, null);
    }

    /* JADX INFO: renamed from: getIntrinsicsPolicy$ui_release, reason: from getter */
    public final IntrinsicsPolicy getIntrinsicsPolicy() {
        return this.intrinsicsPolicy;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.density, value)) {
            return;
        }
        this.density = value;
        onDensityOrLayoutDirectionChanged();
    }

    /* JADX INFO: renamed from: getMeasureScope$ui_release, reason: from getter */
    public final MeasureScope getMeasureScope() {
        return this.measureScope;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "<set-?>");
        this.viewConfiguration = viewConfiguration;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.outerMeasurablePlaceable.getWidth();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.outerMeasurablePlaceable.getHeight();
    }

    /* JADX INFO: renamed from: getAlignmentLines$ui_release, reason: from getter */
    public final LayoutNodeAlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    /* JADX INFO: renamed from: isPlaced, reason: from getter */
    public boolean getIsPlaced() {
        return this.isPlaced;
    }

    /* JADX INFO: renamed from: getPlaceOrder$ui_release, reason: from getter */
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    /* JADX INFO: renamed from: getMeasuredByParent$ui_release, reason: from getter */
    public final UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    /* JADX INFO: renamed from: getIntrinsicsUsageByParent$ui_release, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* JADX INFO: renamed from: getCanMultiMeasure$ui_release, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    /* JADX INFO: renamed from: getInnerLayoutNodeWrapper$ui_release, reason: from getter */
    public final LayoutNodeWrapper getInnerLayoutNodeWrapper() {
        return this.innerLayoutNodeWrapper;
    }

    public final LayoutNodeWrapper getOuterLayoutNodeWrapper$ui_release() {
        return this.outerMeasurablePlaceable.getOuterWrapper();
    }

    /* JADX INFO: renamed from: getSubcompositionsState$ui_release, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* JADX INFO: renamed from: getInnerLayerWrapperIsDirty$ui_release, reason: from getter */
    public final boolean getInnerLayerWrapperIsDirty() {
        return this.innerLayerWrapperIsDirty;
    }

    public final void setInnerLayerWrapperIsDirty$ui_release(boolean z) {
        this.innerLayerWrapperIsDirty = z;
    }

    private final LayoutNodeWrapper getInnerLayerWrapper() {
        if (this.innerLayerWrapperIsDirty) {
            LayoutNodeWrapper wrappedBy$ui_release = this.innerLayoutNodeWrapper;
            LayoutNodeWrapper wrappedBy$ui_release2 = getOuterLayoutNodeWrapper$ui_release().getWrappedBy();
            this._innerLayerWrapper = null;
            while (!Intrinsics.areEqual(wrappedBy$ui_release, wrappedBy$ui_release2)) {
                if ((wrappedBy$ui_release != null ? wrappedBy$ui_release.getLayer() : null) != null) {
                    this._innerLayerWrapper = wrappedBy$ui_release;
                    break;
                }
                wrappedBy$ui_release = wrappedBy$ui_release != null ? wrappedBy$ui_release.getWrappedBy() : null;
            }
        }
        LayoutNodeWrapper layoutNodeWrapper = this._innerLayerWrapper;
        if (layoutNodeWrapper == null || layoutNodeWrapper.getLayer() != null) {
            return layoutNodeWrapper;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: renamed from: getModifierLocalsHead$ui_release, reason: from getter */
    public final ModifierLocalProviderEntity getModifierLocalsHead() {
        return this.modifierLocalsHead;
    }

    /* JADX INFO: renamed from: getModifierLocalsTail$ui_release, reason: from getter */
    public final ModifierLocalProviderEntity getModifierLocalsTail() {
        return this.modifierLocalsTail;
    }

    public final void invalidateLayer$ui_release() {
        LayoutNodeWrapper innerLayerWrapper = getInnerLayerWrapper();
        if (innerLayerWrapper != null) {
            innerLayerWrapper.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier value) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        Owner owner;
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.modifier)) {
            return;
        }
        if (!Intrinsics.areEqual(getModifier(), Modifier.INSTANCE) && this.isVirtual) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = value;
        boolean zShouldInvalidateParentLayer = shouldInvalidateParentLayer();
        copyWrappersToCache();
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            EntityList.m3216clearimpl(outerLayoutNodeWrapper$ui_release.m3274getEntitiesCHwCgZE());
        }
        markReusedModifiers(value);
        LayoutNodeWrapper outerWrapper = this.outerMeasurablePlaceable.getOuterWrapper();
        if (SemanticsNodeKt.getOuterSemantics(this) != null && isAttached()) {
            Owner owner2 = this.owner;
            Intrinsics.checkNotNull(owner2);
            owner2.onSemanticsChange();
        }
        boolean zHasNewPositioningCallback = hasNewPositioningCallback();
        MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector = this.onPositionedCallbacks;
        if (mutableVector != null) {
            mutableVector.clear();
        }
        this.innerLayoutNodeWrapper.onInitialize();
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) getModifier().foldOut(this.innerLayoutNodeWrapper, new Function2<Modifier.Element, LayoutNodeWrapper, LayoutNodeWrapper>() { // from class: androidx.compose.ui.node.LayoutNode$modifier$outerWrapper$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final LayoutNodeWrapper invoke(Modifier.Element mod, LayoutNodeWrapper toWrap) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(toWrap, "toWrap");
                if (mod instanceof RemeasurementModifier) {
                    ((RemeasurementModifier) mod).onRemeasurementAvailable(this.this$0);
                }
                Modifier.Element element = mod;
                EntityList.m3214addBeforeLayoutModifierimpl(toWrap.m3274getEntitiesCHwCgZE(), toWrap, element);
                if (mod instanceof OnGloballyPositionedModifier) {
                    this.this$0.getOrCreateOnPositionedCallbacks$ui_release().add(TuplesKt.to(toWrap, mod));
                }
                if (mod instanceof LayoutModifier) {
                    LayoutModifier layoutModifier = (LayoutModifier) mod;
                    ModifiedLayoutNode modifiedLayoutNodeReuseLayoutNodeWrapper = this.this$0.reuseLayoutNodeWrapper(toWrap, layoutModifier);
                    if (modifiedLayoutNodeReuseLayoutNodeWrapper == null) {
                        modifiedLayoutNodeReuseLayoutNodeWrapper = new ModifiedLayoutNode(toWrap, layoutModifier);
                    }
                    modifiedLayoutNodeReuseLayoutNodeWrapper.onInitialize();
                    toWrap = modifiedLayoutNodeReuseLayoutNodeWrapper;
                }
                EntityList.m3213addAfterLayoutModifierimpl(toWrap.m3274getEntitiesCHwCgZE(), toWrap, element);
                return toWrap;
            }
        });
        setModifierLocals(value);
        LayoutNode parent$ui_release3 = getParent$ui_release();
        layoutNodeWrapper.setWrappedBy$ui_release(parent$ui_release3 != null ? parent$ui_release3.innerLayoutNodeWrapper : null);
        this.outerMeasurablePlaceable.setOuterWrapper(layoutNodeWrapper);
        if (isAttached()) {
            MutableVector<ModifiedLayoutNode> mutableVector2 = this.wrapperCache;
            int size = mutableVector2.getSize();
            if (size > 0) {
                ModifiedLayoutNode[] content = mutableVector2.getContent();
                int i = 0;
                do {
                    content[i].detach();
                    i++;
                } while (i < size);
            }
            LayoutNodeWrapper wrapped$ui_release2 = this.innerLayoutNodeWrapper.getWrapped();
            for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release2 = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release2, wrapped$ui_release2) && outerLayoutNodeWrapper$ui_release2 != null; outerLayoutNodeWrapper$ui_release2 = outerLayoutNodeWrapper$ui_release2.getWrapped()) {
                if (!outerLayoutNodeWrapper$ui_release2.isAttached()) {
                    outerLayoutNodeWrapper$ui_release2.attach();
                } else {
                    for (LayoutNodeEntity<?, ?> next : outerLayoutNodeWrapper$ui_release2.m3274getEntitiesCHwCgZE()) {
                        for (; next != null; next = next.getNext()) {
                            next.onAttach();
                        }
                    }
                }
            }
        }
        this.wrapperCache.clear();
        LayoutNodeWrapper wrapped$ui_release3 = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release3 = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release3, wrapped$ui_release3) && outerLayoutNodeWrapper$ui_release3 != null; outerLayoutNodeWrapper$ui_release3 = outerLayoutNodeWrapper$ui_release3.getWrapped()) {
            outerLayoutNodeWrapper$ui_release3.onModifierChanged();
        }
        if (!Intrinsics.areEqual(outerWrapper, this.innerLayoutNodeWrapper) || !Intrinsics.areEqual(layoutNodeWrapper, this.innerLayoutNodeWrapper)) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        } else if (this.layoutState == LayoutState.Idle && !this.measurePending && zHasNewPositioningCallback) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        } else if (EntityList.m3224has0OSVbXo(this.innerLayoutNodeWrapper.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3231getOnPlacedEntityTypeEEbPh1w()) && (owner = this.owner) != null) {
            owner.registerOnLayoutCompletedListener(this);
        }
        Object parentData = getParentData();
        this.outerMeasurablePlaceable.recalculateParentData();
        if (!Intrinsics.areEqual(parentData, getParentData()) && (parent$ui_release2 = getParent$ui_release()) != null) {
            requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
        }
        if ((zShouldInvalidateParentLayer || shouldInvalidateParentLayer()) && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return this.innerLayoutNodeWrapper;
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> getOrCreateOnPositionedCallbacks$ui_release() {
        MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector = this.onPositionedCallbacks;
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector2 = new MutableVector<>(new Pair[16], 0);
        this.onPositionedCallbacks = mutableVector2;
        return mutableVector2;
    }

    /* JADX INFO: renamed from: getNeedsOnPositionedDispatch$ui_release, reason: from getter */
    public final boolean getNeedsOnPositionedDispatch() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int x, int y) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
        int measuredWidth = this.outerMeasurablePlaceable.getMeasuredWidth();
        LayoutDirection layoutDirection = getLayoutDirection();
        int parentWidth = Placeable.PlacementScope.INSTANCE.getParentWidth();
        LayoutDirection parentLayoutDirection = Placeable.PlacementScope.INSTANCE.getParentLayoutDirection();
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = measuredWidth;
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        Placeable.PlacementScope.placeRelative$default(companion, this.outerMeasurablePlaceable, x, y, 0.0f, 4, null);
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            this.outerMeasurablePlaceable.replace();
        } finally {
            this.relayoutWithoutParentInProgress = false;
        }
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterLayoutNodeWrapper$ui_release().draw(canvas);
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m3246hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = true;
        }
        layoutNode.m3249hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z2);
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3249hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult<PointerInputFilter> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterLayoutNodeWrapper$ui_release().m3277hitTestYqVAtuI(LayoutNodeWrapper.INSTANCE.getPointerInputSource(), getOuterLayoutNodeWrapper$ui_release().m3273fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
    }

    /* JADX INFO: renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3250hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult<SemanticsEntity> hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        getOuterLayoutNodeWrapper$ui_release().m3277hitTestYqVAtuI(LayoutNodeWrapper.INSTANCE.getSemanticsSource(), getOuterLayoutNodeWrapper$ui_release().m3273fromParentPositionMKHz9U(pointerPosition), hitSemanticsEntities, true, isInLayer);
    }

    private final boolean hasNewPositioningCallback() {
        final MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector = this.onPositionedCallbacks;
        return ((Boolean) getModifier().foldOut(false, new Function2<Modifier.Element, Boolean, Boolean>() { // from class: androidx.compose.ui.node.LayoutNode.hasNewPositioningCallback.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Modifier.Element element, Boolean bool) {
                return invoke(element, bool.booleanValue());
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0035  */
            public final Boolean invoke(Modifier.Element mod, boolean z) {
                boolean z2;
                Intrinsics.checkNotNullParameter(mod, "mod");
                if (z) {
                    z2 = true;
                } else {
                    z2 = false;
                    if (mod instanceof OnGloballyPositionedModifier) {
                        MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector2 = mutableVector;
                        Pair<LayoutNodeWrapper, OnGloballyPositionedModifier> pair = null;
                        if (mutableVector2 != null) {
                            int size = mutableVector2.getSize();
                            if (size > 0) {
                                Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>[] content = mutableVector2.getContent();
                                int i = 0;
                                do {
                                    Pair<LayoutNodeWrapper, OnGloballyPositionedModifier> pair2 = content[i];
                                    if (Intrinsics.areEqual(mod, pair2.getSecond())) {
                                        pair = pair2;
                                        break;
                                    }
                                    i++;
                                } while (i < size);
                            }
                            pair = pair;
                        }
                        if (pair == null) {
                            z2 = true;
                        }
                    }
                }
                return Boolean.valueOf(z2);
            }
        })).booleanValue();
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent$ui_release = getParent$ui_release();
        float zIndex = this.innerLayoutNodeWrapper.getZIndex();
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            zIndex += modifiedLayoutNode.getZIndex();
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped();
        }
        if (zIndex != this.zIndex) {
            this.zIndex = zIndex;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!getIsPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent$ui_release != null) {
            if (!this.relayoutWithoutParentInProgress && parent$ui_release.layoutState == LayoutState.LayingOut) {
                if (this.placeOrder != Integer.MAX_VALUE) {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
                int i = parent$ui_release.nextChildPlaceOrder;
                this.placeOrder = i;
                parent$ui_release.nextChildPlaceOrder = i + 1;
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren$ui_release();
    }

    public final void layoutChildren$ui_release() {
        this.alignmentLines.recalculateQueryOwner$ui_release();
        if (this.layoutPending) {
            onBeforeLayoutChildren();
        }
        if (this.layoutPending) {
            this.layoutPending = false;
            this.layoutState = LayoutState.LayingOut;
            LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$layoutChildren$1
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
                    int i = 0;
                    this.this$0.nextChildPlaceOrder = 0;
                    MutableVector<LayoutNode> mutableVector = this.this$0.get_children$ui_release();
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        LayoutNode[] content = mutableVector.getContent();
                        int i2 = 0;
                        do {
                            LayoutNode layoutNode = content[i2];
                            layoutNode.previousPlaceOrder = layoutNode.getPlaceOrder();
                            layoutNode.placeOrder = Integer.MAX_VALUE;
                            layoutNode.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                            if (layoutNode.getMeasuredByParent() == LayoutNode.UsageByParent.InLayoutBlock) {
                                layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                            }
                            i2++;
                        } while (i2 < size);
                    }
                    this.this$0.getInnerLayoutNodeWrapper().getMeasureResult().placeChildren();
                    MutableVector<LayoutNode> mutableVector2 = this.this$0.get_children$ui_release();
                    LayoutNode layoutNode2 = this.this$0;
                    int size2 = mutableVector2.getSize();
                    if (size2 > 0) {
                        LayoutNode[] content2 = mutableVector2.getContent();
                        do {
                            LayoutNode layoutNode3 = content2[i];
                            if (layoutNode3.previousPlaceOrder != layoutNode3.getPlaceOrder()) {
                                layoutNode2.onZSortedChildrenInvalidated();
                                layoutNode2.invalidateLayer$ui_release();
                                if (layoutNode3.getPlaceOrder() == Integer.MAX_VALUE) {
                                    layoutNode3.markSubtreeAsNotPlaced();
                                }
                            }
                            layoutNode3.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(layoutNode3.getAlignmentLines().getUsedDuringParentLayout());
                            i++;
                        } while (i < size2);
                    }
                }
            });
            this.layoutState = LayoutState.Idle;
        }
        if (this.alignmentLines.getUsedDuringParentLayout()) {
            this.alignmentLines.setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (this.alignmentLines.getDirty() && this.alignmentLines.getRequired$ui_release()) {
            this.alignmentLines.recalculate();
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        this.isPlaced = true;
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            if (outerLayoutNodeWrapper$ui_release.getLastLayerDrawingWasSkipped()) {
                outerLayoutNodeWrapper$ui_release.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.placeOrder != Integer.MAX_VALUE) {
                    layoutNode.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout(layoutNode);
                }
                i++;
            } while (i < size);
        }
    }

    private final void rescheduleRemeasureOrRelayout(LayoutNode it) {
        if (WhenMappings.$EnumSwitchMapping$0[it.layoutState.ordinal()] == 1) {
            if (it.measurePending) {
                it.requestRemeasure$ui_release(true);
                return;
            } else {
                if (it.layoutPending) {
                    it.requestRelayout$ui_release(true);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + it.layoutState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markSubtreeAsNotPlaced() {
        if (getIsPlaced()) {
            int i = 0;
            this.isPlaced = false;
            MutableVector<LayoutNode> mutableVector = get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                do {
                    content[i].markSubtreeAsNotPlaced();
                    i++;
                } while (i < size);
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.measurePending && layoutNode.measuredByParent == UsageByParent.InMeasureBlock && m3248remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null)) {
                    requestRemeasure$ui_release$default(this, false, 1, null);
                }
                i++;
            } while (i < size);
        }
    }

    public final void onAlignmentsChanged$ui_release() {
        if (this.alignmentLines.getDirty()) {
            return;
        }
        this.alignmentLines.setDirty$ui_release(true);
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null) {
            return;
        }
        if (this.alignmentLines.getUsedDuringParentMeasurement()) {
            requestRemeasure$ui_release$default(parent$ui_release, false, 1, null);
        } else if (this.alignmentLines.getPreviousUsedDuringParentLayout()) {
            requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
        }
        if (this.alignmentLines.getUsedByModifierMeasurement()) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        }
        if (this.alignmentLines.getUsedByModifierLayout()) {
            requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
        }
        parent$ui_release.onAlignmentsChanged$ui_release();
    }

    public final Map<AlignmentLine, Integer> calculateAlignmentLines$ui_release() {
        if (!this.outerMeasurablePlaceable.getDuringAlignmentLinesQuery$ui_release()) {
            alignmentLinesQueriedByModifier();
        }
        layoutChildren$ui_release();
        return this.alignmentLines.getLastCalculation();
    }

    private final void alignmentLinesQueriedByModifier() {
        if (this.layoutState == LayoutState.Measuring) {
            this.alignmentLines.setUsedByModifierMeasurement$ui_release(true);
            if (this.alignmentLines.getDirty()) {
                markLayoutPending$ui_release();
                return;
            }
            return;
        }
        this.alignmentLines.setUsedByModifierLayout$ui_release(true);
    }

    public final void handleMeasureResult$ui_release(MeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        this.innerLayoutNodeWrapper.setMeasureResult$ui_release(measureResult);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRemeasure$ui_release(z);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestMeasure(this, forceRequest);
        this.outerMeasurablePlaceable.invalidateIntrinsicsParent(forceRequest);
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, forceRequest);
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        MutableVector<Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector;
        int size;
        if (this.layoutState != LayoutState.Idle || this.layoutPending || this.measurePending || !getIsPlaced() || (mutableVector = this.onPositionedCallbacks) == null || (size = mutableVector.getSize()) <= 0) {
            return;
        }
        Pair<LayoutNodeWrapper, OnGloballyPositionedModifier>[] content = mutableVector.getContent();
        int i = 0;
        do {
            Pair<LayoutNodeWrapper, OnGloballyPositionedModifier> pair = content[i];
            pair.getSecond().onGloballyPositioned(pair.getFirst());
            i++;
        } while (i < size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModifierLocalProviderEntity addModifierLocalProvider(ModifierLocalProvider<?> mod, ModifierLocalProviderEntity provider) {
        ModifierLocalProviderEntity next = provider.getNext();
        while (next != null && next.getModifier() != mod) {
            next = next.getNext();
        }
        if (next == null) {
            next = new ModifierLocalProviderEntity(this, mod);
        } else {
            ModifierLocalProviderEntity prev = next.getPrev();
            if (prev != null) {
                prev.setNext(next.getNext());
            }
            ModifierLocalProviderEntity next2 = next.getNext();
            if (next2 != null) {
                next2.setPrev(next.getPrev());
            }
        }
        next.setNext(provider.getNext());
        ModifierLocalProviderEntity next3 = provider.getNext();
        if (next3 != null) {
            next3.setPrev(next);
        }
        provider.setNext(next);
        next.setPrev(provider);
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModifiedLayoutNode reuseLayoutNodeWrapper(LayoutNodeWrapper toWrap, LayoutModifier modifier) {
        int i;
        if (this.wrapperCache.isEmpty()) {
            return null;
        }
        MutableVector<ModifiedLayoutNode> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        int i2 = -1;
        if (size <= 0) {
            i = -1;
            break;
        }
        i = size - 1;
        ModifiedLayoutNode[] content = mutableVector.getContent();
        while (true) {
            ModifiedLayoutNode modifiedLayoutNode = content[i];
            if (modifiedLayoutNode.getToBeReusedForSameModifier() && modifiedLayoutNode.getModifier() == modifier) {
                break;
            }
            i--;
            if (i < 0) {
                i = -1;
                break;
            }
        }
        if (i < 0) {
            MutableVector<ModifiedLayoutNode> mutableVector2 = this.wrapperCache;
            int size2 = mutableVector2.getSize();
            if (size2 > 0) {
                int i3 = size2 - 1;
                ModifiedLayoutNode[] content2 = mutableVector2.getContent();
                do {
                    if (!content2[i3].getToBeReusedForSameModifier()) {
                        i2 = i3;
                        break;
                    }
                    i3--;
                } while (i3 >= 0);
            }
            i = i2;
        }
        if (i < 0) {
            return null;
        }
        ModifiedLayoutNode modifiedLayoutNodeRemoveAt = this.wrapperCache.removeAt(i);
        modifiedLayoutNodeRemoveAt.setModifier(modifier);
        modifiedLayoutNodeRemoveAt.setWrapped(toWrap);
        return modifiedLayoutNodeRemoveAt;
    }

    private final void markReusedModifiers(Modifier modifier) {
        MutableVector<ModifiedLayoutNode> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifiedLayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].setToBeReusedForSameModifier(false);
                i++;
            } while (i < size);
        }
        modifier.foldIn(Unit.INSTANCE, new Function2<Unit, Modifier.Element, Unit>() { // from class: androidx.compose.ui.node.LayoutNode.markReusedModifiers.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit, Modifier.Element element) {
                invoke2(unit, element);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit, Modifier.Element mod) {
                Object obj;
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(mod, "mod");
                MutableVector mutableVector2 = LayoutNode.this.wrapperCache;
                int size2 = mutableVector2.getSize();
                if (size2 <= 0) {
                    obj = null;
                    break;
                }
                int i2 = size2 - 1;
                Object[] content2 = mutableVector2.getContent();
                while (true) {
                    obj = content2[i2];
                    ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) obj;
                    if (modifiedLayoutNode.getModifier() == mod && !modifiedLayoutNode.getToBeReusedForSameModifier()) {
                        break;
                    }
                    i2--;
                    if (i2 < 0) {
                        obj = null;
                        break;
                    }
                }
                ModifiedLayoutNode modifiedLayoutNode2 = (ModifiedLayoutNode) obj;
                if (modifiedLayoutNode2 == null) {
                    return;
                }
                modifiedLayoutNode2.setToBeReusedForSameModifier(true);
            }
        });
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo3124measureBRTryo0(long constraints) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage();
        }
        return this.outerMeasurablePlaceable.mo3124measureBRTryo0(constraints);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m3248remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.outerMeasurablePlaceable.m3289getLastConstraintsDWUhwKw();
        }
        return layoutNode.m3252remeasure_Sx5XlM$ui_release(constraints);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m3252remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage();
        }
        return this.outerMeasurablePlaceable.m3290remeasureBRTryo0(constraints.getValue());
    }

    /* JADX INFO: renamed from: getMeasurePending$ui_release, reason: from getter */
    public final boolean getMeasurePending() {
        return this.measurePending;
    }

    /* JADX INFO: renamed from: getLayoutPending$ui_release, reason: from getter */
    public final boolean getLayoutPending() {
        return this.layoutPending;
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    /* JADX INFO: renamed from: performMeasure-BRTryo0$ui_release, reason: not valid java name */
    public final void m3251performMeasureBRTryo0$ui_release(final long constraints) {
        this.layoutState = LayoutState.Measuring;
        this.measurePending = false;
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$performMeasure$1
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
                this.this$0.getOuterLayoutNodeWrapper$ui_release().mo3124measureBRTryo0(constraints);
            }
        });
        if (this.layoutState == LayoutState.Measuring) {
            markLayoutPending$ui_release();
            this.layoutState = LayoutState.Idle;
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.outerMeasurablePlaceable.getParentData();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        return this.outerMeasurablePlaceable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        return this.outerMeasurablePlaceable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        return this.outerMeasurablePlaceable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        return this.outerMeasurablePlaceable.maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        Constraints constraintsM3289getLastConstraintsDWUhwKw = this.outerMeasurablePlaceable.m3289getLastConstraintsDWUhwKw();
        if (constraintsM3289getLastConstraintsDWUhwKw != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo3299measureAndLayout0kLqBqw(this, constraintsM3289getLastConstraintsDWUhwKw.getValue());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        for (LayoutNodeEntity<?, ?> next = this.innerLayoutNodeWrapper.m3274getEntitiesCHwCgZE()[EntityList.INSTANCE.m3231getOnPlacedEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((OnPlacedModifier) ((SimpleEntity) next).getModifier()).onPlaced(this.innerLayoutNodeWrapper);
        }
    }

    private final void forEachDelegate(Function1<? super ModifiedLayoutNode, Unit> block) {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            block.invoke(modifiedLayoutNode);
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped();
        }
    }

    private final void forEachDelegateIncludingInner(Function1<? super LayoutNodeWrapper, Unit> block) {
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            block.invoke(outerLayoutNodeWrapper$ui_release);
        }
    }

    private final void forEachModifierLocalProvider(Function1<? super ModifierLocalProviderEntity, Unit> block) {
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            block.invoke(next);
        }
    }

    private final void clearSubtreeIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ZComparator$lambda-52, reason: not valid java name */
    public static final int m3245ZComparator$lambda52(LayoutNode layoutNode, LayoutNode layoutNode2) {
        float f = layoutNode.zIndex;
        float f2 = layoutNode2.zIndex;
        if (f == f2) {
            return Intrinsics.compare(layoutNode.placeOrder, layoutNode2.placeOrder);
        }
        return Float.compare(f, f2);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003*\u0001\u0014\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "ModifierLocalNothing", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "NotPlacedPlaceOrder", "", "SentinelModifierLocalProvider", "androidx/compose/ui/node/LayoutNode$Companion$SentinelModifierLocalProvider$1", "Landroidx/compose/ui/node/LayoutNode$Companion$SentinelModifierLocalProvider$1;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        MutableVector mutableVector = new MutableVector(new ModifierInfo[16], 0);
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            OwnedLayer layer = modifiedLayoutNode.getLayer();
            ModifiedLayoutNode modifiedLayoutNode2 = modifiedLayoutNode;
            mutableVector.add(new ModifierInfo(modifiedLayoutNode.getModifier(), modifiedLayoutNode2, layer));
            for (LayoutNodeEntity<?, ?> next : modifiedLayoutNode.m3274getEntitiesCHwCgZE()) {
                for (; next != null; next = next.getNext()) {
                    mutableVector.add(new ModifierInfo(next.getModifier(), modifiedLayoutNode2, layer));
                }
            }
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped();
        }
        for (LayoutNodeEntity<?, ?> next2 : this.innerLayoutNodeWrapper.m3274getEntitiesCHwCgZE()) {
            for (; next2 != null; next2 = next2.getNext()) {
                Modifier modifier = next2.getModifier();
                LayoutNodeWrapper layoutNodeWrapper2 = this.innerLayoutNodeWrapper;
                mutableVector.add(new ModifierInfo(modifier, layoutNodeWrapper2, layoutNodeWrapper2.getLayer()));
            }
        }
        return mutableVector.asMutableList();
    }

    public final void invalidateLayers$ui_release() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            OwnedLayer layer = modifiedLayoutNode.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped();
        }
        OwnedLayer layer2 = this.innerLayoutNodeWrapper.getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    private final void setModifierLocals(Modifier modifier) {
        int i = 0;
        final MutableVector mutableVector = new MutableVector(new ModifierLocalConsumerEntity[16], 0);
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            mutableVector.addAll(mutableVector.getSize(), next.getConsumers());
            next.getConsumers().clear();
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = (ModifierLocalProviderEntity) modifier.foldIn(this.modifierLocalsHead, new Function2<ModifierLocalProviderEntity, Modifier.Element, ModifierLocalProviderEntity>() { // from class: androidx.compose.ui.node.LayoutNode.setModifierLocals.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ModifierLocalProviderEntity invoke(ModifierLocalProviderEntity lastProvider, Modifier.Element mod) {
                Intrinsics.checkNotNullParameter(lastProvider, "lastProvider");
                Intrinsics.checkNotNullParameter(mod, "mod");
                if (mod instanceof FocusOrderModifier) {
                    FocusOrderModifier focusOrderModifier = (FocusOrderModifier) mod;
                    FocusPropertiesModifier focusPropertiesModifierFindFocusPropertiesModifier = LayoutNode.this.findFocusPropertiesModifier(focusOrderModifier, mutableVector);
                    if (focusPropertiesModifierFindFocusPropertiesModifier == null) {
                        final FocusOrderModifierToProperties focusOrderModifierToProperties = new FocusOrderModifierToProperties(focusOrderModifier);
                        focusPropertiesModifierFindFocusPropertiesModifier = new FocusPropertiesModifier(focusOrderModifierToProperties, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.node.LayoutNode$setModifierLocals$1$invoke$lambda-1$$inlined$debugInspectorInfo$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                                invoke2(inspectorInfo);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InspectorInfo inspectorInfo) {
                                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                                inspectorInfo.setName("focusProperties");
                                inspectorInfo.getProperties().set("scope", focusOrderModifierToProperties);
                            }
                        } : InspectableValueKt.getNoInspectorInfo());
                    }
                    LayoutNode.this.addModifierLocalConsumer(focusPropertiesModifierFindFocusPropertiesModifier, lastProvider, mutableVector);
                    lastProvider = LayoutNode.this.addModifierLocalProvider(focusPropertiesModifierFindFocusPropertiesModifier, lastProvider);
                }
                if (mod instanceof ModifierLocalConsumer) {
                    LayoutNode.this.addModifierLocalConsumer((ModifierLocalConsumer) mod, lastProvider, mutableVector);
                }
                return mod instanceof ModifierLocalProvider ? LayoutNode.this.addModifierLocalProvider((ModifierLocalProvider) mod, lastProvider) : lastProvider;
            }
        });
        this.modifierLocalsTail = modifierLocalProviderEntity;
        this.modifierLocalsTail.setNext(null);
        if (isAttached()) {
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    ((ModifierLocalConsumerEntity) content[i]).detach();
                    i++;
                } while (i < size);
            }
            for (ModifierLocalProviderEntity next2 = modifierLocalProviderEntity.getNext(); next2 != null; next2 = next2.getNext()) {
                next2.detach();
            }
            for (ModifierLocalProviderEntity next3 = this.modifierLocalsHead; next3 != null; next3 = next3.getNext()) {
                next3.attachDelayed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FocusPropertiesModifier findFocusPropertiesModifier(FocusOrderModifier mod, MutableVector<ModifierLocalConsumerEntity> consumers) {
        ModifierLocalConsumerEntity modifierLocalConsumerEntity;
        int size = consumers.getSize();
        if (size <= 0) {
            modifierLocalConsumerEntity = null;
            break;
        }
        ModifierLocalConsumerEntity[] content = consumers.getContent();
        int i = 0;
        while (true) {
            modifierLocalConsumerEntity = content[i];
            ModifierLocalConsumerEntity modifierLocalConsumerEntity2 = modifierLocalConsumerEntity;
            if ((modifierLocalConsumerEntity2.getModifier() instanceof FocusPropertiesModifier) && (((FocusPropertiesModifier) modifierLocalConsumerEntity2.getModifier()).getFocusPropertiesScope() instanceof FocusOrderModifierToProperties) && ((FocusOrderModifierToProperties) ((FocusPropertiesModifier) modifierLocalConsumerEntity2.getModifier()).getFocusPropertiesScope()).getModifier() == mod) {
                break;
            }
            i++;
            if (i >= size) {
                modifierLocalConsumerEntity = null;
                break;
            }
        }
        ModifierLocalConsumerEntity modifierLocalConsumerEntity3 = modifierLocalConsumerEntity;
        ModifierLocalConsumer modifier = modifierLocalConsumerEntity3 != null ? modifierLocalConsumerEntity3.getModifier() : null;
        if (modifier instanceof FocusPropertiesModifier) {
            return (FocusPropertiesModifier) modifier;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addModifierLocalConsumer(ModifierLocalConsumer mod, ModifierLocalProviderEntity provider, MutableVector<ModifierLocalConsumerEntity> consumers) {
        int i;
        ModifierLocalConsumerEntity modifierLocalConsumerEntityRemoveAt;
        int size = consumers.getSize();
        if (size <= 0) {
            i = -1;
            break;
        }
        ModifierLocalConsumerEntity[] content = consumers.getContent();
        i = 0;
        while (content[i].getModifier() != mod) {
            i++;
            if (i >= size) {
                i = -1;
                break;
            }
        }
        if (i < 0) {
            modifierLocalConsumerEntityRemoveAt = new ModifierLocalConsumerEntity(provider, mod);
        } else {
            modifierLocalConsumerEntityRemoveAt = consumers.removeAt(i);
            modifierLocalConsumerEntityRemoveAt.setProvider(provider);
        }
        provider.getConsumers().add(modifierLocalConsumerEntityRemoveAt);
    }

    private final void copyWrappersToCache() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            this.wrapperCache.add(modifiedLayoutNode);
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !Intrinsics.areEqual(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped()) {
            if (outerLayoutNodeWrapper$ui_release.getLayer() != null) {
                return false;
            }
            if (EntityList.m3224has0OSVbXo(outerLayoutNodeWrapper$ui_release.m3274getEntitiesCHwCgZE(), EntityList.INSTANCE.m3230getDrawEntityTypeEEbPh1w())) {
                return true;
            }
        }
        return true;
    }
}
