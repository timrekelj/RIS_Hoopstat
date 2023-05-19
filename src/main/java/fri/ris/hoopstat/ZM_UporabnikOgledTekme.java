package fri.ris.hoopstat;
/***********************************************************************
 * Module:  ZM_UporabnikOgledTekme.java
 * Author:  aa8934
 * Purpose: Defines the Class ZM_UporabnikOgledTekme
 ***********************************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** @pdOid c8f67d71-1876-4dbe-a074-dde33a29d912 */
public class ZM_UporabnikOgledTekme extends Application {

   @Override
   public void start(Stage stage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ZM_UporabnikOgledTekme.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 600, 400);
      stage.setTitle("HoopStat");
      stage.setScene(scene);
      stage.setMinHeight(400);
      stage.setMinWidth(600);
      stage.show();
   }

   /** @pdRoleInfo migr=no name=K_OgledTekme assc=Association_7 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public K_OgledTekme k_OgledTekme;
   
   /** @pdOid 6ea6a8b4-a9d2-4ff3-9acc-c493a324ef2f */
   public Tekma Prikazi_seznam_tekem() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 992f1b95-04e3-4f04-bb98-62a6e538ed57 */
   public Tekma Izberi_tekmo() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid a16af580-665e-4c47-b0ab-a317bb449957 */
   public Tekma Prikazi_tekmo() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid ed2b8031-1e4a-4638-bed5-6f2c70512694 */
   public Tekma Spremljaj_v_zivo() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid d1f72966-2323-4d9b-82e3-892dceb1845e */
   public Igralec Prikazi_igralce() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 76337fbf-644e-443c-b143-1842d9b38ccc */
   public Igralec Prikazi_podatke_o_igralcu() {
      // TODO: implement
      return null;
   }
}