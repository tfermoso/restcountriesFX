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
    protected TableColumn<CountryDTO, String> countryNameColumn;
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
    private ObservableList<CountryDTO> observableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        FakeRestCountriesService fakeRestCountriesService = new FakeRestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
        comboRegions.setOnAction(e -> {
            if (comboRegions.getSelectionModel().getSelectedItem() != null) {
                String region = comboRegions.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCoutriesByRegion(region));
                tblCountries.setItems(observableList);
            }
        });
        tblCountries.setOnMouseClicked(e->{
            String countryName=tblCountries.getSelectionModel().getSelectedItem().getName();
            CountryDTO countryDTO=fakeRestCountriesService.getCountryByName(countryName);
        });
        countryNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
    }

    @FXML
    public void btnClear(ActionEvent actionEvent) {
        observableList.clear();
        tblCountries.refresh();
        comboRegions.getSelectionModel().clearSelection();
    }
}