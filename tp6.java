package tp6;

public class Documents {
    protected String titre;
   protected String id;
    protected int nbpg;

    public Documents(String titre, String id, int nbpg) {
        this.titre = titre;
        this.id = id;
        this.nbpg = nbpg;
    }

    
    public String getTitre() {
        return this.titre;}

    public String getId() {
        return this.id;
    
    
    }

    public int getNbpg() {
        return this.nbpg;     }

    public void edition() {
        System.out.println("Le titre:" + titre +", ID:" + id +", Nombre de page:" + nbpg);
    }
}

public class Article extends Documents {
    private String nomAut;

    public Article(String titre, String id, int nbpg, String nomAut) {
        super(titre, id, nbpg);
        this.nomAut = nomAut;
    }
}

public class Livre extends Article {
    private String nomEdit;

    public Livre(String titre, String id, int nbpg, String nomAut, String nomEdit) {
        super(titre, id, nbpg, nomAut);
        this.nomEdit = nomEdit;
    }
}

public class Periodiques extends Documents {
    private int freq;

    public Periodiques(String titre, String id, int nbpg, int freq) {
        super(titre, id, nbpg);
        this.freq = freq;
    }

    public void edition() {
        super.edition();
        System.out.println("Fréquence: " + freq);
    }
}

public class Bibliotheque {
    private Documents[] listeDoc;
    private int nbDoc;
    private int capacite;

    public Bibliotheque(int capacite) {
        this.nbDoc = 0;
        this.capacite = capacite;
        this.listeDoc = new Documents[capacite];
    }

    public int getCapacite() {
        return this.capacite;
    }

    public int getNombreDocument() {
        return this.nbDoc;
    }

    public void ajoutDoc(Documents d) {
        if (nbDoc < capacite) {
            listeDoc[nbDoc] = d;
            nbDoc++;
            trier();
        }
    }

    public void supprimDoc(String id) {
        for (int i = 0; i < nbDoc; i++) {
            if (listeDoc[i].getId().equals(id)) {
                for (int j = i; j < nbDoc -1; j++) {
                    listeDoc[j] = listeDoc[j + 1];
                }
                nbDoc--;
               
            }
        }
    }

    public void setInventaireDoc() {
        for (int i = 0; i < nbDoc; i++) {
            listeDoc[i].edition();
        }
    }

    public Bibliotheque listeLivres() {
        Bibliotheque tab1 = new Bibliotheque(50);
        for (int i = 0; i < nbDoc; i++) {
            if (listeDoc[i] instanceof Livre) {
                tab1.ajoutDoc(listeDoc[i]);
            }
        }
        return tab1;
    }

    public Bibliotheque listePeriodiques() {
        Bibliotheque tab1 = new Bibliotheque(30);
        for (int i = 0; i < nbDoc; i++) {
            if (listeDoc[i] instanceof Periodiques) {
                tab1.ajoutDoc(listeDoc[i]);
            }
        }
        return tab1;
    }

    public Bibliotheque listeArticles() {
        Bibliotheque tab1 = new Bibliotheque(40);
        for (int i = 0; i < nbDoc; i++) {
            if (listeDoc[i] instanceof Article) {
                tab1.ajoutDoc(listeDoc[i]);
            }
        }
        return tab1;
    }

    public void trier() {
		Documents aux;
		ok=true;
		while(ok==true) {
			for(int i=0;i<nb_doc;i++)
			{
				if(tab[i].getnumid>tab[i+1].getnumid())
				aux=tab[i];
				tab[i]=tab[i+1]
				tab[i+1]=aux;
			}
		}
	}


public class Main {
    public static void main(String[] args) {        
    	Bibliotheque bibliotheque = new Bibliotheque(200);
        Documents doc1 = new Documents("Document 1", "Id100", 80);
        Article article1 = new Article("Article 1", "Id200", 40, "Auteur 1");
        Livre livre1 = new Livre("Livre 1", "Id300", 100, "Auteur 2", "Editeur 1");
        Periodiques periodique1 = new Periodiques("Periodique 1", "Id400", 50, 8);
        bibliotheque.ajoutDoc(doc1);
        bibliotheque.ajoutDoc(article1);
        bibliotheque.ajoutDoc(livre1);
        bibliotheque.ajoutDoc(periodique1);
        bibliotheque.setInventaireDoc();
        bibliotheque.supprimDoc("Id200");
        bibliotheque.setInventaireDoc();
        Bibliotheque livres = bibliotheque.listeLivres();
        livres.setInventaireDoc();
        Bibliotheque periodiques = bibliotheque.listePeriodiques();
        periodiques.setInventaireDoc();
    }
}
