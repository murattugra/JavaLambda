import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

	
	/*
	   1) Lambda "Functional Programming"
	      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	   ve hatasiz code yazma acilarindan cok faydalidir.
	   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
	      Lambda kullanmak hatasız code kullanmaktır.
	*/

	public static void main(String[] args) {
		
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		
		
		
		 printElStructured(list);// method call
		 System.out.println();
		 System.out.println("***********");
		 printElfuctional(list);// lambda expression
		 System.out.println();
		 System.out.println("******");
		 printElfuctional1(list);// method reference
		 System.out.println();
		 System.out.println("******");
		 printCiftElStructured(list);
		 System.out.println();
		 System.out.println("******");
		 printCiftAlmisKucuk(list);
		 System.out.println();
		 System.out.println("******");
		 tekveya20denbuyuk(list);
		 System.out.println();
		 System.out.println("******");
		 kareler01(list);
		 System.out.println();
		 System.out.println("******");
		 kupBirFazlaTekFunction(list);
		 System.out.println();
		 System.out.println("******");
		 ciftlerKarekokler(list);

		 System.out.println("******");
		 maxElfunction(list);
	}
	
	// structured Programming ile list elemanlarinin tamamini yazdiriniz
	
	public static void  printElStructured(List<Integer> list) {
		
		for (Integer each : list) {
			System.out.print(each+" ");
		}
	}
	
	// Functional Programming ile list elemanlarinin tamamini yazdiriniz
	
	
	public static void printElfuctional(List<Integer> list) {
		list.stream().forEach(t->System.out.print(t+" "));	 //t lambda operatorudur baska seyde yayilir
																//ama bu daha uygundur
		
		// stream() : datalari yukaridan asagiya akis sekline getirir
		// for Each() : datanin parametresine gore herbir elemani isler 
		//Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
		
		
		
	}
	
	
	// Method Reference --> kendi create ettigimiz veya javadan aldigimiz mothod ile 
	//Classname::MethodName -------***ERBERRRRRLEEEEEEEEEEEEE
	
	
	public static void printEl(int t) {// refere edilecek method creta edildi
		
		System.out.print(t+ " ");
	}
	
	
	public static void printElfuctional1(List<Integer> list) {
		
		list.stream().forEach(Lambda01::printEl);//iste lambda budur
	}
	
	
	// structor Programming ile list elemanlarinin cift olanlarini ani satirda
		//aralarina boslk birakarak yaziniz
	
	
	public static void printCiftElStructured(List<Integer> list) {
		
		for (Integer w : list) {
			if (w%2==0) {
				System.out.print(w+" ");
			}
		}
				
	}
	
	
	// Functional Programming ile list elemanlarinin cift olanlarini ani satirda
	//aralarina bosluk birakarak yaziniz
	
	
	
	public static void printCiftElFuctional1(List<Integer> list) {
		
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		//filter()--> a
	}
	
	
	public static boolean ciftBul(int i) {
		
		return i%2==0;
		
		
	}
	
	public static void printCiftElFuctional2(List<Integer> list) {
		
		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl);
		//filter()--> a
	}
	
	
	public static void printCiftAlmisKucuk(List<Integer> list) {
		
		list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
	}
	
	
	//Functional Programming ile list elemanlarinin  tek olanalrini veya 20 dan buyuk
    // olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz
	
	
	public static void tekveya20denbuyuk(List<Integer> list) {
		
		list.stream().filter(t->t%2==1 || t>20).forEach(Lambda01::printEl);
		
	}
	
	

	//Functional Programming ile list elemanlarinin  cift olanalrini 
    // karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void kareler01(List<Integer> list) {
		
		list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
		//map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.
	
	}
	
	//Functional Programming ile list elemanlarinin  tek olanalrinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	
	public static void kupBirFazlaTekFunction(List<Integer> list) {
		
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);
	
	}
	
	//Functional Programming ile list elemanlarinin  cift olanlarinin
	// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void ciftlerKarekokler(List<Integer> list) {
		
	list.
		stream().							// Bu yazim sekli daha uygundur bildiginizi gosterir
		filter(Lambda01::ciftBul).
		map(Math::sqrt).
		forEach(t->System.out.println(t));
		
		
		//list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(Lambda01::printEl);//map(Math::sqrt)
																						// bunun  icin printEl deki paremetre double
																					//olmasi gerekiyor
		
	}
	
	// List in en buyuk elemanini yazdiriniz
	
	public static void maxElfunction(List<Integer> list) {
		
Optional<Integer> maxEl = list.stream().reduce(Math::max);// reduce coklu elemanlari bir elemana cevirir
	//Optional 	her yola acik Stringde alir integerde alir	hepsini											
		System.out.println(maxEl);// max-.max eleman summ->topla .....
		
		// reduce() --> alzaltmak ... bir cok datayi tek bir dataya(max  min  carpma  top vs cevirmek ic in kullanilir
	}
	
	
	

	
	
	
}
