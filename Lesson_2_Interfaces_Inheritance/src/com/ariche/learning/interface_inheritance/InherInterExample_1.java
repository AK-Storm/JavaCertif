package com.ariche.learning.interface_inheritance;

/**
 * 	Interfaces-inheritance
 *  1- to solve conflict in multi implementation of methods the is two principals 
 *  	a - Instance methods are preferred over interface default methods.(see Example 1)
 *  	b- Methods that are already overridden by other candidates are ignored. (see Example 2)
 *  2- Inherited instance methods from classes can override abstract interface methods. Consider the following interfaces and classes
 *  (see Example 3)
 */

// Example 1
class Horse {
	public String identifyMyself() {
		return "I am a horse.";
	}
}

interface Flyer {
	default public String identifyMyself() {
		return "I am able to fly.";
	}
}

interface Mythical {
	default public String identifyMyself() {
		return "I am a mythical creature.";
	}
}

class FirstRuleExample extends Horse implements Flyer, Mythical {
	public static void demo(){
		FirstRuleExample fse = new FirstRuleExample();
		System.out.println(fse.identifyMyself());
	}
}

// Example 2 

interface Animal {
	default public String identifyMyself() {
		return "I am an animal.";
	}
}

interface EggLayer extends Animal {
	default public String identifyMyself() {
		return "I am able to lay eggs.";
	}
}

interface FireBreather extends Animal {
}

class SecondRuleExample implements EggLayer, FireBreather {
	public static void demo() {
		SecondRuleExample sre = new SecondRuleExample();
		System.out.println(sre.identifyMyself());
	}
}

// Example 3
interface Mammal {
    String identifyMyself();
}
class Crocodile {
    public String identifyMyself() {
        return "I am a Crocodile.";
    }
}
class ThirdRuleExample  extends Crocodile  implements Mammal{
	public static void demo() {
		ThirdRuleExample tre = new ThirdRuleExample();
		System.out.println(tre.identifyMyself());
	}
}


public class InherInterExample_1 {
	
		public static void main(String[] args) {
			// Example 1 
			FirstRuleExample.demo();
			// Example 2
			SecondRuleExample.demo();
			// Example 3
			ThirdRuleExample.demo();
		}
	
	
}
