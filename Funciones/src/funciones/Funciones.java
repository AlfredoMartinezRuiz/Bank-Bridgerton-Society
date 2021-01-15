package funciones;
/**
 * Mónica Castañeda García
 */
public class Funciones {
    
    static float fdxa(float x, float y){
        return x/(y+1);
    }
    static float fdxb(float x, float y){
        return (x+y)/(x-y);
    }
    static float fdxc(float x, float y, float z){
        return x+(y/z);
    }
    static float fdxd(float b, float c, float d){
        return b/(c+d);
    }
    static float fdxe(float a, float b, float c, float d){
        return (a+b)*(c/d);
    }
    static float fdxf(float a, float b){
        return (float) Math.pow(Math.pow((a+b),3),2);
    }
    static float fdxg(float x, float y){
        return (x*y)/(1-4*x);
    }
    static float fdxh(float x, float y, float m, float n){
        return (x*y)/(m*n);
    } 
    static float fdxi(float x, float y, float a, float b){
        return (float) (Math.pow((x+y),2)*(a-b));
    }
    static float fdxj(float x, float y, float z){
        return x-(y/z);
    }
    
    public static void main(String[] args) {
        float x=1, y=2, a=3, b=4, c=5, d=6, m=7, n=8, z=9;
        
        System.out.println("Funciones:");
        System.out.println("a) " + fdxa(x,y));
        System.out.println("b) " + fdxb(x,y));
        System.out.println("c) " + fdxc(x,y,z));
        System.out.println("d) " + fdxd(b,c,d));
        System.out.println("e) " + fdxe(a,b,c,d));
        System.out.println("f) " + fdxf(a,b));
        System.out.println("g) " + fdxg(x,y));
        System.out.println("h) " + fdxh(x,y,m,n));
        System.out.println("i) " + fdxi(x,y,a,b));
        System.out.println("j) " + fdxj(x,y,z));
    }
}
