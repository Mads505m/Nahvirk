import java.util.ArrayList;

public class Skole {
    private ArrayList<Studerende> studerendeListe;
    private ArrayList<Fag> fagListe;
    private ArrayList<Laerer> laererListe ;

    public Skole() {
        this.studerendeListe = new ArrayList<>();
        this.fagListe = new ArrayList<>();
        this.laererListe = new ArrayList<>();
    }


    public Studerende getStuderende(int stdNr) {
        for (Studerende s : studerendeListe) {
            if (s.getStdnr() == stdNr) {
                return s;
            }
        }
        return null;
    }

    public Fag getFag(int fagNr) {
        for (int i = 0; i < fagListe.size(); i++) {
            if (fagListe != null && fagListe.get(i).equals(fagNr)) {
                return fagListe.get(fagNr);
            }

        }
        return null;
    }

    public ArrayList<Fag> getFagListe(){
        return fagListe;
    }
    public Laerer getLaerer ( int laererNr){
        for (int i = 0; i < laererListe.size(); i++) {
            Laerer l = laererListe.get(i);
            if (l.getLaererNr() == laererNr) {
                return l;
            }
        }
        return null;
    }

    private int getStuderendeIndexNr ( int stdNr){
        //returnerer indexpladsen i ArrayListen
        for (int i = 0; i < studerendeListe.size(); i++) {
            if (studerendeListe.get(i).equals(stdNr)) {
                return i;
            }
        }
        return 0;
    }

            private int getStuderendeIndexNr (Studerende s){
                //returnerer indexpladsen i ArrayListen
                for (int i = 0; i < studerendeListe.size(); i++) {
                    if (studerendeListe.get(i).equals(s)) {
                        return i;
                    }

                }
                return -1;
            }

            private int getFagIndexNr ( int fagNr){
                for (int i = 0; i < fagListe.size(); i++) {
                    if (fagListe.get(i).equals(fagNr)) {
                        return i;
                    }
                }
                return -1;
            }

            private int getFagIndexNr (Fag f){
                for (int i = 0; i < fagListe.size(); i++) {
                    if (fagListe.get(i).equals(f)) {
                        return i;
                    }
                }
                return -1;
            }

            private int getLaererIndexNr ( int laererNr){
                //returnerer indexpladsen i ArrayListen
                for (int i = 0; i < laererListe.size(); i++) {
                    if (laererListe.get(i).equals(laererNr)) {
                        return i;
                    }
                }
                return -1;
            }

            private int getLaererIndexNr (Laerer l){
                //returnerer indexpladsen i ArrayListen
                for (int i = 0; i < laererListe.size(); i++) {
                    if (laererListe.get(i).equals(l)) {
                        return i;
                    }
                }
                return -1;
            }

            public void opretStuderende (Studerende s){
                studerendeListe.add(s);
            }

            public void opretStuderende ( int stnNr, String f, String e, String a, String p, String m,char k){
                studerendeListe.add(new Studerende(stnNr, f, e, a, p, m, k, fagListe));
            }

            public void opretLaerer (Laerer l){
                laererListe.add(l);
            }

            public void opretLaerer ( int lNr, String f, String e, String a, String p, String m){

                laererListe.add(new Laerer(lNr, f, e, a, p, m, fagListe));
            }

            public void opretFag (Fag f){
                fagListe.add(f);
            }

            public void opretFag ( int fagNr, String navn, Laerer laerer){

                fagListe.add(new Fag(fagNr, navn, laerer, studerendeListe));
            }

            public void tilmeldStuderendeFag (Studerende s, Fag f){
                if (s != null && f != null) {
                    s.getTilmeldteFag().add(f);
                    f.getKlasseListe().add(s);
                }
            }

    /*public void tilmeldStuderendeFag(int stdNr, int fagNr){
        Studerende s = getStuderende(stdNr);
        Fag f = getFag(fagNr);
        if (s != null && f != null) {
            s.getTilmeldteFag().add(f);
            f.getKlasseListe().add(s);
        }
      } */
            public void setLaererFag (Laerer l, Fag f){
                l.getFagListe().add(f);
            }

            public void setLaererFag ( int laererNr, int fagNr){
                for (int i = 0; i < laererListe.size(); i++) {
                    if (laererListe.get(i).equals(laererNr)) {
                        laererListe.get(i).getFagListe().add(getFag(fagNr));
                    }
                }
            }

            public void frameldStuderendeFag (Studerende s, Fag f){
                if (s != null && f != null) {
                    s.getTilmeldteFag().remove(f);
                    f.getKlasseListe().remove(s);
                }
            }
    /*public void frameldStuderendeFag(int stdNr, int fagNr){
        Studerende s = getStuderende(stdNr);
        Fag f = getFag(fagNr);
        if (s != null && f != null) {
            s.getTilmeldteFag().remove(f);
            f.getKlasseListe().remove(s);
        }
    } */

            public void fjernLaererFag (Laerer l, Fag f){
                if (l != null && f != null) {
                    l.getFagListe().remove(f);
                    f.getKlasseListe().remove(l);
                }
            }

            //public void fjernLaererFag(int laererNr, int fagNr){
            //}
            public ArrayList<Studerende> tilmeldteTilFag ( int fagNr){
                //returnerer alle studerende der går til det pågældende fag
                ArrayList<Studerende> studentersfag = new ArrayList<>();
                for (Studerende studerende : studerendeListe) {
                    if (studerende.getTilmeldteFag().equals(fagNr)) {
                        studentersfag.add(studerende);
                    }
                }
                return studentersfag;

            }

/*    public ArrayList<Studerende> tilmeldteTilFag(Fag f) {
        //returnerer alle studerende der går til det pågældende fag
        ArrayList<Studerende> studentersfag = new ArrayList<>();
        for (Studerende studerende : studerendeListe) {
            if (studerende.getTilmeldteFag().equals(f)) {
                return studentersfag;
            }
            return null;
        } */

            public ArrayList<Laerer> laererUnderviserFag (String fagNavn){
                //returnerer alle lærer der underviser i faget fagNavn
                for (Laerer laerer : laererListe) {
                    if (laerer.getFagListe().equals(fagNavn)) {
                        return laererListe;
                    }
                }
                return null;
            }

            public ArrayList<Studerende> klasseListe ( char kl){
                ArrayList<Studerende> klasser = new ArrayList<>();
                for (Studerende studerende : studerendeListe) {
                    if (studerende.getKlasse() == kl) {
                        klasser.add(studerende);
                    }
                }
                return klasser;
            }

            public void tilmeldStuderendeKlasse ( int stdNr, char kl){
                for (int i = 0; i < studerendeListe.size(); i++) {
                    if (studerendeListe.get(i).equals(stdNr)) {
                        studerendeListe.get(i).setKlasse(kl);
                    }
                }
            }

            public void tilmeldStuderendeKlasse (Studerende s,char kl){
                s.setKlasse(kl);
            }

            public void fjernStuderendeKlasse ( int stdNr, char kl){

            }

            public void fjernStuderendeKlasse (Studerende s,char kl){
            }
        }




