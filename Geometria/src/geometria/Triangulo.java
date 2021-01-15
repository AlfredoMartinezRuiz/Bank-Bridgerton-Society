
package geometria;

import static java.lang.Math.pow;

public class Triangulo { // Usando triángulos isóseles
    private String nombre;
    private Punto A;
    private Punto B;
    private Punto C;

    //Ejemplo de constructor de la clase Rectangulo
    public Triangulo(){
        A = new Punto(3, 5);
        B = new Punto(2, 2);
        C = new Punto(4, 2);
        nombre = "T";
    }
    public Triangulo(String nom, Punto a, Punto b, Punto c){
        A = a;
        B = b;
        C = c;
        nombre = nom;
    }
    public Triangulo(String nom){
        A = new Punto(1, 1);
        B = new Punto(2,2);
        C = new Punto(3, 3);
        nombre = nom;
    }
    public Triangulo(Triangulo t){
        A = t.A;
        B = t.B;
        C = t.C;
        nombre = t.nombre;
    }
    public Triangulo(Punto a, Punto b, Punto c){
        A = a;
        B = b;
        C = c;
        nombre = "T";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setA(Punto A) {
        this.A = A;
    }

    public void setB(Punto B) {
        this.B = B;
    }
    
    public void setC(Punto B) {
        this.B = B;
    }
    
    public String toString(){
        return nombre + ": [" + A.toString()+ ", " + B.toString()+ ", " + C.toString() + "]";
    }
    
  
    public Triangulo interseccion(Triangulo t2){
        // Identificicamos si hay algún punto que esté dentro del triángulo o viceversa
        double m_recta1;
        double m_recta2;
        double y_recta1;
        double y_recta2;
        double x_punto;
        double y_punto;
        double base;
        
        // Primero vemos si el otro triángulo tiene puntos dentro de este
        m_recta1 = (t2.A.y - t2.B.y) / (t2.A.x - t2.B.x); // Para la recta de B a A en externo
        m_recta2 = (t2.A.y - t2.C.y) / (t2.A.x - t2.C.x); // Para la recta de C a A en externo
        base = t2.C.x - t2.B.x;

        // Comprobando puntos
        
        // Para A de this *******---------**********
        x_punto = this.A.x;
        y_punto = this.A.y;
        
        if((t2.B.x <= x_punto && x_punto <= t2.C.x) && y_punto >= t2.C.y){
            if(x_punto == t2.A.x){ // Si x_punto está al nivel que A
                if(y_punto == t2.A.y){ // Si x punto está a la altura que A
                    y_recta1 = m_recta1*(x_punto - t2.A.x) - t2.A.y;
                }
            }
            else if(x_punto < t2.A.x){ // Si x_punto está antes que A
                if(y_punto < t2.A.y){ // Si x punto está debajo de la altura de A
                    // Sí está antes de A
                }
                else{
                    // No está antes de A
                }
            }
            else{
                if(y_punto < t2.A.y){ // Si x punto está debajo de la altura de A
                    // Sí está antes de A
                }
                else{
                    // No está antes de A
                }
            }
        }
        
        
        
        y_recta1 = m_recta1*(x_punto - t2.A.x) - t2.A.y;
        y_recta2 = m_recta2*(x_punto - t2.A.x) - t2.A.y;
        
        return t2;
        
    }
    
    public boolean estaAdentro(Punto A){
        // Identificicamos si hay algún punto que esté dentro del triángulo o viceversa
        double x_punto;
        double y_punto;
        
        x_punto = A.x;
        y_punto = A.y;
        
        if((this.B.x <= x_punto && x_punto <= this.C.x) && y_punto >= this.C.y)
            if(x_punto == this.A.x) // Si x_punto está al nivel que A
                if(y_punto == this.A.y)// Si x punto está a la altura que A
                    return true;
                
            else if(x_punto < this.A.x) // Si x_punto está antes que A
                if(y_punto < this.A.y) // Si x punto está debajo de la altura de A
                    return true;
                else
                    return false;
            
            else
                if(y_punto < this.A.y) // Si x punto está debajo de la altura de A
                    return true;               
                else
                    return false;           
        else
            return false;
        
        return true;        
    }
    
    public double areaT(){
        double a, b, altura;
        b = C.x - B.x;
        
        // Calculando el lado a 
        a = B.distancia(A);
        
        // Calculando altura 
        double aux = pow(a, 2) - (pow(b, 2)/4);
        altura = (double) pow(aux, 0.5);
        
        return b*altura/2;
    }
    
    public int comparar(Triangulo t2){
        if(this.areaT() < t2.areaT())
            return -1;
        
        else if(this.areaT() > t2.areaT())
            return 1;
        
        else
            return 0;
    }
    
    public int compararRec(Rectangulo r){
        if(this.areaT() < r.areaR())
            return -1;
        
        else if(this.areaT() > r.areaR())
            return 1;
        
        else
            return 0;
    }
    
    public void moverRect(Punto a, Punto b, Punto c){
        A = a;
        B = b;
        C = c;
    }
    
    public int cuadTri(){
        Punto aux = new Punto(A.x, A.y);
        
        return aux.cuadrante();
    }
}