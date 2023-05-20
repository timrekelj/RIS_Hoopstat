package fri.ris.hoopstat;
/***********************************************************************
 * Module:  igralec_tekma.java
 * Author:  aa8934
 * Purpose: Defines the Class igralec_tekma
 ***********************************************************************/

/** @pdOid 61dc6001-9504-4ee9-a163-fdb71f30351c */
public class igralec_tekma {
   /** @pdOid 7327b455-6326-48d5-93a4-2b82e193e18b */
   public Igralec igralec;
   /** @pdOid 3c9705bc-e4d9-4d21-baf6-9952607437e2 */
   public Tekma tekma;
   /** @pdOid 0d8cdaea-32cf-40e3-b3c1-1015f1959851 */
   public int tocke;
   /** @pdOid 220e1fb2-94f2-40e2-b6cc-deb385c9382c */
   public int asistence;
   /** @pdOid 8433e1e5-0429-49de-965e-a33a80848083 */
   public int skoki;
   /** @pdOid c5283ce2-c48b-4ee7-ad65-47d4287fe9a5 */
   public int bloki;
   /** @pdOid ca17619f-9d2f-4d2f-822c-68f300033d14 */
   public int ukradene_zoge;
   /** @pdOid 73a3b382-0fd1-4b9a-bedd-5897ebbcd4dc */
   public int izgubljene_zoge;

   public igralec_tekma(Igralec igralec, Tekma tekma, int tocke, int asistence, int skoki, int bloki, int ukradene_zoge, int izgubljene_zoge) {
      this.igralec = igralec;
      this.tekma = tekma;
      this.tocke = tocke;
      this.asistence = asistence;
      this.skoki = skoki;
      this.bloki = bloki;
      this.ukradene_zoge = ukradene_zoge;
      this.izgubljene_zoge = izgubljene_zoge;
   }
}