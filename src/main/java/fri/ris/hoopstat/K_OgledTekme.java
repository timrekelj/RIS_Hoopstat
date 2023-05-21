package fri.ris.hoopstat;
/***********************************************************************
 * Module:  K_OgledTekme.java
 * Author:  timrekelj
 * Purpose: Defines the Class K_OgledTekme
 ***********************************************************************/

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.Instant;
import java.util.*;

/** @pdOid a92dd081-e135-4e64-b5ed-06dd201d951c */
public class K_OgledTekme implements Initializable {

   public ToggleGroup izbranaTekmaGroup;
   public RadioButton tekma00;
   public RadioButton tekma01;
   public RadioButton tekma02;
   public Label ekipa_home;
   public Label ekipa_away;
   public Label rezultat_home;
   public Label rezultat_away;
   public ChoiceBox izbira_igralca;
   public Button spremljaj;
   public Label igralec;
   public Label tocke;
   public Label asistence;
   public Label skoki;
   public Label bloki;
   public Label ukradene;
   public Label izgubljene;


   /** @pdRoleInfo migr=no name=Tekma assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public static List<Tekma> tekme;
   public Tekma izbrana_tekma;
   public Igralec izbrani_igralec;
   public VBox prikazan_igralec;

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      tekme = new ArrayList<Tekma>();

      List<Igralec> igralci_lakers = new ArrayList<Igralec>();
      List<Igralec> igralci_heat = new ArrayList<Igralec>();
      List<Igralec> igralci_olimpija = new ArrayList<Igralec>();

      igralci_lakers.add(new Igralec("Lebron", "James", 23));
      igralci_lakers.add(new Igralec("Anthony", "Davis", 3));
      igralci_lakers.add(new Igralec("Dennis", "Schroder", 17));
      igralci_lakers.add(new Igralec("Kyle", "Kuzma", 0));
      igralci_lakers.add(new Igralec("Marc", "Gasol", 14));

      igralci_heat.add(new Igralec("Jimmy", "Butler", 22));
      igralci_heat.add(new Igralec("Bam", "Adebayo", 13));
      igralci_heat.add(new Igralec("Goran", "Dragic", 7));
      igralci_heat.add(new Igralec("Tyler", "Herro", 14));
      igralci_heat.add(new Igralec("Duncan", "Robinson", 55));

      igralci_olimpija.add(new Igralec("Jaka", "Blazic", 7));
      igralci_olimpija.add(new Igralec("Edo", "Muric", 13));
      igralci_olimpija.add(new Igralec("Luka", "Rupnik", 5));
      igralci_olimpija.add(new Igralec("Jure", "Bubnic", 15));
      igralci_olimpija.add(new Igralec("Jan", "Span", 11));

      Ekipa lakers = new Ekipa("Lakers", igralci_lakers);
      Ekipa heat = new Ekipa("Heat", igralci_heat);
      Ekipa olimpija = new Ekipa("Olimpija", igralci_olimpija);

      tekme.add(new Tekma(lakers, heat, Date.from(Instant.now()), 91, 99));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(0), tekme.get(0), 25, 8, 6, 1, 1, 4));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(1), tekme.get(0), 30, 3, 12, 3, 0, 0));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(2), tekme.get(0), 14, 12, 3, 0, 1, 3));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(3), tekme.get(0), 22, 2, 4, 1, 1, 1));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(4), tekme.get(0), 8, 4, 9, 2, 0, 1));

      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_heat.get(0), tekme.get(0), 29, 8, 6, 1, 1, 4));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_heat.get(1), tekme.get(0), 24, 3, 12, 3, 0, 0));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_heat.get(2), tekme.get(0), 11, 12, 3, 0, 1, 3));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_heat.get(3), tekme.get(0), 15, 2, 4, 1, 1, 1));
      tekme.get(0).igralec_tekma.add(new igralec_tekma(igralci_heat.get(4), tekme.get(0), 12, 4, 9, 2, 0, 1));


      tekme.add(new Tekma(lakers, olimpija, Date.from(Instant.parse("2023-04-04T20:30:00Z")), 123, 112));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(0), tekme.get(1), 15, 10, 9, 0, 2, 6));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(1), tekme.get(1), 30, 5, 17, 5, 0, 1));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(2), tekme.get(1), 24, 9, 1, 0, 4, 2));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(3), tekme.get(1), 26, 1, 2, 0, 0, 2));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_lakers.get(4), tekme.get(1), 17, 2, 7, 1, 0, 0));

      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(0), tekme.get(1), 36, 13, 6, 0, 3, 3));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(1), tekme.get(1), 34, 5, 12, 3, 0, 3));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(2), tekme.get(1), 18, 4, 3, 0, 1, 2));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(3), tekme.get(1), 22, 2, 4, 1, 1, 1));
      tekme.get(1).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(4), tekme.get(1), 13, 1, 2, 2, 0, 1));


      tekme.add(new Tekma(olimpija, heat, Date.from(Instant.parse("2023-03-05T22:00:00Z")), 95, 96));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(0), tekme.get(2), 29, 11, 3, 0, 2, 4));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(1), tekme.get(2), 26, 5, 9, 3, 0, 1));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(2), tekme.get(2), 13, 2, 1, 0, 0, 2));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(3), tekme.get(2), 16, 1, 2, 0, 1, 2));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_olimpija.get(4), tekme.get(2), 12, 2, 3, 1, 1, 0));

      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_heat.get(0), tekme.get(2), 33, 6, 6, 2, 1, 4));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_heat.get(1), tekme.get(2), 19, 3, 12, 3, 0, 2));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_heat.get(2), tekme.get(2), 12, 9, 5, 0, 1, 3));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_heat.get(3), tekme.get(2), 18, 5, 4, 0, 1, 1));
      tekme.get(2).igralec_tekma.add(new igralec_tekma(igralci_heat.get(4), tekme.get(2), 13, 1, 2, 0, 0, 1));
   }
   
   /** @pdOid 31538e12-8394-4237-9bcd-3c0c31434101 */
   public List<Tekma> Vrni_seznam_tekem() {
      return tekme;
   }
   
