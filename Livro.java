import java.util.Calendar;  
import java.util.Date;  
import java.util.GregorianCalendar;  

public class Livro extends Item {  
    private Usuario retiradoPor;  
    private Date dtEmprestimo;  
    private Date dtDevolucao;  
    private Usuario bloqueadoPor;  
    private Date dtBloqueio;  
    private Date dtDesbloqueio;  

    public Livro(String titulo) {  
        super(titulo);  
    }  

    public boolean isDisponivel() {  
        Date hoje = new Date();  
        return this.retiradoPor == null && (this.bloqueadoPor == null || this.dtDesbloqueio.before(hoje));  
    }  

    public boolean isEmprestado() {  
        return !(this.retiradoPor == null);  
    }  

    public boolean isBloqueado() {  
        Date hoje = new Date();  
        return this.retiradoPor == null && !(this.bloqueadoPor == null) && !(this.dtDesbloqueio.before(hoje));  
    }  

    public boolean bloqueia(Usuario u, int prazo) {  
        GregorianCalendar cal = new GregorianCalendar();  
        if (this.isDisponivel() && u.isProfessor()) {  
            this.bloqueadoPor = u;  
            this.dtBloqueio = cal.getTime();  
            cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));  
            this.dtDesbloqueio = cal.getTime();  
            return true;  
        }  
        return false;  
    }  

    public boolean desbloqueia(Usuario u) {  
        if (u == this.bloqueadoPor) {  
            this.bloqueadoPor = null;  
            return true;  
        }  
        return false;  
    }  

    public boolean empresta(Usuario u, int prazo) {  
        GregorianCalendar cal = new GregorianCalendar();  
        if (this.isDisponivel()) {  
            this.retiradoPor = u;  
            this.dtEmprestimo = cal.getTime();  
            cal.add(Calendar.DATE, prazo);  
            this.dtDevolucao = cal.getTime();  
            return true;  
        }  
        return false;  
    }  

    public boolean retorna(Usuario u) {  
        if (u == this.retiradoPor) {  
            this.retiradoPor = null;  
            return true;  
        }  
        return false;  
    }  

    public boolean isEmAtraso() {  
        Date hoje = new Date();  
        return isEmprestado() && dtDevolucao.before(hoje);  
    }  

    public String toString() {  
        if (this.isDisponivel()) {  
            return this.titulo + " disponível";  
        }  
        if (this.isEmprestado()) {  
            return this.titulo + " retirado por " + this.retiradoPor + " até " + dma(this.dtDevolucao);  
        }  
        return this.titulo + " bloqueado por " + this.bloqueadoPor + " até " + dma(this.dtDesbloqueio);  
    }  

    private String dma(Date dt) {  
        GregorianCalendar cal = new GregorianCalendar();  
        cal.setTime(dt);  
        return cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);  
    }  
}