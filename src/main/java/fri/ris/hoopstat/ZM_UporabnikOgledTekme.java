package fri.ris.hoopstat;
/***********************************************************************
 * Module:  ZM_UporabnikOgledTekme.java
 * Author:  aa8934
 * Purpose: Defines the Class ZM_UporabnikOgledTekme
 ***********************************************************************/

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/** @pdOid c8f67d71-1876-4dbe-a074-dde33a29d912 */
public class ZM_UporabnikOgledTekme extends Application {

   /** @pdRoleInfo migr=no name=K_OgledTekme assc=Association_7 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public K_OgledTekme k_OgledTekme;

   @Override
   public void start(Stage stage) throws IOException {
      FXMLLoader fxmlLoader = new FXMLLoader(ZM_UporabnikOgledTekme.class.getResource("ZM_UporabnikOgledTekme.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 600, 400);
      stage.setTitle("HoopStat");
      stage.setScene(scene);
      stage.setMinHeight(400);
      stage.setMinWidth(600);
      stage.show();

      // tole je potrebno, da lahko dostopamo do kontrollerja
      // use kar rabmo iz controllerja, klicemo prek tega
      k_OgledTekme = fxmlLoader.getController();

      // tukej klicemo metode iz tega classa da se izvedejo use casi
      Prikazi_seznam_tekem();

      Spremljaj_v_zivo(stage);

      // listener za izbrano tekmo
      k_OgledTekme.izbranaTekmaGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
         public void changed(ObservableValue<? extends Toggle> ov,
                             Toggle old_toggle, Toggle new_toggle) {
            if (k_OgledTekme.izbranaTekmaGroup.getSelectedToggle() != null) {
               String temp = k_OgledTekme.izbranaTekmaGroup.selectedToggleProperty().get().toString().split("]")[1];
               temp = temp.substring(1, temp.length() - 1);
               String ekipa1 = temp.split(" vs ")[0];
               String ekipa2 = temp.split(" vs ")[1];
               for (Tekma t : k_OgledTekme.Vrni_seznam_tekem()) {
                  if (t.domaca_ekipa.ime.equals(ekipa1) && t.gostujoca_ekipa.ime.equals(ekipa2)){
                     Izberi_tekmo(t);
                     return;
                  }
               }
               System.out.println("Tekma ne obstaja");
            }
         }
      });

      k_OgledTekme.izbira_igralca.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
         if (newValue == null) {
            k_OgledTekme.igralec.setText("<Ime igralca>");
            k_OgledTekme.tocke.setText("null");
            k_OgledTekme.asistence.setText("null");
            k_OgledTekme.skoki.setText("null");
            k_OgledTekme.bloki.setText("null");
            k_OgledTekme.ukradene.setText("null");
            k_OgledTekme.izgubljene.setText("null");
            return;
         }

         for (igralec_tekma igralec_tekma: k_OgledTekme.izbrana_tekma.igralec_tekma) {
            if (igralec_tekma.igralec.ime.equals(newValue.toString().split(" ")[0]) && igralec_tekma.igralec.priimek.equals(newValue.toString().split(" ")[1])) {
               Prikazi_podatke_o_igralcu(igralec_tekma);
               return;
            }
         }
      });
   }

   /** @pdOid 6ea6a8b4-a9d2-4ff3-9acc-c493a324ef2f */
   public void Prikazi_seznam_tekem() {
      List<Tekma> tekme = k_OgledTekme.Vrni_seznam_tekem();

      // to bi bilo uporabno, ce radio buttoni ne bi bili hardcodani
      // for(Tekma tekma : tekme) {
      //   K_OgledTekme.tekma00.setText(tekma.domaca_ekipa.ime + " vs " + tekma.gostujoca_ekipa.ime);
      //}

      // tole je hardcodana resitev
      k_OgledTekme.tekma00.setText(tekme.get(0).domaca_ekipa.ime + " vs " + tekme.get(0).gostujoca_ekipa.ime);
      k_OgledTekme.tekma01.setText(tekme.get(1).domaca_ekipa.ime + " vs " + tekme.get(1).gostujoca_ekipa.ime);
      k_OgledTekme.tekma02.setText(tekme.get(2).domaca_ekipa.ime + " vs " + tekme.get(2).gostujoca_ekipa.ime);

      Izberi_tekmo(tekme.get(0));
   }
   
