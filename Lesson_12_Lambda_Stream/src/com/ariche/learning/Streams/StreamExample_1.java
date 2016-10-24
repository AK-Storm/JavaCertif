package com.ariche.learning.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;




/***
 *      Streams 1 : 
 *      
 *      - There are two kinds of streams'operations intermediate and terminal, intermediate return a stream and terminal return void or a non-stream result. 
 *      
 *      - A stream operation have to be :
 *      		- non-interfering : not change the original object
 *      		-  stateless :  no lambda expression depends on any mutable variables or states from the outer scope.
 *      
 *      - Stream are two kinds : sequential and parallel.
 *      
 *      - To create a stream we can use the stream method on a collection object that return a stream object 
 *        or we can use "of" static method Stream.of(elts).
 *        
 *      - We can create streams with object and with primitives,for example a integer primitive stream will use IntFunciton instead 
 *        of Function,IntPredicate instead of Predicate ... ,also they could use with aggregation operations like sum(),average().
 *        
 *      - The processing order follow this rules: 
 *      	a - laziness : intermediate operations are only executed if there is a terminal operation
 *      	b - order : there are two types of operations 
 *      				1 - statefull  : who need to be executed and after that we could give control to next operation(sort)
 *      				2 - executed for one element and give control to next to be executed for the same element (filter,map)
 *      				NB the second approach is powerful because it vertical see example below.
 *      
 *      - We can only chain stream operations,but it's cannot be reused. As soon as you call any terminal operation the stream is closed
 *        or we will get the exception java.lang.IllegalStateException, to reuse the stream we could use supplier.
 *      
 *      - Advanced operations 
 *      
 *      		A - Collectors : Collect accepts a Collector which consists of four different operations: a supplier, an accumulator, a combiner and a finisher.
 *      						 we could make with very useful operations, we could use built-in collectors in Collectors Class.
 *      
 *      		B - FlatMap : transforms each element of the stream into a stream of other objects.
 *      
 *      		C - Reducer : is used to make an operation on a list to get only one result.
 *      
 *      
 *      
 */
public class StreamExample_1 {

	public static void main(String[] args) {
		
		// 1- Stream creation
		// a) stream method
		System.out.println("1- Stream creation");
		Arrays.asList("elt1", "elt2") // returns a List
				.stream()
				.forEach(System.out::println);

		// b) static of method
		Stream.of("a", "b", "c")
			.forEach(System.out::println);

		// c) create a range stream eq to a for
		IntStream.range(1, 4)
			.forEach(System.out::println);
		// 2- primitive streams

		System.out.println("2- primitive streams");
		Arrays.stream(new int[] { 1, 2, 3 })
			.map(n -> 2 * n + 1)
			.average()
			.ifPresent(System.out::println);
		
		// convert a primitive stream to Object 
		// to do that we use mapToInt,mapToDouble,mapTo<Type>
		Stream.of("a1", "a2", "a3")
	    	.map(s -> s.substring(1))
	    	.mapToInt(Integer::parseInt)
	    	.max()
	    	.ifPresent(System.out::println);  // 3
		
	   // we can do the reverse object stream to primitive
	   // to do that we use mapToObj
		IntStream.range(1, 4)
	    	.mapToObj(i -> "a" + i)
	    	.forEach(System.out::println);
		
		// 3- Processing order
		System.out.println("3- Processing order");
		
		// laziness 
		Stream.of("d2", "a2", "b1", "b3", "c")
		.filter(s -> {
			System.out.println("filter: " + s);
			return true;
		});
		// vertical order 
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		// statefull operations 
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		// NB we could change the order to improve performance and get less operations done
		
		// 4 - Reusing Streams
		
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));

			stream.anyMatch(s -> true);    // ok
//			stream.noneMatch(s -> true);   // exception
		
		Supplier<Stream<String>> streamSupplier =
			    () -> Stream.of("d2", "a2", "b1", "b3", "c")
			            .filter(s -> s.startsWith("a"));

			streamSupplier.get().anyMatch(s -> true);   // ok
			streamSupplier.get().noneMatch(s -> true);  // ok
		
		// 5 Advanced Operations - Collectors
			
	   List<Person> persons = Arrays.asList(
				        				new Person("Max", 18),
				        				new Person("Peter", 23),
				        				new Person("Pamela", 23),
				        				new Person("David", 12));
			
		// built in collectors 
			
		// toList ,toSet ...
			
		List<Person> filtered = persons.stream()
										.filter(p -> p.name.startsWith("P"))
										.collect(Collectors.toList());

		System.out.println(filtered); 
		
		// group by
		Map<Integer, List<Person>> personsByAge = persons
						.stream()
						.collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		
		// statistics averaging
		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
		System.out.println(averageAge);
		
		// statistics 
		IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSummary);
		
		// joining(<delimiter>,<prefix>,<suffix>)
		String phrase = persons
			    .stream()
			    .filter(p -> p.age >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
	    System.out.println(phrase);
			
	   // toMap : create a map from object list
	    
		Map<Integer, String> map = persons
										.stream()
										.collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + ";" + name2));
		System.out.println(map);
		
		// TODO collectors creation
		
		// 6 Advanced Operations - FlatMap
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
			.range(1, 4)
			.forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos
		   .forEach(f -> IntStream.range(1, 4)
		   .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
		
		foos
		  .stream()
		  .flatMap(f -> f.bars.stream())
		  .forEach(b -> System.out.println(b.name));
		// we can use faltMap and Optional to avoid checking for null inner classes
		// to do that 
		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
		    System.out.println(outer.nested.inner.foo);
		}
		// 
		Optional.of(new Outer())
			.flatMap(o -> Optional.ofNullable(o.nested))
			.flatMap(n -> Optional.ofNullable(n.inner))
			.flatMap(i -> Optional.ofNullable(i.foo))
			.ifPresent(System.out::println);
		
		// 6 Advanced Operations - Reduce
		
		// reduce(<init>,<accumulator>,<combiner>)
		// the combiner is used to combine the results in each thread parallel Stream
		
		persons
	    .stream()
	    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    .ifPresent(System.out::println);    // Pamela
		
		Person result =
			    persons
			        .stream()
			        .reduce(new Person("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

			System.out.format("name=%s; age=%s\n", result.name, result.age);
			// name=MaxPeterPamelaDavid; age=76
			
		// 7 Parallel Stream 
			
		//	to see how many thread is created by ForkJoinPool to make parallel treatment 
			
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());
		
		// to create a parallel stream from a list we use parallelStream Method
		
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
			.parallelStream()
			.filter(s -> {
						System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
						return true;
			})
			.map(s -> {
						System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
						return s.toUpperCase();
			})
			.forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	
		// the sort method is not executed in parallel --> it's stop all parallel operations before starting
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .sorted((s1, s2) -> {
	        System.out.format("sort: %s <> %s [%s]\n",
	            s1, s2, Thread.currentThread().getName());
	        return s1.compareTo(s2);
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));
		
		// example using reduce with combiner and parallel stream
		// here the combiner is used to make addition between the result found on each thread 
		// to get a final sum result of all persons in the list below.
		 Arrays.asList(
			    new Person("Max", 18),
			    new Person("Peter", 23),
			    new Person("Pamela", 23),
			    new Person("David", 12)) 
			    .parallelStream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("accumulator: sum=%s; person=%s [%s]\n",
			                sum, p, Thread.currentThread().getName());
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
			                sum1, sum2, Thread.currentThread().getName());
			            return sum1 + sum2;
			        }); 
		
	}
}
