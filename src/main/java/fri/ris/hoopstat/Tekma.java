package fri.ris.hoopstat;
/***********************************************************************
 * Module:  Tekma.java
 * Author:  aa8934
 * Purpose: Defines the Class Tekma
 ***********************************************************************/

import java.util.*;

/** @pdOid dc628a9e-a9e1-4a27-b2fd-d6ccbde9eec8 */
public class Tekma {
   /** @pdOid a69fca72-cc11-4bc1-a701-907794fb18b9 */
   public Ekipa domaca_ekipa;
   /** @pdOid 00de4af1-e4cc-4502-9d23-97a09f550563 */
   public Ekipa gostujoca_ekipa;
   /** @pdOid d2c5b3fa-bd4c-42d6-aa3a-2c551ebc4401 */
   private java.util.Date datum_ura;
   /** @pdOid dd51945d-e851-4220-bee5-6a7860ba2640 */
   public int tocke_gostujoca;
   /** @pdOid 21019559-b7aa-4c98-b12a-97ec2d7495ca */
   public int tocke_domaca;

   /** @pdOid 00de4af1-b7aa-4220-b12a-6a7860ba2640 */
   public boolean koncana;

   /** @pdRoleInfo migr=no name=igralec_tekma assc=Association_8 coll=java.util.Collection impl=java.util.HashSet mult=0..1 type=Composition */
   public List<igralec_tekma> igralec_tekma;

   public Tekma(Ekipa domaca_ekipa, Ekipa gostujoca_ekipa, Date datum_ura, int tocke_gostujoca, int tocke_domaca, boolean koncana) {
        this.domaca_ekipa = domaca_ekipa;
        this.gostujoca_ekipa = gostujoca_ekipa;
        this.datum_ura = datum_ura;
        this.tocke_gostujoca = tocke_gostujoca;
        this.tocke_domaca = tocke_domaca;
        this.koncana = koncana;
        igralec_tekma = new ArrayList<>();
   }
   
   /** @pdOid a64051e2-286a-4a35-a4fe-bff6b8c776bf */
   public Tekma vrni_tekmo() {
      return this;
   }
   
   /** @pdOid 473b5aed-7125-4230-a86d-5a888bd8ed8b */
   public Collection<Tekma> vrni_seznam_tekem() {
      // TODO: implement
      return null;
   }

   /** @pdOid 16e5529d-38c3-4891-8ec6-1704ad3ce7aa */
   public Igralec vrni_igralca() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 81952ea3-fc18-4793-9d52-037d55ce42fd */
   public List<Igralec> vrni_seznam_igralcev() {
      List<Igralec> igralci = new ArrayList<>();
      for (fri.ris.hoopstat.igralec_tekma it: igralec_tekma) {
         igralci.add(it.igralec);
      }
      return igralci;
   }

}