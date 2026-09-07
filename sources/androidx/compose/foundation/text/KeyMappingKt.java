package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: KeyMapping.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001f\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000ø\u0001\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> shortcutModifier) {
        Intrinsics.checkNotNullParameter(shortcutModifier, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo699mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (shortcutModifier.invoke(KeyEvent.m2848boximpl(event)).booleanValue() && KeyEvent_androidKt.m2871isShiftPressedZmokQxo(event)) {
                    if (Key.m2270equalsimpl0(KeyEvent_androidKt.m2865getKeyZmokQxo(event), MappedKeys.INSTANCE.m732getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (shortcutModifier.invoke(KeyEvent.m2848boximpl(event)).booleanValue()) {
                    long jM2865getKeyZmokQxo = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m714getCEK5gGoQ()) ? true : Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m723getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m730getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m731getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m711getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m732getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m2869isCtrlPressedZmokQxo(event)) {
                    return null;
                }
                if (KeyEvent_androidKt.m2871isShiftPressedZmokQxo(event)) {
                    long jM2865getKeyZmokQxo2 = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m718getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m719getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m720getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m717getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m727getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m726getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m725getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m724getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m723getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM2865getKeyZmokQxo3 = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m718getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m719getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m720getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m717getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m727getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m726getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m725getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m724getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m721getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m713getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m716getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m728getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m715getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m729getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m2869isCtrlPressedZmokQxo(((KeyEvent) obj).m2854unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo699mapZmokQxo(android.view.KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m2871isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m2869isCtrlPressedZmokQxo(event)) {
                    long jM2865getKeyZmokQxo = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m718getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m719getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m720getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo, MappedKeys.INSTANCE.m717getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m2869isCtrlPressedZmokQxo(event)) {
                    long jM2865getKeyZmokQxo2 = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m718getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m719getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m720getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m717getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m722getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m716getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m713getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo2, MappedKeys.INSTANCE.m712getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m2871isShiftPressedZmokQxo(event)) {
                    long jM2865getKeyZmokQxo3 = KeyEvent_androidKt.m2865getKeyZmokQxo(event);
                    if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m725getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_HOME;
                    } else if (Key.m2270equalsimpl0(jM2865getKeyZmokQxo3, MappedKeys.INSTANCE.m724getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo699mapZmokQxo(event) : keyCommand;
            }
        };
    }
}
