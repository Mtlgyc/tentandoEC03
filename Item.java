public abstract class Item {  
    protected String titulo;  

    public Item(String titulo) {  
        this.titulo = titulo;  
    }  

    public String getTitulo() {  
        return titulo;  
    }  

    public abstract boolean empresta(Usuario u, int prazo);  
    public abstract boolean retorna(Usuario u);  
}