   /** @pdOid 992f1b95-04e3-4f04-bb98-62a6e538ed57 */
   public Tekma Izberi_tekmo(Tekma t) {
      k_OgledTekme.izbrana_tekma = t;
      Prikazi_tekmo(t);
      return null;
   }
   
   /** @pdOid a16af580-665e-4c47-b0ab-a317bb449957 */
   public Tekma Prikazi_tekmo(Tekma t) {
      k_OgledTekme.ekipa_home.setText(t.domaca_ekipa.ime);
      k_OgledTekme.ekipa_away.setText(t.gostujoca_ekipa.ime);
      k_OgledTekme.rezultat_home.setText(Integer.toString(t.tocke_domaca));
      k_OgledTekme.rezultat_away.setText(Integer.toString(t.tocke_gostujoca));
      Prikazi_igralce(t);
      Prikazi_podatke_o_igralcu(null);
      return null;
   }
   
   /** @pdOid ed2b8031-1e4a-4638-bed5-6f2c70512694 */
   public Tekma Spremljaj_v_zivo(Window window) {
      Popup popup = new Popup();
      Label label = new Label();

      label.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 10px;");
      label.setMinWidth(100);
      label.setMinHeight(50);

      popup.getContent().add(label);

      EventHandler<ActionEvent> spremljaj = actionEvent -> {
         if (popup.isShowing()) {
            // ugasni popup
            k_OgledTekme.spremljaj.setText("Spremljaj v živo");
            popup.hide();
            return;
         }

         // prižgi popup
         popup.show(window);
         k_OgledTekme.spremljaj.setText("Prenehaj spremljati v živo");

         if (k_OgledTekme.izbrana_tekma.koncana) {
            label.setText("Tekma se je že končala");
            return;
         }

         // če tekma še ni končana, začni osveževati podatke
         // v primeru podatkovne baze/api-ja bi klicali in osveževali podatke z metodo osvezevanje()
         label.setText(k_OgledTekme.izbrana_tekma.domaca_ekipa.ime + ": " + k_OgledTekme.izbrana_tekma.tocke_domaca + "\n" +
                 k_OgledTekme.izbrana_tekma.gostujoca_ekipa.ime + ": " + k_OgledTekme.izbrana_tekma.tocke_gostujoca);
      };
      k_OgledTekme.spremljaj.setOnAction(spremljaj);
      return null;
   }

   private void osvezevanje(Label label) {
      try {
         Thread.sleep(1000);
         // osveži podatke
         osvezevanje(label);
      } catch (InterruptedException e) { e.printStackTrace(); }
   }

   /** @pdOid d1f72966-2323-4d9b-82e3-892dceb1845e */
   public Igralec Prikazi_igralce(Tekma t) {
      k_OgledTekme.izbira_igralca.getItems().clear();
      k_OgledTekme.izbira_igralca.getItems().addAll(k_OgledTekme.Vrni_igralce_na_tekmi());
      return null;
   }
   
   /** @pdOid 76337fbf-644e-443c-b143-1842d9b38ccc */
   public Igralec Prikazi_podatke_o_igralcu(igralec_tekma igralec_tekma) {
      if (igralec_tekma == null) {
         k_OgledTekme.prikazan_igralec.visibleProperty().setValue(false);
         return null;
      }
      k_OgledTekme.prikazan_igralec.visibleProperty().setValue(true);
      k_OgledTekme.igralec.setText(igralec_tekma.igralec.ime + " " + igralec_tekma.igralec.priimek);
      k_OgledTekme.tocke.setText(Integer.toString(igralec_tekma.tocke));
      k_OgledTekme.asistence.setText(Integer.toString(igralec_tekma.asistence));
      k_OgledTekme.skoki.setText(Integer.toString(igralec_tekma.skoki));
      k_OgledTekme.bloki.setText(Integer.toString(igralec_tekma.bloki));
      k_OgledTekme.ukradene.setText(Integer.toString(igralec_tekma.ukradene_zoge));
      k_OgledTekme.izgubljene.setText(Integer.toString(igralec_tekma.izgubljene_zoge));
      // TODO: implement
      return null;
   }
}