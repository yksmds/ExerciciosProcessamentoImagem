package br.com.formais.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="trabalhoDois")
@ViewScoped
public class TrabalhoDois implements Serializable{
   private static final long serialVersionUID=1490871110407247360L;
   
   private String campox1;
   private String campox2;
   private String campoy1;
   private String campoy2;
   
   public String getCampox1() {
      return campox1;
   }

   public void setCampox1(String campox1) {
      this.campox1=campox1;
   }

   public String getCampox2() {
      return campox2;
   }

   public void setCampox2(String campox2) {
      this.campox2=campox2;
   }

   public String getCampoy1() {
      return campoy1;
   }

   public void setCampoy1(String campoy1) {
      this.campoy1=campoy1;
   }

   public String getCampoy2() {
      return campoy2;
   }

   public void setCampoy2(String campoy2) {
      this.campoy2=campoy2;
   }


   public void distanciaEuclidiana() {
	  try {

		 Integer x1 = Integer.parseInt(campox1);
		 Integer x2 = Integer.parseInt(campox2);
		 Integer y1 = Integer.parseInt(campoy1);
		 Integer y2 = Integer.parseInt(campoy2);
		 
		 int p = (x1-x2)^2;
		 
		 int q = (y1-y2)^2;
		 
		 double resultado = Math.sqrt(p+q);
		 System.out.println(resultado);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			 FacesMessage.SEVERITY_INFO, "SUCESSO!", "O RESULTADO É " + resultado));
		 
	  }catch(Exception e){
		 e.getCause();
		 e.getMessage();
	  }
   }
   
   public void distanciaD4() {
	  try {

		 Integer x1 = Integer.parseInt(campox1);
		 Integer x2 = Integer.parseInt(campox2);
		 Integer y1 = Integer.parseInt(campoy1);
		 Integer y2 = Integer.parseInt(campoy2);
		 
		 int p = (x1-x2);
		 p = Math.abs(p);
		 
		 int q = (y1-y2);
		 q = Math.abs(q);
		 
		 int resultado = p+q;
		 System.out.println(resultado);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			 FacesMessage.SEVERITY_INFO, "SUCESSO!", "O RESULTADO É " + resultado));
		 
	  }catch(Exception e){
		 e.getCause();
		 e.getMessage();
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			 FacesMessage.SEVERITY_ERROR, "Error!", "Não foi possível realizar operação!"));
	  }
   }
   
   public void distanciaD8() {
	  try {

		 Integer x1 = Integer.parseInt(campox1);
		 Integer x2 = Integer.parseInt(campox2);
		 Integer y1 = Integer.parseInt(campoy1);
		 Integer y2 = Integer.parseInt(campoy2);
		 
		 int p = (x1-x2);
		 p = Math.abs(p);
		 
		 int q = (y1-y2);
		 q = Math.abs(q);
		 
		 int resultado = 0;
		 if (p >= q) {
			resultado = p;
		 }
		 else 
			resultado = q;
		 
		 System.out.println(resultado);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			 FacesMessage.SEVERITY_INFO, "SUCESSO!", "O RESULTADO É " + resultado));
		 
	  }catch(Exception e){
		 e.getCause();
		 e.getMessage();
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
			 FacesMessage.SEVERITY_ERROR, "Error!", "Não foi possível realizar operação!"));
	  }
   }

}
