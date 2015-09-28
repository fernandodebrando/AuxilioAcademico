package Model;
 
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name = "cursoService")
@ApplicationScoped
public class CursoService {
     
    public TreeNode createCursos() {
        TreeNode root = new DefaultTreeNode(new Curso("Files", "-", "Folder"), null);
         
        TreeNode documents = new DefaultTreeNode(new Curso("Documents", "-", "Folder"), root);
        TreeNode pictures = new DefaultTreeNode(new Curso("Pictures", "-", "Folder"), root);
        TreeNode movies = new DefaultTreeNode(new Curso("Movies", "-", "Folder"), root);
         
        TreeNode work = new DefaultTreeNode(new Curso("Work", "-", "Folder"), documents);
        TreeNode primefaces = new DefaultTreeNode(new Curso("PrimeFaces", "-", "Folder"), documents);
         
        //Documents
        TreeNode expenses = new DefaultTreeNode("document", new Curso("Expenses.doc", "30 KB", "Word Document"), work);
        TreeNode resume = new DefaultTreeNode("document", new Curso("Resume.doc", "10 KB", "Word Document"), work);
        TreeNode refdoc = new DefaultTreeNode("document", new Curso("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
         
        //Pictures
        TreeNode barca = new DefaultTreeNode("picture", new Curso("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
        TreeNode primelogo = new DefaultTreeNode("picture", new Curso("logo.jpg", "45 KB", "JPEG Image"), pictures);
        TreeNode optimus = new DefaultTreeNode("picture", new Curso("optimusprime.png", "96 KB", "PNG Image"), pictures);
         
        //Movies
        TreeNode pacino = new DefaultTreeNode(new Curso("Al Pacino", "-", "Folder"), movies);
        TreeNode deniro = new DefaultTreeNode(new Curso("Robert De Niro", "-", "Folder"), movies);
         
        TreeNode scarface = new DefaultTreeNode("mp3", new Curso("Scarface", "15 GB", "Movie File"), pacino);
        TreeNode carlitosWay = new DefaultTreeNode("mp3", new Curso("Carlitos' Way", "24 GB", "Movie File"), pacino);
         
        TreeNode goodfellas = new DefaultTreeNode("mp3", new Curso("Goodfellas", "23 GB", "Movie File"), deniro);
        TreeNode untouchables = new DefaultTreeNode("mp3", new Curso("Untouchables", "17 GB", "Movie File"), deniro);
         
        return root;
    }
}