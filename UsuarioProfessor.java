public class UsuarioProfessor extends Usuario {  
    public UsuarioProfessor(String nome) {  
        super(nome);  
    }  

    public boolean bloqueiaLivro(Livro item, int prazo) {  
        return item.bloqueia(this, prazo);  
    }  

    public boolean desbloqueiaLivro(Livro item) {  
        return item.desbloqueia(this);  
    }  

    public int getCotaMaxima() {  
        return 5;  
    }  

    public int getPrazoMaximo() {  
        return 14;  
    }  

    public boolean isProfessor() {  
        return true;  
    }  

    public String toString() {  
        return "Prof. " + super.getNome();  
    }  
}