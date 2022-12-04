package pl.sda.j133.hibernate.fakturowanie;

import pl.sda.j133.hibernate.fakturowanie.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowanie.komenda.Komenda;
import pl.sda.j133.hibernate.fakturowanie.komenda.KomendaDodajFirme;
import pl.sda.j133.hibernate.fakturowanie.model.Firma;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = List.of(
 new KomendaDodajFirme()
        );
        String komenda;
        do {
            System.out.println("Lista dostepnych komend");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + " " + listaKomend.get(i).getKomenda());

            }
            System.out.println();

            System.out.println("Podaj komende:");
            komenda = Komenda.SCANNER.nextLine();
            ;
            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                    //  new DataAccessObject<Firma>().findAll(Firma.class);
                }
            }
        } while (!komenda.equalsIgnoreCase("exit")) ;

    }
}