import java.util.ArrayList;  

public class Usuario {  
    private String nome;  
    private ArrayList<Livro> livrosRetirados;  

    public Usuario(String nome) {  
        this.nome = nome;  
        this.livrosRetirados = new ArrayList<Livro>();  
    }  

    public boolean retiraLivro(Livro item) {  
        if (this.isAptoARetirar()) {  
            if (item.empresta(this, getPrazoMaximo())) {  
                this.livrosRetirados.add(item);  
                return true;  
            }  
        }  
        return false;  
    }  

    public boolean devolveLivro(Livro item) {  
        if (item.retorna(this)) {  
            this.livrosRetirados.remove(item);  
            return true;  
        }  
        return false;  
    }  

    public boolean isAptoARetirar() {  
        return !isADevolver();  
    }  

    public boolean isADevolver() {  
        return (this.livrosRetirados.size() >= this.getCotaMaxima() || this.temPrazoVencido());  
    }  

    public int getCotaMaxima() {  
        return 2; // Limite padrão para usuário externo  
    }  

    public int getPrazoMaximo() {  
        return 4; // Prazo padrão para usuário externo  
    }  

    public boolean temPrazoVencido() {  
        for (Livro livro : this.livrosRetirados) {  
            if (livro.isEmAtraso()) {  
                return true;  
            }  
        }  
        return false;  
    }  

    public String getNome() {  
        return this.nome;  
    }  

    public String toString() {  
        return "Usuario " + nome;  
    }

	public boolean isProfessor() {
		// TODO Auto-generated method stub
		return false;
	}  
}