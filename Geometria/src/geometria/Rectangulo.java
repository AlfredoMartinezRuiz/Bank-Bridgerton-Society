package geometria;

public class Rectangulo {
    private String nombre;
    private Punto A;
    private Punto B;

    //Ejemplo de constructor de la clase Rectangulo
    public Rectangulo(){
        A = new Punto(1, 1);
        B = new Punto(2,2);
        nombre = "Incógnito";
    }
    public Rectangulo(String nom, Punto a, Punto b){
        A = a;
        B = b;
        nombre = nom;
    }
    public Rectangulo(String nom){
        A = new Punto(1, 1);
        B = new Punto(2,2);
        nombre = nom;
    }
    public Rectangulo(Rectangulo r){
        A = r.A;
        B = r.B;
        nombre = r.nombre;
    }
    public Rectangulo(Punto a, Punto b){
        A = a;
        B = b;
        nombre = "Incognito";
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
    
    public String toString(){
        return nombre + ": [" + A.toString()+ "," + B.toString()+"]";
    }
    public Rectangulo union(Rectangulo r2){
        Punto aux = new Punto(1,1);
        Punto aux2 = new Punto(1,1);
        Rectangulo auxR = new Rectangulo();
        int cx = 0, cy = 0;
        // Para el punto inferior
        cx = A.comparadorX(r2.A);
        cy = A.comparadorY(r2.A);
        
        if(cx == 1)
            aux.setX(A.getX());
        else
            aux.setX(r2.A.getX());
        
        if(cy == 1)
            aux.setY(A.getY());
        else
            aux.setY(r2.A.getY());
        aux.setNom("P1");
        auxR.setA(aux);
        
        // Para el punto superior
        cx = B.comparadorX(r2.B); 
        cy = B.comparadorY(r2.B);
        if(cx == -1)
            aux2.setX(B.getX());
        else
            aux2.setX(r2.B.getX());
        
        if(cy == -1)
            aux2.setY(B.getY());
        else
            aux2.setY(r2.B.getY());
        aux2.setNom("P2");
        auxR.setB(aux2);
        auxR.setNombre("Union");
        return auxR;
    }
    public Rectangulo interseccion(Rectangulo r2){
        Punto aux = new Punto(1,1);
        Punto aux2 = new Punto(1,1);
        Rectangulo auxR = new Rectangulo();
        int cx = 0, cy = 0;
        // Para el punto inferior
        cx = A.comparadorX(r2.A);
        cy = A.comparadorY(r2.A);
        
        if(cx == -1)
            aux.setX(A.getX());
        else
            aux.setX(r2.A.getX());
        
        if(cy == -1)
            aux.setY(A.getY());
        else
            aux.setY(r2.A.getY());
        aux.setNom("P1");
        auxR.setA(aux);
        
        // Para el punto superior
        cx = B.comparadorX(r2.B); 
        cy = B.comparadorY(r2.B);
        if(cx == 1)
            aux2.setX(B.getX());
        else
            aux2.setX(r2.B.getX());
        
        if(cy == 1)
            aux2.setY(B.getY());
        else
            aux2.setY(r2.B.getY());
        aux2.setNom("P2");
        auxR.setB(aux2);
        auxR.setNombre("Interseccion");
        return auxR;
    }
    
    public boolean estaAdentro(Punto a){
        if(A.x <= a.getX() && a.getX() <= B.x)
            if(A.y <= a.getY() && a.getY() <= B.y)
                return true;

        return false;
    }
    
    private float areaR(){
        float altura, base;
        altura = B.y - A.y;
        base = B.x - A.x;
        return base*altura;
    }
    
    public int comparar(Rectangulo r2){
        if(this.areaR() < r2.areaR())
            return -1;
        
        if(this.areaR() > r2.areaR())
            return 1;
        
        else
            return 0;
    }
    
    public void moverRect(Punto a, Punto b){
        A = a;
        B = b;
    }
    
    public int cuadRect(){
        Punto aux = new Punto(A.x,B.y);
        
        return aux.cuadrante();
    }
}
