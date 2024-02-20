package com.ceica.restcountriesfx;

import com.ceica.restcountriesfx.Models.CountryDTO;
import com.ceica.restcountriesfx.Services.FakeRestCountriesService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.lang.annotation.Target;

public class RestCountriesController {
  @FXML
  protected ComboBox comboRegions;
  @FXML
    protected TableView<CountryDTO> tblCountries;
  @FXML
    protected TableColumn<CountryDTO,String> countryNameColumn;
  @FXML
    protected ImageView imgFlag;
  @FXML
    protected TextField txtCountryName;
  @FXML
    protected TextField txtCountryPopulation;
  @FXML
    protected TextField txtCountryCapital;
  @FXML
    protected TextField txtCountryCoin;
@FXML
  public void initialize(){
  FakeRestCountriesService fakeRestCountriesService=new FakeRestCountriesService();
    comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
    comboRegions.setOnAction(e->{
      String region=comboRegions.getSelectionModel().getSelectedItem().toString();
      ObservableList<CountryDTO> observableList= FXCollections.observableArrayList();
      observableList.addAll(fakeRestCountriesService.getCoutriesByRegion(region));
      tblCountries.setItems(observableList);
    });
    countryNameColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getName()));
  }
  @FXML
    public void btnClear(ActionEvent actionEvent) {
    }
}