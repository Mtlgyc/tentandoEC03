public class Periodico extends Livro {  
    public Periodico(String titulo) {  
        super(titulo);  
    }  

    @Override  
    public boolean empresta(Usuario u, int prazo) {  
        if (u.isProfessor()) {  
            return super.empresta(u, 7); // Prazo fixo de 7 dias para periódicos  
        }  
        return false;  
    }  
}