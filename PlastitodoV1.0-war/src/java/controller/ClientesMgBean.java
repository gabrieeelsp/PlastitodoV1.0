/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Cliente;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author gabrieeelsp
 */
@Named(value = "clientesMgBean")
@RequestScoped
public class ClientesMgBean implements Serializable{

    private Cliente cliente;
    public ClientesMgBean() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void registrar(){
        boolean resp = false;
        FacesMessage message = null;
        if(cliente.getNombre().equals("gabriel")){
            resp = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El cliente se há registrado correctamente.", "");
        }else{
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se ha producido un error. \n No se han guardado los cambios.", "");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("isRegistrado", resp);
    }
    
    
}
