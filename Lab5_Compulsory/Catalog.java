package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /*constructor*/
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    /*The "classical" way - curs*/
    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
}
