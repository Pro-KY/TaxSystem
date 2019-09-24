package ua.training.service;

public class ServiceFactory {

    public static TaxTypeService getTaxTypeService() {
        return TaxTypeService.getInstance();
    }

}
