import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 3, 65, -3, 7, 34, 22, -60, 42, 15));

		ciftKareMax(list);

		toplaEl1(list);

		ciftCarpimEl1(list);

		ciftCarpimEl2(list);

		enKucuk(list);

		enKucuk3(list);

		enKucuk4(list);
		
		onbestenBykKckTekSayi(list);
		
		ciftKareKckByg(list);
		
		ciftKareBytKcg(list);
	}

	// Listteki cift olan sayilarin karelerini aliniz en byugunu yazdiriniz

	public static void ciftKareMax(List<Integer> list) {

		Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
		// reduce(Math::max); da kullanilarbilir ancak reduce(Integer::max); daha
		// specific oldugu icin hizli calisir

		// int <Integer>
		// maxEl=list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
		// reduce() returne edilen eleman null yada int'de buyuk olur ihtimali icin java
		// guvenlik olarak
		// handle ederek Optional class sart kosuyor

		System.out.println(maxEl);

	}

	// List teki tum elemanlari toplamini yazdiriniz
	// Lambda Expresiion..

	public static void toplaEl1(List<Integer> list) {

		int toplam = list.stream().reduce(0, (x, y) -> x + y);
										     // (12, 3, 65, -3, 7, 34, 22, -60, 42, 15));
		System.out.println(toplam); 
		/*
		 * x her zaman ilk degerini atanan degerden (0) alır y her zaman degerini
		 * list.stream()'den alır(akis) x ilk degerden sonraki degerlerini islemden alir
		 */

	}

	// List teki tum elemanlarin toplamini yaziniz
	// Method Reference....

	public static void toplaEl2(List<Integer> list) {

		Optional<Integer> toplam = list.stream().reduce(Integer::sum);

		System.out.println(toplam);

	}

	// List'teki cift elemanlarin carpimini yazdiriniz.
	// Method Reference...

	public static void ciftCarpimEl1(List<Integer> list) {

		Optional<Integer> carpim = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);// multiplyExact
		System.out.println(carpim); // Carpma

	}

	// List'teki cift elemanlarin carpimini yazdiriniz.
	// Lambda Expresiion

	public static void ciftCarpimEl2(List<Integer> list) {

		Integer carpim = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> x * y);
		// pozitif deger uretiniz
		Integer carpim2 = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> x * y);
		System.out.println(carpim);
		System.out.println(carpim2);
	}

	// List' teki elemanladan en kucugunu 4 farkli yontem ile yaziniz

	// 1.1.Yontem Method Reference -->Integer Class
	public static void enKucuk(List<Integer> list) {

		Optional<Integer> enKucuk = list.stream().reduce(Integer::min);
		System.out.println(enKucuk);
	}

	// 1.2.Yontem Method Reference -->Math Class

	public static void enKucuk2(List<Integer> list) {

		Optional<Integer> enKucuk = list.stream().reduce(Math::min);
		System.out.println(enKucuk);
	}

	// 2.Yontem Mathod Reference --> Murat Clasindan

	public static int minBul(int x, int y) {

		return x < y ? x : y;

	}

	public static void enKucuk3(List<Integer> list) {

		Optional<Integer> enKucuk = list.stream().reduce(Lambda02::minBul);

		System.out.println(enKucuk);
	}

	// 4. Yontem Lambda Expression

	public static void enKucuk4(List<Integer> list) {

		Integer enKucuk = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);// X maximum int sayi ile baslar
																		//(12, 3, 65, -3, 7, 34, 22, -60, 42, 15));
		System.out.println(enKucuk);									// y miz ilk 12 dir  y x e gecer					
	}																	

	
	//List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
	
	
	public static void onbestenBykKckTekSayi(List<Integer> list) {
	
	//list.stream().filter(t->t%2==1).filter(t->t>15).reduce(Integer::min);
	
		System.out.println(list.
				stream().//akisa girdi
				filter(t->t%2==1 & t>15).//tek ve 15 den byk sart
				reduce(Integer::min));//min deger reduce edildi
	
	}
	
	//list'in cift  elemanlarinin kareleri ni  kucukte buyuge yazdiriniz
	
	public static void ciftKareKckByg(List<Integer> list) {
		
		list.
			stream().
			filter(Lambda01::ciftBul).
			map(t->t*t).
			sorted().//akisa giren elemanlari naturel order e gore siralar
			forEach(Lambda01::printEl);//144 484 1156 1764 3600 
	System.out.println();
	}
	
	//list'in tek  elemanlarinin kareleri ni buyukten kucukge yazdiriniz
	public static void ciftKareBytKcg(List<Integer> list) {
		
		list.
		stream().
		filter(t->t%2==1).
		map(t->t*t).
		sorted(Comparator.reverseOrder()).//akisa giren elemanlari ters siralar ******************
		forEach(Lambda01::printEl);//4225 225 49 9 
		
		
		
	}
	
}
