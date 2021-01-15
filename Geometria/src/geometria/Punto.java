
package geometria;

import static java.lang.Math.pow;

public class Punto {
    int x;
    int y;
    private String nom;
    //Ejemplo de constructor de la clase Punto
    public Punto(String nom, int x, int y){
        this.x = x;
        this.y = y;
        this.nom = nom;
    }
    public Punto(String nom){
        x = y = 0;
        this.nom = nom;
    }
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
        nom = "P";
    }
 
    public String toString(){
        return nom + "(" + this.x +","+ this.y + ")";
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public String getNom(){
        return this.nom;
    }

    public float distancia(Punto p){
        float d = 0, x1 = 0, y1 = 0;
        x1 = this.x - p.x;
        x1 = (float) pow(x1,2.0);
        y1 = this.y - p.y;
        y1 = (float) pow(y1,2.0);
        d = x1 + y1;
        d = (float) pow(d,0.5);
        return d;
    }
    
    public float distancia(){
        float d = 0, x1 = 0, y1 = 0;
        x1 = this.x;
        x1 = (float) pow(x1,2.0);
        y1 = this.y;
        y1 = (float) pow(y1,2.0);
        d = x1 + y1;
        d = (float) pow(d,0.5);
        return d;
    }
    
    public int cuadrante(){
        if(this.x>0){
            if(this.y>0)
                return 1;
            else
                return 4;
        }
        else{
            if(this.y>0)
                return 2;
            else
                return 3;
        }
    }
    
    public int comparadorX(Punto b){
        if(this.x == b.x){
            return 0;
        }
        if(this.x > b.x){
            return -1;
        }
        else{
            return 1;
        }
    }
    public int comparadorY(Punto b){
        if(this.y == b.y){
            return 0;
        }
        if(this.y > b.y){
            return -1;
        }
        else{
            return 1;
        }
    }
}
