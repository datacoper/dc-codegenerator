<#assign formManagerName = "form"+model.classNameBasic+"Manager">
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://xmlns.jcp.org/jsf/html"
    xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
    xmlns:p="http://primefaces.org/ui"
    xmlns:f="http://xmlns.jcp.org/jsf/core"
    xmlns:dc="http://xmlns.jcp.org/jsf/composite/component">

    <ui:composition template="/componente/crud/formGenerico.xhtml">
        <ui:param name="formGenericManager" value=${r"#{" + formManagerName + "}"}/>
        <ui:define name="metadata"> 
            <f:metadata> 
                <ui:param name="formGenericManager" value=${r"#{" + formManagerName + "}"}/> 
            </f:metadata> 
        </ui:define>
    </ui:composition>
</html>