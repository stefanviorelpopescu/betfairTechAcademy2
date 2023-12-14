package org.example.generics.pecs;

import java.util.Comparator;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        class PhysicalObject {
            double weight;
        }

        class Car extends PhysicalObject {}

        class RealNumber {
            final double value;

            public RealNumber(double value) {
                this.value = value;
            }

            public double getValue() {
                return value;
            }
        }

        class PositiveRealNumber extends RealNumber {

            public PositiveRealNumber(double value) {
                super(value);
                assert(value > 0);
            }
        }

        Comparator<RealNumber> realComparator = Comparator.comparingDouble(RealNumber::getValue);

        Function<PhysicalObject, PositiveRealNumber> weight = p -> new PositiveRealNumber(p.weight);

        Function<PhysicalObject, RealNumber> surrealWeight = p -> new RealNumber(p.weight);

        Function<Car, PositiveRealNumber> carWeight = p -> new PositiveRealNumber(p.weight);

// Example 1
//         badCompare1(weight, realComparator); // doesn't compile
        //
        // type error:
        // required: Function<A,B>,Comparator<B>
        // found: Function<PhysicalObject,PositiveReal>,Comparator<Real>

        // Example 2.1
//         Comparator<Car> c2 = badCompare2(weight, realComparator); // doesn't compile
        //
        // type error:
        // required: Function<? super A,B>,Comparator<B>
        // found: Function<PhysicalObject,PositiveReal>,Comparator<Real>

        // Example 2.2
        // This compiles, but for this to work, we had to loosen the output
        // type of `weight` to a non-necessarily-positive real number
        Comparator<Car> c2_2 = badCompare2(surrealWeight, realComparator);

        // Example 3.1
        // This doesn't compile, because `Car` is not *exactly* a `PhysicalObject`:
        // Comparator<Car> c3_1 = badCompare3(weight, realComparator);
        //
        // incompatible types: inferred type does not conform to equality constraint(s)
        // inferred: Car
        // equality constraints(s): Car,PhysicalObject

        // Example 3.2
        // This works, but with a bad code-duplicated `carWeight` instead of `weight`
        Comparator<Car> c3_2 = badCompare3(carWeight, realComparator);


        Comparator<Car> goodComparator = goodCompare(weight, realComparator);

    }

    public static <A, B> Comparator<A> goodCompare(Function<? super A, ? extends B> f, Comparator<B> cb) {
        return (a1, a2) -> cb.compare(f.apply(a1), f.apply(a2));
    }

    public static <A, B> Comparator<A> badCompare1(Function<A, B> f, Comparator<B> cb) {
        return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
    }

    public static <A, B> Comparator<A> badCompare2(Function<? super A, B> f, Comparator<B> cb) {
        return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
    }

    public static <A, B> Comparator<A> badCompare3(Function<A, ? extends B> f, Comparator<B> cb) {
        return (A a1, A a2) -> cb.compare(f.apply(a1), f.apply(a2));
    }

}
