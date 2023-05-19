package fri.ris.hoopstat;
/***********************************************************************
 * Module:  Igralec.java
 * Author:  aa8934
 * Purpose: Defines the Class Igralec
 ***********************************************************************/

/** @pdOid 2c91a1c3-59fd-4578-a5a5-5f314559bd49 */
public class Igralec {
   /** @pdOid 7136bc52-e4ae-4cc8-95d0-10bc873b63c1 */
   private String ime;
   /** @pdOid 46132289-1623-4b61-bd28-c1c74e4af386 */
   private String priimek;
   /** @pdOid e2af5cd9-969e-4a0e-b3b5-fe2cd0fae96a */
   private int stevilka;
   /** @pdOid 31af813b-2653-4134-a528-e26334d22b17 */

   public Igralec(String ime, String priimek, int stevilka) {
      this.ime = ime;
      this.priimek = priimek;
      this.stevilka = stevilka;
   }
   
   /** @pdOid 9c222507-6943-4628-a976-7b80df3e18e0 */
   public Igralec vrni_podatke_igralca() { return this; }

}