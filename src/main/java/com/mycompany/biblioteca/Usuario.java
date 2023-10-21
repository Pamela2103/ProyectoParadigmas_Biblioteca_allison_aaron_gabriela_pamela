package com.mycompany.biblioteca;

import javafx.beans.property.SimpleStringProperty;import javafx.beans.property.StringProperty;

public class Usuario {
    private final StringProperty id = new SimpleStringProperty();    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty lastNameP = new SimpleStringProperty();    private final StringProperty lastNameM = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();    private final StringProperty phone = new SimpleStringProperty();
    public Usuario(String id, String name, String lastNameP, String lastNameM, String address, String phone) {
        this.id.set(id);        this.name.set(name);
        this.lastNameP.set(lastNameP);        this.lastNameM.set(lastNameM);
        this.address.set(address);        this.phone.set(phone);
    }
    public StringProperty idProperty() {        return id;
    }
    public StringProperty nameProperty() {        return name;
    }
    public StringProperty lastNamePProperty() {        return lastNameP;
    }
    public StringProperty lastNameMProperty() {        return lastNameM;
    }
    public StringProperty addressProperty() {        return address;
    }
    public StringProperty phoneProperty() {        return phone;
    }
    public String getId() {        return id.get();
    }
    public void setId(String id) {        this.id.set(id);
    }
    public String getNombre() {        return name.get();
    }
    public void setNombre(String nombre) {        this.name.set(nombre);
    }
    public String getApellidoPaterno() {        return lastNameP.get();
    }
    public void setApellidoPaterno(String apellidoPaterno) {        this.lastNameP.set(apellidoPaterno);
    }
    public String getApellidoMaterno() {        return lastNameM.get();
    }
    public void setApellidoMaterno(String apellidoMaterno) {        this.lastNameM.set(apellidoMaterno);
    }
    public String getDomicilio() {
        return address.get();    }
    public void setDomicilio(String domicilio) {
        this.address.set(domicilio);    }
    public String getTelefono() {
        return phone.get();    }
    public void setTelefono(String telefono) {
        this.phone.set(telefono);    }
    Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); 
}
}