
package br.com.formais.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

/*Threshold =>
 * Supondo uma imagem f(x,y) em tons de cinza, a mesma pode ser dividida em duas partes:
 *     - Background
 *     - Foreground
 * T (threshold) eh um tom de cinza que separa essas duas regioes
 * 
 * Algoritmo =>
 * 1. Selecione uma estimativa inicial para T
 * 2. Segmente a imagem usando T
 *		Isso vai produzir dois grupos de pixels:
 *		G1 - todos os pixels com os niveis de cinza <  T
 *		G2 - todos os pixels com os niveis de cinza >= T
 * 3. Para cada grupo calcule o nivel de cinza medio (u1 e u2)
 * 4. Calcule o novo limiar -> T = (u1 + u2)/2
 * 5. Repita os passos de 2 a 4 ate que a diferenca entre sucessivos Ts seja menor do que um parametro T0
 */
public class Threshold{
   
   private BufferedImage image;
   private ArrayList<Coordenadas> grupo1;
   private ArrayList<Coordenadas> grupo2;
   private int t;
   private double t0;
   
   int BLACK=Color.BLACK.getRGB();
   int WHITE=Color.WHITE.getRGB();

   public Threshold(String fileName, double t0) throws IOException {
	  this.image=ImageIO.read(new File(caminhoImagem() + "black-and-white.jpg"));
	  this.grupo1=new ArrayList<Coordenadas>();
	  this.grupo2=new ArrayList<Coordenadas>();
	  this.t=(int) Math.floor(this.calcularMedia(this.image));
	  this.t0=t0;
   }

   public BufferedImage execThreshold() {
	  boolean terminou=false;
	  while (!terminou) {
		 this.separar();
		 float mediaCinzag1=this.calcularMedia(this.grupo1);
		 float mediaCinzag2=this.calcularMedia(this.grupo2);
		 int novoT=(int) Math.floor((mediaCinzag1 + mediaCinzag2) / 2);
		 if(Math.abs(novoT - this.t) <= this.t0) {
			terminou=true;
		 } else {
			this.t=novoT;
			this.grupo1=new ArrayList<Coordenadas>();
			this.grupo2=new ArrayList<Coordenadas>();
		 }
	  }
	  return this.gerarImagem();
   }

   public BufferedImage gerarImagem() {
	  BufferedImage result=this.image;
	  for(Coordenadas coord : this.grupo1) {
		 result.setRGB(coord.getX() , coord.getY() , BLACK);
	  }
	  for(Coordenadas coord : this.grupo2) {
		 result.setRGB(coord.getX() , coord.getY() , WHITE);
	  }
	  return result;
   }

   private void separar() {
	  for(int i=0; i < this.image.getHeight(); i++) {
		 for(int j=0; j < this.image.getWidth(); j++) {
			this.preecheGrupos(j , i);
		 }
	  }
   }

   private void preecheGrupos(int x, int y) {
	  Integer pixel=corPx(this.image.getRGB(x , y));
	  if(pixel < this.t) {
		 this.grupo1.add(new Coordenadas(x, y));
	  } else {
		 this.grupo2.add(new Coordenadas(x, y));
	  }
   }

   private float calcularMedia(BufferedImage im) {
	  float total=im.getHeight() * im.getWidth();
	  float media=0;
	  for(int i=0; i < im.getHeight(); i++) {
		 for(int j=0; j < im.getWidth(); j++) {
			media+=corPx(im.getRGB(j , i));
		 }
	  }
	  media=media / total;
	  return media;
   }

   private float calcularMedia(ArrayList<Coordenadas> g) {
	  float total=g.size();
	  float media=0;
	  for(Coordenadas coord : g) {
		 media+=corPx(this.image.getRGB(coord.getX() , coord.getY()));
	  }
	  media=media / total;
	  return media;
   }

   public static String caminhoImagem() {
	  String url = "C:\\Users\\Public\\";
	  return url;
   }

   int corPx(int a) {
	  int bluea=a & 0xFF;
	  int grena=(a >> 8) & 0xFF;
	  int reda=(a >> 16) & 0xFF;
	  int media=(reda + grena + bluea) / 3;

	  return media;
   }
   

   public static void main(String[] args) {
	  try {
		 Threshold t=new Threshold(caminhoImagem(), 108);
		 BufferedImage im=t.execThreshold();
		 ImageIO.write(im , "PNG" , new File(caminhoImagem() + "face_threshold.png"));
	  } catch (IOException e) {
		 e.printStackTrace();
	  }
   }
}
