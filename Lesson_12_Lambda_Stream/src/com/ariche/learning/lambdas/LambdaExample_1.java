package com.ariche.learning.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 
 * 
 * 			Lambda : une expression lamba est constitue de param -> corps de fonctions 
 * 			
 * 			1- régles d'ecriture (parametres) :
 * 				 
 * 				 a - Le type des paramètres peuvent être explicitement déclaré ou être inféré par le compilateur,on peut pas mixer.
 *			     b - Les parenthèses sont  obligatoires, si on un seul paramétre sans type explicite alors on peut l'omettre,seulement dans ce cas.
 *				 c - Il est possible d'utiliser le modificateur final sur les paramètres ,ou les annoter si leur type est précisé explicitement
 *. 		
 *			2- régles d'écriture (corps de fonctions) :
 *
 *  			a - Il peut n'avoir aucune, une seule ou plusieurs instructions.
 *				b - Lorsqu'il ne contient qu'une seule instruction, les accolades ne sont pas obligatoires et la valeur de retour est celle de l'instruction si elle en possède une.
 *				c - Lorsqu'il y a plusieurs instructions, elles doivent obligatoirement être entourées d'accolades. 
 *			
 *			3-  La portée des variables :
 *			    
 *   			a - Dans l'expression lamba on a l'access seulement au variable de contexte englobant déclarer final ou effectivement final.
 *              b - This fait référence à l'instance courante dans le bloc de code englobant et dans l'expression lambda.
 *              c - super fait référence à l'instance de la classe mère de this.
 *              
 *         4-  Une même expression lambda peut donc être assignée à plusieurs interfaces fonctionnelles tant qu'elle respecte leur contrat.
 *		   
 *		   5-  on peut référencier une methode ou un constructeur à la place d'une expression lambda.
 *			
 *		   6- Il n'est pas possible d'assigner une expression lambda à un objet de type Object.
 *		
 *		   7-
 *
 *
 *
 */

@FunctionalInterface
interface OperationEntiere {
  long effectuer(int a, int b);
}
@FunctionalInterface
interface MonFormateur {
  String formater(String format, Object... arguments);
}
@FunctionalInterface
interface PersonneSupplier {
  Personne creerInstance(String nom, String prenom);
}
class Personne{
	private String nom;
	private String prenom;
	
	public Personne() {
		super();
		this.nom = "default-Nom";
		this.prenom = "default-Prenom";
	}
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	} 
	
}

class ComparaisonPersonne {

	public int comparerParNom(Personne p1, Personne p2) {
		return p1.getNom().compareTo(p2.getNom());
	}

	public int comparerParPrenom(Personne p1, Personne p2) {
		return p1.getPrenom().compareTo(p2.getPrenom());
	}
}
public class LambdaExample_1 {

	 

	public static void main(String[] args) {
		LambdaExample_1 instance = new LambdaExample_1();
		System.out.println(instance.toString());
		instance.executer();
		
		 
	    OperationEntiere addition = (a, b) -> a + b;
	    OperationEntiere soustraction = (a, b) -> a - b;

	    System.out.println(instance.calculer(10, 5, addition));
	    System.out.println(instance.calculer(10, 5, soustraction));
	    
	    // reference d'une méthode
	    List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
	    // utilisation de lambda
	    afficher(fruits, (fmt, arg) -> String.format(fmt, arg));
	    System.out.println("ref static ");
	    // reference à une méthode statique 
	    afficher(fruits, String::format);
	    // reference à une méthode d'instance
	    System.out.println("ref method instance");
		Personne[] personnes = { new Personne("nom3", "Julien"), new Personne("nom1", "Thierry"),new Personne("nom2", "Alain") };
		ComparaisonPersonne comparaisonPersonne = new ComparaisonPersonne();

		Arrays.sort(personnes, comparaisonPersonne::comparerParNom);
		System.out.println(Arrays.deepToString(personnes));

		Arrays.sort(personnes, comparaisonPersonne::comparerParPrenom);
		System.out.println(Arrays.deepToString(personnes)); 
		
		System.out.println("ref method d'une instance arbitraire d'un type");
		String[] fruits2 = { "Melon", "abricot", "fraise", "cerise", "mytille" };
		Arrays.sort(fruits2, String::compareToIgnoreCase);
		System.out.println(Arrays.deepToString(fruits2));
	    
		System.out.println("ref constructor");
		// zéro arg
		Supplier<Personne> supplier = Personne::new;
		System.out.println(supplier.get());
		// with args
		PersonneSupplier personneSupplier = Personne::new;
		Personne p = personneSupplier.creerInstance("nom", "prenom");
		System.out.println(p);
	}
	public static void afficher(List<String> liste, MonFormateur formateur) {
	    int i = 0;
	    for (String element : liste) {
	      i++;
	      System.out.print(formateur.formater("%3d %s%n", i, element));
	    }
	  }
	public void executer() {
		Runnable runnable = () -> {
			System.out.println(this.toString());
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	public long calculer(int a, int b, OperationEntiere operation) {
		return operation.effectuer(a, b);
	}

}
