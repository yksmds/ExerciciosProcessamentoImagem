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


@ManagedBean(name="operacoesAritmeticas")
@ViewScoped
public class OperacoesAritmeticas implements Serializable{
   private static final long serialVersionUID=1490871110407247360L;
  
   public String caminhoImagem (){

	  FacesContext facesContext = FacesContext.getCurrentInstance();
	  ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

	  String contexto = scontext.getRealPath("")+"\\resources\\images\\";
	  return contexto;
   }

   /******************* SOMA DE IMAGENS *****************/
   public void somar() {
	  try {
		 
		 String contexto = caminhoImagem();
		 
		 BufferedImage imagemOriginal=ImageIO.read(new File(contexto + "vaso1.jpg"));
		 BufferedImage imagemProcessada=ImageIO.read(new File(contexto + "vasowhiteblack.jpg"));
		 int w=imagemOriginal.getWidth();
		 int h=imagemOriginal.getHeight();
		 
		 BufferedImage imagemSoma=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		 
		 for(int lin=0; lin < h; lin++) {
			for(int col=0; col < w; col++) {
			   try {
				  imagemSoma.setRGB(col , lin , gsoma(imagemOriginal.getRGB(col , lin), imagemProcessada.getRGB(col , lin)));
			   }catch (Exception e) {
				  System.out.println("Col: " + col + "Linha: " + lin);
			   }
			}
		 }
		 
		 ImageIO.write(imagemSoma , "PNG" , new File(contexto + "gsoma.png"));
	  
	  } catch (IOException e) {
		 e.printStackTrace();
		 System.out.println(e.getMessage());
	  }
   }
   public int gsoma(int a, int b) {
	  int bluea = a & 0xFF;
	  int grena = (a >> 8) & 0xFF; 
	  int reda = (a >> 16) & 0xFF; 

	  int blueb = b & 0xFF;
	  int grenb = (b >> 8) & 0xFF; 
	  int redb = (b >> 16) & 0xFF; 
	  
	  int mediaRed = (reda + redb)/2;
	  int mediaGreen = (grena + grenb)/2;
	  int mediaBlue = (bluea + blueb)/2;
	  
	  Color media = new Color(Math.abs(mediaRed) , Math.abs(mediaGreen) , Math.abs(mediaBlue));
	  return media.getRGB();	  
   }
   
   
   
   /******************* SUBTRAÇÃO DE IMAGENS *****************/
   public int subtract(int color1, int color2) {
      Color c1 = new Color(color1);
      Color c2 = new Color(color2);
      int r = Math.max(0, c1.getRed() - c2.getRed());
      int g = Math.max(0, c1.getGreen() - c2.getGreen());
      int b = Math.max(0, c1.getBlue() - c2.getBlue());
      return new Color(r, g, b).getRGB();
  }
  public BufferedImage subtract(BufferedImage img1, BufferedImage img2) {
      BufferedImage out = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
      for (int y = 0; y < img1.getHeight(); y++)
          for (int x = 0; x < img1.getWidth(); x++)
              out.setRGB(x, y, subtract(img1.getRGB(x, y), img2.getRGB(x, y)));
      return out;
  }
  public void subtracao() throws IOException {
      BufferedImage img1 = ImageIO.read(new File(caminhoImagem() + "img1.jpg"));
      BufferedImage img2 = ImageIO.read(new File(caminhoImagem() + "img2.jpg"));
      
      ImageIO.write(subtract(img2, img1), "png", new File(caminhoImagem() + "out.png"));
  }
  
  
  /******************* ESPELHAMENTO DE IMAGENS *****************/
  public void espelharVertical() throws IOException {
     BufferedImage img1 = ImageIO.read(new File(caminhoImagem() + "vaso1.jpg"));
     ImageIO.write(inverte(img1), "png", new File(caminhoImagem() + "espelho.png"));
 }
  
  public BufferedImage inverte(BufferedImage img) {
	 BufferedImage espelho = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
	 int contL = 0;
	 int contC = 0;
	 for (int y = 0; y < img.getHeight(); y++){
        for (int x = 0; x < img.getWidth(); x++){
            espelho.setRGB((img.getWidth()-1) - contC, (img.getHeight()-1) - contL, img.getRGB(x,y));
            contC++;
        }

        
	 contL++;
	 contC = 0;
	 }
	 return espelho;
  }
  
  
 public void negativoImagem() throws IOException {
     BufferedImage img1 = ImageIO.read(new File(caminhoImagem() + "img1.jpg"));
     ImageIO.write(negativo(img1), "png", new File(caminhoImagem() + "negativo.png"));
 }
  public static BufferedImage negativo(BufferedImage image) {
     int width = image.getWidth();
     int height = image.getHeight();
     for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {               
        	int rgb = image.getRGB(i, j);              
        	
        	//a cor inversa é dado por 255 menos o valor da cor                 
        	int r = 255 - (int)((rgb&0x00FF0000)>>>16);
        	int g = 255 - (int)((rgb&0x0000FF00)>>>8);
        	int b = 255 - (int) (rgb&0x000000FF);
            
        	Color color = new Color(r, g, b);
        	image.setRGB(i, j, color.getRGB());
         }
     }
     return image;
 }
   

}
