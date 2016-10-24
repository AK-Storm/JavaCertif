package com.ariche.learning.general;

public class MainProgram {
	private int x; 
	private static final int y;
	private final int z;
	static {
		y = 0;
	}
	public MainProgram(int x) {
		super();
		this.x = y; 
		this.z = 10 ;
	}

	public MainProgram(){
		// MainProgram
		this(5);
	}
	public static void main(String[] args) {
		
		// arguments != parameters
		// override != overload 
	
		/**
		 * 1- varargs
		 */
		// a- use mode : passing arguments 
		varargs("hello ","varargs"," !!");
		// b- use mode : passing an array 
		String[] arrayOfArgs = {"another ","exemple "," of varargs"," !!"};
		varargs(arrayOfArgs);
		
		
		/**
		 * 2- shadowing  
		 */
		MainProgram m = new MainProgram(12);
		shadowing(10);
		/**
		 * 3- covariant return type (a revoir)
		 */
		
		/**
		 * 4- explicit constructor invocation
		 * 
		 */
		MainProgram n = new MainProgram();
		System.out.println(n);
		
		/**
		 * 5- Access modifiers
		 *  There are two levels :
		 *  * top level : (classes)  public, or package-private (it can be used in the same package)
		 *  * member level : public ,protected ,private  or package-private
		 *  
		 *  
		 *  	- package-private : can be accessed by other classes in the same package
		 *  	- protected : can be accessed by other classes in the same package and subclasses 
		 *  		 		  even they are not in the same package
		 *  
		 */
		
		/**
		 * 6- Class members (! instance members) 
		 *    refering class members :  we can refer to them by instance_obj.x but its discouraged 
		 *     				   because it does not make it clear that they are class variables.
		 *     
		 *     Not all combinations of instance and class variables and methods are allowed:

				- Instance methods can access instance variables and instance methods directly.
				- Instance methods can access class variables and class methods directly.
				- Class methods can access class variables and class methods directly.
				- Class methods cannot access instance variables or instance methods directly—they must use an object reference. Also,
				  class methods cannot use the this keyword as there is no instance for this to refer to.
				  
				* If a primitive type or a string is defined as a constant and the value is known at compile time,
				  the compiler replaces the constant name everywhere in the code with its value. This is called a compile-time constant.
				 change ==>   recompile
				 
		 *   
		 */
		
		/**
		 * 7 initializing blocks (to factories the deplicated code)
		 *     because there content gone be copied to all the constructors at the beginning
		 *     
		 * 		a- Static Initialization Blocks 
		 * 		private static int  x ;
		 * 		static{
		 * 
		 * 		// are used to init static variables 
		 * 		// and static final varialbles (the only place where to initilize)
		 * 
		 * 			x = 1
		 * 		}
		 *      equivalent to call a static method 
		 *      private static int x = initilizeMethod();
		 *      
		 *      public static int initilizeMethod(){
		 *	       // do st
		 *	       return 1;
		 *      }
		 *      
		 *      b- Simple initialization Blocks
		 *      // are used to init the final variables (here , in the contrcutros ,or inline)
		 *      private int final x ; 
		 *      {
		 *         x = 10;
		 *        
		 *      }
		 *      private int  x = initilizeMethod();
		 *      equivalent to call a final method 
		 *      public final int initilizeMethod(){
		 *      	return 2;
		 *      }
		 *      
		 */
	} 
	
	public static void varargs(String ... args){
		for (String arg : args) {
			System.out.print(arg);
		}
		System.out.println();
	}
	
	public static void shadowing(int x){
		// the x parameter will shadow the class field
		System.out.println(x);
	}

	@Override
	public String toString() {
		return "MainProgram [x=" + x + "]";
	}
	
}
