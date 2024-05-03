package Model;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int id_eq; 
    private ArrayList<Employe> tab_emp; 
    public Equipe(int id_eq, ArrayList<Employe> tab_emp) {
        this.id_eq = id_eq;
        this.tab_emp = tab_emp;
    }
    public int getIdEquipe() {
        return id_eq;
    }
    public void setIdEquipe(int id_eq) {
        this.id_eq = id_eq;
    }
    public List<Employe> getMembresEquipe() {
        return tab_emp;
    }
    public void setMembresEquipe(ArrayList<Employe> tab_emp) {
        this.tab_emp = tab_emp;
    }
        public void addMembresEquipe(Employe emp) {
        this.tab_emp.add(emp);
    }
        
        
    public ArrayList<Employe> getMembresEquipeBD(){
    employeBD employeIns= new employeBD();
     ArrayList<Employe> employeBD= (ArrayList<Employe>) employeIns.getListeEmployesDepuisBase();
    for( Employe emp: employeBD){
        if (this.id_eq==emp.getIdEquipe()){
    this.addMembresEquipe(emp);
}

    }        return this.tab_emp;

    }

    @Override
    public String toString() {
        return "Equipe [id_eq=" + id_eq + ", tab_emp=" + tab_emp + "]";
    }
}



