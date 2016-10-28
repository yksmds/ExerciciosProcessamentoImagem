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

@ManagedBean(name="laplaciano")
@ViewScoped
public class Laplaciano implements Serializable{
   private static final long serialVersionUID=1L;
   
   public String caminhoImagem (){

	  FacesContext facesContext = FacesContext.getCurrentInstance();
	  ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

	  String contexto = scontext.getRealPath("")+"\\resources\\images\\";
	  return contexto;
   }
   
   public void maskOne() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "este.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  
	  for(int lin=1; lin < h-1; lin++) {
		 for(int col=1; col < w-1; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0]=px1; p[1]=px2; p[2]=px3; 
			   p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int media = aplymaskOne(p);
			   newImage.setRGB(col, lin, media);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "JPG" , new File(caminhoImagem() + "maskone.jpg"));
   }
   
   public void maskTwo() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "este.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
	  
	  for(int lin=1; lin < h-1; lin++) {
		 for(int col=1; col < w-1; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0]=px1; p[1]=px2; p[2]=px3; 
			   p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int media = aplymaskTwo(p);
			   newImage.setRGB(col, lin, media);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "JPG" , new File(caminhoImagem() + "masktwo.jpg"));
   }
   
   public void maskTree() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "este.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  
	  for(int lin=1; lin < h-1; lin++) {
		 for(int col=1; col < w-1; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0]=px1; p[1]=px2; p[2]=px3; 
			   p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int media = aplymaskTree(p);
			   newImage.setRGB(col, lin, media);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "JPG" , new File(caminhoImagem() + "masktree.jpg"));
   }
   
   public void maskFor() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "este.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  
	  for(int lin=1; lin < h-1; lin++) {
		 for(int col=1; col < w-1; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0]=px1; p[1]=px2; p[2]=px3; 
			   p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int media = aplymaskFor(p);
			   newImage.setRGB(col, lin, media);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "JPG" , new File(caminhoImagem() + "maskfor.jpg"));
   }
   
   public int aplymaskOne(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  for(int i=0; i<p.length;i++){
		 if(i == 4){
			int aux;
			aux = (p[i] >> 16) & 0xFF;
			red[i] = aux * (-4);
			green[i] =(p[i] >> 8) & 0xFF; 
			green[i] = green[i] * (-4);
			blue[i] = p[i] & 0xFF;
			blue[i] = blue[i] * (-4);
		 }
		 else {
			if(i%2 == 0){
      			red[i] = (p[i] >> 16) & 0xFF *0;
      			green[i] = (p[i] >> 8) & 0xFF *0;
      			blue[i] = p[i] & 0xFF *0;
			}
			else{
			   red[i] = (p[i] >> 16) & 0xFF;
			   green[i] = (p[i] >> 8) & 0xFF;
			   blue[i] = p[i] & 0xFF;
			}
		 }
	  }
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
   
   public int aplymaskTwo(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  for(int i=0; i<p.length;i++){
		 if(i == 4){
			int aux;
			aux = (p[i] >> 16) & 0xFF;
			red[i] = aux * (-8);
			green[i] =(p[i] >> 8) & 0xFF; 
			green[i] = green[i] * 8;
			blue[i] = p[i] & 0xFF;
			blue[i] = blue[i] * 8;
		 }
		 else {
			red[i] = (p[i] >> 16) & 0xFF;
			green[i] = (p[i] >> 8) & 0xFF;
			blue[i] = p[i] & 0xFF;
		 }
	  }
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
   
   public int aplymaskTree(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  for(int i=0; i<p.length;i++){
		 if(i == 4){
			int aux;
			aux = (p[i] >> 16) & 0xFF;
			red[i] = aux * (4);
			green[i] =(p[i] >> 8) & 0xFF; 
			green[i] = green[i] *4;
			blue[i] = p[i] & 0xFF;
			blue[i] = blue[i] *4;
		 }
		 else {
			if(i%2 == 0){
      			red[i] = ((p[i] >> 16) & 0xFF) *0;
      			green[i] = ((p[i] >> 8) & 0xFF) *0;
      			blue[i] = (p[i] & 0xFF) *0;
			}
			else{
			   red[i] = ((p[i] >> 16) & 0xFF) *(-1);
			   green[i] = ((p[i] >> 8) & 0xFF) *(-1);
			   blue[i] = (p[i] & 0xFF) *(-1);
			}
		 }
	  }
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
   public int aplymaskFor(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  for(int i=0; i<p.length;i++){
		 if(i == 4){
			red[i] = ((p[i] >> 16) & 0xFF) *(8);
			green[i] =((p[i] >> 8) & 0xFF) * (8); 
			blue[i] = (p[i] & 0xFF) * (8);
		 }
		 else {
			red[i] = ((p[i] >> 16) & 0xFF) *(-1);
			green[i] = ((p[i] >> 8) & 0xFF) *(-1);
			blue[i] = (p[i] & 0xFF) *(-1);
		 }
	  }
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
   
   public void sobel() throws IOException{
	  BufferedImage imagemOriginal=ImageIO.read(new File(caminhoImagem() + "este.jpg"));
	  int w=imagemOriginal.getWidth();
	  int h=imagemOriginal.getHeight();
	  BufferedImage newImage=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  
	  for(int lin=1; lin < h-1; lin++) {
		 for(int col=1; col < w-1; col++) {
			try {
			   int[] p = new int[9];
			   int px1 = imagemOriginal.getRGB(col-1 , lin-1);
			   int px4 = imagemOriginal.getRGB(col-1 , lin);
			   int px7 = imagemOriginal.getRGB(col-1 , lin+1);
			   
			   int px2 = imagemOriginal.getRGB(col , lin-1);
			   int px5 = imagemOriginal.getRGB(col , lin);
			   int px8 = imagemOriginal.getRGB(col , lin+1);
			   
			   int px3 = imagemOriginal.getRGB(col+1 , lin-1);
			   int px6 = imagemOriginal.getRGB(col+1 , lin);
			   int px9 = imagemOriginal.getRGB(col+1 , lin+1);
			   
			   p[0]=px1; p[1]=px2; p[2]=px3; 
			   p[3]=px4; p[4]=px5; p[5]=px6;
			   p[6]=px7; p[7]=px8; p[8]=px9;
			   
			   int sobelX = aplySobelX(p);
			   newImage.setRGB(col, lin, sobelX);

			}catch (Exception e) {
			   System.out.println("Col: " + col + "Linha: " + lin);
			}
		 }
	  }
	  
	  ImageIO.write(newImage , "JPG" , new File(caminhoImagem() + "sobel.jpg"));
   }
   public int aplySobelX(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  red[0] = ((p[0] >> 16) & 0xFF) *(-1);
	  green[0] = ((p[0] >> 8) & 0xFF) *(-1);
	  blue[0] = (p[0] & 0xFF) *(-1);
	  
	  red[1] = ((p[1] >> 16) & 0xFF) *(-2);
	  green[1] = ((p[1] >> 8) & 0xFF) *(-2);
	  blue[1] = (p[1] & 0xFF) *(-2);
	  
	  red[2] = ((p[2] >> 16) & 0xFF) *(-1);
	  green[2] = ((p[2] >> 8) & 0xFF) *(-1);
	  blue[2] = (p[2] & 0xFF) *(-1);
	  
	  red[3] = ((p[3] >> 16) & 0xFF) *(0);
	  green[3] = ((p[3] >> 8) & 0xFF) *(0);
	  blue[3] = (p[3] & 0xFF) *(0);
	  
	  red[4] = ((p[4] >> 16) & 0xFF) *(0);
	  green[4] = ((p[4] >> 8) & 0xFF) *(0);
	  blue[4] = (p[4] & 0xFF) *(0);
	  
	  red[5] = (p[5] >> 16) & 0xFF *(0);
	  green[5] = (p[5] >> 8) & 0xFF *(0);
	  blue[5] = p[5] & 0xFF *(0);
	  
	  red[6] = (p[6] >> 16) & 0xFF;
	  green[6] = (p[6] >> 8) & 0xFF;
	  blue[6] = p[6] & 0xFF;
	
	  red[7] = ((p[7] >> 16) & 0xFF) *2;
	  green[7] = ((p[7] >> 8) & 0xFF) *2;
	  blue[7] = (p[7] & 0xFF) *2;
	  
	  red[8] = (p[8] >> 16) & 0xFF;
	  green[8] = (p[8] >> 8) & 0xFF;
	  blue[8] = p[8] & 0xFF;
	  
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
   
   public int aplySobelY(int[] p) {
	  int[] blue = new int[9];
	  int[] red = new int[9];
	  int[] green = new int[9];
	  
	  red[0] = ((p[0] >> 16) & 0xFF) *(-1);
	  green[0] = ((p[0] >> 8) & 0xFF) *(-1);
	  blue[0] = (p[0] & 0xFF) *(-1);
	  
	  red[1] = ((p[1] >> 16) & 0xFF) *(0);
	  green[1] = ((p[1] >> 8) & 0xFF) *(0);
	  blue[1] = (p[1] & 0xFF) *(0);
	  
	  red[2] = ((p[2] >> 16) & 0xFF) *(1);
	  green[2] = ((p[2] >> 8) & 0xFF) *(1);
	  blue[2] = (p[2] & 0xFF) *(1);
	  
	  red[3] = ((p[3] >> 16) & 0xFF) *(-2);
	  green[3] = ((p[3] >> 8) & 0xFF) *(-2);
	  blue[3] = (p[3] & 0xFF) *(-2);
	  
	  red[4] = (p[4] >> 16) & 0xFF *(0);
	  green[4] = (p[4] >> 8) & 0xFF *(0);
	  blue[4] = p[4] & 0xFF *(0);
	  
	  red[5] = (p[5] >> 16) & 0xFF *(2);
	  green[5] = (p[5] >> 8) & 0xFF *(2);
	  blue[5] = p[5] & 0xFF *(2);
	  
	  red[6] = ((p[6] >> 16) & 0xFF) *(-1);
	  green[6] = ((p[6] >> 8) & 0xFF) *(-1);
	  blue[6] = (p[6] & 0xFF) *(-1);
	
	  red[7] = (p[7] >> 16) & 0xFF *0;
	  green[7] = (p[7] >> 8) & 0xFF *0;
	  blue[7] = p[7] & 0xFF *0;
	  
	  red[8] = (p[8] >> 16) & 0xFF;
	  green[8] = (p[8] >> 8) & 0xFF;
	  blue[8] = p[8] & 0xFF;
	  
	  
	  int mediaRed=0;
	  int mediaGreen=0;
	  int mediaBlue=0;
	  
	  for(int i=0;i<p.length;i++){
		 mediaRed = mediaRed + red[i];
		 mediaBlue = mediaBlue + blue[i];
		 mediaGreen = mediaGreen + green[i];
	  }

	  mediaRed = Math.min(255, Math.max(0 , mediaRed));
	  mediaGreen = Math.min(255, Math.max(0 , mediaGreen));
	  mediaBlue = Math.min(255, Math.max(0 , mediaBlue));
	  
	  Color media = new Color(mediaRed, mediaGreen, mediaBlue);
	  return media.getRGB();	  
   }
}
