
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
        A = new Punto(1,1);
        B = new Punto(2,2);
        C = new Punto(3,3);
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
    
    @Override
    public String toString(){
        return nombre + ": [" + A.toString()+ ", " + B.toString()+ ", " + C.toString() + "]";
    }
    
    public Triangulo interseccion(Triangulo t2){
        // Identificicamos si hay algún punto que esté dentro del triángulo o viceversa
        double m_recta1;
        double m_recta2;
        double y_recta1; // a izquierda
        double y_recta2; // a derecha
        double x_punto;
        double y_punto;
        
        // Primero vemos si el otro triángulo tiene puntos dentro de este
        m_recta1 = (double)(t2.A.y - t2.B.y) / (t2.A.x - t2.B.x); // Para la recta de B a A en externo
        m_recta2 = (double)(t2.A.y - t2.C.y) / (t2.A.x - t2.C.x); // Para la recta de C a A en externo

        // Comprobando puntos
        
        // Para A de this *******---------**********
        x_punto = this.A.x;
        y_punto = this.A.y;
        
        if((t2.B.x <= x_punto && x_punto <= t2.C.x) && y_punto >= t2.C.y){
          
            if(x_punto == t2.A.x){ // Si x_punto está al nivel que A
                if(y_punto == t2.A.y){ // Si x punto está a la altura que A
                    if(this.C.x > t2.C.x && this.C.y < t2.C.y){ // Implica que el triángulo del punto esa más grande que t2
                        
                        return new Triangulo("I", t2.A, t2.B, t2.C);
                    }
                    return t2;
                }
                else{
                    
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de this para poder obtener B
                    double m_recta1_this = (double)(this.A.y - this.B.y) / (this.A.x - this.B.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    double co = this.A.y - t2.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(this.A.x-ca), (int)t2.B.y);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    double m_recta2_this = (double)(this.A.y - this.C.y) / (this.A.x - this.C.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(this.A.x+ca), (int)t2.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < t2.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - t2.A.x) + t2.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                    
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de this para poder obtener B
                    double m_recta1_this = (double)(this.A.y - this.B.y) / (this.A.x - this.B.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    double co = this.A.y - t2.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(this.A.x-ca), (int)t2.B.y);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    double m_recta2_this = (double)(this.A.y - this.C.y) / (this.A.x - this.C.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(this.A.x+ca), (int)t2.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);                  
                }
            }
            else{
                
                y_recta2 = m_recta2*(x_punto - t2.A.x) + t2.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de this para poder obtener B
                    double m_recta1_this = (double)(this.A.y - this.B.y) / (this.A.x - this.B.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    double co = this.A.y - t2.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(this.A.x-ca), (int)t2.B.y);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    double m_recta2_this = (double)(this.A.y - this.C.y) / (this.A.x - this.C.x); // Para la recta de B a A en this
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(this.A.x+ca), (int)t2.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        // Para B de this *******---------**********
        x_punto = this.B.x;
        y_punto = this.B.y;
        if((t2.B.x <= x_punto && x_punto <= t2.C.x) && y_punto >= t2.C.y){
           
            if(x_punto == t2.A.x){ // Si x_punto está al nivel que A
                if(y_punto == t2.A.y){ // Si x punto está a la altura que A
                    
                   return null;
                }
                else{
                    Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - t2.A.y) / m_recta2) + t2.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta2 = m_recta2*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < t2.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - t2.A.x) + t2.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                     Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - t2.A.y) / m_recta2) + t2.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta2 = m_recta2*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            else{
                y_recta2 = m_recta2*(x_punto - t2.A.x) + t2.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - t2.A.y) / m_recta2) + t2.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta2 = m_recta2*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        // Para C de this *******---------**********
        x_punto = this.C.x;
        y_punto = this.C.y;
        
        if((t2.B.x <= x_punto && x_punto <= t2.C.x) && y_punto >= t2.C.y){
           
            if(x_punto == t2.A.x){ // Si x_punto está al nivel que A
                if(y_punto == t2.A.y){ // Si x punto está a la altura que A
                    
                   return null;
                }
                else{
                    Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y B
                    double x_recta1 = ( (y_punto - t2.A.y) / m_recta1) + t2.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta1 = m_recta1*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < t2.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - t2.A.x) + t2.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                     Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y B
                    double x_recta1 = ( (y_punto - t2.A.y) / m_recta1) + t2.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta1 = m_recta1*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            else{
                y_recta2 = m_recta2*(x_punto - t2.A.x) + t2.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de t2 para poder obtener A y B
                    double x_recta1 = ( (y_punto - t2.A.y) / m_recta1) + t2.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de this para poder obtener C
                    y_recta1 = m_recta1*(media_base - t2.A.x) + t2.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        
        m_recta1 = (double)(this.A.y - this.B.y) / (this.A.x - this.B.x); // Para la recta de B a A en externo
        m_recta2 = (double)(this.A.y - this.C.y) / (this.A.x - this.C.x); // Para la recta de C a A en externo

        // Comprobando puntos
        
        // Para A de t2 *******---------**********
        x_punto = t2.A.x;
        y_punto = t2.A.y;
        
        if((this.B.x <= x_punto && x_punto <= this.C.x) && y_punto >= this.C.y){
          
            if(x_punto == this.A.x){ // Si x_punto está al nivel que A
                if(y_punto == this.A.y){ // Si x punto está a la altura que A
                    if(t2.C.x > this.C.x && t2.C.y < this.C.y){ // Implica que el triángulo del punto esa más grande que this
                        
                        return new Triangulo("I", this.A, this.B, this.C);
                    }
                    return this;
                }
                else{
                    
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de t2 para poder obtener B
                    double m_recta1_this = (double)(t2.A.y - t2.B.y) / (t2.A.x - t2.B.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    double co = t2.A.y - this.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(t2.A.x-ca), (int)this.B.y);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    double m_recta2_this = (double)(t2.A.y - t2.C.y) / (t2.A.x - t2.C.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(t2.A.x+ca), (int)this.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < this.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - this.A.x) + this.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                    
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de t2 para poder obtener B
                    double m_recta1_this = (double)(t2.A.y - t2.B.y) / (t2.A.x - t2.B.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    double co = t2.A.y - this.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(t2.A.x-ca), (int)this.B.y);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    double m_recta2_this = (double)(t2.A.y - t2.C.y) / (t2.A.x - t2.C.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(t2.A.x+ca), (int)this.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);                  
                }
            }
            else{
                
                y_recta2 = m_recta2*(x_punto - this.A.x) + this.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto A_aux = new Punto("AI", (int) x_punto, (int)y_punto);
                    // Obteniendo la recta uno de t2 para poder obtener B
                    double m_recta1_this = (double)(t2.A.y - t2.B.y) / (t2.A.x - t2.B.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    double co = t2.A.y - this.B.y;
                    double ca = (double) (co /m_recta1_this);
                    
                    Punto B_aux = new Punto("BI", (int)Math.round(t2.A.x-ca), (int)this.B.y);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    double m_recta2_this = (double)(t2.A.y - t2.C.y) / (t2.A.x - t2.C.x); // Para la recta de B a A en t2
                    
                    //Obtniendo a c.o
                    ca = (double) (co /m_recta1_this);
                    Punto C_aux = new Punto("CI", (int) Math.round(t2.A.x+ca), (int)this.B.y);
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        // Para B de t2 *******---------**********
        x_punto = t2.B.x;
        y_punto = t2.B.y;
        if((this.B.x <= x_punto && x_punto <= this.C.x) && y_punto >= this.C.y){
           
            if(x_punto == this.A.x){ // Si x_punto está al nivel que A
                if(y_punto == this.A.y){ // Si x punto está a la altura que A
                    
                   return null;
                }
                else{
                    Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - this.A.y) / m_recta2) + this.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta2 = m_recta2*(media_base - this.A.x) + this.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < this.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - this.A.x) + this.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                     Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - this.A.y) / m_recta2) + this.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta2 = m_recta2*(media_base - this.A.x) + this.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            else{
                y_recta2 = m_recta2*(x_punto - this.A.x) + this.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto B_aux = new Punto("BI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y C
                    double x_recta2 = (double)( (y_punto - this.A.y) / m_recta2) + this.A.x; // En el y punto
                    
                    Punto C_aux = new Punto("CI", (int) Math.round(x_recta2), (int)y_punto);
                    
                    // La media base
                    double media_base = x_punto + (double)((x_recta2 - x_punto)*0.5);
                    
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta2 = m_recta2*(media_base - this.A.x) + this.A.y; // En el y punto
                    
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta2));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        // Para C de t2 *******---------**********
        x_punto = t2.C.x;
        y_punto = t2.C.y;
        
        if((this.B.x <= x_punto && x_punto <= this.C.x) && y_punto >= this.C.y){
           
            if(x_punto == this.A.x){ // Si x_punto está al nivel que A
                if(y_punto == this.A.y){ // Si x punto está a la altura que A
                    
                   return null;
                }
                else{
                    Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y B
                    double x_recta1 = ( (y_punto - this.A.y) / m_recta1) + this.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta1 = m_recta1*(media_base - this.A.x) + this.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            if(x_punto < this.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - this.A.x) + this.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                     Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y B
                    double x_recta1 = ( (y_punto - this.A.y) / m_recta1) + this.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta1 = m_recta1*(media_base - this.A.x) + this.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
            else{
                y_recta2 = m_recta2*(x_punto - this.A.x) + this.A.y;
                if(y_punto <= y_recta2){ // Si x punto está debajo de la altura de A
                    Punto C_aux = new Punto("CI", (int) x_punto, (int)y_punto);
                    
                // Obteniendo la x de la recta dos de this para poder obtener A y B
                    double x_recta1 = ( (y_punto - this.A.y) / m_recta1) + this.A.x; //En el y punto
                    
                    Punto B_aux = new Punto("BI", (int) Math.round(x_recta1), (int) y_punto);
                    
                    // La media base
                    double media_base = x_punto - (double)((x_punto-x_recta1)*0.5);
                    // Obteniendo la recta uno de t2 para poder obtener C
                    y_recta1 = m_recta1*(media_base - this.A.x) + this.A.y; // En el y punto
                    Punto A_aux = new Punto("AI", (int) Math.round(media_base), (int)Math.round(y_recta1));
                    
                    return new Triangulo("I", A_aux, B_aux, C_aux);
                }
            }
        }
        
        
        //y_recta1 = m_recta1*(x_punto - this.A.x) + this.A.y;
        //y_recta2 = m_recta2*(x_punto - this.A.x) + this.A.y;
        //y_recta3 = m_recta3*(x_punto - t2.A.x) + t2.A.y;
        
        // x_recta1 = ( (y_recta1 - this.A.y) / m_recta1) + this.A.x;
        // x_recta2 = ( (y_recta2 - this.A.y) / m_recta2) + this.A.x;
        return null;
    }
    
    public boolean estaAdentro(Punto A){
          // Identificicamos si hay algún punto que esté dentro del triángulo o viceversa
        double m_recta1;
        double m_recta2;
        
        double y_recta1; // a izquierda
        double y_recta2; // a derecha
        
        double x_punto;
        double y_punto;
        
        // Primero vemos si el otro triángulo tiene puntos dentro de este
        m_recta1 = (this.A.y - this.B.y) / (this.A.x - this.B.x); // Para la recta de B a A en externo
        m_recta2 = (this.A.y - this.C.y) / (this.A.x - this.C.x); // Para la recta de C a A en externo

        // Comprobando puntos
        

        // Para A de this ******---------*********
        x_punto = A.x;
        y_punto = A.y;
        
        if((this.B.x <= x_punto && x_punto <= this.C.x) && y_punto >= this.C.y){
            if(x_punto == this.A.x){ // Si x_punto está al nivel que A
                if(y_punto == this.A.y){ // Si x punto está a la altura que A
                    return true;
                }
            }
            if(x_punto < this.A.x){ // Si x_punto está antes que A
                y_recta1 = m_recta1*(x_punto - this.A.x) + this.A.y;
                
                if(y_punto <= y_recta1){ // Si x punto está debajo de la recta antes de A
                    return true;                    
                }
                else{
                    return false;
                }
            }
            else{
                y_recta2 = m_recta2*(x_punto - this.A.x) + this.A.y;
                
                if(y_punto <= y_recta2){ // Si x punto está debajo de la recta después de A
                    return true;                    
                }
                else{
                    return false;
                }
            }
        }
        else
            return false;
        
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
    
    public void moverTri(Punto a, Punto b, Punto c){
        A = a;
        B = b;
        C = c;
    }
    
    public int cuadTri(){
        Punto aux = new Punto(A.x, A.y);
        
        return aux.cuadrante();
    }
}