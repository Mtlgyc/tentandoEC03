import java.util.Date;  

public class UsuarioAluno extends Usuario {  
    private Date dataLimite;  

    public UsuarioAluno(String nome, Date dataLimite) {  
        super(nome);  
        this.dataLimite = dataLimite;  
    }  

    public void renovaCartao(Date data) {  
        this.dataLimite = data;  
    }  

    public boolean isRegular() {  
        Date hoje = new Date();  
        return dataLimite.after(hoje);  
    }  

    public int getCotaMaxima() {  
        return isRegular() ? 3 : super.getCotaMaxima();  
    }  

    public int getPrazoMaximo() {  
        return isRegular() ? 7 : super.getPrazoMaximo();  
    }  

    public String toString() {  
        return "Aluno " + getNome();  
    }  
}