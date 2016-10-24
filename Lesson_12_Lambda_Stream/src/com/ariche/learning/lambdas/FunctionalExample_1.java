package com.ariche.learning.lambdas;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 			java.util.function : 
 * 			1- Consumer<T> : void accept(T t), it's used to implement an action,and has a default function andThen that is used for chain actions.
 *  		2- Function<T,R> :  R apply(T t), it's used to implement a transformation and has three default functions,andThen,compose,identity
 * 			3- Predicate<T> :  test(T t), it's used to test and has or,and,isEqual,negate default functions
 * 			4- Supplier<T> : T get(),it's used as an object factory 
 * 
 * 
 * 
 * 
 */
public class FunctionalExample_1 {

	public static void main(String[] args) {
		
		// Consumer
		Consumer<String> a = (t) -> {
			System.out.println("a");
			System.out.println(t);
		};
		Consumer<String> b = (t) -> {
			System.out.println("b");
			System.out.println(t);
		};
		Consumer<String> c = (t) -> {
			System.out.println("c");
			System.out.println(t);
		};
		a.andThen(b).andThen(c).accept("bonjour ");
		// Function
		
		Function<Double,Double>  doubler = (i) ->{
			System.out.println("doubler i "+ i);
			return  i*2; 
		};
		Function<Double,Double> divider = (i) ->{
			System.out.println("divider i "+i);
			return i/3; 
		};
		Function<Double,Double> id = Function.identity();
		System.out.println(doubler.andThen(divider).apply(25.0));
		System.out.println(doubler.compose(divider).apply(25.0));  
		System.out.println(id.apply(6.0));
		
		
		Predicate<String> possedeTailleTrois = s -> s.length() == 3;
		Predicate<String> contientX = s -> s.contains("X");
		Predicate<String> estNonNull = Objects::nonNull;
		Predicate<String> contientXOuTaille3 = contientX.or(possedeTailleTrois);
		Predicate<String> estSMS = Predicate.isEqual("SMS");

		System.out.println("1 " + contientX.negate().test("WXYZ"));
		System.out.println("2 " + contientX.or(possedeTailleTrois).test("WWW"));
		System.out.println("2 " + contientX.or(possedeTailleTrois).test("WX"));
		System.out.println("3 " + contientX.and(possedeTailleTrois).test("WXY"));
		System.out.println("3 " + contientX.and(possedeTailleTrois).test("WWW"));
		System.out.println("4 " + estNonNull.test(null));
		System.out.println("5 " + estNonNull.and(contientX).and(possedeTailleTrois).test("WWW"));
		System.out.println("5 " + estNonNull.and(contientX).and(possedeTailleTrois).test("XX"));
		System.out.println("5 " + estNonNull.and(contientX).and(possedeTailleTrois).test(null));
		System.out.println("6 " + estNonNull.and(contientXOuTaille3).test("WWW"));
		System.out.println("6 " + estNonNull.and(contientXOuTaille3).test("XX"));
		System.out.println("6 " + estNonNull.and(contientXOuTaille3).test(null));
		System.out.println("7 " + estNonNull.and(contientX.or(possedeTailleTrois)).test("WWW"));
		System.out.println("7 " + estNonNull.and(contientX.or(possedeTailleTrois)).test("XX"));
		System.out.println("7 " + estNonNull.and(contientX.or(possedeTailleTrois)).test(null));
		System.out.println("8 " + estSMS.test("SMS"));
		System.out.println("8 " + estSMS.test("ABC"));
		System.out.println("8 " + estSMS.test(null));
		
		
		Supplier<Personne> message = () ->{
			return new Personne();
		};
	 
		System.out.println(message.get());
	}
}
