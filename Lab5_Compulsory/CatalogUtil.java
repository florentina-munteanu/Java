package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.sql.Types.NULL;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            ((ObjectOutputStream) oos).writeObject(catalog);
        }
    }

    /*https://www.geeksforgeeks.org/classloader-in-java/*/
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {

        if (path.endsWith(".ser") == false) {
            throw new InvalidCatalogException(new Exception());
        }

        Path cale = Paths.get(path);

        FileInputStream in = null;
        /*“Catching” I/O Exceptions - curs*/
        try {
            in = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream obj = new ObjectInputStream(in);
        /*Reading a File - curs*/
        Catalog c = (Catalog) obj.readObject();

        obj.close();

        return c;
    }

    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        /*Desktop.getDesktop().open(doc);*/
        URI uri = new URI(doc.getLocation());
        desktop.browse(uri);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}