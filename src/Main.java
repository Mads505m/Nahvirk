import java.lang.reflect.Array;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Fag> fagListe = new ArrayList<>();
        ArrayList<Fag> tilmeldteFag = new ArrayList<>();
        ArrayList<Studerende> klasseListe = new ArrayList<>();
        ArrayList<Studerende> studentsFag = new ArrayList<>();
        Skole nySkole = new Skole();


        Studerende s1 = new Studerende(1, "Emil", "Emilsen", "Næstved", "4700", "10203040", 'A', tilmeldteFag);
        Laerer l1 = new Laerer(1, "Huggo", "Plys", "Huggoland", "4700", "20392102", tilmeldteFag);
        Fag f2 = (new Fag(2, "Hugo sprog", l1, klasseListe));
        Fag f1 = new Fag(1, "Matematik", l1, klasseListe);
        nySkole.opretFag(f1);
        nySkole.opretFag(f2);
        System.out.println(nySkole.getFagListe());
        System.out.println(tilmeldteFag);
        //nySkole.getStuderende(1).getTilmeldteFag().add(f2);

        s1 = nySkole.getStuderende(s1.getStdnr());
        f1 = nySkole.getFag(f1.getFagnr());

        nySkole.tilmeldStuderendeFag(s1, f2);
        nySkole.frameldStuderendeFag(s1, f2);
        System.out.println(s1);

        System.out.println(nySkole.tilmeldteTilFag(1));
        nySkole.getStuderende(3);

        System.out.println(nySkole);



    }
}
