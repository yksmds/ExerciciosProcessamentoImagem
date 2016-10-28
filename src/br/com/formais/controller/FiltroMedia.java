package br.com.formais.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

@ManagedBean(name="filtroMedia")
@ViewScoped
public class FiltroMedia implements Serializable{
   private static final long serialVersionUID=1L;
   
   public String caminhoImagem (){

	  FacesContext facesContext = FacesContext.getCurrentInstance();
	  ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

	  String contexto = scontext.getRealPath("")+"\\resources\\images\\";
	  return contexto;
   }
   
   public void filtroMedia() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "vaso1.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  
	  for(int lin=1; lin < h-2; lin++) {
		 for(int col=1; col < w-2; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0] = px1; p[1] = px2; p[2]=px3; p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int media = mediaPx(p);
			   newImage.setRGB(col, lin, media);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "PNG" , new File(caminhoImagem() + "filtroMedia.png"));
   }
   
   public int mediaPx(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  for(int i=0; i<p.length;i++){
		  blue[i] = p[i] & 0xFF;
		  green[i] = (p[i] >> 8) & 0xFF; 
		  red[i] = (p[i] >> 16) & 0xFF; 
	  }
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }
	  
	  Color media = new Color((mediaRed/9) , (mediaGreen/9) , (mediaBlue/9));
	  return media.getRGB();	  
   }
}
