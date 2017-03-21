package C3D;

public class NodoC3D {
    private String cad;    
    private int dim;
    private String id;

    public NodoC3D(String cad,String id,int dim) {
        this.cad = cad;
        this.id=id;
        this.dim=dim;
    }     
    public String getCad(){
        return cad;
    } 
    public void aumentarDim(){
        this.dim++;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
        
        
}