   /** @pdOid e41c5dc0-181f-4914-8340-a80f74943c07 */
   public Tekma Vrni_podrobnosti_o_tekmi() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 2f6cada9-38cc-4d05-b792-19c90fba14ba */
   public String[] Vrni_igralce_na_tekmi() {
      String[] igralci = new String[10];
      List<Igralec> igralciTekme = izbrana_tekma.vrni_seznam_igralcev();
      for (int i = 0; i < igralciTekme.size(); i++) {
         igralci[i] = igralciTekme.get(i).ime + " " + igralciTekme.get(i).priimek;
      }
      return igralci;
   }
   
   /** @pdOid ad4a78cc-459c-4c19-b14a-a4fc898fcd72 */
   public Igralec Vrni_podatke_o_igralcu_na_tekmi() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 6be1f0a4-d4be-4dd2-a64e-6873d2f3636f */
   public String Obvestilo_o_koncani_tekmi() {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public Collection getTekma() {
      if (tekme == null)
         tekme = new ArrayList<>();
      return tekme;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTekma() {
      if (tekme == null)
         tekme = new ArrayList<>();
      return tekme.iterator();
   }

   /** @pdGenerated default setter
     * @param newTekma */
   public void setTekma(java.util.Collection newTekma) {
      removeAllTekma();
      for (java.util.Iterator iter = newTekma.iterator(); iter.hasNext();)
         addTekma((Tekma)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTekma */
   public void addTekma(Tekma newTekma) {
      if (newTekma == null)
         return;
      if (this.tekme == null)
         this.tekme = new ArrayList<>();
      if (!this.tekme.contains(newTekma))
         this.tekme.add(newTekma);
   }
   
   /** @pdGenerated default remove
     * @param oldTekma */
   public void removeTekma(Tekma oldTekma) {
      if (oldTekma == null)
         return;
      if (this.tekme != null)
         if (this.tekme.contains(oldTekma))
            this.tekme.remove(oldTekma);
   }

   /** @pdGenerated default removeAll */
   public void removeAllTekma() {
      if (tekme != null)
         tekme.clear();
   }
}