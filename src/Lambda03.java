import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import javax.management.ConstructorParameters;
import javax.naming.LimitExceededException;

public class Lambda03 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>(
				Arrays.asList("mehmet", "emre", "nilgun", "yıldız", "kader", "emine", "islam", "islam", "emre"));

		bykHrfTekrarsizSira(list);
		System.out.println();
		karakterSayisiTekrarsiz(list);
		System.out.println();
		karakterSayisiSiraliEl(list);
		System.out.println();
		sonHarfTersSiraliEl(list);
		System.out.println();
		ciftSayiliElKareTekrarsiz(list);
		System.out.println();
		harfSayisi7Kontrol(list);
		System.out.println();
		wIleBaslama(list);
		System.out.println();
		wmi(list);
		System.out.println();
		karakteriEnBuyukEl2(list);
		System.out.println();
		ilkElemanHarisSonHarfSirali(list);
	}

	// List elemanlarini alafabetik buyuk harf ve tekrarsiz yazdiriniz

	public static void bykHrfTekrarsizSira(List<String> list) {
		list.stream().// akisa girdi
		// map(t->t.toUpperCase()).//elelmanlar byk harf update edildi
				map(String::toUpperCase).// elelmanlar byk harf update edildi
				sorted().// alfabetik sira
				distinct().// tekrarsiz yapildi *********************************
				forEach(t -> System.out.print(t + " "));// yazdirilidi
		// EMRE EMİNE KADER MEHMET NİLGUN YILDIZ İSLAM
		System.out.println();
	}

	// list elemanlarinin character sayisini ters sirali tekrarsiz yazdiriniz

	public static void karakterSayisiTekrarsiz(List<String> list) {

		list.stream().map(t -> t.length()).// elemanlar Integer update edildi
				sorted(Comparator.reverseOrder()).// terste siraladi
				distinct().// tekrarsiz yapti
				forEach(Lambda01::printEl);// yazdi

		// degistireceksen map yap ... siralayacaksan Compare... tekrarsizsa distinct..
		// reverseOrder ters sira
	}

	// List elemanlarini character sayisina gore kckten byk e gore yazdiriniz.
	public static void karakterSayisiSiraliEl(List<String> list) {
		list.stream().sorted(Comparator.comparing(t -> t.length())).// eleman character sayisina gore ozel siralama
																	// yapildi
				forEach(t -> System.out.print(t + " "));

	}

	// list elemanlarinin son harfine gore ters sirali yazdiriniz
	public static void sonHarfTersSiraliEl(List<String> list) {
		list.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).// elemanin
																										// length()-1)-->son
																										// inedx'inin
																										// karakterini
																										// alir
				reversed()).// elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
				forEach(t -> System.out.print(t + " "));
	}

	// Cift sayili elemanlarin karelerini hesaplayan, tekrarli olanlari sadece bir
	// kere buyukten kucuge dogru
	// yazdiran bir program yaziniz.

	public static void ciftSayiliElKareTekrarsiz(List<String> list) {

		list.stream().// akisa sokar
				map(String::length).// uzunluklarini alir
				filter(t -> t % 2 == 0).// uzunluklari cift olanlari bulur sart var burada
				map(t -> t * t).// uzunluklari cift olanlarin karelerini alir
				sorted(Comparator.reverseOrder()).// onlari terse ceviri buyukten kucuge
				distinct().// tekrarsiz yapildi
				forEach(Lambda01::printEl);
		;// yazar output-> 36 16

	}
	// List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol
	// ediniz

	public static void harfSayisi7Kontrol(List<String> list) {

		System.out.println(list.stream().allMatch(t -> t.length() <= 7)// burasi ture yada false doner allMatch herbir
																		// elemanin //harf sayisinin <=7 eslesmesine
																		// bakti
				? "List elemanlari 7 harfte den buyuk deil"
				: "List elemanlari 7 harfte den buyuk ");// ternary kullandik

	}

	// List elelmanlarinin "W" ile baslamasını kontrol ediniz
	public static void wIleBaslama(List<String> list) {

		System.out.println(
				list.stream().noneMatch(t -> t.startsWith("w")) ? "w ile basayan isim kimse yok" : "eslesen var");

		// noneMatch hepsinde eslesen yoksa true verir yoksa varsa false verir

		// anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return
		// eder
		// allMatch() --> tum elemanlar sarti saglarsa true en az bir eleman sarti
		// saglamazsa false return eder.
		// noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA
		// false return eder.

	}

	public static void wmi(List<String> list) {
		System.out.println(// otomatik Stream yapti
				list.stream().noneMatch(t -> t.startsWith("w")) ? "hicbiri W ile baslamiyor" : "w ile baslayan var");
		System.out.println(
				list.stream().allMatch(t -> t.startsWith("w")) ? "hepsi W ile basliyor" : "hicbiri W ile baslamiyor");
		System.out.println(list.stream().anyMatch(t -> t.startsWith("w")) ? "herhangibiri W ile basliyor"
				: "hicbiri W ile baslamiyor");

	}
	 public static void karakteriEnBuyukEl(List<String> list) {
	        System.out.println(list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
	                        reversed()).//ters sirlad b->k
	                        findFirst());//ilk elelmani aldi

	    }
	// Karakter sayisi en buyuk elemani yazdiriniz.
	public static void karakteriEnBuyukEl2(List<String> list) {
		 Stream<String> sonIsim = list.
	                stream().
	                sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
	                        reversed()).//ters sirlad b->k
	                //  findFirst());//ilk elelmani aldi
	                        limit(1);//limit(a) akısdan cıkan elemanları a parametresine dore ilk a elamanı alır
	        System.out.println(Arrays.toString(sonIsim.toArray()));// sonIsim i array yaparak yazdirdik
	}

	//list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari yazdiriniz
    public static void ilkElemanHarisSonHarfSirali(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.length() - 1))).
                skip(1).//akıstan cikaln elelmanlarin 1. parametreyi atlar
                forEach(t-> System.out.print(t+" "));


    }

	
	
	
	
	
}
