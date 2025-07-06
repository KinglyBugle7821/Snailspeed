package net.numericalk.snailspeed.utils.records;

import net.minecraft.network.codec.PacketCodec;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface SnailPacketCodec extends PacketCodec {
    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> PacketCodec<B, C> tuple(
            final PacketCodec<? super B, T1> codec1, final Function<C, T1> from1,
            final PacketCodec<? super B, T2> codec2, final Function<C, T2> from2,
            final PacketCodec<? super B, T3> codec3, final Function<C, T3> from3,
            final PacketCodec<? super B, T4> codec4, final Function<C, T4> from4,
            final PacketCodec<? super B, T5> codec5, final Function<C, T5> from5,
            final PacketCodec<? super B, T6> codec6, final Function<C, T6> from6,
            final PacketCodec<? super B, T7> codec7, final Function<C, T7> from7,
            final PacketCodec<? super B, T8> codec8, final Function<C, T8> from8,
            final PacketCodec<? super B, T9> codec9, final Function<C, T9> from9,
            final PacketCodec<? super B, T10> codec10, final Function<C, T10> from10,
            final PacketCodec<? super B, T11> codec11, final Function<C, T11> from11,
            final PacketCodec<? super B, T12> codec12, final Function<C, T12> from12,
            final PacketCodec<? super B, T13> codec13, final Function<C, T13> from13,
            final PacketCodec<? super B, T14> codec14, final Function<C, T14> from14,
            final PacketCodec<? super B, T15> codec15, final Function<C, T15> from15,
            final Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, C> to
    ) {
        return new PacketCodec<B, C>() {
            public C decode(B object) {
                T1 t1 = codec1.decode(object);
                T2 t2 = codec2.decode(object);
                T3 t3 = codec3.decode(object);
                T4 t4 = codec4.decode(object);
                T5 t5 = codec5.decode(object);
                T6 t6 = codec6.decode(object);
                T7 t7 = codec7.decode(object);
                T8 t8 = codec8.decode(object);
                T9 t9 = codec9.decode(object);
                T10 t10 = codec10.decode(object);
                T11 t11 = codec11.decode(object);
                T12 t12 = codec12.decode(object);
                T13 t13 = codec13.decode(object);
                T14 t14 = codec14.decode(object);
                T15 t15 = codec15.decode(object);
                return to.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15);
            }

            public void encode(B object, C value) {
                codec1.encode(object, from1.apply(value));
                codec2.encode(object, from2.apply(value));
                codec3.encode(object, from3.apply(value));
                codec4.encode(object, from4.apply(value));
                codec5.encode(object, from5.apply(value));
                codec6.encode(object, from6.apply(value));
                codec7.encode(object, from7.apply(value));
                codec8.encode(object, from8.apply(value));
                codec9.encode(object, from9.apply(value));
                codec10.encode(object, from10.apply(value));
                codec11.encode(object, from11.apply(value));
                codec12.encode(object, from12.apply(value));
                codec13.encode(object, from13.apply(value));
                codec14.encode(object, from14.apply(value));
                codec15.encode(object, from15.apply(value));
            }
        };
    }
    static <B, C, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> PacketCodec<B, C> tuple(
            final PacketCodec<? super B, T1> codec1, final Function<C, T1> from1,
            final PacketCodec<? super B, T2> codec2, final Function<C, T2> from2,
            final PacketCodec<? super B, T3> codec3, final Function<C, T3> from3,
            final PacketCodec<? super B, T4> codec4, final Function<C, T4> from4,
            final PacketCodec<? super B, T5> codec5, final Function<C, T5> from5,
            final PacketCodec<? super B, T6> codec6, final Function<C, T6> from6,
            final PacketCodec<? super B, T7> codec7, final Function<C, T7> from7,
            final PacketCodec<? super B, T8> codec8, final Function<C, T8> from8,
            final PacketCodec<? super B, T9> codec9, final Function<C, T9> from9,
            final PacketCodec<? super B, T10> codec10, final Function<C, T10> from10,
            final PacketCodec<? super B, T11> codec11, final Function<C, T11> from11,
            final Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, C> to
    ) {
        return new PacketCodec<B, C>() {
            public C decode(B object) {
                T1 t1 = codec1.decode(object);
                T2 t2 = codec2.decode(object);
                T3 t3 = codec3.decode(object);
                T4 t4 = codec4.decode(object);
                T5 t5 = codec5.decode(object);
                T6 t6 = codec6.decode(object);
                T7 t7 = codec7.decode(object);
                T8 t8 = codec8.decode(object);
                T9 t9 = codec9.decode(object);
                T10 t10 = codec10.decode(object);
                T11 t11 = codec11.decode(object);
                return to.apply(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11);
            }

            public void encode(B object, C value) {
                codec1.encode(object, from1.apply(value));
                codec2.encode(object, from2.apply(value));
                codec3.encode(object, from3.apply(value));
                codec4.encode(object, from4.apply(value));
                codec5.encode(object, from5.apply(value));
                codec6.encode(object, from6.apply(value));
                codec7.encode(object, from7.apply(value));
                codec8.encode(object, from8.apply(value));
                codec9.encode(object, from9.apply(value));
                codec10.encode(object, from10.apply(value));
                codec11.encode(object, from11.apply(value));
            }
        };
    }

    @FunctionalInterface
    public interface Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11);
    }

    @FunctionalInterface
    public interface Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> {
        R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10,
                T11 t11, T12 t12, T13 t13, T14 t14, T15 t15);
    }
}

