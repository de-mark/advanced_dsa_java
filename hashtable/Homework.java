package hashtable;

public class Homework {
    public static void main(String[] args) {
        Book linuxBible = new Book(50, "Linux Bible", "Christopher Negus", "Linux");
        Book linuxEmbedded = new Book(40, "Embedded Linux Primer", "Christopher Hallinan", "Linux");
        Book atmosScience = new Book(70, "Principles pf Atmospheric Science", "John E. Frederick", "Environment");
        Book envScience = new Book(35, "Environmental Science", "G. Tyler Miller", "Environment");
        Book astroPhys = new Book(45, "Fundamentals of Astrodynamics", "Roger R. Bate", "Astrophysics");
        Book rocketScience = new Book(90, "It's ONLY Rocket Science", "Lucy Rogers", "Astrophysics");
        Book electronicsForBeginners = new Book(43, "Electronics for Beginners", "Jonathan Bartlett", "Electronics");
        Book practicalElectronics = new Book(44, "Practical Electronics for Inventors", "Paul Scherz", "Electronics");
        Book machineLearningSysDes = new Book(103, "Machine Learning System Design Interview", "Ali Aminian",
                "Machine Learning");
        Book naturalLanguage = new Book(150, "Introduction to Natural Language Processing", "Jacob Eisenstein",
                "Machine Learning");
        Book hamRadio = new Book(900, "Ham Radio: License Manual", "ARRL", "Radio");

        Book deleteMe = new Book(999, "THIS BOOK IS JUST HERE TO BE DELETED", "DELETE ME", "DELETE");

        // BST tree = new BST();
        // tree.insert(linuxBible);
        // tree.insert(linuxEmbedded);
        // tree.insert(atmosScience);
        // tree.insert(envScience);
        // tree.insert(astroPhys);
        // tree.insert(rocketScience);
        // tree.insert(electronicsForBeginners);
        // tree.insert(practicalElectronics);
        // tree.insert(machineLearningSysDes);
        // tree.insert(naturalLanguage);
        // tree.inorder();
        HashTable hash = new HashTable(7);
        hash.insert(linuxBible);
        hash.insert(linuxEmbedded);
        hash.insert(atmosScience);
        hash.insert(envScience);
        hash.insert(astroPhys);
        hash.insert(rocketScience);
        hash.insert(electronicsForBeginners);
        hash.insert(practicalElectronics);
        hash.insert(machineLearningSysDes);
        hash.insert(naturalLanguage);
        hash.insert(deleteMe);
        System.out.println("=====================================================");
        System.out.println("FIRST PASS: ALL BOOKS INSERTED TO THE HASHTABLE");
        System.out.println("=====================================================\n\n");
        hash.display();
        System.out.println("\n\n\n=====================================================");
        System.out.println("DELETING DELETE ME BOOK");
        System.out.println("=====================================================\n\n");
        hash.delete(deleteMe.getId());
        hash.display();
        System.out.println("\n\n\n=====================================================");
        System.out.println("SEARCHING FOR LINUX BIBLE TO MAKE SURE FIND FN WORKS");
        System.out.println("=====================================================\n\n");
        hash.find(linuxBible.getId()).display();
        System.out.println("\n\n\n=====================================================");
        System.out.println("INSERTING HAM RADIO BOOK");
        System.out.println("=====================================================\n\n");
        hash.insert(hamRadio);
        hash.display();
        System.out.println("\n\n\n");
        System.out.println("=====================================================\n\n");

    }
}
