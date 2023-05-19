package fri.ris.hoopstat;
/***********************************************************************
 * Module:  Ekipa.java
 * Author:  aa8934
 * Purpose: Defines the Class Ekipa
 ***********************************************************************/

import java.util.*;

/** @pdOid c2cdc733-e668-4db3-b29a-36486a994b42 */
public class Ekipa {
   /** @pdOid 4b359e05-c17d-4ffb-9a82-7fb18694cf5b */
   private String ime;
   private List<Igralec> igralci;

   public Ekipa(String ime, List<Igralec> igralci) {
       this.ime = ime;
       this.igralci = igralci;
   }

   public Ekipa vrni_podatke_ekipe() { return this; }
   
   /** @pdOid 34b5a594-36dc-4c3a-b519-d6c65c03efc5 */
   public List<Igralec> vrni_igralce() {
        return igralci;
   }

}