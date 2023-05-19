package fri.ris.hoopstat;
/***********************************************************************
 * Module:  K_OgledTekme.java
 * Author:  timrekelj
 * Purpose: Defines the Class K_OgledTekme
 ***********************************************************************/

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.Instant;
import java.util.*;

/** @pdOid a92dd081-e135-4e64-b5ed-06dd201d951c */
public class K_OgledTekme implements Initializable {

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
   public Label ukradene_zoge;
   public Label izgubljene_zoge;


   /** @pdRoleInfo migr=no name=Tekma assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public static List<Tekma> tekme;
   public Tekma izbrana_tekma;
   public Igralec izbrani_igralec;

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

      tekme.add(new Tekma(lakers, heat, Date.from(Instant.now()), 99, 91));
      tekme.add(new Tekma(lakers, olimpija, Date.from(Instant.parse("2023-04-04T20:30:00Z")), 112, 123));
      tekme.add(new Tekma(olimpija, heat, Date.from(Instant.parse("2023-03-05T22:00:00Z")), 96, 95));
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
   public Igralec Vrni_igralce_na_tekmi() {
      // TODO: implement
      return null;
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