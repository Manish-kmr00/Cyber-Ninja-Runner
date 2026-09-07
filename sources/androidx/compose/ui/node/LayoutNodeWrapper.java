package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.json.b9;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutNodeWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\"\b \u0018\u0000 á\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004á\u0001â\u0001B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\fH\u0002J%\u0010q\u001a\u00020u2\u0006\u0010r\u001a\u00020\u00002\u0006\u0010v\u001a\u00020uH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010xJ\b\u0010y\u001a\u00020\u0007H\u0016J\u0010\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020EH&J\u001d\u0010|\u001a\u00020@2\u0006\u0010?\u001a\u00020@H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b}\u0010~J\b\u0010\u007f\u001a\u00020\u0007H\u0016J)\u0010\u0080\u0001\u001a\u00020\"2\u0007\u0010\u0081\u0001\u001a\u00020u2\u0006\u0010?\u001a\u00020@H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0006J\u001c\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00062\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0004J\u0012\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0002J\u0018\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u008b\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u008c\u0001J\u001f\u0010\u008d\u0001\u001a\u00020u2\u0006\u0010Q\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u008e\u0001\u0010~J\u001a\u0010\u008f\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\fH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020F2\u0006\u0010{\u001a\u00020EH\u0086\u0002J\u008e\u0001\u0010\u0092\u0001\u001a\u00020\u0007\"\u0018\b\u0000\u0010\u0093\u0001*\u0011\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0094\u0001\"\u0005\b\u0001\u0010\u0096\u0001\"\n\b\u0002\u0010\u0095\u0001*\u00030\u0097\u00012\u001d\u0010\u0098\u0001\u001a\u0018\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0096\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0099\u00012\u0007\u0010\u0081\u0001\u001a\u00020u2\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0096\u00010\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010\u009d\u0001\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0090\u0001\u0010 \u0001\u001a\u00020\u0007\"\u0018\b\u0000\u0010\u0093\u0001*\u0011\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0094\u0001\"\u0005\b\u0001\u0010\u0096\u0001\"\n\b\u0002\u0010\u0095\u0001*\u00030\u0097\u00012\u001d\u0010\u0098\u0001\u001a\u0018\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0096\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0099\u00012\u0007\u0010\u0081\u0001\u001a\u00020u2\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0096\u00010\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010\u009d\u0001\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J\t\u0010¢\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010£\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0096\u0002J!\u0010¤\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020uH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0007\u0010§\u0001\u001a\u00020\fJ\u001b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010ª\u0001\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\fH\u0016J*\u0010«\u0001\u001a\u00020u2\u0007\u0010ª\u0001\u001a\u00020\u00032\u0007\u0010¬\u0001\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J \u0010¯\u0001\u001a\u00020u2\u0007\u0010°\u0001\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b±\u0001\u0010~J \u0010²\u0001\u001a\u00020u2\u0007\u0010°\u0001\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b³\u0001\u0010~J \u0010´\u0001\u001a\u00020u2\u0007\u0010\u0081\u0001\u001a\u00020uH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\bµ\u0001\u0010~J\t\u0010¶\u0001\u001a\u00020\u0007H\u0016J\"\u0010·\u0001\u001a\u00020\u00072\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b+J\u001b\u0010¸\u0001\u001a\u00020\u00072\u0007\u0010¹\u0001\u001a\u00020F2\u0007\u0010º\u0001\u001a\u00020FH\u0014J\u0007\u0010»\u0001\u001a\u00020\u0007J\t\u0010¼\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010½\u0001\u001a\u00020\u0007J\u0012\u0010¾\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0016J5\u0010¿\u0001\u001a\u00020\u00012\b\u0010À\u0001\u001a\u00030Á\u00012\r\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0084\bø\u0001\u0000ø\u0001\u0003ø\u0001\u0001¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001JC\u0010Å\u0001\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020P2\u0006\u0010i\u001a\u00020\"2\u0019\u0010,\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b+H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001c\u0010È\u0001\u001a\u00020\u00072\u0007\u0010s\u001a\u00030©\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010É\u0001J+\u0010Ê\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\f2\t\b\u0002\u0010Ë\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bÌ\u0001J\u0007\u0010Í\u0001\u001a\u00020\fJ\u001f\u0010Î\u0001\u001a\u00020u2\u0006\u0010Q\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\bÏ\u0001\u0010~J\b\u0010Ð\u0001\u001a\u00030©\u0001J\t\u0010Ñ\u0001\u001a\u00020\u0007H\u0002J \u0010Ò\u0001\u001a\u00020u2\u0007\u0010Ó\u0001\u001a\u00020uH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\bÔ\u0001\u0010~J+\u0010Õ\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00062\u0013\u0010Â\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0084\bø\u0001\u0003J!\u0010Ö\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020uH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b×\u0001\u0010¦\u0001J\u0097\u0001\u0010Ø\u0001\u001a\u00020\u0007\"\u0018\b\u0000\u0010\u0093\u0001*\u0011\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0094\u0001\"\u0005\b\u0001\u0010\u0096\u0001\"\n\b\u0002\u0010\u0095\u0001*\u00030\u0097\u0001*\u0005\u0018\u0001H\u0093\u00012\u001d\u0010\u0098\u0001\u001a\u0018\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0096\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0099\u00012\u0007\u0010\u0081\u0001\u001a\u00020u2\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0096\u00010\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010\u009d\u0001\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J \u0001\u0010Û\u0001\u001a\u00020\u0007\"\u0018\b\u0000\u0010\u0093\u0001*\u0011\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0094\u0001\"\u0005\b\u0001\u0010\u0096\u0001\"\n\b\u0002\u0010\u0095\u0001*\u00030\u0097\u0001*\u0005\u0018\u0001H\u0093\u00012\u001d\u0010\u0098\u0001\u001a\u0018\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0096\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0099\u00012\u0007\u0010\u0081\u0001\u001a\u00020u2\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0096\u00010\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010\u009d\u0001\u001a\u00020\f2\u0007\u0010Ü\u0001\u001a\u00020\"H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J \u0001\u0010ß\u0001\u001a\u00020\u0007\"\u0018\b\u0000\u0010\u0093\u0001*\u0011\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0094\u0001\"\u0005\b\u0001\u0010\u0096\u0001\"\n\b\u0002\u0010\u0095\u0001*\u00030\u0097\u0001*\u0005\u0018\u0001H\u0093\u00012\u001d\u0010\u0098\u0001\u001a\u0018\u0012\u0005\u0012\u0003H\u0093\u0001\u0012\u0005\u0012\u0003H\u0096\u0001\u0012\u0005\u0012\u0003H\u0095\u00010\u0099\u00012\u0007\u0010\u0081\u0001\u001a\u00020u2\u000f\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0096\u00010\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\f2\u0007\u0010\u009d\u0001\u001a\u00020\f2\u0007\u0010Ü\u0001\u001a\u00020\"H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bà\u0001\u0010Þ\u0001R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\"\u0010'\u001a\u0004\u0018\u00010&2\b\u0010#\u001a\u0004\u0018\u00010&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)RD\u0010,\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b+2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b+@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R$\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e8F@@X\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020<X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010G\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u0010J\u001a\u0004\u0018\u00010K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0013\u0010N\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010IR)\u0010Q\u001a\u00020P2\u0006\u0010#\u001a\u00020P@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010S\u001a\u0004\bR\u0010BR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020E0U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020\u00108DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\\8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b]\u0010BR\u0014\u0010^\u001a\u00020_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0016\u0010b\u001a\u0004\u0018\u00010\u00008PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010d\"\u0004\bg\u0010hR$\u0010i\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010J\u001a\u0004\u0018\u00010K*\n\u0012\u0004\u0012\u00020o\u0018\u00010n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010p\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006ã\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_isAttached", "", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "entities", "Landroidx/compose/ui/node/EntityList;", "getEntities-CHwCgZE", "()[Landroidx/compose/ui/node/LayoutNodeEntity;", "[Landroidx/compose/ui/node/LayoutNodeEntity;", "hasMeasureResult", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isShallowPlacing", "setShallowPlacing", "(Z)V", "isValid", "lastLayerAlpha", "", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "value", "measureResult", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "()J", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", b9.h.L, "getPosition-nOcc-ac", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "zIndex", "getZIndex", "()F", "setZIndex", "(F)V", "Landroidx/compose/ui/node/SimpleEntity;", "Landroidx/compose/ui/layout/ParentDataModifier;", "(Landroidx/compose/ui/node/SimpleEntity;)Ljava/lang/Object;", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/LayoutNodeWrapper;J)J", "attach", "calculateAlignmentLine", "alignmentLine", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "detach", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "get", "hitTest", "T", "Landroidx/compose/ui/node/LayoutNodeEntity;", "M", "C", "Landroidx/compose/ui/Modifier;", "hitTestSource", "Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onInitialize", "onLayerBlockUpdated", "onMeasureResultChanged", "width", "height", "onMeasured", "onModifierChanged", "onPlaced", "performDraw", "performingMeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "updateLayerParameters", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/node/LayoutNodeEntity;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/LayoutNodeEntity;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LayoutNodeWrapper extends Placeable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private boolean _isAttached;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final LayoutNodeEntity<?, ?>[] entities;
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private boolean isShallowPlacing;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private LayoutNodeWrapper wrappedBy;
    private float zIndex;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<LayoutNodeWrapper, Unit> onCommitAffectingLayerParams = new Function1<LayoutNodeWrapper, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNodeWrapper layoutNodeWrapper) {
            invoke2(layoutNodeWrapper);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNodeWrapper wrapper) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            if (wrapper.isValid()) {
                wrapper.updateLayerParameters();
            }
        }
    };
    private static final Function1<LayoutNodeWrapper, Unit> onCommitAffectingLayer = new Function1<LayoutNodeWrapper, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutNodeWrapper layoutNodeWrapper) {
            invoke2(layoutNodeWrapper);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutNodeWrapper wrapper) {
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            OwnedLayer layer = wrapper.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier> PointerInputSource = new HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: entityType-EEbPh1w, reason: not valid java name */
        public int mo3283entityTypeEEbPh1w() {
            return EntityList.INSTANCE.m3233getPointerInputEntityTypeEEbPh1w();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public PointerInputFilter contentFrom(PointerInputEntity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            return entity.getModifier().getPointerInputFilter();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(PointerInputEntity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            return entity.getModifier().getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo3282childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<PointerInputFilter> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m3249hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };
    private static final HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier> SemanticsSource = new HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public SemanticsEntity contentFrom(SemanticsEntity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            return entity;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(SemanticsEntity entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            return false;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: entityType-EEbPh1w */
        public int mo3283entityTypeEEbPh1w() {
            return EntityList.INSTANCE.m3235getSemanticsEntityTypeEEbPh1w();
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration;
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(parentLayoutNode);
            boolean z = false;
            if (outerSemantics != null && (semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics.collapsedSemanticsConfiguration()) != null && semanticsConfigurationCollapsedSemanticsConfiguration.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        public void mo3282childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<SemanticsEntity> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m3250hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };

    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0004\b\u0001\u0010\u0004*\b\b\u0002\u0010\u0003*\u00020\u00052\u00020\u0006JC\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0018H&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\nH&ø\u0001\u0003\u0082\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;", "T", "Landroidx/compose/ui/node/LayoutNodeEntity;", "M", "C", "Landroidx/compose/ui/Modifier;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "contentFrom", "entity", "(Landroidx/compose/ui/node/LayoutNodeEntity;)Ljava/lang/Object;", "entityType", "Landroidx/compose/ui/node/EntityList$EntityType;", "entityType-EEbPh1w", "()I", "interceptOutOfBoundsChildEvents", "(Landroidx/compose/ui/node/LayoutNodeEntity;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HitTestSource<T extends LayoutNodeEntity<T, M>, C, M extends Modifier> {
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        void mo3282childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<C> hitTestResult, boolean isTouchEvent, boolean isInLayer);

        C contentFrom(T entity);

        /* JADX INFO: renamed from: entityType-EEbPh1w */
        int mo3283entityTypeEEbPh1w();

        boolean interceptOutOfBoundsChildEvents(T entity);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract MeasureScope getMeasureScope();

    /* JADX INFO: renamed from: getWrapped$ui_release */
    public LayoutNodeWrapper getWrapped() {
        return null;
    }

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getLayoutNode$ui_release, reason: from getter */
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public LayoutNodeWrapper(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.INSTANCE.m3971getZeronOccac();
        this.entities = EntityList.m3218constructorimpl$default(null, 1, null);
        this.invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$invalidateParentLayer$1
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
                LayoutNodeWrapper wrappedBy = this.this$0.getWrappedBy();
                if (wrappedBy != null) {
                    wrappedBy.invalidateLayer();
                }
            }
        };
    }

    /* JADX INFO: renamed from: getWrappedBy$ui_release, reason: from getter */
    public final LayoutNodeWrapper getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(LayoutNodeWrapper layoutNodeWrapper) {
        this.wrappedBy = layoutNodeWrapper;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo3126getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            return layoutNodeWrapper.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        if (!this._isAttached || this.layoutNode.isAttached()) {
            return this._isAttached;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final MeasureResult getMeasureResult() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public final void setMeasureResult$ui_release(MeasureResult value) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult measureResult = this._measureResult;
        if (value != measureResult) {
            this._measureResult = value;
            if (measureResult == null || value.getWidth() != measureResult.getWidth() || value.getHeight() != measureResult.getHeight()) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && value.getAlignmentLines().isEmpty()) || Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            LayoutNodeWrapper wrapped$ui_release = getWrapped();
            if (Intrinsics.areEqual(wrapped$ui_release != null ? wrapped$ui_release.layoutNode : null, this.layoutNode)) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    parent$ui_release2.onAlignmentsChanged$ui_release();
                }
                if (this.layoutNode.getAlignmentLines().getUsedDuringParentMeasurement()) {
                    LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
                    if (parent$ui_release3 != null) {
                        LayoutNode.requestRemeasure$ui_release$default(parent$ui_release3, false, 1, null);
                    }
                } else if (this.layoutNode.getAlignmentLines().getUsedDuringParentLayout() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
            } else {
                this.layoutNode.onAlignmentsChanged$ui_release();
            }
            this.layoutNode.getAlignmentLines().setDirty$ui_release(true);
            LinkedHashMap linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(value.getAlignmentLines());
        }
    }

    private final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (LayoutNodeWrapper wrapped$ui_release = this; wrapped$ui_release != null; wrapped$ui_release = wrapped$ui_release.getWrapped()) {
            MeasureResult measureResult = wrapped$ui_release._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    protected void onMeasureResultChanged(int width, int height) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo3294resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
            if (layoutNodeWrapper != null) {
                layoutNodeWrapper.invalidateLayer();
            }
        }
        Owner owner = this.layoutNode.getOwner();
        if (owner != null) {
            owner.onLayoutChange(this.layoutNode);
        }
        m3164setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        for (LayoutNodeEntity<?, ?> next = this.entities[EntityList.INSTANCE.m3230getDrawEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((DrawEntity) next).onMeasureResultChanged();
        }
    }

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return getParentData((SimpleEntity) EntityList.m3226head0OSVbXo(this.entities, EntityList.INSTANCE.m3232getParentDataEntityTypeEEbPh1w()));
    }

    private final Object getParentData(SimpleEntity<ParentDataModifier> simpleEntity) {
        if (simpleEntity == null) {
            LayoutNodeWrapper wrapped$ui_release = getWrapped();
            if (wrapped$ui_release != null) {
                return wrapped$ui_release.getParentData();
            }
            return null;
        }
        return simpleEntity.getModifier().modifyParentData(getMeasureScope(), getParentData((SimpleEntity) simpleEntity.getNext()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        return this.layoutNode.getOuterLayoutNodeWrapper$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        return this.wrappedBy;
    }

    /* JADX INFO: renamed from: isShallowPlacing, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing(boolean z) {
        this.isShallowPlacing = z;
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver();
    }

    /* JADX INFO: renamed from: getEntities-CHwCgZE, reason: not valid java name */
    public final LayoutNodeEntity<?, ?>[] m3274getEntitiesCHwCgZE() {
        return this.entities;
    }

    /* JADX INFO: renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m3279performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m3165setMeasurementConstraintsBRTryo0(constraints);
        Placeable placeableInvoke = block.invoke();
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo3294resizeozmzZPI(getMeasuredSize());
        }
        return placeableInvoke;
    }

    public final void onMeasured() {
        if (EntityList.m3224has0OSVbXo(this.entities, EntityList.INSTANCE.m3234getRemeasureEntityTypeEEbPh1w())) {
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    for (LayoutNodeEntity<?, ?> next = this.entities[EntityList.INSTANCE.m3234getRemeasureEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
                        ((OnRemeasuredModifier) ((SimpleEntity) next).getModifier()).mo251onRemeasuredozmzZPI(getMeasuredSize());
                    }
                    Unit unit = Unit.INSTANCE;
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                } catch (Throwable th) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                snapshotCreateNonObservableSnapshot.dispose();
                throw th2;
            }
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        int iM3962getYimpl;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (!getHasMeasureResult() || (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            iM3962getYimpl = IntOffset.m3961getXimpl(m3161getApparentToRealOffsetnOccac());
        } else {
            iM3962getYimpl = IntOffset.m3962getYimpl(m3161getApparentToRealOffsetnOccac());
        }
        return iCalculateAlignmentLine + iM3962getYimpl;
    }

    public void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo3125placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        onLayerBlockUpdated(layerBlock);
        if (!IntOffset.m3960equalsimpl0(this.position, position)) {
            this.position = position;
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3293movegyyYBs(position);
            } else {
                LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
                if (layoutNodeWrapper != null) {
                    layoutNodeWrapper.invalidateLayer();
                }
            }
            LayoutNodeWrapper wrapped$ui_release = getWrapped();
            if (!Intrinsics.areEqual(wrapped$ui_release != null ? wrapped$ui_release.layoutNode : null, this.layoutNode)) {
                this.layoutNode.onAlignmentsChanged$ui_release();
            } else {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.onAlignmentsChanged$ui_release();
                }
            }
            Owner owner = this.layoutNode.getOwner();
            if (owner != null) {
                owner.onLayoutChange(this.layoutNode);
            }
        }
        this.zIndex = zIndex;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float fM3961getXimpl = IntOffset.m3961getXimpl(this.position);
        float fM3962getYimpl = IntOffset.m3962getYimpl(this.position);
        canvas.translate(fM3961getXimpl, fM3962getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-fM3961getXimpl, -fM3962getYimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        DrawEntity drawEntity = (DrawEntity) EntityList.m3226head0OSVbXo(this.entities, EntityList.INSTANCE.m3230getDrawEntityTypeEEbPh1w());
        if (drawEntity == null) {
            performDraw(canvas);
        } else {
            drawEntity.draw(canvas);
        }
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        LayoutNodeWrapper wrapped$ui_release = getWrapped();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.draw(canvas);
        }
    }

    public final void onPlaced() {
        for (LayoutNodeEntity<?, ?> next = this.entities[EntityList.INSTANCE.m3231getOnPlacedEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((OnPlacedModifier) ((SimpleEntity) next).getModifier()).onPlaced(this);
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(final Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.layoutNode.getIsPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper.invoke.1
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
                    LayoutNodeWrapper.this.drawContainedDrawModifiers(canvas);
                }
            });
            this.lastLayerDrawingWasSkipped = false;
        } else {
            this.lastLayerDrawingWasSkipped = true;
        }
    }

    public final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        Owner owner;
        boolean z = (this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, this.layoutNode.getDensity()) && this.layerLayoutDirection == this.layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = layerBlock;
        this.layerDensity = this.layoutNode.getDensity();
        this.layerLayoutDirection = this.layoutNode.getLayoutDirection();
        if (isAttached() && layerBlock != null) {
            if (this.layer != null) {
                if (z) {
                    updateLayerParameters();
                    return;
                }
                return;
            }
            OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(this.layoutNode).createLayer(this, this.invalidateParentLayer);
            ownedLayerCreateLayer.mo3294resizeozmzZPI(getMeasuredSize());
            ownedLayerCreateLayer.mo3293movegyyYBs(this.position);
            this.layer = ownedLayerCreateLayer;
            updateLayerParameters();
            this.layoutNode.setInnerLayerWrapperIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            this.layoutNode.setInnerLayerWrapperIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = this.layoutNode.getOwner()) != null) {
                owner.onLayoutChange(this.layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(this.layoutNode.getDensity());
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper.updateLayerParameters.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    function1.invoke(LayoutNodeWrapper.graphicsLayerScope);
                }
            });
            ownedLayer.mo3295updateLayerPropertiesNHXXZp8(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.getTransformOrigin(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope.getRenderEffect(), reusableGraphicsLayerScope.getAmbientShadowColor(), reusableGraphicsLayerScope.getSpotShadowColor(), this.layoutNode.getLayoutDirection(), this.layoutNode.getDensity());
            this.isClipping = reusableGraphicsLayerScope.getClip();
        } else if (this.layerBlock != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner = this.layoutNode.getOwner();
        if (owner != null) {
            owner.onLayoutChange(this.layoutNode);
        }
    }

    /* JADX INFO: renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.layer != null;
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m3275getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo319toSizeXkaWNTQ(this.layoutNode.getViewConfiguration().mo3253getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3277hitTestYqVAtuI(HitTestSource<T, C, M> hitTestSource, long pointerPosition, HitTestResult<C> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        LayoutNodeEntity layoutNodeEntityM3226head0OSVbXo = EntityList.m3226head0OSVbXo(this.entities, hitTestSource.mo3283entityTypeEEbPh1w());
        if (!m3281withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float fM3272distanceInMinimumTouchTargettz77jQw = m3272distanceInMinimumTouchTargettz77jQw(pointerPosition, m3275getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM3272distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM3272distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM3272distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m3268hitNearJHbHoSQ(layoutNodeEntityM3226head0OSVbXo, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, fM3272distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (layoutNodeEntityM3226head0OSVbXo == null) {
            mo3244hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m3278isPointerInBoundsk4lQ0M(pointerPosition)) {
            m3267hit1hIXUjU(layoutNodeEntityM3226head0OSVbXo, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float fM3272distanceInMinimumTouchTargettz77jQw2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m3272distanceInMinimumTouchTargettz77jQw(pointerPosition, m3275getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM3272distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM3272distanceInMinimumTouchTargettz77jQw2)) {
            if (hitTestResult.isHitInMinimumTouchTargetBetter(fM3272distanceInMinimumTouchTargettz77jQw2, isInLayer)) {
                m3268hitNearJHbHoSQ(layoutNodeEntityM3226head0OSVbXo, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM3272distanceInMinimumTouchTargettz77jQw2);
                return;
            }
        }
        m3270speculativeHitJHbHoSQ(layoutNodeEntityM3226head0OSVbXo, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, fM3272distanceInMinimumTouchTargettz77jQw2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hit-1hIXUjU, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3267hit1hIXUjU(final T t, final HitTestSource<T, C, M> hitTestSource, final long j, final HitTestResult<C> hitTestResult, final boolean z, final boolean z2) {
        if (t == null) {
            mo3244hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(hitTestSource.contentFrom(t), z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$hit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/LayoutNodeWrapper;TT;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource<TT;TC;TM;>;JLandroidx/compose/ui/node/HitTestResult<TC;>;ZZ)V */
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
                    this.this$0.m3267hit1hIXUjU(t.getNext(), hitTestSource, j, hitTestResult, z, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3268hitNearJHbHoSQ(final T t, final HitTestSource<T, C, M> hitTestSource, final long j, final HitTestResult<C> hitTestResult, final boolean z, final boolean z2, final float f) {
        if (t == null) {
            mo3244hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(hitTestSource.contentFrom(t), f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$hitNear$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/LayoutNodeWrapper;TT;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource<TT;TC;TM;>;JLandroidx/compose/ui/node/HitTestResult<TC;>;ZZF)V */
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
                    this.this$0.m3268hitNearJHbHoSQ(t.getNext(), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void m3270speculativeHitJHbHoSQ(final T t, final HitTestSource<T, C, M> hitTestSource, final long j, final HitTestResult<C> hitTestResult, final boolean z, final boolean z2, final float f) {
        if (t == null) {
            mo3244hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(t)) {
            hitTestResult.speculativeHit(hitTestSource.contentFrom(t), f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeWrapper$speculativeHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/LayoutNodeWrapper;TT;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource<TT;TC;TM;>;JLandroidx/compose/ui/node/HitTestResult<TC;>;ZZF)V */
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
                    this.this$0.m3270speculativeHitJHbHoSQ(t.getNext(), hitTestSource, j, hitTestResult, z, z2, f);
                }
            });
        } else {
            m3270speculativeHitJHbHoSQ(t.getNext(), hitTestSource, j, hitTestResult, z, z2, f);
        }
    }

    /* JADX INFO: renamed from: hitTestChild-YqVAtuI */
    public <T extends LayoutNodeEntity<T, M>, C, M extends Modifier> void mo3244hitTestChildYqVAtuI(HitTestSource<T, C, M> hitTestSource, long pointerPosition, HitTestResult<C> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        LayoutNodeWrapper wrapped$ui_release = getWrapped();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.m3277hitTestYqVAtuI(hitTestSource, wrapped$ui_release.m3273fromParentPositionMKHz9U(pointerPosition), hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRoot = LayoutCoordinatesKt.findRoot(this);
        MutableRect rectCache = getRectCache();
        long jM3271calculateMinimumTouchTargetPaddingE7KxVPU = m3271calculateMinimumTouchTargetPaddingE7KxVPU(m3275getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1464getWidthimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m1461getHeightimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m1464getWidthimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m1461getHeightimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU));
        LayoutNodeWrapper layoutNodeWrapper = this;
        while (layoutNodeWrapper != layoutCoordinatesFindRoot) {
            layoutNodeWrapper.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            Intrinsics.checkNotNull(layoutNodeWrapper);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo3130windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates layoutCoordinatesFindRoot = LayoutCoordinatesKt.findRoot(this);
        return mo3127localPositionOfR5De75A(layoutCoordinatesFindRoot, Offset.m1399minusMKHz9U(LayoutNodeKt.requireOwner(this.layoutNode).mo3296calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRoot)));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo3129localToWindowMKHz9U(long relativeToLocal) {
        return LayoutNodeKt.requireOwner(this.layoutNode).mo3297calculatePositionInWindowMKHz9U(mo3128localToRootMKHz9U(relativeToLocal));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo3127localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) sourceCoordinates;
        LayoutNodeWrapper layoutNodeWrapperFindCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
        while (layoutNodeWrapper != layoutNodeWrapperFindCommonAncestor$ui_release) {
            relativeToSource = layoutNodeWrapper.m3280toParentPositionMKHz9U(relativeToSource);
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            Intrinsics.checkNotNull(layoutNodeWrapper);
        }
        return m3266ancestorToLocalR5De75A(layoutNodeWrapperFindCommonAncestor$ui_release, relativeToSource);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) sourceCoordinates;
        LayoutNodeWrapper layoutNodeWrapperFindCommonAncestor$ui_release = findCommonAncestor$ui_release(layoutNodeWrapper);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m4003getWidthimpl(sourceCoordinates.mo3126getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m4002getHeightimpl(sourceCoordinates.mo3126getSizeYbymL2g()));
        while (layoutNodeWrapper != layoutNodeWrapperFindCommonAncestor$ui_release) {
            rectInParent$ui_release$default(layoutNodeWrapper, rectCache, clipBounds, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
            Intrinsics.checkNotNull(layoutNodeWrapper);
        }
        ancestorToLocal(layoutNodeWrapperFindCommonAncestor$ui_release, rectCache, clipBounds);
        return MutableRectKt.toRect(rectCache);
    }

    /* JADX INFO: renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m3266ancestorToLocalR5De75A(LayoutNodeWrapper ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper == null || Intrinsics.areEqual(ancestor, layoutNodeWrapper)) {
            return m3273fromParentPositionMKHz9U(offset);
        }
        return m3273fromParentPositionMKHz9U(layoutNodeWrapper.m3266ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(LayoutNodeWrapper ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo3128localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        for (LayoutNodeWrapper layoutNodeWrapper = this; layoutNodeWrapper != null; layoutNodeWrapper = layoutNodeWrapper.wrappedBy) {
            relativeToLocal = layoutNodeWrapper.m3280toParentPositionMKHz9U(relativeToLocal);
        }
        return relativeToLocal;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float fM3961getXimpl = IntOffset.m3961getXimpl(getPosition());
        float fM3962getYimpl = IntOffset.m3962getYimpl(getPosition());
        canvas.translate(fM3961getXimpl, fM3962getYimpl);
        block.invoke(canvas);
        canvas.translate(-fM3961getXimpl, -fM3962getYimpl);
    }

    /* JADX INFO: renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3280toParentPositionMKHz9U(long position) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            position = ownedLayer.mo3292mapOffset8S9VItk(position, false);
        }
        return IntOffsetKt.m3975plusNvtHpc(position, this.position);
    }

    /* JADX INFO: renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3273fromParentPositionMKHz9U(long position) {
        long jM3973minusNvtHpc = IntOffsetKt.m3973minusNvtHpc(position, this.position);
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo3292mapOffset8S9VItk(jM3973minusNvtHpc, true) : jM3973minusNvtHpc;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m4003getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m4002getHeightimpl(getMeasuredSize()) - 0.5f), paint);
    }

    public void attach() {
        this._isAttached = true;
        onLayerBlockUpdated(this.layerBlock);
        for (LayoutNodeEntity<?, ?> next : this.entities) {
            for (; next != null; next = next.getNext()) {
                next.onAttach();
            }
        }
    }

    public void detach() {
        for (LayoutNodeEntity<?, ?> next : this.entities) {
            for (; next != null; next = next.getNext()) {
                next.onDetach();
            }
        }
        this._isAttached = false;
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(LayoutNodeWrapper layoutNodeWrapper, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        layoutNodeWrapper.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long jM3275getMinimumTouchTargetSizeNHjbRc = m3275getMinimumTouchTargetSizeNHjbRc();
                    float fM1464getWidthimpl = Size.m1464getWidthimpl(jM3275getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM1461getHeightimpl = Size.m1461getHeightimpl(jM3275getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    bounds.intersect(-fM1464getWidthimpl, -fM1461getHeightimpl, IntSize.m4003getWidthimpl(mo3126getSizeYbymL2g()) + fM1464getWidthimpl, IntSize.m4002getHeightimpl(mo3126getSizeYbymL2g()) + fM1461getHeightimpl);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m4003getWidthimpl(mo3126getSizeYbymL2g()), IntSize.m4002getHeightimpl(mo3126getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(bounds, false);
        }
        float fM3961getXimpl = IntOffset.m3961getXimpl(this.position);
        bounds.setLeft(bounds.getLeft() + fM3961getXimpl);
        bounds.setRight(bounds.getRight() + fM3961getXimpl);
        float fM3962getYimpl = IntOffset.m3962getYimpl(this.position);
        bounds.setTop(bounds.getTop() + fM3962getYimpl);
        bounds.setBottom(bounds.getBottom() + fM3962getYimpl);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        float fM3961getXimpl = IntOffset.m3961getXimpl(this.position);
        bounds.setLeft(bounds.getLeft() - fM3961getXimpl);
        bounds.setRight(bounds.getRight() - fM3961getXimpl);
        float fM3962getYimpl = IntOffset.m3962getYimpl(this.position);
        bounds.setTop(bounds.getTop() - fM3962getYimpl);
        bounds.setBottom(bounds.getBottom() - fM3962getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m4003getWidthimpl(mo3126getSizeYbymL2g()), IntSize.m4002getHeightimpl(mo3126getSizeYbymL2g()));
                bounds.isEmpty();
            }
        }
    }

    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3281withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m1412isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo3291isInLayerk4lQ0M(pointerPosition);
    }

    /* JADX INFO: renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3278isPointerInBoundsk4lQ0M(long pointerPosition) {
        float fM1395getXimpl = Offset.m1395getXimpl(pointerPosition);
        float fM1396getYimpl = Offset.m1396getYimpl(pointerPosition);
        return fM1395getXimpl >= 0.0f && fM1396getYimpl >= 0.0f && fM1395getXimpl < ((float) getMeasuredWidth()) && fM1396getYimpl < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        LayoutNodeWrapper layoutNodeWrapper = this.wrappedBy;
        if (layoutNodeWrapper != null) {
            layoutNodeWrapper.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(LayoutNodeWrapper layoutNodeWrapper, Rect rect, Continuation continuation) {
        Object objPropagateRelocationRequest;
        LayoutNodeWrapper layoutNodeWrapper2 = layoutNodeWrapper.wrappedBy;
        return (layoutNodeWrapper2 != null && (objPropagateRelocationRequest = layoutNodeWrapper2.propagateRelocationRequest(rect.m1432translatek4lQ0M(layoutNodeWrapper2.localBoundingBoxOf(layoutNodeWrapper, false).m1430getTopLeftF1C5BW0()), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objPropagateRelocationRequest : Unit.INSTANCE;
    }

    public void onModifierChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final LayoutNodeWrapper findCommonAncestor$ui_release(LayoutNodeWrapper other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode parent$ui_release = other.layoutNode;
        LayoutNode parent$ui_release2 = this.layoutNode;
        if (parent$ui_release == parent$ui_release2) {
            LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = parent$ui_release2.getOuterLayoutNodeWrapper$ui_release();
            LayoutNodeWrapper layoutNodeWrapper = this;
            while (layoutNodeWrapper != outerLayoutNodeWrapper$ui_release && layoutNodeWrapper != other) {
                layoutNodeWrapper = layoutNodeWrapper.wrappedBy;
                Intrinsics.checkNotNull(layoutNodeWrapper);
            }
            return layoutNodeWrapper == other ? other : this;
        }
        while (parent$ui_release.getDepth() > parent$ui_release2.getDepth()) {
            parent$ui_release = parent$ui_release.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
        }
        while (parent$ui_release2.getDepth() > parent$ui_release.getDepth()) {
            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release2);
        }
        while (parent$ui_release != parent$ui_release2) {
            parent$ui_release = parent$ui_release.getParent$ui_release();
            parent$ui_release2 = parent$ui_release2.getParent$ui_release();
            if (parent$ui_release == null || parent$ui_release2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (parent$ui_release2 == this.layoutNode) {
            return this;
        }
        return parent$ui_release == other.layoutNode ? other : parent$ui_release.getInnerLayoutNodeWrapper();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        PointerInputEntity pointerInputEntity = (PointerInputEntity) EntityList.m3226head0OSVbXo(this.entities, EntityList.INSTANCE.m3233getPointerInputEntityTypeEEbPh1w());
        if (pointerInputEntity != null && pointerInputEntity.shouldSharePointerInputWithSiblings()) {
            return true;
        }
        LayoutNodeWrapper wrapped$ui_release = getWrapped();
        return wrapped$ui_release != null && wrapped$ui_release.shouldSharePointerInputWithSiblings();
    }

    /* JADX INFO: renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m3269offsetFromEdgeMKHz9U(long pointerPosition) {
        float fM1395getXimpl = Offset.m1395getXimpl(pointerPosition);
        float fMax = Math.max(0.0f, fM1395getXimpl < 0.0f ? -fM1395getXimpl : fM1395getXimpl - getMeasuredWidth());
        float fM1396getYimpl = Offset.m1396getYimpl(pointerPosition);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM1396getYimpl < 0.0f ? -fM1396getYimpl : fM1396getYimpl - getMeasuredHeight()));
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m3271calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1464getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m1461getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight()) / 2.0f));
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m3272distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m1464getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m1461getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM3271calculateMinimumTouchTargetPaddingE7KxVPU = m3271calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float fM1464getWidthimpl = Size.m1464getWidthimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM1461getHeightimpl = Size.m1461getHeightimpl(jM3271calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM3269offsetFromEdgeMKHz9U = m3269offsetFromEdgeMKHz9U(pointerPosition);
        if ((fM1464getWidthimpl > 0.0f || fM1461getHeightimpl > 0.0f) && Offset.m1395getXimpl(jM3269offsetFromEdgeMKHz9U) <= fM1464getWidthimpl && Offset.m1396getYimpl(jM3269offsetFromEdgeMKHz9U) <= fM1461getHeightimpl) {
            return Offset.m1394getDistanceSquaredimpl(jM3269offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* JADX INFO: compiled from: LayoutNodeWrapper.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeWrapper$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;", "Landroidx/compose/ui/node/PointerInputEntity;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "getPointerInputSource", "()Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/semantics/SemanticsEntity;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "", "onCommitAffectingLayerParams", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HitTestSource<PointerInputEntity, PointerInputFilter, PointerInputModifier> getPointerInputSource() {
            return LayoutNodeWrapper.PointerInputSource;
        }

        public final HitTestSource<SemanticsEntity, SemanticsEntity, SemanticsModifier> getSemanticsSource() {
            return LayoutNodeWrapper.SemanticsSource;
        }
    }
}
