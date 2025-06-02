package java8.streamProcessing.custom;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// joins strings with a delimiter, T A R
@AllArgsConstructor
public class CustomStringJoiner implements Collector<String, StringBuilder, String>
{
    private final String delimiter;
    private final String prefix;
    private final String suffix;

    // Supplier - creates the accumulation container
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    // Accumulator - adds element to container
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, str) -> {
            if (sb.length() > 0) {
                sb.append(delimiter);
            }
            sb.append(str);
        };
    }

    // Combiner - merges two containers (for parallel streams)
    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb1, sb2) -> {
            if (sb1.length() > 0 && sb2.length() > 0) {
                sb1.append(delimiter);
            }
            return sb1.append(sb2);
        };
    }

    // Finisher - transforms container to final result
    @Override
    public Function<StringBuilder, String> finisher() {
        return sb -> prefix + sb.toString() + suffix;
    }

    // Characteristics - optimization hints
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet(); // No special characteristics
    }

    // ==============================

    // Convenience factory method
    public static CustomStringJoiner joining(String delimiter, String prefix, String suffix) {
        return new CustomStringJoiner(delimiter, prefix, suffix);
    }
}
