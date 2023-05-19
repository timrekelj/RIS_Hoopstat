package fri.ris.hoopstat.models;
/***********************************************************************
 * Module:  K_OgledTekme.java
 * Author:  timrekelj
 * Purpose: Defines the Class K_OgledTekme
 ***********************************************************************/

import java.util.*;

/** @pdOid a92dd081-e135-4e64-b5ed-06dd201d951c */
public class K_OgledTekme {
   /** @pdRoleInfo migr=no name=Tekma assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection tekma;
   
   /** @pdOid 31538e12-8394-4237-9bcd-3c0c31434101 */
   public Tekma Vrni_seznam_tekem() {
      // TODO: implement
      return null;
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
   public java.util.Collection getTekma() {
      if (tekma == null)
         tekma = new java.util.HashSet();
      return tekma;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTekma() {
      if (tekma == null)
         tekma = new java.util.HashSet();
      return tekma.iterator();
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
      if (this.tekma == null)
         this.tekma = new java.util.HashSet();
      if (!this.tekma.contains(newTekma))
         this.tekma.add(newTekma);
   }
   
   /** @pdGenerated default remove
     * @param oldTekma */
   public void removeTekma(Tekma oldTekma) {
      if (oldTekma == null)
         return;
      if (this.tekma != null)
         if (this.tekma.contains(oldTekma))
            this.tekma.remove(oldTekma);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTekma() {
      if (tekma != null)
         tekma.clear();
   }

}