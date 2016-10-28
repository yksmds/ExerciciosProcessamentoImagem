package br.com.formais.controller;

public class Coordenadas{
   private int X;
   private int Y;
   
   public Coordenadas(int x, int y) {
	  this.X = x;
	  this.Y = y;
   }
   
   public int getX() {
      return X;
   }
   public void setX(int x) {
      X=x;
   }
   public int getY() {
      return Y;
   }
   public void setY(int y) {
      Y=y;
   }
   
   
}
